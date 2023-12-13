package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<title> Taska Sarjana Pintar</title>\n");
      out.write("  <body>\n");
      out.write("    <head>\n");
      out.write("        <div class=\"navbar\">\n");
      out.write("            <h1 class=\"w3-center\"><b>Taska Sarjana Pintar</h1></b>\n");
      out.write("        <a href=\"index.jsp\">Home</a>\n");
      out.write("        <a href=\"ourInfo.jsp\">Our Info</a>\n");
      out.write("        <a href=\"register.jsp\">Register</a>\n");
      out.write("        <a href=\"studentProfile.jsp\">Student Profile</a>\n");
      out.write("        <a href=\"login.jsp\">User</a>\n");
      out.write("      </div>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("      \n");
      out.write("    \n");
      out.write("      <br><br><br><br><br><br><br><br>\n");
      out.write("      <div class=\"w3-container w3-content w3-center w3-padding-64 w3-round w3-border w3-card-4 w3-light-grey\" style=\"max-width:1500px\">\n");
      out.write("        <div class=\"mySlides w3-display-container w3-center\">\n");
      out.write("            <img src=\"img1.jpeg\" class=\"w3-round w3-border w3-card-4\" style=\"width:100%\">\n");
      out.write("            <div class=\"w3-display-middle w3-container w3-text-white w3-padding-32 w3-hide-small\">\n");
      out.write("                <img src=\"logo.jpg\" style=\"width:30%\"><br>\n");
      out.write("                <font size=\"7\"><b>Taska Sarjana Pintar</b></font>\n");
      out.write("                <p><b>“Once you learn how to read, you will be free forever”</b></p>\n");
      out.write("            </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"mySlides w3-display-container w3-center\">\n");
      out.write("              <img src=\"img2.jpeg\" class=\"w3-round w3-border w3-card-4\" style=\"width:100%\">\n");
      out.write("              <div class=\"w3-display-middle w3-container w3-text-white w3-padding-32 w3-hide-small\">\n");
      out.write("                <img src=\"logo.jpg\" style=\"width:30%\"><br>\n");
      out.write("                <font size=\"7\"><b>Taska Sarjana Pintar</b></font>\n");
      out.write("                <p><b>“Once you learn how to read, you will be free forever”</b></p>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"mySlides w3-display-container w3-center\">\n");
      out.write("              <img src=\"img3.jpeg\" class=\"w3-round w3-border w3-card-4\" style=\"width:100%\">\n");
      out.write("              <div class=\"w3-display-middle w3-container w3-text-white w3-padding-32 w3-hide-small\">\n");
      out.write("                <img src=\"logo.jpg\" style=\"width:30%\"><br>\n");
      out.write("                <font size=\"7\"><b>Taska Sarjana Pintar</b></font>\n");
      out.write("                <p><b>“Once you learn how to read, you will be free forever”</b></p>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("      </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <footer>\n");
      out.write("        <p class=\"w3-medium\">Powered by UiTM</p>\n");
      out.write("    </footer>\n");
      out.write("\n");
      out.write("  </body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("<script>\n");
      out.write("        // Automatic Slideshow - change image every 2 seconds\n");
      out.write("        var myIndex = 0;\n");
      out.write("        carousel();\n");
      out.write("\n");
      out.write("        function carousel() {\n");
      out.write("            var i;\n");
      out.write("            var x = document.getElementsByClassName(\"mySlides\");\n");
      out.write("            for (i = 0; i < x.length; i++) {\n");
      out.write("               x[i].style.display = \"none\";\n");
      out.write("            }\n");
      out.write("            myIndex++;\n");
      out.write("            if (myIndex > x.length) {myIndex = 1}\n");
      out.write("            x[myIndex-1].style.display = \"block\";\n");
      out.write("            setTimeout(carousel, 2000);\n");
      out.write("        }\n");
      out.write("        </script>\n");
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
