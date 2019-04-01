package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.stereotype.Component;

/**
 * Film POJO. Also XML related annotations to help generate XML format.
 * 
 * @author Kashif Ahmed - 18061036
 * @version 1.0
 * @since   March 2019
 */
@Component
@Entity
@XmlRootElement 
@XmlType(propOrder = { "id", "title", "year", "director", "stars", "review" })
@Table(name="films")
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	int id;
	@Column(name="title")
	String title;
	@Column(name="year")
	int year;
	@Column(name="director")
	String director;
	@Column(name="stars")
	String stars;
	@Column(name="review")
	String review;
   
   // Default constructor
   public Film() {}
   
   // Custom constructor
   public Film(String title, int year, String director, String stars, String review) {
		this.title = title;
		this.year = year;
		this.director = director;
		this.stars = stars;
		this.review = review;
	}

    // Getters & Setters
	public int getId() {
		return id;
	}
	@XmlAttribute
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	@XmlElement
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	@XmlElement
	public void setYear(int year) {
		this.year = year;
	}
	public String getDirector() {
		return director;
	}
	@XmlElement
	public void setDirector(String director) {
		this.director = director;
	}
	public String getStars() {
		return stars;
	}
	@XmlElement
	public void setStars(String stars) {
		this.stars = stars;
	}
	public String getReview() {
		return review;
	}
	@XmlElement
	public void setReview(String review) {
		this.review = review;
	}
	
	@Override
	public String toString() {
		return "\n\nID  =  " + id + "    \nTITLE  =  " + title + "    \nYEAR  =  " + year
				+ "    \nDIRECTOR  =  " + director + "    \nSTARS  =  " + stars + "    \nREVIEW  =  " + review;
	}   
	
	/**
	 * This generates CSV format for user.
	 * @return String containing film as CSV format.
	 */
	public String toCSVString() {
		return id + "," + title + "," + year + "," + director + "," + stars + "," + review + "\n";
	}  
}
