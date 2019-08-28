package com.project.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.entities.BankCardEntity;
import com.project.repository.BankCardsRepo;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BankCardsServiceTests {

	@InjectMocks
	BankCardServiceImpl service;

	@Mock
	BankCardsRepo repo;

	private static final BankCardEntity BANK_CARD1 = new BankCardEntity(143441, 626000000000000L, "01-16-63", 227126,
			19552539, "Barclays Bank");

	@Test
	public void findBankCardTest() {
		Mockito.when(repo.findByAccountNumber(19552539)).thenReturn(BANK_CARD1);
		assertEquals(BANK_CARD1, service.getBankCard(BANK_CARD1));
		Mockito.verify(repo).findByAccountNumber(19552539);
	}
}
