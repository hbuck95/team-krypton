package com.project.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.project.entity.Citizen;
import com.project.service.CitizenService;

@RunWith(SpringRunner.class)
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
	public void getCitizenTest() {
		List<Citizen> Mock_List = new ArrayList<>();
		Mock_List.add(citizen1);
		Mock_List.add(citizen2);
		Mockito.when(service.getCitizen()).thenReturn(Mock_List);
		assertEquals(Mock_List, controller.getCitizen());
		Mockito.verify(service).getCitizen();
	}

}
