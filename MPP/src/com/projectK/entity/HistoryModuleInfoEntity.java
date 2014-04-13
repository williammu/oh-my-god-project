package com.projectK.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.projectK.common.DomainObject;

@Entity
@Table(name = "historymoduleinfo_tbl")
public class HistoryModuleInfoEntity extends DomainObject {
	private PerfResMetaEntryEntity resMeta;
	private PerfModuleEntity moduleEntity;
	private Set<HistoryModulePlotEntity> plotEntries = new HashSet<HistoryModulePlotEntity>();
	
	@ManyToOne(cascade = {CascadeType.ALL})
	public PerfResMetaEntryEntity getResMeta() {
		return resMeta;
	}
	public void setResMeta(PerfResMetaEntryEntity resMeta) {
		this.resMeta = resMeta;
	}
	
	@ManyToOne
	@JoinColumn(name = "module_id")
	public PerfModuleEntity getModuleEntity() {
		return moduleEntity;
	}
	public void setModuleEntity(PerfModuleEntity moduleEntity) {
		this.moduleEntity = moduleEntity;
	}
	
	@OneToMany(mappedBy="historyModuleInfo", cascade = {CascadeType.ALL})
	@OrderBy("id")
	public Set<HistoryModulePlotEntity> getPlotEntries() {
		return plotEntries;
	}
	public void setPlotEntries(Set<HistoryModulePlotEntity> plotEntries) {
		this.plotEntries = plotEntries;
	}
	
	
}
