package com.projectK.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.projectK.common.DomainObject;


@Entity
@Table(name = "userentity_tbl")
public class UserEntity extends DomainObject {
	private String userName;
	private String passHash; //md5
	private String nickName;
	private String token;//a random number hashed by md5
	private Date tokenExpireDate;
	private int identity;
	private String email;
	
	@Column(name = "username_col")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@Column(name = "passhash_col")
	public String getPassHash() {
		return passHash;
	}
	public void setPassHash(String passHash) {
		this.passHash = passHash;
	}
	@Column(name = "nickname_col")
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Column(name = "token_col")
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Column(name = "tokenexpiredate_col")
	public Date getTokenExpireDate() {
		return tokenExpireDate;
	}
	public void setTokenExpireDate(Date tokenExpireDate) {
		this.tokenExpireDate = tokenExpireDate;
	}
	
	@Column(name = "identity_col")
	public int getIdentity() {
		return identity;
	}
	public void setIdentity(int identity) {
		this.identity = identity;
	}
	
	@Column(name ="email_col")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
//	@Transient
//	public String getIdentityDesc()
//	{
//		if(identity == UserIdentityEnum.IDENTITY_VIEWER)
//			return "观察者";
//		else if(identity == UserIdentityEnum.IDENTITY_OPERATOR)
//			return "操作员";
//		else if(identity == UserIdentityEnum.IDENTITY_DICTATOR)
//			return "管理者";
//		else if(identity == UserIdentityEnum.IDENTITY_SUPERADMIN)
//			return "超级管理员";
//		else
//			return "不知哪根葱";
//	}
	
}
