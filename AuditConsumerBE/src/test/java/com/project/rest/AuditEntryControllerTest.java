package com.project.rest;

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

import com.project.entities.AuditEntrySent;
import com.project.service.AuditService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AuditEntryControllerTest {

	@InjectMocks
	private AuditEntryController controller;

	@Mock
	private AuditService service;

	private static final AuditEntrySent auditEntry1 = new AuditEntrySent("testusername", "testurl", "testsearch",
			"testdate");
	private static final AuditEntrySent auditEntry2 = new AuditEntrySent("testusername2", "testurl2", "testsearch2",
			"testdate2");

	@Test
	public void getAllAudits() {
		List<AuditEntrySent> test_list = new ArrayList<>();
		test_list.add(auditEntry1);
		test_list.add(auditEntry2);
		Mockito.when(service.getAllAudits()).thenReturn(test_list);
		assertEquals(test_list, controller.getAllAudits());
	}

	@Test
	public void getAuditsForUser() {
		List<AuditEntrySent> test_list = new ArrayList<>();
		test_list.add(auditEntry1);
		Mockito.when(service.getAuditsForUser("testusername")).thenReturn(test_list);
		assertEquals(test_list, controller.getAuditsForUser(auditEntry1));
		Mockito.verify(service).getAuditsForUser("testusername");
	}

	@Test
	public void createAudit() {
		Mockito.when(service.createAudit(auditEntry1))
				.thenReturn("{response: \"Your audit entry was successfully saved to the database.\"}");
		assertEquals("{response: \"Your audit entry was successfully saved to the database.\"}",
				controller.createAudit(auditEntry1));

	}
}
