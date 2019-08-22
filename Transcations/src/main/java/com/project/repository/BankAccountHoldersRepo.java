package com.project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.project.entities.PeopleBankAccountEntity;

@Repository
public interface BankAccountHoldersRepo extends MongoRepository<PeopleBankAccountEntity, Long> {

	@Query("{ 'forenames' : ?0, 'surname' : ?1, 'address' : ?2}")
	PeopleBankAccountEntity findByForenames(String forenames, String surname, String homeAddress);
}
