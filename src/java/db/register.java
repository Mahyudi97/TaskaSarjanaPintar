/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import db.dbconnect;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Afiq
 */
public class register {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        try {
            
            String original = "970714075889"; //password
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(original.getBytes());
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }

            Connection conn = dbconnect.getConnection();
            PreparedStatement statement = conn.prepareStatement("UPDATE LOGIN SET LOGINPASSWORD = ? WHERE LOGINID= ?");
            statement.setString(1, sb.toString());
            statement.setString(2, "1"); //ic
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
