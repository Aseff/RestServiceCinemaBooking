package resources;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "movies")

public class QueryResponse {
	private List<Long> id;

	public List<Long> getId() {
		return id;
	}

	public void setId(List<Long> id) {
		this.id = id;
	}

	
	
	public QueryResponse(List<Long> id) {
		
		this.id = id;
	}
	
	public QueryResponse() {
		
	}

	
}
