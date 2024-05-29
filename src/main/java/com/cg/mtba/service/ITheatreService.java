package com.cg.mtba.service;

import java.util.List;

import com.cg.mtba.exception.TheatreException;
import com.cg.mtba.model.Theatre;

public interface ITheatreService {

	public Theatre addTheatre(Theatre theatre) throws TheatreException;
	
	public Theatre updateTheatre(Theatre theatre) throws TheatreException;
	
	public Theatre deleteTheatre(int theatreid) throws TheatreException;
	
	public List<Theatre> viewTheatreList() throws TheatreException;

	Theatre viewTheatre(int theatreId) throws TheatreException;
}