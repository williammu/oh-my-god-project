package com.projectK.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.projectK.common.DomainObject;

@Entity
@Table(name = "deviceentity_tbl")
public class DeviceEntity extends DomainObject {
	private String deviceMac;
	private String deviceName;
	private int deviceState;
	private String currentRunningCase;
	private String softwareVer;
	private String hardwareVer;
	private String jobURL;
	private HostEntity host;
	private Date lastHeartBeatTime;
	
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
	@Column(name = "devicestate_col")
	public int getDeviceState() {
		return deviceState;
	}
	public void setDeviceState(int deviceState) {
		this.deviceState = deviceState;
	}
	@Column(name = "currentrunningcase_col")
	public String getCurrentRunningCase() {
		return currentRunningCase;
	}
	public void setCurrentRunningCase(String currentRunningCase) {
		this.currentRunningCase = currentRunningCase;
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
	@Column(name = "joburl_col")
	public String getJobURL() {
		return jobURL;
	}
	public void setJobURL(String jobURL) {
		this.jobURL = jobURL;
	}
	@ManyToOne(cascade = {CascadeType.ALL})
	public HostEntity getHost() {
		return host;
	}
	public void setHost(HostEntity host) {
		this.host = host;
	}
	@Column(name = "lastheartbeattime_col")
	public Date getLastHeartBeatTime() {
		return lastHeartBeatTime;
	}
	public void setLastHeartBeatTime(Date lastHeartBeatTime) {
		this.lastHeartBeatTime = lastHeartBeatTime;
	}
	
	
	
}
