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

import com.project.entity.VehicleRegistrationEntity;
import com.project.repository.VehicleRegistrationRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class VehicleRegistrationServiceTest {

	@InjectMocks
	VehicleRegistrationServiceImplementation service;

	@Mock
	VehicleRegistrationRepository repo;

	private static final VehicleRegistrationEntity VEHICLE1 = new VehicleRegistrationEntity("131249", "11/04/1995",
			"QN03 WUU", "BMW", "1 Series", "white", "Patricia Jane", "Adams", "3 CANNON LANE, PINNER, HA5 1HH",
			"07/04/1989", "ADAMS854079PJ9MU 50");
	private static final VehicleRegistrationEntity VEHICLE2 = new VehicleRegistrationEntity("131249", "11/04/1995",
			"QN03 WUU", "SUZUKI", "SWIFT", "red", "Patricia Jane", "Adams", "3 CANNON LANE, PINNER, HA5 1HH",
			"07/04/1989", "ADAMS854079PJ9MU 50");

	@Test
	public void findByForenamesAndSurname() {
		List<VehicleRegistrationEntity> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(VEHICLE1);
		MOCK_LIST.add(VEHICLE2);
		Mockito.when(repo.findByForenames("Patricia Jane", "Adams", "3 CANNON LANE, PINNER, HA5 1HH"))
				.thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, service.findByForenamesAndSurname(VEHICLE1));
		Mockito.verify(repo).findByForenames("Patricia Jane", "Adams", "3 CANNON LANE, PINNER, HA5 1HH");
	}

	@Test
	public void getAllVehiclesTest() {
		List<VehicleRegistrationEntity> VEHICLE_LIST = new ArrayList<>();
		VEHICLE_LIST.add(VEHICLE1);
		VEHICLE_LIST.add(VEHICLE2);
		Mockito.when(repo.findAll()).thenReturn(VEHICLE_LIST);
		assertEquals(VEHICLE_LIST, service.getAll());
		Mockito.verify(repo).findAll();
	}

	@Test
	public void findByRegistrationTest(){
	Mockito.when(repo.findByVehicleRegistrationNo("QN03 WUU")).thenReturn(VEHICLE1);
	assertEquals(VEHICLE1, service.findByRegistration(VEHICLE1));
	Mockito.verify(repo).findByVehicleRegistrationNo("QN03 WUU");
	
		
	}
	
	@Test
	public void defaultConstructorTest() {
		VehicleRegistrationEntity entity = new VehicleRegistrationEntity();
		assertEquals(VehicleRegistrationEntity.class, entity.getClass());
	}
}
