package com.example.codecademy;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.codecademy.Domain.Course;
import com.example.codecademy.Repository.CourseRepository;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.sql.ResultSet;
import java.sql.*;

public class courseController extends CourseRepository implements Initializable{
    
    @FXML
    private ListView<String> myListView;
    
    String item;
    String[] name;

    @FXML
    protected void loadCourse() throws SQLException{
        ArrayList<Course> courses = CourseRepository.getCourses();
        courses.forEach(course -> {
            myListView.getItems().add(course.toString());
        });
    }

    @FXML
    protected void deleteCourse() throws SQLException{

        CourseRepository.deleteCourse(name[0]);
        myListView.getItems().clear();
        loadCourse();
    }

     @Override
     public void initialize(URL arg0, ResourceBundle arg1){
         myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
             @Override
             public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                 item = String.valueOf(myListView.getSelectionModel().getSelectedItem());
                 name = item.split("  ");
                 System.out.println(name[0]);
             }
         });
     }


}


