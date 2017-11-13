package com.iemr.mmu.data.masterdata.anc;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.annotations.Expose;

@Entity
@Table(name = "m_childvaccination")
public class ChildVaccinations {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "VaccinationID")
	private Short vaccinationID;
	
	@Expose
	@Column(name = "VaccinationTime")
	private String vaccinationTime;
	
	@Expose
	@Column(name = "VaccineName")
	private String vaccineName;
	
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

	public ChildVaccinations(Short vaccinationID, String vaccinationTime, String vaccineName) {
		super();
		this.vaccinationID = vaccinationID;
		this.vaccinationTime = vaccinationTime;
		this.vaccineName = vaccineName;
	}
	
}