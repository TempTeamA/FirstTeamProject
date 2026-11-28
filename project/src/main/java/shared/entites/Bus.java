package shared.entites;

import shared.entites.abstractions.Entity;

public class Bus extends Entity {
    private int number;
    private String model;
    private int mileage;

    public Bus(int number, String model, int mileage) {
        this.number = number;
        this.model = model;
        this.mileage = mileage;
    }

    public int getNumber() { return number; }
    public String getModel() { return model; }
    public int getMileage() { return mileage; }
    
    @Override
    public int compareTo(Entity other) {
        int base = super.compareTo(other);   
        if (base != 0) return base;          
        
        if (!(other instanceof Bus bus)) { return 0; }
            
        int byNumber = Integer.compare(this.number, bus.getNumber());
        if (byNumber != 0) return byNumber;

        int byModel = this.model.compareTo(bus.getModel());
        if (byModel != 0) return byModel;

        return Integer.compare(this.mileage, bus.mileage);
    }
}
