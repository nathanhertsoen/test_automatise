package com.ulco.pokemon.service;

import com.ulco.pokemon.dto.PokemonDTO;
import com.ulco.pokemon.enums.PokemonTypeEnum;
import com.ulco.pokemon.exception.AlreadyExistException;
import com.ulco.pokemon.exception.NotFoundException;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Profile("prod")
public class PokemonService implements IPokemonService{

    private static List<PokemonDTO> pokemonList;

    public PokemonService(){
        pokemonList = new ArrayList<>();

        pokemonList.add(new PokemonDTO( 0,"Carapus",50.0,60.0, PokemonTypeEnum.EAU ));
        pokemonList.add(new PokemonDTO( 1,"Pikachu",50.0,60.0, PokemonTypeEnum.EAU ));
        pokemonList.add(new PokemonDTO( 2,"Salamèche",50.0,60.0, PokemonTypeEnum.FEU ));
        pokemonList.add(new PokemonDTO( 3,"Onix",50.0,60.0, PokemonTypeEnum.EAU ));
        pokemonList.add(new PokemonDTO( 4,"Métamorphe",50.0,60.0, PokemonTypeEnum.EAU ));
        pokemonList.add(new PokemonDTO( 5,"Draco",50.0,60.0, PokemonTypeEnum.FEU ));
    }

    public List<PokemonDTO> getAll(){
        return pokemonList;
    }

    @Override
    public  PokemonDTO findById(Integer id){
        return filterId(id);
    }

    @Override
    public  List<PokemonDTO> findByType(PokemonTypeEnum type){
        if (Objects.isNull(type)) {
            return getAll();
        }
        return  pokemonList.stream().filter(PokemonDTO -> PokemonDTO.getLetype().equals(type)).collect(Collectors.toList());
    }

    public ResponseEntity<Void> createdPokemon(PokemonDTO pokemon){
        pokemon.setId(PokemonLastId());
        pokemonList.add(pokemon);

        return ResponseEntity.created(locationReturn(pokemon)).build();
    }

    public ResponseEntity<Void> upgradePokemon(Integer id, PokemonDTO updatedPokemon){
        checkIfPokemonExistForId(updatedPokemon.getId(), Optional.of(updatedPokemon));

        PokemonDTO pokemonToUpdate = filterId(id);

        pokemonToUpdate.setId(updatedPokemon.getId());
        pokemonToUpdate.setName(updatedPokemon.getName());
        pokemonToUpdate.setTaille(updatedPokemon.getTaille());
        pokemonToUpdate.setPoids(updatedPokemon.getPoids());
        pokemonToUpdate.setLetype(updatedPokemon.getLetype());

        return ResponseEntity.created(locationReturn(updatedPokemon)).build();
    }

    public ResponseEntity<Void> deleteAllPokemon(){
        pokemonList.clear();
        return  ResponseEntity.noContent().build();
    }

    public ResponseEntity<Void> deleteOnePokemon(Integer id){
        PokemonDTO pokemonDelete = filterId(id);
        pokemonList.remove(pokemonDelete);
        return  ResponseEntity.noContent().build();
    }

    /*private void checkIfPokemonExistForId(Integer id, PokemonDTO pokemonUp){
        boolean idAlreadyExist = pokemonList.stream()
                .anyMatch(pokemon -> pokemon.getId().equals(pokemonUp.getId()));

        if (idAlreadyExist && !id.equals(pokemonUp.getId())) {
            throw new AlreadyExistException();
        }
    }*/

    private URI locationReturn(PokemonDTO pokemon){
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/id")
                .buildAndExpand(pokemon.getId()).toUri();
        return  location;
    }

    private PokemonDTO filterId(Integer id){
        PokemonDTO pokemon = pokemonList.stream()
                .filter(pokemonDTO -> pokemonDTO.getId().equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
        return  pokemon;
    }

    private void checkIfPokemonExistForId(Integer id, Optional<PokemonDTO> pokemon){
        if(pokemon.isPresent()){
            boolean idAlreadyExist = pokemonList.stream()
                    .anyMatch(pokemonDTO -> pokemonDTO.getId().equals(pokemon.get().getId()));

            if (idAlreadyExist && !id.equals(pokemon.get().getId())) {
                throw new AlreadyExistException();
            }
        }else{
            boolean idAlreadyExist = pokemonList.stream()
                    .anyMatch(pokemonDTO -> pokemonDTO.getId().equals(id));

            if (idAlreadyExist) {
                throw new AlreadyExistException();
            }
        }
    }

    private Integer PokemonLastId(){
        int maxId = pokemonList.stream()
                .map(PokemonDTO::getId)
                .max(Comparator.naturalOrder())
                .orElse(1);
        maxId+=1;
        return  maxId;
    }
}
