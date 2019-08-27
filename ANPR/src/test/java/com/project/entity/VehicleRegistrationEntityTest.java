package com.project.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class VehicleRegistrationEntityTest {

	@InjectMocks
	private VehicleRegistrationEntity vre;

	@Test
	public void defaultConstructorTest() {
		VehicleRegistrationEntity vre = new VehicleRegistrationEntity();
		assertEquals(VehicleRegistrationEntity.class, vre.getClass());

	}

	@Test
	public void VehicleRegistrationEntityTest() {

		VehicleRegistrationEntity vre = new VehicleRegistrationEntity("registrationId", "registrationDate",
				"vehicleRegistrationNo", "make", "model", "colour", "forenames", "surname", "address", "dateOfBirth",
				"driverLicenceID");

		assertEquals("registrationId", vre.getRegistrationId());
		assertEquals("registrationDate", vre.getRegistrationDate());
		assertEquals("vehicleRegistrationNo", vre.getVehicleRegistrationNo());
		assertEquals("make", vre.getMake());
		assertEquals("model", vre.getModel());
		assertEquals("colour", vre.getColour());
		assertEquals("forenames", vre.getForenames());
		assertEquals("surname", vre.getSurname());
		assertEquals("address", vre.getAddress());
		assertEquals("dateOfBirth", vre.getDateOfBirth());
		assertEquals("driverLicenceID", vre.getDriverLicenceID());
		vre.setAddress("test");
		vre.setColour("test");
		vre.setDateOfBirth("test");
		vre.setDriverLicenceID("test");
		vre.setForenames("test");
		vre.setMake("test");
		vre.setModel("test");
		vre.setRegistrationDate("test");
		vre.setRegistrationId("test");
		vre.setSurname("test");
		vre.setVehicleRegistrationNo("test");

		assertEquals("test", vre.getAddress());
		assertEquals("test", vre.getColour());
		assertEquals("test", vre.getDateOfBirth());
		assertEquals("test", vre.getDriverLicenceID());
		assertEquals("test", vre.getForenames());
		assertEquals("test", vre.getMake());
		assertEquals("test", vre.getModel());
		assertEquals("test", vre.getRegistrationDate());
		assertEquals("test", vre.getRegistrationId());
		assertEquals("test", vre.getSurname());
		assertEquals("test", vre.getVehicleRegistrationNo());

	}

}
