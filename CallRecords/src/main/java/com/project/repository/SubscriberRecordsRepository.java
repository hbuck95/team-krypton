package com.project.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.entity.SubscriberRecordsEntity;

public interface SubscriberRecordsRepository extends MongoRepository<SubscriberRecordsEntity, Long>{

	
	List<SubscriberRecordsEntity> findByPhoneNumber(String phoneNumber);
	List<SubscriberRecordsEntity> findByForenameSurname(String forenames, String surname);
	List<SubscriberRecordsEntity> findByForenameSurnameDoBAdd(String forenames, String surname, String dateOfBirth, String address);
}
