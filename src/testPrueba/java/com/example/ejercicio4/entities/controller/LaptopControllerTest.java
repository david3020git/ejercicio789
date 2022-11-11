package com.example.ejercicio4.entities.controller;

import com.example.ejercicio4.entities.Laptop;
import com.example.ejercicio4.services.LaptopCalculatorPrice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LaptopControllerTest {
    /**
     * Creacion de la estructura para ejecutar los test
     */

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:"+port);

        testRestTemplate = new TestRestTemplate(restTemplateBuilder);


    }

    @DisplayName("contrlador para encontrar todos los ordenadores")
    @Test
    void findAll() {

        ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/laptops", Laptop[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());



    }

    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        //comentario para multiples lineas
        String json = """
                 {            
                                     
                        "title": "test de creacion",
                        "price": 29.95
                      
                 }
                              
                
                """;
        System.out.println("creo el json");
        HttpEntity<String> request = new HttpEntity<>(json, headers);
        ResponseEntity<Laptop> response= testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request, Laptop.class);
        Laptop result = response.getBody();
        //assertEquals(1L, result.);
        System.out.println("todo correcto mi bro");
        assertEquals("test de creacion", result.getTitle());
        //assertEquals("test de creacion", result.getTitle());


    }

    @Test
    void findOneById() {
        ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/api/books/1", Laptop.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

    }



}
