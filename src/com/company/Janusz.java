package com.company;

import com.company.Dealer;
import com.company.Cars;
import com.company.Parts;

public class Janusz extends Mechanic{
    public Janusz(String name, Double guarantee) {
        super(name, guarantee);
    }

    @Override
    public void repair(Dealer car, int i, String part) {

        switch(part){
            case "engine":
                car.getCar(i).getParts().setEngine();
                break;
            case "gearbox":
                car.getCar(i).getParts().setGearbox();
                break;
            case "suspension":
                car.getCar(i).getParts().setSuspension();
                break;
            case "tires":
                car.getCar(i).getParts().setTires();
                break;
            case "brakes":
                car.getCar(i).getParts().setBrakes();
                break;
            default:
                System.out.println("Invalid number");

        }


    }
}