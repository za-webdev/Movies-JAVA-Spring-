package com.zoya.movies.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zoya.movies.models.Actor;

public interface ActorRepository extends CrudRepository<Actor, Long> {

}
