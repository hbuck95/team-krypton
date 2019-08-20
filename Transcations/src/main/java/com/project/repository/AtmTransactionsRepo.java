package com.project.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.entities.AtmtransactionsEntity;

@Repository
public interface AtmTransactionsRepo extends MongoRepository<AtmtransactionsEntity, Long> {

	List<AtmtransactionsEntity> findByBankCardNumber(Long bankCardNumber);

}
