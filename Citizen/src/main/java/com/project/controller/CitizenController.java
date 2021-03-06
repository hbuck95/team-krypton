package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.entity.Citizen;
import com.project.service.CitizenService;

@RestController
@RequestMapping("/citizen")
public class CitizenController {
	@Autowired
	private CitizenService service;
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	public CitizenController(CitizenService service) {
		this.service = service;
	}

	@GetMapping("/all")
	public List<Citizen> getAllCitizen() {
		return service.getAllCitizen();

	}

	/**
	 * Returns a a complete Citizen object from the database based on the partial input provided with param.
	 *
	 * @param  		citizen  a partially complete object used as a wrapper containing forenames, surname, and address
	 * @return      the complete citizen object
	 * @see         Citizen
	 */
	@PostMapping("/getCitizen")
	public Citizen getCitizen(@RequestBody Citizen citizen) {
		return service.getCitizen(citizen);
	}

}
