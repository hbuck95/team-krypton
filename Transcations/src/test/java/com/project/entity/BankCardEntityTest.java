package com.project.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.entities.BankCardEntity;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BankCardEntityTest {

	@InjectMocks
	private BankCardEntity bcEntity;

	@Test
	public void defaultConstructorTest() {
		BankCardEntity bcEntity = new BankCardEntity();
		assertEquals(BankCardEntity.class, bcEntity.getClass());

	}

	@Test
	public void BankCardEntityTest() {
		BankCardEntity bcEntity = new BankCardEntity(1, 1L, "sortCode", 3, 4, "bank");

		assertEquals(4, bcEntity.getAccountNumber());
		// assertEquals(1L, bcEntity.getCardNumber());
		assertEquals("sortCode", bcEntity.getSortCode());
		assertEquals(1, bcEntity.getBankcardId());
		assertEquals(3, bcEntity.getBankAccountId());
		assertEquals("bank", bcEntity.getBank());

		bcEntity.setAccountNumber(2);
		bcEntity.setBank("test");
		bcEntity.setBankAccountId(5);
		bcEntity.setCardNumber(2L);
		bcEntity.setSortCode("test");
		bcEntity.setBankcardId(8);

	assertEquals(2, bcEntity.getAccountNumber());
	assertEquals("test", bcEntity.getBank());
	assertEquals(5, bcEntity.getBankAccountId());
	assertEquals("test", bcEntity.getSortCode());
	assertEquals(8, bcEntity.getBankcardId());
	
	}

}
