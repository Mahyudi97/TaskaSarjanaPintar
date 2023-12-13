/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import db.dbconnect;
import domain.Parent;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ahmad Mahyudi
 */
public class ParentDA {

    private static Connection conn;
    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {
        Parent P = authenticateParent("dsadas","dsadas","dsadas","dsadas","dsadas","dsadas","dsadas","dsadas","dsadas","dsadas","dsadas",3);
        System.out.println("Dsadsadsadsadsadsadsa:"+P.getFatherContact());
    }
    public static Parent authenticateParent(String parentAddress,String fatherName, String fatherIC, String fatherContact, String fatherOccupation, String fatherOccupAddress, String motherName, String motherIC, String motherContact, String motherOccupation, String motherOccupAddress,int type) throws SQLException, NoSuchAlgorithmException
    {
        
        conn = dbconnect.getConnection();

        Parent P = null;
        try {
            if(type==1)//REGISTER
            {    
        
            PreparedStatement statement;
            ResultSet rs;
            
            statement = conn.prepareStatement("INSERT into Parent(parentAddress,fatherName,fatherIC,fatherContact,fatherOccupation,fatherOccupAddress,motherName,motherIC,motherContact,motherOccupation,motherOccupAddress) values (?,?,?,?,?,?,?,?,?,?,?)");
            statement.setString(1,parentAddress);
            statement.setString(2,fatherName);
            statement.setString(3,fatherIC);
            statement.setString(4,fatherContact);
            statement.setString(5,fatherOccupation);
            statement.setString(6,fatherOccupAddress);
            statement.setString(7,motherName);
            statement.setString(8,motherIC);
            statement.setString(9,motherContact);
            statement.setString(10,motherOccupation);
            statement.setString(11,motherOccupAddress);
            statement.executeQuery();
            
            statement = conn.prepareStatement("SELECT parentId from Parent where fatherIC = ? AND motherIC = ?");
            statement.setString(1, fatherIC);
            statement.setString(2, motherIC);
            rs = statement.executeQuery();
            while (rs.next()) 
            {
                int parentId = rs.getInt("parentId");
                P=new Parent(parentId,parentAddress,fatherName,fatherIC,fatherContact,fatherOccupation,fatherOccupAddress,motherName,motherIC,motherContact,motherOccupation,motherOccupAddress);
               
            }
            }
            else if(type==3)//edit
            {
                PreparedStatement statement;
                ResultSet rs;

                statement = conn.prepareStatement("update parent set parentAddress=?, fatherName=?, fatherContact=?,fatherOccupation=?,fatherOccupAddress=?,motherName=?, motherContact=?,motherOccupation=?,motherOccupAddress=? where fatherIC=? and motherIC=?");
                statement.setString(1,parentAddress);
                statement.setString(2,fatherName);
                statement.setString(3,fatherContact);
                statement.setString(4,fatherOccupation);
                statement.setString(5,fatherOccupAddress);
                statement.setString(6,motherName);
                statement.setString(7,motherContact);
                statement.setString(8,motherOccupation);
                statement.setString(9,motherOccupAddress);
                statement.setString(10,fatherIC);
                statement.setString(11,motherIC);
                statement.executeQuery();

                statement = conn.prepareStatement("SELECT parentId from Parent where fatherIC = ? AND motherIC = ?");
                statement.setString(1, fatherIC);
                statement.setString(2, motherIC);
                rs = statement.executeQuery();
                while (rs.next()) 
                {
                    int parentId = rs.getInt("parentId");
                    P=new Parent(parentId,parentAddress,fatherName,fatherIC,fatherContact,fatherOccupation,fatherOccupAddress,motherName,motherIC,motherContact,motherOccupation,motherOccupAddress);

                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return P;
    }
}
