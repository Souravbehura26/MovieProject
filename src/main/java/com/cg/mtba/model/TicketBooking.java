package com.cg.mtba.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name="ticketbooking")
@Table(name="ticketbooking_table")
public class TicketBooking {
	@Id
	private int transactionId;
	@Column(name="booking_date",length=20)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private LocalDate bookingDate;
	@Column(name="trans_mode",length=15)
	private String transactionMode;
	@Column(name="trans_status",length=15)
	private String transactionStatus;
	@Column(name="total_cost",length=10)
	private double totalCost;
	
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	
	@OneToOne
	@JoinColumn(name="ticket_id")
	private Ticket ticket;
	
	
	@OneToOne
	@JoinColumn(name="show_id")
	private Show show;
	
	public TicketBooking() {
		super();
	}
	public TicketBooking(int transactionId, LocalDate bookingDate, String transactionMode, String transactionStatus,
			double totalCost) {
		super();
		this.transactionId = transactionId;
		this.bookingDate = bookingDate;
		this.transactionMode = transactionMode;
		this.transactionStatus = transactionStatus;
		this.totalCost = totalCost;
	}
	
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getTransactionMode() {
		return transactionMode;
	}
	public void setTransactionMode(String transactionMode) {
		this.transactionMode = transactionMode;
	}
	public String getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "TicketBooking [transactionId=" + transactionId + ", bookingDate=" + bookingDate + ", transactionMode="
				+ transactionMode + ", transactionStatus=" + transactionStatus + ", totalCost=" + totalCost
				+ ", show=" + show + "]";
	}
	
	

}
