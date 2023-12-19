
package com.learn.app.resource;

import java.util.List;

import com.learn.app.entity.PokemonType;
import com.learn.app.service.PokemonService;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("pokemon")
public class PokemonTypeResource {

    private PokemonService pokemonService;

    @Inject
    public PokemonTypeResource(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PokemonType> getPokemonTypes() {
        return pokemonService.getPokemonTypes();
    }

    @POST
    @Path("/pokemon-type")
    public String createPokemonType(PokemonType pokemonType) {

        return pokemonService.createPokemonType(pokemonType);
    }
}
