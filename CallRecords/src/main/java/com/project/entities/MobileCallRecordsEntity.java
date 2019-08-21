package com.project.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mobileCallRecords")
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



	public String getCallerMSISDN() {
		return callerMSISDN;
	}



	public String getReceiverMSISDN() {
		return receiverMSISDN;
	}



}
