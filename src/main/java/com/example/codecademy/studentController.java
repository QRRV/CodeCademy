package com.example.codecademy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class studentController {
    @FXML
    Stage stage;

    @FXML
    protected void toMain(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(studentController.class.getResource("main-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void toCreateAccount(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(studentController.class.getResource("createAccount-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 400, 450);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void toLogin(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(studentController.class.getResource("log-in-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        stage.setScene(scene);
        stage.show();
    }
}
