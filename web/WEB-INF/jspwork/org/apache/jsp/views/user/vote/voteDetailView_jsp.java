/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.43
 * Generated at: 2019-10-21 07:06:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.user.vote;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import aptuser.model.vo.Aptuser;
import vote.model.vo.Vote;
import java.util.*;
import java.text.*;
import vote.model.vo.VoteResult;
import aptuser.model.vo.Aptuser;

public final class voteDetailView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/views/user/vote/../userheader.jsp", Long.valueOf(1571641317481L));
    _jspx_dependants.put("/views/user/vote/../userfooter.jsp", Long.valueOf(1571394835154L));
    _jspx_dependants.put("/views/user/vote/../userhead.html", Long.valueOf(1571394839378L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("java.text");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("aptuser.model.vo.Aptuser");
    _jspx_imports_classes.add("vote.model.vo.VoteResult");
    _jspx_imports_classes.add("vote.model.vo.Vote");
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

	Vote vote = (Vote) request.getAttribute("vote");
	String vote1 = vote.getVoteOne();
	String vote2 = vote.getVoteTwo();
	String vote3 = vote.getVoteThree();
	String vote4 = vote.getVoteFour();
	String vote5 = vote.getVoteFive();
	String voteName[] = {vote1, vote2, vote3, vote4, vote5};

	VoteResult voteResult = (VoteResult) request.getAttribute("voteresult");
	int voteResultName[] = {voteResult.getVoteOneResult(), voteResult.getVoteTwoResult(),
			voteResult.getVoteThreeResult(), voteResult.getVoteFourResult(), voteResult.getVoteFiveResult()};

      out.write('\r');
      out.write('\n');

	Date date = new Date();
	SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
	String sysdate = simpleDate.format(date);
	Date today = simpleDate.parse(sysdate);

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<!-- head 시작  -->\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <title>HiAPTU</title>\r\n");
      out.write("  <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\r\n");
      out.write("  <meta content=\"\" name=\"keywords\">\r\n");
      out.write("  <meta content=\"\" name=\"description\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Favicons -->\r\n");
      out.write(" <!--  <link href=\"img/favicon.png\" rel=\"icon\"> -->\r\n");
      out.write("\r\n");
      out.write("  <!-- Google Fonts -->\r\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css?family=Ruda:400,900,700\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Bootstrap CSS File -->\r\n");
      out.write("  <link href=\"/hiapt/resources/css/bootstrap.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Libraries CSS Files -->\r\n");
      out.write("  <link\r\n");
      out.write("\thref=\"http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css\"\r\n");
      out.write("\trel=\"stylesheet\">\r\n");
      out.write("  <link href=\"/hiapt/resources/css/prettyphoto.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"/hiapt/resources/css/hoverex-all.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"/hiapt/resources/css/jetmenu.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"/hiapt/resources/css/owl-carousel.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Main Stylesheet File -->\r\n");
      out.write("  <link href=\"/hiapt/resources/css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"/hiapt/resources/css/blue.css\">\r\n");
      out.write("\r\n");
      out.write("</head>");
      out.write("\r\n");
      out.write("<!-- head 끝  -->\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- navi 시작  -->\r\n");
      out.write("\t");
      out.write('\r');
      out.write('\n');

   Aptuser aptuser = (Aptuser)session.getAttribute("aptuser");

      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"topbar clearfix\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <div class=\"col-lg-12 text-right\">\r\n");
      out.write("        <div class=\"social_buttons\">\r\n");
      out.write("          \r\n");
      out.write("          <span style=\"width:66px;padding: 16px;font-size: 16px;\">");
      out.print( aptuser.getUserName() );
      out.write("</span>\r\n");
      out.write("          <span class=\"at_bar\">|</span><a href=\"/hiapt/uout\">로그아웃 </a>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- end container -->\r\n");
      out.write("  </div>\r\n");
      out.write("  <!-- end topbar -->\r\n");
      out.write("\r\n");
      out.write("  <header class=\"header\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <div class=\"site-header clearfix\">\r\n");
      out.write("        <div class=\"col-lg-3 col-md-3 col-sm-12 title-area\">\r\n");
      out.write("          <div class=\"site-title\" id=\"title\">\r\n");
      out.write("            <a href=\"/hiapt/login.jsp\" title=\"\">\r\n");
      out.write("              <h2>Hi<span>APT</span></h2>\r\n");
      out.write("            </a>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- title area -->\r\n");
      out.write("        <div class=\"col-lg-9 col-md-12 col-sm-12\">\r\n");
      out.write("          <div id=\"nav\" class=\"right\">\r\n");
      out.write("            <div class=\"container clearfix\">\r\n");
      out.write("              <ul id=\"jetmenu\" class=\"jetmenu blue\">\r\n");
      out.write("                <!--li class=\"active\"><a href=\"index.html\">Home</a>\r\n");
      out.write("                </li-->\r\n");
      out.write("                <li><a href=\"#\">샘플들</a>\r\n");
      out.write("                   <ul class=\"dropdown\">\r\n");
      out.write("                    <li><a href=\"/hiapt/views/user/sample/contact.html\">샘플1</a></li>\r\n");
      out.write("                    <li><a href=\"/hiapt/views/user/sample/sample.html\">샘플2</a></li>\r\n");
      out.write("                    <li><a href=\"/hiapt/views/user/sample/404.html\">샘플3</a></li>\r\n");
      out.write("                    <li><a href=\"/hiapt/views/user/sample/about.html\">샘플4</a></li>  \r\n");
      out.write("                    <li><a href=\"/hiapt/views/user/sample/service.html\">샘플5</a></li>\r\n");
      out.write("                    <li><a href=\"/hiapt/views/user/sample/support.html\">샘플6</a></li>  \r\n");
      out.write("                    <li><a href=\"/hiapt/views/user/sample/testimonials.html\">샘플7</a></li>\r\n");
      out.write("                    <li><a href=\"/hiapt/views/user/sample/fullwidth.html\">샘플8</a></li>                      \r\n");
      out.write("                  </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a href=\"#\">관리비조회</a>\r\n");
      out.write("                   <ul class=\"dropdown\">                    \r\n");
      out.write("                    <li><a href=\"/hiapt/views/user/maintenance/BillList.jsp\">관리비조회</a></li>\r\n");
      out.write("                    <li><a href=\"/hiapt/views/user/maintenance/ReceiptList.jsp\">납부내역조회</a></li>                   \r\n");
      out.write("                  </ul>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a href=\"#\">관리비결제</a></li>\r\n");
      out.write("                <li><a href=\"#\">민원접수</a></li>\r\n");
      out.write("                <li><a href=\"#\">공지사항</a></li>\r\n");
      out.write("                <li><a href=\"/hiapt/vo.list\">주민투표</a></li>\r\n");
      out.write("                <li><a href=\"/hiapt/bo.list\">자유게시판</a></li>\r\n");
      out.write("              </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <!-- nav -->\r\n");
      out.write("        </div>\r\n");
      out.write("        <!-- title area -->\r\n");
      out.write("      </div>\r\n");
      out.write("      <!-- site header -->\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- end container -->\r\n");
      out.write("  </header>\r\n");
      out.write("  <!-- end header -->\r\n");
      out.write("  <!-- 세대주 머리부분 공통부분 복사해서 쓰세요 끝 =============================================================================== -->");
      out.write("\r\n");
      out.write("\t<!-- navi 끝  -->\r\n");
      out.write("\r\n");
      out.write("\t<!-- /// 본문 시작////// -->\r\n");
      out.write("\t<!-- 본문 제목 타이틀 부분 복사 시작 ===================================================================================-->\r\n");
      out.write("\t<section class=\"post-wrapper-top\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t\t\t<div class=\"col-lg-6 col-md-6 col-sm-6 col-xs-12\">\r\n");
      out.write("\t\t\t\t<ul class=\"breadcrumb\">\r\n");
      out.write("\t\t\t\t\t<li><a href=\"index2.jsp\">Home</a></li>\r\n");
      out.write("\t\t\t\t\t<li>주민투표</li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<h2>주민투표 조회</h2>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\t<!-- end post-wrapper-top -->\r\n");
      out.write("\t<!-- 본문 타이틀 복사 끝 ======================================================================================================-->\r\n");
      out.write("\r\n");
      out.write("\t<script type=\"text/javascript\"\r\n");
      out.write("\t\tsrc=\"/hiapt/resources/js/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\tvar userId =\"");
      out.print(aptuser.getUserId());
      out.write("\";\r\n");
      out.write("\t\t\tvar vSecret =\"");
      out.print( vote.getVoteSecret() );
      out.write("\";\r\n");
      out.write("\t\t\tvar count = 0;\r\n");
      out.write("\t");
for (int i = 0; i < voteName.length; i++) {
				if (voteName[i] != null) {
      out.write("\r\n");
      out.write("\t\tcount++;\r\n");
      out.write("\t");
}}
      out.write("\r\n");
      out.write("\t\t$(\"#vbutton\").click(function() {\r\n");
      out.write("\t\t\t\tvar voteCheck = $(\":input[name=voteresult]:checked\").val();\r\n");
      out.write("\t\t\t\tif (voteCheck != null) {\r\n");
      out.write("\t\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\t\turl : \"vo.vrUpdate\",\r\n");
      out.write("\t\t\t\t\t\tdata : {\r\n");
      out.write("\t\t\t\t\t\t\tvoteresult : voteCheck,\r\n");
      out.write("\t\t\t\t\t\t\tvsecret : vSecret, \r\n");
      out.write("\t\t\t\t\t\t\tvoteno :");
      out.print(vote.getVoteNo());
      out.write(",\r\n");
      out.write("\t\t\t\t\t\t\tuserid : userId\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\t\t\t\tdataType : \"json\",\r\n");
      out.write("\t\t\t\t\t\tsuccess : function(data) {\r\n");
      out.write("\t\t\t\t\t\t\tvar v1 = data.vre1;\r\n");
      out.write("\t\t\t\t\t\t\tvar v2 = data.vre2;\r\n");
      out.write("\t\t\t\t\t\t\tvar v3 = data.vre3;\r\n");
      out.write("\t\t\t\t\t\t\tvar v4 = data.vre4;\r\n");
      out.write("\t\t\t\t\t\t\tvar v5 = data.vre5;\r\n");
      out.write("\t\t\t\t\t\t\tvar vrcount = [ v1, v2, v3, v4, v5 ];\r\n");
      out.write("\t\t\t\t\t\t\tvar dcheck = data.dcheck;\r\n");
      out.write("\t\t\t\t\t\t\tif (dcheck == 1)\r\n");
      out.write("\t\t\t\t\t\t\t\talert(\"이미 투표하셨습니다\");\r\n");
      out.write("\t\t\t\t\t\t\telse\r\n");
      out.write("\t\t\t\t\t\t\t\talert(\"투표가 완료되었습니다\");\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\tfor (var i = 0; i < count; i++) {\r\n");
      out.write("\t\t\t\t\t\t\t\t$(\"#\" + i + \"\").text(vrcount[i]);\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\t\terror : function(jqXHR, textStatus, errorThrown) {\r\n");
      out.write("\t\t\t\t\t\t\tconsole.log(\"error : \" + textStatus);\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t});//아이작스\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\talert(\"투표 체크를 하십시오.\")\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t\treturn false;\r\n");
      out.write("\t\t\t});//클릭\r\n");
      out.write("\t\t});//펑션\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("\t<section class=\"section1\">\r\n");
      out.write("\t\t<div class=\"container clearfix\">\r\n");
      out.write("\r\n");
      out.write("\t\t\t<table class=\"table table-bordered\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th style=\"text-align: center\" width=\"300\">제목</th>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align: center\">");
      out.print(vote.getVoteTitle());
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th style=\"text-align: center\">작성자</th>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align: center\">");
      out.print(vote.getVoteWrite());
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th style=\"text-align: center\">작성 날짜</th>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align: center\">");
      out.print(vote.getVoteDate());
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th style=\"text-align: center\">조회수</th>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align: center\">");
      out.print(vote.getVoteReadCount());
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th style=\"text-align: center\">내용</th>\r\n");
      out.write("\t\t\t\t\t<td style=\"text-align: center\">");
      out.print(vote.getVoteContents());
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t</table>\r\n");
      out.write("\r\n");
      out.write("\t\t\t");

				if (vote.getVoteFinalDate().compareTo(today) >= 0) {
			
      out.write("<!-- 투표진행중 -->\r\n");
      out.write("\t\t\t<table class=\"table table-bordered\">\r\n");
      out.write("\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t<th style=\"text-align: center\" width=\"300\">투표 목록</th>\r\n");
      out.write("\t\t\t\t\t<th style=\"text-align: center\">투표결과(확인)</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

					for (int i = 0; i < 5; i++) {
							if (voteName[i] == null)
								break;
				
      out.write("<tr>\r\n");
      out.write("\t\t\t\t\t<th style=\"text-align: center\"><input type=\"radio\"\r\n");
      out.write("\t\t\t\t\t\tname=\"voteresult\" value=\"");
      out.print(i + 1);
      out.write("\" required>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(i + 1);
      out.write(' ');
      out.write(':');
      out.write(' ');
      out.print(voteName[i]);
      out.write("</th>\r\n");
      out.write("\t\t\t\t\t<td id=\"");
      out.print(i);
      out.write("\" style=\"text-align: center\"></td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t<div align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t<button id=\"vbutton\">확인</button>&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t<button onclick=\"javascript:window.history.go(-1);\">목록</button>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t");

					} else {
				
      out.write("<!-- 투표마감시보여질 화면 -->\r\n");
      out.write("\t\t\t\t<h3 align=\"center\">투표가 마감되었습니다.</h3>\r\n");
      out.write("\t\t\t\t<table class=\"table table-bordered\">\r\n");
      out.write("\t\t\t\t<tr >\r\n");
      out.write("\t\t\t\t\t<th style=\"text-align: center\" width=\"300\">투표 목록</th>\r\n");
      out.write("\t\t\t\t\t<th style=\"text-align: center\">투표 결과</th>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");

					for (int i = 0; i < 5; i++) {
							if (voteName[i] == null)
								break;
				
      out.write("<tr align=\"center\">\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(i + 1);
      out.write(' ');
      out.write(':');
      out.write(' ');
      out.print(voteName[i]);
      out.write("</td>\r\n");
      out.write("\t\t\t\t\t<td>");
      out.print(voteResultName[i]);
      out.write("</td>\r\n");
      out.write("\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t");
}	}
      out.write("\r\n");
      out.write("\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t<div align=\"right\">\r\n");
      out.write("\t\t\t\t<button onclick=\"javascript:window.history.go(-1);\">목록</button>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</section>\r\n");
      out.write("\r\n");
      out.write("\t<!--  /// 본문 끝//////  -->\r\n");
      out.write("\t<!-- footer 시작 -->\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- 세대주 아래 공통부분 복사해서 쓰세요 시작 =============================================================================== --> \r\n");
      out.write("  <footer class=\"footer\">\r\n");
      out.write("    <div class=\"container\">  \r\n");
      out.write("    <ul class=\"footer-menu\">\r\n");
      out.write("      <li class=\"ma-1\"><a href=\"#\"> 회사소개 </a></li>\r\n");
      out.write("      <li><span class=\"at_bar\">|</span><a href=\"#\"> 이용약관 </a></li>\r\n");
      out.write("      <li><span class=\"at_bar\">|</span><a href=\"#\"> 개인정보처리방침 </a></li>\r\n");
      out.write("      <li><span class=\"at_bar\">|</span> Copyright &copy; 2019 - All rights reserved.</li>\r\n");
      out.write("    </ul>    \r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- end container -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  </footer>\r\n");
      out.write("  <!-- end footer -->\r\n");
      out.write("  <div class=\"dmtop\">Scroll to Top</div>\r\n");
      out.write(" \r\n");
      out.write("  <!-- JavaScript Libraries -->\r\n");
      out.write("  <script src=\"/hiapt/resources/js/jquery.min.js\"></script>\r\n");
      out.write("  <script src=\"/hiapt/resources/js/bootstrap.min.js\"></script>\r\n");
      out.write("  <script src=\"/hiapt/resources/js/prettyphoto.js\"></script>\r\n");
      out.write("  <script src=\"/hiapt/resources/js/hoverdir.js\"></script>\r\n");
      out.write("  <script src=\"/hiapt/resources/js/jetmenu.js\"></script>\r\n");
      out.write("\r\n");
      out.write("  <!-- Template Main Javascript File -->\r\n");
      out.write("  <script src=\"/hiapt/resources/js/main.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("\t<!-- footer 끝  -->\r\n");
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
