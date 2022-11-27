package EncapsulationEx4;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight){
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if(!toppingType.equals("meat") && !toppingType.equals("veggies") && !toppingType.equals("cheese") && !toppingType.equals("sauce")){
            String errMsg = String.format("Cannot place %s on top of your pizza.", toppingType);
            throw new IllegalArgumentException(errMsg);
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if(weight < 1 || weight > 50){
            String errMsg = String.format("%s weight should be in the range [1..50].", toppingType);
            throw new IllegalArgumentException(errMsg);
        }
        this.weight = weight;
    }

    public double calculateCalories(){
        //(2 * weight) * toppingType modifier
        double toppingTypeModifier = getToppingTypeModifier(this.toppingType);
        return (2 * weight) * toppingTypeModifier;
    }

    private double getToppingTypeModifier(String toppingType) {
        if(toppingType.equals("Meat")){
            return 1.2;
        }else if(toppingType.equals("Veggies")){
            return 0.8;
        }else if(toppingType.equals("Cheese")){
            return 1.1;
        }else if(toppingType.equals("Sauce")){
            return 0.9;
        }else{
            return 0;
        }
    }
}
