package Lab5Bai1;

public class Orangetall extends Orange{

    private String vicam;

    public String getVicam() {
        return vicam;
    }

    public void setVicam(String vicam) {
        this.vicam = vicam;
    }

    public void printfCamThanhPhong(){
        System.out.println("Cam "+this.vicam);
    }
}
