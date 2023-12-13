<%-- 
    Document   : receipt
    Created on : Jul 10, 2019, 11:01:00 PM
    Author     : Ahmad Mahyudi
--%>

<%@page import="domain.Receipt"%>
<%@page import="domain.Teacher"%>
<%@page import="domain.Student"%>
<%@page import="domain.Payment"%>
<%@page import="domain.Fees"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <style>
    .invoice-box {
        max-width: 800px;
        margin: auto;
        padding: 30px;
        border: 1px solid #eee;
        box-shadow: 0 0 10px rgba(0, 0, 0, .15);
        font-size: 16px;
        line-height: 24px;
        font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;
        color: #555;
    }
    
    .invoice-box table {
        width: 100%;
        line-height: inherit;
        text-align: left;
    }
    
    .invoice-box table td {
        padding: 5px;
        vertical-align: top;
    }
    
    .invoice-box table tr td:nth-child(2) {
        text-align: right;
    }
    
    .invoice-box table tr.top table td {
        padding-bottom: 20px;
    }
    
    .invoice-box table tr.top table td.title {
        font-size: 45px;
        line-height: 45px;
        color: #333;
    }
    
    .invoice-box table tr.information table td {
        padding-bottom: 40px;
    }
    
    .invoice-box table tr.heading td {
        background: #eee;
        border-bottom: 1px solid #ddd;
        font-weight: bold;
    }
    
    .invoice-box table tr.details td {
        padding-bottom: 20px;
    }
    
    .invoice-box table tr.item td{
        border-bottom: 1px solid #eee;
    }
    
    .invoice-box table tr.item.last td {
        border-bottom: none;
    }
    
    .invoice-box table tr.total td:nth-child(2) {
        border-top: 2px solid #eee;
        font-weight: bold;
    }
    
    @media only screen and (max-width: 600px) {
        .invoice-box table tr.top table td {
            width: 100%;
            display: block;
            text-align: center;
        }
        
        .invoice-box table tr.information table td {
            width: 100%;
            display: block;
            text-align: center;
        }
    }
    
    /** RTL **/
    .rtl {
        direction: rtl;
        font-family: Tahoma, 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;
    }
    
    .rtl table {
        text-align: right;
    }
    
    .rtl table tr td:nth-child(2) {
        text-align: left;
    }
    </style>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Receipt</title>
    </head>
    <body>
        <%
                   Integer loginId = (Integer)session.getAttribute("loginId");
                   if (loginId == null)
                   {
                       response.sendRedirect("login.jsp");
                   }
                   int feesId = Integer.parseInt(request.getParameter("feesId"));
                   Fees F = null;
                   Payment P = null;
                   Student S = null;
                   Teacher T = null;
                   Receipt R = null; 
                    try {
                            try {
                                Class.forName("oracle.jdbc.OracleDriver");
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }

                            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "tsp", "tsp"); //attempting to connect to MySQL database
                            PreparedStatement statement;
                            ResultSet rs;
                            
                            //Teacher Information
                            statement = conn.prepareStatement("select * from teacher  where teacherid=?");
                            statement.setInt(1, loginId);
                            rs = statement.executeQuery();
                            while(rs.next()) 
                            {
                                T=new Teacher(rs.getInt("teacherId"),rs.getString("teacherName"),rs.getString("teacherIC"),rs.getString("teacherPosition"),rs.getString("teacherContact"));
                            }
                            //Fees/Payment/Student Information
                            statement = conn.prepareStatement("select * from fees join payment on payment.feesid=fees.feesid join student on student.studid=fees.studid where fees.feesid=?");
                            statement.setInt(1, feesId);
                            rs = statement.executeQuery();
                            while(rs.next()) 
                            {
                                F=new Fees(rs.getInt("feesId"),rs.getDouble("feesAmount"),rs.getString("feesDueDate"),rs.getString("feesType"));
                                P=new Payment(rs.getInt("paymentId"),rs.getString("dateofpayment"),rs.getString("paymentStatus"));
                                S=new Student(rs.getInt("studid"),rs.getString("studName"),rs.getString("studIC"),rs.getInt("studAge"),rs.getString("studGender"),rs.getString("studBirthCertificate"));
                            }
                            //Receipt Information
                            statement = conn.prepareStatement("select * from receipt join payment on payment.paymentId=receipt.paymentId where payment.paymentid=?");
                            statement.setInt(1, P.getPaymentId());
                            rs = statement.executeQuery();
                            while(rs.next()) 
                            {
                                R=new Receipt(rs.getInt("receiptId"),rs.getString("receiptdate"));
                            }
                            %>
                            
                            
                            
        <div class="invoice-box">
        <table cellpadding="0" cellspacing="0">
            <tr class="top">
                <td colspan="2">
                    <table>
                        <tr>
                            <td class="title">
                                <img src="css/TSPlogo.PNG" style="width:100%; max-width:300px;">
                            </td>
                            
                            <td>
                                Invoice #: <%=R.getReciptId()%><br>
                                Created: <%= P.getDateOfPayment()%><br>
                                Due: <%= F.getFeesDueDate()%>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            
            <tr class="information">
                <td colspan="2">
                    <table>
                        <tr>
                            <td>
                                Taska Sarjana Pintar<br>
                                No. 1 & 3, Jalan Ferum 3, 7/31 C, Seksyen 7,<br>
                                Selangor, 40000 Shah Alam
                            </td>
                            
                            <td>
                                <%= T.getTeacherPosition()%><br>
                                <%= T.getTeacherName()%><br>
                                <%= T.getTeacherContact()%>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            
            
            <tr class="heading">
                <td>
                    Student Info
                </td>
                
                <td>
                    <br>
                </td>
            </tr>
            
            <tr class="item">
                <td>
                    Name : <%= S.getStudName()%> <br>
                    IC : <%= S.getStudIC()%>
                </td>
                
                <td>
                    <br>
                </td>
            </tr>
            <tr class="heading">
                <td>
                    Info.
                </td>
                
                <td>
                    Total
                </td>
            </tr>
            
            <tr class="item">
                <td>
                    <%= F.getFeesType()%> Payment
                </td>
                
                <td>
                    RM<%= F.getFeesAmount()%>
                </td>
            </tr>
            
            <tr class="item">
                <td>
                    <br>
                </td>
                
                <td>
                    <br>
                </td>
            </tr>
            
            <tr class="item last">
                <td>
                    <br>
                </td>
                
                <td>
                    <br>
                </td>
            </tr>
            
            <tr class="total">
                <td></td>
                
                <td>
                   Total: RM<%= F.getFeesAmount()%>
                </td>
            </tr>
        </table>
    </div>
                            <%    
                            
                            
                    }catch (Exception e) {
                    e.printStackTrace();
                    }%>
    </body>
</html>
