/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.43
 * Generated at: 2019-10-06 18:33:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.employee.maintenance;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import maintenance.model.vo.BillView;
import java.util.ArrayList;

public final class BillViewList_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("maintenance.model.vo.BillView");
    _jspx_imports_classes.add("java.util.ArrayList");
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
      out.write("\r\n");

	ArrayList<BillView> list = (ArrayList<BillView>)request.getAttribute("list");
	int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
	int beginPage = ((Integer)request.getAttribute("beginPage")).intValue();
	int endPage = ((Integer)request.getAttribute("endPage")).intValue();
	int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();

      out.write("\r\n");
      out.write("<!-- 타이틀 시작 -->\r\n");
      out.write("<div class=\"row\">\r\n");
      out.write("\t<div id=\"breadcrumb\" class=\"col-xs-12\">\r\n");
      out.write("\t\t<!-- 삼디다스 버튼 -->\r\n");
      out.write("\t\t<a href=\"#\" class=\"show-sidebar\"> <i class=\"fa fa-bars\"></i>\r\n");
      out.write("\t\t</a>\r\n");
      out.write("\t\t<ol class=\"breadcrumb pull-left\">\r\n");
      out.write("\t\t\t<!-- 첫번째 타이틀 시작 -->\r\n");
      out.write("\t\t\t<li><a href=\"index.html\">관리비</a></li>\r\n");
      out.write("\t\t\t<!-- 두번째 하위 메뉴 시작 -->\r\n");
      out.write("\t\t\t<li><a href=\"#\">고지서조회</a></li>\r\n");
      out.write("\t\t\t<!-- 세번째 하위 메뉴 시작 -->\r\n");
      out.write("\t\t\t<!--li><a href=\"#\">부과항목등록</a></li-->\r\n");
      out.write("\t\t</ol>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- 타이틀 끝 -->\r\n");
      out.write("<!-- 고지서목록 -->\r\n");
      out.write("<div class=\"bs-callout bs-callout-info\"\r\n");
      out.write("\tid=\"callout-tabs-extends-component\">\r\n");
      out.write("\t<h4>고지서</h4><h6>전체 목록 : ");
      out.print( list.size() );
      out.write(" 개</h6>\r\n");
      out.write("</div>\r\n");
      out.write("<br>\r\n");
      out.write("<table class=\"table table-borderedz\">\r\n");
      out.write("\t<thead>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>고지서번호</th>\r\n");
      out.write("\t\t\t<th>동/호</th>\r\n");
      out.write("\t\t\t<th>부과금액</th>\r\n");
      out.write("\t\t\t<th>미납액</th>\r\n");
      out.write("\t\t\t<th>미납연체료</th>\r\n");
      out.write("\t\t\t<th>납기내금액</th>\r\n");
      out.write("\t\t\t<th>납기후금액</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</thead>\r\n");
      out.write("\t<tbody>\r\n");
      out.write("\t");
 for(BillView b : list){
	
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td>");
      out.print( b.getMerchantUid() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print( b.getUserId() );
      out.write("</td>\t\t\t\r\n");
      out.write("\t\t\t<td>");
      out.print( b.getAmount() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print( b.getArrears() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print( b.getArrearsFine() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print( b.getBeforeAmount() );
      out.write("</td>\r\n");
      out.write("\t\t\t<td>");
      out.print( b.getAfterAmount() );
      out.write("</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t");
 } 
      out.write("\r\n");
      out.write("\t</tbody>\r\n");
      out.write("</table>\r\n");
      out.write("<!-- pageing -->\r\n");
      out.write("<div class=\"row\">\r\n");
      out.write("<div class=\"pagination-centered\">\r\n");
      out.write("\t<ul class=\"pagination main-menu\">\r\n");
      out.write("\t\t<li class=\"disabled\"><a href=\"/hiapt/bwlist?page=1\" aria-label=\"Previous\"><span\r\n");
      out.write("\t\t\t\taria-hidden=\"true\">&lsaquo;</span></a></li>\r\n");
      out.write("\t\t");
 if((beginPage - 10 ) < 1){ 
      out.write("\r\n");
      out.write("\t\t<li class=\"disabled\"><a href=\"/hiapt/bwlist?page=1\" aria-label=\"Previous\"><span\r\n");
      out.write("\t\t\t\taria-hidden=\"true\">«</span></a></li>\r\n");
      out.write("\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t<li class=\"disabled\"><a href=\"/hiapt/bwlist?page=");
      out.print( beginPage - 10 );
      out.write("\" aria-label=\"Previous\"><span\r\n");
      out.write("\t\t\t\taria-hidden=\"true\">«</span></a></li>\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t");
 for(int p = beginPage; p <= endPage; p++){ 
			if( p == currentPage) {
		
      out.write("\r\n");
      out.write("\t\t<li class=\"active\"><a href=\"/hiapt/bwlist?page=");
      out.print( p );
      out.write("\" class=\"ajax-link\">1 <span class=\"sr-only\">");
      out.print( p );
      out.write("</span></a></li>\r\n");
      out.write("\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t<li><a href=\"/hiapt/bwlist?page=");
      out.print( p );
      out.write("\" class=\"ajax-link\">");
      out.print( p );
      out.write("</a></li>\r\n");
      out.write("\t\t");
 }} 
      out.write("\r\n");
      out.write("\t\t");
 if((endPage + 10) > maxPage ){ 
      out.write("\r\n");
      out.write("\t\t<li><a href=\"/hiapt/bwlist?page=");
      out.print( maxPage );
      out.write("\" aria-label=\"Next\"><span aria-hidden=\"true\">»</span></a></li>\r\n");
      out.write("\t\t");
 } else { 
      out.write("\r\n");
      out.write("\t\t<li><a href=\"/hiapt/bwlist?page=");
      out.print( endPage + 10 );
      out.write("\" aria-label=\"Next\"><span aria-hidden=\"true\">»</span></a></li>\r\n");
      out.write("\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t<li><a href=\"/hiapt/bwlist?page=");
      out.print( maxPage );
      out.write("\" aria-label=\"Next\"><span aria-hidden=\"true\">&rsaquo;</span></a></li>\r\n");
      out.write("\t</ul>\r\n");
      out.write("</div>\r\n");
      out.write("</div>\r\n");
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
