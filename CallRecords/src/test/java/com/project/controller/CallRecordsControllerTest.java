package com.project.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import com.project.entities.CellTowerEntity;
import com.project.entities.MobileCallRecordsEntity;
import com.project.entities.PeopleMobileEntity;
import com.project.service.CellTowerService;
import com.project.service.MobileCallRecordsService;
import com.project.service.PeopleMobileService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CallRecordsControllerTest {

	@InjectMocks
	private CallRecordsController controller;
	@Mock
	private CellTowerService ctService;
	@Mock
	private MobileCallRecordsService mcrService;
	@Mock
	private PeopleMobileService pmService;
	@Mock
	private RestTemplate restTemplate;
	private static final MobileCallRecordsEntity mobileCallRecordEntitiy1 = new MobileCallRecordsEntity(
			"2015-05-01T14:01:08.094", "07700 690065", "10572", "07700 500698", "27799");
	private static final MobileCallRecordsEntity mobileCallRecordEntity2 = new MobileCallRecordsEntity(
			"2015-05-03T12:33:47.012", "07700 745330", "103798", "07700 644987", "127838");
	public static final CellTowerEntity cellTowerEntity1 = new CellTowerEntity("9", "Airwave", "TETRA", "51.21526477",
			"-2.894085973");
	public static final CellTowerEntity cellTowerEntity2 = new CellTowerEntity("12", "Airwave", "TETRA", "51.3456754",
			"-2.895478732");
	public static final PeopleMobileEntity peopleMobileEntity1 = new PeopleMobileEntity("Timothy Glenn", "Owen",
			"08/10/1954", "613 HIGH STREET, STOKE-ON-TRENT, ST6 5PD", "07700 505797", "T-Mobile");
	public static final PeopleMobileEntity peopleMobileEntity2 = new PeopleMobileEntity("Harry", "Buck", "02/10/1995",
			"620 HIGH STREET, STOKE-ON-TRENT, ST6 5PD", "07700 505890", "O2");

	@Test
	public void getCallRecordsOfSuspect() {
		List<MobileCallRecordsEntity> Mock_List = new ArrayList<>();
		Mock_List.add(mobileCallRecordEntitiy1);
		Mock_List.add(mobileCallRecordEntity2);
		Mockito.when(mcrService.getCallRecordsOfSuspect(mobileCallRecordEntitiy1)).thenReturn(Mock_List);
		assertEquals(Mock_List, controller.getCallRecordsOfSuspect(mobileCallRecordEntitiy1));
		Mockito.verify(mcrService).getCallRecordsOfSuspect(mobileCallRecordEntitiy1);
	}

	@Test
	public void getCallRecordsOfAssosiate() {
		List<MobileCallRecordsEntity> Mock_List = new ArrayList<>();
		Mock_List.add(mobileCallRecordEntitiy1);
		Mock_List.add(mobileCallRecordEntity2);
		Mockito.when(mcrService.getCallRecordsOfAssociate(mobileCallRecordEntitiy1)).thenReturn(Mock_List);
		assertEquals(Mock_List, controller.getCallRecordsOfAssociate(mobileCallRecordEntitiy1));
		Mockito.verify(mcrService).getCallRecordsOfAssociate(mobileCallRecordEntitiy1);
	}

//	@Test
//	public void getCellTower() {
//		List<MobileCallRecordsEntity> Mock_List = new ArrayList<>();
//		Mock_List.add(mobileCallRecordEntitiy1);
//		Mock_List.add(mobileCallRecordEntity2);
//		List<CellTowerEntity> MOCK_LIST = new ArrayList<>();
//		MOCK_LIST.add(cellTowerEntity1);
//		MOCK_LIST.add(cellTowerEntity2);
//		Mockito.when(ctService.getCellTowers(Mock_List)).thenReturn(MOCK_LIST);
//		Assert.assertEquals(cellTowerEntity1, controller.getCellTower(Mock_List));
//
//	}

	@Test
	public void getAssociate() {
		List<MobileCallRecordsEntity> Mock_List = new ArrayList<>();
		Mock_List.add(mobileCallRecordEntitiy1);
		Mock_List.add(mobileCallRecordEntity2);
		List<PeopleMobileEntity> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(peopleMobileEntity1);
		MOCK_LIST.add(peopleMobileEntity2);
		Mockito.when(pmService.getAssociate(Mock_List)).thenReturn(MOCK_LIST);
		Assert.assertEquals(MOCK_LIST, controller.getAssociate(Mock_List));
	}

}
