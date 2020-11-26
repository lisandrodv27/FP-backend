package com.qa.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.service.TicketService;

@RestController
@CrossOrigin
public class TicketController {

	private TicketService service;

	private TicketController(TicketService service) {
		super();
		this.service = service;
	}

	@PostMapping("/create")
	public ResponseEntity<Profile> createTicket(@RequestBody Ticket ticket) {
		return new ResponseEntity<Profile>(this.service.createTicket(ticket), HttpStatus.CREATED);
	}

	@GetMapping("/get")
	public ResponseEntity<List<Ticket>> getTicket() {
		return ResponseEntity.ok(this.service.getTicket());
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Object> deleteTicket(@PathVariable Long id) {
		if (this.service.deleteTicket(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/update")
	public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket, @PathParam("id") Long id) {
		return new ResponseEntity<Ticket>(this.service.updateTicket(ticket, id), HttpStatus.ACCEPTED);
	}

}
