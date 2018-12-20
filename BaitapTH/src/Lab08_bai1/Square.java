package Lab08_bai1;

public class Square extends Expression{
    Expression expression;
    public Square(Expression e)
    {
        this.expression = e;
    }

    @Override
    public String toString() {
        return Integer.toString(this.evaluate());
    }

    @Override
    public int evaluate() {
        return this.expression.evaluate()*this.expression.evaluate();
    }
}