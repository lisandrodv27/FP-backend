package com.qa.service;

import java.util.List;
import java.util.Optional;

importpackage com.qa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.exceptions.ProfileNotFoundException;
import com.qa.rest.Ticket;
import com.qa.rest.TicketRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository repository;

	private TicketService(TicketRepository repository) {
		super();
		this.repository = repository;
	}

	public List<Ticket> getTicket() {
		return this.repository.findAll();
	}

	public Ticket createTicket(Ticket ticket) {
		return this.repository.save(ticket);
	}

	public boolean deleteTicket(Long id) {
		this.repository.deleteById(id);
		return !this.repository.existsById(id);
	}

	public Ticket updateTicket(Ticket ticket, Long id) {
		Optional<Ticket> optTicket = this.repository.findById(id);
		Ticket oldTicket = optTicket.orElseThrow(() -> new TicketNotFoundException());

		oldTicket.setTitle(ticket.getTitle());
		oldTicket.setIssue(profile.getIssue());
		oldTicket.setTopic(profile.getTopic());
    oldTicket.setSubmitDate(ticket.getSubmitdate());
    oldTicket.setUrgency(ticket.getUrgency());
    oldTicket.setStatus(ticket.getStatus());
    oldTicket.setTraineeID(ticket.getTraineeID());
    oldTicket.setTrainerID(ticket.getTrainerID());

		Ticket updatedTicket = this.repository.save(oldTicket);
		return updatedTicket;

	}
} 
