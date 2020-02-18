package com.cisco.cmad;

import java.util.List;

public interface PokemonCustomRepository {
	public List<Pokemon> getEvolutions(int id);
}
