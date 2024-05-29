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
import com.cg.mtba.model.Customer;
import com.cg.mtba.service.CustomerServiceImpn;

@CrossOrigin("*")
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerServiceImpn custservice;

	@PostMapping("/add")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) throws CustomerException{
		customer = custservice.addCustomer(customer);
		if(customer!=null) {
			return new ResponseEntity<>(customer,HttpStatus.CREATED);
		}
		throw new CustomerException("Record with same customer ID cannot be added");
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) throws CustomerException{
		customer = custservice.updateCustomer(customer);
		if(customer!=null) {
			return new ResponseEntity<>(customer,HttpStatus.OK);
			}
			throw new CustomerException("Customer not found. Can't be updated");
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable ("id") int custid) throws CustomerException{
		Customer cust = custservice.deleteCustomer(custid);
		if(cust!=null) {
			return new ResponseEntity<>(cust,HttpStatus.OK);
			}
		throw new CustomerException("Customer not found.Can't be deleted");
	}
	
	@GetMapping("/view/{id}")
	public ResponseEntity<?> viewCustomer(@PathVariable ("id") int custid) throws CustomerException{
		Customer cust = custservice.viewCustomer(custid);
		if(cust !=null) {
			return new ResponseEntity<>(cust,HttpStatus.OK);
			}
			throw new CustomerException("Customer with given ID not found..please try again!");
	}
	
	@GetMapping("/viewallcustomer")
	public ResponseEntity<?> viewAllCustomer() throws CustomerException {
		List<Customer> cust = custservice.viewAllCustomer();
		if (cust != null) {
			return new ResponseEntity<>(cust, HttpStatus.OK);
		}
		throw new CustomerException("There is no customer available");
	}
}