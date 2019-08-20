package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.CellTowersEntity;
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
	

//	GET SubscriberRecords(forenames, surname)
//	return SubscriberRecords : SubscriberRecordsEntity

	@PostMapping("/subscriberEntityByForenameSurname")
	public List<SubscriberRecordsEntity> getSubscriberEntitybyForenameSurname(
			@RequestBody SubscriberRecordsEntity subscriberRecordEntity) {
		return srService.findByForenameSurname(subscriberRecordEntity);

	}

//	GET MobileCallRecords(Caller MSISDN)
//	return Matching MSISDN's : List <CallRecordEntity>

	@PostMapping("/mobileCallRecordsMSISDN")
	public List<MobileCallRecordsEntity> getMobileCallRecordByMSISDN(
			@RequestBody MobileCallRecordsEntity mobileCallRecordsEntity) {
		return mcrService.findByMSISDN(mobileCallRecordsEntity);
	}

	

//	Get CellTowerEntity(towerId)
//	return List<CellTowerEntity>

	@PostMapping("/cellTowerById")
	public List<CellTowersEntity> getCellTowersEntityById(@RequestBody CellTowersEntity cellTowerEntity) {
		return ctService.findById(cellTowerEntity);
	}

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

//			get CallRecords(receiverMSISDN)
//			return List<callRecordEntity>

	@PostMapping("/callRecordsByReceiverMSISDN")
	public List<MobileCallRecordsEntity> getCallRecordByReceiverMSISDN(
			@RequestBody MobileCallRecordsEntity mobileCallRecordsEntity) {
		return mcrService.findByRecieverMSISDN(mobileCallRecordsEntity);
	}

//	GetSubscriberRecords(forenames, surname, dateOfBirth, address)
//	return SubscriberRecordEntity	

	@PostMapping("/subscriberEntityByForenameSurnameDoBAdd")
	public List<SubscriberRecordsEntity> getSubscriberEntitybyForenameSurnameDoBAdd(
			@RequestBody SubscriberRecordsEntity subscriberRecordEntity) {
		return srService.findByForenameSurnameDoBAdd(subscriberRecordEntity);

	}


}
