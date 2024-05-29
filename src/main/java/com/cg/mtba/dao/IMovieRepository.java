package com.cg.mtba.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.mtba.model.Movie;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer> {
	
	@Query("select m from movie m join m.theatre t where t.theatreId=?1")
	List<Movie> viewMovieList(int theatreid);

}
