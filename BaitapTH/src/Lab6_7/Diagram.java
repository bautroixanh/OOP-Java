package Lab6_7;

import java.util.ArrayList;

public class Diagram {
    private ArrayList<Layer> listLayer = new ArrayList<Layer>();

    public void addLayer(Layer layer) {
        listLayer.add(layer);
    }

    public ArrayList<Layer> getListLayer() {
        for (int i = 0; i < listLayer.size(); i++) {
            if(listLayer.get(i).isVisible()){
                System.out.println("#Layer " + i);
                listLayer.get(i).getList();
            }
        }
        return listLayer;
    }


    public void sortLayer() {
        Layer circles = new Layer();
        Layer triangles = new Layer();
        Layer rectangles = new Layer();
        Layer squares = new Layer();
        Layer hexagons = new Layer();

        for (int i = 0; i < listLayer.size(); i++) {
            for (int j = 0; j < listLayer.get(i).getShape().size() ; j++) {
                Shape shape=listLayer.get(i).getShape().get(j);
                if (shape instanceof Circle) circles.addShape(shape);
                if (shape instanceof Triangle) triangles.addShape(shape);
                if (shape instanceof Rectangle) rectangles.addShape(shape);
                if (shape instanceof Square) squares.addShape(shape);
                if (shape instanceof Hexagon) hexagons.addShape(shape);
            }
        }

        listLayer.clear();
        listLayer.add(circles);
        listLayer.add(triangles);
        listLayer.add(rectangles);
        listLayer.add(squares);
        listLayer.add(hexagons);
    }

    public void removeCirle(){
        for (int i = 0; i < listLayer.size(); i++) {
            listLayer.get(i).removeCircle();
        }
    }
}