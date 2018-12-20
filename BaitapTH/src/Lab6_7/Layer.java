package Lab6_7;
import java.util.ArrayList;
public class Layer{
    private ArrayList<Shape> list = new ArrayList<Shape>();
    private boolean visible;

    public Layer() {
        this.visible = true;
    }

    public void addShape(Shape shap){
        list.add(shap);
    }

    public ArrayList<Shape> getList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        return list;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void removeDouble(){
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if(list.get(i).equals(list.get(j))){
                    list.remove(j);
                }
            }
        }
    }

    public ArrayList<Shape> getShape(){
        return list;
    }

    public void removeTriangle(){
        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i) instanceof Triangle){
                list.remove(i);
                i--;
            }
        }
    }

    public void removeCircle(){
        for (int i = 0; i <list.size() ; i++) {
            if(list.get(i) instanceof Circle){
                list.remove(i);
                i--;
            }
        }
    }

}