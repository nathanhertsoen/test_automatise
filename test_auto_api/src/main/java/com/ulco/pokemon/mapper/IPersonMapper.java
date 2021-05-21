package com.ulco.pokemon.mapper;

import com.ulco.pokemon.dto.PersonDTO;
import com.ulco.pokemon.model.PersonDO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPersonMapper {

    PersonDTO toPersonDTO(PersonDO personDO);
    PersonDO toPersonDO(PersonDTO personDTO);
}

