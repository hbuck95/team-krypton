package com.project.repository;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.entity.Citizen;
import com.project.service.CitizenServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CitizenRepoTest {

	@InjectMocks
	private CitizenServiceImpl service;

	@Mock
	private CitizenRepo repo;

	private static final Citizen TEST_CITIZEN_1 = new Citizen(12345679L, "Tan", "Dryden", "Ilford, London",
			"18/07/1994", "Essex", "female");
	private static final Citizen TEST_CITIZEN_2 = new Citizen(12345678L, "Harry", "Buck", "Romford, London",
			"02/10/1995", "Essex", "male");

	private List<Citizen> citizenList;

	@Before
	public void setup() {
		citizenList = new ArrayList<>();
		citizenList.add(TEST_CITIZEN_1);
		citizenList.add(TEST_CITIZEN_2);
	}

	@Test
	public void getCitizenTest() {
		Mockito.when(repo.findAll()).thenReturn(citizenList);
		List<Citizen> returnedCitizens = service.getCitizen();
		assertEquals(citizenList, returnedCitizens);
		assertEquals(true, returnedCitizens.contains(TEST_CITIZEN_2));

	}

}
