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

import com.cg.mtba.exception.ShowException;
import com.cg.mtba.model.Show;
import com.cg.mtba.service.IShowService;

@CrossOrigin("*")
@RestController
@RequestMapping("/show")
public class ShowController {

	@Autowired
	private IShowService showService;

	@PostMapping("/addshow")
	public ResponseEntity<?> addShow(@RequestBody Show show) throws ShowException {
		show = showService.addShow(show);
		if (show != null) {
			return new ResponseEntity<>(show, HttpStatus.CREATED);
		}
		throw new ShowException("Show id exists,it cannot be added");
	}

	@PutMapping("/updateshow")
	public ResponseEntity<?> updateShow(@RequestBody Show show) throws ShowException {
		show = showService.updateShow(show);
		if (show != null) {
			return new ResponseEntity<>(show, HttpStatus.OK);
		}
		throw new ShowException("Show doesnot exist,it cannot be updated");
	}

	@DeleteMapping("/removeshow/{id}")
	public ResponseEntity<Show> removeShow(@PathVariable ("id") int showId) throws ShowException {
		Show s = showService.removeShow(showId);
		if (s != null) {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
		throw new ShowException("Show doesnot exist,it cannot be removed");
	}

	@GetMapping("/viewallshow")
	public ResponseEntity<?> viewAllShows() throws ShowException {
		List<Show> show = showService.viewAllShows();
		if (show != null) {
			return new ResponseEntity<>(show, HttpStatus.OK);
		}
		throw new ShowException("There is no show available");
	}
	
	@GetMapping("/viewshow/{id}")
	public ResponseEntity<?> viewShowById(@PathVariable ("id") int showId) throws ShowException {
		Show s = showService.viewShowById(showId);
		if (s != null) {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
		throw new ShowException("This show is not available");
	}
	
	@GetMapping("/viewshowbythrid/{id}")
	public ResponseEntity<?> viewShowList(@PathVariable ("id") int theatreid) throws ShowException {
		List<Show> showList = showService.viewShowList(theatreid);
		if (showList!= null) {
			return new ResponseEntity<>(showList, HttpStatus.OK);
		}
		throw new ShowException("No show Found");
	}
	
	@GetMapping("/viewshowbymovieid/{id}")
	public ResponseEntity<?> viewShow(@PathVariable ("id") int movieid) throws ShowException {
		Show s = showService.viewShow(movieid);
		if (s!= null) {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}
		throw new ShowException("No show Found");
	}
}