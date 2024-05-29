package com.cg.mtba.service;

import java.util.List;

import com.cg.mtba.exception.ShowException;
import com.cg.mtba.model.Show;

public interface IShowService {
	
	public Show addShow(Show show) throws ShowException;
	
	public Show updateShow(Show show) throws ShowException;
	
	public Show removeShow(int showId) throws ShowException;
	
	public Show viewShowById(int showId) throws ShowException;
	
	public List<Show> viewShowList(int theatreid) throws ShowException;
	
	public Show viewShow(int movieId) throws ShowException;
	
	public List<Show> viewAllShows() throws ShowException;
	
	
}