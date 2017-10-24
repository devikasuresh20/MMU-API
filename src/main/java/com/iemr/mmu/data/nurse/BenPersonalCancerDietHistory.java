package com.iemr.mmu.data.nurse;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;

@Entity
@Table(name = "t_cancerdiethistory")
public class BenPersonalCancerDietHistory {
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
	@Column(name = "DietType")
	private String dietType;
	@Expose
	@Column(name = "FruitConsumptionDays")
	private Integer fruitConsumptionDays;
	@Expose
	@Column(name = "FruitQuantityPerDay")
	private Integer fruitQuantityPerDay;
	@Expose
	@Column(name = "VegetableConsumptionDays")
	private Integer vegetableConsumptionDays;
	@Expose
	@Column(name = "VegetableQuantityPerDay")
	private Integer vegetableQuantityPerDay;
	@Expose
	@Column(name = "IntakeOfOutsidePreparedMeal")
	private Integer intakeOfOutsidePreparedMeal;
	@Expose
	@Column(name = "TypeOfOilConsumed")
	private String typeOfOilConsumed;
	@Expose
	@Column(name = "PhysicalActivityType")
	private String physicalActivityType;
	@Expose
	@Column(name = "IsRadiationExposure")
	private Boolean ssRadiationExposure;
	@Expose
	@Column(name = "IsThyroidDisorder")
	private Boolean isThyroidDisorder;
	@Expose
	@Column(name = "Deleted", insertable = false)
	private Boolean deleted;
	@Expose
	@Column(name = "Processed", insertable = false)
	private Character processed;
	@Expose
	@Column(name = "CreatedBy")
	private String createdBy;
	@Expose
	@Column(name = "CreatedDate", insertable = false, updatable = false)
	private Timestamp CreatedDate;
	@Expose
	@Column(name = "ModifiedBy")
	private String modifiedBy;
	@Expose
	@Column(name = "LastModDate", insertable = false, updatable = false)
	private Timestamp lastModDate;

	@Transient
	@JsonIgnore
	private List<String> typeOfOilConsumedList;

	public BenPersonalCancerDietHistory() {
	}

	public BenPersonalCancerDietHistory(Long iD, Long beneficiaryRegID, Long benVisitID, Integer providerServiceMapID,
			String dietType, Integer fruitConsumptionDays, Integer fruitQuantityPerDay,
			Integer vegetableConsumptionDays, Integer vegetableQuantityPerDay, Integer intakeOfOutsidePreparedMeal,
			String typeOfOilConsumed, String physicalActivityType, Boolean ssRadiationExposure,
			Boolean isThyroidDisorder, Boolean deleted, Character processed, String createdBy, Timestamp createdDate,
			String modifiedBy, Timestamp lastModDate, List<String> typeOfOilConsumedList) {
		super();
		ID = iD;
		this.beneficiaryRegID = beneficiaryRegID;
		this.benVisitID = benVisitID;
		this.providerServiceMapID = providerServiceMapID;
		this.dietType = dietType;
		this.fruitConsumptionDays = fruitConsumptionDays;
		this.fruitQuantityPerDay = fruitQuantityPerDay;
		this.vegetableConsumptionDays = vegetableConsumptionDays;
		this.vegetableQuantityPerDay = vegetableQuantityPerDay;
		this.intakeOfOutsidePreparedMeal = intakeOfOutsidePreparedMeal;
		this.typeOfOilConsumed = typeOfOilConsumed;
		this.physicalActivityType = physicalActivityType;
		this.ssRadiationExposure = ssRadiationExposure;
		this.isThyroidDisorder = isThyroidDisorder;
		this.deleted = deleted;
		this.processed = processed;
		this.createdBy = createdBy;
		CreatedDate = createdDate;
		this.modifiedBy = modifiedBy;
		this.lastModDate = lastModDate;
		this.typeOfOilConsumedList = typeOfOilConsumedList;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

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

	public Integer getProviderServiceMapID() {
		return providerServiceMapID;
	}

	public void setProviderServiceMapID(Integer providerServiceMapID) {
		this.providerServiceMapID = providerServiceMapID;
	}

	public String getDietType() {
		return dietType;
	}

	public void setDietType(String dietType) {
		this.dietType = dietType;
	}

	public Integer getFruitConsumptionDays() {
		return fruitConsumptionDays;
	}

	public void setFruitConsumptionDays(Integer fruitConsumptionDays) {
		this.fruitConsumptionDays = fruitConsumptionDays;
	}

	public Integer getFruitQuantityPerDay() {
		return fruitQuantityPerDay;
	}

	public void setFruitQuantityPerDay(Integer fruitQuantityPerDay) {
		this.fruitQuantityPerDay = fruitQuantityPerDay;
	}

	public Integer getVegetableConsumptionDays() {
		return vegetableConsumptionDays;
	}

	public void setVegetableConsumptionDays(Integer vegetableConsumptionDays) {
		this.vegetableConsumptionDays = vegetableConsumptionDays;
	}

	public Integer getVegetableQuantityPerDay() {
		return vegetableQuantityPerDay;
	}

	public void setVegetableQuantityPerDay(Integer vegetableQuantityPerDay) {
		this.vegetableQuantityPerDay = vegetableQuantityPerDay;
	}

	public Integer getIntakeOfOutsidePreparedMeal() {
		return intakeOfOutsidePreparedMeal;
	}

	public void setIntakeOfOutsidePreparedMeal(Integer intakeOfOutsidePreparedMeal) {
		this.intakeOfOutsidePreparedMeal = intakeOfOutsidePreparedMeal;
	}

	public String getTypeOfOilConsumed() {
		return typeOfOilConsumed;
	}

	public void setTypeOfOilConsumed(String typeOfOilConsumed) {
		this.typeOfOilConsumed = typeOfOilConsumed;
	}

	public String getPhysicalActivityType() {
		return physicalActivityType;
	}

	public void setPhysicalActivityType(String physicalActivityType) {
		this.physicalActivityType = physicalActivityType;
	}

	public Boolean getSsRadiationExposure() {
		return ssRadiationExposure;
	}

	public void setSsRadiationExposure(Boolean ssRadiationExposure) {
		this.ssRadiationExposure = ssRadiationExposure;
	}

	public Boolean getIsThyroidDisorder() {
		return isThyroidDisorder;
	}

	public void setIsThyroidDisorder(Boolean isThyroidDisorder) {
		this.isThyroidDisorder = isThyroidDisorder;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Character getProcessed() {
		return processed;
	}

	public void setProcessed(Character processed) {
		this.processed = processed;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return CreatedDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		CreatedDate = createdDate;
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

	public List<String> getTypeOfOilConsumedList() {
		return typeOfOilConsumedList;
	}

	public void setTypeOfOilConsumedList(List<String> typeOfOilConsumedList) {
		this.typeOfOilConsumedList = typeOfOilConsumedList;
	}

}