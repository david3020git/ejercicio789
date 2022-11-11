package com.example.ejercicio4.controller;

import com.example.ejercicio4.entities.Laptop;
import com.example.ejercicio4.repository.LaptopRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {


    private final Logger log= LoggerFactory.getLogger(LaptopController.class);

    /**
     * IMPLMENTAR LOS SIGUIENTES METODOS
     * findAll()->OK
     *
     * findOneById() ->ok
     *
     * create()->ok
     *
     * update()->ok
     *
     * delete()->ok
     *
     * deleteAll()->ok
     */
    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    /**
     * Meteodo para buscar los ordenadores
     *  y porder visualizar el resultado en postaman o en el navegador
     *  http://localhost:8080/api/laptops
     * @return
     */
    @GetMapping("/api/laptops")
    public List<Laptop> listaOrdenadores(){

        return laptopRepository.findAll();

    }

    @PostMapping("/api/laptops")
    public Laptop createOrdenador(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){

        return laptopRepository.save(laptop);


    }

    @GetMapping("/api/laptops/{id}")
    @ApiOperation("buscar un ordenador por clave primaria id long")
    public ResponseEntity<Laptop> findById(@ApiParam("clave primaria tipo Long") @PathVariable Long id){
        Optional<Laptop> booOpt = laptopRepository.findById(id);
        if(booOpt.isPresent()){
            return ResponseEntity.ok(booOpt.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/api/laptops/{id}")
    @ApiOperation("actualizar caracteristicas de  un ordenador")
    public ResponseEntity<Laptop> updateOrdenador(@RequestBody Laptop laptop){
        if(laptop.getId()==null){
            log.warn("estas intentando actualizar un libro que no existe");
            return  ResponseEntity.badRequest().build();
        }
        Laptop resutl = laptopRepository.save(laptop);
        return  ResponseEntity.ok(resutl);

    }
    @DeleteMapping("/api/laptops/{id}")
    @ApiIgnore
    public ResponseEntity<Laptop> deleteOrdenador(@PathVariable Long id){
        if(!laptopRepository.existsById(id)){
            log.warn("no eixste el libro que quieres eliminar");
            return  ResponseEntity.notFound().build();
        }
        laptopRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/api/laptops")
    @ApiIgnore
    public ResponseEntity<Laptop> deleteAll( ) {
        // existen diferentes tipos de mensajes log como info dbug son para ayudarnos en ald epuracion de erroes
        log.info(("intentando borrar todos los libros "));
        laptopRepository.deleteAll();
        return  ResponseEntity.notFound().build();
    }


}
