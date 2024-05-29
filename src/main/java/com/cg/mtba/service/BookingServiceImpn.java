package com.cg.mtba.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mtba.dao.IBookingRepository;
import com.cg.mtba.exception.BookingException;
import com.cg.mtba.model.Customer;
import com.cg.mtba.model.TicketBooking;

@Service
public class BookingServiceImpn implements IBookingService {

	@Autowired
	private IBookingRepository bookingrepo;

	@Override
	public TicketBooking addBooking(TicketBooking booking) throws BookingException {
		if (!bookingrepo.existsById(booking.getTransactionId())) {
			bookingrepo.save(booking);
			return booking;
		}
		return null;
	}

	@Override
	public TicketBooking updateBooking(TicketBooking booking) throws BookingException{
		if (bookingrepo.existsById(booking.getTransactionId())) {
			bookingrepo.save(booking);
			return booking;
		}
		return null;
	}

	@Override
	public TicketBooking cancelBooking(int transId) throws BookingException{
		if (bookingrepo.existsById(transId)) {
			TicketBooking bk=bookingrepo.findById(transId).get();
			bookingrepo.delete(bk);
			return bk;
		}
		return null;
	}

	@Override
	public List<TicketBooking> showAllBooking(int movieId) throws BookingException {
		List<TicketBooking> bookList = bookingrepo.showAllBooking(movieId);
		if (bookList.size() > 0) {
			return bookList;
		}
		return null;
	}

	@Override
	public List<TicketBooking> showAllBooking(LocalDate bookingdate) throws BookingException {
		List<TicketBooking> bookList = bookingrepo.showAllBooking(bookingdate);
		if (bookList.size() > 0) {
			return bookList;
		}
		return null;

	}

	@Override
	public List<TicketBooking> showBookingList(int showId) throws BookingException{
		List<TicketBooking> bookList = bookingrepo.showBookingList(showId);
		if (bookList.size() > 0) {
			return bookList;
		}
		return null;
	}

	@Override
	public List<TicketBooking> showBookingList() throws BookingException {
		List<TicketBooking> bookList = bookingrepo.findAll();
		if (bookList.size() > 0) {
			return bookList;
		}
		return null;
	}

	@Override
	public TicketBooking viewBooking(int transId) throws BookingException {
		if (bookingrepo.existsById(transId)) {
			Optional<TicketBooking> book=bookingrepo.findById(transId);
			TicketBooking b=book.get();
			return b;
		}
		return null;
	}

}
