package com.ulco.pokemon.repository;

import com.ulco.pokemon.dto.PokemonDTO;
import com.ulco.pokemon.enums.PokemonTypeEnum;
import com.ulco.pokemon.model.PokemonDO;
import lombok.Getter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IPokemonRepository extends JpaRepository<PokemonDO, Integer> {

    @Query("Select p from PokemonDO p where p.letype = :letype")
    List<PokemonDO> findByType(@Param("letype")PokemonTypeEnum letype);

}