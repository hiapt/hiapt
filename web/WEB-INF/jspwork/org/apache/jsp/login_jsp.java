/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.43
 * Generated at: 2019-10-16 06:57:21 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"utf-8\">\r\n");
      out.write("\t<title>로그인 페이지</title>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"\">\r\n");
      out.write("\t<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\t\r\n");
      out.write("\t<link href=\"/hiapt/resources/css/login.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\twindow.console = window.console || function(t) {};\r\n");
      out.write("\t</script>\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tif (document.location.search.match(/type=embed/gi)) {\r\n");
      out.write("\t\t\twindow.parent.postMessage(\"resize\", \"*\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"form\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<ul class=\"tab-group\">\r\n");
      out.write("\t\t\t<li class=\"tab active\"><a href=\"#login1\">세대주</a></li>\r\n");
      out.write("\t\t\t<li class=\"tab\"><a href=\"#login2\">관리자/직원</a></li>\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div class=\"tab-content\">\r\n");
      out.write("\t\t\t<div id=\"login1\">   \r\n");
      out.write("\t\t\t\t<form action=\"/hiapt/uin\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"field-wrap\">\r\n");
      out.write("\t\t\t\t\t\t<label>\r\n");
      out.write("\t\t\t\t\t\t\t아이디<span class=\"req\">*</span>\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t<!-- <input type=\"text\"/> -->\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"uid\" required autocomplete=\"off\"/>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"field-wrap\">\r\n");
      out.write("\t\t\t\t\t\t<label>\r\n");
      out.write("\t\t\t\t\t\t\t비밀번호<span class=\"req\">*</span>\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t<!-- <input type=\"password\"/> -->\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" name=\"upwd\" required autocomplete=\"off\"/>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<p class=\"forgot\"><a href=\"#\">비밀번호찾기</a></p>\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" value=\"로그인\">\r\n");
      out.write("\t\t\t\t\t<!-- <button class=\"button button-block\"/>로그인</button> -->\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div id=\"login2\">   \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<form action=\"/hiapt/ein\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"field-wrap\">\r\n");
      out.write("\t\t\t\t\t\t<label>\r\n");
      out.write("\t\t\t\t\t\t\t아이디<span class=\"req\">*</span>\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"eid\" required autocomplete=\"off\"/>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<div class=\"field-wrap\">\r\n");
      out.write("\t\t\t\t\t\t<label>\r\n");
      out.write("\t\t\t\t\t\t\t비밀번호<span class=\"req\">*</span>\r\n");
      out.write("\t\t\t\t\t\t</label>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<input type=\"password\" name=\"epwd\" required autocomplete=\"off\"/>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<p class=\"forgot\"><a href=\"#\">비밀번호찾기</a></p>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<input type=\"submit\" value=\"로그인\">\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t</form>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div><!-- tab-content -->\r\n");
      out.write("\t\t\r\n");
      out.write("\t</div> <!-- /form -->\r\n");
      out.write("\t<script id=\"rendered-js\">\r\n");
      out.write("\t\t$('.form').find('input, textarea').on('keyup blur focus', function (e) {\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar $this = $(this),\r\n");
      out.write("\t\t\tlabel = $this.prev('label');\r\n");
      out.write("\r\n");
      out.write("\t\t\tif (e.type === 'keyup') {\r\n");
      out.write("\t\t\t\tif ($this.val() === '') {\r\n");
      out.write("\t\t\t\t\tlabel.removeClass('active highlight');\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\tlabel.addClass('active highlight');\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t} else if (e.type === 'blur') {\r\n");
      out.write("\t\t\t\tif ($this.val() === '') {\r\n");
      out.write("\t\t\t\t\tlabel.removeClass('active highlight');\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\tlabel.removeClass('highlight');\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t} else if (e.type === 'focus') {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\tif ($this.val() === '') {\r\n");
      out.write("\t\t\t\t\tlabel.removeClass('highlight');\r\n");
      out.write("\t\t\t\t} else\r\n");
      out.write("\t\t\t\tif ($this.val() !== '') {\r\n");
      out.write("\t\t\t\t\tlabel.addClass('highlight');\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t$('.tab a').on('click', function (e) {\r\n");
      out.write("\r\n");
      out.write("\t\t\te.preventDefault();\r\n");
      out.write("\r\n");
      out.write("\t\t\t$(this).parent().addClass('active');\r\n");
      out.write("\t\t\t$(this).parent().siblings().removeClass('active');\r\n");
      out.write("\r\n");
      out.write("\t\t\ttarget = $(this).attr('href');\r\n");
      out.write("\r\n");
      out.write("\t\t\t$('.tab-content > div').not(target).hide();\r\n");
      out.write("\r\n");
      out.write("\t\t\t$(target).fadeIn(600);\r\n");
      out.write("\r\n");
      out.write("\t\t});\r\n");
      out.write("      //# sourceURL=pen.js\r\n");
      out.write("  </script>\r\n");
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
