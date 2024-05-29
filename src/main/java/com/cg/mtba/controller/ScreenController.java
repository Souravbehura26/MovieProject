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

import com.cg.mtba.exception.BookingException;
import com.cg.mtba.exception.MovieException;
import com.cg.mtba.exception.ScreenException;
import com.cg.mtba.model.Movie;
import com.cg.mtba.model.Screen;
import com.cg.mtba.model.TicketBooking;
import com.cg.mtba.service.IScreenService;

@CrossOrigin("*")
@RestController
@RequestMapping("/screen")
public class ScreenController {

	@Autowired
	private IScreenService screenService;

	@PostMapping("/add")
	public ResponseEntity<?> addScreen(@RequestBody Screen screen) throws ScreenException {
		screen = screenService.addScreen(screen);
		if (screen != null) {
			return new ResponseEntity<>(screen, HttpStatus.CREATED);
		}
		throw new ScreenException("Screen id exists,it cannot be added");
	}

	@PutMapping("/update")
	public ResponseEntity<?> updateScreen(@RequestBody Screen screen) throws ScreenException {
		screen = screenService.updateScreen(screen);
		if (screen != null) {
			return new ResponseEntity<>(screen, HttpStatus.OK);
		}
		throw new ScreenException("Screen doesnot exist,it cannot be updated");
	}

	@DeleteMapping("/delete/{sid}")
	public ResponseEntity<?> deleteScreen(@PathVariable("sid") int id) throws ScreenException {
		Screen screen = screenService.deleteScreen(id);
		if (screen != null) {
			return new ResponseEntity<>(screen, HttpStatus.OK);
		}
		throw new ScreenException("Screen doesnot exist,it cannot be removed");
	}
	
	@GetMapping("/viewscreenlist")
	public ResponseEntity<?> viewScreenList() throws ScreenException {
		List<Screen> screenList = screenService.viewScreenList();
		if (screenList != null) {
			return new ResponseEntity<>(screenList, HttpStatus.OK);
		}
		throw new ScreenException("Sorry no Screen Not Found");
	}
	
	@GetMapping("/viewscreen/{id}")
	public ResponseEntity<?> viewScreen(@PathVariable ("id") int screenid) throws ScreenException{
		Screen screen = screenService.viewScreen(screenid);
		if(screen != null ) {
			return new ResponseEntity<Screen>(screen,HttpStatus.OK);
		}
		throw new ScreenException("No history found for this booking by this transaction id");
	}
}