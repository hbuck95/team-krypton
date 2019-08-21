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

import com.project.entities.EpostransactionEntity;
import com.project.repository.EpostransactionsRepo;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EposTransactionsServiceTests {

	@InjectMocks
	EpostransactionsServiceImpl service;

	@Mock
	EpostransactionsRepo repo;

	private static final EpostransactionEntity TRANSACTION1 = new EpostransactionEntity("2015-05-03T14:26:41.344Z",
			31251, 8233490000000000L, 41593456, 37.43);
	private static final EpostransactionEntity TRANSACTION2 = new EpostransactionEntity("2015-05-03T14:26:41.344Z",
			31251, 8233490000000000L, 41593456, 25.01);

	@Test
	public void findAtmTransactionsTest() {
		List<EpostransactionEntity> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(TRANSACTION1);
		MOCK_LIST.add(TRANSACTION2);
		Mockito.when(repo.findByBankCardNumber(8233490000000000L)).thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, service.gettransactions(TRANSACTION1));
		Mockito.verify(repo).findByBankCardNumber(8233490000000000L);
	}
}
