package resources;

import java.util.List;

public class JsonQueryResponse {

	private List<Long> id;

	public List<Long> getId() {
		return id;
	}

	public void setId(List<Long> id) {
		this.id = id;
	}

	
	
	public JsonQueryResponse(List<Long> id) {
		
		this.id = id;
	}
	
	public JsonQueryResponse() {
		
	}
}
