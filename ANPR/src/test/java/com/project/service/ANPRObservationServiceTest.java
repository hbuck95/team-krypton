package com.project.service;

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

import com.project.entity.ANPRObservationEntity;
import com.project.entity.VehicleRegistrationEntity;
import com.project.repository.ANPRObservationRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ANPRObservationServiceTest {

	@InjectMocks
	ANPRObservationServiceImplementation service;

	@Mock
	ANPRObservationRepository repo;

	private static final ANPRObservationEntity ANPR_OBSERVATION1 = new ANPRObservationEntity(5538,
			"2015-05-01T09:08:51.975", "IU22 HFF");
	private static final ANPRObservationEntity ANPR_OBSERVATION2 = new ANPRObservationEntity(5538,
			"2015-05-01T09:10:45.975", "IU22 HFF");
	private static final VehicleRegistrationEntity VEHICLE1 = new VehicleRegistrationEntity("131249", "11/04/1995",
			"IU22 HFF", "BMW", "1 Series", "white", "Patricia Jane", "Adams", "3 CANNON LANE, PINNER, HA5 1HH",
			"07/04/1989", "ADAMS854079PJ9MU 50");
//	@Test
//	public void findByVehicleRegistrationNumber() {
//		List<ANPRObservationEntity> MOCK_LIST = new ArrayList<>();
//		MOCK_LIST.add(ANPR_OBSERVATION1);
//		MOCK_LIST.add(ANPR_OBSERVATION2);
//		Mockito.when(repo.findByVehicleRegistrationNumber("IU22 HFF")).thenReturn(MOCK_LIST);
//		assertEquals(MOCK_LIST, service.findByVehicleRegistrationNumber(ANPR_OBSERVATION1));
//		Mockito.verify(repo).findByVehicleRegistrationNumber("IU22 HFF");

	

	@Test
	public void findByVehicleRegistrationNumber() {
List<ANPRObservationEntity> Mock_List = new ArrayList<>();
Mock_List.add(ANPR_OBSERVATION1);
List<VehicleRegistrationEntity> MOCK_LIST = new ArrayList<>();
MOCK_LIST.add(VEHICLE1);
Mockito.when(repo.findByVehicleRegistrationNumber("IU22 HFF")).thenReturn(Mock_List);
assertEquals(Mock_List, service.findByVehicleRegistrationNumber(MOCK_LIST));
Mockito.verify(repo).findByVehicleRegistrationNumber("IU22 HFF");

	}

	@Test
	public void defaultConstructorTest() {
		ANPRObservationEntity entity = new ANPRObservationEntity();
		assertEquals(ANPRObservationEntity.class, entity.getClass());
	}
}
