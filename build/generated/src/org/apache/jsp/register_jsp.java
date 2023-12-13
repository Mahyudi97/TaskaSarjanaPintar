package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<link rel=\"stylesheet\" href=\"css/w3.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"css/stylesheet.css\">\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("<title> Taska Sarjana Pintar</title>\n");
      out.write("  <body>\n");
      out.write("    <head>\n");
      out.write("        \n");
      out.write("        <div class=\"navbar\">\n");
      out.write("            <h1 class=\"w3-center\"><b>Taska Sarjana Pintar</h1></b>\n");
      out.write("        <a href=\"index.jsp\">Home</a>\n");
      out.write("        <a href=\"ourInfo.jsp\">Our Info</a>\n");
      out.write("        <a href=\"register.jsp\">Register</a>\n");
      out.write("        <a href=\"studentProfile.jsp\">Student Profile</a>\n");
      out.write("        <a href=\"login.jsp\" >User</a>\n");
      out.write("      </div>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("      \n");
      out.write("      <br><br><br><br><br><br><br><br>\n");
      out.write("      <div class=\"w3-container w3-content w3-center w3-padding-64 w3-round w3-border w3-card-4 w3-light-grey\" style=\"max-width:1500px\">\n");
      out.write("        <h2 class=\"w3-wide w3-center\">Register Now!</h2>\n");
      out.write("        <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/registerController\" method=\"post\" class=\"w3-center\" >\n");
      out.write("          <center>\n");
      out.write("          <table border=\"2\">\n");
      out.write("            <colgroup>\n");
      out.write("               <col span=\"1\" style=\"width: 20%;\">\n");
      out.write("               <col span=\"1\" style=\"width: 30%;\">\n");
      out.write("               <col span=\"1\" style=\"width: 20%;\">\n");
      out.write("               <col span=\"1\" style=\"width: 30%;\">\n");
      out.write("            </colgroup>\n");
      out.write("            <tr>\n");
      out.write("                <th colspan=\"4\">Student Information</th>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Student's Name : </td>\n");
      out.write("                <td colspan=\"3\"><input class=\"w3-input w3-border\" type=\"text\" name=\"studName\" required></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Student's IC : </td>\n");
      out.write("                <td><input class=\"w3-input w3-border\" type=\"text\" name=\"studIC\" required></td>\n");
      out.write("                <td>Student's Birth Certificate : </td>\n");
      out.write("                <td><input class=\"w3-input w3-border\" type=\"text\" name=\"studBirthCertificate\" required></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Student's Gender : </td>\n");
      out.write("                <td><select class=\"w3-input w3-border\" name=\"studGender\" required>\n");
      out.write("                      <option value=\"Male\">Male</option>\n");
      out.write("                      <option value=\"Female\">Female</option>\n");
      out.write("                    </select></td>\n");
      out.write("                <td>Student's Age : </td>\n");
      out.write("                <td><input class=\"w3-input w3-border\" type=\"text\" name=\"studAge\" required></td>\n");
      out.write("            </tr>\n");
      out.write("          </table>\n");
      out.write("          <br>\n");
      out.write("          <hr>\n");
      out.write("          <br>\n");
      out.write("          <table border=\"2\">\n");
      out.write("            <colgroup>\n");
      out.write("               <col span=\"1\" style=\"width: 15%;\">\n");
      out.write("               <col span=\"1\" style=\"width: 35%;\">\n");
      out.write("               <col span=\"1\" style=\"width: 15%;\">\n");
      out.write("               <col span=\"1\" style=\"width: 35%;\">\n");
      out.write("            </colgroup>\n");
      out.write("            <tr>\n");
      out.write("                <th colspan=\"4\">Parent's Information</th>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("              <td>Parent's Address : </td>\n");
      out.write("              <td colspan=\"3\"><input class=\"w3-input w3-border\" type=\"text\" name=\"parentsAddress\" required></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Father's Name : </td>\n");
      out.write("                <td colspan=\"3\"><input class=\"w3-input w3-border\" type=\"text\" name=\"fatherName\" required></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Father's IC : </td>\n");
      out.write("                <td><input class=\"w3-input w3-border\" type=\"text\" name=\"fatherIC\" required></td>\n");
      out.write("\n");
      out.write("                <td>Fathers's Contact Number : </td>\n");
      out.write("                <td><input class=\"w3-input w3-border\" type=\"text\" name=\"fatherContactNum\" required></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Father's Occupation : </td>\n");
      out.write("                <td colspan=\"3\"><input class=\"w3-input w3-border\" type=\"text\" name=\"fatherOccupation\" required></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Father's Occupation Address : </td>\n");
      out.write("                <td colspan=\"3\"><input class=\"w3-input w3-border\" type=\"text\" name=\"fatherOccupAddress\" required></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Mother's Name : </td>\n");
      out.write("                <td colspan=\"3\"><input class=\"w3-input w3-border\" type=\"text\" name=\"motherName\" required></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Mother's IC : </td>\n");
      out.write("                <td><input class=\"w3-input w3-border\" type=\"text\" name=\"motherIC\" required></td>\n");
      out.write("                <td>Mother's Contact Number : </td>\n");
      out.write("                <td><input class=\"w3-input w3-border\" type=\"text\" name=\"motherContactNum\" required></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Mother's Occupation : </td>\n");
      out.write("                <td colspan=\"3\"><input class=\"w3-input w3-border\" type=\"text\" name=\"motherOccupation\" required></td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Mother's Occupation Address : </td>\n");
      out.write("                <td colspan=\"3\"><input class=\"w3-input w3-border\" type=\"text\" name=\"motherOccupAddress\" required></td>\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("          </table>\n");
      out.write("\n");
      out.write("          <center>\n");
      out.write("          <button class=\"w3-button w3-section w3-card-4 w3-round w3-right w3-black\" type=\"submit\" name=\"submit\">SUBMIT</button>\n");
      out.write("        </center>\n");
      out.write("        </center>\n");
      out.write("        </form>\n");
      out.write("      </div>\n");
      out.write("      \n");
      out.write("      \n");
      out.write("      <br><br><br><br><br><br><br><br>\n");
      out.write("    <footer>\n");
      out.write("        <p class=\"w3-medium\">Powered by UiTM</p>\n");
      out.write("    </footer>\n");
      out.write("\n");
      out.write("  </body>\n");
      out.write("\n");
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
