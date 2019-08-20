package com.project.rest;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.AuditEntry;
import com.project.entities.AuditEntrySent;
import com.project.service.AuditService;

@RestController
public class AuditProducerController {

	private AuditService service;
	private JmsTemplate jmsTemplate;

	@Autowired
	public AuditProducerController(AuditService service, JmsTemplate jmsTemplate) {
		this.service = service;
		this.jmsTemplate = jmsTemplate;
	}

	@GetMapping("/getAll")
	public Collection<AuditEntry> getAllAudits() {
		return service.getAllAudits();
	}

	@PostMapping("/getForUser")
	public Collection<AuditEntry> getAuditsForUser(@RequestBody AuditEntry entry) {
		return service.getAuditsForUser(entry.getUsername());
	}

	@PostMapping("/create")
	public String createAudit(@RequestBody AuditEntry entry) {
		entry.setDate(LocalDateTime.now());
		sendToQueue(entry);
		return service.createAudit(entry);
	}

	private void sendToQueue(AuditEntry entry) {
		AuditEntrySent userToStore = new AuditEntrySent(entry);
		jmsTemplate.convertAndSend("UserQueue", userToStore);
	}

}