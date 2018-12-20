package Tudien;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary{

    private Scanner sc = new Scanner(System.in);
    private static final String fileName = "dictionaries.txt";
   // File fileName = new File(dictionaries.txt);



    public void insertFromCommandline() {
        System.out.println("---------------------------------");
        System.out.println("|           Add English         |");
        System.out.println("---------------------------------");
        System.out.print("Nhập số lượng từ muốn thêm: ");
        int num = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < num; i++) {
            System.out.print("Nhập từ muốn thêm: ");
            String spel = sc.nextLine();

            boolean check = false;
            for (Word ele : Dictionary.listWord) {
                if (ele.getWord_taget().equals(spel.trim())) {
                    System.out.println("Từ " + spel + " đã có trong từ điển!! Nhập lại...");
                    check = true;
                    i--;
                    break;
                }
            }

            if(!check) {
                System.out.print("Nhập nghĩa Tiếng Việt: ");
                String expl = sc.nextLine();
                Dictionary.listWord.add(new Word(spel, expl));
            }

        }
        System.out.println("Thêm thành công " + num + " từ vào từ điển!");
    }

    public void insertFromFile() {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
            String line = br.readLine();

            while (line != null) {

                if (line.indexOf("\t") == -1) {
                    line = br.readLine();
                    continue;
                }
                Word w = new Word(line);
                Dictionary.listWord.add(w);
                line = br.readLine();
            }

            br.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            System.out.println("Không tìm thấy file");
            System.exit(0);
        } catch (IOException ex) {
            System.out.println("Kết nối lỗi");
            System.exit(0);
        }
    }

    public void dictionaryLookup() {
        System.out.println("-----------LOOK UP------------");
        System.out.print("Enter word: ");
        String wordLookup = sc.nextLine();
        for (Word ele : Dictionary.listWord) {
            if (ele.getWord_taget().equals(wordLookup)) {
                System.out.println("Lookup Success!");
                System.out.print("Your word is: ");
                ele.printWord();
                return;
            }
        }
        System.out.println("Word Not Found!");
    }

    public void dictionarySearcher() {
        sc = new Scanner(System.in);
        System.out.println("---------------------------------");
        System.out.println("|        Search English         |");
        System.out.println("---------------------------------");
        System.out.print("Nhập từ cần tìm: ");
        String wordSearch = sc.nextLine();

        ArrayList<Word> listWordSearch = new ArrayList<>();

        for (Word ele : Dictionary.listWord) {
            if (ele.getWord_taget().indexOf(wordSearch) == 0) {
                listWordSearch.add(ele);
            }
        }

        if (listWordSearch.isEmpty()) {
            System.out.println("Không có trong từ điển !!!");
        } else {
            System.out.println("(Các) từ bắt đầu bằng \"" + wordSearch + "\": ");
            int i = 1;
            for (Word ele : listWordSearch) {
                System.out.printf("%-4d", i);
                ele.printWord();
                i++;
            }
        }
    }

    public void editWordInDic() {
        System.out.println("---------------------------------");
        System.out.println("|            Edit word          |");
        System.out.println("---------------------------------");
        System.out.println("Nhập từ bạn muốn sửa: ");
        String edit = sc.nextLine();
        for (int i = 0; i < Dictionary.listWord.size(); i++) {
            if (Dictionary.listWord.get(i).getWord_taget().equals(edit)) {
                System.out.println("Đã thấy từ " + edit + " trong từ điển!");
                System.out.print("Nhập từ thay thế: ");
                String spel = sc.nextLine();
                System.out.print("Nhập nghĩa tiếng việt:");
                String expl = sc.nextLine();
                Dictionary.listWord.set(i, new Word(spel, expl));
                System.out.println("Thêm thành công!!");

            }
        }
        System.out.println("Không tồn tại từ: " + edit);
    }

    public void deleteWordInDic() {
        System.out.println("---------------------------------");
        System.out.println("|           Remove word         |");
        System.out.println("---------------------------------");
        System.out.println("Nhập từ cần xóa: ");
        String delW = sc.nextLine();
        for (int i = 0; i < Dictionary.listWord.size(); i++) {
            if (Dictionary.listWord.get(i).getWord_taget().equals(delW)) {
                System.out.println("Đã tìm thấy " + delW + " trong từ điển!");
                System.out.println("Bạn có muốn xóa từ " + delW + " không? (Y/N)?");
                char option = sc.next().charAt(0);
                if (option == 'Y' || option == 'y') {
                    Dictionary.listWord.remove(i);
                    System.out.println("Xóa thành công!!");
                } else if (option == 'N' || option == 'n') {
                    System.out.println("Xóa không thành công!");
                } else {
                    System.out.println("Error");
                }
                return;
            }
        }
        System.out.println("Từ Không Tồn Tại: " + delW);
    }

    public void dictionaryExportToFile() {
        BufferedWriter file = null;
        try {
            file = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
            for(int i = 0; i < listWord.size(); i++) {
                file.write(listWord.get(i).getWord_taget() + "\t" + listWord.get(i).getWord_explain());
                file.newLine();
            }
            file.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

}