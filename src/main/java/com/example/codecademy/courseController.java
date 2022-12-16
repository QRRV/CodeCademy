package com.example.codecademy;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class courseController {
    
    @FXML
    private Stage stage;
    private Label test;

    @FXML
    protected void test(){
        test.setText("test 1234");
    }
}


