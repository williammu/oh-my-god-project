package com.projectK.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.projectK.common.DomainObject;

@Entity
@Table(name = "historycompinfo_tbl")
public class HistoryCompInfoEntity extends DomainObject {
	private PerfResMetaEntryEntity srcResMeta;
	private PerfResMetaEntryEntity dstResMeta;
	
	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
	public PerfResMetaEntryEntity getSrcResMeta() {
		return srcResMeta;
	}
	public void setSrcResMeta(PerfResMetaEntryEntity srcResMeta) {
		this.srcResMeta = srcResMeta;
	}
	
	@ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "dstresmetaid_col")
	public PerfResMetaEntryEntity getDstResMeta() {
		return dstResMeta;
	}
	public void setDstResMeta(PerfResMetaEntryEntity dstResMeta) {
		this.dstResMeta = dstResMeta;
	}
	
	
}
