package com.ulco.pokemon.service;

import com.ulco.pokemon.dto.PokemonDTO;
import com.ulco.pokemon.enums.PokemonTypeEnum;
import com.ulco.pokemon.exception.AlreadyExistException;
import com.ulco.pokemon.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Profile("test")
public class PokemonServiceV2 implements IPokemonService{

    private Map<Integer, PokemonDTO> pokemonDTOMap;

    public PokemonServiceV2(){
        pokemonDTOMap = new HashMap<>();

        pokemonDTOMap.put(1,new PokemonDTO(1,"Test", 80.0,80.0, PokemonTypeEnum.EAU));
        pokemonDTOMap.put(2,new PokemonDTO(2,"Test", 80.0,80.0, PokemonTypeEnum.FEU));
        pokemonDTOMap.put(3,new PokemonDTO(3,"Test", 80.0,80.0, PokemonTypeEnum.EAU));
        pokemonDTOMap.put(4,new PokemonDTO(4,"Test", 80.0,80.0, PokemonTypeEnum.PLANTE));
        pokemonDTOMap.put(5,new PokemonDTO(5,"Test", 80.0,80.0, PokemonTypeEnum.FEU));

    }

    @Override
    public List<PokemonDTO> getAll() {
        return pokemonDTOMap.values()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public PokemonDTO findById(Integer id) {
        return  Optional.ofNullable(pokemonDTOMap.get(id)).orElseThrow(NotFoundException::new);
    }

    @Override
    public List<PokemonDTO> findByType(PokemonTypeEnum type) {
       return  Optional.ofNullable(pokemonDTOMap.values().stream()
               .filter(pokemonDTO -> pokemonDTO.getLetype().equals(type))
               .collect(Collectors.toList())).orElseThrow(NotFoundException::new);
    }

    @Override
    public ResponseEntity<Void> createdPokemon(PokemonDTO pokemonDTO) {
        Optional<PokemonDTO> maybePokemon = Optional.ofNullable(pokemonDTOMap.get(pokemonDTO.getId()));
        if(maybePokemon.isPresent()){
            throw new AlreadyExistException();
        }
        pokemonDTOMap.put(pokemonDTO.getId(),pokemonDTO);
        return  ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteAllPokemon() {
        pokemonDTOMap.clear();
        return  ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> deleteOnePokemon(Integer id) {
        findById(id);
        pokemonDTOMap.remove(id);
        return  ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<Void> upgradePokemon(Integer id, PokemonDTO updatedPokemon) {

        PokemonDTO pokemonToUpdate = filterId(id);

        boolean idAlready =
                pokemonDTOMap.keySet().stream()
                .anyMatch(x->x.equals(updatedPokemon.getId()));
        if(idAlready && !id.equals(updatedPokemon.getId())){
            throw new AlreadyExistException();
        }

        deleteOnePokemon(pokemonToUpdate.getId());
        createdPokemon(pokemonToUpdate);
        return  ResponseEntity.noContent().build();
    }

    private PokemonDTO filterId(Integer id){

        PokemonDTO pokemon = pokemonDTOMap.get(id);
        return  pokemon;
    }


}
