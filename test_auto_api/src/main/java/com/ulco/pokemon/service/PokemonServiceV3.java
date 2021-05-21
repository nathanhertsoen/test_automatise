package com.ulco.pokemon.service;

import com.ulco.pokemon.config.ErrorHandler;
import com.ulco.pokemon.dto.ErrorDTO;
import com.ulco.pokemon.dto.PokemonDTO;
import com.ulco.pokemon.enums.PokemonTypeEnum;
import com.ulco.pokemon.exception.NotFoundException;
import com.ulco.pokemon.mapper.IPokemonMapper;
import com.ulco.pokemon.model.PokemonDO;
import com.ulco.pokemon.repository.IPokemonRepository;
import io.swagger.annotations.ApiOperation;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Profile("db")
public class PokemonServiceV3 implements IPokemonService{

    @Autowired
    private IPokemonRepository pokemonRepository;

    @Autowired
    private IPokemonMapper pokemonMapper;

    @Override
    @ApiOperation("Récupèrer tous les pokemons.")
    public List<PokemonDTO> getAll() {
        return pokemonRepository.findAll().stream()
                .map(pokemonMapper::toPokemonDTO)
                .collect(Collectors.toList());
    }

    @Override
    @ApiOperation("Récupèrer le pokemon par son id.")
    public PokemonDTO findById(final Integer id) {
        return pokemonRepository.findById(id)
                .map(pokemonMapper::toPokemonDTO)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    @ApiOperation("Récupèrer tous les pokemons d'un type.")
    public List<PokemonDTO> findByType(PokemonTypeEnum type) {
        return pokemonRepository.findByType(type).stream()
                .map(pokemonMapper::toPokemonDTO)
                .collect(Collectors.toList());
    }

    @Override
    @ApiOperation("Créer un pokemon.")
    public ResponseEntity<Void> createdPokemon(PokemonDTO pokemonDTO) {
        PokemonDO pokemonToCreate = pokemonMapper.toPokemonDO(pokemonDTO);
        PokemonDO createPokemon = pokemonRepository.save(pokemonToCreate);
        return  ResponseEntity.noContent().build();
    }

    @Override
    @ApiOperation("Supprimer tous les pokemons.")
    public ResponseEntity<Void> deleteAllPokemon() {
        pokemonRepository.deleteAll();
        return  ResponseEntity.noContent().build();
    }

    @Override
    @ApiOperation("Supprimer le pokemon par son id.")
    public ResponseEntity<Void> deleteOnePokemon(Integer id) {
        findById(id);
        pokemonRepository.deleteById(id);
        return  ResponseEntity.noContent().build();
    }

    @Override
    @ApiOperation("Met à jour un pokemon.")
    public ResponseEntity<Void> upgradePokemon(Integer id, PokemonDTO pokemonDTO) {
        findById(id);
        PokemonDO pokemonToUpdate = pokemonMapper.toPokemonDO(pokemonDTO);
        pokemonToUpdate.setId(id);
        pokemonRepository.save(pokemonToUpdate);
        return  ResponseEntity.noContent().build();

    }
}