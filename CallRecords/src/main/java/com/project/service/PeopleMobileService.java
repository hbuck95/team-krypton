package com.project.service;

import java.util.List;

import com.project.entities.MobileCallRecordsEntity;
import com.project.entities.PeopleMobileEntity;

public interface PeopleMobileService {

	List<PeopleMobileEntity> getAssociate(List<MobileCallRecordsEntity> mobileCallRecordsEntity);

	PeopleMobileEntity getPhoneNumber(PeopleMobileEntity peopleMobileEntity);
}
