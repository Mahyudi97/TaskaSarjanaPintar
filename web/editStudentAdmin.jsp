<%-- 
    Document   : editStudent
    Created on : Jul 4, 2019, 2:21:58 PM
    Author     : Ahmad Mahyudi
--%>
<%@page language="java"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/stylesheet.css">
<title> Taska Sarjana Pintar</title>
<html>
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
        <%
            Integer loginId = (Integer)session.getAttribute("loginId");
            if (loginId == null)
            {
                response.sendRedirect("login.jsp");
            }
            int studId = Integer.parseInt(request.getParameter("studId"));
        %>
    <br><br><br><br><br><br><br><br><br><br>
    <div class="w3-container w3-content w3-center w3-padding-64 w3-round w3-border w3-card-4 w3-light-grey" style="max-width:1500px">
      <h1 class="w3-center"><h2><b> Register </b></h2></h1>
      <br>
      <%=studId%>
      <form action="${pageContext.request.contextPath}/editStudentController" method="post" class="w3-center" >
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
                            statement = conn.prepareStatement("SELECT * FROM student JOIN parent on parent.parentID=student.parentID");
                            //statement.setInt(1, studId);
                            rs = statement.executeQuery();
                            while(rs.next()) 
                            {
                                if(studId==rs.getInt("studId"))
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
                      <th colspan="4">Student Information</th>
                  </tr>
                  <tr>
                      <td>Student's Name : </td>
                      <td colspan="3"><input class="w3-input w3-border"  type="text" name="studName" value="<%= rs.getString("studName")%>"required></td>
                      <input class="w3-input w3-border"  type="hidden" name="loginId" value="<%= loginId%>"required>
                  </tr>
                  <tr>
                      <td>Student's IC : </td>
                      <td><%= rs.getString("studIC")%></td>
                      <input class="w3-input w3-border"  type="hidden" name="studIC" value="<%= rs.getString("studIC")%>">
                      <td>Student's Birth Certificate : </td>
                      <td><input class="w3-input w3-border" type="text" name="studBirthCertificate" value="<%= rs.getString("studBirthCertificate")%>"required></td>
                  </tr>
                  <tr>
                      <td>Student's Gender : </td>
                      <td><select class="w3-input w3-border"  name="studGender" required>
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                          </select></td>
                      <td>Student's Age : </td>
                      <td><input class="w3-input w3-border"  type="number" name="studAge" value="<%= rs.getInt("studAge")%>"required></td>
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
                    <td colspan="3"><input class="w3-input w3-border"  type="text" name="parentAddress" value="<%= rs.getString("parentAddress")%>"required></td>
                  </tr>
                  <tr>
                      <td>Father's Name : </td>
                      <td colspan="3"><input class="w3-input w3-border"  type="text" name="fatherName" value="<%= rs.getString("fatherName")%>"required></td>
                  </tr>
                  <tr>
                      <td>Father's IC : </td>
                      <td><%= rs.getString("fatherIC")%></td>
                      <input class="w3-input w3-border"  type="hidden" name="fatherIC" value="<%= rs.getString("fatherIC")%>"required>

                      <td>Fathers's Contact Number : </td>
                      <td><input class="w3-input w3-border"  type="text" name="fatherContactNum" value="<%= rs.getString("fatherContact")%>"required></td>
                  </tr>
                  <tr>
                      <td>Father's Occupation : </td>
                      <td colspan="3"><input class="w3-input w3-border" type="text" name="fatherOccupation" value="<%= rs.getString("fatherOccupation")%>"required></td>
                  </tr>
                  <tr>
                      <td>Father's Occupation Address : </td>
                      <td colspan="3"><input class="w3-input w3-border" type="text" name="fatherOccupAddress" value="<%= rs.getString("fatherOccupAddress")%>"required></td>
                  </tr>
                  <tr>
                      <td>Mother's Name : </td>
                      <td colspan="3"><input class="w3-input w3-border" type="text" name="motherName" value="<%= rs.getString("motherName")%>"required></td>
                  </tr>
                  <tr>
                      <td>Mother's IC : </td>
                      <td><%= rs.getString("motherIC")%></td>
                      <input class="w3-input w3-border"  type="hidden" name="motherIC" value="<%= rs.getString("motherIC")%>"required>
                      <td>Mother's Contact Number : </td>
                      <td><input class="w3-input w3-border" type="text" name="motherContactNum"  value="<%= rs.getString("motherContact")%>"required></td>
                  </tr>
                  <tr>
                      <td>Mother's Occupation : </td>
                      <td colspan="3"><input class="w3-input w3-border" type="text" name="motherOccupation"  value="<%= rs.getString("motherOccupation")%>"required></td>
                  </tr>
                  <tr>
                      <td>Mother's Occupation Address : </td>
                      <td colspan="3"><input class="w3-input w3-border" type="text" name="motherOccupAddress"  value="<%= rs.getString("motherOccupAddress")%>"required></td>
                  </tr>

                </table>
                    <%    }
                            }
                    } catch (Exception e) {
                    e.printStackTrace();
                    }
                    %>


                <button class="w3-button w3-section w3-card-4 w3-round w3-right" type="submit" name="submit">SUBMIT</button>
      </form>

        </center>
    </div>
            <br><br><br><br><br><br><br><br><br><br>
        <footer>
            <p class="w3-medium">Powered by UiTM</p>
        </footer>

  </body>

</html>