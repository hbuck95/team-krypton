package com.project.service;

import java.util.List;

import com.project.entities.AtmPointEntity;
import com.project.entities.AtmtransactionsEntity;

public interface AtmPointService {

	List<AtmPointEntity> getAtmLocations(List<AtmtransactionsEntity> atmTransactionsEntity);

}
