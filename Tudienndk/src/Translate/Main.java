package Translate;

import java.util.Scanner;

public class Main extends  DictionaryCommandline {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DictionaryManagement mana = new DictionaryManagement();
        DictionaryCommandline com = new DictionaryCommandline();
        mana.insertFromFile();

        int Click;
        do {
            System.out.println("|      Translate E-V");
            System.out.println("|1. Search word ");
            System.out.println("|2. Add word");
            System.out.println("|3. Edit word");
            System.out.println("|4. Remove word");
            System.out.println("|5. Full dictionary ");
            System.out.println("|6. End.");
            System.out.println("**********");

            Click = sc.nextInt();

            switch (Click) {
                case 1:
                    com.dictionarySearcher();
                    break;
                case 2:
                    mana.insertFromCommandline();
                    break;
                case 3:
                    mana.editWordInDic();
                    break;
                case 4:
                    mana.deleteWordInDic();
                    break;
                case 5:
                    com.showAllWords();
                    break;
            }
            com.dictionaryExportToFile();

        } while (Click >= 1 && Click <= 5);
    }

//    Dictionary a = new Dictionary();
//    System.out.println(a.listWord);

}
