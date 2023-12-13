<%-- 
    Document   : feesAdmin
    Created on : Jul 3, 2019, 2:40:23 PM
    Author     : Ahmad Mahyudi
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/stylesheet.css">
<html>
<title> Taska Sarjana Pintar</title>
<head>
    <div class="navbar">  
                <h1 class="w3-center"><b><img src="css/logo.png" style="width:5%">Taska Sarjana Pintar</b></h1>
              <a href="homeStaff.jsp">Student's List</a>
              <a href="register2.jsp">Register</a>
              <a href="fees.jsp">Fees</a>
              <a href="logout.jsp">Logout</a>
            </div>
    </head>
    
  <body>
    <%
        Integer loginId = (Integer)session.getAttribute("loginId");
	if (loginId == null)
        {
            response.sendRedirect("login.jsp");
        }
        
    %>
    <br><br><br><br><br><br><br><br><br><br>
    <div class="w3-container w3-content w3-center w3-padding-64 w3-round w3-border w3-card-4 w3-light-grey" style="max-width:1500px">
            <h1 class="w3-center"><h2><b> Log out? </b></h2></h1>
                  <center>
                      <%
                    try {
                            try {
                                Class.forName("oracle.jdbc.OracleDriver");
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }

                            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "tsp", "tsp"); //attempting to connect to MySQL database
                            PreparedStatement statement;
                            ResultSet rs;
                            statement = conn.prepareStatement("SELECT * FROM teacher JOIN class on class.teacherID=teacher.teacherid where teacher.teacherId=?");
                            statement.setInt(1, loginId);
                            rs = statement.executeQuery();
                            while(rs.next()) 
                            {
                        
                       %>
                <table border="2">
                  <colgroup>
                     <col span="1" style="width: 20%;">
                     <col span="1" style="width: 30%;">
                     <col span="1" style="width: 20%;">
                     <col span="1" style="width: 30%;">
                  </colgroup>
                  <tr>
                      <th colspan="4">Teacher Information</th>
                  </tr>
                  <tr>
                      <td>Teacher's Name : </td>
                      <td colspan="3"><%= rs.getString("teacherName")%></td>
                      
                  </tr>
                  <tr>
                      <td>Teacher's IC : </td>
                      <td><%= rs.getString("teacherIC")%></td>
                      <td>Teacher's Contact : </td>
                      <td><%= rs.getString("teacherContact")%></td>
                  </tr>
                  <tr>
                      <td>Teacher's Position </td>
                      <td><%= rs.getString("teacherPosition")%></td>
                      <td>Teacher's Class : </td>
                      <td><%= rs.getString("className")%></td>
                  </tr>
                </table>
                <%      }
                                
                        } catch (Exception e) {
                        e.printStackTrace();
                        }
                        %>
                        <a href="logoutout.jsp" class="btn btn-sm btn-default"><span class="glyphicon glyphicon-log-out"></span> Logout</a>

              </center>
    </div>

    <footer>
        <p class="w3-medium">Powered by UiTM</p>
    </footer>

  </body>

</html>

