package com.projectK.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.projectK.common.DomainObject;


@Entity
@Table(name = "perfresultentry_tbl")
public class PerfResultEntryEntity extends DomainObject {
	private String indexValue;
	private PerfResAuxiliaryInfoEntity auxiliaryInfo;
	private PerfModuleIndexEntity perfIndex;
	
	@ManyToOne
	@Cascade({CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.SAVE_UPDATE})
	public PerfModuleIndexEntity getPerfIndex() {
		return perfIndex;
	}
	public void setPerfIndex(PerfModuleIndexEntity perfIndex) {
		this.perfIndex = perfIndex;
	}
	@Column(name = "indexvalue_col",columnDefinition="LONGTEXT")
	public String getIndexValue() {
		return indexValue;
	}
	public void setIndexValue(String indexValue) {
		this.indexValue = indexValue;
	}
	
	@ManyToOne
	@Cascade({CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.SAVE_UPDATE})
	public PerfResAuxiliaryInfoEntity getAuxiliaryInfo() {
		return auxiliaryInfo;
	}
	public void setAuxiliaryInfo(PerfResAuxiliaryInfoEntity auxiliaryInfo) {
		this.auxiliaryInfo = auxiliaryInfo;
	}
}
