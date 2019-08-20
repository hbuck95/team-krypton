package com.project.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.entities.EposTranscationEntity;

@Repository
public interface EposTranscationsRepo extends MongoRepository<EposTranscationEntity, Long> {

	List<EposTranscationEntity> findByBankCardNumber(int bankCardNumber);
}
