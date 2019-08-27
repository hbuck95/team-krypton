package com.project.entity;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class VehicleEntityTest {

	@InjectMocks
	private VehicleEntity ve;

	@Test
	public void defaultConstructorTest() {
		VehicleEntity ve = new VehicleEntity();
		assertEquals(VehicleEntity.class, ve.getClass());
	}

	@Test
	public void VehicleEntityTest() {
		VehicleEntity ve = new VehicleEntity("vehicleRegistrationNo", "make", "model", "colour");

		assertEquals("vehicleRegistrationNo", ve.getVehicleRegistrationNo());
		assertEquals("make", ve.getMake());
		assertEquals("model", ve.getModel());
		assertEquals("colour", ve.getColour());
		
		ve.setColour("test");
		ve.setMake("test");
		ve.setModel("test");
		ve.setVehicleRegistrationNo("test");
		
		
		assertEquals("test", ve.getColour());
		assertEquals("test", ve.getMake());
		assertEquals("test", ve.getModel());
		assertEquals("test", ve.getVehicleRegistrationNo());
		
		
		
		
	}
}
