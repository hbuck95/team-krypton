package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.EposEntity;
import com.project.entities.EpostransactionEntity;
import com.project.repository.EposRepo;

@Service
public class EposServiceImpl implements EposService {

	private EposRepo repo;

	@Autowired
	public EposServiceImpl(EposRepo repo) {
		this.repo = repo;
	}

	@Override
	public List<EposEntity> getEposLocations(List<EpostransactionEntity> eposTransactionsEntity) {
		List<EposEntity> eposPoints = new ArrayList<>();
		for (int i = 0; i < eposTransactionsEntity.size(); i++) {
			int id = eposTransactionsEntity.get(i).getEposId();
			EposEntity eposPoint = repo.findByEposId(id);
			eposPoints.add(eposPoint);
		}
		return eposPoints;
	}

	@Override
	public List<EposEntity> getAll() {
		return repo.findAll();
	}
}
