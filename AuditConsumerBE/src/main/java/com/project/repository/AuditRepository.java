package com.project.repository;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.project.entities.AuditEntrySent;

public interface AuditRepository extends MongoRepository<AuditEntrySent, String> {

	@Query("{ 'username' : ?0 }")
	Collection<AuditEntrySent> getAuditsForUser(String username);

}
