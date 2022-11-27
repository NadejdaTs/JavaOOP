package EncapsulationEx3;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money){
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    public void buyProduct(Product product){
        if(this.money < product.getCost()){
            String errMsg = String.format("%s can't afford %s", this.name, product.getName());
            throw new IllegalArgumentException(errMsg);
        }
        this.products.add(product);
    }

    private void setName(String name) {
        if(name.trim().length() < 1){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if(money < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

}
