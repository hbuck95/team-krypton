package com.project.entity;

public class MobileCallRecordsEntity {

	private String timestamp;
	private String callerMSISDN;
	private String callCellTowerId;
	private String receiverMSISDN;
	private String TowerId;
	
	public MobileCallRecordsEntity() {
		
	}

	public MobileCallRecordsEntity(String timestamp, String callerMSISDN, String callCellTowerId, String receiverMSISDN,
			String towerId) {
		super();
		this.timestamp = timestamp;
		this.callerMSISDN = callerMSISDN;
		this.callCellTowerId = callCellTowerId;
		this.receiverMSISDN = receiverMSISDN;
		TowerId = towerId;
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

	public String getCallCellTowerId() {
		return callCellTowerId;
	}

	public void setCallCellTowerId(String callCellTowerId) {
		this.callCellTowerId = callCellTowerId;
	}

	public String getReceiverMSISDN() {
		return receiverMSISDN;
	}

	public void setReceiverMSISDN(String receiverMSISDN) {
		this.receiverMSISDN = receiverMSISDN;
	}

	public String getTowerId() {
		return TowerId;
	}

	public void setTowerId(String towerId) {
		TowerId = towerId;
	}
	
	
}
