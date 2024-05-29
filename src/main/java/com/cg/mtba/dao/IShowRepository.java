package com.cg.mtba.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.mtba.model.Show;

@Repository
public interface IShowRepository extends JpaRepository<Show, Integer> {

	@Query("select s from show s join s.theatre t where t.theatreId=?1")
	List<Show> viewShowList(int theatreid);

	@Query("select s from show s join s.movie m where m.movieId=?1")
	Show viewShow(int movieid);

}
