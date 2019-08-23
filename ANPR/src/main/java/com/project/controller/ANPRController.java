package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.ANPRCameraEntity;
import com.project.entity.ANPRObservationEntity;
import com.project.entity.VehicleRegistrationEntity;
import com.project.service.ANPRCameraService;
import com.project.service.ANPRObservationService;
import com.project.service.VehicleRegistrationService;
import com.project.service.VehicleService;

@RestController
@RequestMapping("/ANPR")
public class ANPRController {

	private ANPRCameraService anprCameraService;
	private ANPRObservationService anprObservationService;
	private VehicleRegistrationService vehicleRegistrationService;
	private VehicleService vehicleService;

	@Autowired
	public ANPRController(ANPRCameraService anprCameraService, ANPRObservationService anprObservationService,
			VehicleRegistrationService vehicleRegistrationService, VehicleService vehicleService) {
		this.vehicleRegistrationService = vehicleRegistrationService;
		this.anprCameraService = anprCameraService;
		this.anprObservationService = anprObservationService;
		this.vehicleService = vehicleService;
	}

	@GetMapping("/getAll")
	public List<VehicleRegistrationEntity> getAll() {
		return vehicleRegistrationService.getAll();
	}

	@PostMapping("/getVehicleRegistrations")
	public List<VehicleRegistrationEntity> getVehicleRegistrations(
			@RequestBody VehicleRegistrationEntity vehicleRegistrationEntity) {

		return vehicleRegistrationService.findByForenamesAndSurname(vehicleRegistrationEntity);
	}

	@PostMapping("/getANPRObservations")
	public List<ANPRObservationEntity> getANPRObservations(@RequestBody ANPRObservationEntity anprObservationEntity) {

		return anprObservationService.findByVehicleRegistrationNumber(anprObservationEntity);
	}

	@PostMapping("/getANPRCamera")
	public List<ANPRCameraEntity> getANPRCamera(@RequestBody List<ANPRObservationEntity> anprObservationEntity) {

		return anprCameraService.findById(anprObservationEntity);
	}

	@PostMapping("/getVehicle")
	public VehicleRegistrationEntity findVehicleByRegistration(
			@RequestBody VehicleRegistrationEntity vehicleRegistrationEntity) {
		return vehicleRegistrationService.findByRegistration(vehicleRegistrationEntity);
	}

}
