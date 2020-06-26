package com.company;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Human {
    private final String firstName;
    private static int nextId = 1;
    private Double cash;
    private Cars car;
    double randomCash = ThreadLocalRandom.current().nextDouble(10000.0, 300000.0 + 1);
    public Set<Cars> myCars;

    public Human() {
        this.firstName = "client " + Human.nextId++;
        this.cash = randomCash;
        this.myCars=new HashSet<Cars>();
    }
    public void addCar(Cars car) {
        this.car = car;
        this.myCars.add(car);
    }
    public Double getCash(){
        return this.cash;
    }
    public void setCash(Double cash){
        this.cash=cash;
    }
    public String toString() {
        return "Klient: " + this.firstName + ", Gotówka: " + decimalFormat(this.cash);
    }
    private String decimalFormat(Double value) {
        DecimalFormat decimalFormat =  new DecimalFormat("#0.00");
        return decimalFormat.format(value);
    }

}