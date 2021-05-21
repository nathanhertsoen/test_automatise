package com.ulco.pokemon.mapper;

import com.ulco.pokemon.dto.PersonDTO;
import com.ulco.pokemon.model.PersonDO;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-21T19:23:34+0200",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.9 (JetBrains s.r.o.)"
)
@Component
public class IPersonMapperImpl implements IPersonMapper {

    @Override
    public PersonDTO toPersonDTO(PersonDO personDO) {
        if ( personDO == null ) {
            return null;
        }

        PersonDTO personDTO = new PersonDTO();

        personDTO.setId( personDO.getId() );
        personDTO.setFirstname( personDO.getFirstname() );
        personDTO.setLastname( personDO.getLastname() );
        personDTO.setBirthday( personDO.getBirthday() );
        personDTO.setCp( personDO.getCp() );
        personDTO.setEmail( personDO.getEmail() );
        personDTO.setPhone( personDO.getPhone() );

        return personDTO;
    }

    @Override
    public PersonDO toPersonDO(PersonDTO personDTO) {
        if ( personDTO == null ) {
            return null;
        }

        PersonDO personDO = new PersonDO();

        personDO.setId( personDTO.getId() );
        personDO.setFirstname( personDTO.getFirstname() );
        personDO.setLastname( personDTO.getLastname() );
        personDO.setBirthday( personDTO.getBirthday() );
        personDO.setCp( personDTO.getCp() );
        personDO.setEmail( personDTO.getEmail() );
        personDO.setPhone( personDTO.getPhone() );

        return personDO;
    }
}
