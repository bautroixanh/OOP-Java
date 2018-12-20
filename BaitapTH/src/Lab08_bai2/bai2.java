package Lab08_bai2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class bai2 {

    public static void Array(){
        int[] arr = {1,2};
        System.out.println("Phan tu mang thu 2 la: "+ arr[2]);
    }

    public static void exception1() throws NullPointerException{
        String s = null;
        System.out.println(s.length());
    }

    public static void exception2()throws ArrayIndexOutOfBoundsException{
        int[] arr = new int[5];
        arr[10] = 100;
    }

    public static void exception3()throws ArithmeticException{
        double s = 50/0;
    }

    public static void exception4()throws ClassCastException{
        Object s = "String";
        int a = (int)s;
        System.out.println(a);
    }

    public static void exception5() throws IOException {
        try {
            BufferedReader b = new BufferedReader(new FileReader("week7.txt"));
            String dong;
            while ((dong = b.readLine()) != null) {
                System.out.println(dong);
            }
        }catch (IOException e){
            throw new IOException("Loi IOException...");
        }

    }

    public static void exception6() throws FileNotFoundException {
        try {
            BufferedReader b = new BufferedReader(new FileReader("week07.txt"));
        }catch (Exception e){
            throw new FileNotFoundException("Loi FileNotFoundException...");
        }
    }

    public static void main(String[] args) {
        try {
            exception1();
        }catch (NullPointerException e){
            System.err.println("Loi NullPointerException... chua gia tri null...");
        }
        try {
            exception2();
        }catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Loi ArrayIndexOutOfBoundsException...chen sai...");
        }
        try {
            exception3();
        }catch (ArithmeticException e){
            System.err.println("Loi ArithmeticException...khong the chia cho so 0...");
        }
        try {
            exception4();
        }catch (ClassCastException e){
            System.err.println("Loi ClassCastException...khong the chuyen kieu Object...");
        }
        try {
            exception5();
        }catch (IOException e){
            System.err.println(e.getMessage());
        }
        try {
            exception6();
        }catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }

    }

}
