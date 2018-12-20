package Lab6_7;

import java.awt.Color;
import javax.swing.JFrame;
public abstract class Shape {

    protected String color;
    protected boolean filled;
    protected double x;
    protected double y;

    //constructor

    public Shape() {
        this.color="red";
        this.filled=true;
        this.x=0;
        this.y=0;
    }


    public Shape(String color, boolean filled, double x, double y) {
        this.color = color;
        this.filled = filled;
        this.x = x;
        this.y = y;
    }

    // set/get color

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // set/get color

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // set/get x,y

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    abstract public double getArea();
    abstract public void moveTo(double x,double y);


    //ghi de phuong thuc
    @Override
    public String toString() {
        String fill = filled ? "filled" : "non-fill";
        return "{" + this.color + ", " + fill + "}";
    }
}