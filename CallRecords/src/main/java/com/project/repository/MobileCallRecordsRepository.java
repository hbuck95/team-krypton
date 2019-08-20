package com.project.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.entity.MobileCallRecordsEntity;


@Repository
public interface MobileCallRecordsRepository extends MongoRepository <MobileCallRecordsEntity, Long> {

	
	List<MobileCallRecordsEntity> findById(Integer callCellTowerId);
}
