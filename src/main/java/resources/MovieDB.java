package resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MovieDB {

	private static Map<Long,Movie> movies=new HashMap<>();
	
	public static Map<Long,Movie> getMovies(){
		return movies;
	}
	
	public static List<Long> getId() {
		List<Long> ids=movies.keySet().stream().collect(Collectors.toList());
		return ids;
		
	}
	
}
