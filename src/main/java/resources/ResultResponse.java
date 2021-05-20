package resources;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "result")

public class ResultResponse {
	
	private long id;
	private Movie movie;
	
	MovieDB db;
	  
	public long getId() {
		return id;
	}
		
	public void setId(long id) {

		this.id=id;
		
	}
	
	
	public ResultResponse() {
		movie=null;
	}
	public ResultResponse(Movie movie,long id) {
		this.movie=movie;
		this.id=id;
	
	}
	
	
	
	
}
