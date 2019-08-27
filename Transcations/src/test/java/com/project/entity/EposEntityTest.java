package com.project.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.entities.EposEntity;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EposEntityTest {

	@InjectMocks
	private EposEntity eposEntity;

	@Test
	public void defaultConstructorTest() {
		EposEntity eposEntity = new EposEntity();
		assertEquals(EposEntity.class, eposEntity.getClass());
	}

	@Test
	public void EposEntityTest() {
		EposEntity eposEntity = new EposEntity(1, "vendor", "streetName", "postcode", "latitude", "longitude");
		assertEquals(1, eposEntity.getId());
		assertEquals("vendor", eposEntity.getVendor());
		assertEquals("streetName", eposEntity.getStreetName());
		assertEquals("postcode", eposEntity.getPostcode());
		assertEquals("latitude", eposEntity.getLatitude());
		assertEquals("longitude", eposEntity.getLongitude());
		
		eposEntity.setId(2);
		eposEntity.setLatitude("test");
		eposEntity.setLongitude("test");
		eposEntity.setPostcode("test");
		eposEntity.setStreetName("test");
		eposEntity.setVendor("test");
		
		assertEquals(2, eposEntity.getId());
		assertEquals("test", eposEntity.getLatitude());
		assertEquals("test",eposEntity.getLongitude());
		assertEquals("test", eposEntity.getPostcode());
		assertEquals("test", eposEntity.getStreetName());
		assertEquals("test", eposEntity.getVendor());
		
		
		

	}
}
