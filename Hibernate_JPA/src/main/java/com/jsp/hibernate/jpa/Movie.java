package com.jsp.hibernate.jpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {
	@Id
	private int movieId;
	private String movieReleasedDate;
	private String movieName;
	private String movieActorName;
	private String movieDirectorName;
	private String movieType;
	
	
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieReleasedDate() {
		return movieReleasedDate;
	}
	public void setMovieReleasedDate(String movieReleasedDate) {
		this.movieReleasedDate = movieReleasedDate;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getMovieActorName() {
		return movieActorName;
	}
	public void setMovieActorName(String movieActorName) {
		this.movieActorName = movieActorName;
	}
	public String getMovieDirectorName() {
		return movieDirectorName;
	}
	public void setMovieDirectorName(String movieDirectorName) {
		this.movieDirectorName = movieDirectorName;
	}
	public String getMovieType() {
		return movieType;
	}
	public void setMovieType(String movieType) {
		this.movieType = movieType;
	}
	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieReleasedDate=" + movieReleasedDate + ", movieName=" + movieName
				+ ", movieActorName=" + movieActorName + ", movieDirectorName=" + movieDirectorName + ", movieType="
				+ movieType + "]";
	}
	
	
	
	
	
	
		
	

}
