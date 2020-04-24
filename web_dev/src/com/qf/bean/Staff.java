package com.qf.bean;

public class Staff {
	private String staffNo;
	private String name;
	private String position;
	private double salary;
	private int phoneNo;
	private int branchNo;
	private String password;
	
	public Staff() {
		super();
	}

	
	public Staff(String staffNo, String name, String position, double salary, int phoneNo, int branchNo, String password) {
		super();
		this.staffNo = staffNo;
		this.name = name;
		this.position = position;
		this.salary = salary;
		this.phoneNo = phoneNo;
		this.branchNo = branchNo;
		this.password = password;
	}


	@Override
	public String toString() {
		return "Staff [staffNo=" + staffNo + ", name=" + name + ", position=" + position + ", salary=" + salary
				+ ", phoneNo=" + phoneNo + ", branchNo=" + branchNo + ", password=" + password + "]";
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getStaffNo() {
		return staffNo;
	}

	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getBranchNo() {
		return branchNo;
	}

	public void setBranchNo(int branchNo) {
		this.branchNo = branchNo;
	}
	
	
}
