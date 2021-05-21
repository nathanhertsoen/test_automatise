package com.ulco.pokemon.controller;


import com.ulco.pokemon.dto.PersonDTO;
import com.ulco.pokemon.model.PersonDO;
import com.ulco.pokemon.repository.IPersonRepository;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

@DataJpaTest
@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
class PersonControllerTest {


    @Autowired
    private IPersonRepository repository;

    @Test
    void getAll() {

        List<PersonDO> result = repository.findAll();
        //System.out.println("findByID ! ")
        ;
        Date date = new Date(1999-06-18);
        //int i = id.intValue();
        //System.out.println("create date ! ");
        List<PersonDTO>  personDTOList = new ArrayList<>();
        PersonDTO personTest = new PersonDTO(1, "Nathan","Hertsoen", date,"59790","test@test","0763196518");
        personDTOList.add(personTest);
        personDTOList.add(personTest);
        personDTOList.add(personTest);
        assertEquals(result.size(),personDTOList.size());

    }

   @Test
    void findById() {
        System.out.println("findById() in ");

        PersonController personController= new  PersonController();
        //System.out.println("controller ! ");

        Optional<PersonDO> personDO = repository.findById(1);

        assertThat(personDO.isPresent() , is(equalTo(true)));

       System.out.println("findById() out ");
    }

    @Test
    void deleteAll() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void save() {
        System.out.println("save() in ");

        Date date = new Date(1999-06-18);
        PersonDTO personTest = new PersonDTO(1, "Wassim","DJAMAA", date,"62100","test@test","0456543212");
        PersonDO savedPerson = repository.save(personTest.toPersonDO());
        assertEquals(personTest,savedPerson.toPersonDTO());

        System.out.println("save() out ");
    }

    @Test
    void updateOne() {
    }
}