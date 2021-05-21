package com.ulco.pokemon.controller;

import com.ulco.pokemon.dto.PokemonDTO;
import com.ulco.pokemon.enums.PokemonTypeEnum;
import com.ulco.pokemon.exception.AlreadyExistException;
import com.ulco.pokemon.exception.NotFoundException;
import com.ulco.pokemon.service.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    private PokemonTypeEnum typeEnum;

    @Autowired
    //@Qualifier("test")
    private IPokemonService pokemonService;

    @GetMapping
    public List<PokemonDTO> getAllPokemon(){
        return pokemonService.getAll();
    }

    @GetMapping("/{id}")
    public PokemonDTO getOnePokemon(@PathVariable Integer id){
        return pokemonService.findById(id);
    }

    @GetMapping("/type")
    public List<PokemonDTO> getAllPokemonByType(@RequestParam(value = "type", required = false) PokemonTypeEnum type){
        return  pokemonService.findByType(type);
    }

    @PostMapping
    public ResponseEntity<Void> createdPokemon(@RequestBody  @Valid PokemonDTO pokemon){
        return  pokemonService.createdPokemon(pokemon);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllPokemon(){
        pokemonService.deleteAllPokemon();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOnePokemon(@PathVariable Integer id){
        pokemonService.deleteOnePokemon(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void upgradePokemon(@PathVariable Integer id, @RequestBody @Valid PokemonDTO updatedPokemon) {
        pokemonService.upgradePokemon(id,updatedPokemon);
    }
}
