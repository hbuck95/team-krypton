package com.project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.service.ANPRCameraService;
import com.project.service.ANPRObservationService;
import com.project.service.VehicleRegistrationService;
import com.project.service.VehicleService;

@RestController
@RequestMapping("/ANPR")
public class ANPRController {

	private RestTemplate restTemplate;
	private ANPRCameraService anprCameraService;
	private ANPRObservationService anprObservationService;
	private VehicleService vehicleService;
	private VehicleRegistrationService vehicleRegistrationService;

}
