package com.cg.mtba.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mtba.model.Ticket;

@Repository
public interface ITicketRepository extends JpaRepository<Ticket,Integer> {
	

}