package Lab5bai2;

public class Shape {
    private String color;
    private boolean filled;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    public Shape(){
        // khởi tạo thông tin mặc định cho Shape
        this.color="red";
        this.filled=true;
    }
    public Shape(String color,boolean filled){
        this.color=color;
        this.filled=filled;
    }
    public String toString(){
        // biểu diễn đối tượng Shape dưới dạng chuỗi
        return this.getColor()+" "+this.filled;
    }
}