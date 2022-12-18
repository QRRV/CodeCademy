package com.example.codecademy;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.codecademy.Domain.Course;
import com.example.codecademy.Repository.CourseRepository;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.ResultSet;
import java.sql.*;

public class courseController extends CourseRepository implements Initializable {
    
    @FXML
    private ListView<String> myListView = new ListView<String>();
    @FXML
    private ComboBox cName = new ComboBox<>();
    @FXML
    private TextField sub;
    @FXML
    private TextField introTxt;
    @FXML
    private TextField lvl;
    @FXML
    private TextField intrst;

    String item;
    String selName;
    String[] name;

    ArrayList<String> items = new ArrayList<String>();
    ObservableList<String> oListName;
    ArrayList<Course> selItem;
    ArrayList<String> names = new ArrayList<String>();

    @FXML
    private Stage stage;


    @FXML
    protected void toUpdate(ActionEvent event) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(UpdateCourseController.class.getResource("CourseUpdate-view.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load(), 511, 600);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    protected void BackToCourse(ActionEvent event) throws IOException{

        FXMLLoader fxmlLoader = new FXMLLoader(courseController.class.getResource("course-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void getList() throws SQLException{
        ArrayList<Course> courses = CourseRepository.getCourses();
        myListView.getItems().clear();
        courses.forEach(course -> {
            myListView.getItems().add(course.toString());
        });
    }

    @FXML
    protected void deleteCourse() throws SQLException{
//        System.out.println(name[0]);
        CourseRepository.deleteCourse(name[0]);
        myListView.getItems().clear();
        getList();
    }

    @FXML
    protected void updateCourse() throws  SQLException{
        System.out.println(cName.getSelectionModel().getSelectedItem());
        // updateCourse(cName.getText(), Date.valueOf("18-12-2022"), lvl.getText(), intrst.getText());
    }

     @Override
     public void initialize(URL arg0, ResourceBundle arg1) {

         try {
             getList();
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
         myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
             @Override
             public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                 item = myListView.getSelectionModel().getSelectedItem();
                 name = item.split("  ");
             }
         });

         try {
             selItem = CourseRepository.getCourses();
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
         if(cName != null){
             selItem.forEach(course -> {
                 items.add(course.toString());
             });
             items.forEach(item ->{
                 name = item.split("  ");
                 names.add(name[0]);
             });
             oListName = FXCollections.observableArrayList(names);
             cName.setItems(oListName);
         }
     }
}


