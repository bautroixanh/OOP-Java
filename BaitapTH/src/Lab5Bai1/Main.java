package Lab5Bai1;

public class Main extends Orangesanh {
    public static void main(String[] arg)
    {

        Orangesanh cs=new Orangesanh();
        cs.setVicam("chua");
        cs.Cam("màu xanh lá cây đậm", 3);
        cs.Fruit("Cam Sành",20000, "Thanh Phong, Phủ Lý, Hà Nam", "20/10/2018");
        cs.printFruit();
        cs.printfCam();
        cs.printfCamThanhPhong();
        System.out.println("===========================================================");
        Apple t = new Apple();
        t.Tao(300, "Táo ta");
        t.Fruit("Táo",30000, "Duyên Hải, Hưng Hà, Thái Bình", "21/10/2018");
        t.printFruit();
        t.printfTao();

    }
}
