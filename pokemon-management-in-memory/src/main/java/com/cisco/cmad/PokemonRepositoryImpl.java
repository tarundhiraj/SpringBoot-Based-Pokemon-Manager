package com.cisco.cmad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import org.springframework.stereotype.Repository;

@Repository
public class PokemonRepositoryImpl implements PokemonRepository {
	Map<Integer, Pokemon> pokeDeck = new HashMap<Integer, Pokemon>();

	@Override
	public Pokemon add(Pokemon pokemon) {
		pokeDeck.put(pokemon.getId(), pokemon);
		return pokemon;
	}

	@Override
	public Pokemon searchByName(String name) {
		for (Pokemon pokemon : pokeDeck.values()) {
			if (pokemon.getName().contains(name)) {
				return pokemon;
			}
		}
		return null;
	}

	@Override
	public Pokemon searchById(int id) {
		for (Pokemon pokemon : pokeDeck.values()) {
			if (pokemon.getId() == id) {
				return pokemon;
			}
		}
		return null;
	}

	@Override
	public List<Pokemon> getEvolutions(int id) {
		List<Pokemon> pokemons = new ArrayList<>();
		Pokemon p = pokeDeck.get(id);
		if (p != null) {
			pokemons.add(p);
			populateEvolutions(p.getEvolution(), pokemons);
		}
		return pokemons;
	}

	private void populateEvolutions(int id, List<Pokemon> pokemons) {
		Pokemon parent = pokeDeck.get(id);
		if (parent == null) {
			return;
		}
		pokemons.add(parent);
		if (parent.getEvolution() == -1) {
			return;
		} else {
			populateEvolutions(parent.getEvolution(), pokemons);
		}

	}

	@Override
	public List<Pokemon> searchByType(PokemonType type) {
		List<Pokemon> foundPokemons = new ArrayList<>();
		for (Pokemon pokemon : pokeDeck.values()) {
			if (pokemon.getType() == type) {
				foundPokemons.add(pokemon);
			}
		}
		return foundPokemons;
	}

}
