package com.cisco.cmad;

public enum PokemonType {

	WATER("Water"), FIRE("Fire"), GRASS("Grass"), ELECTRIC("Electric"), POISON("Poison"), MYSTIC("Mystic");

	private String type;

	PokemonType(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}
}
