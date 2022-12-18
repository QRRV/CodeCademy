package com.example.codecademy;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.example.codecademy.Domain.Course;
import com.example.codecademy.Repository.CourseRepository;

public class CreateCourseController {
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
    protected void toCreate(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(UpdateCourseController.class.getResource("create-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 511, 600);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void createCourse(){
        try {
             
        }catch (Exception ex){
            System.out.println("Problem occurred at createCourse operation : " + ex);
        }
    }
}