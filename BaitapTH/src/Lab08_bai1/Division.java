package Lab08_bai1;

public class Division extends  BinaryExpression {
    Expression left;
    Expression right;

    public Division(Expression left, Expression right) {
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
        return this.left.evaluate()/this.right.evaluate();
    }
}
