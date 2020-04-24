package com.qf.bean;

public class BinRequest {

	private int serviceID;
	private int binVolumn;
	private int binAmount;
	private String serviceType;

	public BinRequest() {
		super();
	}



	public BinRequest(int serviceID, int binVolumn, int binAmount, String serviceType) {
		super();
		this.serviceID = serviceID;
		this.binVolumn = binVolumn;
		this.binAmount = binAmount;
		this.serviceType = serviceType;
	}



	@Override
	public String toString() {
		return "BinRequest [serviceID=" + serviceID + ", binVolumn=" + binVolumn + ", binAmount=" + binAmount
				+ ", serviceType=" + serviceType + "]";
	}



	public String getServiceType() {
		return serviceType;
	}



	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}



	public int getServiceID() {
		return serviceID;
	}

	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}

	public int getBinVolumn() {
		return binVolumn;
	}

	public void setBinVolumn(int binVolumn) {
		this.binVolumn = binVolumn;
	}

	public int getBinAmount() {
		return binAmount;
	}

	public void setBinAmount(int binAmount) {
		this.binAmount = binAmount;
	}

}
