package com.ulco.pokemon.mapper;

import com.ulco.pokemon.dto.PokemonDTO;
import com.ulco.pokemon.model.PokemonDO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPokemonMapper {

    PokemonDTO toPokemonDTO(PokemonDO pokemonDO);

    PokemonDO toPokemonDO(PokemonDTO pokemonDTO);
}

