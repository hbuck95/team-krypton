package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.CellTowerEntity;
import com.project.entities.MobileCallRecordsEntity;
import com.project.repository.CellTowerRepository;

@Service
public class CellTowerServiceImpl implements CellTowerService {

	private CellTowerRepository repo;

	@Autowired
	public CellTowerServiceImpl(CellTowerRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<CellTowerEntity> getCellTowers(List<MobileCallRecordsEntity> mobileCallRecordsEntity) {
		List<CellTowerEntity> locations = new ArrayList<>();
		for (int i = 0; i < mobileCallRecordsEntity.size(); i++) {
			String id = mobileCallRecordsEntity.get(i).getCallCellTowerId();

			int cellTowerId = id == null ? -1 : Integer.parseInt(id);
			CellTowerEntity location = repo.findByCellTowerId(cellTowerId);
			locations.add(location);
		}
		return locations;
	}

}
