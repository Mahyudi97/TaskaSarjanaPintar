<%-- 
    Document   : studentProfile
    Created on : Jul 1, 2019, 6:29:31 PM
    Author     : Ahmad Mahyudi
--%>

<%@page import="domain.Student"%>
<%@page import="domain.Parent"%>
<%@page import="db.dbconnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*;"%>
<%@ page language="java" import="java.sql.*"%>
<%@ page import="java.util.Random"%>

<!DOCTYPE html>
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/stylesheet.css">
<html> 
<title> Taska Sarjana Pintar</title>
    <head>
        <div class="navbar">
            <h1 class="w3-center"><b><img src="css/logo.png" style="width:5%">Taska Sarjana Pintar</b></h1>
        <a href="index.jsp">Home</a>
        <a href="ourInfo.jsp">Our Info</a>
        <a href="register.jsp">Register</a>
        <a href="studentProfile.jsp">Student Profile</a>
        <a href="login.jsp" >User</a>
      </div>
    </head>
  <body>
      <br><br><br><br><br><br><br><br><br><br>
      <%int studId = (Integer) request.getAttribute("studId"); %>
      <div class="w3-container w3-content w3-center w3-padding-64 w3-round w3-border w3-card-4 w3-light-grey" style="max-width:1500px">
        <form action="${pageContext.request.contextPath}/viewStudentController" method="post" class="w3-center">
          <center> 
        <table border="0">
            <tr>
                <td>Enter student's IC :</td>
                <td><input class="w3-input w3-border" type="text" placeholder="Student's IC" required name="studIC"></td>
            </tr>
        </table>
        <center>
        <button class="w3-button w3-black w3-section w3-card-4 w3-round" type="submit" name="submit">SUBMIT</button>
      </center>
        </form>
        <%
        
        
          try
          {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "tsp", "tsp");
            PreparedStatement statement;
            ResultSet rs;
            statement = conn.prepareStatement("SELECT * FROM student JOIN parent on parent.parentID=student.parentID where student.studId=?");
            statement.setInt(1, studId);
            rs = statement.executeQuery();
            while(rs.next()) 
            {
        %>
          
          <center>
                <table border="2">
                  <colgroup>
                     <col span="1" style="width: 20%;">
                     <col span="1" style="width: 30%;">
                     <col span="1" style="width: 20%;">
                     <col span="1" style="width: 30%;">
                  </colgroup>
                  <tr>
                      <th colspan="4">Student Information</th>
                  </tr>
                  <tr>
                      <td>Student's Name : </td>
                      <td colspan="3"><%= rs.getString("studName")%></td>
                  </tr>
                  <tr>
                      <td>Student's IC : </td>
                      <td><%= rs.getString("studIC")%></td>
                      <td>Student's Birth Certificate : </td>
                      <td><%= rs.getString("studBirthCertificate")%></td>
                  </tr>
                  <tr>
                      <td>Student's Gender : </td>
                      <td><%= rs.getString("studGender")%></td>
                      <td>Student's Age : </td>
                      <td><%= rs.getString("studAge")%></td>
                  </tr>
                </table>
              </center>
              <br><br>
              
                <center>
                <table border="2">
                  <colgroup>
                     <col span="1" style="width: 15%;">
                     <col span="1" style="width: 35%;">
                     <col span="1" style="width: 15%;">
                     <col span="1" style="width: 35%;">
                  </colgroup>
                  <tr>
                      <th colspan="4">Parent's Information</th>
                  </tr>
                  <tr>
                    <td>Parent's Address : </td>
                    <td colspan="3"><%= rs.getString("parentAddress")%></td>
                  </tr>
                  <tr>
                      <td>Father's Name : </td>
                      <td colspan="3"><%= rs.getString("fatherName")%></td>
                  </tr>
                  <tr>
                      <td>Father's IC : </td>
                      <td><%= rs.getString("fatherIC")%></td>

                      <td>Fathers's Contact Number : </td>
                      <td><%=rs.getString("fatherContact")%></td>
                  </tr>
                  <tr>
                      <td>Father's Occupation : </td>
                      <td colspan="3"><%=rs.getString("fatherOccupation")%></td>
                  </tr>
                  <tr>
                      <td>Father's Occupation Address : </td>
                      <td colspan="3"><%=rs.getString("fatherOccupAddress")%></td>
                  </tr>
                  <tr>
                      <td>Mother's Name : </td>
                      <td colspan="3"><%=rs.getString("motherName")%></td>
                  </tr>
                  <tr>
                      <td>Mother's IC : </td>
                      <td><%=rs.getString("motherIC")%></td>
                      <td>Mother's Contact Number : </td>
                      <td><%=rs.getString("motherContact")%></td>
                  </tr>
                  <tr>
                      <td>Mother's Occupation : </td>
                      <td colspan="3"><%=rs.getString("motherOccupation")%></td>
                  </tr>
                  <tr>
                      <td>Mother's Occupation Address : </td>
                      <td colspan="3"><%=rs.getString("motherOccupAddress")%></td>
                  </tr>

                </table>
                  <%}
                    } catch (Exception e) {
                    e.printStackTrace();
                    }
               %>
                  <br><br>
                  <%
        
        
                    try
                    {
                      Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "tsp", "tsp");
                      PreparedStatement statement;
                      ResultSet rs;
                      statement = conn.prepareStatement("SELECT * FROM fees JOIN payment on payment.feesId=fees.feesId where fees.studId=?");
                      statement.setInt(1, studId);
                      rs = statement.executeQuery();
                      while(rs.next()) 
                      {
                  %>
                  <br><br>
                  <table border='2'>
                                <colgroup>
                                   <col span='1' style='width: 45%;'>
                                   <col span='1' style='width: 55%;'>
                                </colgroup>
                                <tr>
                                    <th colspan='2'>Fees Information</th>
                                </tr>
                                <tr>
                                    <td>Fees Type</th>
                                    <td><%=rs.getString("feesType")%></th>
                                </tr>
                                <tr>
                                    <td>Fees Amount</th>
                                    <td>RM<%=rs.getString("feesAmount")%></th>
                                </tr>
                                <tr>
                                    <td>Fees Status</th>
                                    <td><%=rs.getString("paymentStatus")%></th>
                                </tr>
                                <tr>
                                    <td>Due Date</th>
                                    <td><%=rs.getString("feesDueDate")%></th>
                                </tr>
                  </table>
                                 <%}
                    } catch (Exception e) {
                    e.printStackTrace();
                    }
               %>
               
      </center>
    </div>
      <br><br><br><br><br><br><br><br>
    <footer>
        <p class="w3-medium">Powered by UiTM</p>
    </footer>

  </body>

</html>
