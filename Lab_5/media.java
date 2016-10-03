/*
	@author (s):
					Viraj Parimi 2015068
					Yashasvi Baweja 2015116 
*/
import java.lang.*;
import java.util.*;
import java.io.*;
abstract class Media implements Comparable<Media>, Serializable {
	private final String title;
	private String artistName, genre, duration;
	private int yearOfRelease, rating;
	private double size;
	public Media(String title) {
		this.title = title;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public void setYearOfRelease(int yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public void setSize(double size) {
		this.size = size;
	}
	public String getTitle() {
		return title;
	}
	public String getArtistName() {
		return this.artistName;
	}
	public String getGenre() {
		return this.genre;
	}
	public String getDuration() {
		return this.duration;
	}
	public int getYearOfRelease() {
		return this.yearOfRelease;
	}
	public int getRating() {
		return this.rating;
	}
	public double getSize() {
		return this.size;
	}
	public int compareTo(Media object) {
		if( object.rating == this.rating ) {
			return 0;
		}
		else if( object.rating > this.rating ) {
			return -1;
		}
		else if( object.rating < this.rating ) {
			return 1;
		}
		return 0;
	}
}
class Audio extends Media {
	private String audioName;
	public Audio(String title) {
		super(title);
	}
	public void setAudioName(String audioName) {
		this.audioName = audioName;
	}
	public String getAudioName() {
		return this.audioName;
	}
}
class Movie extends Media {
	private String director, producer;
	private char certification;
	public Movie(String title) {
		super(title);
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public void setCertification(char certification) {
		this.certification = certification;
	}
	public String getDirector() {
		return this.director;
	}
	public String getProducer() {
		return this.producer;
	}
	public char getCertification() {
		return certification;
	}
}