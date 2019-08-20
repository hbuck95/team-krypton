package com.project.repository;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.project.entities.SentAuditEntry;

public interface AuditRepository extends MongoRepository<SentAuditEntry, String> {

	@Query("{ 'username' : ?0 }")
	Collection<SentAuditEntry> getAuditsForUser(String username);

}
