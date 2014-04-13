package com.projectK.entity;

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
@Table(name="perfresmetaentry_tbl")
public class PerfResMetaEntryEntity extends DomainObject {
	private PerfProjectEntity perfProject;
	private int curStateProjectID;
	private Set<PerfResAuxiliaryInfoEntity> auxiliaryInfo = new HashSet<PerfResAuxiliaryInfoEntity>();
	private int runSeq;
	private String desc;
	private int status;
	private boolean visible = true;
	private Set<HistoryCompInfoEntity> allHistoryCompInfo = new HashSet<HistoryCompInfoEntity>();
	private Set<HistoryModuleInfoEntity> allHistoryModuleInfo = new HashSet<HistoryModuleInfoEntity>();
	private Set<HistoryCaseIDMapEntryEntity> caseIDMap = new HashSet<HistoryCaseIDMapEntryEntity>();
	private UserEntity runner;
	
	@ManyToOne
	@Cascade({CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.SAVE_UPDATE})
	public PerfProjectEntity getPerfProject() {
		return perfProject;
	}
	public void setPerfProject(PerfProjectEntity perfProject) {
		this.perfProject = perfProject;
	}
	@Column(name = "runseq_col")
	public int getRunSeq() {
		return runSeq;
	}
	public void setRunSeq(int runSeq) {
		this.runSeq = runSeq;
	}
	@Column(name = "desc_col")
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	@Column(name = "status_col")
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@OneToMany(mappedBy="resMeta")
	@Cascade({CascadeType.ALL})
	@OrderBy("id")
	public Set<PerfResAuxiliaryInfoEntity> getAuxiliaryInfo() {
		return auxiliaryInfo;
	}
	public void setAuxiliaryInfo(Set<PerfResAuxiliaryInfoEntity> auxiliaryInfo) {
		this.auxiliaryInfo = auxiliaryInfo;
	}
	
	@Column(name = "visible_col")
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	@OneToMany(mappedBy="srcResMeta", cascade = {javax.persistence.CascadeType.ALL})
	@OrderBy("dstResMeta")
	public Set<HistoryCompInfoEntity> getAllHistoryCompInfo() {
		return allHistoryCompInfo;
	}
	public void setAllHistoryCompInfo(Set<HistoryCompInfoEntity> allHistoryCompInfo) {
		this.allHistoryCompInfo = allHistoryCompInfo;
	}
	
	@OneToMany(mappedBy="resMeta", cascade = {javax.persistence.CascadeType.ALL})
	@javax.persistence.OrderBy("moduleEntity")
	public Set<HistoryModuleInfoEntity> getAllHistoryModuleInfo() {
		return allHistoryModuleInfo;
	}
	public void setAllHistoryModuleInfo(
			Set<HistoryModuleInfoEntity> allHistoryModuleInfo) {
		this.allHistoryModuleInfo = allHistoryModuleInfo;
	}
	
	@OneToMany(mappedBy="resMeta", cascade = {javax.persistence.CascadeType.ALL})
	@OrderBy("currentStateCaseID")
	public Set<HistoryCaseIDMapEntryEntity> getCaseIDMap() {
		return caseIDMap;
	}
	public void setCaseIDMap(Set<HistoryCaseIDMapEntryEntity> caseIDMap) {
		this.caseIDMap = caseIDMap;
	}
	
	@ManyToOne(cascade = {javax.persistence.CascadeType.ALL})
	@JoinColumn(name = "runner_col")
	public UserEntity getRunner() {
		return runner;
	}
	public void setRunner(UserEntity runner) {
		this.runner = runner;
	}
	
	@Column(name = "curstateprojectid_col", columnDefinition = "int default 0")
	public int getCurStateProjectID() {
		return curStateProjectID;
	}
	public void setCurStateProjectID(int curStateProjectID) {
		this.curStateProjectID = curStateProjectID;
	}
}
