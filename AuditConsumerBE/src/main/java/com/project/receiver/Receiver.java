package com.project.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.project.entities.AuditEntrySent;
import com.project.repository.AuditRepository;

@Component
public class Receiver {

	@Autowired
	private AuditRepository repo;

	@JmsListener(destination = "AuditQueue", containerFactory = "myFactory")
	public void receiveMessage(AuditEntrySent audit) {
		repo.save(audit);
	}

}
