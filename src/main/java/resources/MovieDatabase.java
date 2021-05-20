package resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.enterprise.context.RequestScoped;
import javax.servlet.annotation.WebServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


@Path("movies")

public class MovieDatabase {
	private static long id=1;
	MovieService  movieService=new MovieService();
	@GET
	@Produces( MediaType.APPLICATION_JSON )
	public Response getMoviesJson(){
		return Response.ok(new JsonResponse(movieService.getAllMovies())).build();
	}

	@GET
	@Produces( MediaType.APPLICATION_XML)
    public Response getMoviesXml(){
		return Response.ok(new XmlResponse(movieService.getAllMovies())).build();
	}


	@POST
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
//	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
//	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response addMovie(Movie movie) {
		Response response=Response.status(201).entity(new ResultResponse(movieService.addMovie(movie,++id),id)).build();
		return response;
	}
	
	
	
	@GET
	@Path("/{id}")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public Response getMovieId(@PathParam("id") long id) {
		Movie movie;
		if((movie=movieService.getMovie(id))!=null) {
			return Response.ok(movie).build();
		}
		return Response.status(404).build();
	}
	
	
	@DELETE
	@Path("/{id}")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public void deleteMovie(@PathParam("id") long id) {
		 movieService.deleteMovie(id);
	}


	@PUT
	@Path("/{id}")
	@Consumes({"application/xml","application/json"})
	@Produces({"application/xml","application/json"})
	public void updateMovie(@PathParam("id") long id,Movie movie) {
		 movieService.updateMovie(id,movie);
	}
	
	@GET
	@Path("find")
	@Produces( MediaType.APPLICATION_XML)
	@Consumes( MediaType.APPLICATION_XML)
	public Response searchMovies(@QueryParam("year") int year,@QueryParam("orderby") String field) {
		return Response.ok(new QueryResponse(movieService.searchMovie(year,field))).build();
		
	}
	@GET
	@Path("find")
	@Produces( MediaType.APPLICATION_JSON)
	@Consumes( MediaType.APPLICATION_JSON)
	public Response searchMoviesJson(@QueryParam("year") int year,@QueryParam("orderby") String field) {
		
		return Response.ok(new JsonQueryResponse(movieService.searchMovie(year,field))).build();
		
	}

	
	
	
}
