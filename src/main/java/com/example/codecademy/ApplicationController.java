package com.example.codecademy;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ApplicationController {
    @FXML
    private Stage stage;

    @FXML
    protected void createBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(UpdateCourseController.class.getResource("create-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 511, 600);
        stage.setScene(scene);
        stage.show();
    }

    
    @FXML
    protected void updateBtn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(UpdateCourseController.class.getResource("CourseUpdate-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 511, 600);
        stage.setScene(scene);
        stage.show();
    }
}