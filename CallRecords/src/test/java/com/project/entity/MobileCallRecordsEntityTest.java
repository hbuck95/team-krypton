package com.project.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;


import com.project.entities.MobileCallRecordsEntity;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MobileCallRecordsEntityTest {
	
	@InjectMocks
	private MobileCallRecordsEntity mcrEntity;
	
	@Test
	public void defaultConstructorTest() {
		MobileCallRecordsEntity mcrEntity = new MobileCallRecordsEntity();
		assertEquals(MobileCallRecordsEntity.class, mcrEntity.getClass());

	}
	
	@Test
	public void MobileCallRecordsTest() {
		MobileCallRecordsEntity mcrEntity = new MobileCallRecordsEntity("18/07/94", "077689765", "234", "45765", "75674");
		
		assertEquals("18/07/94", mcrEntity.getTimestamp());
		assertEquals("077689765", mcrEntity.getCallerMSISDN());
		assertEquals("234", mcrEntity.getCallCellTowerId());
		assertEquals("45765", mcrEntity.getReceiverMSISDN());
		assertEquals("75674", mcrEntity.getReceiverTowerId());
		mcrEntity.setCallCellTowerId("test");
		mcrEntity.setCallerMSISDN("test");
		mcrEntity.setReceiverMSISDN("test");
		mcrEntity.setReceiverTowerId("test");
		mcrEntity.setTimestamp("test");
		
		assertEquals("test", mcrEntity.getCallCellTowerId());
		assertEquals("test", mcrEntity.getCallerMSISDN());
		assertEquals("test", mcrEntity.getReceiverMSISDN());
		assertEquals("test", mcrEntity.getReceiverTowerId());
		assertEquals("test", mcrEntity.getTimestamp());
		
		
				
	}
	
	
}
