package com.cg.mtba.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.mtba.exception.BookingException;
import com.cg.mtba.model.TicketBooking;

public interface IBookingService {
	
	public TicketBooking addBooking(TicketBooking booking) throws BookingException;
	
	public TicketBooking updateBooking(TicketBooking booking) throws BookingException;
	
	public TicketBooking cancelBooking(int transId) throws BookingException;
	
	public TicketBooking viewBooking(int transId) throws BookingException;
	
	public List<TicketBooking> showAllBooking(int movieId) throws BookingException;
	
	public List<TicketBooking> showAllBooking(LocalDate date) throws BookingException;
	
	public List<TicketBooking> showBookingList(int showId) throws BookingException;
	
	public List<TicketBooking> showBookingList() throws BookingException;
	
}
