package com.projectK.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.projectK.common.DomainObject;

@Entity
@Table(name = "perfmoduleentity_tbl")
public class PerfModuleEntity extends DomainObject {

	private String moduleName;
	private String moduleDesc;
	private Set<PerfModuleIndexEntity> moduleIndices = new HashSet<PerfModuleIndexEntity>();
	private Set<CaseEntity> moduleCases = new HashSet<CaseEntity>();
	private Set<PerfModulePlotEntity> plotEntries = new HashSet<PerfModulePlotEntity>();
	
	@Column(name = "modulename_col")
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	@Column(name = "moduledesc_col")
	public String getModuleDesc() {
		return moduleDesc;
	}
	public void setModuleDesc(String moduleDesc) {
		this.moduleDesc = moduleDesc;
	}
	
	@OneToMany(mappedBy = "perfModuleEntity")
	@Cascade({CascadeType.ALL})
	@OrderBy("id")
	public Set<PerfModuleIndexEntity> getModuleIndices() {
		return moduleIndices;
	}
	public void setModuleIndices(Set<PerfModuleIndexEntity> moduleIndices) {
		this.moduleIndices = moduleIndices;
	}
	
	@OneToMany(mappedBy = "perfModuleEntity")
	@Cascade({CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.SAVE_UPDATE})
	@OrderBy("id")
	public Set<CaseEntity> getModuleCases() {
		return moduleCases;
	}
	public void setModuleCases(Set<CaseEntity> moduleCases) {
		this.moduleCases = moduleCases;
	}
	
	@OneToMany(mappedBy = "perfModuleEntity")
	@Cascade({CascadeType.ALL})
	@OrderBy("id")
	public Set<PerfModulePlotEntity> getPlotEntries() {
		return plotEntries;
	}
	
	public void setPlotEntries(Set<PerfModulePlotEntity> plotEntries) {
		this.plotEntries = plotEntries;
	}
	
}
