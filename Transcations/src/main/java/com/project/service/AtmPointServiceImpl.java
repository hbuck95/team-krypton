package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.AtmPointEntity;
import com.project.entities.AtmtransactionsEntity;
import com.project.repository.AtmPointRepo;

@Service
public class AtmPointServiceImpl implements AtmPointService {

	private AtmPointRepo repo;

	@Autowired
	public AtmPointServiceImpl(AtmPointRepo repo) {
		this.repo = repo;
	}

	@Override
	public List<AtmPointEntity> getAtmLocations(List<AtmtransactionsEntity> atmTransactionsEntity) {
		List<AtmPointEntity> atmPoints = new ArrayList<AtmPointEntity>();
		for (int i = 0; i < atmTransactionsEntity.size(); i++) {
			int atmId = atmTransactionsEntity.get(i).getAtmId();
			AtmPointEntity atmPoint = repo.findByAtmId(atmId);
			atmPoints.add(atmPoint);
		}
		return atmPoints;
	}

	@Override
	public List<AtmPointEntity> getAll() {
		return repo.findAll();
	}

}
