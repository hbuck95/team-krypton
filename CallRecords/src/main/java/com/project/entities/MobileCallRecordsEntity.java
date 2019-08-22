package com.project.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mobilecallrecords")
public class MobileCallRecordsEntity {

	private String timestamp;
	private String callerMSISDN;
	private String callCellTowerId;
	private String receiverMSISDN;
	private String receiverTowerId;

	public MobileCallRecordsEntity() {

		super();
	}

	public MobileCallRecordsEntity(String timestamp, String callerMSISDN, String callCellTowerId, String receiverMSISDN,
			String receiverTowerId) {
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

	public String getCallCellTowerId() {
		return callCellTowerId;
	}

	public void setCallCellTowerId(String callCellTowerId) {
		this.callCellTowerId = callCellTowerId;
	}

	public String getReceiverTowerId() {
		return receiverTowerId;
	}

	public void setReceiverTowerId(String receiverTowerId) {
		this.receiverTowerId = receiverTowerId;
	}

	public void setCallerMSISDN(String callerMSISDN) {
		this.callerMSISDN = callerMSISDN;
	}

	public void setReceiverMSISDN(String receiverMSISDN) {
		this.receiverMSISDN = receiverMSISDN;
	}

	public String getCallerMSISDN() {
		return callerMSISDN;
	}

	public String getReceiverMSISDN() {
		return receiverMSISDN;
	}

}
