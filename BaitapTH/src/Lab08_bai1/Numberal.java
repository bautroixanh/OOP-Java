package Lab08_bai1;

public class Numberal extends Expression{

    int value;

    public Numberal(){
        value=0;
    }

    public Numberal(int value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Numberal{" +
                "value=" + value +
                '}';
    }

    @Override
    public int evaluate() {
        return this.value;
    }
}