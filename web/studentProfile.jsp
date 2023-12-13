<%-- 
    Document   : studentProfile
    Created on : Jul 1, 2019, 6:29:31 PM
    Author     : Ahmad Mahyudi
--%>



<!DOCTYPE html>
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/stylesheet.css">
<html>
<title> Taska Sarjana Pintar</title>
  <body>
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

      <br><br><br><br><br><br><br><br><br><br>
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
        <table border="2">
          <colgroup>
             <col span="1" style="width: 20%;">
             <col span="1" style="width: 30%;">
             <col span="1" style="width: 20%;">
             <col span="1" style="width: 30%;">
          </colgroup>

        </table>
      </center>
    </div>
          <br><br><br><br><br><br><br><br>
    <footer>
        <p class="w3-medium">Powered by UiTM</p>
    </footer>

  </body>

</html>
