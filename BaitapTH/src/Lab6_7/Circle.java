package Lab6_7;
import java.awt.Color;
import java.awt.Graphics;
public class Circle extends Shape {
    private final double PI = Math.PI;
    private double radius;

    public Circle() {
        this.radius = 1;
    }

    /**
     *
     * @param radius
     * @param color
     * @param filled
     * @param x
     * @param y
     */
    public Circle(double radius, String color, boolean filled, double x, double y) {
        this.filled = filled;
        this.radius = radius;
        this.color = color;
        super.setX(x);
        super.setY(y);
    }


    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    public double getArea() {
        return PI * radius * radius;
    }

    @Override
    public void moveTo(double x, double y) {
        super.setX(x);
        super.setY(y);
    }


    /**
     *
     * @return
     */
    public double getPerimeter() {
        return 2 * PI * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "PI=" + PI +
                ", radius=" + radius +
                '}';
    }
}