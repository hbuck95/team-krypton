package com.project.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CitizenEntityTest {

	@InjectMocks
	private Citizen cEntity;

	@Test
	public void defaultConstructorTest() {
		Citizen cEntity = new Citizen();
		assertEquals(Citizen.class, cEntity.getClass());

	}
	
	
	@Test
	public void Citizen() {
		Citizen cEntity = new Citizen(1L, "forenames",  "surname", "homeAddress", "dateOfBirth", "placeOfBirth",  "sex");
	
		assertEquals("forenames", cEntity.getForenames());
		assertEquals("surname", cEntity.getSurname());
		assertEquals("homeAddress", cEntity.getHomeAddress());
		assertEquals("dateOfBirth", cEntity.getDateOfBirth());
		assertEquals("placeOfBirth", cEntity.getPlaceOfBirth());
		assertEquals("sex", cEntity.getSex());
		
		
		cEntity.setCitizenId(2L);
		cEntity.setDateOfBirth("test");
		cEntity.setForenames("test");
		cEntity.setHomeAddress("test");
		cEntity.setPlaceOfBirth("test");
		cEntity.setSex("test");
		cEntity.setSurname("test");
		
		assertEquals("test", cEntity.getDateOfBirth());
		assertEquals("test", cEntity.getForenames());
		assertEquals("test", cEntity.getHomeAddress());
		assertEquals("test", cEntity.getPlaceOfBirth());
		assertEquals("test", cEntity.getSex());
		assertEquals("test", cEntity.getSurname());
		
		
		
		
		
		
		
	}
	
}
