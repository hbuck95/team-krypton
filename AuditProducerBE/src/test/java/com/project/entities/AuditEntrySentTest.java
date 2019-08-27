package com.project.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AuditEntrySentTest {

	@InjectMocks
	private AuditEntry auditEntry;

	@Test
	public void defaultConstructorTest() {
		AuditEntrySent entity = new AuditEntrySent();
		assertEquals(AuditEntrySent.class, entity.getClass());
	}

	@Test
	public void AuditEntrySentTest() {
		AuditEntrySent auditEntry = new AuditEntrySent("testuser", "testurl", "testsearch", "testdate");
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
//{"username": "testuser", "searchUrl": "testurl", "searchCriteria": "testsearch", "date": "testdate"}