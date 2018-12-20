package Lab08_bai1;

public class Addition extends  BinaryExpression {
    Expression left;
    Expression right;

    public Addition(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public Expression left() {
        return this.left;
    }

    @Override
    public Expression right() {
        return this.right;
    }

    @Override
    public String toString() {
        return Integer.toString(this.evaluate());
    }

    @Override
    public int evaluate() {
        return this.left.evaluate()+this.right.evaluate();
    }
}
