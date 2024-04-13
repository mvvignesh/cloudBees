package com.train.userservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.train.userservice.entity.Ticket;
import com.train.userservice.entity.User;
import com.train.userservice.repo.TicketRepo;
import com.train.userservice.service.TicketBookingService;

@SpringBootTest
public class TicketBookingServiceTest {

	@Autowired
	TicketBookingService bookingService;

	@MockBean
	TicketRepo ticketRepo;

	@Test
	public void bookTicket() {
		when(ticketRepo.save(getTicketMock())).thenReturn(getTicketMock());
		assertEquals(HttpStatus.CREATED, bookingService.bookTicket(getTicketMock()).getStatusCode());
	}

	@Test
	public void getAllTicketDetails() {
		List<Ticket> l = new ArrayList<>();
		l.add(getTicketMock());
		when(ticketRepo.findAll()).thenReturn(l);
		assertEquals(HttpStatus.OK, bookingService.getAllTicketDetails().getStatusCode());

	}

	@Test
	public void modifyTicket() {
		when(ticketRepo.findById(getTicketMock().getId())).thenReturn(Optional.of(getTicketMock()));
		when(ticketRepo.save(getTicketMock())).thenReturn(getTicketMock());
		assertEquals("Success", bookingService.modifyTicket(getTicketMock()).getBody());
	}

	@Test
	public void getTicketDetails() {
		when(ticketRepo.findById(getTicketMock().getId())).thenReturn(Optional.of(getTicketMock()));
		assertEquals(HttpStatus.OK, bookingService.getTicketDetails(getTicketMock().getId()).getStatusCode());
	}

	@Test
	public void deleteTicket() {
		doNothing().when(ticketRepo).deleteById(getTicketMock().getId());

		assertEquals(HttpStatus.ACCEPTED, bookingService.deleteTicket(getTicketMock().getId()).getStatusCode());
	}

	public Ticket getTicketMock() {
		User u = new User(1, "name", "name", "name@gmail.com");
		Ticket t = new Ticket(1, "London", "France", 5, "Section A", u);
		return t;
	}
}
