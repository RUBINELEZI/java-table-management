package sample.database;
import sample.controll.additem;

import java.sql.Date;

public class reservations {

    private String name;
    private String nrpeople;
    private int tableid;
    private String  price;
    private String phone;
    private String date;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNrpeople() {
        return nrpeople;
    }

    public void setNrpeople(String nrpeople) {
        this.nrpeople = nrpeople;
    }

    public int getTableid() {
        return tableid;
    }

    public void setTableid(int tableid) {
        this.tableid = tableid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "reservations{" +
                "name='" + name + '\'' +
                ", nrpeople=" + nrpeople +
                ", tableid=" + tableid +
                ", price=" + price +
                ", phone='" + phone + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
