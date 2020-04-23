package sample.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import sample.controll.infoController;


public class databaseHandler {
    public static final String DB_NAME = "eReservation.db";

    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\User\\Desktop\\java-table-management\\src\\sample\\database\\" + DB_NAME;
    public static final String TABLE_RESERVATIONS = "reservations";


    private static Connection conn = null;
    private static Statement stmt = null;
    private static databaseHandler handler = null;

    public static databaseHandler getInstance() {
        if (handler == null) {
            handler = new databaseHandler();
        }
        return handler;
    }


    public boolean open(){
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            return true;
        }catch(SQLException e){
            System.out.println("Couldn't connect to a database: " + e.getMessage());
            return false;
        }
    }

    public void colse(){
        try{
            if (conn != null){
                conn.close();
            }
        }catch(SQLException e){
            System.out.println("Couldnt connect" + e.getMessage());
        }
    }

    public ResultSet execQuerry(String query) {
        ResultSet result = null;
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(CONNECTION_STRING);
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            Statement stmt = conn.createStatement();
            result = stmt.executeQuery(query);


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<reservations> getquerry(String COLUMN_DATE) throws SQLException {
        Connection c = null;
        Statement stmt = null;
        List<reservations> id_list = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(CONNECTION_STRING);
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM " + TABLE_RESERVATIONS + " WHERE date = \"" + COLUMN_DATE + "\";");

            while ( rs.next() ) {
                reservations reserv = new reservations();
                int tableid = rs.getInt("tableid");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String nrpeople = rs.getString("nrpeople");
                int id = rs.getInt("id");
                reserv.setName(name);
                reserv.setNrpeople(nrpeople);
                reserv.setPhone(phone);
                reserv.setTableid(tableid);
                reserv.setId(id);
                id_list.add(reserv);
//                System.out.println( "tableid = " + tableid );
            }

            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        return id_list;
    }


    public static void saveAll(reservations people)
            throws SQLException {
        conn = DriverManager.getConnection(CONNECTION_STRING);
        PreparedStatement prep = conn.prepareStatement("INSERT INTO reservations (name, phone, nrpeople, price, date, tableid) VALUES (?,  ?, ?, ?, ?, ?)");

            prep.setString(1, people.getName());
            prep.setString(2, people.getPhone());
            prep.setString(3, people.getNrpeople());
            prep.setString(4, people.getPrice());
            prep.setString(5, people.getDate());
            prep.setInt(6, people.getTableid());



            prep.addBatch();

        conn.setAutoCommit(false);
        prep.executeBatch();
        conn.setAutoCommit(true);
        prep.close();
    }


    private Connection connect() {
        // SQLite connection string
        String url = CONNECTION_STRING;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void delete(int id) {
        String sql = "DELETE FROM reservations WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

        colse();
    }

    }




