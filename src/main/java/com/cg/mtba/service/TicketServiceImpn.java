package com.cg.mtba.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mtba.dao.IBookingRepository;
import com.cg.mtba.dao.ITicketRepository;
import com.cg.mtba.exception.TicketException;
import com.cg.mtba.model.Screen;
import com.cg.mtba.model.Ticket;


@Service
public class TicketServiceImpn implements ITicketService {

	@Autowired
	public ITicketRepository ticketservicerepo;
	
	@Autowired
	public IBookingRepository bookingrepo;

	
	@Override
	public Ticket cancelTicket(int ticketid) throws TicketException {
		if (ticketservicerepo.existsById(ticketid)) {
			Ticket ticket = ticketservicerepo.findById(ticketid).get();
			ticketservicerepo.delete(ticket);
			return ticket;
		}
		return null;
	}


	@Override
	public Ticket addTicket(Ticket ticket) throws TicketException{
		if (!ticketservicerepo.existsById(ticket.getTicketId())) {
			ticketservicerepo.save(ticket);
			return ticket;
			
		}
		return null;
	}


	@Override
	public List<Ticket> viewAllTicket() throws TicketException {
		List<Ticket> ticketList = ticketservicerepo.findAll();
		if (ticketList.size() > 0) {
			return ticketList;
		}
		return null;
	}




}