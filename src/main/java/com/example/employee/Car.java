package com.example.employee;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Car {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String brand;
    private String model;
    private int price;
    private String carReg;


    public Integer totalCostByBrand(int totalCarsWithBrand)
    {
        return totalCarsWithBrand * price;
    }


    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String n)
    {
        brand = n;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String s)
    {
        model = s;
    }
  
    public void setPrice(int hs)
    {
        price = hs;
    }

    public int getPrice()
    {
        return price;
    }

    public String getCarReg() {
        return carReg;
    }

    public void setCarReg(String cr) {
        this.carReg = cr;
    }

}
