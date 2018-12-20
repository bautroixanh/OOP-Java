package Lab5Bai1;

public class Apple extends Fruit{

    private int trongluongTB;
    private String loaitao;

    public int getTrongluongTB() {
        return trongluongTB;
    }

    public void setTrongluongTB(int trongluongTB) {
        this.trongluongTB = trongluongTB;
    }

    public String getLoaitao() {
        return loaitao;
    }

    public void setLoaitao(String loaitao) {
        this.loaitao = loaitao;
    }
    public void Tao(int trongluongTB,String loaitao){
        this.trongluongTB=trongluongTB;
        this.loaitao=loaitao;
    }
    public void printfTao(){
        System.out.println("Trọng lượng trung bình: "+this.trongluongTB+" gam/quả");
        System.out.println("Loại táo: "+this.loaitao);
    }
}
