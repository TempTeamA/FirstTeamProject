package controller;

import shared.entites.Bus;

public class BusBuilder {
	private int number;
    private String model;
    private int mileage;
     
	public BusBuilder setNumber(int number) { 
		this.number = number;
		return this; 
	}
	
	public BusBuilder setModel(String model) { 
		this.model = model;
		return this; 
	}
	
	
	public BusBuilder setMileAge(int mileage) { 
		this.mileage = mileage;
		return this; 
	}	
	
	public Bus build() {
		return new Bus(number, model, mileage);
	}
}
