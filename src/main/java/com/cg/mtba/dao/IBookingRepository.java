package com.cg.mtba.dao;

import java.time.LocalDate;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.mtba.model.TicketBooking;

@Repository
public interface IBookingRepository extends JpaRepository<TicketBooking, Integer> {

	@Query("select b from ticketbooking b where b.bookingDate=?1")
	List<TicketBooking> showAllBooking(LocalDate date);
			
	@Query("select b from ticketbooking b join b.show s join s.movie m where m.movieId=?1")
	List<TicketBooking> showAllBooking(int movieId);
	
	@Query("select b from ticketbooking b join b.show s where s.showId=?1")
	List<TicketBooking> showBookingList(int showId);

}
