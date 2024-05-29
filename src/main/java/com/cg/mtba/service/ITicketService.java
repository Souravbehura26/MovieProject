package com.cg.mtba.service;

import java.util.List;

import com.cg.mtba.exception.TicketException;
import com.cg.mtba.model.Ticket;

public interface ITicketService {

	public Ticket addTicket(Ticket ticket) throws TicketException;
	
	public Ticket cancelTicket(int ticketid) throws TicketException;

	public List<Ticket> viewAllTicket()throws TicketException;
	
}