package com.cg.mtba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mtba.exception.TheatreException;
import com.cg.mtba.exception.TicketException;
import com.cg.mtba.model.Theatre;
import com.cg.mtba.model.Ticket;
import com.cg.mtba.service.ITicketService;

@CrossOrigin("*")
@RestController
@RequestMapping("/ticket")
public class TicketController {

	@Autowired
	private ITicketService ticketservice;
	
	
	@PostMapping("/add")
	public ResponseEntity<Ticket> addticket(@RequestBody Ticket ticket) throws TicketException{
		ticket=ticketservice.addTicket(ticket);
		if(ticket != null ) {
			return new ResponseEntity<>(ticket,HttpStatus.CREATED);
		}
		throw new TicketException("Ticket Id Exists, cant be added further");
	}
	
	@DeleteMapping("/cancel/{ticketid}")
	public ResponseEntity<Ticket> deleteticket(@PathVariable("ticketid") int tid)throws TicketException{
		Ticket ticket=ticketservice.cancelTicket(tid);
		if(ticket!=null){
		return new ResponseEntity<>(ticket,HttpStatus.OK);
		}
		throw new TicketException("Ticket Id not Found,Sorry Ticket can't be deleted");
	}
	
	@GetMapping("/viewallticket")
	public ResponseEntity<?> viewAllTicket() throws TicketException {
		List<Ticket> ticketList  = ticketservice.viewAllTicket();
		if (ticketList != null) {
			return new ResponseEntity<>(ticketList, HttpStatus.OK);
		}
		throw new TicketException("There is no ticket available");
	}
}