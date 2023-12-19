package com.learn.app.service;

import com.learn.app.entity.PokemonType;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@ApplicationScoped
@Transactional
public class PokemonServiceImpl implements PokemonService {

    private static final Logger LOGGER = Logger.getLogger(PokemonServiceImpl.class.getName());

    @PersistenceContext(unitName = "pa1")
    private EntityManager entityManager;

    @Override
    public String createPokemonType(PokemonType pokemonType) {
        try {
            LOGGER.info("Creating a pokemon type Thread: " + Thread.currentThread().getName());
            entityManager.getTransaction().begin();
            entityManager.persist(pokemonType);
            entityManager.getTransaction().commit();
            LOGGER.info("Successfully created a pokemon type");
            return "Success";
        }catch (Exception ex) {
            LOGGER.log(Level.SEVERE, "Error in PokemonType creation", ex);
        }
        return "Failed";
    }

    @Override
    public List<PokemonType> getPokemonTypes() {
        LOGGER.info("Getting a pokemon type Thread: "+Thread.currentThread().getName());
        return entityManager.createNamedQuery("getPokemonTypes", PokemonType.class).getResultList();
    }
}
