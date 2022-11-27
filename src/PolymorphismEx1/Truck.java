package PolymorphismEx1;

public class Truck extends Vehicle{
    private static final double AIR_CONDITIONER_ADDITIONAL_CONSUMPTION = 1.6;

    public Truck(double fuel, double consumption){
        super(fuel, consumption + AIR_CONDITIONER_ADDITIONAL_CONSUMPTION);
    }

    @Override
    public void refuel(double litters){
        super.refuel(litters * 0.95);
    }
}
