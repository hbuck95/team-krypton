package com.project.service;

import java.util.List;

import com.project.entities.CellTowerEntity;
import com.project.entities.MobileCallRecordsEntity;

public interface CellTowerService {

	List<CellTowerEntity> getCellTowers(List<MobileCallRecordsEntity> mobileCallRecordsEntity);

	List<CellTowerEntity> getAllCellTowers();
}
