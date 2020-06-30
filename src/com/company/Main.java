package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int selection=0;
        int index=0;
        int carId=0;
        int clientId=0;
        int key=0;
        int part=0;
        int numberOfTurns=0;
        String partName;

        Janusz mechanic1 = new Janusz("Janusz",1.0);
        Marian mechanic2 = new Marian("Marian",0.9);
        Adrian mechanic3 = new Adrian("Adrian",0.8);

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
        database.setParts();

        System.out.println("Witaj!");
        System.out.println("Zaczynasz posiadając 25000$, nie posiadasz żadnych samochodów, ale masz dostęp do bazy kilkunastu aut, które możesz kupić.");
        System.out.println("Powodzenia!");

        Scanner in = new Scanner(System.in);

        do{
            System.out.println("[1] Mój komis");
            System.out.println("[2] Otomoto");
            System.out.println("[3] Sprzedaj samochód");
            System.out.println("[4] Mechanik");
            System.out.println("[5] Zaczekaj na nowe ogłoszenia");
            System.out.println("[9] Wyjdź");
            System.out.println();
            System.out.println("Turn: "+ numberOfTurns);
            selection=in.nextInt();
            switch(selection){
                case 1:
                    do{
                        System.out.println("[1] Moje samochody");
                        System.out.println("[2] Stan konta");
                        System.out.println("[3] Historia transakcji");
                        System.out.println("[4] Kup reklamę");
                        System.out.println("[5] Cofnij");
                        key=in.nextInt();
                        switch (key){
                            case 1:
                                System.out.println(myShop.dealerCars);
                                break;
                            case 2:
                                System.out.println(myShop.getCash());
                                break;
                            case 3:
                                System.out.println(myShop.transactionHistory);
                                break;
                            case 5:
                                System.out.println("Cofam");
                                break;
                            default:
                                System.out.println("Zły numer byku");
                        }
                    }while(key!=5);
                    break;
                case 2:
                    do{
                        System.out.println("[1] Pokaż samochody");
                        System.out.println("[2] Kup samochód");
                        System.out.println("[3] Cofnij");
                        key=in.nextInt();
                        switch (key){
                            case 1:
                                System.out.println(database.carsDB);
                                break;
                            case 2:
                                System.out.println("Wybierz samochód (id) :");
                                index=in.nextInt();
                                try {
                                    myShop.buy(database,index);
                                    numberOfTurns++;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 3:
                                System.out.println("Cofam");
                                break;
                            default:
                                System.out.println("Zły numer byku");
                        }
                    }while(key!=3);
                    break;
                case 3:
                    do{
                        System.out.println("[1] Lista chętnych kupców");
                        System.out.println("[2] Sprzedaj samochód kupcowi");
                        System.out.println("[3] Cofnij");
                        key=in.nextInt();
                        switch (key){
                            case 1:
                                System.out.println(database.clientDB);
                                break;
                            case 2:
                                System.out.println(myShop.dealerCars);
                                System.out.println("Wybierz samochód (id) :");
                                carId=in.nextInt();
                                System.out.println("Wybierz kupca (id) :");
                                clientId=in.nextInt();
                                try {
                                    myShop.sell(database,carId,clientId);
                                    numberOfTurns++;
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                break;
                            case 3:
                                System.out.println("Cofam");
                                break;

                            default:
                                System.out.println("Zły numer byku");
                        }
                    }while(key!=3);
                    break;
                case 4:
                    do {
                        System.out.println("Wybierz samochód:");
                        System.out.println("[1] Wybierz samochód do naprawy");
                        System.out.println("Wybierz mechanika:");
                        System.out.println("[2] Mechanik Janusz");
                        System.out.println("[3] Mechanik Marian");
                        System.out.println("[4] Mechanik Adrian");
                        System.out.println("[5] Cofnij");
                        key = in.nextInt();
                        switch (key) {
                            case 1:
                                System.out.println(myShop.dealerCars);
                                System.out.println("Wybierz samochód (id) :");
                                carId = in.nextInt();
                                break;
                            case 2:
                                if (carId!=-1) {
                                    do {
                                        System.out.println("[1] Pokaż części");
                                        System.out.println("Wybierz część do naprawy:    " + "Twoja gotówka: " + myShop.getCash() + "$");
                                        System.out.println("[2] Silnik --- 50,000$");
                                        System.out.println("[3] Skrzynia biegów --- 25,000$");
                                        System.out.println("[4] Zawieszenie --- 7,000$");
                                        System.out.println("[5] Opony --- 25,000$");
                                        System.out.println("[6] Hamulce --- 4,000$");
                                        System.out.println("[7] Cofnij");
                                        part = in.nextInt();
                                        switch (part) {
                                            case 1:
                                                System.out.println(myShop.getCar(carId).getParts());
                                                break;
                                            case 2:
                                                partName = "Silnik";
                                                try {
                                                    mechanic1.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 3:
                                                partName = "Skrzynia biegów";
                                                try {
                                                    mechanic1.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 4:
                                                partName = "Zawieszenie";
                                                try {
                                                    mechanic1.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 5:
                                                partName = "Opony";
                                                try {
                                                    mechanic1.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 6:
                                                partName = "Hamulce";
                                                try {
                                                    mechanic1.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 7:
                                                System.out.println("Cofam");
                                                break;

                                            default:
                                                System.out.println("Zły numer byku");
                                        }
                                    } while (part != 7);
                                } else {
                                    System.out.println("Nie wybrałeś samochodu \n");
                                }
                                break;
                            case 3:
                                if (carId!=-1) {
                                    do {
                                        System.out.println("[1] Pokaż części");
                                        System.out.println("Wybierz część do naprawy:    " + "Twoja gotówka: " + myShop.getCash() + "$");
                                        System.out.println("[2] Silnik --- 30,000$");
                                        System.out.println("[3] Skrzynia biegów --- 15,000$");
                                        System.out.println("[4] Zawieszenie --- 4,000$");
                                        System.out.println("[5] Opony --- 15,000$");
                                        System.out.println("[6] Hamulce --- 2,000$");
                                        System.out.println("[7] Cofnij");
                                        part = in.nextInt();
                                        switch (part) {
                                            case 1:
                                                System.out.println(myShop.getCar(carId).getParts());
                                                break;
                                            case 2:
                                                partName = "Silnik";
                                                try {
                                                    mechanic2.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 3:
                                                partName = "Skrzynia biegów";
                                                try {
                                                    mechanic2.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 4:
                                                partName = "Zawieszenie";
                                                try {
                                                    mechanic2.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 5:
                                                partName = "Opony";
                                                try {
                                                    mechanic2.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 6:
                                                partName = "Hamulce";
                                                try {
                                                    mechanic2.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 7:
                                                System.out.println("Cofam");
                                                break;

                                            default:
                                                System.out.println("Zły numer byku");
                                        }
                                    } while (part != 7);
                                } else {
                                    System.out.println("Nie wybrałeś samochodu \n");
                                }
                                break;
                            case 4:
                                if (carId!=-1) {
                                    do {
                                        System.out.println("[1] pokaż części");
                                        System.out.println("Wybierz część do narawy:    " + "Twoja gotówka: " + myShop.getCash() + "$");
                                        System.out.println("[2] Silnik --- 10,000$");
                                        System.out.println("[3] Skrzynia biegów --- 5,000$");
                                        System.out.println("[4] Zawieszenie --- 2,000$");
                                        System.out.println("[5] Opony --- 5,000$");
                                        System.out.println("[6] Hamulce --- 1,000$");
                                        System.out.println("[7] Cofnij");
                                        part = in.nextInt();
                                        switch (part) {
                                            case 1:
                                                System.out.println(myShop.getCar(carId).getParts());
                                                break;
                                            case 2:
                                                partName = "Silnik";
                                                try {
                                                    mechanic3.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 3:
                                                partName = "Skrzynia biegów";
                                                try {
                                                    mechanic3.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 4:
                                                partName = "Zawieszenie";
                                                try {
                                                    mechanic3.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 5:
                                                partName = "Opony";
                                                try {
                                                    mechanic3.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 6:
                                                partName = "Hamulce";
                                                try {
                                                    mechanic3.repair(myShop, carId, partName);
                                                    numberOfTurns++;
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                }
                                                break;
                                            case 7:
                                                System.out.println("Cofam");
                                                break;

                                            default:
                                                System.out.println("Zły numer byku");
                                        }
                                    } while (part != 7);
                                } else {
                                    System.out.println("Nie wybrałeś samochodu \n");
                                }
                                break;
                            case 5:
                                System.out.println("Cofam");
                                break;
                            default:
                                System.out.println("Zły numer byku");
                        }
                    }while(key!=5);
                    break;
                case 5:
                    database.waitAWeek();
                    numberOfTurns++;
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