package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.CellTowersEntity;

import com.project.repository.CellTowersRepository;

@Service
public class CellTowersServiceImpl implements CellTowersService {

	private CellTowersRepository repo;

	@Autowired
	public CellTowersServiceImpl(CellTowersRepository repo) {
		this.repo = repo;
	}

	@Override
	public List<CellTowersEntity> findById(CellTowersEntity ctEntity) {
		String cellTowerId = ctEntity.getCellTowerId();
		return repo.findById(cellTowerId);
	}

}
