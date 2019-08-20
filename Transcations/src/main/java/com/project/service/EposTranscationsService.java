package com.project.service;

import java.util.List;

import com.project.entities.EposTranscationEntity;

public interface EposTranscationsService {

	List<EposTranscationEntity> getTranscations(EposTranscationEntity eposTranscationEntity);

}
