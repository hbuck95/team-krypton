package com.project.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.project.entities.SentAuditEntry;
import com.project.repository.AuditRepository;

@Component
public class Receiver {

	@Autowired
	private AuditRepository repo;

	@JmsListener(destination = "AuditQueue", containerFactory = "myFactory")
	public void receiveMessage(SentAuditEntry audit) {
		repo.save(audit);
	}

}
