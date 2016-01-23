package edu.kit.ipd.crowdcontrol.objectservice.crowdworking;

import edu.kit.ipd.crowdcontrol.objectservice.database.model.enums.TaskStatus;
import edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.records.PlatformRecord;
import edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.records.TaskRecord;
import edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.records.WorkerRecord;
import edu.kit.ipd.crowdcontrol.objectservice.database.operations.PlatformOperations;
import edu.kit.ipd.crowdcontrol.objectservice.database.operations.TasksOperations;
import edu.kit.ipd.crowdcontrol.objectservice.database.operations.WorkerOperations;
import edu.kit.ipd.crowdcontrol.objectservice.proto.Experiment;
import edu.kit.ipd.crowdcontrol.objectservice.rest.exceptions.BadRequestException;
import org.jooq.DSLContext;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * This class handles managing of the platforms.
 * Created by marcel on 19.01.16.
 */
public class PlatformManager {
    private final Map<String, Platform> platforms;
    private final Worker fallbackWorker;
    private final Payment fallbackPayment;
    private TasksOperations tasksOps;
    private WorkerOperations workerOps;

    /**
     * Create a new manager for platforms. The known platforms in the database will be deleted,
     * and filled with the new.
     *
     * @param crowdPlatforms The list of crowdplatforms to be managed by this manager,
     *                       will be used to setup the list of platforms in the database
     * @param fallbackWorker handler which is called if a platform does not support identifying a worker
     *                       for this case need_email on the platform is set and the email which got entered by the worker
     *                       should be set as some param
     * @param fallbackPayment handler which is called if a platform does not support payment
     * @param tasksOps Used for the task operations on the database
     * @param platformOps Used for the platform operations on the database
     * @param workerOps Used for the worker operations on the database
     */
    public PlatformManager(List<Platform> crowdPlatforms, Worker fallbackWorker,
                           Payment fallbackPayment, TasksOperations tasksOps,
                           PlatformOperations platformOps, WorkerOperations workerOps) {
        this.tasksOps = tasksOps;
        this.workerOps = workerOps;
        this.fallbackWorker = fallbackWorker;
        this.fallbackPayment = fallbackPayment;

        //create hashmap of platforms
        platforms = crowdPlatforms.stream()
                .collect(Collectors.toMap(Platform::getName, Function.identity()));
        //clear database
        platformOps.deleteAllPlatforms();
        //update database
        platforms.forEach((s, platform) -> {
            PlatformRecord rec = new PlatformRecord();
            rec.setName(platform.getName());
            rec.setNeedsEmail(false);

            /* platform does not handle payment, email is needed for internal payment */
            if (!platform.getPayment().isPresent())
                rec.setNeedsEmail(true);
            /* if platform cannot identify worker, we need to do that with a email adress */
            if (!platform.getWorker().isPresent())
                rec.setNeedsEmail(true);

            rec.setRenderCalibrations(platform.isCalibsAllowd());

            platformOps.createPlatform(rec);
        });
    }

    /**
     * Will get you the instance of a platform interface of a platform, this instance is the same for all calls
     * @param name The name of the instance to use
     * @return The optional crowd platform instance
     */
    public Optional<Platform> getPlatform(String name) {
        return Optional.ofNullable(platforms.get(name));
    }

    /**
     * Will return the Worker interface which should be used to identify workers for the given platform
     *
     * @param name The name of the platform
     * @return The interface used to identify a worker
     */
    public Optional<Worker> getWorker(String name) {
        return getPlatform(name).map(platform -> platform.getWorker().orElse(fallbackWorker));
    }

    /**
     * Will return the payment service which should be used for the given platform
     * If there is no Platform with the given name None is returned.
     *
     * @param name The name of the platform to use
     * @return The interface used for payment
     */
    public Optional<Payment> getPlatformPayment(String name) {
        return getPlatform(name).map(platform -> platform.getPayment().orElse(fallbackPayment));
    }

