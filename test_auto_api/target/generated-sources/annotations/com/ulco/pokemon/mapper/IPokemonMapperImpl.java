package com.ulco.pokemon.mapper;

import com.ulco.pokemon.dto.PokemonDTO;
import com.ulco.pokemon.dto.PokemonDTO.PokemonDTOBuilder;
import com.ulco.pokemon.model.PokemonDO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-21T19:23:33+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.9 (JetBrains s.r.o.)"
)
@Component
public class IPokemonMapperImpl implements IPokemonMapper {

    @Override
    public PokemonDTO toPokemonDTO(PokemonDO pokemonDO) {
        if ( pokemonDO == null ) {
            return null;
        }

        PokemonDTOBuilder pokemonDTO = PokemonDTO.builder();

        pokemonDTO.id( pokemonDO.getId() );
        pokemonDTO.name( pokemonDO.getName() );
        pokemonDTO.taille( pokemonDO.getTaille() );
        pokemonDTO.poids( pokemonDO.getPoids() );
        pokemonDTO.letype( pokemonDO.getLetype() );

        return pokemonDTO.build();
    }

    @Override
    public PokemonDO toPokemonDO(PokemonDTO pokemonDTO) {
        if ( pokemonDTO == null ) {
            return null;
        }

        PokemonDO pokemonDO = new PokemonDO();

        pokemonDO.setId( pokemonDTO.getId() );
        pokemonDO.setName( pokemonDTO.getName() );
        pokemonDO.setTaille( pokemonDTO.getTaille() );
        pokemonDO.setPoids( pokemonDTO.getPoids() );
        pokemonDO.setLetype( pokemonDTO.getLetype() );

        return pokemonDO;
    }
}
