package com.project.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.entities.PeopleBankAccountEntity;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PeopleBankAccountEntityTest {

	@InjectMocks
	private PeopleBankAccountEntity pba;

	@Test
	public void defaultConstructorTest() {
		PeopleBankAccountEntity pba = new PeopleBankAccountEntity();
		assertEquals(PeopleBankAccountEntity.class, pba.getClass());

	}

	@Test
	public void PeopleBankAccountEntityTest() {
		PeopleBankAccountEntity pba = new PeopleBankAccountEntity(1, 1, "bank", "forenames", "surname", "dateOfBirth",
				"homeAddress");

		assertEquals(1, pba.getAccountNumber());
		assertEquals(1, pba.getBankAccountId());
		assertEquals("bank", pba.getBank());
		assertEquals("forenames", pba.getForenames());
		assertEquals("surname", pba.getSurname());
		assertEquals("dateOfBirth", pba.getDateOfBirth());
		assertEquals("homeAddress", pba.getHomeAddress());

		pba.setAccountNumber(2);
		pba.setBank("test");
		pba.setBankAccountId(2);
		pba.setDateOfBirth("test");
		pba.setForenames("test");
		pba.setHomeAddress("test");
		pba.setSurname("test");

		assertEquals(2, pba.getAccountNumber());
		assertEquals(2, pba.getBankAccountId());
		assertEquals("test", pba.getBank());
		assertEquals("test", pba.getDateOfBirth());
		assertEquals("test", pba.getForenames());
		assertEquals("test", pba.getHomeAddress());
		assertEquals("test", pba.getSurname());

	}

}
