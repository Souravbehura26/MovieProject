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

import com.cg.mtba.exception.CustomerException;
import com.cg.mtba.exception.ShowException;
import com.cg.mtba.exception.TheatreException;
import com.cg.mtba.model.Customer;
import com.cg.mtba.model.Show;
import com.cg.mtba.model.Theatre;
import com.cg.mtba.service.ITheatreService;

@CrossOrigin("*")
@RestController
@RequestMapping("/theatre")
public class TheatreController {

	@Autowired
	private ITheatreService theatreservice;
	
	@PostMapping("/add")
	public ResponseEntity<?> addtheatre(@RequestBody Theatre theatre)throws TheatreException{
		theatre =theatreservice.addTheatre(theatre);
		if(theatre!=null){
		return new ResponseEntity<>(theatre,HttpStatus.CREATED);
		}
		 throw new TheatreException("Theatre Id Exist,Sorry Theatre Can't Be Added");
	}
	
	
	@DeleteMapping("/delete/{theatreid}")
	public ResponseEntity<?> deletetheatre(@PathVariable("theatreid") int tid)throws TheatreException{
		Theatre theatre=theatreservice.deleteTheatre(tid);
		if(theatre!=null){
		return new ResponseEntity<>(theatre,HttpStatus.OK);
		}
		 throw new TheatreException("Theatre Doesn't Exist,Sorry Theatre Can't be deleted");
	}
	
	
	@PutMapping("/update")
	public ResponseEntity<?> updatetheatre(@RequestBody Theatre theatre)throws TheatreException{
		theatre=theatreservice.updateTheatre(theatre);
		if(theatre!=null){
		return new ResponseEntity<>(theatre,HttpStatus.OK);
		}
		 throw new TheatreException("Theatre Doesn't Exist,Sorry Theatre Can't be Updated");
	}
	
	@GetMapping("/viewalltheatre")
	public ResponseEntity<?> viewTheatreList() throws TheatreException {
		List<Theatre> theatreList = theatreservice.viewTheatreList();
		if (theatreList != null) {
			return new ResponseEntity<>(theatreList, HttpStatus.OK);
		}
		throw new TheatreException("There is no theatre available");
	}
	
	@GetMapping("/viewtheatre/{id}")
	public ResponseEntity<?> viewTheatre(@PathVariable ("id") int custid) throws TheatreException{
		Theatre th = theatreservice.viewTheatre(custid);
		if(th !=null) {
			return new ResponseEntity<>(th,HttpStatus.OK);
			}
			throw new TheatreException("No theatre Found for this theatre id!");
	}

}