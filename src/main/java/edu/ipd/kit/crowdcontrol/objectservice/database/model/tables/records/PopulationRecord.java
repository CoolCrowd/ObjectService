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
public class PopulationRecord extends org.jooq.impl.UpdatableRecordImpl<edu.ipd.kit.crowdcontrol.objectservice.database.model.tables.records.PopulationRecord> implements org.jooq.Record4<java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Object> {

	private static final long serialVersionUID = -1435988152;

	/**
	 * Setter for <code>crowdcontrol.Population.idPopulation</code>.
	 */
	public void setIdpopulation(java.lang.Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>crowdcontrol.Population.idPopulation</code>.
	 */
	public java.lang.Integer getIdpopulation() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>crowdcontrol.Population.experiment</code>.
	 */
	public void setExperiment(java.lang.Integer value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>crowdcontrol.Population.experiment</code>.
	 */
	public java.lang.Integer getExperiment() {
		return (java.lang.Integer) getValue(1);
	}

	/**
	 * Setter for <code>crowdcontrol.Population.volume</code>.
	 */
	public void setVolume(java.lang.String value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>crowdcontrol.Population.volume</code>.
	 */
	public java.lang.String getVolume() {
		return (java.lang.String) getValue(2);
	}

	/**
	 * Setter for <code>crowdcontrol.Population.platform_data</code>.
	 */
	public void setPlatformData(java.lang.Object value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>crowdcontrol.Population.platform_data</code>.
	 */
	public java.lang.Object getPlatformData() {
		return (java.lang.Object) getValue(3);
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
	// Record4 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row4<java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Object> fieldsRow() {
		return (org.jooq.Row4) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row4<java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Object> valuesRow() {
		return (org.jooq.Row4) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field1() {
		return edu.ipd.kit.crowdcontrol.objectservice.database.model.tables.Population.POPULATION.IDPOPULATION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field2() {
		return edu.ipd.kit.crowdcontrol.objectservice.database.model.tables.Population.POPULATION.EXPERIMENT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field3() {
		return edu.ipd.kit.crowdcontrol.objectservice.database.model.tables.Population.POPULATION.VOLUME;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Object> field4() {
		return edu.ipd.kit.crowdcontrol.objectservice.database.model.tables.Population.POPULATION.PLATFORM_DATA;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value1() {
		return getIdpopulation();
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
	public java.lang.String value3() {
		return getVolume();
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
	public PopulationRecord value1(java.lang.Integer value) {
		setIdpopulation(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PopulationRecord value2(java.lang.Integer value) {
		setExperiment(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PopulationRecord value3(java.lang.String value) {
		setVolume(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PopulationRecord value4(java.lang.Object value) {
		setPlatformData(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PopulationRecord values(java.lang.Integer value1, java.lang.Integer value2, java.lang.String value3, java.lang.Object value4) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached PopulationRecord
	 */
	public PopulationRecord() {
		super(edu.ipd.kit.crowdcontrol.objectservice.database.model.tables.Population.POPULATION);
	}

	/**
	 * Create a detached, initialised PopulationRecord
	 */
	public PopulationRecord(java.lang.Integer idpopulation, java.lang.Integer experiment, java.lang.String volume, java.lang.Object platformData) {
		super(edu.ipd.kit.crowdcontrol.objectservice.database.model.tables.Population.POPULATION);

		setValue(0, idpopulation);
		setValue(1, experiment);
		setValue(2, volume);
		setValue(3, platformData);
	}
}
