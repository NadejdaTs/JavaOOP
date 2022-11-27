package PolymorphismLab2;

public class Rectangle extends Shape{
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width){
        this.height = height;
        this.width = width;
    }

    @Override
    protected void calculatePerimeter(){
        Double result = 2 * (this.height + this.width);
        super.setPerimeter(result);
    }

    @Override
    protected void calculateArea() {
        Double result = this.height * this.width;
        super.setArea(result);
    }

    public double getWidth() {
        return this.width;
    }

    public double getHeight() {
        return this.height;
    }
}
