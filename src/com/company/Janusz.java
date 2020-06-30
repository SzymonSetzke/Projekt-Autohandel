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
            case "Silnik":
                car.getCar(i).getParts().setEngine();
                car.setCash(car.getCash() - 50000.0);
                car.getCar(i).setValue(car.getCar(i).getValue()*2);
                System.out.println("Wydałeś 50,000 na naprawę silnika");
                break;
            case "Skrzynia biegów":
                car.getCar(i).getParts().setGearbox();
                car.setCash(car.getCash() - 25000.0);
                car.getCar(i).setValue(car.getCar(i).getValue()*1.5);
                System.out.println("Wydałeś 25,000 na naprawę skrzyni biegów");
                break;
            case "Zawieszenie":
                car.getCar(i).getParts().setSuspension();
                car.setCash(car.getCash() - 7000.0);
                car.getCar(i).setValue(car.getCar(i).getValue()*1.2);
                System.out.println("Wydałeś 7,000 na naprawę zawieszenia");
                break;
            case "Opony":
                car.getCar(i).getParts().setTires();
                car.setCash(car.getCash() - 25000.0);
                car.getCar(i).setValue(car.getCar(i).getValue()*1.5);
                System.out.println("Wydałeś 25,000 na naprawę opon");
                break;
            case "Hamulce":
                car.getCar(i).getParts().setBrakes();
                car.setCash(car.getCash() - 4000.0);
                car.getCar(i).setValue(car.getCar(i).getValue()*1.1);
                System.out.println("Wydałeś 4,000 na naprawę hamulców");
                break;
            default:
                System.out.println("Zły numer byku");
        }
    }
}