package com.cisco.cmad;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer>, PokemonCustomRepository{
	public Pokemon findById(int id);
	public Pokemon findByName(String name);
	public List<Pokemon> findByType(PokemonType type);
}
