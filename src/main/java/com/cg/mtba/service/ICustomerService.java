package com.cg.mtba.service;

import java.util.List;

import com.cg.mtba.exception.CustomerException;
import com.cg.mtba.model.Customer;


public interface ICustomerService {
	
	public Customer addCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer) throws CustomerException;
	
	public Customer deleteCustomer(int custid) throws CustomerException;
	
	public Customer viewCustomer(int custid) throws CustomerException;
	
	public List<Customer> viewAllCustomer() throws CustomerException;
	
	
}