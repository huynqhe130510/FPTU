package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Employee;
import java.util.ArrayList;
import model.Department;

public final class employee_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        ");

            ArrayList<Department> depts = (ArrayList<Department>) request.getAttribute("depts");
            ArrayList<Employee> emps = (ArrayList<Employee>) request.getAttribute("emps");
            Integer did = (Integer) request.getAttribute("did");
        
      out.write("\n");
      out.write("        <script>\n");
      out.write("            function submitForm()\n");
      out.write("            {\n");
      out.write("                document.getElementById(\"searchFrm\").submit();\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form id=\"searchFrm\" action=\"list\" method=\"get\">\n");
      out.write("            <select name=\"did\" onchange=\"submitForm();\"> \n");
      out.write("                <option value=\"-1\">----------ALL----------</option>\n");
      out.write("                ");
 for (Department d : depts) {
                
      out.write("\n");
      out.write("                <option \n");
      out.write("                    ");
      out.print((d.getId() == did) ? "selected" : "");
      out.write("\n");
      out.write("                    value=\"");
      out.print(d.getId());
      out.write('"');
      out.write('>');
      out.print(d.getName());
      out.write("</option>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("            </select>\n");
      out.write("        </form> \n");
      out.write("\n");
      out.write("        <a href=\"insert\"><input type=\"button\" value=\"Add\"></a>\n");
      out.write("\n");
      out.write("        <table border =1>\n");
      out.write("            <tr>\n");
      out.write("                <th>ID</th>\n");
      out.write("                <th>Name</th>\n");
      out.write("                <th>DOB</th>\n");
      out.write("                <th>Gender</th>\n");
      out.write("                <th>Department</th>\n");
      out.write("                <th>Edit</th>\n");
      out.write("                <th>Delete</th>\n");
      out.write("            </tr>\n");
      out.write("            ");
 for (Employee e : emps) {
            
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(e.getId());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(e.getName());
      out.write("</td>\n");
      out.write("                <td>");
      out.print(e.getDob());
      out.write("</td>\n");
      out.write("                <td>\n");
      out.write("                    ");
if (e.isGender()) {
      out.write("<img src=\"https://static.thenounproject.com/png/583025-200.png\" width = \"20px\" height = \"20px\" alt=\"\"/>");
}
      out.write(" \n");
      out.write("                    ");
 if (!e.isGender()) {
      out.write("<img src=\"https://image.flaticon.com/icons/png/512/38/38373.png\" width = \"20px\" height = \"20px\" alt=\"\"/>");
}
      out.write(" \n");
      out.write("                </td>\n");
      out.write("                <td>");
      out.print(e.getDept().getName());
      out.write("</td>\n");
      out.write("                <td><a href=\"update?id=");
      out.print(e.getId());
      out.write("\">Edit</a></td>\n");
      out.write("                <td><a href=\"delete?idd=");
      out.print(e.getId());
      out.write("\">Delete</a></td>\n");
      out.write("            </tr>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("        </table>  \n");
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
