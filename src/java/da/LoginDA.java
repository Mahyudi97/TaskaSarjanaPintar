/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import db.dbconnect;
import domain.Login;
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
 * @author Ahmad Mahyudi
 */
public class LoginDA {
    private static Connection conn;
    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException
    {
           //Login L = authenticateLogin(1,"970714075889");
           Login L = authenticateLoginEdit(6,"abcd");
           System.out.println("dsadsdsa: "+L.getLoginId());
           System.out.println("dsadsdsa: "+L.getLoginPassword());
           
    }
    
    //Login
    public static Login authenticateLogin(int teacherId,String loginPassword) throws SQLException, NoSuchAlgorithmException{
        
        conn = dbconnect.getConnection();

        Login L = null;
        StringBuffer sb = null;
        try {

            MessageDigest md;
            try {
                md = MessageDigest.getInstance("MD5");
                md.update(loginPassword.getBytes());
                byte[] digest = md.digest();
                sb = new StringBuffer();
                for (byte b : digest) {
                    sb.append(String.format("%02x", b & 0xff));
                }
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(LoginDA.class.getName()).log(Level.SEVERE, null, ex);
            }
            PreparedStatement statement;
            ResultSet rs;
            System.out.println(sb.toString());

            statement = conn.prepareStatement("SELECT * FROM Login JOIN Teacher ON Login.loginId=Teacher.loginId WHERE teacherId = ? AND loginPassword = ?");
            statement.setInt(1, teacherId);
            statement.setString(2, sb.toString());

            rs = statement.executeQuery();
            while (rs.next()) {
                int loginId = rs.getInt("loginId");
                L=new Login(loginId,loginPassword);
               
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return L;

    }
    //ADD TEACHER
    public static Login authenticateLogin(String loginPassword) throws SQLException, NoSuchAlgorithmException
    {
        conn = dbconnect.getConnection();

        Login L = null;
        try {
                String original = loginPassword; //password
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(original.getBytes());
                byte[] digest = md.digest();
                StringBuffer sb = new StringBuffer();
                for (byte b : digest) {
                    sb.append(String.format("%02x", b & 0xff));
                }
                
            PreparedStatement statement;
            ResultSet rs;
            statement = conn.prepareStatement("INSERT into Login(loginPassword) values(?)");
            statement.setString(1, sb.toString());
            statement.executeQuery();
            
            statement = conn.prepareStatement("select max(loginId) from login");
            rs = statement.executeQuery();
            while (rs.next()) {
                int loginId = rs.getInt("max(loginId)");
                L=new Login(loginId,loginPassword);
               
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return L;

    }
    
    
    //Edit TEACHER
    public static Login authenticateLoginEdit(int teacherId,String loginPassword) throws SQLException, NoSuchAlgorithmException
    {
        conn = dbconnect.getConnection();

        Login L = null;
        try {
                String original = loginPassword; //password
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(original.getBytes());
                byte[] digest = md.digest();
                StringBuffer sb = new StringBuffer();
                for (byte b : digest) {
                    sb.append(String.format("%02x", b & 0xff));
                }
                
            PreparedStatement statement;
            ResultSet rs;
            
            statement = conn.prepareStatement("SELECT * FROM Login JOIN Teacher ON Login.loginId=Teacher.loginId WHERE Teacher.teacherId = ?");
            statement.setInt(1, teacherId);
            rs = statement.executeQuery();
            while (rs.next()) {
                int loginId = rs.getInt("loginId");
                L=new Login(loginId,loginPassword);
               
            }
            statement = conn.prepareStatement("update login set loginPassword=? where loginId=?");
            statement.setString(1, sb.toString());
            statement.setInt(2, L.getLoginId());
            statement.executeQuery();
            
            

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return L;

    }
    
}
