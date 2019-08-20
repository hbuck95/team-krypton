package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.CellTowersEntity;

@Repository
public interface CellTowersRepository extends MongoRepository <CellTowersEntity, Long> {

	
	
}
