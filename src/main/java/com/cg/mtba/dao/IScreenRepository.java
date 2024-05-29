package com.cg.mtba.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.mtba.model.Screen;


@Repository
public interface IScreenRepository extends JpaRepository<Screen,Integer> {

}
