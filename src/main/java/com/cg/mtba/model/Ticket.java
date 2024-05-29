package com.cg.mtba.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.BooleanString;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="ticket")
@Table(name="ticket_table")
public class Ticket {
	@Id
	private int ticketId;
	@Column(name="noof_seats",length=10)
	private int noOfSeats;
	@Column(name="ticket_status",length=2)
	private boolean ticketStatus;
	
	@JsonIgnore
	@OneToOne(mappedBy="ticket")
	private TicketBooking bookingRef;
	
	@JsonIgnore
	@OneToMany(mappedBy="ticket",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Seat> seatNumber=new ArrayList<Seat>();
	
	
	public Ticket() {
		super();
	}

	public Ticket(int ticketId, int noOfSeats, boolean ticketStatus) {
		super();
		this.ticketId = ticketId;
		this.noOfSeats = noOfSeats;
		this.ticketStatus = ticketStatus;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public boolean isTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(boolean ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public List<Seat> getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(List<Seat> seatNumber) {
		this.seatNumber = seatNumber;
	}

	public TicketBooking getBookingRef() {
		return bookingRef;
	}

	public void setBookingRef(TicketBooking bookingRef) {
		this.bookingRef = bookingRef;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", noOfSeats=" + noOfSeats + ", ticketStatus=" + ticketStatus
				+ ", bookingRef=" + bookingRef + "]";
	}
	

}
