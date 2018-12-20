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

public class ControllerEdit implements   Initializable {


    private Stage stage;
    private String t1,t2,t3;
    @FXML
    Button edit;
    @FXML
    TextField target_old;

    @FXML
    TextField target_new;

    @FXML
    TextField explain;


    @FXML
    private void closeWindow(MouseEvent event) {
        stage = ( Stage ) (( ImageView ) event.getSource()).getScene().getWindow();
        stage.close();

    }

    @FXML
    public void edit(ActionEvent actionEvent) {

        int temp;
        DictionaryManagement e = new DictionaryManagement();
        temp = e.edit(t1, t2, t3);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        if (temp == 1) {
            alert.setTitle("Done");
            alert.setContentText("Sửa Từ Thành Công");
        } else {
            alert.setTitle("Error");
            alert.setContentText("Từ Đã Tồn Tại Mời Nhập Lại");
        }

        while (target_old.getText().length() == 0 && target_new.getText().length() == 0 && explain.getText().length() == 0) {
            alert.setTitle("Error");
            alert.setContentText("NHẬP TỪ VÀO Ô CÓ DẤU *");
        }
        alert.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        DictionaryManagement a = new DictionaryManagement();
        a.insertFromFile();

        target_old.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            t1=newValue;

        });

        target_new.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            t2=newValue;

        });

        explain.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            t3=newValue;

        });


    }
}
