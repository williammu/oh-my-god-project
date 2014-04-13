package com.projectK.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.projectK.common.DomainObject;

@Entity
@Table(name = "historymoduleplot_tbl")
public class HistoryModulePlotEntity extends DomainObject {
	private int overViewType;
	private int plotType;
	private HistoryModuleInfoEntity historyModuleInfo;
	private Set<PerfModuleIndexEntity> indexCollections = new HashSet<PerfModuleIndexEntity>();
	
	@Column(name = "overviewtype_col")
	public int getOverViewType() {
		return overViewType;
	}
	public void setOverViewType(int overViewType) {
		this.overViewType = overViewType;
	}
	
	@Column(name = "plottype_col")
	public int getPlotType() {
		return plotType;
	}
	public void setPlotType(int plotType) {
		this.plotType = plotType;
	}
	
	@ManyToMany
	@Cascade({CascadeType.ALL})
	@JoinTable(name="history_plot_index_tbl", 
			joinColumns = @JoinColumn(name = "history_plot_id_col"),
			inverseJoinColumns = @JoinColumn(name = "perfindex_id_col"))
	@OrderBy("id")
	public Set<PerfModuleIndexEntity> getIndexCollections() {
		return indexCollections;
	}
	
	public void setIndexCollections(Set<PerfModuleIndexEntity> indexCollections) {
		this.indexCollections = indexCollections;
	}
	
	@ManyToOne
	@Cascade({CascadeType.ALL})
	public HistoryModuleInfoEntity getHistoryModuleInfo() {
		return historyModuleInfo;
	}
	public void setHistoryModuleInfo(HistoryModuleInfoEntity historyModuleInfo) {
		this.historyModuleInfo = historyModuleInfo;
	}
	
	
}
