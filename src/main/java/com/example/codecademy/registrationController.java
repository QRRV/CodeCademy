package com.example.codecademy;

import com.example.codecademy.Domain.Course;
import com.example.codecademy.Domain.Registration;
import com.example.codecademy.Repository.CourseRepository;
import com.example.codecademy.Repository.RegistrationRepository;
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
import org.w3c.dom.Text;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class registrationController implements Initializable {

    @FXML
    Stage stage;
    @FXML
    private TableView<Registration> tableView = new TableView<Registration>();
    @FXML
    private TextField cname;
    @FXML
    private TextField eMail;
    @FXML
    private TextField certificateId;
    @FXML
    private TextField newName;
    @FXML
    private TextField NewemailAddress;
    @FXML
    private TextField regDate;
    @FXML
    private TextField certID;
    @FXML
    private ComboBox registratieBox = new ComboBox<>();
    @FXML
    private TableColumn courseName = new TableColumn<>();

    @FXML
    private TableColumn emailAddress = new TableColumn<>();
    @FXML
    private TableColumn registrationDate = new TableColumn<>();
    @FXML
    private TableColumn certificateID = new TableColumn<>();


    ObservableList oListRegistrations;
    String item;
    String[] name;
    String[] mail;
    String[] date;
    String[] rDate;
    String[] Item;
    ArrayList<String> items = new ArrayList<String>();
    ObservableList<String> oListName;



    @FXML
    protected void toMain(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(studentController.class.getResource("main-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void toRegistration(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(studentController.class.getResource("Registration/registration-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void toCreate(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(studentController.class.getResource("Registration/registrationCreate-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 511, 600);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void createRegistration (ActionEvent event) throws IOException {
        if(certificateId.getText()==null){
            RegistrationRepository.createRegistration(eMail.getText(), cname.getText(), new Date().toString(), null);
        }else {
            RegistrationRepository.createRegistration(eMail.getText(), cname.getText(), new Date().toString(), certificateId.getText());
        }
        FXMLLoader fxmlLoader = new FXMLLoader(studentController.class.getResource("Registration/registration-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void toUpdate(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(studentController.class.getResource("Registration/registrationUpdate-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 511, 600);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void updateRegistration (ActionEvent event) throws IOException {
        RegistrationRepository.updateRegistration((String) registratieBox.getSelectionModel().getSelectedItem(), NewemailAddress.getText(), newName.getText(), new Date().toString());

        FXMLLoader fxmlLoader = new FXMLLoader(studentController.class.getResource("Registration/registration-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void getList() throws SQLException {
        ArrayList<Registration> registrations = RegistrationRepository.getRegistrations();
        tableView.getItems().clear();
        oListRegistrations = tableView.getItems();
        registrations.forEach(course -> {
            oListRegistrations.add(course);
        });
        courseName.setCellValueFactory(new PropertyValueFactory<Course,String>("courseName"));
        emailAddress.setCellValueFactory(new PropertyValueFactory<Course,String>("emailAddress"));
        registrationDate.setCellValueFactory(new PropertyValueFactory<Course,String>("registrationDate"));
        certificateID.setCellValueFactory(new PropertyValueFactory<Course,String>("certificateID"));

        tableView.setItems(oListRegistrations);
    }

    @FXML
    protected void deleteRegistration() throws SQLException {
        RegistrationRepository.deleteRegistration(mail[1], name[1], rDate[0]);
        tableView.getItems().clear();
        getList();

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        try {
            getList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Registration>() {
            @Override
            public void changed(ObservableValue<? extends Registration> observable, Registration oldValue, Registration newValue) {
                item = String.valueOf(tableView.getSelectionModel().getSelectedItem());
                Item = item.split(" ");
                mail = Item[1].split("'");
                name = Item[2].split("'");
                date = Item[0].split("=");
                rDate = date[1].split(",");
                System.out.println(rDate[0]);

            }
        });

//        selItem = CourseRepository.getCourses();
//        if (registratieBox != null) {
//            selItem.forEach(registration -> {
//                items.add(registration.toString());
//            });
//            items.forEach(item -> {
//                name = item.split(" ");
//                names.add(name[0]);
//            });
//            oListName = FXCollections.observableArrayList(names);
//            registratieBox.setItems(oListName);
//        }
    }
}
