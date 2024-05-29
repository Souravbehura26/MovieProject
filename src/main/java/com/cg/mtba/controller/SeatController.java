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

import com.cg.mtba.exception.BookingException;
import com.cg.mtba.exception.MovieException;
import com.cg.mtba.exception.SeatException;
import com.cg.mtba.model.Seat;
import com.cg.mtba.model.TicketBooking;
import com.cg.mtba.service.ISeatService;

@CrossOrigin("*")
@RestController
@RequestMapping("/seat")
public class SeatController {
	
	@Autowired
	private ISeatService seatService;

	@PostMapping("/add")
	public ResponseEntity<?> bookSeat(@RequestBody Seat seat) throws SeatException {
		seat=seatService.bookSeat(seat);
		if(seat != null) {
			return new ResponseEntity<>(seat,HttpStatus.CREATED);
		}
		throw new SeatException("Seat Id Exists , Cant be added further");

	}
	
	@DeleteMapping("/cancel/{id}")
	public ResponseEntity<?> cancelSeatBooking(@PathVariable ("id") int seatId) throws SeatException{
		Seat s=seatService.cancelSeatBooking(seatId);
		if(s!= null) {
			return new ResponseEntity<>(s,HttpStatus.OK);
		}
		throw new SeatException("Seat has not been booked, No Seat Cancellation Possible");
	}
	
	@PostMapping("/block")
	public ResponseEntity<?> blockSeat(@RequestBody Seat seat) throws SeatException{
		seat=seatService.blockSeat(seat);
		if(seat != null) {
			return new ResponseEntity<>(seat,HttpStatus.OK);

		}
		throw new SeatException("Seat has not been booked, No Seat Blocking Possible");
	}
	
	@GetMapping("/viewseatlist")
	public ResponseEntity<?>viewAllSeat()throws SeatException{
		List<Seat> seatList=seatService.viewAllSeat();
		if(seatList!=null){
			return new ResponseEntity<>(seatList,HttpStatus.OK);
		}
		
			throw new SeatException ("Sorry Seat List Not Found");
		
	}

}
