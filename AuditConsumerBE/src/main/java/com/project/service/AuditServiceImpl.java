package com.project.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entities.SentAuditEntry;
import com.project.repository.AuditRepository;

@Service
public class AuditServiceImpl implements AuditService {

	private AuditRepository repo;

	@Autowired
	public AuditServiceImpl(AuditRepository repo) {
		this.repo = repo;
	}

	@Override
	public Collection<SentAuditEntry> getAllAudits() {
		return repo.findAll();
	}

	@Override
	public Collection<SentAuditEntry> getAuditsForUser(String username) {
		return repo.getAuditsForUser(username);
	}

	@Override
	public String createAudit(SentAuditEntry audit) {
		repo.save(audit);
		return "{response: \"Your audit entry was successfully saved to the database.\"}";
	}

}
