package com.project.entities;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Audits")
public class AuditEntry {

	private String username;
	private String searchUrl;
	private String searchCriteria;
	private LocalDateTime date;

	public AuditEntry() {
		super();
	}

	public AuditEntry(String username, String searchUrl, String searchCriteria, LocalDateTime date) {
		this.username = username;
		this.searchUrl = searchUrl;
		this.searchCriteria = searchCriteria;
		this.date = date;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSearchUrl() {
		return searchUrl;
	}

	public void setSearchUrl(String searchUrl) {
		this.searchUrl = searchUrl;
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