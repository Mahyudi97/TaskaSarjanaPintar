package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html><link rel=\"stylesheet\" href=\"w3.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"stylesheet.css\">\n");
      out.write("<html>\n");
      out.write("<style>\n");
      out.write("footer {\n");
      out.write("  position: fixed;\n");
      out.write("   left: 0;\n");
      out.write("   bottom: 0;\n");
      out.write("   width: 100%;\n");
      out.write("   background-color: #333;\n");
      out.write("   color: white;\n");
      out.write("   text-align: center;\n");
      out.write("}\n");
      out.write("</style>\n");
      out.write("<title> Taska Sarjana Pintar</title>\n");
      out.write("  <body>\n");
      out.write("    <head>\n");
      out.write("        <h1 class=\"w3-center\"><b>Taska Sarjana Pintar</h1></b>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("      <br><br>\n");
      out.write("      <div class=\"w3-container w3-content w3-center w3-padding-64 w3-round w3-border w3-card-4 w3-light-grey\" style=\"max-width:1200px\">\n");
      out.write("          <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/loginController\" method=\"post\" class=\"w3-center\">\n");
      out.write("          <center>\n");
      out.write("            <table border=\"0\">\n");
      out.write("              <colgroup>\n");
      out.write("                 <col span=\"1\" style=\"width: 35%;\">\n");
      out.write("                 <col span=\"1\" style=\"width: 65%;\">\n");
      out.write("              </colgroup>\n");
      out.write("\n");
      out.write("              <tr>\n");
      out.write("                  <td>Enter IC number : </td>\n");
      out.write("                  <td><input class=\"w3-input w3-border\" type=\"text\" placeholder=\"User's IC\" required name=\"teacherIC\"></td>\n");
      out.write("              </tr>\n");
      out.write("              <tr>\n");
      out.write("                  <td>Password : </td>\n");
      out.write("                  <td><input class=\"w3-input w3-border\" type=\"password\"  placeholder=\"Password\" required name=\"loginPassword\"></td>\n");
      out.write("              </tr>\n");
      out.write("            </table>\n");
      out.write("            <button class=\"w3-button w3-black w3-section w3-card-4 w3-round\" type=\"submit\" name=\"submit\">SUBMIT</button>\n");
      out.write("            <button class=\"w3-button w3-black w3-section w3-card-4 w3-round\" type=\"reset\" name=\"reset\">RESET</button>\n");
      out.write("          </center>\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("      </div>\n");
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
