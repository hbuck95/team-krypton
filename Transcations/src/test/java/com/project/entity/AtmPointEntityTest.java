package com.project.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.entities.AtmPointEntity;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AtmPointEntityTest {

	@InjectMocks
	private AtmPointEntity atmEntity;

	@Test
	public void defaultConstructorTest() {
		AtmPointEntity atmEntity = new AtmPointEntity();
		assertEquals(AtmPointEntity.class, atmEntity.getClass());

	}

	@Test
	public void AtmPointEntityTest() {
		AtmPointEntity atm = new AtmPointEntity(3, "operator", "streetName", "postcode", "latitude", "longitude");

		assertEquals(3, atm.getAtmId());
		assertEquals("operator", atm.getOperator());
		assertEquals("streetName", atm.getStreetName());
		assertEquals("postcode", atm.getPostcode());
		assertEquals("latitude", atm.getLatitude());
		assertEquals("longitude", atm.getLongitude());

		atm.setAtmId(2);
		atm.setLatitude("test");
		atm.setLongitude("test");
		atm.setOperator("test");
		atm.setPostcode("test");
		atm.setStreetName("test");
		
		assertEquals(2, atm.getAtmId());
		assertEquals("test", atm.getLatitude());
		assertEquals("test", atm.getLongitude());
		assertEquals("test", atm.getOperator());
		assertEquals("test", atm.getPostcode());
		assertEquals("test", atm.getStreetName());
		
		
	}

}