package com.projectK.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.projectK.common.DomainObject;

@Entity
@Table(name = "historycaseidmap_tbl")
public class HistoryCaseIDMapEntryEntity extends DomainObject {
	private PerfResMetaEntryEntity resMeta;
	private int currentStateCaseID;
	private int historyStateCaseID;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	public PerfResMetaEntryEntity getResMeta() {
		return resMeta;
	}
	public void setResMeta(PerfResMetaEntryEntity resMeta) {
		this.resMeta = resMeta;
	}
	@Column(name = "currentstatecaseid_col")
	public int getCurrentStateCaseID() {
		return currentStateCaseID;
	}
	public void setCurrentStateCaseID(int currentStateCaseID) {
		this.currentStateCaseID = currentStateCaseID;
	}
	@Column(name = "historystatecaseid_col")
	public int getHistoryStateCaseID() {
		return historyStateCaseID;
	}
	public void setHistoryStateCaseID(int historyStateCaseID) {
		this.historyStateCaseID = historyStateCaseID;
	}
	
	
}
