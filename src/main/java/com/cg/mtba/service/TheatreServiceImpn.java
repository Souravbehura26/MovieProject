package com.cg.mtba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mtba.dao.ITheatreRepository;
import com.cg.mtba.exception.BookingException;
import com.cg.mtba.exception.TheatreException;
import com.cg.mtba.model.Show;
import com.cg.mtba.model.Theatre;
import com.cg.mtba.model.TicketBooking;

@Service
public class TheatreServiceImpn implements ITheatreService {

	@Autowired
	public ITheatreRepository theatreservicerepo;

	@Override
	public Theatre addTheatre(Theatre theatre) throws TheatreException{
		if (!theatreservicerepo.existsById(theatre.getTheatreId())) {
			theatreservicerepo.save(theatre);
			return theatre;
		}
		return null;
	}

	@Override
	public Theatre updateTheatre(Theatre theatre) throws TheatreException{
		if (theatreservicerepo.existsById(theatre.getTheatreId())) {
			theatreservicerepo.save(theatre);
			return theatre;
		}
		return null;
	}

	@Override
	public Theatre deleteTheatre(int theatreid) throws TheatreException {

		if (theatreservicerepo.existsById(theatreid)) {
			Theatre theatre = theatreservicerepo.findById(theatreid).get();
			theatreservicerepo.delete(theatre);
			return theatre;
		}
		return null;
	}

	@Override
	public List<Theatre> viewTheatreList() throws TheatreException {
		List<Theatre> theatreList = theatreservicerepo.findAll();
		if (theatreList.size() > 0) {
			return theatreList;
		}
		return null;
	}
	
	@Override
	public Theatre viewTheatre(int theatreId) throws TheatreException {
		if (theatreservicerepo.existsById(theatreId)) {
			Optional<Theatre> th=theatreservicerepo.findById(theatreId);
			Theatre theatre=th.get();
			return theatre;
		}
		return null;
	}

}