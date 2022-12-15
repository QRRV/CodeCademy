package com.example.codecademy;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class readCourseController {
    
    @FXML
    private Stage stage;
    private Label test;

    @FXML
    protected void test() throws IOException{
        test.setText("test 1234");
    }
}


// public void start(Stage stage) throws IOException {
//     FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//     Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//     stage.setTitle("Hello!");
//     stage.setScene(scene);
//     stage.show();
// }
