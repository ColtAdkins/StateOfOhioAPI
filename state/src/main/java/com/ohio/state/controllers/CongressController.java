package com.ohio.state.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ohio.state.models.Senator;
import com.ohio.state.services.RepresentativeRepository;
import com.ohio.state.services.SenatorRepository;
import com.ohio.state.models.Representative;

@RestController
public class CongressController {
	@Autowired
	SenatorRepository senatorRepository;
	@Autowired
	RepresentativeRepository representativeRepository;
	
	@RequestMapping("/")
	public String index() {
		representativeRepository.deleteAll();
		representativeRepository.save(new Representative("Anthony", "Gonzalez", "Yea"));
		representativeRepository.save(new Representative("Steve", "Chabbot", "Nay"));
		representativeRepository.save(new Representative("Brad", "Wenstrup", "Nay"));
		representativeRepository.save(new Representative("Joyce", "Beatty", "Nay"));
		representativeRepository.save(new Representative("Jim", "Jordan", "Nay"));
		representativeRepository.save(new Representative("Bob", "Gibbs", "Nay"));
		representativeRepository.save(new Representative("Bill", "Johnson", "Yea"));
		representativeRepository.save(new Representative("Bob", "Latta", "Nay"));
		representativeRepository.save(new Representative("Warren", "Davidson", "Yea"));
		representativeRepository.save(new Representative("Marcy", "Kaptur", "Yea"));
		representativeRepository.save(new Representative("Mike", "Turner", "Nay"));
		representativeRepository.save(new Representative("Marcia", "Fudge", "Yea"));
		representativeRepository.save(new Representative("Troy", "Balderson", "Yea"));
		representativeRepository.save(new Representative("Tim", "Ryan", "Yea"));
		representativeRepository.save(new Representative("Steve", "Stivers", "Yea"));
		senatorRepository.deleteAll();
		senatorRepository.save(new Senator("Sherrod", "Brown", "Nay"));
		senatorRepository.save(new Senator("Robert", "Portman", "Yea"));
		return "Enter /findallsenators or /findallrepresentatives to view their votes, if you'd like to view an individual congress members vote please enter /senator?id= or /representative?id=";
	}

	@GetMapping("/findallsenators")
	public String getAllSenators(){
		String result = "";
		for(Senator senator : senatorRepository.findAll()) {
			result += senator.toString() + "</br>";
		};
		return result;
	}
	
	@GetMapping("/findallrepresentatives")
	public String getAllRepresentatives(){
		String result = "";
		for(Representative rep : representativeRepository.findAll()) {
			result += rep.toString() + "</br>";
		};
		return result;
	}
	@RequestMapping("/senator")
	public String getSenator(@RequestParam("id") long id) {
		String result = "";
		try {
			result = senatorRepository.findById(id).get().toString();
		} catch(Exception e) {
			return "No senator found with the provided ID: " + id;
		}

		return result;
	}
	@RequestMapping("/representative")
	private String getRepresentative(@RequestParam("id") long id) {
		String result = "";
		try {
			result = representativeRepository.findById(id).get().toString();
		} catch(Exception e) {
			return "No representative found with the provided ID: " + id;
		}
		return result;
	}
}
