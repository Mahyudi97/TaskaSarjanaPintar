<%-- 
    Document   : logoutout
    Created on : Jul 10, 2019, 12:13:26 AM
    Author     : Ahmad Mahyudi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
         <%
     // for checking the session is available or not, if not available it will throw exception, "Session already invalidated."
      
        session.invalidate();
        response.sendRedirect("login.jsp");
      
     %>
    </body>
</html>
