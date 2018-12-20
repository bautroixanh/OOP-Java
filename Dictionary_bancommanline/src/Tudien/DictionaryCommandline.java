package Tudien;
import java.util.*;

public class DictionaryCommandline extends  DictionaryManagement {
    private Scanner sc = new Scanner(System.in);

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
    public void dictionaryBasic(){
        insertFromCommandline();
        showAllWords();
    }
    public void dictionaryAdvanced(){
        insertFromFile();
        showAllWords();
        dictionaryLookup();
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
}
