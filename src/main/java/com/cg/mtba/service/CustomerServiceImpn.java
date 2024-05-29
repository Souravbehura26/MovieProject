package com.cg.mtba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.cg.mtba.dao.ICustomerRepository;
import com.cg.mtba.exception.CustomerException;
import com.cg.mtba.model.Customer;

@Service
public class CustomerServiceImpn implements ICustomerService{

	@Autowired
	ICustomerRepository custrepo;
	
	public Customer addCustomer(Customer customer) throws CustomerException{
		if(!custrepo.existsById(customer.getCustomerId())) {
			custrepo.save(customer);
			return customer;
		}
		return  null;
	}
	
	public Customer updateCustomer(Customer customer) throws CustomerException {
		if(custrepo.existsById(customer.getCustomerId())) {
			custrepo.save(customer);
			return customer;
		}
		return  null;
	}
	
	public Customer deleteCustomer(int custid) throws CustomerException {
		if(custrepo.existsById(custid)) {
			Customer cust=custrepo.findById(custid).get();
			custrepo.delete(cust);
			return cust;
		}
		return  null;
	}
	
	public Customer viewCustomer(int custid) throws CustomerException {
		if(custrepo.existsById(custid)) {
			Customer c=custrepo.findById(custid).get();
			return c;
		}
		return  null;
	}


	@Override
	public List<Customer> viewAllCustomer() throws CustomerException {
		List<Customer> custList = custrepo.findAll();
		if (custList.size() > 0) {
			return custList;
		}
		return null;
	}
	
}