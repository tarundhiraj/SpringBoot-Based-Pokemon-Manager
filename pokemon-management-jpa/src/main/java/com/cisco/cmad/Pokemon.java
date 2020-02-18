package com.cisco.cmad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pokemon {
	@Id
	@GeneratedValue
	private int pid;
	private int id;
	private String name;
	private PokemonType type;
	private String[] abilities;
	// evolution = -1 if this is the last pokemon in the evolution
	private int evolution;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PokemonType getType() {
		return type;
	}

	public void setType(PokemonType type) {
		this.type = type;
	}

	public String[] getAbilities() {
		return abilities;
	}

	public void setAbilities(String[] abilities) {
		this.abilities = abilities;
	}

	public int getEvolution() {
		return evolution;
	}

	public void setEvolution(int evolution) {
		this.evolution = evolution;
	}
}
