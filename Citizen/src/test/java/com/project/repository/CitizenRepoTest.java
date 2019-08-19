package com.project.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.project.controller.CitizenController;
import com.project.entity.Citizen;
import com.project.service.CitizenService;

@RunWith(SpringRunner.class)
public class RepoTest {

	@Autowired
	private CitizenController controller;

	@Autowired
	private CitizenService service;

	private static final Citizen citizen1 = new Citizen(12345679L, "Tan", "Dryden", "Ilford, London", "18/07/1994",
			"Essex", "female");
	
	
	@Test
	public void getCitizenTest(){
		service.getCitizen();
		assertEquals(citizen1.toString(), service.getCitizen().toString());
		
	}

}
