package com.example.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CarService {

    private final CarRepository carRepository;

    CarService(CarRepository carRepository) {
        super();
        this.carRepository = carRepository;
    }

    List<Car> getAll(){
        var l = new ArrayList<Car>();
        for(Car r : carRepository.findAll())
        {
            l.add(r);
        }
        return l;
    }

    Car getSingle(Integer id){
        return carRepository.findById(id).get();
    }

}
