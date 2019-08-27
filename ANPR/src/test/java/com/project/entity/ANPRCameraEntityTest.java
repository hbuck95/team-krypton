package com.project.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ANPRCameraEntityTest {

	@InjectMocks
	private ANPRCameraEntity cmEntity;

	@Test
	public void defaultConstructorTest() {
		ANPRCameraEntity cmEntity = new ANPRCameraEntity();
		assertEquals(ANPRCameraEntity.class, cmEntity.getClass());

	}

	@Test
	public void ANPRCameraEntityTest() {
		ANPRCameraEntity cmEntity = new ANPRCameraEntity(1, "streetName", "latitude", "longitude");

		assertEquals(1, cmEntity.getAnprId());
		assertEquals("streetName", cmEntity.getStreetName());
		assertEquals("latitude", cmEntity.getLatitude());
		assertEquals("longitude", cmEntity.getLongitude());
		cmEntity.setAnprId(2);
		cmEntity.setLatitude("2");
		cmEntity.setLongitude("2");
		cmEntity.setStreetName("2");
assertEquals(2, cmEntity.getAnprId());
assertEquals("2", cmEntity.getLatitude());
assertEquals("2", cmEntity.getLongitude());
assertEquals("2", cmEntity.getStreetName());

	}

}
