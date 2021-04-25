package com.example.employee;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class CarController {

    @Autowired
    private CarService carService;
    @Autowired
    private CarRepository carRepository;

    @GetMapping(path="/")
    @CrossOrigin()
    String empty()
    {
        return "OK!";
    }



    @GetMapping(path="/cars")
    @CrossOrigin()
    List<Car> getAll(){
        return carService.getAll();
    }

    @GetMapping(path="/car/{id}")
    @CrossOrigin()
    Car getSingle(@PathVariable Integer id){
        return carService.getSingle(id);
    }



    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    @CrossOrigin()
    ResponseEntity<Object> add(@RequestBody Car dbCar){

        carRepository.save( dbCar );

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path( "/{id}" )
                .buildAndExpand( dbCar.getId() )
                .toUri();
        return  ResponseEntity.created( location ).build();

    }

    @PutMapping(path = "/car/{id}", consumes = "application/json", produces = "application/json")
    @CrossOrigin()
    Car update(@PathVariable Integer id, @RequestBody Car updateCar){
        Car dbCar = carService.getSingle(id);
        dbCar.setBrand( updateCar.getBrand());
        dbCar.setModel( updateCar.getModel());
        dbCar.setPrice( updateCar.getPrice());
        dbCar.setCarReg( updateCar.getCarReg());
        carRepository.save( dbCar );
        return dbCar;
    }

    @DeleteMapping(path = "/delete/{id}")
    @CrossOrigin()
    public void delete(@PathVariable Integer id) {
        carRepository.deleteById(id);
    }
    
}
