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

import com.project.entities.AtmtransactionsEntity;
import com.project.repository.AtmTransactionsRepo;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AtmTransactionServiceTests {

	@InjectMocks
	AtmTransactionsServiceImpl service;

	@Mock
	AtmTransactionsRepo repo;

	private static final AtmtransactionsEntity TRANSACTION1 = new AtmtransactionsEntity("2015-05-02T17:54:31.835", 3846,
			1417430000000000L, "Cash Withdrawal", 110);
	private static final AtmtransactionsEntity TRANSACTION2 = new AtmtransactionsEntity("2015-05-02T17:54:31.835", 3846,
			1417430000000000L, "Cash Withdrawal", 90);

	@Test
	public void findAtmTransactionsTest() {
		List<AtmtransactionsEntity> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(TRANSACTION1);
		MOCK_LIST.add(TRANSACTION2);
		Mockito.when(repo.findByBankCardNumber(1417430000000000L)).thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, service.getTransactions(TRANSACTION1));
		Mockito.verify(repo).findByBankCardNumber(1417430000000000L);

	}
}
