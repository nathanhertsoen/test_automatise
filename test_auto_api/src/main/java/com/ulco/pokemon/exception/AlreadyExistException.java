package com.ulco.pokemon.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE)
public class AlreadyExistException extends RuntimeException{
    public AlreadyExistException(){
        super("La ressource n'existe pas");
    }
    public AlreadyExistException(String nsg){
        super(nsg);
    }
}
