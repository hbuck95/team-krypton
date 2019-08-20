package com.project.service;

import java.util.Collection;

import com.project.entities.AuditEntry;

public interface AuditService {
	Collection<AuditEntry> getAllAudits();

	Collection<AuditEntry> getAuditsForUser(String username);

	String createAudit(AuditEntry audit);
}
