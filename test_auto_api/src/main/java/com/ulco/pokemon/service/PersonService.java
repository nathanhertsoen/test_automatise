package com.ulco.pokemon.service;

import com.ulco.pokemon.dto.PersonDTO;
import com.ulco.pokemon.mapper.IPersonMapper;
import com.ulco.pokemon.model.PersonDO;
import com.ulco.pokemon.repository.IPersonRepository;

import com.ulco.pokemon.exception.NotFoundException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
//@Primary
//@Profile("development")
@Service("PersonService")
public class PersonService implements IPersonService {

    @Autowired
    private IPersonMapper personMapper;

    @Autowired
    private IPersonRepository personRepository;

    @Override
    public List<PersonDTO> getAll() {
        System.out.println(personRepository.count());
        return personRepository.findAll().stream()
                .map(personMapper::toPersonDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PersonDTO findById(Integer id) {
        return personRepository.findById(id)
                .map(personMapper::toPersonDTO)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public PersonDTO save(PersonDTO personDTO) {

        final PersonDO personToCreate = personMapper.toPersonDO(personDTO);
        final PersonDO createdPerson = personRepository.save(personToCreate);

        return personMapper.toPersonDTO(createdPerson);
    }

    @Override
    public void deleteAll() {
        personRepository.deleteAll();
    }

    @Override
    public void deleteById(Integer id) {
        personRepository.deleteById(id);
    }

    @Override
    public void updateOne(PersonDTO personDTO, Integer id) {

        findById(id);
        PersonDO personToUpdate = personMapper.toPersonDO(personDTO);
        personToUpdate.setId(id);
        personRepository.save(personToUpdate);
    }
}