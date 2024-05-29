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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.mtba.exception.MovieException;
import com.cg.mtba.model.Movie;
import com.cg.mtba.service.IMovieService;

@CrossOrigin("*")
@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private IMovieService movieservice;
	
	@PostMapping("/add")
	public ResponseEntity<?> addmovie(@RequestBody Movie movie)throws MovieException{
		movie=movieservice.addMovie(movie);
		if(movie!=null){
		return new ResponseEntity<>(movie,HttpStatus.CREATED);
		}
		throw new MovieException ("Movie Id Exist,Can't be Added");
	}
	@PutMapping("/update")
	public ResponseEntity<?> updatemovie(@RequestBody Movie movie)throws MovieException{
		movie=movieservice.updateMovie(movie);
		if(movie!=null){
		return new ResponseEntity<>(movie,HttpStatus.OK);
		}
		throw new MovieException ("Movie Not Found,Sorry Can't be Updated");
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> removemovie(@PathVariable("id") int movieid)throws Exception{
		Movie m=movieservice.removeMovie(movieid);
		if(m!=null){
		return new ResponseEntity <>(m,HttpStatus.OK);
		}
		throw new MovieException ("Movie Not Found,Sorry Can't be Removed");
	}
	@GetMapping("/viewmovie/{id}")
	public ResponseEntity<?> viewmovie(@PathVariable("id")int movieid)throws MovieException{
		Movie m=movieservice.viewMovie(movieid);
		if(m!=null){
		return new ResponseEntity<>(m,HttpStatus.OK);
		}
		throw new MovieException ("Sorry That Movie Not Found");
	}
	
	@GetMapping("/viewmovielist")
	public ResponseEntity<?> viewmovielist()throws MovieException{
		List<Movie>movielist=movieservice.viewMovieList();
		if(movielist!=null){
			return new ResponseEntity<>(movielist,HttpStatus.OK);
		}
		
			throw new MovieException ("Sorry Movie List Not Found");
		
	}
	
	@GetMapping("/viewmovielistbythrid/{id}")
	public ResponseEntity<?> viewmovielist(@PathVariable ("id") int theatreid)throws MovieException{
		List<Movie>movielist=movieservice.viewMovieList();
		if(movielist!=null){
			return new ResponseEntity<>(movielist,HttpStatus.OK);
		}
		
			throw new MovieException ("Sorry Movie List Not Found");
		
	}
	

	
}