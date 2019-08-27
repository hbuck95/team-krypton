package com.project.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ANPRObservationEntityTest {

	@InjectMocks
	private ANPRObservationEntity oe;

	@Test
	public void defaultConstructorTest() {
		ANPRObservationEntity oe = new ANPRObservationEntity();
		assertEquals(ANPRObservationEntity.class, oe.getClass());

	}

	@Test
	public void ANPRObservationEntityTest() {
		ANPRObservationEntity oe = new ANPRObservationEntity(1, "timeStamp", "vehicleRegistrationNumber");

		assertEquals(1, oe.getANPRPointId());
		assertEquals("timeStamp", oe.getTimeStamp());
		assertEquals("vehicleRegistrationNumber", oe.getVehicleRegistrationNumber());
		
		oe.setANPRPointId(2);
		oe.setTimeStamp("2");
		oe.setVehicleRegistrationNumber("2");
		
		assertEquals(2, oe.getANPRPointId());
		assertEquals("2", oe.getTimeStamp());
		assertEquals("2", oe.getVehicleRegistrationNumber());
		
		
	}
}
