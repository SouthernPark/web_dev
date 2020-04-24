package com.qf.bean;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Resident {
	private int residentID;
	private String name;
	private String email;
	private Timestamp dateJoined;
	private String password;
	private int branchNo=1;
	private String address;
	private double latitude;
	private double longitude;
	private int binVolume;
	
	public Resident() {
		super();
	}
	public Resident(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public Resident(int residentID, String name, String email, Timestamp dateJoined, String password,
			String address, double latitude, double longitude, int binVolume) {
		super();
		this.residentID = residentID;
		this.name = name;
		this.email = email;
		this.dateJoined = dateJoined;
		this.password = password;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.binVolume = binVolume;
	}

	public Resident(String name, String email, Timestamp dateJoined, String password,
					String address, double latitude, double longitude, int binVolume) {
		super();
		this.name = name;
		this.email = email;
		this.dateJoined = dateJoined;
		this.password = password;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.binVolume = binVolume;
	}



	@Override
	public String toString() {
		return "Resident [residentID=" + residentID + ", name=" + name + ", email=" + email + ", dateJoined="
				+ dateJoined + ", password=" + password + ", branchNo=" + branchNo + ", address=" + address
				+ ", latitude=" + latitude + ", longitude=" + longitude + ", binVolumn=" + binVolume + "]";
	}

	
	public int getBinVolume() {
		return binVolume;
	}

	public void setBinVolume(int binVolume) {
		this.binVolume = binVolume;
	}

	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public double getLatitude() {
		return latitude;
	}



	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}


	public double getLongitude() {
		return longitude;
	}


	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public int getResidentID() {
		return residentID;
	}

	public void setResidentID(int residentID) {
		this.residentID = residentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(Timestamp dateJoined) {
		this.dateJoined = dateJoined;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getBranchNo() {
		return branchNo;
	}

	public void setBranchNo(int branchNo) {
		this.branchNo = branchNo;
	}
	
	
}
