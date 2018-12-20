package Lab5bai2;

class Circle extends Shape{
    final double PI=3.14;
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    Circle(){
        this.radius=1.0;
    }
    Circle(double radius){
        this.radius=radius;
    }
    Circle(double radius,String color,boolean filled){
        this.radius=radius;
        this.setColor(color);
        this.setFilled(filled);
    }
    public double getArea(){
        //Diện tích hình tròn
        return this.radius*this.radius*PI;
    }
    public double getPerimeter(){
        //chu vi hình tròn
        return 2*PI*this.radius;
    }
    public String toString(){
        return this.radius+" "+this.getArea()+" "+this.getPerimeter()+" "+this.getColor()+" "+this.isFilled();
    }

}