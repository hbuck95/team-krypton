package com.project.service;

import java.util.Collection;

import com.project.entities.AuditEntrySent;

public interface AuditService {
	Collection<AuditEntrySent> getAllAudits();

	Collection<AuditEntrySent> getAuditsForUser(String username);

	String createAudit(AuditEntrySent audit);
}
