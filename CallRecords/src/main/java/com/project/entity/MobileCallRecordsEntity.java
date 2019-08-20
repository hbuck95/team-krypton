package com.project.entity;

public class MobileCallRecordsEntity {

	private String timestamp;
	private String callerMSISDN;
	private Integer callCellTowerId;
	private String receiverMSISDN;
	private String towerId;
	
	public MobileCallRecordsEntity() {
		
	}

	public MobileCallRecordsEntity(String timestamp, String callerMSISDN, Integer callCellTowerId, String receiverMSISDN,
			String towerId) {
		super();
		this.timestamp = timestamp;
		this.callerMSISDN = callerMSISDN;
		this.callCellTowerId = callCellTowerId;
		this.receiverMSISDN = receiverMSISDN;
		this.towerId = towerId;
	}

	public String getTowerId() {
		return towerId;
	}

	public void setTowerId(String towerId) {
		this.towerId = towerId;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getCallerMSISDN() {
		return callerMSISDN;
	}

	public void setCallerMSISDN(String callerMSISDN) {
		this.callerMSISDN = callerMSISDN;
	}

	public Integer getCallCellTowerId() {
		return callCellTowerId;
	}

	public void setCallCellTowerId(Integer callCellTowerId) {
		this.callCellTowerId = callCellTowerId;
	}

	public String getReceiverMSISDN() {
		return receiverMSISDN;
	}

	public void setReceiverMSISDN(String receiverMSISDN) {
		this.receiverMSISDN = receiverMSISDN;
	}

	
}
