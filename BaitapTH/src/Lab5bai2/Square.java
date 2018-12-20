package Lab5bai2;

class Square extends Rectangle{
    private double side;

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }
    public Square() {
        this.side=this.getLength();
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(double side,String color, boolean filled){
        super(side, side, color, filled);
        this.side = side;
    }

    public String toString() {
        return this.side+" "+this.getArea()+" "+this.getPerimeter()+" "+this.getColor()
                +" "+this.isFilled();
    }
    public static void main(String[] args) {
        System.out.println("Hình tròn");
        Circle c = new Circle(3.8, "blue", true);
        System.out.println(c.toString());
        System.out.println("Hình Vuông");
        Square s=new Square(1.2);
        s=new Square(1.2, "red", false);
        System.out.println(s.toString());

    }
}