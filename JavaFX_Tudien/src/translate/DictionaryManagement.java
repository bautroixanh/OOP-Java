package translate;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary {

    private Scanner sc = new Scanner(System.in);
    private static final String fileName = "E_V.txt";

    //get listview
    public ArrayList<String> getList(){
        ArrayList<String> data = new ArrayList<String>();
        if (!Dictionary.listWord.isEmpty()) {
            int i = 1;
            for (Word ele : Dictionary.listWord) {
                //data.add(ele.getWord_taget());
                //ele.printWord();
                i++;
            }
        }
        System.out.println(data.size());
        return data;
    }


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
            System.out.println("Không tìm thấy file");
            System.exit(0);
        } catch (IOException ex) {
            System.out.println("Kết nối lỗi");
            System.exit(0);
        }
    }

    public int add(String text,String text1)
    {
        ArrayList<String> data = new ArrayList<String>();
        String wordTarget = text;
        boolean check = false;
        for (Word ele : Dictionary.listWord) {
            if (ele.getWord_taget().equals(wordTarget.trim())) {
                //System.out.println("Từ " + spel + " đã có trong từ điển!! Nhập lại...");
                check = true;
                return -1;
            }
        }
        if(!check) {
            // System.out.print("Nhập nghĩa Tiếng Việt: ");
            String wordExplain = text1;
            Dictionary.listWord.add(new Word(wordTarget, wordExplain));

            return 1;
        }
        return 0;
    }



    public int edit(String text1,String text2,String text3)
    {
       // ArrayList<String> data = new ArrayList<String>();
        String editW = text1;
        for (int i = 0; i < listWord.size(); i++) {
            if (editW.equals(listWord.get(i).getWord_taget())) {
                //System.out.println("Đã thấy từ " + editW + " trong từ điển!");
                //System.out.print("Nhập từ thay thế: ");
                String eng = text2;
                //System.out.print("Nhập nghĩa tiếng việt:");
                String vn = text3;
                Word w = new Word(eng, vn);
                listWord.set(i, w);
                System.out.println("Sửa thành công!!");
                this.dictionaryExportToFile();
                return  1;
            }else{
                System.out.println("Không tìm thấy từ: " + editW);
            }


        }
        return 0;
    }


    public int delete(String text)
    {
        ArrayList<String> data = new ArrayList<String>();
        String dW = text;

        for (int i = 0; i < Dictionary.listWord.size(); i++) {
            if (dW.equals(listWord.get(i).getWord_taget())) {
                System.out.println("Đã thấy từ " + dW + " trong từ điển!");
                listWord.remove(i);
                System.out.println("Xóa thành công!!");

                return 1;
            }else {
                System.out.println("Không tìm thấy từ: " + dW);
            }

        }
        return 0;
    }

    public void dictionaryExportToFile() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), "UTF-8"));
            for (Word ele : listWord) {
                bw.write(ele.getWord_taget() + "\t" + ele.getWord_explain());
                bw.newLine();
            }
            bw.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            System.out.println("Không tìm thấy file");
            System.exit(0);
        } catch (IOException ex) {
            System.out.println("Kết nối lỗi");
            System.exit(0);
        }
    }

}