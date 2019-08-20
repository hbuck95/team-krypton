package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.MobileCallRecordsEntity;
import com.project.repository.MobileCallRecordsRepository;

@Service
public class MobileCallRecordsServiceImpl implements MobileCallRecordsService{
	
private MobileCallRecordsRepository repo;

	
@Autowired
public MobileCallRecordsServiceImpl(MobileCallRecordsRepository repo) {
	this.repo = repo;
	
}

@Override
public List<MobileCallRecordsEntity> findById(MobileCallRecordsEntity mobileCallRecordsEntity){
	Integer callCellTowerId = mobileCallRecordsEntity.getCallCellTowerId();
	return repo.findById(callCellTowerId);
	
}

}
