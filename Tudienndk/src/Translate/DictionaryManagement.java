package Translate;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary {

    private Scanner sc = new Scanner(System.in);
    private static final String fileName = "test.txt";

    public void showAllWords() {
        if (!Dictionary.listWord.isEmpty()) {
            System.out.printf("%-4s%c%-20s%c%-20s\n", "STT", '|', "English", '|', "Vietnamese");
            int i = 1;
            for (Word ele : Dictionary.listWord) {
                System.out.printf("%-5d", i);
                ele.printWord();
                i++;
            }
        }
    }

    public void insertFromCommandline() {
        System.out.println("**Thêm từ vào từ điển");
            System.out.print("Nhập từ tiếng anh: ");
            String tu = sc.nextLine();
            boolean kiemtra = false;
            for (Word ele : listWord) {
                if (ele.getWord_taget().equals(tu.trim())) {
                    System.out.println("Từ Vừa Nhập Đã Tồn Tại...");
                    kiemtra = true;
                    break;
                }
            }
            if(!kiemtra) {
                System.out.print("Nhập nghĩa  ");
                String tu1 = sc.nextLine();
                Dictionary.listWord.add(new Word(tu, tu1));
            }
        }

    //đọc file add vào listWord
    public void insertFromFile() {
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "UTF-8"));
            String line = br.readLine();

            while ((line = br.readLine()) != null){
                Word w = new Word(line);
                listWord.add(w);
            }
            br.close();

        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            System.exit(0);
        } catch (IOException ex) {
            System.exit(0);
        }
    }

    public void dictionaryLookup() {
        System.out.println("**LOOK UP");
        System.out.print("Enter word: ");
        String wordLookup = sc.nextLine();
        for (Word ele : Dictionary.listWord) {
            if (ele.getWord_taget().equals(wordLookup)) {
                System.out.println("Tìm Kiếm Thành Công");
                System.out.print("\n" +"Từ của bạn là: ");
                ele.printWord();
                return;
            }
        }
        System.out.println("\n" +"Không tìm thấy từ!");
    }


    public void editWordInDic() {
        System.out.println("**Sửa từ trong từ điển");
        System.out.println("Nhập từ bạn muốn sửa: ");
        String edit = sc.nextLine();
        for (int i = 0; i < Dictionary.listWord.size(); i++) {
            if (Dictionary.listWord.get(i).getWord_taget().equals(edit)) {
                System.out.println("Đã thấy từ " + edit );
                System.out.print("Từ Cần Thay: ");
                String tu = sc.nextLine();
                System.out.print("Nghĩa :");
                String tu1 = sc.nextLine();
                Dictionary.listWord.set(i, new Word(tu, tu1));
                System.out.println("Thành công");
                return;
            }
        }
        System.out.println("Không tìm thấy từ cần sửa");
    }

    public void deleteWordInDic() {
        System.out.println("**Xóa từ trong từ điển");
        System.out.println("Nhập từ bạn muốn xóa: ");
        String xoa = sc.nextLine();
        for (int i = 0; i < Dictionary.listWord.size(); i++) {
            if (Dictionary.listWord.get(i).getWord_taget().equals(xoa)) {
                System.out.println("Đã thấy từ " + xoa + " trong từ điển!");
                Dictionary.listWord.remove(i);
                System.out.println("Xóa thành công");
                return;
            }
        }
        System.out.println("Từ Không tồn tại");
    }

    public void dictionaryExportToFile() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
            for (Word ele : Dictionary.listWord) {
                bw.write(ele.getWord_taget() + "\t" + ele.getWord_explain());
                bw.newLine();
            }
            bw.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            System.exit(0);
        } catch (IOException ex) {
            System.exit(0);
        }
    }

}