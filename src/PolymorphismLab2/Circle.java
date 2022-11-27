package PolymorphismLab2;

public class Circle extends Shape{
    private Double radius;

    public Circle(Double radius){
        this.setRadius(radius);
        calculatePerimeter();
        calculateArea();
    }

    @Override
    public void calculatePerimeter() {
        Double result = 2 * Math.PI * this.radius;
        setPerimeter(result);
    }

    @Override
    public void calculateArea() {
        Double result = Math.PI * this.radius * this.radius;
        setArea(result);
    }

    public final Double getRadius() {
        return this.radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }
}
