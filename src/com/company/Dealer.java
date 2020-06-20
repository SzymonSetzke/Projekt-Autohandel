package com.company;

import java.util.HashSet;
import java.util.Set;

public class Dealer implements Buy {
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
    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }
    public String toString() {
        return this.name;
    }

    @Override
    public void buy(CarsDB car, int i) {
        this.setCash(this.getCash() - car.getValue(i));
        this.dealerCars.add(car.getCar(i));
        car.removeCar(car.getCar(i));
        car.carsDB.add(new Cars());
    }
}