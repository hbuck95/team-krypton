package com.project.service;

import java.util.List;

import com.project.entities.MobileCallRecordsEntity;

public interface MobileCallRecordsService {

	List<MobileCallRecordsEntity> getCallRecordsOfSuspect(MobileCallRecordsEntity mobileCallRecordsEntity);

	List<MobileCallRecordsEntity> getCallRecordsOfAssociate(MobileCallRecordsEntity mobileCallRecordsEntity);
}
