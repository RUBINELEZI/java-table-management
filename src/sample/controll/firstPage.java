package sample.controll;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.database.info;
import sample.database.reservations;
import sample.database.databaseHandler;
public class firstPage  {

    databaseHandler databaseHandler = new databaseHandler();

    @FXML
    private DatePicker date;

    @FXML
    private Rectangle table1;

    @FXML
    private Rectangle table2;

    @FXML
    private Rectangle table3;

    @FXML
    private Rectangle table4;

    @FXML
    private Rectangle table5;

    @FXML
    private TabPane tabPane;

    @FXML
    private AnchorPane tabPane2;





    reservations t = new reservations();

    sample.database.info info = new info();

    public firstPage() {
    }

    @FXML
    void table1() {
        t.setTableid(1);
        btnClicked();

    }

    @FXML
    void table2() {
        t.setTableid(2);
        btnClicked();
    }

    @FXML
    void table3() {
        t.setTableid(3);
        btnClicked();
    }

    @FXML
    void table4() {
        t.setTableid(4);
        btnClicked();
    }

    @FXML
    void table5() {
        t.setTableid(5);
        btnClicked();
    }

//    infoController infoController = new infoController();
    @FXML
    void initialize() throws IOException {

    }
    //metoda qe ndryshon skenat kur shtypet butoini
    private void btnClicked() {

            try {
                Stage popupwindow = new Stage();
                popupwindow.initModality(Modality.APPLICATION_MODAL);
                popupwindow.setTitle("eReservation");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/sample/view/dialoge.fxml"));
                Parent root = loader.load();
                additem childcontroller = loader.getController();
                LocalDate datee =  date.getValue();
                childcontroller.setTableid(t.getTableid(),datee);

                Scene scene1 = new Scene(root);
                popupwindow.setScene(scene1);
                popupwindow.showAndWait();
                dateaction();


            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

    }

    @FXML
    void refresh(ActionEvent event) throws Exception {
        dateaction();
    }



    public void returnDefault(){
        table1.setStyle("-fx-fill: DODGERBLUE");
        table1.setDisable(false);
        table2.setStyle("-fx-fill: DODGERBLUE");
        table2.setDisable(false);
        table3.setStyle("-fx-fill: DODGERBLUE");
        table3.setDisable(false);
        table4.setStyle("-fx-fill: DODGERBLUE");
        table4.setDisable(false);
        table5.setStyle("-fx-fill: DODGERBLUE");
        table5.setDisable(false);
    }



    public void dateaction() throws Exception {
        returnDefault();
        reservations s = new reservations();
        LocalDate data = date.getValue();
        s.setDate(data.toString());
        System.out.println(s.getDate());

        List<reservations> id_list = databaseHandler.getquerry(String.valueOf(data));
        for(reservations x : id_list){
            if(x.getTableid() == 1){
                table1.setStyle("-fx-fill: #e85454");
                table1.setDisable(true);



            }
            if(x.getTableid() == 2){
                table2.setStyle("-fx-fill: #e85454");
                table2.setDisable(true);

            }
            if(x.getTableid() == 3){
                table3.setStyle("-fx-fill: #e85454");
                table3.setDisable(true);

            }
            if(x.getTableid() == 4){
                table4.setStyle("-fx-fill: #e85454");
                table4.setDisable(true);

            }
            if(x.getTableid() == 5){
                table5.setStyle("-fx-fill: #e85454");
                table5.setDisable(true);
            }
            System.out.println(x);

        }
        tabPane2.getChildren().removeAll();
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("sample/view/info.fxml"));
        tabPane2.getChildren().add(loader.load());
        infoController cont = loader.getController();
        LocalDate datee =  date.getValue();
        cont.setDate(datee);

        System.out.println("data eshte" + cont.getDatee());
    }


}
    




