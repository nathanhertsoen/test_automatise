package com.ulco.pokemon.model;

import com.ulco.pokemon.enums.PokemonTypeEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name ="adresse_postale")
public class AdressePostaleDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(name = "city")
    private  String city;

    @Column(name = "number")
    private  String number;

    @Column(name = "street")
    private  String street;

    @Column(name = "cp")
    private  String cp;
}

