package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.entities.PeopleBankAccountEntity;

@Repository
public interface BankAccountHoldersRepo extends MongoRepository<PeopleBankAccountEntity, Long> {

	PeopleBankAccountEntity findByForenames(String forenames, String surname, String homeAddress);
}
