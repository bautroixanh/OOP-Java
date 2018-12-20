package Lab6_7;


import java.awt.Color;
import java.awt.Graphics;
public class Hexagon extends Shape {
    protected Point p1=new Point();
    protected Point p2=new Point();
    protected Point p3=new Point();
    protected Point p4=new Point();
    protected Point p5=new Point();
    protected Point p6=new Point();


    public Hexagon(String color, boolean filled, double x, double y, Point p1, Point p2, Point p3, Point p4, Point p5, Point p6) {
        super(color, filled, x, y);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;
        this.p6 = p6;
    }

    public Hexagon() {
        super();
        this.p1.x = 0;
        this.p1.y = 0;
        this.p2.x = 0;
        this.p2.y = 0;
        this.p3.x = 0;
        this.p3.y = 0;
        this.p4.x = 0;
        this.p4.y = 0;
        this.p5.x = 0;
        this.p5.y = 0;
        this.p6.x = 0;
        this.p6.y = 0;
    }

    public String getA() {
        return "{"+p1.x+"-"+p1.y+"}";
    }

    public String getB() {
        return "{"+p2.x+"-"+p3.y+"}";
    }

    public String getC() {
        return "{"+p3.x+"-"+p3.y+"}";
    }

    public String getD() {
        return "{"+p4.x+"-"+p4.y+"}";
    }

    public String getE() {
        return "{"+p5.x+"-"+p5.y+"}";
    }

    public String getF() {
        return "{"+p6.x+"-"+p6.y+"}";
    }

//setter


    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public void setP3(Point p3) {
        this.p3 = p3;
    }

    public void setP4(Point p4) {
        this.p4 = p4;
    }

    public void setP5(Point p5) {
        this.p5 = p5;
    }

    public void setP6(Point p6) {
        this.p6 = p6;
    }

    public double getArea(){
        double s=((p2.x-p1.x)*(p3.y-p1.y)-(p3.x-p1.x)*(p2.y-p1.y))/2;
        return s;
    }

    @Override
    public void moveTo(double x, double y) {
        this.p1.x+=x;
        this.p2.x+=x;
        this.p3.x+=x;
        this.p4.x+=x;
        this.p5.x+=x;
        this.p6.x+=x;

        this.p1.y+=y;
        this.p2.y+=y;
        this.p3.y+=y;
        this.p4.y+=y;
        this.p5.y+=y;
        this.p6.y+=y;

        this.x+=x;
        this.y+=y;

    }

    @Override
    public String toString() {
        return "Hexagon{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                ", p4=" + p4 +
                ", p5=" + p5 +
                ", p6=" + p6 +
                '}';
    }
}