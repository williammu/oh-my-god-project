package com.projectK.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.projectK.common.DomainObject;

@Entity
@Table(name = "svncredentialentity_tbl")
public class SVNCredentialEntity extends DomainObject {
	private String username;
	private String password; 
	private String commonSVN;
	
	@Column(name = "username_col")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Column(name = "password_col")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "commonsvn_col")
	public String getCommonSVN() {
		return commonSVN;
	}
	public void setCommonSVN(String commonSVN) {
		this.commonSVN = commonSVN;
	}
	
	
	
}
