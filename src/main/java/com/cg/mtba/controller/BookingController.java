package com.cg.mtba.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.mtba.exception.BookingException;
import com.cg.mtba.exception.MovieException;
import com.cg.mtba.model.Movie;
import com.cg.mtba.model.TicketBooking;
import com.cg.mtba.service.IBookingService;

@CrossOrigin("*")
@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private IBookingService bookingservice;
	
	@PostMapping("/add")
	public ResponseEntity<?> addBooking(@RequestBody TicketBooking booking) throws BookingException{
		booking=bookingservice.addBooking(booking);
		if(booking != null ) {
			return new ResponseEntity<TicketBooking>(booking,HttpStatus.CREATED);
		}
		throw new BookingException("Transaction Id Exists,Booking not happened");
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateBooking(@RequestBody TicketBooking booking) throws BookingException{
		booking=bookingservice.updateBooking(booking);
		if(booking != null ) {
			return new ResponseEntity<TicketBooking>(booking,HttpStatus.OK);
		}
		throw new BookingException("No history found for this booking,Cannot be updated");
	}
	
	@DeleteMapping("/cancel/{id}")
	public ResponseEntity<?> cancelBooking(@PathVariable ("id") int transid) throws BookingException{
		TicketBooking book=bookingservice.cancelBooking(transid);
		if(book != null ) {
			return new ResponseEntity<TicketBooking>(book,HttpStatus.OK);
		}
		throw new BookingException("No history found for this booking,Cannot be cancelled");
	}
	
	@GetMapping("/showbooking/{bookingDate}")
	public ResponseEntity<?> showAllBooking(
			@PathVariable("bookingDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "dd-MM-yyyy") LocalDate date) throws BookingException{
		List<TicketBooking> bookingList=bookingservice.showAllBooking(date);
		if(bookingList != null ) {
			return new ResponseEntity<>(bookingList,HttpStatus.OK);
		}
		throw new BookingException("No history found for this booking on this date");
	}
	
	@GetMapping("/showbymovieid/{id}")
	public ResponseEntity<?> showAllBooking(@PathVariable ("id") int movieid) throws BookingException{
		List<TicketBooking> bookingList=bookingservice.showAllBooking(movieid);
		if(bookingList != null ) {
			return new ResponseEntity<>(bookingList,HttpStatus.OK);
		}
		throw new BookingException("No history found for this booking by this movie id");
	}
	
	@GetMapping("/showbyshowid/{id}")
	public ResponseEntity<?> showBookingList(@PathVariable ("id") int showid) throws BookingException{
		List<TicketBooking> bookingList=bookingservice.showBookingList(showid);
		if(bookingList != null ) {
			return new ResponseEntity<>(bookingList,HttpStatus.OK);
		}
		throw new BookingException("No history found for this booking by this show id ");
	}
	
	@GetMapping("/viewbookinglist")
	public ResponseEntity<?> showBookingList()throws  BookingException{
		List<TicketBooking> bookingList=bookingservice.showBookingList();
		if(bookingList!=null){
			return new ResponseEntity<>(bookingList,HttpStatus.OK);
		}
		
			throw new BookingException ("Sorry Booking List Not Found");
		
	}
	
	@GetMapping("/viewbooking/{id}")
	public ResponseEntity<?> viewBooking(@PathVariable ("id") int transid) throws BookingException{
		TicketBooking book=bookingservice.viewBooking(transid);
		if(book != null ) {
			return new ResponseEntity<TicketBooking>(book,HttpStatus.OK);
		}
		throw new BookingException("No history found for this booking by this transaction id");
	}
	

}
