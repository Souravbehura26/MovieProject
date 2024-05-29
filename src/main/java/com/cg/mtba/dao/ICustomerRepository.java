package com.cg.mtba.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mtba.model.Customer;


@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	


}
