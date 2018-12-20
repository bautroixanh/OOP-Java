package Lab09;

import java.io.*;

public class Utils {


    // đọc một tệp .txt từ ổ cứng
    public static String readContentFromFile(String path)
    {
        String s="";
        String s1="";
        File file = new File(path);
        if(!file.exists())
        {
            return "không tìm thấy file!";
        }
        try {
            FileReader reader = new FileReader(path);
            BufferedReader in = new BufferedReader(reader);
            while ((s=in.readLine())!=null)
            {
                s1+=s + "\n";
            }
            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s1;

    }

    //xuất nội dung một xâu vào ổ cứng
    public static void writeContentToFile(String path)
    {
        File file = new File(path);
        if(!file.exists())
        {
            System.out.println("Không tìm thấy file!");
        }
        try {
            FileWriter writer = new FileWriter(path);
            PrintWriter out = new PrintWriter(writer);
            String s = "Xin chao !";
            out.println(s);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //bổ sung nội dung mới vào cuối tệp hiện tại
    public static void writeFile(String path)
    {
        try {
            FileWriter file = new FileWriter(path,true);
            PrintWriter out = new PrintWriter(file);
            String s = "Them dong moi 1";
            String s1 = "Them dong moi 2";
            out.write(s);
            out.println();
            out.write(s1);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //tìm file
    public static File findFileByName(String folderPath, String fileName)
    {
        File file = new  File(folderPath);
        for (File f : file.listFiles())
        {
            if(f.getName().equals(fileName))
            {
                return new File("file tồn tại");
            }
        }
        return new File("không tìm thấy file");
    }


    public static void main(String[] args)
    {
        System.out.println(readContentFromFile("D:\\Netbean\\test9.txt"));

        writeContentToFile("D:\\Netbean\\test9.txt");

        writeFile("D:\\Netbean\\test9.txt");

        System.out.println(findFileByName("D:\\Netbean","search1.txt"));

       // System.out.println(readContentFromFile("D:\\Netbean\\search1.txt"));
    }
}
