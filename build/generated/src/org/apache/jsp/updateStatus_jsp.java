package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.Connection;

public final class updateStatus_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <style>\n");
      out.write("    .invoice-box {\n");
      out.write("        max-width: 800px;\n");
      out.write("        margin: auto;\n");
      out.write("        padding: 30px;\n");
      out.write("        border: 1px solid #eee;\n");
      out.write("        box-shadow: 0 0 10px rgba(0, 0, 0, .15);\n");
      out.write("        font-size: 16px;\n");
      out.write("        line-height: 24px;\n");
      out.write("        font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;\n");
      out.write("        color: #555;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    .invoice-box table {\n");
      out.write("        width: 100%;\n");
      out.write("        line-height: inherit;\n");
      out.write("        text-align: left;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    .invoice-box table td {\n");
      out.write("        padding: 5px;\n");
      out.write("        vertical-align: top;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    .invoice-box table tr td:nth-child(2) {\n");
      out.write("        text-align: right;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    .invoice-box table tr.top table td {\n");
      out.write("        padding-bottom: 20px;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    .invoice-box table tr.top table td.title {\n");
      out.write("        font-size: 45px;\n");
      out.write("        line-height: 45px;\n");
      out.write("        color: #333;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    .invoice-box table tr.information table td {\n");
      out.write("        padding-bottom: 40px;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    .invoice-box table tr.heading td {\n");
      out.write("        background: #eee;\n");
      out.write("        border-bottom: 1px solid #ddd;\n");
      out.write("        font-weight: bold;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    .invoice-box table tr.details td {\n");
      out.write("        padding-bottom: 20px;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    .invoice-box table tr.item td{\n");
      out.write("        border-bottom: 1px solid #eee;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    .invoice-box table tr.item.last td {\n");
      out.write("        border-bottom: none;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    .invoice-box table tr.total td:nth-child(2) {\n");
      out.write("        border-top: 2px solid #eee;\n");
      out.write("        font-weight: bold;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    @media only screen and (max-width: 600px) {\n");
      out.write("        .invoice-box table tr.top table td {\n");
      out.write("            width: 100%;\n");
      out.write("            display: block;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("        \n");
      out.write("        .invoice-box table tr.information table td {\n");
      out.write("            width: 100%;\n");
      out.write("            display: block;\n");
      out.write("            text-align: center;\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    /** RTL **/\n");
      out.write("    .rtl {\n");
      out.write("        direction: rtl;\n");
      out.write("        font-family: Tahoma, 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    .rtl table {\n");
      out.write("        text-align: right;\n");
      out.write("    }\n");
      out.write("    \n");
      out.write("    .rtl table tr td:nth-child(2) {\n");
      out.write("        text-align: left;\n");
      out.write("    }\n");
      out.write("    </style>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("                ");

                   Integer loginId = (Integer)session.getAttribute("loginId");
                   if (loginId == null)
                   {
                       response.sendRedirect("login.jsp");
                   }
                   int feesId = Integer.parseInt(request.getParameter("feesId"));

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
                            
                            statement = conn.prepareStatement("SELECT max(paymentId) from payment");
                            rs = statement.executeQuery();
                            
                    }catch (Exception e) {
                    e.printStackTrace();
                    }
      out.write("\n");
      out.write("                    <div class=\"invoice-box\">\n");
      out.write("                    <table cellpadding=\"0\" cellspacing=\"0\">\n");
      out.write("                        <tr class=\"top\">\n");
      out.write("                            <td colspan=\"2\">\n");
      out.write("                                <table>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td class=\"title\">\n");
      out.write("                                            <img src=\"https://www.sparksuite.com/images/logo.png\" style=\"width:100%; max-width:300px;\">\n");
      out.write("                                        </td>\n");
      out.write("\n");
      out.write("                                        <td>\n");
      out.write("                                            Invoice #: 123<br>\n");
      out.write("                                            Created: January 1, 2015<br>\n");
      out.write("                                            Due: February 1, 2015\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                </table>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                        <tr class=\"information\">\n");
      out.write("                            <td colspan=\"2\">\n");
      out.write("                                <table>\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>\n");
      out.write("                                            Sparksuite, Inc.<br>\n");
      out.write("                                            12345 Sunny Road<br>\n");
      out.write("                                            Sunnyville, CA 12345\n");
      out.write("                                        </td>\n");
      out.write("\n");
      out.write("                                        <td>\n");
      out.write("                                            Acme Corp.<br>\n");
      out.write("                                            John Doe<br>\n");
      out.write("                                            john@example.com\n");
      out.write("                                        </td>\n");
      out.write("                                    </tr>\n");
      out.write("                                </table>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                        <tr class=\"heading\">\n");
      out.write("                            <td>\n");
      out.write("                                Payment Method\n");
      out.write("                            </td>\n");
      out.write("\n");
      out.write("                            <td>\n");
      out.write("                                Check #\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                        <tr class=\"details\">\n");
      out.write("                            <td>\n");
      out.write("                                Check\n");
      out.write("                            </td>\n");
      out.write("\n");
      out.write("                            <td>\n");
      out.write("                                1000\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                        <tr class=\"heading\">\n");
      out.write("                            <td>\n");
      out.write("                                Item\n");
      out.write("                            </td>\n");
      out.write("\n");
      out.write("                            <td>\n");
      out.write("                                Price\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                        <tr class=\"item\">\n");
      out.write("                            <td>\n");
      out.write("                                Website design\n");
      out.write("                            </td>\n");
      out.write("\n");
      out.write("                            <td>\n");
      out.write("                                $300.00\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                        <tr class=\"item\">\n");
      out.write("                            <td>\n");
      out.write("                                Hosting (3 months)\n");
      out.write("                            </td>\n");
      out.write("\n");
      out.write("                            <td>\n");
      out.write("                                $75.00\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                        <tr class=\"item last\">\n");
      out.write("                            <td>\n");
      out.write("                                Domain name (1 year)\n");
      out.write("                            </td>\n");
      out.write("\n");
      out.write("                            <td>\n");
      out.write("                                $10.00\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                        <tr class=\"total\">\n");
      out.write("                            <td></td>\n");
      out.write("\n");
      out.write("                            <td>\n");
      out.write("                               Total: $385.00\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                    ");

                    /*if(loginId>8)
                    {
                        out.println("Successful!");
                        response.sendRedirect("fees.jsp");
                    }
                    else 
                    {
                        out.println("Successful!");
                        response.sendRedirect("feesAdmin.jsp");
                    }*/
                    
      out.write("\n");
      out.write("    </body>\n");
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
