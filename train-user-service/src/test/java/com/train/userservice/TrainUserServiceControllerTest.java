package com.train.userservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.train.userservice.controller.TicketBookingController;
import com.train.userservice.entity.Ticket;
import com.train.userservice.entity.User;
import com.train.userservice.service.TicketBookingService;

@SpringBootTest
public class TrainUserServiceControllerTest {

	@Autowired
	TicketBookingController ticketBookingController;

	@MockBean
	TicketBookingService ticketBookingService;

	@Test
	public void bookTicket() {
		when(ticketBookingService.bookTicket(getTicketMock()))
				.thenReturn(new ResponseEntity<Long>(getTicketMock().getId(), HttpStatus.CREATED));
		assertEquals(HttpStatus.CREATED, ticketBookingController.bookTicket(getTicketMock()).getStatusCode());
	}

	@Test
	public void getAllTicketDetails() {
		List<Ticket> l = new ArrayList<>();
		l.add(getTicketMock());
		when(ticketBookingService.getAllTicketDetails()).thenReturn(new ResponseEntity(l, HttpStatus.OK));
		assertEquals(HttpStatus.OK, ticketBookingController.getAllTicketDetails().getStatusCode());

	}

	@Test
	public void modifyTicket() {
		when(ticketBookingService.modifyTicket(getTicketMock()))
				.thenReturn(new ResponseEntity<String>("Success", HttpStatus.ACCEPTED));
		assertEquals("Success", ticketBookingController.modifyTicket(getTicketMock()).getBody());
	}

	@Test
	public void getTicketDetails() {
		when(ticketBookingService.getTicketDetails(getTicketMock().getId()))
				.thenReturn(new ResponseEntity(getTicketMock(), HttpStatus.OK));
		assertEquals(HttpStatus.OK, ticketBookingController.getTicketDetails(getTicketMock().getId()).getStatusCode());
	}

	@Test
	public void deleteTicket () {
		when(ticketBookingService.deleteTicket(getTicketMock().getId())).thenReturn(new ResponseEntity<String>("Success", HttpStatus.ACCEPTED));
		assertEquals("Success", ticketBookingController.deleteTicket(getTicketMock().getId()).getBody());
	}
	public static Ticket getTicketMock() {
		User u = new User(1, "name", "name", "name@gmail.com");
		Ticket t = new Ticket(1, "London", "France", 5, "Section A", u);
		return t;
	}

}
