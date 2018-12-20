package Lab6_7;
public class Point {
    public int x,y;
    Point(){
        x=0;
        y=0;
    }
    Point(int x,int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}