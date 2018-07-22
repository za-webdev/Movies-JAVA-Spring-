package com.zoya.movies.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.zoya.movies.models.Actor;
import com.zoya.movies.repositories.ActorRepository;

@Service
public class ActorService {
	
	private ActorRepository actorRepository;
	
	public ActorService(ActorRepository actorRepository) {
		this.actorRepository=actorRepository;
	}
	
	public Actor create(Actor actor) {
		return actorRepository.save(actor);
	}
	
	public ArrayList<Actor> all(){
		return (ArrayList<Actor>) actorRepository.findAll();
	}
	
	public void destroy(Long id) {
        actorRepository.deleteById(id);
    }
	
	public Actor findById(Long id) {
		Optional<Actor> actor = actorRepository.findById(id);
        if (actor.isPresent()){
            return actor.get();
        }else{
            return null;
        }
    }
	
	public void update(Actor actor) {
        actorRepository.save(actor);
    }
}
