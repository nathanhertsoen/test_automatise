package com.ulco.pokemon.repository;

import com.ulco.pokemon.model.PersonDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersonRepository extends JpaRepository<PersonDO, Integer> {

    @Query(
            value = "select * from person as u where u.firstname = :firstname",
            nativeQuery = true)
    PersonDO findByNameNativeQuery(@Param("firstname") String firstname);

}