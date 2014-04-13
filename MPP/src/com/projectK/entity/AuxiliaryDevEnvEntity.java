package com.projectK.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.projectK.common.DomainObject;

@Entity
@Table(name = "auxiliarydevenventity_tbl")
public class AuxiliaryDevEnvEntity extends DomainObject {
	private String deviceMac;
	private String deviceName;
	private String softwareVer;
	private String hardwareVer;
	private Set<PerfResAuxiliaryInfoEntity> allAuxiliaryInfo;
	
	@Column(name = "devicemac_col")
	public String getDeviceMac() {
		return deviceMac;
	}
	public void setDeviceMac(String deviceMac) {
		this.deviceMac = deviceMac;
	}
	@Column(name = "devicename_col")
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	
	@Column(name = "softwarever_col")
	public String getSoftwareVer() {
		return softwareVer;
	}
	public void setSoftwareVer(String softwareVer) {
		this.softwareVer = softwareVer;
	}
	@Column(name = "hardwarever_col")
	public String getHardwareVer() {
		return hardwareVer;
	}
	public void setHardwareVer(String hardwareVer) {
		this.hardwareVer = hardwareVer;
	}
	@OneToMany(mappedBy="runEnv", cascade = {CascadeType.ALL})
	public Set<PerfResAuxiliaryInfoEntity> getAllAuxiliaryInfo() {
		return allAuxiliaryInfo;
	}
	public void setAllAuxiliaryInfo(Set<PerfResAuxiliaryInfoEntity> allAuxiliaryInfo) {
		this.allAuxiliaryInfo = allAuxiliaryInfo;
	}

	
	
	
}
