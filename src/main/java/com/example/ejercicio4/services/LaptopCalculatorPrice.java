package com.example.ejercicio4.services;

import com.example.ejercicio4.entities.Laptop;

public class LaptopCalculatorPrice {
    public double calculatePrice(Laptop laptop) {
        double price = laptop.getPrice();

        // si el libro tieene mas de 300 paginas tiene un recago de 5 euros
        if (laptop.getPrice() > 300){
            price += 5;

        }
        //envio
        price += 2.99;
        return price;


    }
}
