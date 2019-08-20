package com.project.service;

import java.util.List;

import com.project.entity.SubscriberRecordsEntity;

public interface SubscriberRecordsService {

	public List<SubscriberRecordsEntity> findByPhoneNumber(SubscriberRecordsEntity srEntity);
	
}
