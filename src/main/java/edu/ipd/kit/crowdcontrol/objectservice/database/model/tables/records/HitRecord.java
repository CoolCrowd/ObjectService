/**
 * This class is generated by jOOQ
 */
package edu.ipd.kit.crowdcontrol.objectservice.database.model.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.1" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class HitRecord extends org.jooq.impl.UpdatableRecordImpl<edu.ipd.kit.crowdcontrol.objectservice.database.model.tables.records.HitRecord> implements org.jooq.Record5<java.lang.Integer, java.lang.Integer, java.lang.Boolean, java.lang.Object, java.lang.String> {

	private static final long serialVersionUID = -1006742451;

	/**
	 * Setter for <code>crowdcontrol.HIT.idHIT</code>.
	 */
	public void setIdhit(java.lang.Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>crowdcontrol.HIT.idHIT</code>.
	 */
	public java.lang.Integer getIdhit() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>crowdcontrol.HIT.experiment</code>.
	 */
	public void setExperiment(java.lang.Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>crowdcontrol.HIT.experiment</code>.
	 */
	public java.lang.Integer getExperiment() {
		return (java.lang.Integer) getValue(1);
	}

	/**
	 * Setter for <code>crowdcontrol.HIT.running</code>.
	 */
	public void setRunning(java.lang.Boolean value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>crowdcontrol.HIT.running</code>.
	 */
	public java.lang.Boolean getRunning() {
		return (java.lang.Boolean) getValue(2);
	}

	/**
	 * Setter for <code>crowdcontrol.HIT.platform_data</code>.
	 */
	public void setPlatformData(java.lang.Object value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>crowdcontrol.HIT.platform_data</code>.
	 */
	public java.lang.Object getPlatformData() {
		return (java.lang.Object) getValue(3);
	}

	/**
	 * Setter for <code>crowdcontrol.HIT.crowd_platform</code>.
	 */
	public void setCrowdPlatform(java.lang.String value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>crowdcontrol.HIT.crowd_platform</code>.
	 */
	public java.lang.String getCrowdPlatform() {
		return (java.lang.String) getValue(4);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.lang.Integer> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record5 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row5<java.lang.Integer, java.lang.Integer, java.lang.Boolean, java.lang.Object, java.lang.String> fieldsRow() {
		return (org.jooq.Row5) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row5<java.lang.Integer, java.lang.Integer, java.lang.Boolean, java.lang.Object, java.lang.String> valuesRow() {
		return (org.jooq.Row5) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field1() {
		return edu.ipd.kit.crowdcontrol.objectservice.database.model.tables.Hit.HIT.IDHIT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field2() {
		return edu.ipd.kit.crowdcontrol.objectservice.database.model.tables.Hit.HIT.EXPERIMENT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Boolean> field3() {
		return edu.ipd.kit.crowdcontrol.objectservice.database.model.tables.Hit.HIT.RUNNING;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Object> field4() {
		return edu.ipd.kit.crowdcontrol.objectservice.database.model.tables.Hit.HIT.PLATFORM_DATA;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field5() {
		return edu.ipd.kit.crowdcontrol.objectservice.database.model.tables.Hit.HIT.CROWD_PLATFORM;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value1() {
		return getIdhit();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value2() {
		return getExperiment();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Boolean value3() {
		return getRunning();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Object value4() {
		return getPlatformData();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value5() {
		return getCrowdPlatform();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HitRecord value1(java.lang.Integer value) {
		setIdhit(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HitRecord value2(java.lang.Integer value) {
		setExperiment(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HitRecord value3(java.lang.Boolean value) {
		setRunning(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HitRecord value4(java.lang.Object value) {
		setPlatformData(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HitRecord value5(java.lang.String value) {
		setCrowdPlatform(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public HitRecord values(java.lang.Integer value1, java.lang.Integer value2, java.lang.Boolean value3, java.lang.Object value4, java.lang.String value5) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached HitRecord
	 */
	public HitRecord() {
		super(edu.ipd.kit.crowdcontrol.objectservice.database.model.tables.Hit.HIT);
	}

	/**
	 * Create a detached, initialised HitRecord
	 */
	public HitRecord(java.lang.Integer idhit, java.lang.Integer experiment, java.lang.Boolean running, java.lang.Object platformData, java.lang.String crowdPlatform) {
		super(edu.ipd.kit.crowdcontrol.objectservice.database.model.tables.Hit.HIT);

		setValue(0, idhit);
		setValue(1, experiment);
		setValue(2, running);
		setValue(3, platformData);
		setValue(4, crowdPlatform);
	}
}
