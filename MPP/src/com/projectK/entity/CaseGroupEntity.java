package com.projectK.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import com.projectK.common.DomainObject;

@Entity
@Table(name = "casegroup_tbl")
public class CaseGroupEntity extends DomainObject {
	private CaseGroupEntity parentGroup;
	
	private String groupDesc;
	private Set<CaseGroupEntity> childrenCaseGroup;
	private Set<CaseEntity> holderCases;
	private int visibilityStatus;
	
	@ManyToOne()
	@JoinColumn(name = "pid")
	public CaseGroupEntity getParentGroup() {
		return parentGroup;
	}
	
	public void setParentGroup(CaseGroupEntity parentGroup) {
		this.parentGroup = parentGroup;
	}
	
	@Column(name = "groupdesc_col")
	public String getGroupDesc() {
		return groupDesc;
	}
	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}
	
	@OneToMany(mappedBy="caseGroup", cascade = {CascadeType.ALL})
	@OrderBy("id")
	public Set<CaseEntity> getHolderCases() {
		return holderCases;
	}
	
	public void setHolderCases(Set<CaseEntity> holderCases) {
		this.holderCases = holderCases;
	}

	public void setChildrenCaseGroup(Set<CaseGroupEntity> childrenCaseGroup) {
		this.childrenCaseGroup = childrenCaseGroup;
	}

	@OneToMany(mappedBy="parentGroup")
	@OrderBy("id")
	public Set<CaseGroupEntity> getChildrenCaseGroup() {
		return childrenCaseGroup;
	}
	
	@Column(name = "visibilitystatus_col", columnDefinition = "tinyint default 0")
	public int getVisibilityStatus() {
		return visibilityStatus;
	}
	public void setVisibilityStatus(int visibilityStatus) {
		this.visibilityStatus = visibilityStatus;
	}
	

}
