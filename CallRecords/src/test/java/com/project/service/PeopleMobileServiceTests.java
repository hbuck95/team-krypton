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
		Mockito.when(repo.findByPhoneNumber("07700 505797")).thenReturn(peopleMobileEntity);
		assertEquals(peopleMobileEntity, service.getAssociate(peopleMobileEntity));
		Mockito.verify(repo).findByPhoneNumber("07700 505797");

	}

	@Test
	public void getPhoneNumber() {

		Mockito.when(repo.findByForenames("Timothy Glenn", "Owen", "613 HIGH STREET, STOKE-ON-TRENT, ST6 5PD"))
				.thenReturn(peopleMobileEntity);
		assertEquals(peopleMobileEntity, service.getPhoneNumber(peopleMobileEntity));
		Mockito.verify(repo).findByForenames("Timothy Glenn", "Owen", "613 HIGH STREET, STOKE-ON-TRENT, ST6 5PD");

	}

}
