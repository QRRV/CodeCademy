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

public class courseController extends CourseRepository{
    
    @FXML
    private ListView<Course> myListView;
    
    String item;

    @FXML
    protected void loadCourse() throws SQLException{
        ArrayList<Course> courses = CourseRepository.getCourses();
        myListView.getItems().addAll(courses);
    }

    @FXML
    protected void deleteCourse() throws SQLException{
        myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2){
                item = myListView.getSelectionModel().getSelectedItem();
            }
        }); 
    }

    // @Override
    // public void initialize(URL arg0, ResourceBundle arg1){
    //     ArrayList<Course> courses = CourseRepository.getCourses();
    //     myListView.getItems().addAll(courses);
    // }


}


