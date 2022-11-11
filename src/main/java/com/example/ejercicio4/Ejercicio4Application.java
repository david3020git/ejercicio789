package com.example.ejercicio4;

import com.example.ejercicio4.entities.Laptop;
import com.example.ejercicio4.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio4Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Ejercicio4Application.class, args);
		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);

		/**
		 * Create a new laptop
		 */
		Laptop laptop1 = new Laptop(1L, "OrdenadorMesa",500.50 );
		Laptop laptop2 = new Laptop(2L, "Portatil",190.56 );

		/**
		 * Save Laptop
		 */
		laptopRepository.save(laptop1);
		laptopRepository.save(laptop2);
		System.out.println("ordenadores registrados " + laptopRepository.findAll().size());




	}

}