    /**
     * Publish the given experiment on the platform.
     * The method will update the database with the new public task
     *
     * @param name The name of the platform
     * @param experiment The experiment to publish
     * @return None if the platform does not exist
     */
    public Optional<CompletableFuture<Boolean>> publishTask(String name, Experiment experiment) throws TaskOperationException {
        if (tasksOps.searchTask(name,experiment.getId()).isPresent())
            throw new TaskOperationException("Experiment is already published!");
        return getPlatform(name).
                map(platform1 -> platform1.publishTask(experiment)).
                map(stringCompletableFuture -> stringCompletableFuture.handle((s, throwable) -> {
                    if (s != null && throwable == null) {
                        TaskRecord record = new TaskRecord();
                        record.setExperiment(experiment.getId());
                        record.setPlatformData(s);
                        record.setStatus(TaskStatus.running);
                        record.setCrowdPlatform(name);
                        tasksOps.createTask(record);
                    }
                    return true;
                }));
    }

    /**
     * Unpublish a given experiment from the given platform
     *
     * @param name The name of the platform
     * @param experiment The experiment to unpublish
     * @return None if the platform was not found, false if the unpublish failed and true if everything went fine
     */
    public Optional<CompletableFuture<Boolean>> unpublishTask(String name, Experiment experiment) throws TaskOperationException {
        TaskRecord record;

        record = tasksOps.searchTask(name, experiment.getId()).
                orElseThrow(() -> new TaskOperationException("Experiment is not published"));

        return getPlatform(name).map(platform1 ->
            platform1.unpublishTask(record.getPlatformData()).handle((b, throwable) -> {
                if (b != null && throwable == null) {
                    record.setStatus(TaskStatus.finished);
                    tasksOps.updateTask(record);
                }
                return true;
            })
        );
    }

    /**
     * update the given experiment on the given platform
     * @param name The name of the platform
     * @param experiment The experiment to update
     * @return None if the platform was not found, false if the update failed and true if everything went fine.
     */
    public Optional<CompletableFuture<Boolean>> updateTask(String name, Experiment experiment) throws TaskOperationException {
        TaskRecord record;

        record = tasksOps.searchTask(name, experiment.getId()).
                orElseThrow(() -> new TaskOperationException("Experiment is not published"));

        return getPlatform(name).
                map(platform -> platform.updateTask(record.getPlatformData(), experiment)).
                map(stringCompletableFuture -> {
                    CompletableFuture<Boolean> result = new CompletableFuture<Boolean>();
                    stringCompletableFuture.whenComplete((s, throwable) -> {
                        if (s != null && throwable == null) {
                            record.setPlatformData(s);
                            tasksOps.updateTask(record);
                        }
                        result.complete(true);
                    });
                    return result;
        });
    }

    /**
     * Parse a worker id out of the params which got passed by a platform
     * @param name The name of the platform
     * @param params Params passed by the platform
     * @return A String if the platform exists
     */
    public Optional<String> identifyWorker(String name, Map<String, String[]> params) {
        return getWorker(name).flatMap(worker -> worker.identifyWorker(params));
    }

    /**
     * Get a worker record from the database which is associated with the given parameters
     * @param name Name of the platform
     * @param params Params which were passed by the platform to the workerservice
     * @return A WorkerRecord if one is found
     */
    public Optional<WorkerRecord> getWorker(String name, Map<String, String[]> params) {
        return identifyWorker(name, params).map(uid ->
            workerOps.getAllWorkers().stream().
                    filter(workerRecord1 -> workerRecord1.getIdentification().equals(uid)).findFirst().
                    orElseGet(() -> {
                        //create a new entry in the database
                        WorkerRecord record = new WorkerRecord(-1, uid, name, null);
                        record = workerOps.createWorker(record);
                        return record;
                    })
        );
    }

    public Optional<CompletableFuture<Boolean>> payWorker(String name, Worker worker, int amount) {
        return getPlatformPayment(name).map(payment -> payment.payWorker(worker, amount));
    }
}
