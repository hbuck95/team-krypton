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
	public static final CellTowerEntity cellTowerEntity1 = new CellTowerEntity(9, "Airwave", "TETRA", "51.21526477",
			"-2.894085973");
	public static final PeopleMobileEntity peopleMobileEntity = new PeopleMobileEntity("Timothy Glenn", "Owen",
			"08/10/1954", "613 HIGH STREET, STOKE-ON-TRENT, ST6 5PD", "07700 505797", "T-Mobile");

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
		Mockito.when(mcrService.getCallRecordsOfAssosiate(mobileCallRecordEntitiy1)).thenReturn(Mock_List);
		assertEquals(Mock_List, controller.getCallRecordsOfAssosiate(mobileCallRecordEntitiy1));
		Mockito.verify(mcrService).getCallRecordsOfAssosiate(mobileCallRecordEntitiy1);
	}

	@Test
	public void getCellTower() {
		Mockito.when(ctService.getCellTower(cellTowerEntity1)).thenReturn(cellTowerEntity1);
		Assert.assertEquals(cellTowerEntity1, controller.getCellTower(cellTowerEntity1));

	}

	@Test
	public void getAssociate() {
		Mockito.when(pmService.getAssosiate(peopleMobileEntity)).thenReturn(peopleMobileEntity);
		Assert.assertEquals(peopleMobileEntity, controller.getAssosiate(peopleMobileEntity));
	}

}
