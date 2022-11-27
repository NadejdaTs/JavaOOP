package PolymorphismLab3;

public abstract class Animal {
    private String name;
    private String favouriteFood;

    protected Animal(String name, String favouriteFood){
        this.setName(name);
        this.setFavouriteFood(favouriteFood);
    }

    public String explainSelf(){
        return String.format("I am %s and my favourite food is %s", this.name, this.favouriteFood);
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setFavouriteFood(String favouriteFood) {
        this.favouriteFood = favouriteFood;
    }
}
