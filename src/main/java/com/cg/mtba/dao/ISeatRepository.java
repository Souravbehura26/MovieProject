package com.cg.mtba.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mtba.model.Seat;

@Repository
public interface ISeatRepository  extends JpaRepository<Seat, Integer>{


	
}
