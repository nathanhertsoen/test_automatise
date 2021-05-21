package com.ulco.pokemon.controller;

import com.ulco.pokemon.dto.PersonDTO;
import com.ulco.pokemon.service.IPersonService;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/persons")
public class PersonController {
    @ApiModelProperty("Powered by CDG Technology ©")

    @Autowired
    private IPersonService personService;

    @GetMapping
    @ApiOperation("Selectionner toutes les personnes.")
    public List<PersonDTO> getAll() {
        return personService.getAll();
    }

    @GetMapping("/{id}")
    @ApiOperation("Selectionner une personne.")
    public PersonDTO findById(@PathVariable Integer id) {
        return personService.findById(id);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    @ApiOperation("Supprimer toutes les personnes.")
    public void deleteAll() {
        personService.deleteAll();
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    @ApiOperation("Supprimer une personne.")
    public void deleteById(
            @PathVariable Integer id) {
        personService.deleteById(id);
    }


    @PostMapping
    @ApiOperation("Créer une personne.")
    public ResponseEntity<Void> save(@RequestBody final PersonDTO personDTO) {
        final PersonDTO createdPerson = personService.save(personDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdPerson.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Mettre à jour une personne.")
    public void updateOne(@PathVariable final Integer id,
                          @RequestBody final PersonDTO personDTO) {
        personService.updateOne(personDTO, id);
    }
}