package com.project.entities;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Audits")
public class AuditEntry {

	private String userId;
	private String username;
	private String searchCriteria;
	private LocalDateTime date;

	public AuditEntry() {
		super();
	}

	public AuditEntry(String userId, String username, String searchCriteria, LocalDateTime date) {
		this.userId = userId;
		this.username = username;
		this.searchCriteria = searchCriteria;
		this.date = date;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSearchCriteria() {
		return searchCriteria;
	}

	public void setSearchCriteria(String searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}
