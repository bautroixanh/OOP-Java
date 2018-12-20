package duykhanh;

import translate.DictionaryCommandline;
import translate.DictionaryManagement;

//chú ý  2 dong no
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import translate.Word;

import javax.script.CompiledScript;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    private ArrayList<Word> li;

    @FXML
    private Button closeButton;
    @FXML
    Stage stage;
    @FXML
    Label label;
    @FXML
    Label eWord;
    @FXML
    TextField textInput;
    @FXML
    WebView view;
    @FXML
    ListView listSearch;
    @FXML
    KeyEvent event;
    private JFXPanel primaryStage;


//    @FXML
//    private void closeWindow(MouseEvent event) {
//        stage = (Stage) (( ImageView) event.getSource()).getScene().getWindow();
//        stage.close();
//    }


    @FXML
    private void speak() throws IOException {
        String url = URLEncoder.encode(eWord.getText(), "UTF-8");
        Ggdich.speakAPI("en",url);
    }
    @FXML
    private void changeSearch() {

        if (textInput.getText().length()>0) {
            listSearch.getItems().add(textInput.getText());
        }
    }
    @FXML
    private void handle()
    {
        if(event.getCode()==(KeyCode.ENTER)) {
            listSearch.getItems().add(textInput.getText());
        }


    }
//    @FXML
//    private void removeList()
//    {
//
//        if( textInput.getText().length()==0 )
//        {
//
//            listSearch.getItems().clear();
//        }
//    }



    @FXML
    private void addNew() throws IOException {
        Stage astage =new Stage();

        astage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("Fxml/Add.fxml"));
        astage.setScene(new Scene(root));
        astage.show();
    }

    @FXML
    private void editWord() throws IOException {
        Stage astage =new Stage();
        astage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("Fxml/Edit.fxml"));
        astage.setScene(new Scene(root));
        astage.show();
    }


    @FXML
    private void remove() throws IOException {
        Stage astage =new Stage();

        astage.initStyle(StageStyle.UNDECORATED);
        Parent root = FXMLLoader.load(getClass().getResource("Fxml/Delete.fxml"));
        astage.setScene(new Scene(root));
        astage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {



        DictionaryManagement a = new DictionaryManagement();
        a.insertFromFile();
        ArrayList<String> list = a.getList();

//        for(int i=0;i<list.size();i++)
//            listSearch.getItems().add(list.get(i));



        DictionaryCommandline b = new DictionaryCommandline();
Runnable task =()->{
        textInput.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            listSearch.getItems().clear();
            li = b.getSearch(newValue);
            //in
            for(int i=0;i<li.size();i++)
                listSearch.getItems().add(li.get(i).getWord_taget());

            // view.getEngine().loadContent("<u><b>Hi</b> <i>Translate</i></u>");
            view.getEngine().loadContent(li.get(0).getWord_explain());
            if( textInput.getText().length()==0 )
            {
                listSearch.getItems().clear();
                view.getEngine().loadContent("");
            }
        });
};
    Thread thread=new Thread(task);
    thread.start();

        listSearch.getSelectionModel().selectedItemProperty()
                .addListener(new ChangeListener<String>() {
                    public void changed(
                            ObservableValue<? extends String> observable,
                            String oldValue, String newValue) {
                        eWord.setText(newValue);

//                        WebView browser = new WebView();
//                        WebEngine webEngine = browser.getEngine();


                        for(int i=0;i<li.size();i++){
                            if(newValue.equals(li.get(i).getWord_taget())){
                                //  webEngine.loadContent("Vietnamese");
                                view.getEngine().loadContent(li.get(i).getWord_explain());
                            }
                        }
                    }
                });


    }
}