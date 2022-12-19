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
    private TextField cname;
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
    String[] name;

    ArrayList<String> items = new ArrayList<String>();
    ObservableList<String> oListName;
    ArrayList<Course> selItem;
    ArrayList<String> names = new ArrayList<String>();

    @FXML
    private Stage stage;


    @FXML
    protected void toUpdate(ActionEvent event) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(courseController.class.getResource("CourseUpdate-view.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load(), 511, 600);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    protected void toCreate(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(courseController.class.getResource("CourseCreate-view.fxml"));
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
    protected void createCourse(ActionEvent event) throws IOException{
        try {
            CourseRepository.createCourse(cname.getText(), sub.getText(), lvl.getText(), introTxt.getText(), intrst.getText());
        }catch (Exception ex){
            System.out.println("Problem occurred at createCourse operation : " + ex);
        }

        FXMLLoader fxmlLoader = new FXMLLoader(courseController.class.getResource("course-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void deleteCourse() throws SQLException{
        CourseRepository.deleteCourse(name[0]);
        myListView.getItems().clear();
        getList();
    }

    @FXML
    protected void updateCourse(ActionEvent event) throws  SQLException, IOException{
        System.out.println(cName.getSelectionModel().getSelectedItem());
        CourseRepository.updateCourse((String) cName.getSelectionModel().getSelectedItem(), sub.getText(), lvl.getText(), introTxt.getText(), intrst.getText());

        FXMLLoader fxmlLoader = new FXMLLoader(courseController.class.getResource("course-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
        stage.show();
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
                 name = item.split("     ");
             }
         });

         selItem = CourseRepository.getCourses();
         if(cName != null){
             selItem.forEach(course -> {
                 items.add(course.toString());
             });
             items.forEach(item ->{
                 name = item.split("     ");
                 names.add(name[0]);
             });
             oListName = FXCollections.observableArrayList(names);
             cName.setItems(oListName);
         }
     }
}


