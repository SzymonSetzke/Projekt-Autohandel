package com.company;

import java.util.HashSet;
import java.util.Set;

public class Dealer {
    private String name;
    private Double cash;
    private Cars car;
    public Set<Cars> dealerCars;

    public Dealer(String name,Double cash){
        this.name=name;
        this.cash=cash;
        this.dealerCars=new HashSet<Cars>();

    }

    public Cars getCar() {
        return car;

    }


    public void addCar(Cars car) {
        this.car = car;
        this.dealerCars.add(car);
    }

    public void removeCar(Cars car) {
        this.dealerCars.remove(car);
    }
}