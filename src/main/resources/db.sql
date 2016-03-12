-- MySQL Script generated by MySQL Workbench
-- Sat Mar 12 17:23:09 2016
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema crowdcontrol
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema crowdcontrol
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `crowdcontrol` DEFAULT CHARACTER SET utf8mb4 ;
USE `crowdcontrol` ;

-- -----------------------------------------------------
-- Table `crowdcontrol`.`Algorithm_Task_Chooser`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Algorithm_Task_Chooser` (
  `id_task_chooser` VARCHAR(191) NOT NULL,
  `description` TEXT NOT NULL,
  PRIMARY KEY (`id_task_chooser`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Template`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Template` (
  `id_template` INT(11) NOT NULL AUTO_INCREMENT,
  `template` LONGTEXT NOT NULL,
  `title` VARCHAR(191) NOT NULL,
  `answer_type` VARCHAR(191) NULL DEFAULT NULL,
  PRIMARY KEY (`id_template`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Algorithm_Answer_Quality`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Algorithm_Answer_Quality` (
  `id_Algorithm_Answer_Quality` VARCHAR(191) NOT NULL,
  `description` TEXT NOT NULL,
  PRIMARY KEY (`id_Algorithm_Answer_Quality`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Algorithm_Rating_Quality`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Algorithm_Rating_Quality` (
  `id_Algorithm_Rating_Quality` VARCHAR(191) NOT NULL,
  `description` TEXT NOT NULL,
  PRIMARY KEY (`id_Algorithm_Rating_Quality`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Experiment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Experiment` (
  `id_experiment` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(191) NULL DEFAULT NULL,
  `description` LONGTEXT NULL DEFAULT NULL,
  `description_raw` LONGTEXT NULL DEFAULT NULL,
  `needed_answers` INT NULL DEFAULT NULL,
  `ratings_per_answer` INT(11) NULL DEFAULT NULL,
  `anwers_per_worker` INT NULL DEFAULT NULL,
  `ratings_per_worker` INT NULL DEFAULT NULL,
  `answer_type` VARCHAR(191) NULL DEFAULT NULL,
  `algorithm_task_chooser` VARCHAR(191) NULL DEFAULT NULL,
  `algorithm_quality_answer` VARCHAR(191) NULL DEFAULT NULL,
  `algorithm_quality_rating` VARCHAR(191) NULL DEFAULT NULL,
  `base_payment` INT(11) NULL DEFAULT NULL,
  `bonus_answer` INT(11) NULL DEFAULT NULL,
  `bonus_rating` INT(11) NULL DEFAULT NULL,
  `template_data` MEDIUMTEXT NULL DEFAULT NULL,
  `template` INT(11) NULL DEFAULT NULL,
  `worker_quality_threshold` INT NULL DEFAULT NULL,
  `result_quality_threshold` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id_experiment`),
  INDEX `usedTemplate_idx` (`template` ASC),
  INDEX `usedTaskChooser_idx` (`algorithm_task_chooser` ASC),
  INDEX `usedRatingQuality_idx` (`algorithm_quality_rating` ASC),
  INDEX `usedAnswerQuality_idx` (`algorithm_quality_answer` ASC),
  CONSTRAINT `usedTaskChooser`
    FOREIGN KEY (`algorithm_task_chooser`)
    REFERENCES `crowdcontrol`.`Algorithm_Task_Chooser` (`id_task_chooser`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `usedTemplate`
    FOREIGN KEY (`template`)
    REFERENCES `crowdcontrol`.`Template` (`id_template`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `usedAnswerQuality`
    FOREIGN KEY (`algorithm_quality_answer`)
    REFERENCES `crowdcontrol`.`Algorithm_Answer_Quality` (`id_Algorithm_Answer_Quality`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `usedRatingQuality`
    FOREIGN KEY (`algorithm_quality_rating`)
    REFERENCES `crowdcontrol`.`Algorithm_Rating_Quality` (`id_Algorithm_Rating_Quality`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Platform`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Platform` (
  `id_platform` VARCHAR(191) NOT NULL,
  `name` VARCHAR(191) NOT NULL,
  `render_calibrations` BIT(1) NOT NULL,
  `needs_email` BIT(1) NOT NULL,
  `inactive` BIT(1) NOT NULL,
  `currency` INT NULL,
  PRIMARY KEY (`id_platform`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Worker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Worker` (
  `id_worker` INT(11) NOT NULL AUTO_INCREMENT,
  `platform_data` JSON NULL DEFAULT NULL,
  `platform` VARCHAR(191) NOT NULL,
  `email` VARCHAR(191) NULL DEFAULT NULL,
  `quality` INT NOT NULL DEFAULT 9,
  `identification` VARCHAR(191) GENERATED ALWAYS AS (JSON_EXTRACT(platform_data, '$.identification')),
  PRIMARY KEY (`id_worker`),
  INDEX `workerOrigin_idx` (`platform` ASC),
  CONSTRAINT `workerOrigin`
    FOREIGN KEY (`platform`)
    REFERENCES `crowdcontrol`.`Platform` (`id_platform`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Answer_Reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Answer_Reservation` (
  `idAnswer_Reservation` INT NOT NULL AUTO_INCREMENT,
  `worker` INT NOT NULL,
  `experiment` INT NOT NULL,
  `timestamp` TIMESTAMP NOT NULL,
  `used` BIT(1) NOT NULL,
  PRIMARY KEY (`idAnswer_Reservation`),
  INDEX `experiment_will_be_answered_idx` (`experiment` ASC),
  INDEX `worker_wil_answer_idx` (`worker` ASC),
  CONSTRAINT `experiment_will_be_answered`
    FOREIGN KEY (`experiment`)
    REFERENCES `crowdcontrol`.`Experiment` (`id_experiment`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `worker_wil_answer`
    FOREIGN KEY (`worker`)
    REFERENCES `crowdcontrol`.`Worker` (`id_worker`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Answer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Answer` (
  `id_answer` INT(11) NOT NULL AUTO_INCREMENT,
  `experiment` INT(11) NOT NULL,
  `answer` MEDIUMTEXT NOT NULL,
  `timestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `worker_id` INT(11) NOT NULL,
  `reservation` INT NOT NULL,
  `quality` INT(11) NULL DEFAULT NULL,
  `quality_assured` BIT(1) NULL,
  `system_response` VARCHAR(191) NULL,
  `hash` BIGINT NULL,
  PRIMARY KEY (`id_answer`),
  INDEX `workerAnswered_idx` (`worker_id` ASC),
  INDEX `idExperimentAnswers_idx` (`experiment` ASC),
  INDEX `reservation_answer_idx` (`reservation` ASC),
  CONSTRAINT `idExperimentAnswers`
    FOREIGN KEY (`experiment`)
    REFERENCES `crowdcontrol`.`Experiment` (`id_experiment`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `workerAnswered`
    FOREIGN KEY (`worker_id`)
    REFERENCES `crowdcontrol`.`Worker` (`id_worker`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `reservation_answer`
    FOREIGN KEY (`reservation`)
    REFERENCES `crowdcontrol`.`Answer_Reservation` (`idAnswer_Reservation`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Constraint`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Constraint` (
  `id_constraint` INT(11) NOT NULL AUTO_INCREMENT,
  `constraint` VARCHAR(45) NOT NULL,
  `experiment` INT(11) NOT NULL,
  PRIMARY KEY (`id_constraint`),
  INDEX `constrainedExperiment` (`experiment` ASC),
  CONSTRAINT `constrainedExperiment`
    FOREIGN KEY (`experiment`)
    REFERENCES `crowdcontrol`.`Experiment` (`id_experiment`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Calibration`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Calibration` (
  `id_calibration` INT(11) NOT NULL AUTO_INCREMENT,
  `property` VARCHAR(191) NOT NULL,
  `name` VARCHAR(191) NOT NULL,
  `experiment` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_calibration`),
  UNIQUE INDEX `experiment_UNIQUE` (`experiment` ASC),
  CONSTRAINT `participatedIn`
    FOREIGN KEY (`experiment`)
    REFERENCES `crowdcontrol`.`Experiment` (`id_experiment`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Calibration_answer_option`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Calibration_answer_option` (
  `id_calibration_answer_option` INT(11) NOT NULL AUTO_INCREMENT,
  `calibration` INT(11) NOT NULL,
  `answer` VARCHAR(191) NOT NULL,
  PRIMARY KEY (`id_calibration_answer_option`),
  INDEX `populationAnswer_idx` (`calibration` ASC),
  CONSTRAINT `calibrationAnswer`
    FOREIGN KEY (`calibration`)
    REFERENCES `crowdcontrol`.`Calibration` (`id_calibration`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Experiments_Platform`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Experiments_Platform` (
  `idExperiments_Platforms` INT NOT NULL AUTO_INCREMENT,
  `experiment` INT NOT NULL,
  `platform` VARCHAR(191) NULL,
  `platform_data` JSON NULL DEFAULT NULL,
  `identification` VARCHAR(191) GENERATED ALWAYS AS (JSON_EXTRACT(platform_data, '$.identification')),
  PRIMARY KEY (`idExperiments_Platforms`),
  INDEX `platform_user_idx` (`experiment` ASC),
  INDEX `active_platform_idx` (`platform` ASC),
  CONSTRAINT `platform_user`
    FOREIGN KEY (`experiment`)
    REFERENCES `crowdcontrol`.`Experiment` (`id_experiment`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `active_platform`
    FOREIGN KEY (`platform`)
    REFERENCES `crowdcontrol`.`Platform` (`id_platform`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Experiments_Calibration`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Experiments_Calibration` (
  `id_experiments_calibration` INT NOT NULL AUTO_INCREMENT,
  `experiments_platform` INT NOT NULL,
  `answer` INT(11) NOT NULL,
  `not` BIT(1) NOT NULL,
  PRIMARY KEY (`id_experiments_calibration`),
  INDEX `referencedAnswer_idx` (`answer` ASC),
  INDEX `referenced_experiments_platform_idx` (`experiments_platform` ASC),
  CONSTRAINT `referenced_answer`
    FOREIGN KEY (`answer`)
    REFERENCES `crowdcontrol`.`Calibration_answer_option` (`id_calibration_answer_option`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `referenced_experiments_platform`
    FOREIGN KEY (`experiments_platform`)
    REFERENCES `crowdcontrol`.`Experiments_Platform` (`idExperiments_Platforms`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Gift_Code`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Gift_Code` (
  `id_gift_code` INT(11) NOT NULL AUTO_INCREMENT,
  `code` MEDIUMTEXT NOT NULL,
  `amount` INT(11) NOT NULL,
  `currency` INT NOT NULL,
  PRIMARY KEY (`id_gift_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Notification`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Notification` (
  `id_notification` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `description` TEXT NOT NULL,
  `checkPeriod` INT(11) NOT NULL,
  `query` MEDIUMTEXT NOT NULL,
  `send_once` BIT(1) NOT NULL,
  PRIMARY KEY (`id_notification`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Calibration_Result`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Calibration_Result` (
  `id_calibration_result` INT(11) NOT NULL AUTO_INCREMENT,
  `worker` INT(11) NOT NULL,
  `answer` INT(11) NOT NULL,
  PRIMARY KEY (`id_calibration_result`),
  INDEX `referencedAnswer_idx` (`answer` ASC),
  INDEX `referencedWorker_idx` (`worker` ASC),
  CONSTRAINT `chosenAnswer`
    FOREIGN KEY (`answer`)
    REFERENCES `crowdcontrol`.`Calibration_answer_option` (`id_calibration_answer_option`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `referencedWorker`
    FOREIGN KEY (`worker`)
    REFERENCES `crowdcontrol`.`Worker` (`id_worker`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Rating_Reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Rating_Reservation` (
  `idReserverd_Rating` INT NOT NULL AUTO_INCREMENT,
  `worker` INT NOT NULL,
  `experiment` INT NOT NULL,
  `answer` INT NOT NULL,
  `timestamp` TIMESTAMP NOT NULL,
  `used` BIT(1) NOT NULL,
  PRIMARY KEY (`idReserverd_Rating`),
  INDEX `reserved_Answer_idx` (`answer` ASC),
  INDEX `worker_will_rate_idx` (`worker` ASC),
  INDEX `experiment_will_rated_on_idx` (`experiment` ASC),
  CONSTRAINT `reserved_Answer`
    FOREIGN KEY (`answer`)
    REFERENCES `crowdcontrol`.`Answer` (`id_answer`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `worker_will_rate`
    FOREIGN KEY (`worker`)
    REFERENCES `crowdcontrol`.`Worker` (`id_worker`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `experiment_will_rated_on`
    FOREIGN KEY (`experiment`)
    REFERENCES `crowdcontrol`.`Experiment` (`id_experiment`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Rating`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Rating` (
  `id_rating` INT(11) NOT NULL AUTO_INCREMENT,
  `experiment` INT(11) NOT NULL,
  `answer_r` INT(11) NOT NULL,
  `timestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `rating` INT(11) NOT NULL,
  `reservation` INT NOT NULL,
  `feedback` TEXT NULL DEFAULT NULL,
  `worker_id` INT(11) NOT NULL,
  `quality` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id_rating`),
  INDEX `idAnswers_idx` (`answer_r` ASC),
  INDEX `workerRated_idx` (`worker_id` ASC),
  INDEX `idExperimentRating_idx` (`experiment` ASC),
  INDEX `reservation_idx` (`reservation` ASC),
  CONSTRAINT `idAnswersRatings`
    FOREIGN KEY (`answer_r`)
    REFERENCES `crowdcontrol`.`Answer` (`id_answer`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `idExperimentRating`
    FOREIGN KEY (`experiment`)
    REFERENCES `crowdcontrol`.`Experiment` (`id_experiment`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `workerRated`
    FOREIGN KEY (`worker_id`)
    REFERENCES `crowdcontrol`.`Worker` (`id_worker`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `reservation_rating`
    FOREIGN KEY (`reservation`)
    REFERENCES `crowdcontrol`.`Rating_Reservation` (`idReserverd_Rating`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Tag` (
  `id_tag` INT(11) NOT NULL AUTO_INCREMENT,
  `tag` VARCHAR(191) NOT NULL,
  `experiment` INT(11) NOT NULL,
  PRIMARY KEY (`id_tag`),
  INDEX `idexperiment_idx` (`experiment` ASC),
  CONSTRAINT `idexperimenttags`
    FOREIGN KEY (`experiment`)
    REFERENCES `crowdcontrol`.`Experiment` (`id_experiment`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Worker_Balance`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Worker_Balance` (
  `id_worker_balance` INT NOT NULL AUTO_INCREMENT,
  `transaction_value` INT NOT NULL,
  `worker` INT NOT NULL,
  `experiment` INT NULL,
  `gift_code` INT NULL,
  `type` ENUM('debit', 'credit') NOT NULL,
  `timestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_worker_balance`),
  INDEX `transaction_partner_idx` (`worker` ASC),
  INDEX `used_gift_code_idx` (`gift_code` ASC),
  CONSTRAINT `transaction_partner`
    FOREIGN KEY (`worker`)
    REFERENCES `crowdcontrol`.`Worker` (`id_worker`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `used_gift_code`
    FOREIGN KEY (`gift_code`)
    REFERENCES `crowdcontrol`.`Gift_Code` (`id_gift_code`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Rating_Option_Template`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Rating_Option_Template` (
  `id_rating_options_template` INT NOT NULL AUTO_INCREMENT,
  `name` TEXT NOT NULL,
  `value` INT NOT NULL,
  `template` INT NOT NULL,
  PRIMARY KEY (`id_rating_options_template`),
  INDEX `referenced_template_idx` (`template` ASC),
  CONSTRAINT `referenced_template`
    FOREIGN KEY (`template`)
    REFERENCES `crowdcontrol`.`Template` (`id_template`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Rating_Option_Experiment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Rating_Option_Experiment` (
  `id_Rating_Option_Experiment` INT NOT NULL AUTO_INCREMENT,
  `name` TEXT NOT NULL,
  `value` INT NOT NULL,
  `experiment` INT NOT NULL,
  PRIMARY KEY (`id_Rating_Option_Experiment`),
  INDEX `rating_options_experiment_reference_idx` (`experiment` ASC),
  CONSTRAINT `rating_options_experiment_reference`
    FOREIGN KEY (`experiment`)
    REFERENCES `crowdcontrol`.`Experiment` (`id_experiment`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Algorithm_Task_Chooser_Param`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Algorithm_Task_Chooser_Param` (
  `id_Algorithm_Task_Chooser_Param` INT NOT NULL AUTO_INCREMENT,
  `description` TEXT NOT NULL,
  `regex` VARCHAR(191) NOT NULL,
  `algorithm` VARCHAR(191) NOT NULL,
  `data` VARCHAR(191) NULL,
  PRIMARY KEY (`id_Algorithm_Task_Chooser_Param`),
  INDEX `referencedTaskChooser_idx` (`algorithm` ASC),
  CONSTRAINT `referencedTaskChooser`
    FOREIGN KEY (`algorithm`)
    REFERENCES `crowdcontrol`.`Algorithm_Task_Chooser` (`id_task_chooser`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Chosen_Task_Chooser_Param`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Chosen_Task_Chooser_Param` (
  `id_Choosen_Task_Chooser_Param` INT NOT NULL AUTO_INCREMENT,
  `value` VARCHAR(191) NOT NULL,
  `experiment` INT NOT NULL,
  `param` INT NOT NULL,
  PRIMARY KEY (`id_Choosen_Task_Chooser_Param`),
  INDEX `taskChooserParamRefExperiment_idx` (`experiment` ASC),
  INDEX `choosenTaskChooserPAram_idx` (`param` ASC),
  CONSTRAINT `taskChooserParamRefExperiment`
    FOREIGN KEY (`experiment`)
    REFERENCES `crowdcontrol`.`Experiment` (`id_experiment`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `choosenTaskChooserPAram`
    FOREIGN KEY (`param`)
    REFERENCES `crowdcontrol`.`Algorithm_Task_Chooser_Param` (`id_Algorithm_Task_Chooser_Param`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Algorithm_Answer_Quality_Param`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Algorithm_Answer_Quality_Param` (
  `id_Algorithm_Answer_Quality_Param` INT NOT NULL AUTO_INCREMENT,
  `description` TEXT NOT NULL,
  `regex` VARCHAR(191) NOT NULL,
  `algorithm` VARCHAR(191) NOT NULL,
  `data` VARCHAR(191) NULL,
  PRIMARY KEY (`id_Algorithm_Answer_Quality_Param`),
  INDEX `referencedAnswerQuality_idx` (`algorithm` ASC),
  CONSTRAINT `referencedAnswerQuality`
    FOREIGN KEY (`algorithm`)
    REFERENCES `crowdcontrol`.`Algorithm_Answer_Quality` (`id_Algorithm_Answer_Quality`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Chosen_Answer_Quality_Param`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Chosen_Answer_Quality_Param` (
  `id_Algorithm_Answer_Quality_Param_Chosen` INT NOT NULL AUTO_INCREMENT,
  `value` VARCHAR(191) NOT NULL,
  `experiment` INT NOT NULL,
  `param` INT NOT NULL,
  PRIMARY KEY (`id_Algorithm_Answer_Quality_Param_Chosen`),
  INDEX `chosenAnswerQualityParam_idx` (`param` ASC),
  INDEX `answerQualityParamRefExperiment_idx` (`experiment` ASC),
  CONSTRAINT `chosenAnswerQualityParam`
    FOREIGN KEY (`param`)
    REFERENCES `crowdcontrol`.`Algorithm_Answer_Quality_Param` (`id_Algorithm_Answer_Quality_Param`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `answerQualityParamRefExperiment`
    FOREIGN KEY (`experiment`)
    REFERENCES `crowdcontrol`.`Experiment` (`id_experiment`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Algorithm_Rating_Quality_Param`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Algorithm_Rating_Quality_Param` (
  `id_Algorithm_Rating_Quality_Param` INT NOT NULL AUTO_INCREMENT,
  `description` TEXT NOT NULL,
  `regex` VARCHAR(191) NOT NULL,
  `algorithm` VARCHAR(191) NOT NULL,
  `data` VARCHAR(191) NULL,
  PRIMARY KEY (`id_Algorithm_Rating_Quality_Param`),
  INDEX `regerencedRatinQuality_idx` (`algorithm` ASC),
  CONSTRAINT `regerencedRatinQuality`
    FOREIGN KEY (`algorithm`)
    REFERENCES `crowdcontrol`.`Algorithm_Rating_Quality` (`id_Algorithm_Rating_Quality`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Chosen_Rating_Quality_Param`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Chosen_Rating_Quality_Param` (
  `id_Algorithm_Rating_Quality_Chosen` INT NOT NULL AUTO_INCREMENT,
  `value` VARCHAR(191) NOT NULL,
  `experiment` INT NOT NULL,
  `param` INT NOT NULL,
  PRIMARY KEY (`id_Algorithm_Rating_Quality_Chosen`),
  INDEX `chosenRatingQualityParam_idx` (`param` ASC),
  INDEX `chosenRatingQualityParamRefExperiment_idx` (`experiment` ASC),
  CONSTRAINT `chosenRatingQualityParam`
    FOREIGN KEY (`param`)
    REFERENCES `crowdcontrol`.`Algorithm_Rating_Quality_Param` (`id_Algorithm_Rating_Quality_Param`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `chosenRatingQualityParamRefExperiment`
    FOREIGN KEY (`experiment`)
    REFERENCES `crowdcontrol`.`Experiment` (`id_experiment`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Notification_Receiver_Email`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Notification_Receiver_Email` (
  `id_notification_receiver_email` INT NOT NULL AUTO_INCREMENT,
  `notification` INT NOT NULL,
  `email` VARCHAR(191) NOT NULL,
  PRIMARY KEY (`id_notification_receiver_email`),
  INDEX `referencedNotification_idx` (`notification` ASC),
  CONSTRAINT `referenced_notification`
    FOREIGN KEY (`notification`)
    REFERENCES `crowdcontrol`.`Notification` (`id_notification`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Notification_Token`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Notification_Token` (
  `id_notification_Token` INT NOT NULL AUTO_INCREMENT,
  `result_id` INT NOT NULL,
  `result_token` VARCHAR(191) NOT NULL,
  `notification` INT NOT NULL,
  PRIMARY KEY (`id_notification_Token`),
  INDEX `belonging_notification_idx` (`notification` ASC),
  CONSTRAINT `belonging_notification`
    FOREIGN KEY (`notification`)
    REFERENCES `crowdcontrol`.`Notification` (`id_notification`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Rating_Constraint`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Rating_Constraint` (
  `id_rating_Constraints` INT NOT NULL AUTO_INCREMENT,
  `ref_rating` INT NOT NULL,
  `off_constraint` INT NOT NULL,
  PRIMARY KEY (`id_rating_Constraints`),
  INDEX `referenced_rating_idx` (`ref_rating` ASC),
  INDEX `roffended_constraint_idx` (`off_constraint` ASC),
  CONSTRAINT `referenced_rating`
    FOREIGN KEY (`ref_rating`)
    REFERENCES `crowdcontrol`.`Rating` (`id_rating`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `roffended_constraint`
    FOREIGN KEY (`off_constraint`)
    REFERENCES `crowdcontrol`.`Constraint` (`id_constraint`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Template_Tag`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Template_Tag` (
  `id_template_Tag` INT NOT NULL AUTO_INCREMENT,
  `template` INT NOT NULL,
  `tag` VARCHAR(191) NOT NULL,
  PRIMARY KEY (`id_template_Tag`),
  INDEX `tagged_template_idx` (`template` ASC),
  CONSTRAINT `tagged_template`
    FOREIGN KEY (`template`)
    REFERENCES `crowdcontrol`.`Template` (`id_template`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Template_Constraint`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Template_Constraint` (
  `id_teamplate_Constraint` INT NOT NULL AUTO_INCREMENT,
  `template` INT NOT NULL,
  `constraint` VARCHAR(191) NOT NULL,
  PRIMARY KEY (`id_teamplate_Constraint`),
  INDEX `constrainedTemplate_idx` (`template` ASC),
  CONSTRAINT `constrained_template`
    FOREIGN KEY (`template`)
    REFERENCES `crowdcontrol`.`Template` (`id_template`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Experiments_Platform_Status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Experiments_Platform_Status` (
  `idExperiments_Platform_Status` INT NOT NULL AUTO_INCREMENT,
  `platform_status` ENUM('draft', 'failedPublishing', 'running', 'finished', 'creative_stopping', 'shutdown', 'stopped') NOT NULL DEFAULT 'draft',
  `timestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `platform` INT NOT NULL,
  PRIMARY KEY (`idExperiments_Platform_Status`),
  INDEX `status_for_platform_idx` (`platform` ASC),
  CONSTRAINT `status_for_platform`
    FOREIGN KEY (`platform`)
    REFERENCES `crowdcontrol`.`Experiments_Platform` (`idExperiments_Platforms`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Experiments_Platform_Mode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Experiments_Platform_Mode` (
  `idExperiments_Platform_Stopgap` INT NOT NULL AUTO_INCREMENT,
  `experiments_platform` INT NOT NULL,
  `mode` ENUM('answer', 'rating', 'normal') NOT NULL,
  `timestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idExperiments_Platform_Stopgap`),
  INDEX `mode_for_platform_idx` (`experiments_platform` ASC),
  CONSTRAINT `mode_for_platform`
    FOREIGN KEY (`experiments_platform`)
    REFERENCES `crowdcontrol`.`Experiments_Platform` (`idExperiments_Platforms`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `crowdcontrol`.`Database_Version`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `crowdcontrol`.`Database_Version` (
  `idDatabase_Version` INT NOT NULL AUTO_INCREMENT,
  `version` INT NOT NULL,
  `timestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idDatabase_Version`))
ENGINE = InnoDB;

USE `crowdcontrol`;

DELIMITER $$
USE `crowdcontrol`$$
CREATE DEFINER = CURRENT_USER TRIGGER `crowdcontrol`.`Algorithm_Task_Chooser_BEFORE_INSERT` BEFORE INSERT ON `Algorithm_Task_Chooser` FOR EACH ROW
BEGIN
	SET NEW.id_task_chooser = LOWER(NEW.id_task_chooser);
    
	IF (NEW.id_task_chooser REGEXP '^[a-z0-9_]+$') = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "id_task_chooser does not match regex";
	END IF;
END$$

USE `crowdcontrol`$$
CREATE DEFINER = CURRENT_USER TRIGGER `crowdcontrol`.`Algorithm_Answer_Quality_BEFORE_INSERT` BEFORE INSERT ON `Algorithm_Answer_Quality` FOR EACH ROW
BEGIN
	SET NEW.id_Algorithm_Answer_Quality = LOWER(NEW.id_Algorithm_Answer_Quality);
    
	IF (NEW.id_Algorithm_Answer_Quality REGEXP '^[a-z0-9_]+$') = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "id_Algorithm_Answer_Quality does not match regex";
	END IF;
END$$

USE `crowdcontrol`$$
CREATE DEFINER = CURRENT_USER TRIGGER `crowdcontrol`.`Algorithm_Rating_Quality_BEFORE_INSERT` BEFORE INSERT ON `Algorithm_Rating_Quality` FOR EACH ROW
BEGIN
	SET NEW.id_Algorithm_Rating_Quality = LOWER(NEW.id_Algorithm_Rating_Quality);
    
	IF (NEW.id_Algorithm_Rating_Quality REGEXP '^[a-z0-9_]+$') = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "id_Algorithm_Rating_Quality does not match regex";
	END IF;
END$$

USE `crowdcontrol`$$
CREATE DEFINER = CURRENT_USER TRIGGER `crowdcontrol`.`Platform_BEFORE_INSERT` BEFORE INSERT ON `Platform` FOR EACH ROW
BEGIN
    SET NEW.id_platform = LOWER(NEW.id_platform);
    
	IF (NEW.id_platform REGEXP '^[a-z0-9_]+$') = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "id_platform does not match regex";
	END IF;
END$$

USE `crowdcontrol`$$
CREATE DEFINER = CURRENT_USER TRIGGER `crowdcontrol`.`Chosen_Task_Chooser_Param` BEFORE INSERT ON `Chosen_Task_Chooser_Param` FOR EACH ROW
BEGIN
	DECLARE msg VARCHAR(191);
	DECLARE checkregex VARCHAR(191);
	SELECT regex FROM Algorithm_Task_Chooser_Param WHERE id_Algorithm_Task_Chooser_Param = NEW.param INTO checkregex;
		
	IF (NEW.value REGEXP checkregex) = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Chosen_Task_Chooser_Param.value does not match regex";
	END IF;
END$$

USE `crowdcontrol`$$
CREATE DEFINER = CURRENT_USER TRIGGER `crowdcontrol`.`Algorithm_Answer_Quality_Param_Chosen_BEFORE_INSERT` BEFORE INSERT ON `Chosen_Answer_Quality_Param` FOR EACH ROW
BEGIN
	DECLARE msg VARCHAR(191);
	DECLARE checkregex VARCHAR(191);
	SELECT regex FROM Algorithm_Answer_Quality_Param WHERE id_Algorithm_Answer_Quality_Param = NEW.param INTO checkregex;
	
	IF (NEW.value REGEXP checkregex) = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Chosen_Answer_Quality_Param.value does not match regex";
	END IF;
END$$

USE `crowdcontrol`$$
CREATE DEFINER = CURRENT_USER TRIGGER `crowdcontrol`.`Algorithm_Rating_Quality_Param_Chosen_BEFORE_INSERT` BEFORE INSERT ON `Chosen_Rating_Quality_Param` FOR EACH ROW
BEGIN
	DECLARE msg VARCHAR(191);
	DECLARE checkregex VARCHAR(191);
	SELECT regex FROM Algorithm_Rating_Quality_Param WHERE id_Algorithm_Rating_Quality_Param = NEW.param INTO checkregex;
	
	IF (NEW.value REGEXP checkregex) = 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = "Chosen_Rating_Quality_Param.value does not match regex";
	END IF;
END$$


DELIMITER ;
