package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import domain.Student;
import domain.Parent;
import db.dbconnect;
import java.util.*;;
import java.sql.*;
import java.util.Random;

public final class homeAdmin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<link rel=\"stylesheet\" href=\"css/w3.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"css/stylesheet.css\">\n");
      out.write("<html> \n");
      out.write("<title> Taska Sarjana Pintar</title>\n");
      out.write("    <head>\n");
      out.write("        <div class=\"navbar\">\n");
      out.write("            <h1 class=\"w3-center\"><b>Taska Sarjana Pintar</h1></b>\n");
      out.write("            <a href=\"homeAdmin.jsp\">Student's List</a>\n");
      out.write("                    <a href=\"register2Admin.jsp\">Register</a>\n");
      out.write("                    <a href=\"feesAdmin.jsp\">Fees</a>\n");
      out.write("                    <a href=\"staffAdmin.jsp\">Staff</a>\n");
      out.write("                    <a href=\"logoutAdmin.jsp\">Logout</a>\n");
      out.write("          </div>\n");
      out.write("    </head>\n");
      out.write("  <body>\n");
      out.write("      <br><br><br><br><br><br><br><br>\n");
      out.write("      ");

        Integer teacherId = (Integer)session.getAttribute("teacherId");
	if (teacherId == null)
        {
            response.sendRedirect("login.jsp");
        }
        
      out.write("\n");
      out.write("      <div class=\"w3-container w3-content w3-center w3-padding-64 w3-round w3-border w3-card-4 w3-light-grey\" style=\"max-width:1500px\">\n");
      out.write("        <h1 class=\"w3-center\"><h2><b> Student List </b></h2></h1>\n");
      out.write("          <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/editStudentController\" method=\"post\" class=\"w3-center\">\n");
      out.write("          <center>\n");
      out.write("                <table border=\"2\">\n");
      out.write("                  <colgroup>\n");
      out.write("                     <col span=\"1\" style=\"width: 10%;\">\n");
      out.write("                     <col span=\"1\" style=\"width: 40%;\">\n");
      out.write("                     <col span=\"1\" style=\"width: 30%;\">\n");
      out.write("                     <col span=\"1\" style=\"width: 20%;\">\n");
      out.write("                  </colgroup>\n");
      out.write("                  <tr>\n");
      out.write("                      <td>No.</td>\n");
      out.write("                      <td>Name</td>\n");
      out.write("                      <td>IC </td>\n");
      out.write("                      <td>Edit</td>\n");
      out.write("                  </tr>\n");
      out.write("                  ");

                  
                    try
                    {
                      Class.forName("com.mysql.jdbc.Driver").newInstance();
                      Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "tsp", "tsp");
                      PreparedStatement statement;
                      ResultSet rs;
                      int num=0;
                      statement = conn.prepareStatement("select * from Teacher ORDER BY teacherName ASC");
                      rs = statement.executeQuery();
                    
      out.write("\n");
      out.write("                      ");

                        while (rs.next()) 
                        {
                       
      out.write("\n");
      out.write("                  <tr>\n");
      out.write("                      <td>");
      out.print( num+1);
      out.write("</td>\n");
      out.write("                      <td>");
      out.print( rs.getString("studName"));
      out.write("</td>\n");
      out.write("                      <td>");
      out.print( rs.getString("studIC"));
      out.write("</td>\n");
      out.write("                      <td><input type=\"button\" name=\"edit\" value=\"Edit\" style=\"background-color:green;font-weight:bold;color:white;\" onclick=\"editRecord(");
      out.print(rs.getString("studId"));
      out.write(");\" ></td>\n");
      out.write("                  </tr>\n");
      out.write("                  ");
    }
                        conn.close();
                    } catch (Exception e) {
                    e.printStackTrace();
                    }
                    
      out.write("\n");
      out.write("                </table>\n");
      out.write("              </center>\n");
      out.write("       </form>\n");
      out.write("    </div>\n");
      out.write("      \n");
      out.write("    \n");
      out.write("<br><br><br><br><br><br><br><br>\n");
      out.write("  </body>\n");
      out.write("<footer>\n");
      out.write("        <p class=\"w3-medium\">Powered by UiTM</p>\n");
      out.write("</footer>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
