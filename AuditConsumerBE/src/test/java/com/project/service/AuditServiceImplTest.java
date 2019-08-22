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

import com.project.entities.AuditEntrySent;
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

	private static final AuditEntrySent auditEntry1 = new AuditEntrySent("testusername", "testurl", "testsearch",
			"testdate");
	private static final AuditEntrySent auditEntry2 = new AuditEntrySent("testusername2", "testurl2", "testsearch2",
			"testdate2");

	@Test
	public void getAllAudits() {
		List<AuditEntrySent> test_list = new ArrayList<>();
		test_list.add(auditEntry1);
		test_list.add(auditEntry2);
		Mockito.when(repo.findAll()).thenReturn(test_list);
		assertEquals(test_list, auditServiceImpl.getAllAudits());
	}

	@Test
	public void getAuditsForUser() {
		List<AuditEntrySent> test_list = new ArrayList<>();
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
