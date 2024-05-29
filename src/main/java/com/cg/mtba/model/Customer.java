
package com.cg.mtba.model;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="customer")
@Table(name="customer_table")
public class Customer {

	@Id
	private int customerId;
	@Column(name="customer_name",length=20)
	private String customerName;
	@Column(name="address", length=30)
	private String address;
	@Column(name="mobile_no", length=15)
	private String mobileNumber;
	@Column(name="email_id", length=30)
	private String email;
	@Column(name="password", length=15)
	private String password;
	
	@JsonIgnore
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<TicketBooking> bookings;

	public Customer(int customerId, String customerName, String address, String mobileNumber, String email,
			String password) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
	}
	
	public Customer() {
		super();
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<TicketBooking> getBookings() {
		return bookings;
	}

	public void setBookings(List<TicketBooking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", address=" + address
				+ ", mobileNumber=" + mobileNumber + ", email=" + email + ", password=" + password + "]";
	}
	
}