<%-- 
    Document   : updateStatus
    Created on : Jul 10, 2019, 5:58:05 PM
    Author     : Ahmad Mahyudi
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="domain.Payment"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                <%
                   Integer loginId = (Integer)session.getAttribute("loginId");
                   if (loginId == null)
                   {
                       response.sendRedirect("login.jsp");
                   }
                   int feesId = Integer.parseInt(request.getParameter("feesId"));
                   Payment P=null;
                    try {
                            try {
                                Class.forName("oracle.jdbc.OracleDriver");
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }

                            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "tsp", "tsp"); //attempting to connect to MySQL database
                            PreparedStatement statement;
                            ResultSet rs;
                            statement = conn.prepareStatement("update payment set paymentStatus='Paid' where feesId=?");
                            statement.setInt(1, feesId);
                            rs = statement.executeQuery();
                            
                            statement = conn.prepareStatement("SELECT * from payment where feesId=?");
                            statement.setInt(1, feesId);
                            rs = statement.executeQuery();
                            while(rs.next()) 
                            {
                                P=new Payment(rs.getInt("paymentId"),rs.getString("dateofpayment"),rs.getString("paymentStatus"));
                            }
                            
                            
                            statement = conn.prepareStatement("insert into receipt(receiptdate,paymentid) values(sysdate,?)");
                            statement.setInt(1, P.getPaymentId());
                            rs = statement.executeQuery();
                            
                    }catch (Exception e) {
                    e.printStackTrace();
                    }%>
                    
                    <%
                    if(loginId>8)
                    {
                        out.println("Successful!");
                        response.sendRedirect("fees.jsp");
                    }
                    else 
                    {
                        out.println("Successful!");
                        response.sendRedirect("feesAdmin.jsp");
                    }
                    %>
    </body>
</html>
