package PolymorphismLab2;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    protected abstract void calculatePerimeter();
    protected abstract void calculateArea();

    public double getArea() {
        calculateArea();
        return this.area;
    }

    public double getPerimeter() {
        calculatePerimeter();
        return this.perimeter;
    }

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    protected void setArea(Double area){
        this.area = area;
    }
}
