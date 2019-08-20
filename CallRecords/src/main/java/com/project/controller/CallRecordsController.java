package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.MobileCallRecordsEntity;
import com.project.entity.SubscriberRecordsEntity;
import com.project.service.CellTowersService;
import com.project.service.MobileCallRecordsService;
import com.project.service.SubscriberRecordsService;

@RestController
@RequestMapping("/CallRecords")
public class CallRecordsController {

	private CellTowersService ctService;
	private MobileCallRecordsService mcrService;
	private SubscriberRecordsService srService;

	@Autowired
	public CallRecordsController(CellTowersService ctService, MobileCallRecordsService mcrService,
			SubscriberRecordsService srService) {
		this.ctService = ctService;
		this.mcrService = mcrService;
		this.srService = srService;

	}

//	get CellTowers(Lat,long,time,range)
//	return List<CellTowerEntities>


	
	
	
	
	
//	get MobileCallRecords(cellTowerId, time)
//	return List<CallRecordsEntities>

	@PostMapping("/mobileCallRecords")
	public List<MobileCallRecordsEntity> getMobileCallRecords(
			@RequestBody MobileCallRecordsEntity mobileCallRecordsEntity) {
		return mcrService.findById(mobileCallRecordsEntity);
	}

	
	
	
//	get SubscriberRecords(callerMSISDN)
//	return List<SusbscriberRecordEntity>

	@PostMapping("/SubscriberRecords")
	public List<SubscriberRecordsEntity> getSubscriberRecords(
			@RequestBody SubscriberRecordsEntity subcriberRecordsEntity) {

		return srService.findByPhoneNumber(subcriberRecordsEntity);

	}

//	GET SubscriberRecords(firstnames, surname)
//	return SubscriberRecords : SubscriberRecordsEntity

//	GET MobileCallRecords(Caller MSISDN)
//	return Matching MSISDN's : List <CallRecordEntity>
//			

//			GET SubscriberRecords(Reciever MSISDN)
//			Return Subscriber Record Entity : List <CitizenEntity>

//			
//			get CallRecords(MSISDN)
//			return List<callRecordEntity>
//			
//			Get CellTowerEntity(towerId)
//			return List<CellTowerEntity>
//		

//	
//	
//	GetSubscriberRecords(forenames, surname, dateOfBirth, address)
//	return SubscriberRecordEntity

//	getCallRecords(phoneNumber)
//	return List<CallRecordEntity>
//	
//	get CellTowerEntity(towerId)
//	return List<CellTowerEntity>

}
