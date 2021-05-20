package resources;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "movies")
@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlResponse {

	public List<Movie> movie;
	
	public XmlResponse() {
		movie=null;
	}
	public XmlResponse(List<Movie> movies) {
		this.movie=movies;
	}
 }
