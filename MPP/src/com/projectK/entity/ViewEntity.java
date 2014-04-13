package com.projectK.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.projectK.common.DomainObject;

@Entity
@Table(name="viewentity_tbl")
public class ViewEntity extends DomainObject {
	private String name;
	private UserEntity modifier;
	private Date modifiedDate;
	private CaseGroupEntity groupRoot;
	private Set<CaseEntity> viewCases = new HashSet<CaseEntity>();
	private int visibilityStatus;
	
	@Column(name = "name_col")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@ManyToOne
	@JoinColumn(name = "modifier_id")
	public UserEntity getModifier() {
		return modifier;
	}
	public void setModifier(UserEntity modifier) {
		this.modifier = modifier;
	}
	
	@OneToMany(mappedBy = "view", cascade = {CascadeType.ALL})
	public Set<CaseEntity> getViewCases() {
		return viewCases;
	}
	public void setViewCases(Set<CaseEntity> viewCases) {
		this.viewCases = viewCases;
	}
	
	@Column(name = "modifiedDate_col")
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	
	@OneToOne
	@JoinColumn(name = "grouproot_col")
	public CaseGroupEntity getGroupRoot() {
		return groupRoot;
	}
	public void setGroupRoot(CaseGroupEntity groupRoot) {
		this.groupRoot = groupRoot;
	}
	
	@Column(name = "visibilitystatus_col", columnDefinition = "tinyint default 0")
	public int getVisibilityStatus() {
		return visibilityStatus;
	}
	public void setVisibilityStatus(int visibilityStatus) {
		this.visibilityStatus = visibilityStatus;
	}
}
