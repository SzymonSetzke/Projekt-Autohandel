package com.company;

import com.company.Dealer;
import com.company.Cars;

public class Marian extends Mechanic {
    public Marian(String name, Double guarantee) {
        super(name, guarantee);
    }


    @Override
    public void repair(Dealer car, int i, String part) {

    }
}