package resources;

import java.util.List;

public class JsonResponse {

	public List<Movie> movie;
	
	public JsonResponse() {
		movie=null;
	}
	public JsonResponse(List<Movie> movies) {
		this.movie=movies;
	}
}
