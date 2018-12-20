package Lab10_11;

import java.util.Random;

public class Bai2 {
    static float[] arr = new float[1000];
    static int dem = 0;
    static final int max = 1000;


    public static void ranDom(){
        Random ran = new Random();
        while (dem < max ){
            float x = ran.nextFloat();
            arr[dem] = (float) (Math.ceil(x*10000)/10000);
            dem++;
        }
    }

    public static void sapXep(){
        for (int i = 0 ; i < max ; i++ ){
            for (int j = 0 ; j < max- 1 - i ; j++){
                if (arr[j] - arr[j+1] > 0){
                    float tem = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tem;
                }
            }
        }

    }

    public static void In() {
        for (float a : arr) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        ranDom();
        sapXep();
        In();
    }
}
