package com.project.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.entities.CellTowerEntity;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CallRecordsEntityTest {

	@InjectMocks
	private CellTowerEntity ctEntity;

	@Test
	public void defaultConstructorTest() {
		CellTowerEntity ctentity = new CellTowerEntity();
		assertEquals(CellTowerEntity.class, ctEntity.getClass());

	}

	@Test
	public void CellTowerEntityTest() {

		CellTowerEntity ctEntity = new CellTowerEntity("testCellId", "testOperator", "testType", "testLatitude",
				"testLongitude");
		assertEquals("testCellId", ctEntity.getCellTowerId());
		assertEquals("testOperator", ctEntity.getOperator());
		assertEquals("testType", ctEntity.getType());
		assertEquals("testLatitude", ctEntity.getLatitude());
		assertEquals("testLongitude", ctEntity.getLongitude());
		ctEntity.setCellTowerId("test");
		ctEntity.setLatitude("test");
		ctEntity.setLongitude("test");
		ctEntity.setOperator("test");
		ctEntity.setType("test");

		assertEquals("test", ctEntity.getCellTowerId());
		assertEquals("test", ctEntity.getLatitude());
		assertEquals("test", ctEntity.getLongitude());
		assertEquals("test", ctEntity.getOperator());
		assertEquals("test", ctEntity.getType());

	}

}
