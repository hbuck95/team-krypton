package com.project.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.project.entities.CellTowerEntity;

@Repository
public interface CellTowerRepository extends MongoRepository<CellTowerEntity, Long> {

	CellTowerEntity findByCellTowerId(int cellTowerId);

}
