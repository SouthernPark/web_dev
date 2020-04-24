package com.qf.bean;

public class Vehicle {
	private int vehicleID;
	private String type;
	private int branchNo;
	
	public Vehicle() {
		super();
	}

	public Vehicle(int vehicleID, String type, int branchNo) {
		super();
		this.vehicleID = vehicleID;
		this.type = type;
		this.branchNo = branchNo;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleID=" + vehicleID + ", type=" + type + ", branchNo=" + branchNo + "]";
	}

	public int getVehicleID() {
		return vehicleID;
	}

	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getBranchNo() {
		return branchNo;
	}

	public void setBranchNo(int branchNo) {
		this.branchNo = branchNo;
	}
	
}
