package com.zoya.movies.controllers;



import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.zoya.movies.models.Actor;
import com.zoya.movies.services.ActorService;
import com.zoya.movies.services.MovieService;

@Controller
public class Actors {
	
	private ActorService actorService;
	private MovieService movieService;
	
	public Actors (ActorService actorService,MovieService movieService) {
		this.actorService=actorService;
		this.movieService=movieService;
	}
	
	@RequestMapping("/addActor")
	public String index(Model model,@ModelAttribute("actor") Actor actor){
		model.addAttribute("actor",new Actor());
		model.addAttribute("actors",actorService.all());
		
		return "actor";
	}
	
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("actor") Actor actor ,BindingResult result) {
		if(result.hasErrors()) {
			return "actor";
		}
		else {
		actorService.create(actor);
		}
		return "redirect:/addActor";
	}
	
	@RequestMapping("/edit/actor/{id}")
		public String edit(@PathVariable("id") Long id, Model model) {
		Actor actor = actorService.findById(id);
		if (actor != null){
            model.addAttribute("actor", actor);
            return "editActor";
		}
		else {
			return "redirect:/addActor";
			
		}
	}
	
	@PostMapping("/edit/actor/{id}")
	public String update(@Valid @ModelAttribute("actor") Actor actor ,BindingResult result) {
		if(result.hasErrors()) {
			return "editActor";
		}
		else {
		actorService.update(actor);
		}
		return "redirect:/addActor";
	}
	
	@RequestMapping("/show/actor/{id}")
    public String findOne(Model model, @PathVariable("id") Long id) {
        model.addAttribute("actor", actorService.findById(id));    
        return "showActor";
    }
	
	
	
}
