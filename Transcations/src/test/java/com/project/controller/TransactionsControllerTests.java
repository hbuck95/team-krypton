package com.project.controller;

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
import com.project.entities.BankCardEntity;
import com.project.entities.EpostransactionEntity;
import com.project.entities.PeopleBankAccountEntity;
import com.project.service.AtmTransactionsService;
import com.project.service.BankAccountHoldersService;
import com.project.service.BankCardService;
import com.project.service.EpostransactionsService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TransactionsControllerTests {

	@InjectMocks
	private TransactionsController controller;

	@Mock
	private AtmTransactionsService atService;

	@Mock
	private BankAccountHoldersService bahService;

	@Mock
	private BankCardService bcService;

	@Mock
	private EpostransactionsService etService;

	private static final AtmtransactionsEntity ATM_TRANSACTION1 = new AtmtransactionsEntity("2015-05-02T17:54:31.835",
			3846, 1417430000000000L, "Cash Withdrawal", 110);
	private static final AtmtransactionsEntity ATM_TRANSACTION2 = new AtmtransactionsEntity("2015-05-02T17:54:31.835",
			3846, 1417430000000000L, "Cash Withdrawal", 90);
	private static final PeopleBankAccountEntity Account_Holder1 = new PeopleBankAccountEntity(225884, 2753156,
			"Santander UK", "Jordan Dale", "Bishop", "02/11/1986", "608 HIGH STREET, STOKE-ON-TRENT, ST6 5PD");
	private static final BankCardEntity BANK_CARD1 = new BankCardEntity(143441, 626000000000000L, "01-16-63", 227126,
			19552539, "Barclays Bank");
	private static final EpostransactionEntity EPOS_TRANSACTION1 = new EpostransactionEntity("2015-05-03T14:26:41.344Z",
			31251, 8233490000000000L, 41593456, 37.43);
	private static final EpostransactionEntity EPOS_TRANSACTION2 = new EpostransactionEntity("2015-05-03T14:26:41.344Z",
			31251, 8233490000000000L, 41593456, 25.01);

	@Test
	public void getAccountHolderTest() {
		Mockito.when(bahService.getBankHolder(Account_Holder1)).thenReturn(Account_Holder1);
		assertEquals(Account_Holder1, controller.getAccountHolder(Account_Holder1));
		Mockito.verify(bahService).getBankHolder(Account_Holder1);
	}

	@Test
	public void getBankCardTest() {
		Mockito.when(bcService.getBankCard(BANK_CARD1)).thenReturn(BANK_CARD1);
		assertEquals(BANK_CARD1, controller.getBankCard(BANK_CARD1));
		Mockito.verify(bcService).getBankCard(BANK_CARD1);
	}

	@Test
	public void getAtmTransactionsTest() {
		List<AtmtransactionsEntity> ATM_MOCK_LIST = new ArrayList<>();
		ATM_MOCK_LIST.add(ATM_TRANSACTION1);
		ATM_MOCK_LIST.add(ATM_TRANSACTION2);
		Mockito.when(atService.getTransactions(ATM_TRANSACTION1)).thenReturn(ATM_MOCK_LIST);
		assertEquals(ATM_MOCK_LIST, controller.getAtmTransactions(ATM_TRANSACTION1));
		Mockito.verify(atService).getTransactions(ATM_TRANSACTION1);

	}

	@Test
	public void getEposTransactionsTest() {
		List<EpostransactionEntity> EPOS_MOCK_LIST = new ArrayList<>();
		EPOS_MOCK_LIST.add(EPOS_TRANSACTION1);
		EPOS_MOCK_LIST.add(EPOS_TRANSACTION2);
		Mockito.when(etService.gettransactions(EPOS_TRANSACTION1)).thenReturn(EPOS_MOCK_LIST);
		assertEquals(EPOS_MOCK_LIST, controller.getEpostransactions(EPOS_TRANSACTION1));
		Mockito.verify(etService).gettransactions(EPOS_TRANSACTION1);
	}

	@Test
	public void getAtmLocation() {

	}
}
