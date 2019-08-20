package com.project.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.entities.MobileCallRecordsEntity;

@Repository
public interface MobileCallRecordsRepo extends MongoRepository<MobileCallRecordsEntity, Long> {

	List<MobileCallRecordsEntity> findByCallerMSISDN(String callerMsisDN);

	List<MobileCallRecordsEntity> findByreceiverMSISDN(String receiverMSISDN);
}
