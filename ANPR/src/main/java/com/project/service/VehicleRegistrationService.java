package com.project.service;

import java.util.List;

import com.project.entity.VehicleRegistrationEntity;

public interface VehicleRegistrationService {

	public List<VehicleRegistrationEntity> findByForenamesAndSurname(String forenames, String surname);

}
