<%-- 
    Document   : register2Admin
    Created on : Jul 3, 2019, 2:38:33 PM
    Author     : Ahmad Mahyudi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" href="css/w3.css">
<link rel="stylesheet" href="css/stylesheet.css">
<title> Taska Sarjana Pintar</title>
<html>
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
      <h1 class="w3-center"><h2><b> Register </b></h2></h1>
      <br>
      <form action="${pageContext.request.contextPath}/registerController" method="post" class="w3-center" >
                <center>
                    <%= loginId%>
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
                      <td colspan="3"><input class="w3-input w3-border"  type="text" name="studName" required></td>
                      <input class="w3-input w3-border"  type="hidden" name="loginId" value="<%= loginId%>"required>
                  </tr>
                  <tr>
                      <td>Student's IC : </td>
                      <td><input class="w3-input w3-border"  type="text" name="studIC" required></td>
                      <td>Student's Birth Certificate : </td>
                      <td><input class="w3-input w3-border" type="text" name="studBirthCertificate" required></td>
                  </tr>
                  <tr>
                      <td>Student's Gender : </td>
                      <td><select class="w3-input w3-border"  name="studGender" required>
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                          </select></td>
                      <td>Student's Age : </td>
                      <td><input class="w3-input w3-border"  type="number" name="studAge" required></td>
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
                    <td colspan="3"><input class="w3-input w3-border"  type="text" name="parentAddress" required></td>
                  </tr>
                  <tr>
                      <td>Father's Name : </td>
                      <td colspan="3"><input class="w3-input w3-border"  type="text" name="fatherName" required></td>
                  </tr>
                  <tr>
                      <td>Father's IC : </td>
                      <td><input class="w3-input w3-border"  type="text" name="fatherIC" required></td>

                      <td>Fathers's Contact Number : </td>
                      <td><input class="w3-input w3-border"  type="text" name="fatherContactNum" required></td>
                  </tr>
                  <tr>
                      <td>Father's Occupation : </td>
                      <td colspan="3"><input class="w3-input w3-border" type="text" name="fatherOccupation" required></td>
                  </tr>
                  <tr>
                      <td>Father's Occupation Address : </td>
                      <td colspan="3"><input class="w3-input w3-border" type="text" name="fatherOccupAddress" required></td>
                  </tr>
                  <tr>
                      <td>Mother's Name : </td>
                      <td colspan="3"><input class="w3-input w3-border" type="text" name="motherName" required></td>
                  </tr>
                  <tr>
                      <td>Mother's IC : </td>
                      <td><input class="w3-input w3-border" type="text" name="motherIC" required></td>
                      <td>Mother's Contact Number : </td>
                      <td><input class="w3-input w3-border" type="text" name="motherContactNum" required></td>
                  </tr>
                  <tr>
                      <td>Mother's Occupation : </td>
                      <td colspan="3"><input class="w3-input w3-border" type="text" name="motherOccupation" required></td>
                  </tr>
                  <tr>
                      <td>Mother's Occupation Address : </td>
                      <td colspan="3"><input class="w3-input w3-border" type="text" name="motherOccupAddress" required></td>
                  </tr>

                </table>


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
/* When the user clicks on the button,
toggle between hiding and showing the dropdown content */
function myFunction() {
  document.getElementById("myDropdown").classList.toggle("show");
}

// Close the dropdown if the user clicks outside of it
window.onclick = function(e) {
  if (!e.target.matches('.dropbtn')) {
  var myDropdown = document.getElementById("myDropdown");
    if (myDropdown.classList.contains('show')) {
      myDropdown.classList.remove('show');
    }
  }
}



</script>

