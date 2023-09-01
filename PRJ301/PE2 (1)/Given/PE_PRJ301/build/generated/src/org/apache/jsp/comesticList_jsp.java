package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import pe.models.Comestic;
import pe.utils.DAO;
import pe.models.User;

public final class comesticList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            User currentUser = (User) session.getAttribute("currentUser");
            if (currentUser != null && !currentUser.getRoleID().equals("AD")) {
                response.sendRedirect("login.jsp");
            }
        
      out.write("\n");
      out.write("        <h1>comesticList, welcome ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${currentUser.getFullName()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("!</h1>\n");
      out.write("\n");
      out.write("        <form action=\"MainController\" method=\"GET\">\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"Search\">\n");
      out.write("            Search by Name: <input type=\"text\" name=\"searchName\">\n");
      out.write("            <input type=\"submit\" name = \"action\" value=\"Search\">\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <form action=\"MainController\" method=\"POST\">\n");
      out.write("            <input hidden value=\"AddDirectory\" name=\"action\">\n");
      out.write("            <button type=\"submit\">Add Comestic</button>\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"MainController\" method=\"POST\">\n");
      out.write("            <input hidden value=\"Logout\" name=\"action\">\n");
      out.write("            <button type=\"submit\">Logout</button>\n");
      out.write("        </form>\n");
      out.write("        ");
 
            List<Comestic> comestics = (List<Comestic>)session.getAttribute("comist");
            if (comestics != null) {
      out.write("\n");
      out.write("        <table border=\"2\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Comestic id</th>\n");
      out.write("                    <th>Name</th>\n");
      out.write("                    <th>Description</th>\n");
      out.write("                    <th>price</th>\n");
      out.write("                    <th>size</th>\n");
      out.write("                    <th>status</th>\n");
      out.write("                    <th>Action</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");
for (Comestic comestic : comestics) {
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( comestic.getId());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( comestic.getName());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( comestic.getDescription());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( comestic.getPrice());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( comestic.getSize());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( comestic.isStatus());
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("                        <form action=\"MainController\">\n");
      out.write("                            <input hidden value=\"Delete\" name=\"action\">\n");
      out.write("                            <input hidden value=\"");
      out.print( comestic.getId());
      out.write("\" name=\"id\">\n");
      out.write("                            <input type=\"submit\" value=\"Delete\">\n");
      out.write("                        </form>\n");
      out.write("                        <form action=\"MainController\">\n");
      out.write("                            <input hidden value=\"Edit\" name=\"action\">\n");
      out.write("                            <input hidden value=\"");
      out.print( comestic.getId());
      out.write("\" name=\"id\">\n");
      out.write("                            <input hidden value=\"");
      out.print( comestic.getName());
      out.write("\" name=\"name\">\n");
      out.write("                            <input hidden value=\"");
      out.print( comestic.getDescription());
      out.write("\" name=\"description\">\n");
      out.write("                            <input hidden value=\"");
      out.print( comestic.getPrice());
      out.write("\" name=\"price\">\n");
      out.write("                            <input hidden value=\"");
      out.print( comestic.getSize());
      out.write("\" name=\"size\">\n");
      out.write("                            <input hidden value=\"");
      out.print( comestic.isStatus());
      out.write("\" name=\"status\">\n");
      out.write("                            <input type=\"submit\" value=\"Edit\">\n");
      out.write("                        </form>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("        ");
} else { 
        DAO dao = new DAO();
        comestics = dao.getAllComestic();
        
      out.write("\n");
      out.write("                <table border=\"2\">\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Comestic id</th>\n");
      out.write("                    <th>Name</th>\n");
      out.write("                    <th>Description</th>\n");
      out.write("                    <th>price</th>\n");
      out.write("                    <th>size</th>\n");
      out.write("                    <th>status</th>\n");
      out.write("                    <th>Action</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");
for (Comestic comestic : comestics) {
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td>");
      out.print( comestic.getId());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( comestic.getName());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( comestic.getDescription());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( comestic.getPrice());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( comestic.getSize());
      out.write("</td>\n");
      out.write("                    <td>");
      out.print( comestic.isStatus());
      out.write("</td>\n");
      out.write("                    <td>\n");
      out.write("                        <form action=\"MainController\">\n");
      out.write("                            <input hidden value=\"Delete\" name=\"action\">\n");
      out.write("                            <input hidden value=\"");
      out.print( comestic.getId());
      out.write("\" name=\"id\">\n");
      out.write("                            <input type=\"submit\" value=\"Delete\">\n");
      out.write("                        </form>\n");
      out.write("                        <form action=\"MainController\">\n");
      out.write("                            <input hidden value=\"Edit\" name=\"action\">\n");
      out.write("                            <input hidden value=\"");
      out.print( comestic.getId());
      out.write("\" name=\"id\">\n");
      out.write("                            <input hidden value=\"");
      out.print( comestic.getName());
      out.write("\" name=\"name\">\n");
      out.write("                            <input hidden value=\"");
      out.print( comestic.getDescription());
      out.write("\" name=\"description\">\n");
      out.write("                            <input hidden value=\"");
      out.print( comestic.getPrice());
      out.write("\" name=\"price\">\n");
      out.write("                            <input hidden value=\"");
      out.print( comestic.getSize());
      out.write("\" name=\"size\">\n");
      out.write("                            <input hidden value=\"");
      out.print( comestic.isStatus());
      out.write("\" name=\"status\">\n");
      out.write("                            <input type=\"submit\" value=\"Edit\">\n");
      out.write("                        </form>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("        ");
 } 
      out.write("\n");
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
