package dev.congquyen.movies.controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.congquyen.movies.model.Movie;
import dev.congquyen.movies.service.MovieService;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
	@Autowired
	private MovieService movieService;
	@GetMapping
	public ResponseEntity<List<Movie>> getallMovies() {
		return new ResponseEntity<List<Movie>>(movieService.AllMovies(),HttpStatus.OK);
	}	
	@GetMapping("/{imdbId}")
	private ResponseEntity<Optional<Movie>> getMovieById(@PathVariable String imdbId)
	{
		return new ResponseEntity<Optional<Movie>>(movieService.getMovieByImdbId(imdbId), HttpStatus.OK);
	}
}	
