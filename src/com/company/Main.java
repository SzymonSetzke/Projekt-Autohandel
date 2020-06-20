package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int selection=0;
        int index=0;
       Dealer myShop = new Dealer("Car Shop", 25000.0);

        CarsDB db = new CarsDB();
        for(int i=0;i<=10;i++)
        {
            db.carsDB.add(new Cars());
        }

        CarsDB database = new CarsDB();
        for(int i=0;i<=10;i++)
        {
            database.carsDB.add(new Cars());
        }

        System.out.println("Witaj!");
        System.out.println("Zaczynasz posiadając 25000$, nie posiadasz żadnych samochodów, ale masz dostęp do bazy kilkunastu aut, które możesz kupić.");
        System.out.println("Aby wygrać uzbieraj 50000$");
        myShop.addCar(new Cars());

        Scanner in = new Scanner(System.in);


        do{
            System.out.println("[1] twój garaż");
            System.out.println("[2] Salon samochodowy");
            System.out.println("[3] Kup samochód");
            System.out.println("[0] Wyjdź");
            selection=in.nextInt();
            switch(selection){
                case 1:
                    System.out.println(myShop.dealerCars);
                    break;
                case 2:
                    System.out.println(database.carsDB);
                    break;
                case 3:
                    System.out.println("Wybierz samochód (0-9) :");
                    index=in.nextInt();
                   myShop.buy(database,index);
                    break;
                case 0:
                    System.out.println("________________");
                    break;
                default:
                    System.out.println("Błąd");

            }
        }while(selection!=0);

    }
}
