package com.projectK.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.projectK.common.DomainObject;


@Entity
@Table(name = "perfmoduleindex_tbl")
public class PerfModuleIndexEntity extends DomainObject {
	private String name;
	private String desc;
	private int type;
	private String unit;
	private PerfModuleEntity perfModuleEntity;
	private Set<PerfIndexFieldEntity> indexDescriptors = new HashSet<PerfIndexFieldEntity>();
	private Set<PerfModulePlotEntity> perfModulePlots = new HashSet<PerfModulePlotEntity>();
	
	@Column(name = "name_col")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "desc_col")
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	@Column(name = "type_col")
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	@ManyToOne
	@Cascade({CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.SAVE_UPDATE})
	public PerfModuleEntity getPerfModuleEntity() {
		return perfModuleEntity;
	}
	public void setPerfModuleEntity(PerfModuleEntity perfModuleEntity) {
		this.perfModuleEntity = perfModuleEntity;
	}
	
	@OneToMany(mappedBy = "perfModuleIndex")
	@Cascade({CascadeType.ALL})
	@OrderBy("id")
	public Set<PerfIndexFieldEntity> getIndexDescriptors() {
		return indexDescriptors;
	}
	public void setIndexDescriptors(Set<PerfIndexFieldEntity> indexDescriptors) {
		this.indexDescriptors = indexDescriptors;
	}
	
	@Column(name = "unit_col")
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public void setPerfModulePlots(Set<PerfModulePlotEntity> perfmodulePlots) {
		this.perfModulePlots = perfmodulePlots;
	}
	
	@ManyToMany(mappedBy = "indexCollections")
	@OrderBy("id")
	public Set<PerfModulePlotEntity> getPerfModulePlots() {
		return perfModulePlots;
	}
}
