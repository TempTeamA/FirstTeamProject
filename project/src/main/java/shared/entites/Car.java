package shared.entites;

import java.time.LocalDate;

import shared.entites.abstractions.Entity;

public class Car extends Entity{

    private int enginePower;
    private String model;
    private LocalDate releaseDate;

    public Car(int enginePower, String model, LocalDate releaseDate){
        this.enginePower = enginePower;
        this.model = model;
        this.releaseDate = releaseDate;
    }

    public int getEnginePower(){
        return enginePower;
    }

    public String getModel(){
        return model;
    }

    public LocalDate getReleaseDate(){
        return releaseDate;
    }
}
