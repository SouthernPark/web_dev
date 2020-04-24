package com.qf.bean;

public class Branch {
	private int branchNo;
	private String address;
	private String zip;
	private int telNo;
	private String recyclingCenterAddress;
	
	public Branch() {
		super();
	}

	public Branch(int branchNo, String address, String zip, int telNo, String recyclingCenterAddress) {
		super();
		this.branchNo = branchNo;
		this.address = address;
		this.zip = zip;
		this.telNo = telNo;
		this.recyclingCenterAddress = recyclingCenterAddress;
	}

	@Override
	public String toString() {
		return "Branch [branchNo=" + branchNo + ", address=" + address + ", zip=" + zip + ", telNo=" + telNo
				+ ", recyclingCenterAddress=" + recyclingCenterAddress + "]";
	}

	public int getBranchNo() {
		return branchNo;
	}

	public void setBranchNo(int branchNo) {
		this.branchNo = branchNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public int getTelNo() {
		return telNo;
	}

	public void setTelNo(int telNo) {
		this.telNo = telNo;
	}

	public String getRecyclingCenterAddress() {
		return recyclingCenterAddress;
	}

	public void setRecyclingCenterAddress(String recyclingCenterAddress) {
		this.recyclingCenterAddress = recyclingCenterAddress;
	}
	
	
}
