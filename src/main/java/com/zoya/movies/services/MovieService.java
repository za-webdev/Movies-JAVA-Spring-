package com.zoya.movies.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.zoya.movies.models.Movie;
import com.zoya.movies.repositories.MovieRepository;

@Service
public class MovieService {
	
	private MovieRepository movieRepository;
	
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository=movieRepository;
	}
	
	
	public Movie create(Movie movie) {
		return movieRepository.save(movie);		
	}
	
	public ArrayList<Movie> all(){
		return (ArrayList<Movie>)movieRepository.findAll();
	}
	
	public void destroy(Long id) {
        movieRepository.deleteById(id);
    }
	
	public Movie findById(Long id) {
		Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()){
            return optionalMovie.get();
        }else{
            return null;
        }
    }
	
	public void update(Movie movie) {
        movieRepository.save(movie);
    }
}
