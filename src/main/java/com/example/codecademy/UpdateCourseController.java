package com.example.codecademy;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UpdateCourseController{
    @FXML
    private TextField cname;
    @FXML
    private TextField sub;
    @FXML
    private TextField introt;
    @FXML
    private TextField lvl;

    @FXML
    private Stage stage;

    @FXML
    protected void toUpdate(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(UpdateCourseController.class.getResource("CourseUpdate-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 511, 600);
        stage.setScene(scene);
        stage.show();
    }
}
