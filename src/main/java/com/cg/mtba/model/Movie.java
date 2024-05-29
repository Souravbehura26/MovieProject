package com.cg.mtba.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity(name="movie")
@Table(name="movie_table")
public class Movie {

	@Id
	private int movieId;
	@Column(name="movie_name",length=25)
	private String movieName;
	@Column(name="movie_genre",length=20)
	private String movieGenre;
	@Column(name="movie_hours",length=15)
	private String movieHours;
	@Column(name="language",length=15)
	private String language;
	@Column(name="description",length=30)
	private String description;
	
	@ManyToOne
	@JoinColumn(name="theatre_id")
	private Theatre theatre;
	
	@OneToOne(mappedBy="movie")
	private Show show;

	
	public Movie() {
		super();
	}
	public Movie(int movieId, String movieName, String movieGenre, String movieHours, String language,
			String description) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieGenre = movieGenre;
		this.movieHours = movieHours;
		this.language = language;
		this.description = description;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}
	public String getMovieHours() {
		return movieHours;
	}
	public void setMovieHours(String movieHours) {
		this.movieHours = movieHours;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", movieGenre=" + movieGenre + ", movieHours="
				+ movieHours + ", language=" + language + ", description=" + description + "]";
	}
}