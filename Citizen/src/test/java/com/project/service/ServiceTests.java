package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import com.project.entity.Citizen;
import com.project.repository.CitizenRepo;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTests {

	@InjectMocks
	CitizenServiceImpl service;

	@Mock
	CitizenRepo repo;

    private static final Citizen citizen1= new Citizen(12345679L, "Tan", "Dryden", "Ilford, London", "18/07/1994", "Essex", "female");
	private static final Citizen citizen2= new Citizen(12345779L, "Chris", "Holmes", "Barking, London", "01/07/1974", "Essex", "male");
	
	@Test
	public void getCitizenTest() {
		List<Citizen> MOCK_LIST = new ArrayList<>();;
		MOCK_LIST.add(citizen1);
		MOCK_LIST.add(citizen2);
		Mockito.when(repo.findAll()).thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, service.getCitizen());
		Mockito.verify(repo).findAll();
	}
	
	
}
