package com.project.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.entities.AtmtransactionsEntity;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AtmtransactionsEntityTest {

	@InjectMocks
	private AtmtransactionsEntity atmTEntity;

	@Test
	public void defaultConstructorTest() {
		AtmtransactionsEntity atmTEntity = new AtmtransactionsEntity();
		assertEquals(AtmtransactionsEntity.class, atmTEntity.getClass());

	}

	@Test
	public void AtmtransactionsEntity() {
		AtmtransactionsEntity atmTEntity = new AtmtransactionsEntity("timeStamp", 2, 1L, "type", 3);
		assertEquals("timeStamp", atmTEntity.getTimeStamp());
		assertEquals(2, atmTEntity.getAtmId());


		assertEquals("type", atmTEntity.getType());
		assertEquals(3, atmTEntity.getAmount());

		atmTEntity.setAmount(5);
		atmTEntity.setAtmId(3);
		atmTEntity.setBankCardNumber(2L);
		atmTEntity.setTimeStamp("test");
		atmTEntity.setType("test");

		assertEquals(5, atmTEntity.getAmount());
		assertEquals(3, atmTEntity.getAtmId());
		assertEquals("test", atmTEntity.getTimeStamp());
		assertEquals("test", atmTEntity.getType());

	}

}
