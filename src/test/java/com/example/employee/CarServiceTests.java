package com.example.employee;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CarServiceTests {
    
    CarRepository carRepository;
    ArrayList<Car> testlist;
    @BeforeEach
    void init()
    {
        testlist = new ArrayList<Car>();
        testlist.add(new Car());
        testlist.add(new Car());
        testlist.add(new Car());
        testlist.add(new Car());
        testlist.add(new Car());
        carRepository = Mockito.mock( CarRepository.class);
        when( carRepository.findAll()).thenReturn(testlist);
    }

    @Test
    void getAllReturnsAllRecords()
    {
        var sut = new CarService( carRepository );
        assertArrayEquals( testlist.toArray() ,sut.getAll().toArray());            
    }


}
