package com.example.codecademy;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloController {
    @FXML
    private Label welcomeText;
    private Stage stage;

    @FXML
    protected void onHelloButtonClick(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloController.class.getResource("course-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
        stage.show();
    }
} 
