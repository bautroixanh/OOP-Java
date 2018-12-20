package Lab6_7;


public class Square extends Rectangle {

    public Square() {
    }

    public Square(String color, boolean filled, double x, double y, Point p1, Point p2, Point p3, Point p4) {
        super(color, filled, x, y, p1, p2, p3, p4);
    }

    @Override
    public String toString() {
        return "Square{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                ", p4=" + p4 +
                '}';
    }
}