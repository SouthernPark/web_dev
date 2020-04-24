package com.qf.bean;

public class Driver {
	private String staffNo;
	private String carAllowance;
	private String workState;
	private String taskForDriver;
	
	public Driver() {
		super();
	}

	public Driver(String staffNo, String carAllowance, String workState, String taskForDriver) {
		super();
		this.staffNo = staffNo;
		this.carAllowance = carAllowance;
		this.workState = workState;
		this.taskForDriver = taskForDriver;
	}

	@Override
	public String toString() {
		return "Driver [staffNo=" + staffNo + ", carAllowance=" + carAllowance + ", workState=" + workState
				+ ", taskForDriver=" + taskForDriver + "]";
	}


	public String getTaskForDriver() {
		return taskForDriver;
	}


	public void setTaskForDriver(String taskForDriver) {
		this.taskForDriver = taskForDriver;
	}


	public String getStaffNo() {
		return staffNo;
	}

	public void setStaffNo(String staffNo) {
		this.staffNo = staffNo;
	}

	public String getCarAllowance() {
		return carAllowance;
	}

	public void setCarAllowance(String carAllowance) {
		this.carAllowance = carAllowance;
	}

	public String getWorkState() {
		return workState;
	}

	public void setWorkState(String workState) {
		this.workState = workState;
	}
	
	
}
