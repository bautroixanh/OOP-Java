package Lab6_7;

import javax.swing.JFrame;
public class test {
    public static void main(String arg[]) {
        Diagram dia = new Diagram();
        Layer layer = new Layer();

        Rectangle rectangle = new Rectangle();
        Square square = new Square();
        Circle circle = new Circle();
        Triangle triangle = new Triangle();

        layer.addShape(square);
        layer.addShape(circle);
        layer.addShape(triangle);
        layer.addShape(triangle);
        layer.addShape(circle);


        dia.addLayer(layer);
        layer.getList();

        layer.removeDouble();
        dia.getListLayer();


        dia.sortLayer();
//
        dia.getListLayer();

//        //remove
//        System.out.println("After remove:");
//
//        layer.removeTriangle();
//
//        layer.getList();
//
//        dia.addLayer(layer);
//        dia.addLayer(layer);
//        dia.getListLayer();
//
//        //remove dia circle
//        System.out.println("After remove:");
//        dia.removeCirle();
//        dia.getListLayer();

    }
}