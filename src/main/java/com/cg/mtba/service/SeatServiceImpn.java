package com.cg.mtba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mtba.dao.ISeatRepository;

import com.cg.mtba.exception.SeatException;
import com.cg.mtba.model.Seat;
import com.cg.mtba.model.TicketBooking;


@Service
public class SeatServiceImpn implements ISeatService{

	@Autowired
	private ISeatRepository seatrepo;
	
	
	@Override
	public Seat bookSeat(Seat seat) throws SeatException {
		if(!seatrepo.existsById(seat.getSeatId()))  {
			seatrepo.save(seat);
			return seat;
		}
		return null;
	}
	
	@Override
	public Seat cancelSeatBooking(int seatId) throws SeatException {
		if(seatrepo.existsById(seatId)) {
			Seat s=seatrepo.findById(seatId).get();
			seatrepo.delete(s);
			return s;
		}
		return null;
	}

	@Override
	public Seat blockSeat(Seat seat) throws SeatException{
		if(seatrepo.existsById(seat.getSeatId())) {
			seatrepo.save(seat);
			return seat;
		}
		return null;
	}

	@Override
	public List<Seat> viewAllSeat() throws SeatException {
		List<Seat> seatList = seatrepo.findAll();
		if (seatList.size() > 0) {
			return seatList;
		}
		return null;
	}


}
