/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.76
 * Generated at: 2024-11-19 18:19:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;

public final class UpdateStudent_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.sql.ResultSet");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("	\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");
      out.write("<!-- Google Fonts -->\r\n");
      out.write("<link\r\n");
      out.write("	href=\"https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap\"\r\n");
      out.write("	rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("* {\r\n");
      out.write("	box-sizing: border-box;\r\n");
      out.write("	margin: 0;\r\n");
      out.write("	padding: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("	font-family: 'Poppins', sans-serif;\r\n");
      out.write("	height: 100vh;\r\n");
      out.write("	display: flex;\r\n");
      out.write("	justify-content: center;\r\n");
      out.write("	align-items: center;\r\n");
      out.write("	background: linear-gradient(165deg, purple, aqua);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("form {\r\n");
      out.write("	/*   border: 2px solid black; */\r\n");
      out.write("	background: #fff;\r\n");
      out.write("	padding: 30px;\r\n");
      out.write("	width: 100%;\r\n");
      out.write("	max-width: 500px;\r\n");
      out.write("	display: flex;\r\n");
      out.write("	justify-content: center;\r\n");
      out.write("	align-items: center;\r\n");
      out.write("	flex-direction: column;\r\n");
      out.write("	gap: 20px;\r\n");
      out.write("	border-radius: 15px;\r\n");
      out.write("	box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("h1 {\r\n");
      out.write("	font-size: 2rem;\r\n");
      out.write("	color: #333;\r\n");
      out.write("	text-align: center;\r\n");
      out.write("	font-weight: 600; \r\n");
      out.write("} \r\n");
      out.write("	\r\n");
      out.write("input {\r\n");
      out.write("	height: 40px;\r\n");
      out.write("	width: 300px;\r\n");
      out.write("	padding-left: 10px;\r\n");
      out.write("	font-size: 16px;\r\n");
      out.write("	border: 2px solid #ccc;\r\n");
      out.write("	border-radius: 10px;\r\n");
      out.write("	transition: border-color 0.3s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input:focus {\r\n");
      out.write("    border-color: #007BFF;\r\n");
      out.write("    outline: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#update_btn {\r\n");
      out.write("	height: 50px;\r\n");
      out.write("	width: 120px;\r\n");
      out.write("    background-color: #007BFF;\r\n");
      out.write("    color: #fff;\r\n");
      out.write("    border: none;\r\n");
      out.write("    font-size: 18px;\r\n");
      out.write("    border-radius: 10px;\r\n");
      out.write("    cursor: pointer;\r\n");
      out.write("    transition: background-color 0.3s, transform 0.2s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#update_btn:hover {\r\n");
      out.write("    background-color: #0056b3;\r\n");
      out.write("    transform: scale(1.05);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Media Query */\r\n");
      out.write("@media (max-width: 600px) {\r\n");
      out.write("    form {\r\n");
      out.write("        padding: 20px;\r\n");
      out.write("        width: 90%;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    h1 {\r\n");
      out.write("        font-size: 1.5rem;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    input, #update_btn {\r\n");
      out.write("        font-size: 14px;\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");

	ResultSet rs = (ResultSet) request.getAttribute("resultSet");
	rs.next();
	
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<form action=\"save-updated-student\" method=\"post\">\r\n");
      out.write("		<div>\r\n");
      out.write("			<h1>Update Student Details:</h1>\r\n");
      out.write("		</div>\r\n");
      out.write("		<div>\r\n");
      out.write("			<input type=\"number\" value=\"");
      out.print(rs.getInt(1));
      out.write("\" name=\"studentId\" readonly=\"readonly\">\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("		<div>\r\n");
      out.write("			<input type=\"text\" value=\"");
      out.print( rs.getString(2) );
      out.write("\" name=\"studentName\">\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("		<div>\r\n");
      out.write("			<input type=\"text\" value=\"");
      out.print( rs.getString(3) );
      out.write("\"\r\n");
      out.write("				name=\"studentEmail\">\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("		<div>\r\n");
      out.write("			<input type=\"number\" value=\"");
      out.print( rs.getInt(4) );
      out.write("\" name=\"studentAge\">\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("		<div>\r\n");
      out.write("			<input type=\"text\" value=\"");
      out.print( rs.getString(5) );
      out.write("\"\r\n");
      out.write("				name=\"studentCourse\">\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("		<div>\r\n");
      out.write("			<input type=\"text\" value=\"");
      out.print( rs.getString(6) );
      out.write("\" name=\"studentCity\">\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("		<div>\r\n");
      out.write("			<button type=\"submit\" id=\"update_btn\" value=\"Update\">Update</button>\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("	</form>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}