package com.project.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.entity.ANPRObservationEntity;
import com.project.repository.ANPRObservationRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ANPRObservationServiceTest {

	@InjectMocks
	ANPRObservationServiceImplementation service;

	@Mock
	ANPRObservationRepository repo;

	private static final ANPRObservationEntity ANPR_OBSERVATION1 = new ANPRObservationEntity(5538,
			"2015-05-01T09:08:51.975", "IU22 HFF");
	private static final ANPRObservationEntity ANPR_OBSERVATION2 = new ANPRObservationEntity(5538,
			"2015-05-01T09:10:45.975", "IU22 HFF");

//	@Test
//	public void getANPRObservation() {
//		List<ANPRObservationEntity> MOCK_LIST = new ArrayList<>();
//		MOCK_LIST.add(ANPR_OBSERVATION1);
//		MOCK_LIST.add(ANPR_OBSERVATION2);
//		Mockito.when(repo.findByVehicleRegistrationNumber("IU22 HFF")).thenReturn(MOCK_LIST);
//		assertEquals(MOCK_LIST, service.findByVehicleRegistrationNumber(ANPR_OBSERVATION1));
//		Mockito.verify(repo).findByVehicleRegistrationNumber("IU22 HFF");
//
//	}

	@Test
	public void defaultConstructorTest() {
		ANPRObservationEntity entity = new ANPRObservationEntity();
		assertEquals(ANPRObservationEntity.class, entity.getClass());
	}
}
