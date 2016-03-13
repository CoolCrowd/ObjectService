/**
 * This class is generated by jOOQ
 */
package edu.kit.ipd.crowdcontrol.objectservice.database.model.tables;


import edu.kit.ipd.crowdcontrol.objectservice.database.model.Crowdcontrol;
import edu.kit.ipd.crowdcontrol.objectservice.database.model.Keys;
import edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.records.AlgorithmTaskChooserRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
	value = {
		"http://www.jooq.org",
		"jOOQ version:3.7.3"
	},
	comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AlgorithmTaskChooser extends TableImpl<AlgorithmTaskChooserRecord> {

	private static final long serialVersionUID = 1020511976;

	/**
	 * The reference instance of <code>crowdcontrol.Algorithm_Task_Chooser</code>
	 */
	public static final AlgorithmTaskChooser ALGORITHM_TASK_CHOOSER = new AlgorithmTaskChooser();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<AlgorithmTaskChooserRecord> getRecordType() {
		return AlgorithmTaskChooserRecord.class;
	}

	/**
	 * The column <code>crowdcontrol.Algorithm_Task_Chooser.id_task_chooser</code>.
	 */
	public final TableField<AlgorithmTaskChooserRecord, String> ID_TASK_CHOOSER = createField("id_task_chooser", org.jooq.impl.SQLDataType.VARCHAR.length(191).nullable(false), this, "");

	/**
	 * The column <code>crowdcontrol.Algorithm_Task_Chooser.description</code>.
	 */
	public final TableField<AlgorithmTaskChooserRecord, String> DESCRIPTION = createField("description", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

	/**
	 * Create a <code>crowdcontrol.Algorithm_Task_Chooser</code> table reference
	 */
	public AlgorithmTaskChooser() {
		this("Algorithm_Task_Chooser", null);
	}

	/**
	 * Create an aliased <code>crowdcontrol.Algorithm_Task_Chooser</code> table reference
	 */
	public AlgorithmTaskChooser(String alias) {
		this(alias, ALGORITHM_TASK_CHOOSER);
	}

	private AlgorithmTaskChooser(String alias, Table<AlgorithmTaskChooserRecord> aliased) {
		this(alias, aliased, null);
	}

	private AlgorithmTaskChooser(String alias, Table<AlgorithmTaskChooserRecord> aliased, Field<?>[] parameters) {
		super(alias, Crowdcontrol.CROWDCONTROL, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<AlgorithmTaskChooserRecord> getPrimaryKey() {
		return Keys.KEY_ALGORITHM_TASK_CHOOSER_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<AlgorithmTaskChooserRecord>> getKeys() {
		return Arrays.<UniqueKey<AlgorithmTaskChooserRecord>>asList(Keys.KEY_ALGORITHM_TASK_CHOOSER_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AlgorithmTaskChooser as(String alias) {
		return new AlgorithmTaskChooser(alias, this);
	}

	/**
	 * Rename this table
	 */
	public AlgorithmTaskChooser rename(String name) {
		return new AlgorithmTaskChooser(name, null);
	}
}
