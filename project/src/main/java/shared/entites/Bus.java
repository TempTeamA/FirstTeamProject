package shared.entites;

import shared.entites.abstractions.Entity;

public class Bus extends Entity{

    private int number;
    private String model;
    private int mileage;

    public Bus(int number, String model, int mileage){
        this.number = number;
        this.model = model;
        this.mileage = mileage;
    }

    public int getNumber(){
        return number;
    }

    public String getModel(){
        return model;
    }

    public int getMileage(){
        return mileage;
    }
}
