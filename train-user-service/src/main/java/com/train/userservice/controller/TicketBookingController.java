/**
 * 
 */
package com.train.userservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.train.userservice.entity.Ticket;
import com.train.userservice.service.TicketBookingService;

import jakarta.validation.Valid;

/**
 * 
 */
@RestController
@RequestMapping("/ticket")
public class TicketBookingController {

	@Autowired
	TicketBookingService ticketBookingService;

	@PostMapping("/bookTicket")
	public ResponseEntity<Long> bookTicket(@RequestBody @Valid Ticket ticket) {
		return ticketBookingService.bookTicket(ticket);
	}

	@GetMapping("/getAllTicketDetails")
	public ResponseEntity<List<Ticket>> getAllTicketDetails() {
		return ticketBookingService.getAllTicketDetails();
	}

	@PutMapping("/updateTicket")
	public ResponseEntity<String> modifyTicket(@RequestBody @Valid Ticket ticket) {
		return ticketBookingService.modifyTicket(ticket);
	}

	@GetMapping("/getByReceiptId")
	public ResponseEntity<Optional<Ticket>> getTicketDetails(@RequestParam @Valid Long id) {
		return ticketBookingService.getTicketDetails(id);
	}

	@DeleteMapping("/deleteTicket")
	public ResponseEntity<String> deleteTicket(@RequestParam @Valid Long id) {
		return ticketBookingService.deleteTicket(id);
	}
}
