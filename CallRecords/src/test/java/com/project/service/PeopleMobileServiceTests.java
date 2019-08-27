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
import com.project.entities.PeopleMobileEntity;
import com.project.repository.MobileCallRecordsRepo;
import com.project.repository.PeopleMobileRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PeopleMobileServiceTests {

	@InjectMocks
	PeopleMobileServiceImpl service;

	@Mock
	PeopleMobileRepository repo;

	@Mock
	MobileCallRecordsRepo mrepo;

	public static final PeopleMobileEntity peopleMobileEntity = new PeopleMobileEntity("Timothy Glenn", "Owen",
			"08/10/1954", "613 HIGH STREET, STOKE-ON-TRENT, ST6 5PD", "07700 505797", "T-Mobile");

	public static final PeopleMobileEntity peopleMobileEntity2 = new PeopleMobileEntity("Timothy Glenn", "Owen",
			"08/10/1954", "613 HIGH STREET, STOKE-ON-TRENT, ST6 5PD", "07700 505797", "T-Mobile");
	private static final MobileCallRecordsEntity mobileCallRecordEntity1 = new MobileCallRecordsEntity(
			"2015-05-01T14:01:08.094", "07700 690065", "10572", "07700 505797", "27799");
	private static final MobileCallRecordsEntity mobileCallRecordEntity2 = new MobileCallRecordsEntity(
			"2015-05-03T12:33:47.012", "07700 745330", "103798", "07700 644987", "127838");

//  @Test
//  public void getAssociate() {
//      List<MobileCallRecordsEntity> Mock_List = new ArrayList<>();
//      Mock_List.add(mobileCallRecordEntity1);
//      Mock_List.add(mobileCallRecordEntity2);
//      List<PeopleMobileEntity> MOCK_LIST = new ArrayList<>();
//      MOCK_LIST.add(peopleMobileEntity);
//      MOCK_LIST.add(peopleMobileEntity2);
//      Mockito.when(repo.findByPhoneNumber("07700 690065")).thenReturn(peopleMobileEntity);
//      assertEquals(peopleMobileEntity, service.getAssociate(Mock_List));
//      Mockito.verify(repo).findByPhoneNumber("07700 690065");
//
//  }

	@Test
	public void getAssociate2() {
		List<MobileCallRecordsEntity> Mock_List = new ArrayList<>();
		Mock_List.add(mobileCallRecordEntity1);
//		Mock_List.add(mobileCallRecordEntity2);
		List<PeopleMobileEntity> MOCK_LIST = new ArrayList<>();
		MOCK_LIST.add(peopleMobileEntity);
//		MOCK_LIST.add(peopleMobileEntity2);
		MOCK_LIST.add(Mock_List);
		Mockito.when(mrepo.findByCallerMSISDN("07700 505797")).thenReturn(Mock_List);
		
		
		assertEquals(Mock_List, service.getAssociate(Mock_List));
		Mockito.verify(repo).findByPhoneNumber("07700 505797");

	}

	@Test
	public void getPhoneNumber() {

		Mockito.when(repo.findByForenames("Timothy Glenn", "Owen", "613 HIGH STREET, STOKE-ON-TRENT, ST6 5PD"))
				.thenReturn(peopleMobileEntity);
		assertEquals(peopleMobileEntity, service.getPhoneNumber(peopleMobileEntity));
		Mockito.verify(repo).findByForenames("Timothy Glenn", "Owen", "613 HIGH STREET, STOKE-ON-TRENT, ST6 5PD");

	}

}
