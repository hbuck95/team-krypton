package com.project.service;

import java.util.List;

import com.project.entities.EposEntity;
import com.project.entities.EpostransactionEntity;

public interface EposService {

	List<EposEntity> getEposLocations(List<EpostransactionEntity> eposTransactionsEntity);

	List<EposEntity> getAll();

}
