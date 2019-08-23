package com.project.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.entity.ANPRCameraEntity;
import com.project.entity.ANPRObservationEntity;
import com.project.entity.VehicleRegistrationEntity;
import com.project.service.ANPRCameraService;
import com.project.service.ANPRObservationService;
import com.project.service.VehicleRegistrationService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ANPRControllerTest {

	@InjectMocks
	private ANPRController controller;

	@Mock
	private ANPRCameraService anprcService;

	@Mock
	private ANPRObservationService anproService;

	@Mock
	private VehicleRegistrationService vrService;

	private static final ANPRCameraEntity ANPR_CAMERA1 = new ANPRCameraEntity(4, "Stafford Road, A34", "52.70225114",
			"-2.036851876");
	private static final ANPRCameraEntity ANPR_CAMERA2 = new ANPRCameraEntity(6, "Stafford Road, A34", "53.82336337",
			"-8.479851852");
	private static final ANPRObservationEntity ANPR_OBSERVATION1 = new ANPRObservationEntity(5538,
			"2015-05-01T09:08:51.975", "IU22 HFF");
	private static final ANPRObservationEntity ANPR_OBSERVATION2 = new ANPRObservationEntity(5538,
			"2015-05-01T09:10:45.975", "IU22 HFF");
	private static final VehicleRegistrationEntity VEHICLE1 = new VehicleRegistrationEntity("131249", "11/04/1995",
			"QN03 WUU", "BMW", "1 Series", "white", "Patricia Jane", "Adams", "3 CANNON LANE, PINNER, HA5 1HH",
			"07/04/1989", "ADAMS854079PJ9MU 50");
	private static final VehicleRegistrationEntity VEHICLE2 = new VehicleRegistrationEntity("131249", "11/04/1995",
			"QN03 WUU", "SUZUKI", "SWIFT", "red", "Patricia Jane", "Adams", "3 CANNON LANE, PINNER, HA5 1HH",
			"07/04/1989", "ADAMS854079PJ9MU 50");

	@Test
	public void getVehicleRegistrationsTest() {
		List<VehicleRegistrationEntity> VEHICLE_LIST = new ArrayList<>();
		VEHICLE_LIST.add(VEHICLE1);
		VEHICLE_LIST.add(VEHICLE2);
		Mockito.when(vrService.findByForenamesAndSurname(VEHICLE1)).thenReturn(VEHICLE_LIST);
		assertEquals(VEHICLE_LIST, controller.getVehicleRegistrations(VEHICLE1));
		Mockito.verify(vrService).findByForenamesAndSurname(VEHICLE1);
	}

//	@Test
//	public void getANPRObservationsTest() {
//		List<ANPRObservationEntity> OBSERVATION_LIST = new ArrayList<>();
//		OBSERVATION_LIST.add(ANPR_OBSERVATION1);
//		OBSERVATION_LIST.add(ANPR_OBSERVATION2);
//		Mockito.when(anproService.findByVehicleRegistrationNumber(ANPR_OBSERVATION1)).thenReturn(OBSERVATION_LIST);
//		assertEquals(OBSERVATION_LIST, controller.getANPRObservations(ANPR_OBSERVATION1));
//		Mockito.verify(anproService).findByVehicleRegistrationNumber(ANPR_OBSERVATION1);
//	}

	@Test
	public void getANPRCameraTest() {
		List<ANPRObservationEntity> Mock_List = new ArrayList<>();
		Mock_List.add(ANPR_OBSERVATION1);
		Mock_List.add(ANPR_OBSERVATION2);
		List<ANPRCameraEntity> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(ANPR_CAMERA1);
		MOCK_LIST.add(ANPR_CAMERA2);
		Mockito.when(anprcService.findById(Mock_List)).thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, controller.getANPRCamera(Mock_List));
		Mockito.verify(anprcService).findById(Mock_List);
	}

	@Test
	public void getAllVehiclesTest() {
		List<VehicleRegistrationEntity> VEHICLE_LIST = new ArrayList<>();
		VEHICLE_LIST.add(VEHICLE1);
		VEHICLE_LIST.add(VEHICLE2);
		Mockito.when(vrService.getAll()).thenReturn(VEHICLE_LIST);
		assertEquals(VEHICLE_LIST, controller.getAll());
		Mockito.verify(vrService).getAll();
	}
}
