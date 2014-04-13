package com.projectK.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.projectK.common.DomainObject;

@Entity
@Table(name="case_tbl")
public class CaseEntity extends DomainObject {
	private String name;
	private String desc;
	private String steps;
	private int priority;
	private int version;
	private boolean isAutomated;
	private Set<CaseCompatibilityEntity> compatibility = new HashSet<CaseCompatibilityEntity>();
	private CaseEntity root = null;
	private ViewEntity view = null;
	private int visibilityStatus;
	private CaseGroupEntity caseGroup;
	private Set<PerfProjectEntity> perfProjects = new HashSet<PerfProjectEntity>();
	private Set<CaseEditHistoryEntryEntity> editEntries = new HashSet<CaseEditHistoryEntryEntity>();
	private PerfModuleEntity perfModuleEntity;
	private Set<PerfResAuxiliaryInfoEntity> perfResAuxiliaryInfos;
	
	@Column(name="name_col")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="desc_col",columnDefinition="LONGTEXT")
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Column(name="steps_col",columnDefinition="LONGTEXT")
	public String getSteps() {
		return steps;
	}
	public void setSteps(String steps) {
		this.steps = steps;
	}
	
	@Column(name="priority_col")
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	@Column(name="version_col")
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	
	@Column(name="isAutomated_col")
	public boolean isAutomated() {
		return isAutomated;
	}
	public void setAutomated(boolean isAutomated) {
		this.isAutomated = isAutomated;
	}
	
	@OneToMany(mappedBy="holder")
	@Cascade({CascadeType.ALL})
	@OrderBy("id")
	public Set<CaseCompatibilityEntity> getCompatibility() {
		return compatibility;
	}
	public void setCompatibility(Set<CaseCompatibilityEntity> compatibility) {
		this.compatibility = compatibility;
	}
	
	@ManyToOne
	@Cascade({CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.SAVE_UPDATE})
	public CaseGroupEntity getCaseGroup() {
		return caseGroup;
	}
	
	public void setCaseGroup(CaseGroupEntity caseGroup) {
		this.caseGroup = caseGroup;
	}
	
	
	@ManyToMany
	@Cascade({CascadeType.ALL})
	@JoinTable(name="project_case_tbl", 
			joinColumns = @JoinColumn(name = "case_id_col"),
			inverseJoinColumns = @JoinColumn(name = "perfproject_id_col"))
	@OrderBy("id")
	public Set<PerfProjectEntity> getPerfProjects() {
		return perfProjects;
	}
	public void setPerfProjects(Set<PerfProjectEntity> perfProjects) {
		this.perfProjects = perfProjects;
	}
	
	@OneToMany(mappedBy = "holderCase")
	@Cascade({CascadeType.ALL})
	@OrderBy("id")
	public Set<CaseEditHistoryEntryEntity> getEditEntries() {
		return editEntries;
	}
	public void setEditEntries(Set<CaseEditHistoryEntryEntity> editEntries) {
		this.editEntries = editEntries;
	}
	
	@ManyToOne
	@Cascade({CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.SAVE_UPDATE})
	public PerfModuleEntity getPerfModuleEntity() {
		return perfModuleEntity;
	}
	public void setPerfModuleEntity(PerfModuleEntity perfModuleEntity) {
		this.perfModuleEntity = perfModuleEntity;
	}
	
	@OneToMany(mappedBy = "caseEntity")
	@Cascade({CascadeType.ALL})
	@OrderBy("id")
	public Set<PerfResAuxiliaryInfoEntity> getPerfResAuxiliaryInfos() {
		return perfResAuxiliaryInfos;
	}
	public void setPerfResAuxiliaryInfos(
			Set<PerfResAuxiliaryInfoEntity> perfResAuxiliaryInfos) {
		this.perfResAuxiliaryInfos = perfResAuxiliaryInfos;
	}
	
	@ManyToOne(cascade = {javax.persistence.CascadeType.ALL})
	@JoinColumn(name = "root_col")
	public CaseEntity getRoot() {
		return root;
	}
	public void setRoot(CaseEntity root) {
		this.root = root;
	}
	
	@ManyToOne(cascade = {javax.persistence.CascadeType.ALL})
	public ViewEntity getView() {
		return view;
	}
	public void setView(ViewEntity view) {
		this.view = view;
	}
	
	@Column(name = "visibilitystatus_col", columnDefinition = "tinyint default 0")
	public int getVisibilityStatus() {
		return visibilityStatus;
	}
	public void setVisibilityStatus(int visibilityStatus) {
		this.visibilityStatus = visibilityStatus;
	}
	
	
	
}
