package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.ANPRCameraEntity;

@Repository
public interface ANPRCameraRepository extends MongoRepository<ANPRCameraEntity, Long> {

	ANPRCameraEntity findByAnprId(String anprId);

}
