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

import com.project.entities.EposEntity;
import com.project.entities.EpostransactionEntity;
import com.project.repository.EposRepo;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EposServiceImplTest {

	@InjectMocks
	EposServiceImpl eposServiceImpl;

	@Mock
	EposRepo repo;

	private static final EpostransactionEntity eposTransaction = new EpostransactionEntity("2015-05-01T14:37:29.961Z",
			20974, 699764343354795L, 49462613, 63.33);
	private static final EposEntity eposEntity = new EposEntity(27064, "Al Safi Mini Market", "Holland Park Road",
			"W14 8NZ", "51.4985742625977", "-0.201958730105688");

	@Test
	public void getEposLocations() {
		List<EpostransactionEntity> eposTransactionList = new ArrayList();
		eposTransactionList.add(eposTransaction);
		List<EposEntity> eposList = new ArrayList();
		eposList.add(eposEntity);

		Mockito.when(repo.findByEposId(20974)).thenReturn(eposEntity);
		assertEquals(eposList, eposServiceImpl.getEposLocations(eposTransactionList));
	}

}
