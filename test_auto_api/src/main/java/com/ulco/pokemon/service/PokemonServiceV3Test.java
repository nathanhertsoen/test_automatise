package com.ulco.pokemon.service;

import com.ulco.pokemon.dto.PokemonDTO;
import com.ulco.pokemon.enums.PokemonTypeEnum;
import com.ulco.pokemon.mapper.IPokemonMapper;
import com.ulco.pokemon.repository.IPokemonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PokemonServiceV3Test implements IPokemonService{

    @Autowired
    private IPokemonRepository pokemonRepository;

    @Autowired
    private IPokemonMapper pokemonMapper;


    @Test
    void deleteOnePokemon() {

        Integer id = 1;
        pokemonRepository.deleteById(id);
        assertNull(findById(id));
    }

    @Override
    public List<PokemonDTO> getAll() {
        return null;
    }

    @Override
    public PokemonDTO findById(Integer id) {
        return null;
    }

    @Override
    public List<PokemonDTO> findByType(PokemonTypeEnum type) {
        return null;
    }

    @Override
    public ResponseEntity<Void> createdPokemon(@Valid PokemonDTO pokemon) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteAllPokemon() {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteOnePokemon(@Valid Integer id) {
        return null;
    }

    @Override
    public ResponseEntity<Void> upgradePokemon(@Valid Integer id, PokemonDTO pokemon) {
        return null;
    }
}