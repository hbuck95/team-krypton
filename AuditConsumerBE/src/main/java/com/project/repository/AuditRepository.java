package com.project.repository;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.project.entities.AuditEntry;

public interface AuditRepository extends MongoRepository<AuditEntry, String> {

	@Query("{ 'username' : ?0 }")
	Collection<AuditEntry> getAuditsForUser(String username);

}
