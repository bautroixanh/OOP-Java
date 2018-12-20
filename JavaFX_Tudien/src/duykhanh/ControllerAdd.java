package duykhanh;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import translate.DictionaryManagement;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerAdd implements   Initializable {

    private Stage stage;
    private String ta,ex;
    @FXML
    Button add;
    @FXML
    TextField target;

    @FXML
    TextField explain;


    @FXML
    private void closeWindow(MouseEvent event) {
        stage = ( Stage ) (( ImageView ) event.getSource()).getScene().getWindow();
        stage.close();

    }
    @FXML
    public void add(ActionEvent actionEvent) {
        int result=0;
        DictionaryManagement mage = new DictionaryManagement();
        result = mage.add(ta,ex);
        mage.dictionaryExportToFile();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if(result==1){
            alert.setTitle("Done");
            alert.setContentText("Thêm Từ Thành Công");
        }else{
            alert.setTitle("Error");
            alert.setContentText("Từ Đã Tồn Tại Mời Nhập Lại");
        }

        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        DictionaryManagement a = new DictionaryManagement();
        a.insertFromFile();

        target.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            ta=newValue;

        });

        explain.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            ex=newValue;
   });

    }

}
