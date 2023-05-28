package dev.congquyen.movies.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.congquyen.movies.Repository.MovieRepository;
import dev.congquyen.movies.model.Movie;

@Service
public class MovieService {
	@Autowired
	private MovieRepository movieRepository;
	public List<Movie> AllMovies(){
		return movieRepository.findAll();
	}
	public Optional<Movie> getMovieByImdbId(String imdbId) {
		return movieRepository.getMovieByImdbId(imdbId);
	}
}
