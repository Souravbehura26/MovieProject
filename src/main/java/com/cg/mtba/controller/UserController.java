package com.cg.mtba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.mtba.exception.TicketException;
import com.cg.mtba.exception.UserException;
import com.cg.mtba.model.Ticket;
import com.cg.mtba.model.User;
import com.cg.mtba.service.IUserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/addnewuser")
	public ResponseEntity<?> addNewUser(@RequestBody User user) throws UserException {
		user=userService.addNewUser(user);
		if(user != null) {
			return new ResponseEntity<>(user,HttpStatus.CREATED);
		}
		throw new UserException("User Exists");

	}
	
	@PostMapping("/signin/{id}/{pwd}")
	public ResponseEntity<?> signIn(@PathVariable ("id") int userId,@PathVariable ("pwd") String password) throws UserException {
		User u=userService.signIn(userId,password);
		if(u != null) {
			return new ResponseEntity<>(u,HttpStatus.OK);
		}
		throw new UserException("User does not Exist");
	}
	
	@PostMapping("/signout")
	public ResponseEntity<?> signOut(@RequestBody User user) throws UserException {
		user=userService.signOut(user);
		String s="User logged out";
		if(user != null) {
			return new ResponseEntity<>(s,HttpStatus.OK);
		}
		throw new UserException("User has not logged in ");

	}
	
	@GetMapping("/viewalluser")
	public ResponseEntity<?> viewUserList() throws UserException{
		List<User>userList  = userService.viewUserList();
		if (userList != null) {
			return new ResponseEntity<>(userList, HttpStatus.OK);
		}
		throw new UserException("There is no user available");
	}

}
