package com.project.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.entities.PeopleMobileEntity;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PeopleMobileEntityTest {

	@InjectMocks
	private PeopleMobileEntity pme;

	@Test
	public void defaultConstructorTest() {
		PeopleMobileEntity pme = new PeopleMobileEntity();
		assertEquals(PeopleMobileEntity.class, pme.getClass());

	}

	@Test
	public void PeopleMobileEntityTest() {

		PeopleMobileEntity pme = new PeopleMobileEntity("forename", "surname", "dateOfBirth", "address", "phoneNumber",
				"network");
		assertEquals("forename", pme.getForenames());
		assertEquals("surname", pme.getSurname());
		assertEquals("dateOfBirth", pme.getDateOfBirth());
		assertEquals("address", pme.getAddress());
		assertEquals("phoneNumber", pme.getPhoneNumber());
		assertEquals("network", pme.getNetwork());

		pme.setAddress("test");
		pme.setDateOfBirth("test");
		pme.setForenames("test");
		pme.setNetwork("test");
		pme.setPhoneNumber("test");
		pme.setSurname("test");

		assertEquals("test", pme.getAddress());
		assertEquals("test", pme.getDateOfBirth());
		assertEquals("test", pme.getForenames());
		assertEquals("test", pme.getNetwork());
		assertEquals("test", pme.getPhoneNumber());
		assertEquals("test", pme.getSurname());

	}

}
