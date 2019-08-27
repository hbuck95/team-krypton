package com.project.controller;

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
import org.springframework.web.client.RestTemplate;

import com.project.entity.Citizen;
import com.project.service.CitizenService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CitizenTest {

	@InjectMocks
	private CitizenController controller;

	@Mock
	private CitizenService service;

	@Mock
	private RestTemplate restTemplate;

	private static final Citizen citizen1 = new Citizen(12345679L, "Tan", "Dryden", "Ilford, London", "18/07/1994",
			"Essex", "female");
	private static final Citizen citizen2 = new Citizen(12345779L, "Chris", "Holmes", "Barking, London", "01/07/1974",
			"Essex", "male");

	@Test
	public void getAllCitizenTest() {
		List<Citizen> Mock_List = new ArrayList<>();
		Mock_List.add(citizen1);
		Mock_List.add(citizen2);
		Mockito.when(service.getAllCitizen()).thenReturn(Mock_List);
		assertEquals(Mock_List, controller.getAllCitizen());
		Mockito.verify(service).getAllCitizen();
	}

	@Test
	public void getCitizen() {
		Mockito.when(service.getCitizen(citizen1)).thenReturn(citizen1);
		assertEquals(citizen1, controller.getCitizen(citizen1));
		Mockito.verify(service).getCitizen(citizen1);
	}

}
