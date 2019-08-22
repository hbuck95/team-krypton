package com.project.service;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.entities.CellTowerEntity;
import com.project.repository.CellTowerRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CellTowerServiceTest {

	@InjectMocks
	CellTowerServiceImpl service;

	@Mock
	CellTowerRepository repo;

	public static final CellTowerEntity cellTowerEntity1 = new CellTowerEntity(9, "Airwave", "TETRA", "51.21526477",
			"-2.894085973");

//	@Test
//	public void getCellTowerTest() {
//		
//		Mockito.when(repo.findByCellTowerId("9")).thenReturn(cellTowerEntity1);
//		assertEquals(cellTowerEntity1, service.getCellTowers(cellTowerEntity1));
//		Mockito.verify(repo).findByCellTowerId("9");
//	}

}
