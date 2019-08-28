package com.project.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.entity.ANPRCameraEntity;
import com.project.repository.ANPRCameraRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ANPRCameraServiceTest {

	@InjectMocks
	ANPRCameraServiceImplementation impl;

	@Mock
	ANPRCameraRepository repo;

	private static final ANPRCameraEntity ANPR_CAMERA = new ANPRCameraEntity(4, "Stafford Road, A34", "52.70225114",
			"-2.036851876");

//	@Test
//	public void findByIdTest() {
//		Mockito.when(repo.findByAnprId(4)).thenReturn(ANPR_CAMERA);
//		assertEquals(ANPR_CAMERA, service.findById(ANPR_CAMERA));
//		Mockito.verify(repo).findByAnprId(4);
//
//	}

	@Test
	public void defaultConstructorTest() {
		ANPRCameraEntity entity = new ANPRCameraEntity();
		assertEquals(ANPRCameraEntity.class, entity.getClass());
	}
}
