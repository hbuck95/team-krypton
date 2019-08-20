package com.project.entities;

import java.time.LocalDateTime;

public class AuditEntry {

	private String userId;
	private String username;
	private String searchCriteria;
	private LocalDateTime date;

	public AuditEntry() {
		this.date = LocalDateTime.now();
	}

	public AuditEntry(String userId, String username, String searchCriteria) {
		this.userId = userId;
		this.username = username;
		this.searchCriteria = searchCriteria;
		this.date = LocalDateTime.now();
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
