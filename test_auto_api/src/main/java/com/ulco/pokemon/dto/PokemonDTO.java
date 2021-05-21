package com.ulco.pokemon.dto;

import com.ulco.pokemon.enums.PokemonTypeEnum;
import com.ulco.pokemon.model.PokemonDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ApiModel("Pokemon")
public class PokemonDTO {


    @Null(message = "L'id doit être vide.")
    @ApiModelProperty("Identifiant unique du pokemon.")
    private Integer id;

    @Size(min = 2, max = 15, message = "Le nom doit faire entre 2 et 15 caractères.")
    @NotBlank(message = "Le nom du pokemon ne peut pas être vide.")
    @ApiModelProperty("Nom du pokemon.")
    private  String name;


    @NotNull(message = "La taille du pokemon ne peut pas être nulle.")
    @ApiModelProperty("Taille du pokemon.")
    @Positive
    private  Double taille;


    @NotNull(message = "Le poids du pokemon ne peut pas être null.")
    @ApiModelProperty("Poids du pokemon.")
    @Positive
    private  Double poids;

    @NotNull(message = "Le type du pokemon ne peut pas être null.")
    @ApiModelProperty("Type du pokemon.")
    private  PokemonTypeEnum letype;
}