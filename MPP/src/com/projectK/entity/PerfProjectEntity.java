package com.projectK.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.projectK.common.DomainObject;

@Entity
@Table(name = "perfproject_tbl")
public class PerfProjectEntity extends DomainObject{
	private String projectName;
	private String prototype;
	private String sysVer;
	private String projectDesc;
	private Set<CaseEntity> projectCases = new HashSet<CaseEntity>();
	private Set<ProjectCompPlotEntryEntity> compPlotEntries = new HashSet<ProjectCompPlotEntryEntity>();
	private Set<PerfResMetaEntryEntity> runRecord = new HashSet<PerfResMetaEntryEntity>();;
	private String hash;
	private String autoCaseSVN;
	private ViewEntity view;
	
	@Column(name = "projectname_col")
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	@Column(name = "prototype_col")
	public String getPrototype() {
		return prototype;
	}
	public void setPrototype(String prototype) {
		this.prototype = prototype;
	}
	
	@Column(name = "sysver_col")
	public String getSysVer() {
		return sysVer;
	}
	public void setSysVer(String sysVer) {
		this.sysVer = sysVer;
	}
	
	@Column(name = "projectdesc_col",columnDefinition="LONGTEXT")
	public String getProjectDesc() {
		return projectDesc;
	}
	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}
	
	@ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "perfProjects")
	@OrderBy("id")
	public Set<CaseEntity> getProjectCases() {
		return projectCases;
	}
	public void setProjectCases(Set<CaseEntity> projectCases) {
		this.projectCases = projectCases;
	} 

	@OneToMany(mappedBy = "srcProject", cascade = {CascadeType.ALL})
	@OrderBy("dstProject")
	public Set<ProjectCompPlotEntryEntity> getCompPlotEntries() {
		return compPlotEntries;
	}
	public void setCompPlotEntries(Set<ProjectCompPlotEntryEntity> compPlotEntries) {
		this.compPlotEntries = compPlotEntries;
	}
	@OneToMany(mappedBy="perfProject", cascade = CascadeType.ALL)
	@OrderBy("id")
	public Set<PerfResMetaEntryEntity> getRunRecord() {
		return runRecord;
	}
	public void setRunRecord(Set<PerfResMetaEntryEntity> runRecord) {
		this.runRecord = runRecord;
	}
	
	@Column(name = "hash_col")
	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}
	@Column(name = "autocasesvn_col")
	public String getAutoCaseSVN() {
		return autoCaseSVN;
	}
	public void setAutoCaseSVN(String autoCaseSVN) {
		this.autoCaseSVN = autoCaseSVN;
	}
	
	@ManyToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "viewid_col")
	public ViewEntity getView() {
		return view;
	}
	public void setView(ViewEntity view) {
		this.view = view;
	}
	
	
}
