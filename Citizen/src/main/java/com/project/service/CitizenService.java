package com.project.service;

import java.util.List;

import com.project.entity.Citizen;

public interface CitizenService {

	List<Citizen> getAllCitizen();

	Citizen getCitizen(Citizen citizen);

}
