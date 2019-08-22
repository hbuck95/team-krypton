package com.project.rest;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.client.RestTemplate;

import com.project.entities.AuditEntry;
import com.project.service.AuditService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class AuditProducerControllerTest {

	@InjectMocks
	private AuditProducerController controller;
	
	@Mock
	private AuditService service;
	
	@Mock 
	private RestTemplate restTemplate;
	
	@Mock
	private JmsTemplate jmsTemplate;
	
	 
	
	private static final AuditEntry auditEntry1 = new AuditEntry("testusername", "testurl", "testsearch", "testdate");
	private static final AuditEntry auditEntry2 = new AuditEntry("testusername2", "testurl2", "testsearch2", "testdate2");
	private static final AuditEntry blankAuditEntry = new AuditEntry("null", "null", "null", "null");

	
	@Test
	public void getAllAudits() {
		List<AuditEntry> test_list = new ArrayList<>();
		test_list.add(auditEntry1);
		test_list.add(auditEntry2);
		Mockito.when(service.getAllAudits()).thenReturn(test_list);
		assertEquals(test_list, controller.getAllAudits());
		Mockito.verify(service).getAllAudits();
	}
	
	@Test
	public void getAuditsForUser() {
		List<AuditEntry> test_list = new ArrayList<>();
		test_list.add(auditEntry1);
		Mockito.when(service.getAuditsForUser("testusername")).thenReturn(test_list);
		assertEquals(test_list, controller.getAuditsForUser(auditEntry1));
		Mockito.verify(service).getAuditsForUser("testusername");
	}
	
	@Test
	public void createAudit() {
		Mockito.when(service.createAudit(blankAuditEntry)).thenReturn("{response: \"Your audit entry was successfully saved to the database.\"}");
		assertEquals("{response: \"Your audit entry was successfully saved to the database.\"}", controller.createAudit(blankAuditEntry));
		
	}
}
