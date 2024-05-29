package com.cg.mtba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.mtba.dao.IMovieRepository;
import com.cg.mtba.exception.MovieException;
import com.cg.mtba.model.Movie;

@Service
public class MovieServiceImpn implements IMovieService {

	@Autowired
	private IMovieRepository movieservicerepo;
	
	public Movie addMovie(Movie movie) throws MovieException {
		if(!movieservicerepo.existsById(movie.getMovieId())){
		movieservicerepo.save(movie);
		return movie;
		}
		return null;
	}

	public Movie updateMovie( Movie movie) throws MovieException{
		if(movieservicerepo.existsById(movie.getMovieId())){
		movieservicerepo.save(movie);
		return movie;
		}
		return null;
	}

	public Movie removeMovie(int movieid) throws MovieException {
		if(movieservicerepo.existsById(movieid)){
			Movie movie=movieservicerepo.findById(movieid).get();
			movieservicerepo.delete(movie);
			return movie;
		}
		return null;
	}

	public Movie viewMovie(int movieid) throws MovieException{
		if(movieservicerepo.existsById(movieid)){
			Movie movie=movieservicerepo.findById(movieid).get();
			return movie;
		}
		return null;
	}

	@Override
	public List<Movie> viewMovieList() throws MovieException {
		List<Movie>al=movieservicerepo.findAll();
		if(al.size()>0){
		return al;
		}
		return null;
	}

	public List<Movie> viewMovieList(int theatreid) throws MovieException {
		List<Movie> movieList=movieservicerepo.viewMovieList(theatreid);
		if(movieList.size()>0) {
			return movieList;
		}
		return null;
	}


}