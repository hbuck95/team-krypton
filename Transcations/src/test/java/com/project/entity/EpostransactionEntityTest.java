package com.project.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.entities.EpostransactionEntity;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class EpostransactionEntityTest {

	@InjectMocks
	private EpostransactionEntity eposT;

	@Test
	public void defaultConstructorTest() {
		EpostransactionEntity eposT = new EpostransactionEntity();
		assertEquals(EpostransactionEntity.class, eposT.getClass());
	}

	
	@Test
	public void EpostransactionEntityTest() {
		EpostransactionEntity eposT = new EpostransactionEntity("timestamp", 1, 1L, 1, 1);
		
		assertEquals("timestamp", eposT.getTimestamp());
		assertEquals(1, eposT.getEposId());
		assertEquals(1, eposT.getEposId());

		
		eposT.setAmount(2);
		eposT.setBankCardNumber(2L);
		eposT.setEposId(2);
		eposT.setPayeeAccount(2);
		eposT.setTimestamp("test");
		
	assertEquals(2, eposT.getEposId());
	assertEquals(2, eposT.getPayeeAccount());
	assertEquals("test", eposT.getTimestamp());
	
		
		
		
		
		
		
		
	}
}
