package PolymorphismEx1;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuel;
    private double consumption;

    public Vehicle(double fuel, double consumption){
        this.fuel = fuel;
        this.consumption = consumption;
    }

    public String drive(double distance) {
        double fuelNeeded = distance * this.consumption;
        if(fuelNeeded > this.fuel){
            return this.getClass().getSimpleName() + " needs refueling";
        }

        this.fuel -= fuelNeeded;

        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format("%s travelled %s km",
                this.getClass().getSimpleName(),
                formatter.format(distance));
    }

    public void refuel(double litters) {
        this.fuel += litters;
    }

    public String toString(){
        //DecimalFormat formatter = new DecimalFormat("##.##");
        //return String.format("%s: %s", this.getClass().getSimpleName(), formatter.format(this.fuel));
        return String.format("%s: %.2f", this.getClass().getSimpleName(), this.fuel);
    }
}
