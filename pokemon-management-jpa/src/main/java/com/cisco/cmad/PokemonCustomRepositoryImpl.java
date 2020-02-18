package com.cisco.cmad;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PokemonCustomRepositoryImpl implements PokemonCustomRepository {
    @PersistenceContext
    EntityManager entityManager;
    
	@Override
	public List<Pokemon> getEvolutions(int id) {
		List<Pokemon> pokemons = new LinkedList<>();
		Pokemon p = getPokemon(id);
		if (p != null) {
			pokemons.add(p);
			evolutions(p.getEvolution(), pokemons);
		}
		return pokemons;
	}
	
	private void evolutions(int id, List<Pokemon> pokemons) {
		Pokemon parent = getPokemon(id);
		if (parent == null) {
			return;
		}
		pokemons.add(parent);
		if (parent.getEvolution() == -1) {
			return;
		} else {
			evolutions(parent.getEvolution(), pokemons);
		}
	}
	
	private Pokemon getPokemon(int id) {
        Query query = entityManager.createNativeQuery("SELECT p.* FROM pokedeck.pokemon as p " +
                "WHERE p.id = ?", Pokemon.class);
        query.setParameter(1, id + "%");
        Pokemon p = (Pokemon)query.getSingleResult();
        return p;
	}

}
