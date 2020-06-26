package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int selection=0;
        int index=0;
        int carId=0;
        int clientId=0;
       Dealer myShop = new Dealer("Car Shop", 25000.0);

        Database database = new Database();
        for(int i=0;i<10;i++)
        {
            database.carsDB.add(new Cars());
        }
        for(int i=0;i<5;i++)
        {
            database.clientDB.add(new Human());
        }

        System.out.println("Witaj!");
        System.out.println("Zaczynasz posiadając 25000$, nie posiadasz żadnych samochodów, ale masz dostęp do bazy kilkunastu aut, które możesz kupić.");
        System.out.println("Powodzenia!");

        Scanner in = new Scanner(System.in);


        do{
            System.out.println("[1] Twoje samochody");
            System.out.println("[2] Stan konta");
            System.out.println("[3] Komis u Mirka");
            System.out.println("[4] Kup samochód");
            System.out.println("[5] Lista kupców");
            System.out.println("[6] Sprzedaj samochód");
            System.out.println("[8] Lista transakcji");
            System.out.println("[9] Wyjdź");
            selection=in.nextInt();
            switch(selection){
                case 1:
                    System.out.println(myShop.dealerCars);
                    break;
                case 2:
                    System.out.println(myShop.getCash());
                    break;
                case 3:
                    System.out.println(database.carsDB);
                    break;
                case 4:
                    System.out.println("Wybierz samochód (0-9) :");
                    index=in.nextInt();
                    myShop.buy(database,index);
                    break;
                case 5:
                    System.out.println(database.clientDB);
                    break;
                case 6:
                    System.out.println("Wybierz samochód (0-9) :");
                    carId=in.nextInt();
                    System.out.println("Wybierz kupca (0-4) :");
                    clientId=in.nextInt();
                    myShop.sell(database,carId,clientId);
                    break;
                case 8:
                    System.out.println(myShop.transactionHistory);
                    break;
                case 9:
                    System.out.println("Elo");
                    break;
                default:
                    System.out.println("Zły numer byku");

            }
        }while(selection!=9);


    }
}