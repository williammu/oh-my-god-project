package com.projectK.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.projectK.common.DomainObject;

@Entity
@Table(name = "hostentity_tbl")
public class HostEntity extends DomainObject {
	private String hostName;
	private String hostOS;
	private String hostMac;
	private String hostIP;
	private Set<DeviceEntity> deviceInfo;
	@Column(name = "hostname_col")
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	@Column(name = "hostos_col")
	public String getHostOS() {
		return hostOS;
	}
	public void setHostOS(String hostOS) {
		this.hostOS = hostOS;
	}
	@Column(name = "hostmac_col")
	public String getHostMac() {
		return hostMac;
	}
	public void setHostMac(String hostMac) {
		this.hostMac = hostMac;
	}
	@Column(name = "hostip_col")
	public String getHostIP() {
		return hostIP;
	}
	public void setHostIP(String hostIP) {
		this.hostIP = hostIP;
	}
	@OneToMany(mappedBy = "host", cascade = {CascadeType.ALL})
	public Set<DeviceEntity> getDeviceInfo() {
		return deviceInfo;
	}
	public void setDeviceInfo(Set<DeviceEntity> deviceInfo) {
		this.deviceInfo = deviceInfo;
	}
	
	

}
