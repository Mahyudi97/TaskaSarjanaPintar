/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import db.dbconnect;
import domain.Teacher;
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
public class TeacherDA{
    
    private static Connection conn;
    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException
    {
         Teacher T = TeacherDA.authenticateTeacher(6,"Ahmad Amir","97071234569","Admin","012565656","Setia");//Edit
         
         System.out.print("NAme : "+T.getTeacherName());
         System.out.print("IC : "+T.getTeacherIC());
         
         
    }
        //LOGIN
        public static Teacher authenticateTeacher(String teacherIC) throws SQLException, NoSuchAlgorithmException
         {
             
            conn = dbconnect.getConnection();
            Teacher T = null;
            StringBuffer sb = null;
            try {
                PreparedStatement statement;
                ResultSet rs;
                statement = conn.prepareStatement("SELECT * FROM Teacher WHERE teacherIC = ? ");
                statement.setString(1, teacherIC);

                rs = statement.executeQuery();
                while (rs.next()) {
                    int teacherId = rs.getInt("teacherId");
                    String teacherName = rs.getString("teacherName");
                    String teacherPosition = rs.getString("teacherPosition");
                    String teacherContact = rs.getString("teacherContact");
                    T=new Teacher(teacherId,teacherName,teacherIC,teacherPosition,teacherContact);
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            return T;

        }
        
        //ADD TEACHER
        public static Teacher authenticateTeacher(String teacherName,String teacherIC,String teacherPosition,String teacherContact,String className,int loginId) throws SQLException, NoSuchAlgorithmException
         {
             
            conn = dbconnect.getConnection();
            Teacher T = null;
            StringBuffer sb = null;
            try {
                PreparedStatement statement;
                ResultSet rs;
                statement = conn.prepareStatement("INSERT into Teacher(teacherName,teacherIC,teacherPosition,teacherContact,loginId) values (?,?,?,?,?)");
                statement.setString(1, teacherName);
                statement.setString(2, teacherIC);
                statement.setString(3, teacherPosition);
                statement.setString(4, teacherContact);
                statement.setInt(5, loginId);
                rs = statement.executeQuery();
                
                statement = conn.prepareStatement("Select * from Teacher where teacherIC=? AND loginid=?");
                statement.setString(1, teacherIC);
                statement.setInt(2, loginId);
                rs = statement.executeQuery();
                while (rs.next()) {
                    
                    int teacherId=rs.getInt("teacherId");
                    T=new Teacher(teacherId,teacherName,teacherIC,teacherPosition,teacherContact);
                }
                
                statement = conn.prepareStatement("update class set teacherId=? where className=?");
                statement.setInt(1, T.getTeacherId());
                statement.setString(2, className);
                rs = statement.executeQuery();
                
                

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            return T;

        }
        
        //Edit TEACHER
        public static Teacher authenticateTeacher(int teacherid,String teacherName,String teacherIC,String teacherPosition,String teacherContact,String className) throws SQLException, NoSuchAlgorithmException
         {
             
            conn = dbconnect.getConnection();
            Teacher T = null;
            StringBuffer sb = null;
            try {
                PreparedStatement statement;
                ResultSet rs;
                statement = conn.prepareStatement("update teacher set teacherName=?, teacherIC=?, teacherPosition=?, teacherContact=? where teacherId=?");
                statement.setString(1, teacherName);
                statement.setString(2, teacherIC);
                statement.setString(3, teacherPosition);
                statement.setString(4, teacherContact);
                statement.setInt(5, teacherid);
                rs = statement.executeQuery();
                
                statement = conn.prepareStatement("Select * from Teacher where teacherId=?");
                statement.setInt(1, teacherid);
                rs = statement.executeQuery();
                while (rs.next()) {
                    
                    int teacherId=rs.getInt("teacherId");
                    T=new Teacher(teacherId,teacherName,teacherIC,teacherPosition,teacherContact);
                }
                
                statement = conn.prepareStatement("update class set teacherId=? where className=?");
                statement.setInt(1, T.getTeacherId());
                statement.setString(2, className);
                rs = statement.executeQuery();
                
                

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

            return T;

        }
    
}
