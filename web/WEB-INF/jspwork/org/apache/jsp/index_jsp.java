/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.43
 * Generated at: 2019-10-15 16:30:28 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import employee.model.vo.Employee;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(5);
    _jspx_dependants.put("/./views/common/empTopNavi.jsp", Long.valueOf(1571157023390L));
    _jspx_dependants.put("/views/common/empfooter.html", Long.valueOf(1571157023395L));
    _jspx_dependants.put("/./views/common/emphead.html", Long.valueOf(1571157023399L));
    _jspx_dependants.put("/./views/common/empnavi.jsp", Long.valueOf(1571157023403L));
    _jspx_dependants.put("/views/common/topbutton.html", Long.valueOf(1571157023412L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("employee.model.vo.Employee");
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

      out.write("\t\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<!-- head 시작 -->\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\r\n");
      out.write("<meta name=\"description\" content=\"\">\r\n");
      out.write("<meta name=\"author\" content=\"\">\r\n");
      out.write("\r\n");
      out.write("<title>HIAPTProject</title>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Custom fonts for this template-->\r\n");
      out.write("\t<link href=\"/hiapt/resources/vendor/fontawesome-free/css/all.min.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t<link\r\n");
      out.write("\thref=\"https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("\t<!-- Custom styles for this template-->\r\n");
      out.write("\t<link href=\"/hiapt/resources/css/sb-admin-2.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<link href=\"/hiapt/resources/css/basic.css\" rel=\"stylesheet\">\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- Bootstrap core JavaScript-->\r\n");
      out.write("\t<script src=\"/hiapt/resources/vendor/jquery/jquery.min.js\"></script>\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"/hiapt/resources/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Core plugin JavaScript-->\r\n");
      out.write("\t<script\r\n");
      out.write("\t\tsrc=\"/hiapt/resources/vendor/jquery-easing/jquery.easing.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Custom scripts for all pages-->\r\n");
      out.write("\t<script src=\"/hiapt/resources/js/sb-admin-2.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Page level plugins -->\r\n");
      out.write("\t<script src=\"/hiapt/resources/vendor/chart.js/Chart.min.js\"></script>\r\n");
      out.write("\t<script src=\"/hiapt/resources/js/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<!--// css or jQuery or javaScript ì½ì ë¶ë¶    -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- head 시작 -->\r\n");
      out.write("<body id=\"page-top\">\r\n");
      out.write("\r\n");
      out.write("\t<!-- Page Wrapper -->\r\n");
      out.write("\t<div id=\"wrapper\">\r\n");
      out.write("\r\n");
      out.write("<!-- 왼쪽 메인 메뉴바 시작 --> \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");

	Employee emp = (Employee)session.getAttribute("employee");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- ============================================================= -->\r\n");
      out.write("<!-- 왼쪽 메인 메뉴바 시작  --> \r\n");
      out.write("\t\t<ul\r\n");
      out.write("\t\t\tclass=\"navbar-nav bg-gradient-primary sidebar sidebar-dark accordion\"\r\n");
      out.write("\t\t\tid=\"accordionSidebar\">\r\n");
      out.write("\r\n");
      out.write("<!-- 스마일 로고 -->\r\n");
      out.write("\t\t\t<a class=\"sidebar-brand d-flex align-items-center justify-content-center\"\r\n");
      out.write("\t\t\t\thref=\"/hiapt/login.jsp\">\r\n");
      out.write("\t\t\t\t<div class=\"sidebar-brand-icon rotate-n-15\">\r\n");
      out.write("\t\t\t\t\t<i class=\"fas fa-laugh-wink\"></i>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"sidebar-brand-text mx-3\">\r\n");
      out.write("\t\t\t\t\tHIAPT <sup>2</sup>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\r\n");
      out.write("<!-- 왼쪽 메뉴바 시작 -->\r\n");
      out.write("<!-- ============================================================= -->\t\t\r\n");
      out.write("\t\t<hr class=\"sidebar-divider\">\r\n");
      out.write("\t\t<!-- Heading 나중에 삭제부분-->\r\n");
      out.write("      \t<div class=\"sidebar-heading\">직원</div>\r\n");
      out.write("<!-- ============================================================= -->\r\n");
      out.write("<!-- 메일 시작 -->\r\n");
      out.write("\t\t\t<li class=\"nav-item\"><a class=\"nav-link collapsed\" href=\"#\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"collapse\" data-target=\"#mail\"\r\n");
      out.write("\t\t\t\taria-expanded=\"true\" aria-controls=\"collapseTwo\"> <i\r\n");
      out.write("\t\t\t\t\tclass=\"fas fa-fw fa-envelope-open\"></i> <span>메일(직원)</span>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t\t<div id=\"mail\" class=\"collapse\"\r\n");
      out.write("\t\t\t\t\taria-labelledby=\"headingUtilities\" data-parent=\"#accordionSidebar\">\r\n");
      out.write("\t\t\t\t\t<div class=\"bg-white py-2 collapse-inner rounded\">\r\n");
      out.write("\t\t\t\t\t\t<a class=\"collapse-item\" href=\"/hiapt/views/emp/mail/allmail.jsp\">전체메일함</a>\r\n");
      out.write("\t\t\t\t\t\t<a class=\"collapse-item\" href=\"cards.html\">메일2</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("<!-- 메일 끝 -->\r\n");
      out.write("<!-- ====================================================================================== -->\r\n");
      out.write("<!-- ====================================================================================== -->\t\t\t\r\n");
      out.write("<!--인사정보 시작 -->\r\n");
      out.write("\t\t<hr class=\"sidebar-divider\">\r\n");
      out.write("\t\t<!-- Heading 나중에 삭제부분-->\r\n");
      out.write("      \t<div class=\"sidebar-heading\">직원</div>\r\n");
      out.write("<!-- ====================================================================================== -->\t      \t\r\n");
      out.write("\t\t\t<li class=\"nav-item\"><a class=\"nav-link collapsed\" href=\"#\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"collapse\" data-target=\"#employee\" aria-expanded=\"true\"\r\n");
      out.write("\t\t\t\taria-controls=\"collapseUtilities\"> <i\r\n");
      out.write("\t\t\t\t\tclass=\"fas fa-fw fa-address-card\"></i> <span>인사</span>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t\t<div id=\"employee\" class=\"collapse\"\r\n");
      out.write("\t\t\t\t\taria-labelledby=\"headingUtilities\" data-parent=\"#accordionSidebar\">\r\n");
      out.write("\t\t\t\t\t<div class=\"bg-white py-2 collapse-inner rounded\">\r\n");
      out.write("\t\t\t\t\t\t<a class=\"collapse-item\" href=\"/hiapt/emplist\">직원정보</a> <a\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"collapse-item\"\r\n");
      out.write("\t\t\t\t\t\t\thref=\"/hiapt/views/emp/member/empenroll.html\">직원등록</a> <a\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"collapse-item\" href=\"utilities-animation.html\">Animations</a>\r\n");
      out.write("\t\t\t\t\t\t<a class=\"collapse-item\" href=\"utilities-other.html\">Other</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\r\n");
      out.write("<!-- 인사정보 끝 -->\r\n");
      out.write("<!-- ================================================================================= -->\r\n");
      out.write("\r\n");
      out.write("<!-- ================================================================================= -->\r\n");
      out.write("<!--전자결재 시작 -->\r\n");
      out.write("\t\t<hr class=\"sidebar-divider\">\r\n");
      out.write("\t\t<!-- Heading 나중에 삭제부분-->\r\n");
      out.write("      \t<div class=\"sidebar-heading\">직원</div>\r\n");
      out.write("<!-- ====================================================================================== -->\t\r\n");
      out.write("\t\t\t<li class=\"nav-item\"><a class=\"nav-link collapsed\" href=\"#\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"collapse\" data-target=\"#draft\" aria-expanded=\"true\"\r\n");
      out.write("\t\t\t\taria-controls=\"collapseUtilities\"> <i\r\n");
      out.write("\t\t\t\t\tclass=\"fas fa-fw fa-folder\"></i> <span>전자결재</span>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t\t<div id=\"draft\" class=\"collapse\"\r\n");
      out.write("\t\t\t\t\taria-labelledby=\"headingUtilities\" data-parent=\"#accordionSidebar\">\r\n");
      out.write("\t\t\t\t\t<div class=\"bg-white py-2 collapse-inner rounded\">\r\n");
      out.write("\t\t\t\t\t\t<a class=\"collapse-item\"\r\n");
      out.write("\t\t\t\t\t\t\thref=\"/hiapt/views/emp/approval/draftWrite.jsp\">기안작성테스트</a> \r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"collapse-item\" href=\"/hiapt/dtemp\">임시보관함</a> \r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"collapse-item\" href=\"/hiapt/dlist?empno=");
      out.print( emp.getEmpNo() );
      out.write("\">전자결재 전체목록</a>\r\n");
      out.write("\t\t\t\t\t\t\t<a class=\"collapse-item\" href=\"/hiapt/dstandby\">전자결재 대기목록</a> <a\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"collapse-item\" href=\"/hiapt/dapproved\">전자결재 승인목록</a> <a\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"collapse-item\" href=\"/hiapt/dreturn\">전자결재 반려목록</a> <a\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"collapse-item\" href=\"/hiapt/ddefer\">전자결재 보류목록</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("<!-- 전자결재 끝 -->\r\n");
      out.write("<!-- ================================================================================= -->\r\n");
      out.write("<!-- ================================================================================= -->\r\n");
      out.write("<!--관리비 시작 -->\r\n");
      out.write("\t\t<hr class=\"sidebar-divider\">\r\n");
      out.write("\t\t<!-- Heading 나중에 삭제부분-->\r\n");
      out.write("      \t<div class=\"sidebar-heading\">직원</div>\r\n");
      out.write("<!-- ====================================================================================== -->\t\r\n");
      out.write("\t\t\t<li class=\"nav-item\"><a class=\"nav-link collapsed\" href=\"#\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"collapse\" data-target=\"#maintenance\"\r\n");
      out.write("\t\t\t\taria-expanded=\"true\" aria-controls=\"collapseUtilities\"> <i\r\n");
      out.write("\t\t\t\t\tclass=\"fas fa-fw fa-calculator\"></i> <span>관리비관리</span>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t\t<div id=\"maintenance\" class=\"collapse\"\r\n");
      out.write("\t\t\t\t\taria-labelledby=\"headingUtilities\" data-parent=\"#accordionSidebar\">\r\n");
      out.write("\t\t\t\t\t<div class=\"bg-white py-2 collapse-inner rounded\">\r\n");
      out.write("\t\t\t\t\t\t<a class=\"collapse-item\" href=\"/hiapt/bwlist\">일반관리비 목록 </a> <a\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"collapse-item\" href=\"/hiapt/bilist\">고지서 목록 </a> <a\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"collapse-item\"\r\n");
      out.write("\t\t\t\t\t\t\thref=\"/hiapt/views/emp/maintenance/BillList.jsp\">고지서 상세 목록 조회</a>\r\n");
      out.write("\t\t\t\t\t\t<a class=\"collapse-item\"\r\n");
      out.write("\t\t\t\t\t\t\thref=\"/hiapt/views/emp/maintenance/BillListDetailView.jsp\">상세보기</a>\r\n");
      out.write("\t\t\t\t\t\t<a class=\"collapse-item\" href=\"/hiapt/bvilis\">부과기초작업</a> <a\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"collapse-item\" href=\"*\">4</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("<!-- 관리비 끝 -->\r\n");
      out.write("<!-- ================================================================================= -->\r\n");
      out.write("<!-- ================================================================================= -->\r\n");
      out.write("<!--공지사항 시작 -->\r\n");
      out.write("\t\t<hr class=\"sidebar-divider\">\r\n");
      out.write("\t  \t<!-- Heading 나중에 삭제부분-->\r\n");
      out.write("      \t<div class=\"sidebar-heading\">관리자</div>\r\n");
      out.write("<!-- ================================================================================= -->\r\n");
      out.write("\t\t\t<li class=\"nav-item\"><a class=\"nav-link collapsed\" href=\"#\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"collapse\" data-target=\"#notice\"\r\n");
      out.write("\t\t\t\taria-expanded=\"true\" aria-controls=\"collapseUtilities\"> <i\r\n");
      out.write("\t\t\t\t\tclass=\"fas fa-fw fa-bullhorn\"></i> <span>공지사항</span>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t\t<div id=\"notice\" class=\"collapse\"\r\n");
      out.write("\t\t\t\t\taria-labelledby=\"headingUtilities\" data-parent=\"#accordionSidebar\">\r\n");
      out.write("\t\t\t\t\t<div class=\"bg-white py-2 collapse-inner rounded\">\r\n");
      out.write("\t\t\t\t\t\t<a class=\"collapse-item\" href=\"/hiapt/views/master/notice/noticeAdminListView.jsp\">공지사항 목록</a> \r\n");
      out.write("\t\t\t\t\t\t<a class=\"collapse-item\" href=\"*\">공지사항 대기목록 </a> \r\n");
      out.write("\t\t\t\t\t\t<a class=\"collapse-item\" href=\"*\">공지사항2</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("<!--공지사항 끝 -->\r\n");
      out.write("<!-- ================================================================================= -->\r\n");
      out.write("<!-- ================================================================================= -->\r\n");
      out.write("<!--캘린더 시작 -->\r\n");
      out.write("      <hr class=\"sidebar-divider\">\r\n");
      out.write("        <!-- Heading 나중에 삭제부분-->\r\n");
      out.write("         <div class=\"sidebar-heading\">emp</div>\r\n");
      out.write("<!-- ================================================================================= -->\r\n");
      out.write("         <li class=\"nav-item\"><a class=\"nav-link\"\r\n");
      out.write("            href=\"z\"> <i\r\n");
      out.write("               class=\"fas fa-fw fa-calendar-alt\"></i> <span>Calendar</span></a>\r\n");
      out.write("         </li>\r\n");
      out.write("<!--캘린더 끝 -->\r\n");
      out.write("<!-- ================================================================================= -->\r\n");
      out.write("<!-- ================================================================================= -->\r\n");
      out.write("<!-- Nav Item - Pages Collapse Menu 삭제용 -->\r\n");
      out.write("      <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseTwo\" aria-expanded=\"true\" aria-controls=\"collapseTwo\">\r\n");
      out.write("          <i class=\"fas fa-fw fa-cog\"></i>\r\n");
      out.write("          <span>Components</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <div id=\"collapseTwo\" class=\"collapse\" aria-labelledby=\"headingTwo\" data-parent=\"#accordionSidebar\">\r\n");
      out.write("          <div class=\"bg-white py-2 collapse-inner rounded\">\r\n");
      out.write("            <h6 class=\"collapse-header\">Custom Components:</h6>\r\n");
      out.write("            <a class=\"collapse-item\" href=\"/hiapt/views/ex/buttons.html\">Buttons</a>\r\n");
      out.write("            <a class=\"collapse-item\" href=\"/hiapt/views/ex/cards.html\">Cards</a>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </li>\r\n");
      out.write("\r\n");
      out.write("      <!-- Nav Item - Utilities Collapse Menu -->\r\n");
      out.write("      <li class=\"nav-item\">\r\n");
      out.write("        <a class=\"nav-link collapsed\" href=\"#\" data-toggle=\"collapse\" data-target=\"#collapseUtilities\" aria-expanded=\"true\" aria-controls=\"collapseUtilities\">\r\n");
      out.write("          <i class=\"fas fa-fw fa-wrench\"></i>\r\n");
      out.write("          <span>Utilities</span>\r\n");
      out.write("        </a>\r\n");
      out.write("        <div id=\"collapseUtilities\" class=\"collapse\" aria-labelledby=\"headingUtilities\" data-parent=\"#accordionSidebar\">\r\n");
      out.write("          <div class=\"bg-white py-2 collapse-inner rounded\">\r\n");
      out.write("            <h6 class=\"collapse-header\">Custom Utilities:</h6>\r\n");
      out.write("            <a class=\"collapse-item\" href=\"/hiapt/views/ex/utilities-color.html\">Colors</a>\r\n");
      out.write("            <a class=\"collapse-item\" href=\"/hiapt/views/ex/utilities-border.html\">Borders</a>\r\n");
      out.write("            <a class=\"collapse-item\" href=\"/hiapt/views/ex/utilities-animation.html\">Animations</a>\r\n");
      out.write("            <a class=\"collapse-item\" href=\"/hiapt/views/ex/utilities-other.html\">Other</a>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </li>\r\n");
      out.write("<!--page 시작(삭제용) -->\r\n");
      out.write("<hr class=\"sidebar-divider\">\r\n");
      out.write("\t\t\t<!-- Nav Item - Pages Collapse Menu -->\r\n");
      out.write("\t\t\t<li class=\"nav-item\"><a class=\"nav-link collapsed\" href=\"#\"\r\n");
      out.write("\t\t\t\tdata-toggle=\"collapse\" data-target=\"#page\"\r\n");
      out.write("\t\t\t\taria-expanded=\"true\" aria-controls=\"collapsePages\"> <i\r\n");
      out.write("\t\t\t\t\tclass=\"fas fa-fw fa-folder\"></i> <span>Pages</span>\r\n");
      out.write("\t\t\t</a>\r\n");
      out.write("\t\t\t\t<div id=\"page\" class=\"collapse\"\r\n");
      out.write("\t\t\t\t\taria-labelledby=\"headingPages\" data-parent=\"#accordionSidebar\">\r\n");
      out.write("\t\t\t\t\t<div class=\"bg-white py-2 collapse-inner rounded\">\r\n");
      out.write("\t\t\t\t\t\t<h6 class=\"collapse-header\">Login Screens:</h6>\r\n");
      out.write("\t\t\t\t\t\t<a class=\"collapse-item\" href=\"/hiapt/views/ex/login.html\">Login</a>\r\n");
      out.write("\t\t\t\t\t\t<a class=\"collapse-item\" href=\"/hiapt/views/ex/register.html\">Register</a>\r\n");
      out.write("\t\t\t\t\t\t<a class=\"collapse-item\"\r\n");
      out.write("\t\t\t\t\t\t\thref=\"/hiapt/views/ex/forgot-password.html\">Forgot Password</a>\r\n");
      out.write("\t\t\t\t\t\t<div class=\"collapse-divider\"></div>\r\n");
      out.write("\t\t\t\t\t\t<h6 class=\"collapse-header\">Other Pages:</h6>\r\n");
      out.write("\t\t\t\t\t\t<a class=\"collapse-item\" href=\"/hiapt/views/ex/404.html\">404\r\n");
      out.write("\t\t\t\t\t\t\tPage</a> <a class=\"collapse-item\" href=\"/hiapt/views/ex/blank.html\">Blank\r\n");
      out.write("\t\t\t\t\t\t\tPage</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("<!--page 끝 -->\r\n");
      out.write("<!-- ================================================================================= -->\r\n");
      out.write("<!-- ================================================================================= -->\r\n");
      out.write("<!-- charts 시작(삭제용) -->\t\t\r\n");
      out.write("\t\t\t<li class=\"nav-item\"><a class=\"nav-link\"\r\n");
      out.write("\t\t\t\thref=\"/hiapt/views/ex/charts.html\"> <i\r\n");
      out.write("\t\t\t\t\tclass=\"fas fa-fw fa-chart-area\"></i> <span>Charts</span></a>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Nav Item - Tables -->\r\n");
      out.write("\t\t\t<li class=\"nav-item\"><a class=\"nav-link\"\r\n");
      out.write("\t\t\t\thref=\"/hiapt/views/ex/tables.html\"> <i\r\n");
      out.write("\t\t\t\t\tclass=\"fas fa-fw fa-table\"></i> <span>Tables</span></a>\r\n");
      out.write("\t\t\t</li>\r\n");
      out.write("<!-- charts 끝 -->\r\n");
      out.write("<!-- ================================================================================= -->\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Divider -->\r\n");
      out.write("\t\t\t<hr class=\"sidebar-divider d-none d-md-block\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- Sidebar Toggler (Sidebar) -->\r\n");
      out.write("\t\t\t<div class=\"text-center d-none d-md-inline\">\r\n");
      out.write("\t\t\t\t<button class=\"rounded-circle border-0\" id=\"sidebarToggle\"></button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t</ul>\r\n");
      out.write("<!-- 왼쪽 메인 메뉴 끝 -->\r\n");
      out.write("<!-- ================================================================================= -->");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 왼쪽 메인 메뉴바 끝  --> \r\n");
      out.write("<!-- ================================================================================= -->\r\n");
      out.write("\r\n");
      out.write("<!--- 중앙 전체 큰 틀 ---------------------------------------------->\r\n");
      out.write("<!-- Content Wrapper -->\r\n");
      out.write("<div id=\"content-wrapper\" class=\"d-flex flex-column\">\r\n");
      out.write("<!-- Main Content -->\r\n");
      out.write("<div id=\"content\">\r\n");
      out.write("\r\n");
      out.write("<!-- ================================================================================= -->\r\n");
      out.write("<!---탑메뉴  시작 =================---------------------------->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- ================================================================================= -->\r\n");
      out.write("<!---탑 메뉴  시작 =================---------------------------->\r\n");
      out.write("\t\t\t\t<nav\r\n");
      out.write("\t\t\t\t\tclass=\"navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t<!-- Sidebar Toggle (Topbar) -->\r\n");
      out.write("\t\t\t\t\t<button id=\"sidebarToggleTop\"\r\n");
      out.write("\t\t\t\t\t\tclass=\"btn btn-link d-md-none rounded-circle mr-3\">\r\n");
      out.write("\t\t\t\t\t\t<i class=\"fa fa-bars\"></i>\r\n");
      out.write("\t\t\t\t\t</button>\r\n");
      out.write("<!--========================================================================================== -->\r\n");
      out.write("\r\n");
      out.write("<!--========================================================================================== -->\r\n");
      out.write("\t\t\t\t\t<!-- Topbar Navbar -->\r\n");
      out.write("\t\t\t\t\t<ul class=\"navbar-nav ml-auto\">\t\t\t\t\t\t\r\n");
      out.write("<!--========================================================================================== -->\r\n");
      out.write("\r\n");
      out.write("<!--========================================================================================== -->\r\n");
      out.write("<!--알림 아이콘 -->\r\n");
      out.write("\t\t\t\t\t\t<!-- Nav Item - Alerts -->\r\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item dropdown no-arrow mx-1\"><a\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"nav-link dropdown-toggle\" href=\"#\" id=\"alertsDropdown\"\r\n");
      out.write("\t\t\t\t\t\t\trole=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\"\r\n");
      out.write("\t\t\t\t\t\t\taria-expanded=\"false\"> <i class=\"fas fa-bell fa-fw\"></i> <!-- Counter - Alerts -->\r\n");
      out.write("\t\t\t\t\t\t\t\t<span class=\"badge badge-danger badge-counter\">3+</span>\r\n");
      out.write("\t\t\t\t\t\t</a> \r\n");
      out.write("\t\t\t\t\t\t<!-- Dropdown - Alerts -->\r\n");
      out.write("\t\t\t\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in\"\r\n");
      out.write("\t\t\t\t\t\t\t\taria-labelledby=\"alertsDropdown\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h6 class=\"dropdown-header\">알림</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a class=\"dropdown-item d-flex align-items-center\" href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"mr-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"icon-circle bg-warning\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t<i class=\"fas fa-exclamation-triangle text-white\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"small text-gray-500\">2019, 10.20</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t알림 메세지 샘플1\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</a> <a class=\"dropdown-item text-center small text-gray-500\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\thref=\"#\">알림 더 읽기</a>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t</li>\r\n");
      out.write("<!--알림 아이콘 끝-->\r\n");
      out.write("<!--========================================================================================== -->\r\n");
      out.write("<!-- 채팅 알림창   -->\r\n");
      out.write("<!--========================================================================================== -->\r\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item dropdown no-arrow mx-1\"><a\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"nav-link dropdown-toggle\" href=\"#\" id=\"messagesDropdown\"\r\n");
      out.write("\t\t\t\t\t\t\trole=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\"\r\n");
      out.write("\t\t\t\t\t\t\taria-expanded=\"false\"> <i class=\"fas fa-comment-dots fa-fw\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t<!-- Counter - Messages --> <span\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"badge badge-danger badge-counter\">7</span>\r\n");
      out.write("\t\t\t\t\t\t</a> <!-- Dropdown - Messages -->\r\n");
      out.write("\t\t\t\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in\"\r\n");
      out.write("\t\t\t\t\t\t\t\taria-labelledby=\"messagesDropdown\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<h6 class=\"dropdown-header\">채팅</h6>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a class=\"dropdown-item d-flex align-items-center\" href=\"#\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"dropdown-list-image mr-3\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<img class=\"rounded-circle\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tsrc=\"https://source.unsplash.com/fn_BT9fwg_E/60x60\" alt=\"\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"status-indicator bg-success\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"font-weight-bold\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"text-truncate\">채팅 메세지 샘플</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<div class=\"small text-gray-500\">로하 · 58m</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t\t</a> <a class=\"dropdown-item text-center small text-gray-500\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\thref=\"#\">채팅 더하기</a>\r\n");
      out.write("\t\t\t\t\t\t\t</div></li>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"topbar-divider d-none d-sm-block\"></div>\r\n");
      out.write("<!--========================================================================================== -->\r\n");
      out.write("<!-- 개인정보 창  -->\r\n");
      out.write("<!--========================================================================================== -->\r\n");
      out.write("\t\t\t\t\t\t<li class=\"nav-item dropdown no-arrow\"><a\r\n");
      out.write("\t\t\t\t\t\t\tclass=\"nav-link dropdown-toggle\" href=\"#\" id=\"userDropdown\"\r\n");
      out.write("\t\t\t\t\t\t\trole=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\"\r\n");
      out.write("\t\t\t\t\t\t\taria-expanded=\"false\"> <span\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"mr-2 d-none d-lg-inline text-gray-600 small\">직원</span> <img\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"img-profile rounded-circle\"\r\n");
      out.write("\t\t\t\t\t\t\t\tsrc=\"/hiapt/resources/images/avatar.png\">\r\n");
      out.write("\t\t\t\t\t\t</a> <!-- Dropdown - User Information -->\r\n");
      out.write("\t\t\t\t\t\t\t<div\r\n");
      out.write("\t\t\t\t\t\t\t\tclass=\"dropdown-menu dropdown-menu-right shadow animated--grow-in\"\r\n");
      out.write("\t\t\t\t\t\t\t\taria-labelledby=\"userDropdown\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<a class=\"dropdown-item\" href=\"#\"> <i\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"fas fa-user fa-sm fa-fw mr-2 text-gray-400\"></i> 개인정보\r\n");
      out.write("\t\t\t\t\t\t\t\t</a> <a class=\"dropdown-item\" href=\"#\"> <i\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"fas fa-cogs fa-sm fa-fw mr-2 text-gray-400\"></i> 설정\r\n");
      out.write("\t\t\t\t\t\t\t\t</a> <a class=\"dropdown-item\" href=\"#\"> <i\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"fas fa-list fa-sm fa-fw mr-2 text-gray-400\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\tActivity Log\r\n");
      out.write("\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"dropdown-divider\"></div>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a class=\"dropdown-item\" href=\"#\" data-toggle=\"modal\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdata-target=\"#logoutModal\"> <i\r\n");
      out.write("\t\t\t\t\t\t\t\t\tclass=\"fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400\"></i>\r\n");
      out.write("\t\t\t\t\t\t\t\t\t로그아웃\r\n");
      out.write("\t\t\t\t\t\t\t\t</a>\r\n");
      out.write("\t\t\t\t\t\t\t</div></li>\r\n");
      out.write("<!-- 개인정보 창 끝  -->\r\n");
      out.write("<!--========================================================================================== -->\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t</nav>\r\n");
      out.write("<!---탑 메뉴 끝 ------------------------------------------->\r\n");
      out.write("<!--========================================================================================== -->");
      out.write("\r\n");
      out.write("<!---탑 메뉴 끝 ------------------------------------------->\r\n");
      out.write("<!--========================================================================================== -->\r\n");
      out.write("<!-- Begin Page Content -->\r\n");
      out.write("<div class=\"container-fluid\">\r\n");
      out.write("<!-- 본문 타이틀 들어가는 부분 ---->\t\t\t\t\t\r\n");
      out.write("<!--///////본문 내용 시작 ///////-------->\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div><!-- /.container-fluid -->\t\t\t\t\r\n");
      out.write("</div><!-- End of Main Content -->\t\r\n");
      out.write("<!---//// 본문 내용 끝 ///////------------------->\r\n");
      out.write("<!-- footer 시작 -->\r\n");
      out.write("<!-- Footer ìì -->\r\n");
      out.write("\t\t\t<footer class=\"sticky-footer bg-white\">\r\n");
      out.write("\t\t\t\t<div class=\"container my-auto\">\r\n");
      out.write("\t\t\t\t\t<div class=\"copyright text-center my-auto\">\r\n");
      out.write("\t\t\t\t\t\t<span>Copyright &copy; HIAPT Website 2019</span>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</footer>\r\n");
      out.write("<!-- Footer ë -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- footer 시작 -->\r\n");
      out.write("</div>\t<!-- End of Content Wrapper -->\r\n");
      out.write("</div>\t<!-- End of Page Wrapper -->\t\r\n");
      out.write("<!--========================================================================================== -->\r\n");
      out.write("<!-- top 버튼 -->\r\n");
      out.write("<!-- top ë²í¼ -->\r\n");
      out.write("\t<!-- Scroll to Top Button-->\r\n");
      out.write("\t<a class=\"scroll-to-top rounded\" href=\"#page-top\"> \r\n");
      out.write("\t<i class=\"fas fa-angle-up\"></i>\r\n");
      out.write("\t</a>\r\n");
      out.write("<!--========================================================================================== -->");
      out.write("\r\n");
      out.write("<!--========================================================================================== -->\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
