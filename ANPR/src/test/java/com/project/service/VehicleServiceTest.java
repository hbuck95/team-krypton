package com.project.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.entity.VehicleEntity;
import com.project.repository.VehicleRepo;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class VehicleServiceTest {
	@InjectMocks
	VehicleServiceImpl service;

	@Mock
	VehicleRepo repo;

	private static final VehicleEntity vehicle1 = new VehicleEntity("12345", "Ford", "Fiesta", "Red");
	private static final VehicleEntity vehicle2 = new VehicleEntity("1234567", "Ford", "Fiesta", "Blue");

	@Test
	public void findVehicleByRegistration() {
		Mockito.when(repo.findbyVehicleRegistrationNo("12345")).thenReturn(vehicle1);
		assertEquals(vehicle1, service.findVehicleByRegistration(vehicle1));
		Mockito.verify(repo).findbyVehicleRegistrationNo("12345");
	}

	@Test
	public void defaultConstructorTest() {
		VehicleEntity entity = new VehicleEntity();
		assertEquals(VehicleEntity.class, entity.getClass());
	}

}
