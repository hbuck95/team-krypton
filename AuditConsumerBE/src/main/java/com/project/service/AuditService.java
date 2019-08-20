package com.project.service;

import java.util.Collection;

import com.project.entities.SentAuditEntry;

public interface AuditService {
	Collection<SentAuditEntry> getAllAudits();

	Collection<SentAuditEntry> getAuditsForUser(String username);

	String createAudit(SentAuditEntry audit);
}
