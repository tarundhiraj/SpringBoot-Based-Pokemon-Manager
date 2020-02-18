package com.cisco.cmad;

import java.util.List;


public interface PokemonRepository {
	public Pokemon add(Pokemon pokemon);

	public Pokemon searchByName(String name);

	public Pokemon searchById(int id);

	public List<Pokemon> getEvolutions(int id);

	public List<Pokemon> searchByType(PokemonType type);
}
