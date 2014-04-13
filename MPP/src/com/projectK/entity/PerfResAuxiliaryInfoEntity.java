package com.projectK.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.projectK.common.DomainObject;

@Entity
@Table(name = "perfresauxiliaryinfo_tbl")
public class PerfResAuxiliaryInfoEntity extends DomainObject {
	private CaseEntity caseEntity;
	private Date date;
	private String imei;
	private int status;
	private Set<PerfResultEntryEntity> resultEntries = new HashSet<PerfResultEntryEntity>();
	private PerfResMetaEntryEntity resMeta;
	private AuxiliaryDevEnvEntity runEnv;
	private Integer buildNum;
	private UserEntity personInCharge;
	private UserEntity dataCommitter;
	private String comments;
	
	@ManyToOne
	@Cascade({CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.SAVE_UPDATE})
	public CaseEntity getCaseEntity() {
		return caseEntity;
	}
	
	public void setCaseEntity(CaseEntity caseEntity) {
		this.caseEntity = caseEntity;
	}
	
	@Column(name = "date_col")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name = "imei_col")
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	
	@Column(name = "status_col")
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
	
	@OneToMany(mappedBy = "auxiliaryInfo")
	@Cascade({CascadeType.ALL})
	@OrderBy("id")
	public Set<PerfResultEntryEntity> getResultEntries() {
		return resultEntries;
	}
	public void setResultEntries(Set<PerfResultEntryEntity> resultEntries) {
		this.resultEntries = resultEntries;
	}
	@ManyToOne
	@Cascade({CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.SAVE_UPDATE})
	public PerfResMetaEntryEntity getResMeta() {
		return resMeta;
	}
	public void setResMeta(PerfResMetaEntryEntity resMeta) {
		this.resMeta = resMeta;
	}

	@ManyToOne(cascade = {javax.persistence.CascadeType.ALL})
	public AuxiliaryDevEnvEntity getRunEnv() {
		return runEnv;
	}

	public void setRunEnv(AuxiliaryDevEnvEntity runEnv) {
		this.runEnv = runEnv;
	}

	@Column(name = "buildnum_col")
	public Integer getBuildNum() {
		return buildNum;
	}

	public void setBuildNum(Integer buildNum) {
		this.buildNum = buildNum;
	}

	@ManyToOne(cascade = {javax.persistence.CascadeType.ALL})
	@JoinColumn(name = "persionincharge_col")
	public UserEntity getPersonInCharge() {
		return personInCharge;
	}

	public void setPersonInCharge(UserEntity personInCharge) {
		this.personInCharge = personInCharge;
	}

	@ManyToOne(cascade = {javax.persistence.CascadeType.ALL})
	@JoinColumn(name = "datacommitter_col")
	public UserEntity getDataCommitter() {
		return dataCommitter;
	}

	public void setDataCommitter(UserEntity dataCommitter) {
		this.dataCommitter = dataCommitter;
	}

	@Column(name = "comments_col", columnDefinition="LONGTEXT")
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	
	
}
