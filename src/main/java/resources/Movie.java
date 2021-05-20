package resources;

import java.util.Arrays;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "movie")
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Movie {
	
	private String title;
	
	private Integer year;
	
	private String director;
	 
	private String[] actor;
	
	
	public Movie() {
	
	}


	public Movie(String title, int year, String director, String[] actor) {
		super();
		this.title = title;
		this.year = year;
		this.director = director;
		this.actor = actor;
	}
	



	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Integer getYear() {
		return year;
	}


	public void setYear(Integer year) {
		this.year = year;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public String[] getActor() {
		return actor;
	}


	public void setActor(String[] actor) {
		this.actor = actor;
	}


	@Override
	public String toString() {
		return "MovieDatabase [title=" + title + ", year=" + year + ", director=" + director + ", actor="
				+ Arrays.toString(actor) + "]";
	}


	
	
}
