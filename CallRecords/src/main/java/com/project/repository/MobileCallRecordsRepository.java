package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.entity.MobileCallRecordsEntity;

public interface MobileCallRecordsRepository extends MongoRepository <MobileCallRecordsEntity, Long> {

}
