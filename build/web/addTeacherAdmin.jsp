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
        %>
   <br><br><br><br><br><br><br><br><br><br>
    <div class="w3-container w3-content w3-center w3-padding-64 w3-round w3-border w3-card-4 w3-light-grey" style="max-width:1500px">
      <h1 class="w3-center"><h2><b> Add Teacher </b></h2></h1>
      <br>
      <%=loginId%>
      <form action="${pageContext.request.contextPath}/addTeacherController" method="post" class="w3-center" >
                <center>
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
                      <td colspan="3"><input class="w3-input w3-border"  type="text" name="teacherName" required></td>
                      
                  </tr>
                  <tr>
                      <td>Teacher's IC : </td>
                      <td><input class="w3-input w3-border"  type="text" name="teacherIC" required></td>
                      <td>Teacher's Contact : </td>
                      <td><input class="w3-input w3-border" type="text" name="teacherContact" required></td>
                  </tr>
                  <tr>
                      <td>Teacher's Position </td>
                      <td><select class="w3-input w3-border"  name="teacherPosition" required>
                            <option value="Admin">Admin</option>
                            <option value="Staff">Staff</option>
                          </select></td>
                      <td>Teacher's Class : </td>
                      <td><select class="w3-input w3-border"  name="className" required>
                            <option value="Bestari">Bestari</option>
                            <option value="Cemerlang">Cemerlang</option>
                            <option value="Setia">Setia</option>
                            <option value="Handal">Handal</option>
                          </select></td>
                  </tr>
                  <tr>
                      <td>Password : </td>
                      <td><input class="w3-input w3-border" type="password" name="loginPassword" required onchange='check_pass();'></td>
                      <td>Confirm Password : </td>
                      <td><input class="w3-input w3-border" type="password" name="confirmPassword" required onchange='check_pass();'></td>
                  </tr>
                </table>
                    <span id='message'></span>
              </center>
              <br><br>
                <center>
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
<script>
    function check_pass() {
    if (document.getElementById('loginPassword').value == document.getElementById('confirmPassword').value) {
        document.getElementById('submit').disabled = false;
    } else {
        document.getElementById('submit').disabled = true;
    }
}
</script>