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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.sql.ResultSet;
import java.sql.*;

public class courseController extends CourseRepository implements Initializable {

    @FXML
    private TextField cname;
    @FXML
    private TableView<Course> tableView = new TableView<Course>();
    @FXML
    private TableColumn courseName = new TableColumn<>();
    @FXML
    private TableColumn subject = new TableColumn<>();
    @FXML
    private TableColumn introductionText = new TableColumn<>();
    @FXML
    private TableColumn status = new TableColumn<>();
    @FXML
    private TableColumn recommendedCourse = new TableColumn<>();
    @FXML
    private ComboBox cName = new ComboBox<>();
    @FXML
    private TextField sub;
    @FXML
    private TextField introTxt;
    @FXML
    private TextField lvl;
    @FXML
    private ComboBox recCourse = new ComboBox<>();

    String item;
    String[] name;

    ArrayList<String> items = new ArrayList<String>();
    ObservableList<String> oListName;

    ObservableList<Course> oListCourses;
    ArrayList<Course> selItem;
    ArrayList<String> names = new ArrayList<String>();

    @FXML
    private Stage stage;


    @FXML
    protected void toCourse(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(courseController.class.getResource("Course/course-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void toUpdate(ActionEvent event) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(courseController.class.getResource("Course/CourseUpdate-view.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load(), 511, 600);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    protected void toCreate(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(courseController.class.getResource("Course/CourseCreate-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 511, 600);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void BackToCourse(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(courseController.class.getResource("Course/course-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void getList() throws SQLException{
        ArrayList<Course> courses = CourseRepository.getCourses();
        tableView.getItems().clear();
        oListCourses = tableView.getItems();
        courses.forEach(course -> {
            oListCourses.add(course);
        });
        courseName.setCellValueFactory(new PropertyValueFactory<Course,String>("courseName"));
        subject.setCellValueFactory(new PropertyValueFactory<Course,String>("subject"));
        status.setCellValueFactory(new PropertyValueFactory<Course,String>("level"));
        introductionText.setCellValueFactory(new PropertyValueFactory<Course,String>("introductionText"));
        recommendedCourse.setCellValueFactory(new PropertyValueFactory<Course,String>("interest"));

        tableView.setItems(oListCourses);
    }

    @FXML
    protected void createCourse(ActionEvent event) throws IOException{
        System.out.println(cname.getText());
        if(cname.getText().isBlank()) {
            System.out.println("Course Naam is verplicht");
        }else {
            try {
                if (recCourse.getSelectionModel().getSelectedItem() == null) {
                    CourseRepository.createCourse(cname.getText(), sub.getText(), lvl.getText(), introTxt.getText(), "");
                } else {
                    CourseRepository.createCourse(cname.getText(), sub.getText(), lvl.getText(), introTxt.getText(), (String) recCourse.getSelectionModel().getSelectedItem());
                }
            } catch (Exception ex) {
                System.out.println("Problem occurred at createCourse operation : " + ex);
            }

            FXMLLoader fxmlLoader = new FXMLLoader(courseController.class.getResource("Cousrse/course-view.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    protected void deleteCourse() throws SQLException{
        CourseRepository.deleteCourse(name[0]);
        tableView.getItems().clear();
        getList();
    }

    @FXML
    protected void updateCourse(ActionEvent event) throws  SQLException, IOException{
        if(cName.getSelectionModel().getSelectedItem()!=null) {
            if (recCourse.getSelectionModel().getSelectedItem() != null) {
                CourseRepository.updateCourse((String) cName.getSelectionModel().getSelectedItem(), sub.getText(), lvl.getText(), introTxt.getText(), (String) recCourse.getSelectionModel().getSelectedItem());
            } else {
                CourseRepository.updateCourse((String) cName.getSelectionModel().getSelectedItem(), sub.getText(), lvl.getText(), introTxt.getText(), "");
            }
            FXMLLoader fxmlLoader = new FXMLLoader(courseController.class.getResource("Course/course-view.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setScene(scene);
            stage.show();
        }else {
            System.out.println("Course name is verplicht");
        }
    }

     @Override
     public void initialize(URL arg0, ResourceBundle arg1) {

         try {
             getList();
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
         tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Course>() {
             @Override
             public void changed(ObservableValue<? extends Course> observable, Course oldValue, Course newValue) {
                 item = String.valueOf(tableView.getSelectionModel().getSelectedItem());
                 name = item.split(" ");
                 System.out.println(name[0]);
             }
         });

         selItem = CourseRepository.getCourses();
         if(cName != null){
             selItem.forEach(course -> {
                 items.add(course.toString());
             });
             items.forEach(item ->{
                 name = item.split(" ");
                 names.add(name[0]);
             });
             oListName = FXCollections.observableArrayList(names);
             cName.setItems(oListName);
             recCourse.setItems(oListName);
         }
     }
}


