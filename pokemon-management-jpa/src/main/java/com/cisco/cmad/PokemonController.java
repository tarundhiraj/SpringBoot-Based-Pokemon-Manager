package com.cisco.cmad;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@CrossOrigin
@EnableSwagger2
public class PokemonController {
	@Autowired
	PokemonRepository pokeService;
	
	@RequestMapping(path= "/pokemon", method=RequestMethod.POST)
	public ResponseEntity<Pokemon> add(@RequestBody  Pokemon pokemon){
		pokeService.save(pokemon);
		return new ResponseEntity<Pokemon>(pokemon, HttpStatus.CREATED);
	}
	
	@RequestMapping(path= "/pokemon/id/{id}", method=RequestMethod.GET)
	public ResponseEntity<Pokemon> searchById(@RequestParam  int id){
		Pokemon p = pokeService.findById(id);
		if(p != null) {
			return new ResponseEntity<Pokemon>(p, HttpStatus.OK);
		}else {
			return new ResponseEntity<Pokemon>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path= "/pokemon/name/{name}", method=RequestMethod.GET)
	public ResponseEntity<Pokemon> searchByName(@RequestParam  String name){
		Pokemon p = pokeService.findByName(name);
		if(p != null) {
			return new ResponseEntity<Pokemon>(p, HttpStatus.OK);
		}else {
			return new ResponseEntity<Pokemon>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path= "/pokemon/type/{type}", method=RequestMethod.GET)
	public ResponseEntity<List<Pokemon>> searchByType(@RequestParam  PokemonType type){
		List<Pokemon> pokemons= pokeService.findByType(type);
		if(pokemons.size() > 0) {
			return new ResponseEntity<List<Pokemon>>(pokemons, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Pokemon>>(pokemons, HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(path= "/pokemon/evolutions/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<Pokemon>> evolutions(@RequestParam  int id){
		List<Pokemon> pokemons= pokeService.getEvolutions(id);
		if(pokemons.size() > 0) {
			return new ResponseEntity<List<Pokemon>>(pokemons, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<Pokemon>>(pokemons, HttpStatus.NOT_FOUND);
		}
	}
	
}
