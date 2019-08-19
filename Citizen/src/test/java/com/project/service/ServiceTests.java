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

import com.project.entity.Citizen;
import com.project.repository.CitizenRepo;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ServiceTests {

	@InjectMocks
	CitizenServiceImpl service;

	@Mock
	CitizenRepo repo;

	private static final Citizen citizen1 = new Citizen(12345679L, "Tan", "Dryden", "Ilford, London", "18/07/1994",
			"Essex", "female");
	private static final Citizen citizen2 = new Citizen(12345779L, "Chris", "Holmes", "Barking, London", "01/07/1974",
			"Essex", "male");

	@Test
	public void getAllSCitizenTest() {
		List<Citizen> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(citizen1);
		MOCK_LIST.add(citizen2);
		Mockito.when(repo.findAll()).thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, service.getAllCitizen());
		Mockito.verify(repo).findAll();
	}

	@Test
	public void findCitizen() {
		Mockito.when(repo.findByForenames("Tan", "Dryden", "Ilford, London")).thenReturn(citizen1);
		assertEquals(citizen1, service.getCitizen(citizen1));
		Mockito.verify(repo).findByForenames("Tan", "Dryden", "Ilford, London");
	}
}
