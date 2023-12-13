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
<html>
<title> Taska Sarjana Pintar</title>
<script language="javascript">
function update(id){
    var f=document.form;
    f.method="post";
    f.action='updateStatus.jsp?feesId='+id;
    f.submit();
}

function receipt(id){
    var f=document.form;
    f.method="post";
    f.action='receipt.jsp?feesId='+id;
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
      <h1 class="w3-center"><h2><b> Fees </b></h2></h1>
      <br>
      <%=studId%>
      <form method="post" name="form">
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
                            statement = conn.prepareStatement("SELECT * FROM student where studid=?");
                            statement.setInt(1, studId);
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
                      <td colspan="3"><%= rs.getString("studName")%></td>
                      <input class="w3-input w3-border"  type="hidden" name="loginId" value="<%= loginId%>"required>
                  </tr>
                  <tr>
                      <td>Student's IC : </td>
                      <td><%= rs.getString("studIC")%></td>
                      <input class="w3-input w3-border"  type="hidden" name="studIC" value="<%= rs.getString("studIC")%>">
                      <td>Student's Birth Certificate : </td>
                      <td><%= rs.getString("studBirthCertificate")%></td>
                  </tr>
                  <tr>
                      <td>Student's Gender : </td>
                      <td><%= rs.getString("studGender")%></td>
                      <td>Student's Age : </td>
                      <td><%= rs.getInt("studAge")%></td>
                  </tr>
                </table>
              </center>
                  <br>
                   <%       }
                            }
                            statement = conn.prepareStatement("SELECT * FROM fees JOIN payment on payment.feesid=fees.feesid where studid=?");
                            statement.setInt(1, studId);
                            rs = statement.executeQuery();
                            while(rs.next()) 
                            {
                                if(studId==rs.getInt("studId"))
                                {
                        
                       %>
                        <table border='2'>
                                <colgroup>
                                   <col span='1' style='width: 45%;'>
                                   <col span='1' style='width: 55%;'>
                                </colgroup>
                                <tr>
                                    <th colspan='2'>Fees Information</th>
                                </tr>
                                <tr>
                                    <td>Fees Type</td>
                                    <td><%=rs.getString("feesType")%></td>
                                    <%=rs.getString("feesId")%>
                                </tr>
                                <tr>
                                    <td>Fees Amount</td>
                                    <td>RM<%=rs.getString("feesAmount")%></td>
                                </tr>
                                <tr>
                                    <td>Fees Status</td>
                                   <td> <% if(rs.getString("paymentStatus").equals("Paid"))
                                        { %>
                                            <%=rs.getString("paymentStatus")%>
                                            <input type="button" name="Receipt" value="Receipt" style="background-color:gray;font-weight:bold;color:white;" onclick="receipt(<%=rs.getInt("feesId")%>);" >
                                      <% }
                                        else { %>
                                    <input type="button" name="view" value='<%=rs.getString("paymentStatus")%>' style="background-color:green;font-weight:bold;color:white;" onclick="update(<%=rs.getInt("feesId")%>);" ><%}%></td>
                                </tr>
                                <tr>
                                    <td>Due Date</th>
                                    <td><%=rs.getString("feesDueDate")%></td>
                                </tr>
                  </table>
              <br><br>
                <center>
                    <%      }
                            }
                    } catch (Exception e) {
                    e.printStackTrace();
                    }
                    %>


                
      </form>

        </center>
    </div>
            <br><br><br><br><br><br><br><br><br><br>
        <footer>
            <p class="w3-medium">Powered by UiTM</p>
        </footer>

  </body>

</html>