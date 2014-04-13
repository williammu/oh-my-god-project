package com.projectK.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.projectK.common.DomainObject;

@Entity
@Table(name="projectcompplotentry_tbl")
public class ProjectCompPlotEntryEntity extends DomainObject {
	private PerfProjectEntity srcProject;
	private PerfProjectEntity dstProject;
	private int runSeq;
	
	@ManyToOne
	@Cascade({CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
	public PerfProjectEntity getSrcProject() {
		return srcProject;
	}
	public void setSrcProject(PerfProjectEntity srcProject) {
		this.srcProject = srcProject;
	}
	
	@ManyToOne
	@Cascade({CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
	public PerfProjectEntity getDstProject() {
		return dstProject;
	}
	
	public void setDstProject(PerfProjectEntity dstProject) {
		this.dstProject = dstProject;
	}
	public int getRunSeq() {
		return runSeq;
	}
	public void setRunSeq(int runSeq) {
		this.runSeq = runSeq;
	}

}
