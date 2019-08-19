package com.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.entity.ANPRCameraEntity;
import com.project.repository.ANPRCameraRepository;

@Service
public class ANPRCameraServiceImplementation implements ANPRCameraService {

	private ANPRCameraRepository repo;

	@Override
	public List<ANPRCameraEntity> findById(String Id) {

		return repo.findByAnprId(Id);

	}

}
