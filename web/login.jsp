<%-- 
    Document   : login
    Created on : Jun 18, 2019, 3:50:26 PM
    Author     : Ahmad Mahyudi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/stylesheet.css">
<html>
    <style>table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}</style>
<title> Taska Sarjana Pintar</title>
  <body>
    <head>
        <div class="navbar">
            <h1 class="w3-center"><b><img src="css/logo.png" style="width:5%">Taska Sarjana Pintar</b></h1>
        <a href="index.jsp">Home</a>
        <a href="ourInfo.jsp">Our Info</a>
        <a href="register.jsp">Register</a>
        <a href="studentProfile.jsp">Student Profile</a>
        <a href="login.jsp">User</a>
      </div>
    </head>
        
        
      <br><br><br><br><br><br><br><br><br><br>
      
      <div class="w3-container w3-content w3-center w3-padding-64 w3-round w3-border w3-card-4 w3-light-grey" style="max-width:1500px">
          <form action="${pageContext.request.contextPath}/loginController" method="post" class="w3-center">
          <center>
            <table border="0">
              <colgroup>
                 <col span="1" style="width: 35%;">
                 <col span="1" style="width: 65%;">
              </colgroup>

              <tr>
                  <td>Enter IC number : </td>
                  <td><input class="w3-input w3-border" type="text" placeholder="User's IC" required name="teacherIC"></td>
              </tr>
              <tr>
                  <td>Password : </td>
                  <td><input class="w3-input w3-border" type="password"  placeholder="Password" required name="loginPassword"></td>
              </tr>
            </table>
            <button class="w3-button w3-black w3-section w3-card-4 w3-round" type="submit" name="submit">SUBMIT</button>
            <button class="w3-button w3-black w3-section w3-card-4 w3-round" type="reset" name="reset">RESET</button>
          </center>

        </form>


      </div>
    <footer>
        <p class="w3-medium">Powered by UiTM</p>
    </footer>

  </body>

</html>
