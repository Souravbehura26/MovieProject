package com.cg.mtba.service;

import java.util.List;

import com.cg.mtba.exception.MovieException;
import com.cg.mtba.model.Movie;

public interface IMovieService {

	public Movie addMovie(Movie movie) throws MovieException;
	
	public Movie updateMovie(Movie movie) throws MovieException;
	
	public Movie removeMovie(int movieid) throws MovieException;
	
	public Movie viewMovie(int movieid) throws MovieException;
	
	public List<Movie> viewMovieList() throws MovieException;
	
	public List<Movie> viewMovieList(int threaterid) throws MovieException;
	

	
}