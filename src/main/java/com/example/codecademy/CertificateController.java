package com.example.codecademy;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.codecademy.Domain.Certificate;
import com.example.codecademy.Repository.CertificateRepository;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CertificateController extends CertificateRepository implements Initializable {
    @FXML
    private Stage stage;
    String item;
    String[] name;
    ArrayList<String> items = new ArrayList<String>();
    ObservableList<String> oListName;
    ArrayList<Course> selItem;
    ArrayList<String> names = new ArrayList<String>();
    @FXML
    protected void toUpdate(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(courseController.class.getResource("CertificateUpdate-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 511, 600);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void toCreate(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(courseController.class.getResource("CertificateCreate-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 511, 600);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void BackToCertifficate(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(courseController.class.getResource("Certificate-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize() {

    }
}
