package com.project.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.entity.ANPRCameraEntity;
import com.project.entity.ANPRObservationEntity;
import com.project.repository.ANPRCameraRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ANPRCameraServiceTest {

	@InjectMocks
	ANPRCameraServiceImplementation service;

	@Mock
	ANPRCameraRepository repo;

	private static final ANPRCameraEntity ANPR_CAMERA = new ANPRCameraEntity(4, "Stafford Road, A34", "52.70225114",
			"-2.036851876");
	private static final ANPRObservationEntity ANPR_OBSERVATION1 = new ANPRObservationEntity(4,
			"2015-05-01T09:08:51.975", "IU22 HFF");
	

	@Test
	public void findByIdTest() {
List<ANPRCameraEntity> Mock_List = new ArrayList<>();
Mock_List.add(ANPR_CAMERA);
List<ANPRObservationEntity> MOCK_LIST = new ArrayList<>();
MOCK_LIST.add(ANPR_OBSERVATION1);
Mockito.when(repo.findByAnprId(4)).thenReturn(ANPR_CAMERA);
assertEquals(Mock_List, service.findById(MOCK_LIST));
Mockito.verify(repo).findByAnprId(4);
	}




	@Test
	public void defaultConstructorTest() {
		ANPRCameraEntity entity = new ANPRCameraEntity();
		assertEquals(ANPRCameraEntity.class, entity.getClass());
	}
}
