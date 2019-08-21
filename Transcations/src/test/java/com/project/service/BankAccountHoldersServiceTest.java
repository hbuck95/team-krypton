package com.project.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.entities.PeopleBankAccountEntity;
import com.project.repository.BankAccountHoldersRepo;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BankAccountHoldersServiceTest {

	@InjectMocks
	BankAccountHoldersServiceImpl service;

	@Mock
	BankAccountHoldersRepo repo;

	private static final PeopleBankAccountEntity Account_Holder1 = new PeopleBankAccountEntity(225884, 2753156,
			"Santander UK", "Jordan Dale", "Bishop", "02/11/1986", "608 HIGH STREET, STOKE-ON-TRENT, ST6 5PD");

	@Test
	public void getAccountHolderTest() {
		Mockito.when(repo.findByForenames("Jordan Dale", "Bishop", "608 HIGH STREET, STOKE-ON-TRENT, ST6 5PD"))
				.thenReturn(Account_Holder1);
		assertEquals(Account_Holder1, service.getBankHolder(Account_Holder1));
		Mockito.verify(repo).findByForenames("Jordan Dale", "Bishop", "608 HIGH STREET, STOKE-ON-TRENT, ST6 5PD");
	}
}
