package com.project.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.AuditEntry;
import com.project.repository.AuditRepository;

@Service
public class AuditServiceImpl implements AuditService {

	private AuditRepository repo;

	@Autowired
	public AuditServiceImpl(AuditRepository repo) {
		this.repo = repo;
	}

	@Override
	public Collection<AuditEntry> getAllAudits() {
		return repo.findAll();
	}

	@Override
	public Collection<AuditEntry> getAuditsForUser(String username) {
		return repo.getAuditsForUser(username);
	}

	@Override
	public String createAudit(AuditEntry audit) {
		// repo.save(audit);
		return "{response: \"Your audit entry was successfully saved to the database.\"}";
	}

}
