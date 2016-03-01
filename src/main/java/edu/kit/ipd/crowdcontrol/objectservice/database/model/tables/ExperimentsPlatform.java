/**
 * This class is generated by jOOQ
 */
package edu.kit.ipd.crowdcontrol.objectservice.database.model.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.1" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ExperimentsPlatform extends org.jooq.impl.TableImpl<edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.records.ExperimentsPlatformRecord> {

	private static final long serialVersionUID = -738456915;

	/**
	 * The singleton instance of <code>crowdcontrol.Experiments_Platform</code>
	 */
	public static final edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.ExperimentsPlatform EXPERIMENTS_PLATFORM = new edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.ExperimentsPlatform();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.records.ExperimentsPlatformRecord> getRecordType() {
		return edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.records.ExperimentsPlatformRecord.class;
	}

	/**
	 * The column <code>crowdcontrol.Experiments_Platform.idExperiments_Platforms</code>.
	 */
	public final org.jooq.TableField<edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.records.ExperimentsPlatformRecord, java.lang.Integer> IDEXPERIMENTS_PLATFORMS = createField("idExperiments_Platforms", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>crowdcontrol.Experiments_Platform.experiment</code>.
	 */
	public final org.jooq.TableField<edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.records.ExperimentsPlatformRecord, java.lang.Integer> EXPERIMENT = createField("experiment", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>crowdcontrol.Experiments_Platform.platform</code>.
	 */
	public final org.jooq.TableField<edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.records.ExperimentsPlatformRecord, java.lang.String> PLATFORM = createField("platform", org.jooq.impl.SQLDataType.VARCHAR.length(191), this, "");

	/**
	 * The column <code>crowdcontrol.Experiments_Platform.platform_data</code>.
	 */
	public final org.jooq.TableField<edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.records.ExperimentsPlatformRecord, java.lang.String> PLATFORM_DATA = createField("platform_data", org.jooq.impl.SQLDataType.CLOB.length(16777215), this, "");

	/**
	 * Create a <code>crowdcontrol.Experiments_Platform</code> table reference
	 */
	public ExperimentsPlatform() {
		this("Experiments_Platform", null);
	}

	/**
	 * Create an aliased <code>crowdcontrol.Experiments_Platform</code> table reference
	 */
	public ExperimentsPlatform(java.lang.String alias) {
		this(alias, edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.ExperimentsPlatform.EXPERIMENTS_PLATFORM);
	}

	private ExperimentsPlatform(java.lang.String alias, org.jooq.Table<edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.records.ExperimentsPlatformRecord> aliased) {
		this(alias, aliased, null);
	}

	private ExperimentsPlatform(java.lang.String alias, org.jooq.Table<edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.records.ExperimentsPlatformRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, edu.kit.ipd.crowdcontrol.objectservice.database.model.Crowdcontrol.CROWDCONTROL, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.records.ExperimentsPlatformRecord, java.lang.Integer> getIdentity() {
		return edu.kit.ipd.crowdcontrol.objectservice.database.model.Keys.IDENTITY_EXPERIMENTS_PLATFORM;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.records.ExperimentsPlatformRecord> getPrimaryKey() {
		return edu.kit.ipd.crowdcontrol.objectservice.database.model.Keys.KEY_EXPERIMENTS_PLATFORM_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.records.ExperimentsPlatformRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.records.ExperimentsPlatformRecord>>asList(edu.kit.ipd.crowdcontrol.objectservice.database.model.Keys.KEY_EXPERIMENTS_PLATFORM_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.records.ExperimentsPlatformRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.records.ExperimentsPlatformRecord, ?>>asList(edu.kit.ipd.crowdcontrol.objectservice.database.model.Keys.PLATFORM_USER, edu.kit.ipd.crowdcontrol.objectservice.database.model.Keys.ACTIVE_PLATFORM);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.ExperimentsPlatform as(java.lang.String alias) {
		return new edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.ExperimentsPlatform(alias, this);
	}

	/**
	 * Rename this table
	 */
	public edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.ExperimentsPlatform rename(java.lang.String name) {
		return new edu.kit.ipd.crowdcontrol.objectservice.database.model.tables.ExperimentsPlatform(name, null);
	}
}
