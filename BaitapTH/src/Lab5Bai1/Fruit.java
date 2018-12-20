package Lab5Bai1;

import sun.util.calendar.BaseCalendar;

import java.util.Date;

public class Fruit {

    private String Ten;
    private double giaban;
    private String nguongoc;
    private String ngaynhap;
    public Fruit(){ }

    public void setTen(String ten)
    {
        this.Ten=ten;
    }
    public String getTen()
    {
        return Ten;
    }
    public void setGiaban(Double giaban)
    {
        this.giaban=giaban;
    }
    public Double getGiaban()
    {
        return giaban;
    }



    public void setNguongoc(String nguongoc)
    {
        this.nguongoc=nguongoc;
    }
    public String getNguongoc()
    {
        return nguongoc;
    }

    public void setNgaynhap(String ngaynhap)
    {
        this.ngaynhap=ngaynhap;
    }
    public String getNgaynhap()
    {
        return ngaynhap;
    }



    public void Fruit(String Ten,double giaban,String nguongoc,String ngaynhap)
    {
        this.Ten=Ten;
        this.giaban=giaban;

        this.nguongoc=nguongoc;
        this.ngaynhap=ngaynhap;
    }
    public void printFruit()
    {
        System.out.println("Tên loại quả: "+this.Ten);
        System.out.println("Giá bán: "+this.giaban+" VNĐ/kg");
        System.out.println("Nguồn gốc: "+this.nguongoc);
        System.out.println("Nơi sản Xuất: "+this.ngaynhap);
    }

}
