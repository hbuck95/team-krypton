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

import com.project.entities.AtmPointEntity;
import com.project.entities.AtmtransactionsEntity;
import com.project.repository.AtmPointRepo;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AtmPointServiceTest {

	@InjectMocks
	AtmPointServiceImpl atmPointServiceImpl;

	@Mock
	AtmPointRepo repo;

	private static final AtmtransactionsEntity TRANSACTION1 = new AtmtransactionsEntity("2015-05-02T17:54:31.835", 3846,
			1417430000000000L, "Cash Withdrawal", 110);
	private static final AtmPointEntity ENTITY1 = new AtmPointEntity(4, "Clydesdake Bank", "East Street", "HP5 1FE",
			"51.7045445304116", "-0.612916592575059");

	@Test
	public void getAtmLocations() {
		List<AtmtransactionsEntity> test_list = new ArrayList();
		test_list.add(TRANSACTION1);
		List<AtmPointEntity> test_list_2 = new ArrayList();
		test_list_2.add(ENTITY1);

		Mockito.when(repo.findByAtmId(3846)).thenReturn(ENTITY1);
		assertEquals(test_list_2, atmPointServiceImpl.getAtmLocations(test_list));
	}

}
