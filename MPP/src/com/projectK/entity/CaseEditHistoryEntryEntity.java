package com.projectK.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.projectK.common.DomainObject;

@Entity
@Table(name = "caseedithistory_tbl")
public class CaseEditHistoryEntryEntity extends DomainObject {
	private CaseEntity holderCase;
	private String reviser;
	private int caseVer;
	private Date date;

	
	@ManyToOne
	@Cascade({CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.SAVE_UPDATE})
	public CaseEntity getHolderCase() {
		return holderCase;
	}
	public void setHolderCase(CaseEntity holderCase) {
		this.holderCase = holderCase;
	}
	
	@Column(name = "reviser_col")
	public String getReviser() {
		return reviser;
	}
	public void setReviser(String reviser) {
		this.reviser = reviser;
	}
	
	@Column(name = "casever_col")
	public int getCaseVer() {
		return caseVer;
	}
	public void setCaseVer(int caseVer) {
		this.caseVer = caseVer;
	}
	
	@Column(name = "date_col")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
