package Lab5bai2;

class Rectangle extends Shape{
    private double width;
    private double length;

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    Rectangle() {
        this.length=1.0;
        this.width=1.0;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        //kế thừa từ lớp cha Shape
        super(color, filled);
        this.width = width;
        this.length = length;
    }
    public double getArea(){
        return this.length*this.width;
    }
    public double getPerimeter(){
        return 2*(this.length+this.width);
    }
    public String toString(){
        return this.width+" "+this.length+" "+this.getArea()+" "+this.getPerimeter()+
                " "+this.getColor()+" "+this.isFilled();
    }
}