package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.entities.BankCardEntity;

@Repository
public interface BankCardsRepo extends MongoRepository<BankCardEntity, Long> {

	BankCardEntity findByAccountNumber(int accountNumber);
}
