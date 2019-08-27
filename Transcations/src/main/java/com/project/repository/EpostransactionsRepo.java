package com.project.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.entities.EpostransactionEntity;

@Repository
public interface EpostransactionsRepo extends MongoRepository<EpostransactionEntity, Long> {

	List<EpostransactionEntity> findByBankCardNumber(Long bankCardNumber);
}
