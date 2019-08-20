package com.project.rest;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entities.AuditEntry;
import com.project.service.AuditService;

@RestController
@RequestMapping("/audits")
public class AuditEntryController {

	private AuditService service;

	@Autowired
	public AuditEntryController(AuditService service) {
		this.service = service;
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
		// entry.setDate(LocalDateTime.now());
		return service.createAudit(entry);
	}

}
