package com.ulco.pokemon.model;

import com.ulco.pokemon.dto.PersonDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name ="person")
public class PersonDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "firstname")
    private  String firstname;

    @Column(name = "lastname")
    private  String lastname;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "cp")
    private String cp;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    public PersonDO() {
    }

    @Transient
    public PersonDTO toPersonDTO() {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(id);
        personDTO.setFirstname(firstname);
        personDTO.setLastname(lastname);
        personDTO.setBirthday(birthday);
        personDTO.setCp(cp);
        personDTO.setEmail(email);
        personDTO.setPhone(phone);

        return personDTO;
    }

}

