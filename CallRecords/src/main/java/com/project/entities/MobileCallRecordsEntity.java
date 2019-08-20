package com.project.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mobileCallRecords_subset")
public class MobileCallRecordsEntity {

	private String timestamp;
	private String callerMSISDN;
	private int callCellTowerId;
	private String receiverMSISDN;
	private int receiverTowerId;

	public MobileCallRecordsEntity() {
		super();
	}

	public MobileCallRecordsEntity(String timestamp, String callerMSISDN, int callCellTowerId, String receiverMSISDN,
			int receiverTowerId) {
		super();
		this.timestamp = timestamp;
		this.callerMSISDN = callerMSISDN;
		this.callCellTowerId = callCellTowerId;
		this.receiverMSISDN = receiverMSISDN;
		this.receiverTowerId = receiverTowerId;
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

	public int getCallCellTowerId() {
		return callCellTowerId;
	}

	public void setCallCellTowerId(int callCellTowerId) {
		this.callCellTowerId = callCellTowerId;
	}

	public String getReceiverMSISDN() {
		return receiverMSISDN;
	}

	public void setReceiverMSISDN(String receiverMSISDN) {
		this.receiverMSISDN = receiverMSISDN;
	}

	public int getReceiverTowerId() {
		return receiverTowerId;
	}

	public void setReceiverTowerId(int receiverTowerId) {
		this.receiverTowerId = receiverTowerId;
	}

}
