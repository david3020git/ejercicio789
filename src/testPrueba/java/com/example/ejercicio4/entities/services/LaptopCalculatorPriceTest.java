package com.example.ejercicio4.entities.services;

import com.example.ejercicio4.entities.Laptop;
import com.example.ejercicio4.services.LaptopCalculatorPrice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LaptopCalculatorPriceTest {

    @Test
    void calculatePrice() {
        Laptop laptop = new Laptop(1L,"computer",10.00);
        LaptopCalculatorPrice calculator = new LaptopCalculatorPrice();

        // se jecuta el comportamiento a testear double price= calculator.calculatePrice(book);
        double price = calculator.calculatePrice(laptop);
        System.out.println(price);

        // verificamos si la comportamiento esta correcta
        // assertTrue   evaluar una expresion
        assertTrue(price>0);
    }

}