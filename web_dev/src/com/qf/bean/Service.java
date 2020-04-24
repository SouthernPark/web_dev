package com.qf.bean;

import java.sql.Date;
import java.sql.Timestamp;
public class Service {
	private int serviceID;
	private String serviceType;
	private Timestamp serviceDate;
	private int residentID;
	private String staffNo;
	private String serviceStatus;
	private String serviceAddress;

	public Service() {
		super();
	}



	public Service(int serviceID, String serviceType, Timestamp serviceDate, String serviceTerm, int residentID,
			String staffNo, String serviceStatus, String serviceAddress) {
		super();
		this.serviceID = serviceID;
		this.serviceType = serviceType;
		this.serviceDate = serviceDate;
		this.residentID = residentID;
		this.staffNo = staffNo;
		this.serviceStatus = serviceStatus;
		this.serviceAddress = serviceAddress;
	}



	@Override
	public String toString() {
		return "Service{" +
				"serviceID=" + serviceID +
				", serviceType='" + serviceType + '\'' +
				", serviceDate=" + serviceDate +
				", residentID=" + residentID +
				", staffNo='" + staffNo + '\'' +
				", serviceStatus='" + serviceStatus + '\'' +
				", serviceAddress='" + serviceAddress + '\'' +
				'}';
	}

	public String getStaffNo() {
		return staffNo;
	}



	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}



	public int getServiceID() {
		return serviceID;
	}

	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public Timestamp getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(Timestamp serviceDate) {
		this.serviceDate = serviceDate;
	}

	public int getResidentID() {
		return residentID;
	}

	public void setResidentID(int residentID) {
		this.residentID = residentID;
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public String getServiceAddress() {
		return serviceAddress;
	}

	public void setServiceAddress(String serviceAddress) {
		this.serviceAddress = serviceAddress;
	}
	
}
