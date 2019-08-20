package com.project.service;

import java.util.List;

import com.project.entity.MobileCallRecordsEntity;

public interface MobileCallRecordsService {

	public List<MobileCallRecordsEntity> findById(MobileCallRecordsEntity mobileCallRecordsEntity);
}
