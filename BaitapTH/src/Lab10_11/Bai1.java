package Lab10_11;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Bai1 {
    static List<String> list = new LinkedList<>();

    public static List<String> getAllFunction(File path){
        String s ="";
        if (path.exists()){
            try {
                FileInputStream stream = new FileInputStream(path);
                BufferedReader in = new BufferedReader(new InputStreamReader(stream));
                while ((s = in.readLine()) != null){
                    String[] dong = s.split("\\{");
                    String d = dong[0].trim();
                    if (d.contains("static")){
                        list.add(d);
                    }
                }
                in.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public static String findFunctionByName(String name){
        File file = new File("src/week9/Utils.java");
        if (!file.exists()){
            return "Khong tim thay file...";
        }else {
            try {
                FileInputStream stream = new FileInputStream(file);
                BufferedReader in = new BufferedReader(new InputStreamReader(stream));
                String dong;
                while ((dong = in.readLine()) != null){
                    String[] s = dong.split("\\{");
                    String l = s[0].trim();
                    if (l.contains(name)){
                        return l;
                    }
                }
                in.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "Khong tim thay " + name;
    }

    public static void main(String[] args) {
        List<String> list1  = getAllFunction(new File("src/week9/Utils.java"));
        for (String l : list1){
            System.out.println(l);
        }
        String name = "String readContentFromFile";
        System.out.println("\nTim kiem phuong thuc " + name);
        System.out.println(findFunctionByName(name));
    }

}
