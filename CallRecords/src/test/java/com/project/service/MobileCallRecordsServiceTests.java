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

import com.project.entities.MobileCallRecordsEntity;
import com.project.repository.MobileCallRecordsRepo;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class MobileCallRecordsServiceTests {

	@InjectMocks
	MobileCallRecordsServiceImpl service;
	
	@Mock
	MobileCallRecordsRepo repo;
	

	
	private static final MobileCallRecordsEntity mobileCallRecordEntity1 = new MobileCallRecordsEntity(
			"2015-05-01T14:01:08.094", "07700 690065", "10572", "07700 500698", "27799");
	private static final MobileCallRecordsEntity mobileCallRecordEntity2 = new MobileCallRecordsEntity(
			"2015-05-03T12:33:47.012", "07700 745330", "103798", "07700 644987", "127838");
	
	
	@Test
	public void getCallRecordsOfSuspect() {
		List<MobileCallRecordsEntity> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(mobileCallRecordEntity1);
		MOCK_LIST.add(mobileCallRecordEntity2);
		Mockito.when(repo.findByCallerMSISDN("07700 690065")).thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, service.getCallRecordsOfSuspect(mobileCallRecordEntity1));
		Mockito.verify(repo).findByCallerMSISDN("07700 690065");
		
	}
	
	@Test
	public void getCallRecordsOfAssosiate() {
		List<MobileCallRecordsEntity> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(mobileCallRecordEntity1);
		MOCK_LIST.add(mobileCallRecordEntity2);
		Mockito.when(repo.findByreceiverMSISDN("07700 644987")).thenReturn(MOCK_LIST);
		assertEquals(MOCK_LIST, service.getCallRecordsOfAssosiate(mobileCallRecordEntity2));
		Mockito.verify(repo).findByreceiverMSISDN("07700 644987");
		
		
	}
	
	

	//List<MobileCallRecordsEntity> getCallRecordsOfAssosiate(MobileCallRecordsEntity mobileCallRecordsEntity);
}
