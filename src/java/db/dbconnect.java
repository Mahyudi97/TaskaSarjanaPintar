package db;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Ahmad Mahyudi
 */
public class dbconnect {
    static Connection conn = null;

    public dbconnect() {

    }

    public static Connection getConnection() throws SQLException {

        try {
            try {
                Class.forName("oracle.jdbc.OracleDriver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "tsp", "tsp"); //attempting to connect to MySQL database
            System.out.println("Printing connection object " + conn);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
}
