package com.company;

import java.text.DecimalFormat;
import java.time.LocalDateTime;

public class Transactions{
    private Dealer dealer;
    private Human buyer;
    private Database seller;
    private Cars car;
    private Double price;
    private LocalDateTime date;

    public Transactions(Dealer seller, Human buyer, Cars car, Double price, LocalDateTime date){
        this.dealer=seller;
        this.buyer = buyer;
        this.car=car;
        this.price = price;
        this.date = date;

    }
    public Transactions(Dealer buyer, Database seller, Cars car, Double price, LocalDateTime date){
        this.dealer=buyer;
        this.car=car;
        this.seller = seller;
        this.price = price;
        this.date = date;

    }


    public String toString() {
        if(this.buyer == null){
            return "\n"+"Transakcja pomiędzy: " + this.dealer+", a "+ this.seller + "   Samochód: " + this.car + " Cena: " + decimalFormat(this.price)+ ", Data: " + this.date;
        }else{
            return "\n"+"Transakcja pomiędzy: " + this.dealer+", a "+ this.buyer + "   Samochód: " + this.car + " Cena: " + decimalFormat(this.price) + ", Data: " + this.date;
        }

    }
    private String decimalFormat(Double value) {
        DecimalFormat decimalFormat =  new DecimalFormat("#0.00");
        return decimalFormat.format(value);
    }


}