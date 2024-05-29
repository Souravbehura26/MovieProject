
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


@Entity(name="theatre")
@Table(name="theatre_table")
public class Theatre {

	@Id
	private int theatreId;
	@Column(name="theatre_name",length=20)
	private String theatreName;
	@Column(name="theatre_city",length=20)
	private String threatreCity;
	@Column(name="manager_name",length=20)
	private String managerName;
	@Column(name="manager_contact",length=20)
	private String managerContact;
	
	@JsonIgnore
	@OneToMany(mappedBy="theatre",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Screen> listofscreens;
	
	@JsonIgnore
	@OneToMany(mappedBy="theatre",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Show> listofshows;
	
	@JsonIgnore
	@OneToMany(mappedBy="theatre",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Movie> listofmovies;
	
	public Theatre() {
		super();
	}
	public Theatre(int theatreId, String theatreName, String threatreCity, String managerName, String managerContact) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.threatreCity = threatreCity;
		this.managerName = managerName;
		this.managerContact = managerContact;
	}
	public int getTheatreId() {
		return theatreId;
	}
	public void setTheatreId(int theatreId) {
		this.theatreId = theatreId;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getThreatreCity() {
		return threatreCity;
	}
	public void setThreatreCity(String threatreCity) {
		this.threatreCity = threatreCity;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerContact() {
		return managerContact;
	}
	public void setManagerContact(String managerContact) {
		this.managerContact = managerContact;
	}
	
	public List<Screen> getListofscreens() {
		return listofscreens;
	}
	public void setListofscreens(List<Screen> listofscreens) {
		this.listofscreens = listofscreens;
	}
	public List<Show> getListofshows() {
		return listofshows;
	}
	public void setListofshows(List<Show> listofshows) {
		this.listofshows = listofshows;
	}
	public List<Movie> getListofmovies() {
		return listofmovies;
	}
	public void setListofmovies(List<Movie> listofmovies) {
		this.listofmovies = listofmovies;
	}
	@Override
	public String toString() {
		return "Threater [theatreId=" + theatreId + ", theatreName=" + theatreName + ", threatreCity=" + threatreCity
				+ ", managerName=" + managerName + ", managerContact=" + managerContact + "]";
	}
	
	
}