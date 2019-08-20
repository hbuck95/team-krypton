package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.CellTowerEntity;
import com.project.entities.MobileCallRecordsEntity;
import com.project.service.CellTowerService;
import com.project.service.MobileCallRecordsService;

@RestController
@RequestMapping("/call")
public class CallRecordsController {

	private CellTowerService ctService;
	private MobileCallRecordsService mcrService;

	@Autowired
	public CallRecordsController(CellTowerService ctService, MobileCallRecordsService mcrService) {
		this.ctService = ctService;
		this.mcrService = mcrService;
	}

	@PostMapping("/getCallRecordsOfSuspect")
	public List<MobileCallRecordsEntity> getCallRecordsOfSuspect(
			@RequestBody MobileCallRecordsEntity mobileCallRecordsEntity) {
		return mcrService.getCallRecordsOfSuspect(mobileCallRecordsEntity);
	}

	@PostMapping("/getCallRecordsOfAssosiate")
	public List<MobileCallRecordsEntity> getCallRecordsOfAssosiate(
			@RequestBody MobileCallRecordsEntity mobileCallRecordsEntity) {
		return mcrService.getCallRecordsOfAssosiate(mobileCallRecordsEntity);
	}

	@PostMapping("/getCellTower")
	public List<CellTowerEntity> getCellTower(@RequestBody CellTowerEntity cellTowerEntity) {
		return ctService.getCellTower(cellTowerEntity);
	}

}
