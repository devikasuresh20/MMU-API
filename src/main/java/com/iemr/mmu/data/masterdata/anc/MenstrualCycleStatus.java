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
@Table(name = "m_menstrualcyclestatus")
public class MenstrualCycleStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Expose
	@Column(name = "MenstrualCycleStatusID")
	private Short menstrualCycleStatusID;
	
	@Expose
	@Column(name = "Name")
	private String name;
	
	@Expose
	@Column(name = "MenstrualCycleStatusDesc")
	private String menstrualCycleStatusDesc;
	
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

	public MenstrualCycleStatus(Short menstrualCycleStatusID, String name, String menstrualCycleStatusDesc) {
		super();
		this.menstrualCycleStatusID = menstrualCycleStatusID;
		this.name = name;
		this.menstrualCycleStatusDesc = menstrualCycleStatusDesc;
	}
	
}
