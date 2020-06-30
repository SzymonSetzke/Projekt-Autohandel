package com.company;

import com.company.Dealer;
import com.company.Cars;

import java.util.Random;

public class Adrian extends Mechanic {
    private static final Double DEFAULT_GUARANTEE = 0.8;

    public Adrian(String name, Double guarantee) {
        super(name, guarantee);
        this.guarantee=DEFAULT_GUARANTEE;
    }

    public boolean chanceToRepair(){

        if(new Random().nextInt()>=0 && new Random().nextInt()<=80){
            return true;
        }else
            return false;
    }


    @Override
    public void repair(Dealer car, int i, String part) {
        switch(part){
            case "Silnik":
                car.setCash(car.getCash() - 10000.0);
                System.out.println("Wydałeś 10,000 na naprawę silnika");
                if(chanceToRepair()==true){
                    car.getCar(i).getParts().setEngine();
                    System.out.println(part+" został naprawiony");
                    car.getCar(i).setValue(car.getCar(i).getValue()*2);
                }else{
                    System.out.println("Adrianowi nie udało się naprawić  "+part);
                }
                break;
            case "Skrzynia biegów":
                car.setCash(car.getCash() - 5000.0);
                System.out.println("Wydałeś 5,000 na naprawę skrzyni biegów");
                if(chanceToRepair()==true){
                    car.getCar(i).getParts().setGearbox();
                    System.out.println(part+" zostałą naprawiona");
                    car.getCar(i).setValue(car.getCar(i).getValue()*1.5);
                }else{
                    System.out.println("Adrianowi nie udało się naprawić "+part);
                }
                break;
            case "Zawieszenie":
                car.setCash(car.getCash() - 2000.0);
                System.out.println("Wydałeś 2,000 na naprawę zawieszenia");
                if(chanceToRepair()==true){
                    car.getCar(i).getParts().setSuspension();
                    System.out.println(part+" zostało naprawione");
                    car.getCar(i).setValue(car.getCar(i).getValue()*1.2);
                }else{
                    System.out.println("Adrianowi nie udało się naprawić "+part);
                }
                break;
            case "Opony":
                car.setCash(car.getCash() - 5000.0);
                System.out.println("Wydałeś 5,000 na naprawę opon");
                if(chanceToRepair()==true){
                    car.getCar(i).getParts().setTires();
                    System.out.println(part+" zostały naprawione");
                    car.getCar(i).setValue(car.getCar(i).getValue()*1.5);
                }else{
                    System.out.println("Adrianowi nie udało się naprawić "+part);
                }
                break;
            case "Hamulce":
                car.setCash(car.getCash() - 1000.0);
                System.out.println("Wydałeś 1,000 na naprawę hamulców");
                if(chanceToRepair()==true){
                    car.getCar(i).getParts().setBrakes();
                    System.out.println(part+" zostały naprawione");
                    car.getCar(i).setValue(car.getCar(i).getValue()*1.1);
                }else{
                    System.out.println("Adrianowi nie udało się naprawić "+part);
                }
                break;
            default:
                System.out.println("Zły numer byku");
        }

    }
}