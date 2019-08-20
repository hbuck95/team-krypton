package com.project.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.ANPRCameraEntity;

@Repository
public interface ANPRCameraRepository extends MongoRepository<ANPRCameraEntity, Long> {

	List<ANPRCameraEntity> findByAnprId(Integer anprId);

}
