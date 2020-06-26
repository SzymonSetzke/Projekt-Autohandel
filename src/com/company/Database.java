package com.company;

import java.util.HashSet;

import java.util.Set;

public class Database{
    public Set<Human> clientDB;
    public Set<Cars> carsDB;

    public Database(){
        this.clientDB=new HashSet<Human>();
        this.carsDB=new HashSet<Cars>();
    }
    public Cars getCar(Integer i) {
        Cars[] myArray = new Cars[carsDB.size()];
        carsDB.toArray(myArray);
        return myArray[i];
    }
    public Double getValue(Integer i){
        Cars[] myArray = new Cars[carsDB.size()];
        carsDB.toArray(myArray);
        return myArray[i].getValue();
    }
    public Human getClient(Integer i) {
        Human[] myArray = new Human[clientDB.size()];
        clientDB.toArray(myArray);
        return myArray[i];
    }
    public Double getCash(Integer i){
        Human[] myArray = new Human[clientDB.size()];
        clientDB.toArray(myArray);
        return myArray[i].getCash();
    }
    public void setCash(Double cash, Integer i){
        Human[] myArray = new Human[clientDB.size()];
        clientDB.toArray(myArray);
        myArray[i].setCash(cash);
    }
    public void removeCar(Cars car) {
        this.carsDB.remove(car);
    }

    public String toString(){
        return "Database";
    }

}