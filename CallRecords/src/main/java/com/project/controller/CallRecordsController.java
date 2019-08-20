package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public CallRecordsController (CellTowersService ctService, MobileCallRecordsService mcrService, SubscriberRecordsService srService) {
		this.ctService = ctService;
		this.mcrService = mcrService;
		this.srService = srService;
		
	}
	
	
}
