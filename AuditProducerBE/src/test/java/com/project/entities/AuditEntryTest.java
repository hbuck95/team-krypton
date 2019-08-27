package com.project.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AuditEntryTest {

	@InjectMocks
	private AuditEntry auditEntry;

	@Test
	public void defaultConstructorTest() {
		AuditEntry entity = new AuditEntry();
		assertEquals(AuditEntry.class, entity.getClass());
	}

	@Test
	public void AuditEntrySentTest() {
		AuditEntry auditEntry = new AuditEntry("testuser", "testurl", "testsearch", "testdate");
		assertEquals("testuser", auditEntry.getUsername());
		assertEquals("testurl", auditEntry.getSearchUrl());
		assertEquals("testsearch", auditEntry.getSearchCriteria());
		assertEquals("testdate", auditEntry.getDate());
		auditEntry.setUsername("test");
		auditEntry.setSearchUrl("test");
		auditEntry.setSearchCriteria("test");
		auditEntry.setDate("test");
		assertEquals("test", auditEntry.getUsername());
		assertEquals("test", auditEntry.getSearchUrl());
		assertEquals("test", auditEntry.getSearchCriteria());
		assertEquals("test", auditEntry.getDate());

	}
}
