package com.company;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Cars {

    private final String producer;
    private final String color;
    private final String segment;
    private Integer mileage;
    private Double value;

    public String[] producers ={"VW","Audi","Ferrari","BMW","Kia","Mercedes","Lamborghini","Toyota","Seat","Porsche"};
    public String[] colors ={"White","Grey","Silver","Blue","Yellow","Green","Orange","Black","Red","Purple"};
    public String[] segments ={"Premium", "Standard", "Budget"};

    double randomValue = ThreadLocalRandom.current().nextDouble(3000.0, 500000.0 + 1);
    double randomPremiumValue = ThreadLocalRandom.current().nextDouble(200000.0, 400000.0);
    double randomStandardValue = ThreadLocalRandom.current().nextDouble(30000.0, 150000.0);
    double randomBudgetValue = ThreadLocalRandom.current().nextDouble(5000.0, 20000.0);
    int randomMileage = ThreadLocalRandom.current().nextInt(1000, 300000);

    public Cars() {
        this.producer = producers[new Random().nextInt(producers.length)];
        this.color = colors[new Random().nextInt(colors.length)];;
        this.mileage = randomMileage;
        this.segment = setSegment();
        this.value = setRandomValue();
    }
    public String setSegment(){
        if(this.producer.equals("Ferrari") || this.producer.equals("Porsche") || this.producer.equals("Lamborghini")){
            return segments[0];
        }
        if(this.producer.equals("Audi") || this.producer.equals("BMW") || this.producer.equals("Mercedes") || this.producer.equals("Kia")){
            return segments[1];
        }else{
            return segments[2];
        }
    }

    public String getSegment(){
        return this.segment;
    }

    public Double getValue(){
        return this.value;
    }

    public Double setRandomValue(){
        if(this.segment.equals("Premium")){
            return randomPremiumValue;
        }
        if(this.segment.equals("Standard")){
            return randomStandardValue;
        }else{
            return randomBudgetValue;
        }
    }

    public String toString() {
        return "\n"+this.producer + ", color: " + this.color +", Mileage: " + this.mileage + " KM, Segment: "+this.segment+ ", value: " + decimalFormat(this.value)+"$";
    }
    private String decimalFormat(Double value) {
        DecimalFormat decimalFormat =  new DecimalFormat("#0.00");
        return decimalFormat.format(value);
    }

}