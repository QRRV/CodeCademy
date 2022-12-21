package com.example.codecademy;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.example.codecademy.Domain.Certificate;
import com.example.codecademy.Repository.CertificateRepository;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CertificateController extends CertificateRepository implements Initializable {
    @FXML
    private TextField cID;
    @FXML
    private TextField grd;
    @FXML
    private TextField nameEmp;
    @FXML
    private Stage stage;
    @FXML
    private TableColumn certificateID = new TableColumn<>();
    @FXML
    private TableColumn grade = new TableColumn<>();
    @FXML
    private TableColumn nameEmployer = new TableColumn<>();
    String item;
    String[] certId;
    ObservableList<Certificate> oListCertificate;
    @FXML
    private TableView<Certificate> tableView = new TableView<Certificate>();

    @FXML
    protected void createCertificate(ActionEvent event) throws IOException{
        System.out.println(cID.getText());
        if(cID.getText().isBlank()) {
            System.out.println("Certificate ID is verplicht");
        }else {
            try {
                CertificateRepository.createCertificate(Integer.parseInt(cID.getText()), Integer.parseInt(grd.getText()), nameEmp.getText());
            } catch (Exception ex) {
                System.out.println("Problem occurred at createCourse operation : " + ex);
            }

            FXMLLoader fxmlLoader = new FXMLLoader(CertificateController.class.getResource("Certificate-View.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setScene(scene);
            stage.show();
        }
    }
    @FXML
    protected void updateCertificate(ActionEvent event) throws  SQLException, IOException{
        System.out.println(cID.getText());
        if(cID.getText().isBlank()) {
            System.out.println("Certificate ID is verplicht");
        }else {
            try {
                CertificateRepository.updateCertificate(Integer.parseInt(cID.getText()), Integer.parseInt(grd.getText()), nameEmp.getText());
            } catch (Exception ex) {
                System.out.println("Problem occurred at createCourse operation : " + ex);
            }

            FXMLLoader fxmlLoader = new FXMLLoader(CertificateController.class.getResource("Certificate-View.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(fxmlLoader.load(), 800, 600);
            stage.setScene(scene);
            stage.show();
        }
    }
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
    protected void deleteCertificate() throws SQLException{
        CertificateRepository.deleteCertificate(Integer.parseInt(certId[0]));
        tableView.getItems().clear();
        getList();
    }

    @FXML
    protected void BackToCertifficate(ActionEvent event) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(courseController.class.getResource("Certificate-view.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void getList() throws SQLException{
        ArrayList<Certificate> certificates = CertificateRepository.getCertificates();
        tableView.getItems().clear();
        oListCertificate = tableView.getItems();
        certificates.forEach(certificate -> {
            oListCertificate.add(certificate);
        });
        System.out.println(oListCertificate);
        certificateID.setCellValueFactory(new PropertyValueFactory<Certificate, Integer>("certificateId"));
        grade.setCellValueFactory(new PropertyValueFactory<Certificate, Integer>("grade"));
        nameEmployer.setCellValueFactory(new PropertyValueFactory<Certificate, String>("nameEmployer"));
        tableView.setItems(oListCertificate);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        try {
            getList();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Certificate>() {
            @Override
            public void changed(ObservableValue<? extends Certificate> observable, Certificate oldValue, Certificate newValue) {
                item = String.valueOf(tableView.getSelectionModel().getSelectedItem());
                certId = item.split(" ");
                System.out.println(certId[0]);

            }
        });
    }
}
