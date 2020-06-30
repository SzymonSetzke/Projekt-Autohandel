package com.company;

import java.util.HashSet;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Database{
    public Set<Human> clientDB;
    public Set<Cars> carsDB;

    int randomIndex = ThreadLocalRandom.current().nextInt(0, 5 + 1);

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

    public void setParts(){
        for(Cars car : this.carsDB)
        {
            car.setParts();
        }
    }

    public void waitAWeek(){
        removeCar(getCar(new Random().nextInt(9)));
        removeCar(getCar(new Random().nextInt(9)));
        this.carsDB.add(new Cars());
        this.carsDB.add(new Cars());
        System.out.println("Lista samochodów została zaktualizowana !\\n");
    }

    public String toString(){
        return "Database";
    }

}