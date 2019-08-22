package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.CellTowerEntity;
import com.project.entities.MobileCallRecordsEntity;
import com.project.entities.PeopleMobileEntity;
import com.project.service.CellTowerService;
import com.project.service.MobileCallRecordsService;
import com.project.service.PeopleMobileService;

@RestController
@RequestMapping("/call")
public class CallRecordsController {

	private CellTowerService ctService;
	private MobileCallRecordsService mcrService;
	private PeopleMobileService pmService;

	@Autowired
	public CallRecordsController(CellTowerService ctService, MobileCallRecordsService mcrService,
			PeopleMobileService pmService) {
		this.ctService = ctService;
		this.mcrService = mcrService;
		this.pmService = pmService;
	}

	@PostMapping("/getAssociatesByCallRecord")
	public List<PeopleMobileEntity> getAssoicatesByCallRecord(@RequestBody String phoneNumber) {
		List<MobileCallRecordsEntity> suspectCallRecords = mcrService.getCallRecordsOfSuspect(phoneNumber);
		return pmService.getAssociate(suspectCallRecords);
	}
//
//	@PostMapping("/getCallRecordsOfSuspect")
//	public List<MobileCallRecordsEntity> getCallRecordsOfSuspect(
//			@RequestBody MobileCallRecordsEntity mobileCallRecordsEntity) {
//		return mcrService.getCallRecordsOfSuspect(mobileCallRecordsEntity);
//	}
//
//	@PostMapping("/getCallRecordsOfAssociate")
//	public List<MobileCallRecordsEntity> getCallRecordsOfAssociate(
//			@RequestBody MobileCallRecordsEntity mobileCallRecordsEntity) {
//		return mcrService.getCallRecordsOfAssociate(mobileCallRecordsEntity);
//	}

	@PostMapping("/getAssosiate")
	public List<PeopleMobileEntity> getAssociate(@RequestBody List<MobileCallRecordsEntity> mobileCallRecordsEntity) {
		return pmService.getAssociate(mobileCallRecordsEntity);
	}

	@PostMapping("/getCellTower")
	public CellTowerEntity getCellTower(@RequestBody CellTowerEntity cellTowerEntity) {
		return ctService.getCellTower(cellTowerEntity);
	}

	@PostMapping("/getPhoneNumber")
	public PeopleMobileEntity getPhoneNumber(@RequestBody PeopleMobileEntity peopleMobileEntity) {
		return pmService.getPhoneNumber(peopleMobileEntity);
	}
}
