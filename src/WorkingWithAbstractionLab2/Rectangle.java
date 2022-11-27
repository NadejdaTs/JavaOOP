package WorkingWithAbstractionLab2;

public class Rectangle{
    private final Point a;
    private final Point b;


    public Rectangle(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public boolean contains(Point p) {
        return p.greaterOrEqual(a) && p.lessOrEqual(b);
    }
}
