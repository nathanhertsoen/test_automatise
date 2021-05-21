package com.ulco.pokemon.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloWorldControllerTest {

    @Test
    void getUser() {
        HelloWorldController helloWorldController = new HelloWorldController();
        String result = helloWorldController.getUser(null);
        assertEquals(result, "Hello World GET !");
    }
}