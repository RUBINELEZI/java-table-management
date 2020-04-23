package sample.controll;


import java.sql.*;
import java.time.LocalDate;


import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

import sample.database.databaseHandler;
import sample.database.info;
import sample.database.reservations;

public class infoController {

    LocalDate datee;

    public LocalDate getDatee() {
        return datee;
    }

    ObservableList<info> list = FXCollections.observableArrayList();

    @FXML
    private StackPane rootPane;
    @FXML
    private TableView<info> tableView;
    @FXML
    private TableColumn<info, String> colName;
    @FXML
    private TableColumn<info, String> colPhone;
    @FXML
    private TableColumn<info, String> colPeople;
    @FXML
    private TableColumn<info, String> colPrice;
    @FXML
    private TableColumn<info, String> colDate;
    @FXML
    private TableColumn<info, String> colTable;

    @FXML
    private TableColumn<info, String> id;

    @FXML
    private Button serachbtn;

    @FXML
    private TextField sField;

    @FXML
    private AnchorPane contentPane;

    @FXML
    private Button delete;




    info d = new info();

    public void setDate(LocalDate datee) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~  "+datee);
        this.datee = datee;
        System.out.println("```````````" + this.datee);
    }
    @FXML
    void initialize()  {
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colPeople.setCellValueFactory(new PropertyValueFactory<>("nrpeople"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        colTable.setCellValueFactory(new PropertyValueFactory<>("tableid"));

        Platform.runLater(() -> {
            try {
                loadData();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });


        //sorting and filter
        FilteredList<info> filteredData = new FilteredList<>(list, p -> true);
        //whether the filter changes

            sField.textProperty().addListener((observable, oldValue, newValue) -> {
                filteredData.setPredicate(person -> {
                    // If filter text is empty, display all persons.
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    // Compare first name and last name of every person with filter text.
                    String lowerCaseFilter = newValue.toLowerCase();
                    System.out.println(lowerCaseFilter);
                    if (person.getName().toLowerCase().contains(lowerCaseFilter)) {
                        return true; // Filter matches first name.
                    }else if ((person.getDate().toLowerCase().contains(lowerCaseFilter))) {
                        return true; // Filter matches first name.
                    }else if ((person.getTableid().toLowerCase().contains(lowerCaseFilter))) {
                        return true; // Filter matches first name.
                    }else if ((person.getNrpeople().toLowerCase().contains(lowerCaseFilter))) {
                        return true; // Filter matches first name.
                    }else if ((person.getPhone().toLowerCase().contains(lowerCaseFilter))) {
                        return true; // Filter matches first name.
                    }else if ((person.getPrice().toLowerCase().contains(lowerCaseFilter))) {
                        return true; // Filter matches first name.
                    }else {
                        return false; // Does not match.
                    }
                });
                tableView.setItems(filteredData);
            });

    }




    databaseHandler handler = databaseHandler.getInstance();
    private void loadData() throws SQLException {
        list.clear();
        Connection c = DriverManager.getConnection(handler.CONNECTION_STRING);
        c.setAutoCommit(false);
        reservations res = new reservations();
        firstPage f = new firstPage();

        System.out.println("==========" + this.datee);
        PreparedStatement stat = c.prepareStatement("SELECT * FROM reservations where date = ?");
        stat.setString(1, datee.toString());
        ResultSet rs = stat.executeQuery();
        try {
            while (rs.next()) {
                info i = new info();
                i.setName(rs.getString("name"));
                i.setPhone(rs.getString("phone"));
                i.setNrpeople(rs.getString("nrpeople"));
                i.setPrice(rs.getString("price"));
                i.setDate(rs.getString("date"));
                i.setTableid(rs.getString("tableid"));
                i.setId(rs.getInt("id"));



                list.add(i);
                System.out.println(i.getName());
            }
            tableView.setItems(list);
            rs.close();
            stat.close();
            c.close();

        } catch (SQLException ex) {
            System.out.println("problem");
        }


    }


firstPage f = new firstPage();

    @FXML
    void deletebtn(ActionEvent event) throws Exception {

        info selectedForDelete = tableView.getSelectionModel().getSelectedItem();
        int id = selectedForDelete.getId();


        handler.delete(id);
        tableView.getItems().remove(selectedForDelete);

    }

    @FXML
    void searchon(ActionEvent event) throws SQLException {

    }


}
