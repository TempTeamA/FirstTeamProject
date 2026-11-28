package controller;

import java.time.LocalDate;

import shared.entites.Car;

public class CarBuilder {
	private int enginePower;
	private String model;
	private LocalDate releaseDate;
	
	public CarBuilder setEnginePower(int enginePower){
        this.enginePower = enginePower;
        return this;
    }

    public CarBuilder setModel(String model){
        this.model = model;
        return this;
    }

    public CarBuilder setReleaseDate(LocalDate releaseDate){
        this.releaseDate = releaseDate;
        return this;
    }
    
    public Car build() {
    	return new Car(enginePower, model, releaseDate);
    }
}
