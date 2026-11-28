package shared.entites;

import java.time.LocalDate;

import shared.entites.abstractions.Entity;

public class Car extends Entity {
    private int enginePower;
    private String model;
    private LocalDate releaseDate;

    public Car(int enginePower, String model, LocalDate releaseDate) {
        this.enginePower = enginePower;
        this.model = model;
        this.releaseDate = releaseDate;
    }

    public int getEnginePower() { return enginePower; }
    public String getModel() { return model; }
    public LocalDate getReleaseDate() { return releaseDate; }
    
    @Override
    public int compareTo(Entity other) {
        int base = super.compareTo(other);   
        if (base != 0) return base;          
        
        if (!(other instanceof Car car)) { return 0; }
            
        int byEnginePower = Integer.compare(this.enginePower, car.getEnginePower());
        if (byEnginePower != 0) return byEnginePower;

        int byModel = this.model.compareTo(car.getModel());
        if (byModel != 0) return byModel;

        return this.releaseDate.compareTo(car.getReleaseDate());
    }
}
