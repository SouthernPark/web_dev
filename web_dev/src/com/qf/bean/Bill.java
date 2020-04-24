package com.qf.bean;

public class Bill {
	private int billNo;
	private double amount;
	private int serviceID;
	
	
	public Bill() {
		super();
	}

	public Bill(int billNo,double amount, int serviceID) {
		super();
		this.billNo = billNo;
		this.amount = amount;
		this.serviceID = serviceID;
	}

	@Override
	public String toString() {
		return "Bill [billNo=" + billNo + ", amount=" + amount + ", serviceID=" + serviceID + "]";
	}

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getServiceID() {
		return serviceID;
	}

	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}
	
	
	
	
	
}
