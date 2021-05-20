package resources;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MovieService {
	
	private static final Object lock = new Object();
	private Map<Long,Movie> movies=MovieDB.getMovies();
	

	
	public Map<Long,Movie> getInstance() {
		return movies;
	}
	
	public List<Movie> getAllMovies(){
	  return new ArrayList<Movie>(movies.values());
		
	}
	
	public Movie getMovie(long id) {
		return movies.get(id);
	}
	
	public Movie addMovie(Movie movie,long identifier) {
		// only add one user at a time to the map
	     synchronized (lock)
	     {
	      	movies.put(identifier,movie);

	     }
		return movie;
	}
	
	public void updateMovie(long id,Movie movie) {

		movies.put(id, movie);
	
	}
	
	public Movie deleteMovie(long id) {
		return movies.remove(id);
	}
	
	public List<Long> searchMovie(int year,String field) {
		List<Movie> list=new ArrayList<>();
		List<Long> idList=new ArrayList<Long>();
	
			for (Map.Entry<Long, Movie> entry : movies.entrySet()) {
	            if (entry.getValue().getYear().equals(year)){
	            	list.add(entry.getValue());

	            	
	              }
	         }
	            	
	        if(field.equals("Title")) {
	    		if (list.size() > 0) {
	    			Comparator<Movie> compareByTitle = (Movie o1, Movie o2) -> o1.getTitle().compareTo( o2.getTitle() );
		   				Collections.sort(list, compareByTitle);
	    		}
	        }
	        else if(field.equals("Director")) {
	   			 if (list.size() > 0) {
	   			   Comparator<Movie> compareByDirector = (Movie o1, Movie o2) -> o1.getDirector().compareTo( o2.getDirector() );
	   				Collections.sort(list, compareByDirector);
	   			 }
	   		} 
	            	
	            
			for(Movie movie : list) {
				System.out.println(movie.getTitle());
				for (Map.Entry<Long, Movie> entry : movies.entrySet()) {
				    Long id = entry.getKey();
				    Movie mapMovie = entry.getValue();
				       if(movie.equals(mapMovie)) {
				    		idList.add(id);
				    		
				    	}
				    
				    }
				}
		
		return idList;
		
         }
	}
	
	
	

