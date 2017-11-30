package com.iemr.mmu.data.anc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_Sys_Respiratory")
public class SysRespiratoryExamination {

	@Id
	@GeneratedValue
	@Expose
	@Column(name = "ID")
	private Long ID;

	@Expose
	@Column(name = "BeneficiaryRegID")
	private Long beneficiaryRegID;

	@Expose
	@Column(name = "BenVisitID")
	private Long benVisitID;
	
	@Expose
	@Column(name = "ProviderServiceMapID")
	private Integer providerServiceMapID;

	@Expose
	@Column(name = "Trachea")
	private String trachea;

	@Expose
	@Column(name = "Inspection")
	private String inspection;

	@Expose
	@Column(name = "SignsOfRespiratoryDistress")
	private String signsOfRespiratoryDistress;

	@Expose
	@Column(name = "Palpation")
	private String palpation;

	@Expose
	@Column(name = "Auscultation")
	private String auscultation;

	@Expose
	@Column(name = "Auscultation_Stridor")
	private String auscultation_Stridor;

	@Expose
	@Column(name = "Auscultation_BreathSounds")
	private String auscultation_BreathSounds;

	@Expose
	@Column(name = "Auscultation_Crepitations")
	private String auscultation_Crepitations;

	@Expose
	@Column(name = "Auscultation_Wheezing")
	private String auscultation_Wheezing;

	@Expose
	@Column(name = "Auscultation_PleuralRub")
	private String auscultation_PleuralRub;

	@Expose
	@Column(name = "Auscultation_ConductedSounds")
	private String auscultation_ConductedSounds;

	@Expose
	@Column(name = "Percussion")
	private String percussion;
	
	@Expose
	@Column(name = "Deleted", insertable = false, updatable = true)
	private Boolean deleted;

	@Expose
	@Column(name = "Processed", insertable = false, updatable = true)
	private String processed;

	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;

	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp createdDate;

	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;

	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	public Long getBeneficiaryRegID() {
		return beneficiaryRegID;
	}

	public void setBeneficiaryRegID(Long beneficiaryRegID) {
		this.beneficiaryRegID = beneficiaryRegID;
	}

	public Long getBenVisitID() {
		return benVisitID;
	}

	public void setBenVisitID(Long benVisitID) {
		this.benVisitID = benVisitID;
	}

	public String getTrachea() {
		return trachea;
	}

	public void setTrachea(String trachea) {
		this.trachea = trachea;
	}

	public String getInspection() {
		return inspection;
	}

	public void setInspection(String inspection) {
		this.inspection = inspection;
	}

	public String getSignsOfRespiratoryDistress() {
		return signsOfRespiratoryDistress;
	}

	public void setSignsOfRespiratoryDistress(String signsOfRespiratoryDistress) {
		this.signsOfRespiratoryDistress = signsOfRespiratoryDistress;
	}

	public String getPalpation() {
		return palpation;
	}

	public void setPalpation(String palpation) {
		this.palpation = palpation;
	}

	public String getAuscultation() {
		return auscultation;
	}

	public void setAuscultation(String auscultation) {
		this.auscultation = auscultation;
	}

	public String getAuscultation_Stridor() {
		return auscultation_Stridor;
	}

	public void setAuscultation_Stridor(String auscultation_Stridor) {
		this.auscultation_Stridor = auscultation_Stridor;
	}

	public String getAuscultation_BreathSounds() {
		return auscultation_BreathSounds;
	}

	public void setAuscultation_BreathSounds(String auscultation_BreathSounds) {
		this.auscultation_BreathSounds = auscultation_BreathSounds;
	}

	public String getAuscultation_Crepitations() {
		return auscultation_Crepitations;
	}

	public void setAuscultation_Crepitations(String auscultation_Crepitations) {
		this.auscultation_Crepitations = auscultation_Crepitations;
	}

	public String getAuscultation_Wheezing() {
		return auscultation_Wheezing;
	}

	public void setAuscultation_Wheezing(String auscultation_Wheezing) {
		this.auscultation_Wheezing = auscultation_Wheezing;
	}

	public String getAuscultation_PleuralRub() {
		return auscultation_PleuralRub;
	}

	public void setAuscultation_PleuralRub(String auscultation_PleuralRub) {
		this.auscultation_PleuralRub = auscultation_PleuralRub;
	}

	public String getAuscultation_ConductedSounds() {
		return auscultation_ConductedSounds;
	}

	public void setAuscultation_ConductedSounds(String auscultation_ConductedSounds) {
		this.auscultation_ConductedSounds = auscultation_ConductedSounds;
	}

	public String getPercussion() {
		return percussion;
	}

	public void setPercussion(String percussion) {
		this.percussion = percussion;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public String getProcessed() {
		return processed;
	}

	public void setProcessed(String processed) {
		this.processed = processed;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Timestamp getLastModDate() {
		return lastModDate;
	}

	public void setLastModDate(Timestamp lastModDate) {
		this.lastModDate = lastModDate;
	}

	public Long getID() {
		return ID;
	}
	
}