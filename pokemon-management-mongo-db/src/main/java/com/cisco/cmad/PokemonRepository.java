package com.cisco.cmad;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends MongoRepository<Pokemon, Integer>{
	public Pokemon findById(int id);
	public Pokemon findByName(String name);
	public List<Pokemon> findByType(PokemonType type);
}
