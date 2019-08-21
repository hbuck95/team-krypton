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

import com.project.entities.PeopleMobileEntity;
import com.project.repository.PeopleMobileRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PeopleMobileServiceTests {

	@InjectMocks
	PeopleMobileServiceImpl service;
	
	@Mock
	PeopleMobileRepository repo;
	
	public static final PeopleMobileEntity peopleMobileEntity = new PeopleMobileEntity("Timothy Glenn", "Owen",
			"08/10/1954", "613 HIGH STREET, STOKE-ON-TRENT, ST6 5PD", "07700 505797", "T-Mobile");
	
	@Test
	public void getAssociate() {
		List<PeopleMobileEntity> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(peopleMobileEntity);
		Mockito.when(repo.findByPhoneNumber("07700 505797")).thenReturn((PeopleMobileEntity) MOCK_LIST);
		assertEquals(MOCK_LIST, service.getAssosiate(peopleMobileEntity));
		Mockito.verify(repo).findByPhoneNumber("07700 505797");
		
	}
	
	@Test
	public void getPhoneNumber() {
		List<PeopleMobileEntity> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(peopleMobileEntity);
		Mockito.when(repo.findByPhoneNumber("07700 505797")).thenReturn(peopleMobileEntity);
		assertEquals(MOCK_LIST, service.getPhoneNumber(peopleMobileEntity));
		Mockito.verify(repo).findByPhoneNumber("07700 505797");
		
	}
	
	//PeopleMobileEntity getAssosiate(PeopleMobileEntity peopleMobileEntity);

	//PeopleMobileEntity getPhoneNumber(PeopleMobileEntity peopleMobileEntity);
	
	
}
