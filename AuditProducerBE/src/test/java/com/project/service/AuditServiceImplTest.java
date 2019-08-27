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
import org.springframework.jms.core.JmsTemplate;

import com.project.entities.AuditEntry;
import com.project.repository.AuditRepository;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AuditServiceImplTest {

	@InjectMocks
	private AuditServiceImpl auditServiceImpl;

	@Mock
	private AuditService service;

	@Mock
	private AuditRepository repo;

	@Mock
	private JmsTemplate jmsTemplate;

	private static final AuditEntry auditEntry1 = new AuditEntry("testusername", "testurl", "testsearch", "testdate");
	private static final AuditEntry auditEntry2 = new AuditEntry("testusername2", "testurl2", "testsearch2",
			"testdate2");
	private static final AuditEntry blankAuditEntry = new AuditEntry("null", "null", "null", "null");

	@Test
	public void getAllAudits() {
		List<AuditEntry> test_list = new ArrayList<>();
		test_list.add(auditEntry1);
		test_list.add(auditEntry2);
		Mockito.when(repo.findAll()).thenReturn(test_list);
		assertEquals(test_list, auditServiceImpl.getAllAudits());
	}

	@Test
	public void getAuditsForUser() {
		List<AuditEntry> test_list = new ArrayList<>();
		test_list.add(auditEntry1);
		Mockito.when(repo.getAuditsForUser("testusername")).thenReturn(test_list);
		assertEquals(test_list, auditServiceImpl.getAuditsForUser("testusername"));

	}

	@Test
	public void createAudit() {
		assertEquals("{response: \"Your audit entry was successfully saved to the database.\"}",
				auditServiceImpl.createAudit(auditEntry1));
	}
}
