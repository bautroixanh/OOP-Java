package Tudien;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Dictionary {

    static ArrayList<String> listWord = new ArrayList<>();
    // private static final String fileDir = "dictionaries.txt";

    Dictionary() {
        try {
            File fileDir = new File("dictionaries.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fileDir), "UTF-8"));
            String line;

            while ((line = in.readLine()) != null) {

                Word w = new Word(line);
                listWord.add(line);
                //add(w.getWord_explain());
                System.out.println(line);
            }
            in.close();
        } catch (Exception e) {
        }

    }
}



