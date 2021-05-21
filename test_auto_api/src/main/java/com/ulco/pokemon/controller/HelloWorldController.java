package com.ulco.pokemon.controller;

import ch.qos.logback.classic.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloWorldController {

    @GetMapping
    public String getUser(@RequestParam String name){
        if(name!=null || Objects.nonNull(name)){
            return "Hello  !";
        }
        log.info("Hello world using GET");
        return "Hello World GET !";
    }

}