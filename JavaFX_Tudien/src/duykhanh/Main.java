package duykhanh;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Fxml/Main.fxml"));


        primaryStage.getIcons().add(new Image("file:app1.png"));
        primaryStage.setTitle("Dictionary");

        primaryStage.setScene(new Scene(root, 700, 500));
        //primaryStage.show();
//
        primaryStage.initStyle(StageStyle.DECORATED);
//
//        Group roo = new Group();
//        Scene scene = new Scene(roo, 100, 100);
//
//        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void start2(Stage primaryStage) throws Exception{



    }

    public static void main(String[] args) {
        launch(args);
    }
}