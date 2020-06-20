package com.company;

import java.util.HashSet;
import java.util.Set;

public class CarsDB {
    public Set<Cars> carsDB;

    public CarsDB(){
        this.carsDB=new HashSet<Cars>();
    }

    public Cars getCar(Integer i) {
        Cars[] myArray = new Cars[carsDB.size()];
        carsDB.toArray(myArray);
        return myArray[i];
    }
    public Double getValue(Integer i){
        double value =0.0;
        Cars[] myArray = new Cars[carsDB.size()];
        carsDB.toArray(myArray);
        return myArray[i].getValue();
    }
    public void removeCar(Cars car) {
        this.carsDB.remove(car);
    }

}