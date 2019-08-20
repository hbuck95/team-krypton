package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.CellTowerEntity;
import com.project.repository.CellTowerRepository;

@Service
public class CellTowerServiceImpl implements CellTowerService {

	private CellTowerRepository repo;

	@Autowired
	public CellTowerServiceImpl(CellTowerRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<CellTowerEntity> getCellTower(CellTowerEntity cellTowerEntity) {
		int towerId = cellTowerEntity.getCellTowerId();
		List<CellTowerEntity> cellTower = repo.findByCellTowerId(towerId);
		return cellTower;
	}

}
