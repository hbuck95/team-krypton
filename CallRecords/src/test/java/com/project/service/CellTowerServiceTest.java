package com.project.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.entities.CellTowerEntity;
import com.project.entities.MobileCallRecordsEntity;

import com.project.repository.CellTowerRepository;

//@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
//public class CellTowerServiceTest {
//
//	@InjectMocks
//	CellTowerServiceImpl service;
//
//	@Mock
//	CellTowerRepository repo;
//
//	private static final CellTowerEntity CellTower1 = new CellTowerEntity("123", "op", "type", "30.5", "56.3");
//	private static final CellTowerEntity CellTower2 = new CellTowerEntity("123", "oper", "type2", "20.5", "53.3");
//	
//	private static final MobileCallRecordsEntity mobileCallRecordEntity1 = new MobileCallRecordsEntity(
//			"2015-05-01T14:01:08.094", "07700 690065", "10572", "07700 500698", "27799");
//
//	
////	@Test
////	public void getCellTowers2() {
////		List<CellTowerEntity> Mock_List = new ArrayList<>();
////		Mock_List.add(CellTower1);
////		List<MobileCallRecordsEntity> MOCK_LIST=new ArrayList<>();
////		MOCK_LIST.add(mobileCallRecordEntity1);
////		Mockito.when(repo.findByCellTowerId(123)).thenReturn(CellTower1);
////		
////		assertEquals(Mock_List, service.getCellTowers(MOCK_LIST));
////		Mockito.verify(repo).findByCellTowerId(123);
////		
////		
////	}
////	
//}
