package sample.database;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../view/firstPage.fxml"));

        primaryStage.setTitle("eReservation");
        primaryStage.setScene(new Scene(root, 900, 650));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        databaseHandler databaseHandler = new databaseHandler();
        if(!databaseHandler.open()){
            System.out.println("cant open");
            return;
        }
        databaseHandler.colse();
    }

    }

