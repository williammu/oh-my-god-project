package com.projectK.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.projectK.common.DomainObject;

@Entity
@Table(name = "casecompatibility_tbl")
public class CaseCompatibilityEntity extends DomainObject {
	private CaseEntity holder;
	private String prototype;
	private String sysVer;
	
	@ManyToOne
	@Cascade({CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.SAVE_UPDATE})
	public CaseEntity getHolder() {
		return holder;
	}
	public void setHolder(CaseEntity holder) {
		this.holder = holder;
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

}
