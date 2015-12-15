/**
 * This class is generated by jOOQ
 */
package edu.ipd.kit.crowdcontrol.objectservice.database.model.tables.pojos;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.4.1" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Experiment implements java.io.Serializable {

	private static final long serialVersionUID = 1807141797;

	private java.lang.Integer idexperiment;
	private java.lang.String  question;
	private java.lang.Object  ratingOptions;
	private java.lang.String  titel;
	private java.lang.String  answerDescription;
	private java.lang.String  ratingDescription;
	private java.lang.Integer ratingsPerAnswer;
	private java.lang.String  algorithmTaskChooser;
	private java.lang.String  algorithmQualityAnswer;
	private java.lang.String  algorithmQualityRating;
	private java.lang.Integer basePayment;
	private java.lang.Integer bonusAnswer;
	private java.lang.Integer bonusRating;

	public Experiment() {}

	public Experiment(
		java.lang.Integer idexperiment,
		java.lang.String  question,
		java.lang.Object  ratingOptions,
		java.lang.String  titel,
		java.lang.String  answerDescription,
		java.lang.String  ratingDescription,
		java.lang.Integer ratingsPerAnswer,
		java.lang.String  algorithmTaskChooser,
		java.lang.String  algorithmQualityAnswer,
		java.lang.String  algorithmQualityRating,
		java.lang.Integer basePayment,
		java.lang.Integer bonusAnswer,
		java.lang.Integer bonusRating
	) {
		this.idexperiment = idexperiment;
		this.question = question;
		this.ratingOptions = ratingOptions;
		this.titel = titel;
		this.answerDescription = answerDescription;
		this.ratingDescription = ratingDescription;
		this.ratingsPerAnswer = ratingsPerAnswer;
		this.algorithmTaskChooser = algorithmTaskChooser;
		this.algorithmQualityAnswer = algorithmQualityAnswer;
		this.algorithmQualityRating = algorithmQualityRating;
		this.basePayment = basePayment;
		this.bonusAnswer = bonusAnswer;
		this.bonusRating = bonusRating;
	}

	public java.lang.Integer getIdexperiment() {
		return this.idexperiment;
	}

	public void setIdexperiment(java.lang.Integer idexperiment) {
		this.idexperiment = idexperiment;
	}

	public java.lang.String getQuestion() {
		return this.question;
	}

	public void setQuestion(java.lang.String question) {
		this.question = question;
	}

	public java.lang.Object getRatingOptions() {
		return this.ratingOptions;
	}

	public void setRatingOptions(java.lang.Object ratingOptions) {
		this.ratingOptions = ratingOptions;
	}

	public java.lang.String getTitel() {
		return this.titel;
	}

	public void setTitel(java.lang.String titel) {
		this.titel = titel;
	}

	public java.lang.String getAnswerDescription() {
		return this.answerDescription;
	}

	public void setAnswerDescription(java.lang.String answerDescription) {
		this.answerDescription = answerDescription;
	}

	public java.lang.String getRatingDescription() {
		return this.ratingDescription;
	}

	public void setRatingDescription(java.lang.String ratingDescription) {
		this.ratingDescription = ratingDescription;
	}

	public java.lang.Integer getRatingsPerAnswer() {
		return this.ratingsPerAnswer;
	}

	public void setRatingsPerAnswer(java.lang.Integer ratingsPerAnswer) {
		this.ratingsPerAnswer = ratingsPerAnswer;
	}

	public java.lang.String getAlgorithmTaskChooser() {
		return this.algorithmTaskChooser;
	}

	public void setAlgorithmTaskChooser(java.lang.String algorithmTaskChooser) {
		this.algorithmTaskChooser = algorithmTaskChooser;
	}

	public java.lang.String getAlgorithmQualityAnswer() {
		return this.algorithmQualityAnswer;
	}

	public void setAlgorithmQualityAnswer(java.lang.String algorithmQualityAnswer) {
		this.algorithmQualityAnswer = algorithmQualityAnswer;
	}

	public java.lang.String getAlgorithmQualityRating() {
		return this.algorithmQualityRating;
	}

	public void setAlgorithmQualityRating(java.lang.String algorithmQualityRating) {
		this.algorithmQualityRating = algorithmQualityRating;
	}

	public java.lang.Integer getBasePayment() {
		return this.basePayment;
	}

	public void setBasePayment(java.lang.Integer basePayment) {
		this.basePayment = basePayment;
	}

	public java.lang.Integer getBonusAnswer() {
		return this.bonusAnswer;
	}

	public void setBonusAnswer(java.lang.Integer bonusAnswer) {
		this.bonusAnswer = bonusAnswer;
	}

	public java.lang.Integer getBonusRating() {
		return this.bonusRating;
	}

	public void setBonusRating(java.lang.Integer bonusRating) {
		this.bonusRating = bonusRating;
	}
}
