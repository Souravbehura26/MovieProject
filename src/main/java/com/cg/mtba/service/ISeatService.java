package com.cg.mtba.service;

import java.util.List;

import com.cg.mtba.exception.SeatException;
import com.cg.mtba.model.Seat;

public interface ISeatService {

	public Seat bookSeat(Seat seat) throws SeatException;
	
	public Seat cancelSeatBooking(int seatId) throws SeatException;
	
	public Seat blockSeat(Seat seat) throws SeatException;
	
	public List<Seat> viewAllSeat() throws SeatException;
	
}
