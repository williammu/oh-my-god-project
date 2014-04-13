package com.projectK.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.projectK.common.DomainObject;

@Entity
@Table(name = "perfindexfield_tbl")
public class PerfIndexFieldEntity extends DomainObject {
	private PerfModuleIndexEntity perfModuleIndex;
	private String fieldName;
	private String fieldDesc;
	
	@ManyToOne
	@Cascade({CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.SAVE_UPDATE})
	public PerfModuleIndexEntity getPerfModuleIndex() {
		return perfModuleIndex;
	}
	public void setPerfModuleIndex(PerfModuleIndexEntity perfModuleIndex) {
		this.perfModuleIndex = perfModuleIndex;
	}
	
	@Column(name = "fieldname_col")
	public String getFieldName() {
		return fieldName;
	}
	public void setFieldName(String field_name) {
		this.fieldName = field_name;
	}
	
	@Column(name = "fielddesc_col")
	public String getFieldDesc() {
		return fieldDesc;
	}
	public void setFieldDesc(String filed_desc) {
		this.fieldDesc = filed_desc;
	}
	
}
