/**
 * 
 */
package com.train.userservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.train.userservice.entity.Ticket;
import com.train.userservice.repo.TicketRepo;

/**
 * 
 */
@Service
public class TicketBookingService {

	@Autowired
	TicketRepo ticketRepo;

	public ResponseEntity<Long> bookTicket(Ticket ticket) {
		Ticket receipt = ticketRepo.save(ticket);
		return new ResponseEntity<Long>(receipt.getId(), HttpStatus.CREATED);
	}

	public ResponseEntity<String> deleteUser(Ticket ticket) {
		ticketRepo.delete(ticket);
		return new ResponseEntity<String>("Success", HttpStatus.ACCEPTED);
	}

	public ResponseEntity<List<Ticket>> getAllTicketDetails() {
		List<Ticket> allDetails = ticketRepo.findAll();
		return new ResponseEntity<List<Ticket>>(allDetails, HttpStatus.OK);
	}

	public ResponseEntity<String> modifyTicket (Ticket ticket) {
		Ticket id = ticketRepo.findById(ticket.getId()).get();
		Ticket modifyTicket= new Ticket(id.getId(), ticket.getFromPlace(), ticket.getDestination(), ticket.getPricePaid(), ticket.getSection(), ticket.getUserDetails());
		ticketRepo.save(modifyTicket);
		return new ResponseEntity<String>("Success", HttpStatus.ACCEPTED);
	}

	public ResponseEntity<Optional<Ticket>> getTicketDetails(Long receiptId ) {
		Optional<Ticket> ticket = ticketRepo.findById(receiptId);
		return new ResponseEntity<>(ticket, HttpStatus.OK);
	}

	public ResponseEntity<String> deleteTicket (Long receiptId ) {
		ticketRepo.deleteById(receiptId);
		return new ResponseEntity<String>("Success", HttpStatus.ACCEPTED);
	}
}
