package Lab08_bai1;

public class ExpressionTest {
    public static void main(String[] args) {

        try {
            Square square = new Square(new Numberal(10));
            Subtraction subtraction = new Subtraction(square, new Numberal(1));
            Multiplication multiplication = new Multiplication(new Numberal(2), new Numberal(3));
            Addition addition = new Addition(subtraction, multiplication);
            Square square1 = new Square(addition);
            System.out.println(square1.toString());
            Numberal a = new Numberal(0);
            System.out.println(new Division(square1, a).toString());
        } catch (ArithmeticException e) {
            System.out.println("Loi chia cho 0.");
        }






//        try {
//            int a = 1/0;
//        } catch (ArithmeticException e) {
//            e.printStackTrace();
//        }
//
//
//
//        Square sq = new Square(new Numeral(10));
//        Subtraction sub = new Subtraction(sq, new Numeral(1));
//        Multiplication mul = new Multiplication(new Numeral(2), new Numeral(3));
//        Addition add = new Addition(sub,mul);
//        Square squ = new Square(add);
//        System.out.println(squ.evaluate());
//
//        try {
//            Division div = new Division(new Numeral(1), new Numeral(0));
//            System.out.println(div.evaluate());
//        }catch (ArithmeticException e){
//            System.err.println("Loi ArithmeticException...ko the chia cho 0...");
//        }

    }
}