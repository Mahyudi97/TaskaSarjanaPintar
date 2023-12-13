/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package da;

import db.dbconnect;
import domain.Fees;
import domain.Group;
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
public class StudentDA {

    /**
     * @param args the command line arguments
     */
    private static Connection conn;
    public static void main(String[] args) throws SQLException, NoSuchAlgorithmException {
        Student S=authenticateStudent("Mahmud","1632133221",0,"Male","32132132",5,3);
        System.out.println("Name:"+S.getStudName());
    }
    
    
    public static Student authenticateStudent(String studName, String studIC, int studAge, String studGender,String studBirthCertificate ,int parentId,int type) throws SQLException, NoSuchAlgorithmException
    {
        conn = dbconnect.getConnection();
        Student S = null;
        Group G = null;
        Fees F = null;
        int groupA=1;
        int groupB=3;
        int groupC=5;
        int groupD=99;
        try {
            
            if(type==1)//REGISTRATION
            {
                
                PreparedStatement statement;
                ResultSet rs;
                
                //DETERMINE GROUP
                statement = conn.prepareStatement("SELECT * FROM Groups");
                rs = statement.executeQuery();
                int num=0;
                while (rs.next()) {
                    int groupId = rs.getInt("groupId");
                    int groupAge = rs.getInt("groupAge");
                    if(studAge<groupAge)
                    {
                        G=new Group(groupId,groupAge);
                    }
                }
                
                //INSERT STUDENT
                statement = conn.prepareStatement("INSERT into Student(studName,studIC,studAge,studGender,studBirthCertificate,parentId,groupId) values (?,?,?,?,?,?,?)");
                statement.setString(1, studName);
                statement.setString(2, studIC);
                statement.setInt(3, studAge);
                statement.setString(4, studGender);
                statement.setString(5, studBirthCertificate);
                statement.setInt(6, parentId);
                statement.setInt(7, G.getGroupId());
                statement.executeQuery();

                statement = conn.prepareStatement("SELECT studId from Student where studIC = ? AND studBirthCertificate = ?");
                statement.setString(1, studIC);
                statement.setString(2, studBirthCertificate);
                rs = statement.executeQuery();
                while (rs.next()) 
                {
                    int studId = rs.getInt("studId");
                    S=new Student(studId,studName,studIC,studAge,studGender,studBirthCertificate);

                }
                
                //Determine Fees Amount
                int feesId=0;
                double feesAmount=0.0;
                double registerAmount=0.0;
                double monthlyAmount=0.0;
                String feesDueDate=" ";
                String feesType=" ";
                if(S.getStudAge()<groupA)
                {
                    registerAmount=720.0;
                    monthlyAmount=520.0;
                }
                else if(S.getStudAge()<groupB)
                {
                    registerAmount=720.0;
                    monthlyAmount=520.0;
                }
                else if(S.getStudAge()<groupC)
                {
                    registerAmount=620.0;
                    monthlyAmount=420.0;
                }
                else
                {
                    registerAmount=620.0;
                    monthlyAmount=420.0;
                }
                //Registration
                statement = conn.prepareStatement("INSERT into Fees(feesAmount,feesDueDate,feesType,studId) values (?,add_months(sysdate,1),?,?)");
                statement.setDouble(1, registerAmount);
                statement.setString(2, "Registration");
                statement.setInt(3, S.getStudId());
                rs = statement.executeQuery();
                
                statement = conn.prepareStatement("SELECT max(feesId) from fees");
                //statement.setDouble(1, S.getStudId());
               // statement.setString(2, "Registration");
                rs = statement.executeQuery();
                while (rs.next()) 
                {
                    feesId=rs.getInt("max(feesId)");
                        
                }
                //F=new Fees(feesId,feesAmount,feesDueDate,feesType);  
                //PAYMENT
                statement = conn.prepareStatement("INSERT into Payment(dateOfPayment,paymentStatus,feesId) values (SYSDATE,?,?)");
                statement.setString(1, "Unpaid");
                statement.setInt(2, feesId);
                statement.executeQuery();
                
                
                //Monthly
                int no=2;
                while(no<=12)
                {
                    statement = conn.prepareStatement("INSERT into Fees(feesAmount,feesDueDate,feesType,studId) values (?,add_months(sysdate,?),?,?)");
                    statement.setDouble(1, monthlyAmount);
                    statement.setInt(2, no);
                    statement.setString(3, "Monthly");
                    statement.setInt(4, S.getStudId());
                    rs = statement.executeQuery();
                    statement = conn.prepareStatement("SELECT max(feesId) from fees");
                    //statement.setDouble(1, S.getStudId());
                    //statement.setString(2, "Registration");
                    rs = statement.executeQuery();
                    while (rs.next()) 
                    {
                        feesId=rs.getInt("max(feesId)");
                    }
                    //F=new Fees(feesId,feesAmount,feesDueDate,feesType);  
                    //PAYMENT
                    statement = conn.prepareStatement("INSERT into Payment(dateOfPayment,paymentStatus,feesId) values (SYSDATE,?,?)");
                    statement.setString(1, "Unpaid");
                    statement.setInt(2, feesId);
                    statement.executeQuery();
                    
                    no++;
                }
                
                    
                   
                    
                
                
                
                
            }
            else if(type == 2)//VIEW STUDENT PROFILE    
            {
                PreparedStatement statement;
                ResultSet rs;
                
                statement = conn.prepareStatement("SELECT * from Student where studIC = ?");
                statement.setString(1, studIC);
                rs = statement.executeQuery();

                while (rs.next()) 
                {
                    int studId = rs.getInt("studId");
                    String Name = rs.getString("studName");
                    String IC = rs.getString("studIC");
                    int Age = rs.getInt("studAge");
                    String Gender = rs.getString("studGender");
                    String BirthCertificate = rs.getString("studBirthCertificate");
                    S=new Student(studId,Name,IC,Age,Gender,BirthCertificate);

                }
            }
            else
            if(type==3)//edit
            {
                PreparedStatement statement;
                ResultSet rs;
                
                statement = conn.prepareStatement("update student set studname=?, studAge=?, studGender=?,studBirthCertificate=? where studIC=?");
                statement.setString(1, studName);
                statement.setInt(2, studAge);
                statement.setString(3, studGender);
                statement.setString(4, studBirthCertificate);
                statement.setString(5, studIC);
                statement.executeQuery();

                statement = conn.prepareStatement("SELECT studId from Student where studIC = ? AND studBirthCertificate = ?");
                statement.setString(1, studIC);
                statement.setString(2, studBirthCertificate);
                rs = statement.executeQuery();
                while (rs.next()) 
                {
                    int studId = rs.getInt("studId");
                    S=new Student(studId,studName,studIC,studAge,studGender,studBirthCertificate);

                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return S;
        
    }
    
}
