<%-- 
    Document   : fees
    Created on : Jul 2, 2019, 4:08:12 PM
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
function updatePayment(id){
    var f=document.form;
    f.method="post";
    f.action='feesViewAdmin.jsp?studId='+id;
    f.submit();
}
</script>
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
      <br><br><br><br><br><br><br><br><br><br>
      <%
        Integer loginId = (Integer)session.getAttribute("loginId");
	if (loginId == null)
        {
            response.sendRedirect("login.jsp");
        }
        request.getSession().setAttribute("loginId",loginId);
        %>
      <div class="w3-container w3-content w3-center w3-padding-64 w3-round w3-border w3-card-4 w3-light-grey" style="max-width:1500px">
        <h1 class="w3-center"><h2><b> Fees Check </b></h2></h1>
        <form method="post" name="form">
            <%= loginId%>
          <center>
                <table border="2">
                  <colgroup>
                     <col span="1" style="width: 10%;">
                     <col span="1" style="width: 40%;">
                     <col span="1" style="width: 30%;">
                     <col span="1" style="width: 20%;">
                  </colgroup>
                  <tr>
                      <th>No.</th>
                      <th>Name</th>
                      <th>IC </th>
                      <th>View</th>
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
                            statement = conn.prepareStatement("SELECT * FROM student");
                            //statement.setInt(1, studId);
                            rs = statement.executeQuery();
                            while(rs.next()) 
                            {
                        
                       %>
                  <tr>
                      <td><%= no%></td>
                      <td><%= rs.getString("studName")%></td>
                      <td><%= rs.getString("studIC")%></td>
                      <td style="text-align: center"><input type="button" name="view" value="View" style="background-color:green;font-weight:bold;color:white;" onclick="updatePayment(<%=rs.getString("studId")%>);" ></td>
                  </tr>
                  <%    no++;}
                    } catch (Exception e) {
                    e.printStackTrace();
                    }
                    %>
                </table>
              </center>
        </form>
    </div>
      
    
<br><br><br><br><br><br><br><br>
  </body>
<footer>
        <p class="w3-medium">Powered by UiTM</p>
</footer>
</html>

