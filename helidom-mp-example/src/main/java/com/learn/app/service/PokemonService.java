package com.learn.app.service;

import com.learn.app.entity.PokemonType;

import java.util.List;

public interface PokemonService {

    String createPokemonType(PokemonType pokemonType);
    List<PokemonType> getPokemonTypes();
}
