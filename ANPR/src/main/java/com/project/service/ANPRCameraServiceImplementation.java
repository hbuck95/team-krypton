package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.ANPRCameraEntity;
import com.project.entity.ANPRObservationEntity;
import com.project.repository.ANPRCameraRepository;

@Service
public class ANPRCameraServiceImplementation implements ANPRCameraService {

	private ANPRCameraRepository repo;

	@Autowired
	public ANPRCameraServiceImplementation(ANPRCameraRepository repository) {
		this.repo = repository;
	}

	@Override
	public List<ANPRCameraEntity> findById(List<ANPRObservationEntity> anprObservationEntity) {
		List<ANPRCameraEntity> locations = new ArrayList<>();
		for (int i = 0; i < anprObservationEntity.size(); i++) {
			int anprId = anprObservationEntity.get(i).getANPRPointId();
			ANPRCameraEntity location = repo.findByAnprId(anprId);
			locations.add(location);
		}
		return locations;
	}

	@Override
	public List<ANPRCameraEntity> getAllCameras() {
		return repo.findAll();
	}

}
