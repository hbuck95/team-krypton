package com.project.service;

import java.util.List;

import com.project.entity.ANPRCameraEntity;
import com.project.entity.ANPRObservationEntity;

public interface ANPRCameraService {

	List<ANPRCameraEntity> findById(List<ANPRObservationEntity> anprObservationEntity);

}
