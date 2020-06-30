package com.company;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Dealer implements Buy, Sell {
    private String name;
    private Double cash;
    private Cars car;
    public ArrayList<Transactions> transactionHistory = new ArrayList<>();
    public Set<Cars> dealerCars;

    public Dealer(String name,Double cash){
        this.name=name;
        this.cash=cash;
        this.dealerCars=new HashSet<Cars>();

    }

    public String getName() {
        return this.name;

    }

    public Cars getCar(Integer i) {
        Cars[] myArray = new Cars[dealerCars.size()];
        dealerCars.toArray(myArray);
        return myArray[i];
    }
    public Double getValue(Integer i){
        Cars[] myArray = new Cars[dealerCars.size()];
        dealerCars.toArray(myArray);
        return myArray[i].getValue();
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
    public void buy(Database carDb, int i) throws Exception {
        if (this.getCash()< carDb.getValue(i)) {
            throw new Exception("Masz za mało gotówki");
        }
        this.setCash(this.getCash() - carDb.getValue(i));
        this.setCash(this.getCash() - carDb.getValue(i));
        this.dealerCars.add(carDb.getCar(i));
        System.out.println("Kupiłeś "+carDb.getCar(i)+" za kwotę: "+ decimalFormat(carDb.getValue(i))+"$" );
        transactionHistory.add(new Transactions(this, carDb,carDb.getCar(i),carDb.getValue(i),LocalDateTime.now()));
        carDb.removeCar(carDb.getCar(i));
        carDb.carsDB.add(new Cars());
    }

    private String decimalFormat(Double value) {
        DecimalFormat decimalFormat =  new DecimalFormat("#0.00");
        return decimalFormat.format(value);
    }

    @Override
    public void sell( Database clientDb, int carId, int clientId) {
        this.setCash(this.getCash() + this.getValue(carId));
        clientDb.setCash(clientDb.getCash(clientId)-this.getValue(carId),clientId);
        transactionHistory.add(new Transactions(this,clientDb.getClient(clientId),this.getCar(carId),this.getValue(carId),LocalDateTime.now()));
        this.removeCar(this.getCar(carId));
        clientDb.clientDB.add(new Human());
        clientDb.clientDB.add(new Human());
    }
    }
