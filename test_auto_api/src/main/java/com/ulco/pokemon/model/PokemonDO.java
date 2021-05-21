package com.ulco.pokemon.model;

import com.ulco.pokemon.dto.PokemonDTO;
import com.ulco.pokemon.enums.PokemonTypeEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name ="pokemon")
public class PokemonDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(name = "name")
    private  String name;

    @Column(name = "taille")
    private  Double taille;

    @Column(name = "poids")
    private  Double poids;

    @Column(name = "letype")
    @Enumerated(EnumType.STRING)
    private PokemonTypeEnum letype;
}

