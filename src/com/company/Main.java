package com.company;

public class Main {

    public static void main(String[] args) {
       Dealer myShop = new Dealer("Car Shop", 25000.0);

        CarsDB db = new CarsDB();
        for(int i=0;i<=10;i++)
        {
            db.carsDB.add(new Cars());
        }
        System.out.println("Witaj!");
        System.out.println("Zaczynasz posiadając 25000$, nie posiadasz żadnych samochodów, ale masz dostęp do bazy kilkunastu aut, które możesz kupić.");
        System.out.println("Aby wygrać uzbieraj 50000$");
        myShop.addCar(new Cars());
        System.out.println(myShop.dealerCars);
        System.out.println(db.carsDB);

    }
}
