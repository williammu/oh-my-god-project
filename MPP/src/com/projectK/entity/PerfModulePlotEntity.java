package com.projectK.entity;

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
@Table(name = "perfmoduleplot_tbl")
public class PerfModulePlotEntity extends DomainObject {
	private PerfModuleEntity perfModuleEntity;
	private int overViewType;
	private int plotType;
	private Set<PerfModuleIndexEntity> indexCollections;

	@ManyToOne
	@Cascade({CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.SAVE_UPDATE})
	public PerfModuleEntity getPerfModuleEntity() {
		return perfModuleEntity;
	}
	public void setPerfModuleEntity(PerfModuleEntity perfModuleEntity) {
		this.perfModuleEntity = perfModuleEntity;
	}
	
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
	@JoinTable(name="plot_index_tbl", 
			joinColumns = @JoinColumn(name = "plot_id_col"),
			inverseJoinColumns = @JoinColumn(name = "perfindex_id_col"))
	@OrderBy("id")
	public Set<PerfModuleIndexEntity> getIndexCollections() {
		return indexCollections;
	}
	
	public void setIndexCollections(Set<PerfModuleIndexEntity> indexCollections) {
		this.indexCollections = indexCollections;
	}
}
