package com.project.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	// get vehicleRegistrations(forenames, surname)
	// get ANPRObservations(vehicleRegistration)
	// get ANPRCamera(id, timestamp)

	@PostMapping("/getVehicleRegistrations")
	public String getVehicleRegistrations(@RequestBody String forenames, @RequestBody String surname) {

		return "g";
	}

	@PostMapping("/getANPRObservations")
	public String getANPRObservations(@RequestBody String vehicleRegistration) {

		return "g";

	}

	@PostMapping("/getANPRCamera")
	public String getANPRCamera(@RequestBody String id) {

		return "g";
	}

}
