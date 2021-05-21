package com.ulco.pokemon.service;

import com.ulco.pokemon.dto.PersonDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IPersonService {




    List<PersonDTO> getAll();
    PersonDTO findById(Integer id);

    PersonDTO save(PersonDTO personDTO);
    void updateOne(PersonDTO personDTO, Integer id);

    void deleteById(Integer id);
    void deleteAll();

}
