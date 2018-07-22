package com.zoya.movies.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zoya.movies.models.Actor;
import com.zoya.movies.models.Movie;
import com.zoya.movies.services.ActorService;
import com.zoya.movies.services.MovieService;

@Controller
public class Movies {
	
	private MovieService movieService;
	private ActorService actorService;
	
	public Movies (MovieService movieService, ActorService actorService) {
		this.movieService=movieService;
		this.actorService=actorService;
		
	}
	
	//display all
	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("movie",new Movie());
		model.addAttribute("actor",new Actor());
		model.addAttribute("movies",movieService.all());
		model.addAttribute("actors",actorService.all());
		return "index";
	}
	
	//add a movie
	@PostMapping("/add")
	public String create( @Valid @ModelAttribute("movie") Movie movie ,BindingResult result) {
		if (result.hasErrors()) {
            return "redirect:/add";
		}
		movieService.create(movie);
		return "redirect:/"; 
	}
	
	//delete a movie
	@RequestMapping("/delete/{id}")
    public String destroy(@PathVariable("id") Long id) {
        movieService.destroy(id);
        return "redirect:/";
    }
	
	//view pre populated edit form
	@RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Movie movie = movieService.findById(id);
        if (movie != null){
            model.addAttribute("movie", movie);
            return "edit";
        }else{
            return "redirect:/";
        }
        
	}
	
	//update the edition and save
	
	@PostMapping("/edit/{id}")
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("movie") Movie movie, BindingResult result) {
        if (result.hasErrors()) {
            return "edit";
        }else{
            movieService.update(movie);
            return "redirect:/";
        }
    }
	
	//view seleted movie
	
	@RequestMapping("/display/{id}")
    public String findOne(Model model, @PathVariable("id") Long id) {
        model.addAttribute("movie", movieService.findById(id));
        return "display";
    }
	
	@PostMapping("/cast")
	public String cast(@RequestParam Long actor_id,@RequestParam Long movie_id) {
		Movie movie = movieService.findById(movie_id);
		Actor actor=actorService.findById(actor_id);
		List<Actor> actors=movie.getActors();
		List<Movie> movies=actor.getMovies();
		movies.add(movie);
		actors.add(actor);
		movie.setActors(actors);
		actor.setMovies(movies);
		movieService.update(movie);
		actorService.update(actor);
		
		
		System.out.println(movies);
		return "redirect:/";
	}
	

}
