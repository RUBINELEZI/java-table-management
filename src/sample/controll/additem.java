package sample.controll;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.database.databaseHandler;
import sample.database.reservations;

public class additem {

    private int tableid;

    @FXML
    private BorderPane rootPane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField name;

    @FXML
    private TextField phoneNO;

    @FXML
    private TextField nrPeople;

    @FXML
    private TextField price;

    @FXML
    private DatePicker date;

    @FXML
    public Button closeButton;

    private LocalDate datee;

    public void setTableid(int tableid, LocalDate date) {
        this.tableid = tableid;
        this.datee = date;
    }

    @FXML
    private void add() throws Exception {


        reservations reservations = new reservations();

        if (name.getText().isEmpty() || nrPeople.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("You should enter name and number of people");
            alert.showAndWait();
            if ( datee == null){

                alert.setHeaderText(null);
                alert.setContentText("You should specify a date");
                alert.showAndWait();
                handleCloseButtonAction();
            }
        }else{
            reservations.setPhone(phoneNO.getText());
            reservations.setName(name.getText());
            reservations.setPrice(price.getText());
            reservations.setNrpeople(nrPeople.getText());
            reservations.setDate(datee.toString());
            reservations.setTableid(tableid);

            databaseHandler.saveAll(reservations);

            handleCloseButtonAction();
        }





    }



    public void handleCloseButtonAction() {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }
}
