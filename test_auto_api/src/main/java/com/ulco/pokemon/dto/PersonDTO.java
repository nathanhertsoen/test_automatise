package com.ulco.pokemon.dto;

import com.ulco.pokemon.model.PersonDO;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor // prends tous les paramètres de notre classe en entrée
@NoArgsConstructor // ajouter un constructeur par défaut


public class PersonDTO {

    @ApiModelProperty("id : service d'une personne")
    @Positive(message ="L'id doit être positive")
    @NotNull(message ="L'id ne peut pas être nulle")
    protected Integer id;

    @ApiModelProperty("prénom du patient")
    @NotBlank(message = "La personne a besoin d'un prénom")
    @Size(min = 1, max = 255, message = "la taille du prénom doit être comprise entre 1 et 20 caratères")
    protected String firstname;


    @ApiModelProperty("nom du patient")
    @NotBlank(message = "Le patient a besoin d'un nom de famille")
    @Size(min = 1, max = 255, message = "la taille du nom doit être comprise entre 1 et 20 caratères")
    protected String lastname;

    @JsonFormat(pattern="yyyy-mm-dd", shape = JsonFormat.Shape.STRING)
    @ApiModelProperty("date de début d'hospitalisation")
    @NotNull(message ="L'hospitalisation doit avoir une date de départ")
    private Date birthday;

    @ApiModelProperty("nom du patient")
    @NotBlank(message = "Le patient a besoin d'un nom de famille")
    @Size(min = 1, max = 255, message = "la taille du nom doit être comprise entre 1 et 20 caratères")
    protected String cp;

    @ApiModelProperty("nom du patient")
    @NotBlank(message = "Le patient a besoin d'un nom de famille")
    @Size(min = 1, max = 255, message = "la taille du nom doit être comprise entre 1 et 20 caratères")
    protected String email;

    @ApiModelProperty("nom du patient")
    @NotBlank(message = "Le patient a besoin d'un nom de famille")
    @Size(min = 1, max = 255, message = "la taille du nom doit être comprise entre 1 et 20 caratères")
    protected String phone;

    public PersonDO toPersonDO(){
        PersonDO personDO = new PersonDO();
        personDO.setId(id);
        personDO.setFirstname(firstname);
        personDO.setLastname(lastname);
        personDO.setBirthday(birthday);
        personDO.setCp(cp);
        personDO.setEmail(email);
        personDO.setPhone(phone);

        return personDO;
    }

}