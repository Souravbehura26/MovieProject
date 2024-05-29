package com.cg.mtba.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mtba.model.Theatre;

@Repository
public interface ITheatreRepository extends JpaRepository<Theatre, Integer>{

}