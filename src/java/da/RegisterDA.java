/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import db.dbconnect;
import domain.Group;
import domain.Registration;
import domain.Student;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ahmad Mahyudi
 */
public class RegisterDA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {
        // TODO code application logic here
        Registration R = authenticateRegistration(8);
        System.out.println("DSDS : "+R.getRegistrationDate());
        
    }
    
    private static Connection conn;
    public static Registration authenticateRegistration(int studId) throws SQLException, NoSuchAlgorithmException{
        
        conn = dbconnect.getConnection();

        Registration R = null;
        Student S = null;
        Group G = null;
        try {

            PreparedStatement statement;
            ResultSet rs;
            //RETRIEVE STUDENT INFORMATION
            statement = conn.prepareStatement("SELECT * FROM Student where studId =?");
            statement.setInt(1, studId);
            rs = statement.executeQuery();
            while (rs.next()) {
                String studName=rs.getString("studName");
                String studIC=rs.getString("studIC");
                int studAge = rs.getInt("studAge");
                String studGender = rs.getString("studgender");
                String studBirthCertificate = rs.getString("studBirthCertificate");
                S=new Student(studId,studName,studIC,studAge,studGender,studBirthCertificate);
               
            }
            
            //DETERMINE GROUP
            statement = conn.prepareStatement("SELECT * FROM Groups");
            rs = statement.executeQuery();
            int num=0;
            while (rs.next()) {
                int groupId = rs.getInt("groupId");
                int groupAge = rs.getInt("groupAge");
                if(S.getStudAge()<groupAge)
                {
                    G=new Group(groupId,groupAge);
                }
            }
            
            //INSERT REGISTRATION  
            statement = conn.prepareStatement("INSERT into Registration(registrationDate,studId) values (SYSDATE,?)");
            statement.setInt(1, S.getStudId());
            statement.executeQuery();
            
            //REGISTRATION  
            statement = conn.prepareStatement("SELECT * FROM Registration where studId =?");
            statement.setInt(1, S.getStudId());
            rs = statement.executeQuery();
            while (rs.next()) 
            {
                int registrationId = rs.getInt("registrationId");
                String registrationDate = rs.getString("registrationDate");
                
                R=new Registration(registrationId,registrationDate);
            }
            
            //update
            
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return R;

    }
    
}
