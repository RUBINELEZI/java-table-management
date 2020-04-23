package sample.database;


import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class info {
    private SimpleStringProperty name = new SimpleStringProperty();
   private SimpleStringProperty phone =  new SimpleStringProperty();
   private SimpleStringProperty nrpeople = new SimpleStringProperty();
   private SimpleStringProperty price = new SimpleStringProperty();
   private SimpleStringProperty date = new SimpleStringProperty();
   private SimpleStringProperty tableid = new SimpleStringProperty();
   private SimpleIntegerProperty id = new SimpleIntegerProperty();

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getNrpeople() {
        return nrpeople.get();
    }

    public SimpleStringProperty nrpeopleProperty() {
        return nrpeople;
    }

    public void setNrpeople(String nrpeople) {
        this.nrpeople.set(nrpeople);
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getDate() {
        return date.get();
    }

    public SimpleStringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getTableid() {
        return tableid.get();
    }

    public SimpleStringProperty tableidProperty() {
        return tableid;
    }

    public void setTableid(String tableid) {
        this.tableid.set(tableid);
    }
}
