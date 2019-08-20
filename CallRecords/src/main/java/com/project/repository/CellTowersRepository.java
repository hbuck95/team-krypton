package com.project.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.CellTowersEntity;
import com.project.entity.MobileCallRecordsEntity;

@Repository
public interface CellTowersRepository extends MongoRepository <CellTowersEntity, Long> {

	List<CellTowersEntity> findById(String cellTowerId);
	
	
	
}