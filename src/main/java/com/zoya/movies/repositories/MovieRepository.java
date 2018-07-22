package com.zoya.movies.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zoya.movies.models.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {


}
