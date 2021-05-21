package com.ulco.pokemon.service;

import com.ulco.pokemon.dto.PokemonDTO;
import com.ulco.pokemon.enums.PokemonTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Validated
public interface IPokemonService {

    List<PokemonDTO> getAll();
    PokemonDTO findById(Integer id);
    List<PokemonDTO> findByType(PokemonTypeEnum type);
    ResponseEntity<Void> createdPokemon(@Valid PokemonDTO pokemon);
    ResponseEntity<Void> deleteAllPokemon();
    ResponseEntity<Void> deleteOnePokemon(@Valid Integer id);
    ResponseEntity<Void> upgradePokemon(@Valid Integer id, PokemonDTO pokemon);

}
