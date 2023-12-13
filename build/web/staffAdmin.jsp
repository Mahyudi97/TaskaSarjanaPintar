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
<script language="javascript">
function editRecord(id){
    var f=document.form;
    f.method="post";
    f.action='editTeacherAdmin.jsp?teacherId='+id;
    f.submit();
}
</script>
    <head>
        <div class="navbar">
            <h1 class="w3-center"><b><img src="css/logo.png" style="width:5%">Taska Sarjana Pintar</b></h1>
            <a href="homeAdmin.jsp">Student's List</a>
                    <a href="register2Admin.jsp">Register</a>
                    <a href="feesAdmin.jsp">Fees</a>
                    <a href="staffAdmin.jsp">Staff</a>
                    <a href="logoutAdmin.jsp">Logout</a>
          </div>
    </head>
  <body>
      <br><br><br><br><br><br><br><br><br><br>
      <%
        Integer loginId = (Integer)session.getAttribute("loginId");
	if (loginId == null)
        {
            response.sendRedirect("login.jsp");
        }
        %>
      <div class="w3-container w3-content w3-center w3-padding-64 w3-round w3-border w3-card-4 w3-light-grey" style="max-width:1500px">
        <h1 class="w3-center"><h2><b> Teachers </b></h2></h1>
        <form method="post" name="form">
            <%= loginId%>
          <center>
                <table border="2">
                  <colgroup>
                     <col span="1" style="width: 5%;">
                     <col span="1" style="width: 35%;">
                     <col span="1" style="width: 25%;">
                     <col span="1" style="width: 20%;">
                     <col span="1" style="width: 15%;">
                  </colgroup>
                  <tr>
                      <th>No.</th>
                      <th>Name</th>
                      <th>IC </th>
                      <th>Class</th>
                      <th>Edit</th>
                  </tr>
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
                            int no=1;
                            statement = conn.prepareStatement("SELECT * FROM teacher JOIN class on class.teacherID=teacher.teacherid ");
                            //statement.setInt(1, studId);
                            rs = statement.executeQuery();
                            while(rs.next()) 
                            {
                        
                       %>
                        <tr>
                            <td><%= no%></td>
                            <td><%= rs.getString("teacherName")%></td>
                            <td><%= rs.getString("teacherIC")%></td>
                            <td><%= rs.getString("className")%></td>
                            <td style="text-align: center"><input type="button" name="edit" value="Edit" style="background-color:green;font-weight:bold;color:white;" onclick="editRecord(<%=rs.getString("teacherId")%>);" ></td>
                        </tr>
                        <%   no++; }
                    } catch (Exception e) {
                    e.printStackTrace();
                    }
                    %>
                </table>
                </form>
                <form action="addTeacherAdmin.jsp" method="post" class="w3-center">
                     <button class="w3-button w3-section w3-card-4 w3-round w3-right" type="submit" name="add">Add</button>
                </form>
        
              </center>
        
    </div>
      
    
<br><br><br><br><br><br><br><br>
  </body>
<footer>
        <p class="w3-medium">Powered by UiTM</p>
</footer>
</html>
