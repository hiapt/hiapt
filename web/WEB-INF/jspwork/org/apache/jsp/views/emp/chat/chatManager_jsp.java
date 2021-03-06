/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.43
 * Generated at: 2019-11-05 06:58:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.views.emp.chat;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import employee.model.vo.Employee;
import chat.model.vo.*;
import java.util.*;

public final class chatManager_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("chat.model.vo");
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

      out.write("\r\n");
      out.write("    \r\n");

	Employee employee = (Employee)session.getAttribute("employee");
	ArrayList<ChatPerson> clist = (ArrayList<ChatPerson>)request.getAttribute("clist");
	ArrayList<ChatRoomPerson> crplist = (ArrayList<ChatRoomPerson>)request.getAttribute("crplist");
	ArrayList<ChatMessage> cmlist = (ArrayList<ChatMessage>)request.getAttribute("cmlist");
	ArrayList<int[]> crpCountlist = (ArrayList<int[]>)request.getAttribute("crpCountlist");

      out.write("\r\n");
      out.write("  \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>chatting</title>\r\n");
      out.write("\r\n");
      out.write("<!-- Custom fonts for this template-->\r\n");
      out.write("\t<link href=\"/hiapt/resources/vendor/fontawesome-free/css/all.min.css\"\r\n");
      out.write("\trel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- Custom styles for this template-->\r\n");
      out.write("\t<link href=\"/hiapt/resources/css/sb-admin-2.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\t<link href=\"/hiapt/resources/css/basic.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("<!-- Bootstrap core JavaScript-->\r\n");
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
      out.write("\t\r\n");
      out.write("<script type=\"text/javascript\" src=\"/hiapt/resources/js/jquery-3.4.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("/* 채팅 네비 전환 */\r\n");
      out.write("function viewbcp(){\r\n");
      out.write("\tvar chatPerson = document.getElementById(\"chatperson\");\r\n");
      out.write("\tvar chatRooms = document.getElementById(\"chatrooms\");\r\n");
      out.write("\tchatRooms.style.display=\"none\";\r\n");
      out.write("\tchatPerson.style.display=\"\";\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("function viewbcr(){\r\n");
      out.write("\tvar chatPerson = document.getElementById(\"chatperson\");\r\n");
      out.write("\tvar chatRooms = document.getElementById(\"chatrooms\");\r\n");
      out.write("\tchatPerson.style.display=\"none\";\r\n");
      out.write("\tchatRooms.style.display=\"\";\r\n");
      out.write("}\r\n");
      out.write("/* 채팅view */\r\n");
      out.write("/* 켜자마자 웹소켓연결 */\r\n");
      out.write(" webSocket = null;\r\n");
      out.write("$(function(){\r\n");
      out.write("\t webSocket = new WebSocket(\"ws://localhost:12080/hiapt/ChatController\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t/* url/path/mapping */\t\t\r\n");
      out.write("\tempNo = \"");
      out.print( employee.getEmpNo() );
      out.write("\";\t\t\t\t\t\t\t\t\r\n");
      out.write("\twebSocket.onopen = function(event){\r\n");
      out.write("\t\tconsole.log(\"웹소켓 연결됨\");\r\n");
      out.write("\t\twebSocket.send(\"online:\"+empNo);\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("\twebSocket.onclose = function(event){\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("\twebSocket.onerror = function(event){\r\n");
      out.write("\t\tconsols.log(event);\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("\twebSocket.onmessage = function(event){\r\n");
      out.write("\t\tonMessage(event);\r\n");
      out.write("\t};\r\n");
      out.write("});\r\n");
      out.write("\r\n");
      out.write("function SocketClose(){\r\n");
      out.write("\twebSocket.close();\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("function onMessage(event){\r\n");
      out.write("\t\r\n");
      out.write("\tvar elist = event.data.split(\",\");\r\n");
      out.write("\tif(elist[0]==\"empno\"){//온라인오프라인표시할때\r\n");
      out.write("\tvar onOff=document.getElementsByClassName(\"onoff\");\r\n");
      out.write("\r\n");
      out.write("\tfor(var i=0; i<onOff.length; i++){\r\n");
      out.write("\t\tonOff[i].innerHTML='&nbsp;&nbsp;&nbsp;<i class=\"fas fa-user-slash fa-2x\"></i>';\r\n");
      out.write("\t}\r\n");
      out.write("\tfor(var i=1; i<elist.length; i++){\r\n");
      out.write("\t\tvar empno = elist[i];\r\n");
      out.write("\t\tvar obj=document.getElementById(\"on\"+empno);\r\n");
      out.write("\t\tif(obj!=null)\r\n");
      out.write("\t\t obj.innerHTML ='&nbsp;&nbsp;&nbsp;<i class=\"fas fa-user fa-2x\"></i>';\r\n");
      out.write("\t}\r\n");
      out.write("\t}//온라인오프라인표시할때\r\n");
      out.write("\telse if(elist[0]==\"rout\"){//방에서 나갈때(목록제외)\r\n");
      out.write("\t\tvar roomOutlist = document.getElementById(elist[2]);\r\n");
      out.write("\t\troomOutlist.remove();\t\r\n");
      out.write("\t\r\n");
      out.write("\t}//방에서 나갈때(목록제외)\r\n");
      out.write("\telse if(elist[0]==\"newRoom\"){//새로운방일경우\r\n");
      out.write("\t\topenOldRoom(elist[1]);\r\n");
      out.write("\t}//새로운방일경우 chatno부여\r\n");
      out.write("\telse{//메세지가와서 목록최신화시킬떄..\r\n");
      out.write("\t\tvar cetcm = event.data.split(\",\");\r\n");
      out.write("\t\tvar chatn = cetcm[0];\r\n");
      out.write("\t\tvar empn = cetcm[1];\r\n");
      out.write("\t\tvar ctitle = cetcm[2];\r\n");
      out.write("\t\tvar chatCount = cetcm[3];\r\n");
      out.write("\t\tvar chatMessage = cetcm[4];\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar listDiv = document.getElementById(chatn);\r\n");
      out.write("\t\tif(listDiv!=null){\r\n");
      out.write("\t\tlistDiv.remove();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t var startdiv = \"<div id='\"+chatn+\"' class='dropdown'><div style='padding: 5px'></div>\";\r\n");
      out.write("\t\t var button = \"&nbsp;<button style='background-color:gray' class='btn btn-primary' type='button' id='dropdownMenuButton' data-toggle='dropdown' aria-haspopup='true' aria-expanded='false'>\";\r\n");
      out.write("\t\t var chatTitle = \"<div  class='dropdown-toggle' id='chatTitle\"+chatn+\"'>\"+ctitle+\"</div></button>&nbsp;&nbsp;\";\r\n");
      out.write("\t\t var chatCount1 = chatCount+\"명<br>\";\r\n");
      out.write("\t\t var chatContent = \"&nbsp;<span>\"+chatMessage+\"</span>\";\r\n");
      out.write("\t\t var buttonDropDown1 = \"<div class='dropdown-menu' aria-labelledby='dropdownMenuButton'>\"+\"<a class='dropdown-item' href='#' onclick='openOldRoom(\"+chatn+\")'>대화방 참여</a>\";\r\n");
      out.write("\t\t var buttonDropDown2 = \"<a class='dropdown-item' href='#' onclick='changeRoomTitle(\"+chatn+\",chatTitle\"+chatn+\");'>방제목 변경</a></div></dvi>\";\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t $('#chatrooms').prepend(startdiv+button+chatTitle+chatCount1+chatContent+buttonDropDown1+buttonDropDown2);\r\n");
      out.write("\t\t \r\n");
      out.write("\t}\r\n");
      out.write("\treturn false;\r\n");
      out.write("};\r\n");
      out.write("\r\n");
      out.write("function openProFile(empno2){\r\n");
      out.write("\tvar empNo2;\r\n");
      out.write("\tif(typeof(empno2)===\"number\")\r\n");
      out.write("\tempNo2 = empno2;\r\n");
      out.write("\telse\r\n");
      out.write("\tempNo2 = empno2.value;\r\n");
      out.write("\t\r\n");
      out.write("\twindow.open(\"/hiapt/ch.profile?empno2=\"+empNo2,empNo2,\"width=430,height=300\"); \r\n");
      out.write("\treturn false;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function openNewRoom(empno2){\r\n");
      out.write("\tvar empNo2;\r\n");
      out.write("\tif(typeof(empno2)===\"number\")\r\n");
      out.write("\tempNo2 = empno2;\r\n");
      out.write("\telse\r\n");
      out.write("\tempNo2 = empno2.value;\r\n");
      out.write("\t\r\n");
      out.write("\twebSocket.send(\"newRoom,\"+empNo+\",\"+empNo2);\r\n");
      out.write("\treturn false;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function openOldRoom(chatno){\r\n");
      out.write("\tvar chatNo = chatno;\r\n");
      out.write("\twindow.open(\"/hiapt/ch.message?empno=\"+empNo+\"&chatno=\"+chatNo,chatNo,\"width=600,height=380\");\r\n");
      out.write("\treturn false;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function changeRoomTitle(chatno,chattitle){\r\n");
      out.write("\tvar chatNo = chatno;\r\n");
      out.write("\tvar roomTitle = prompt('바꾸실 방제목을 입력해주세요','');\r\n");
      out.write("\tif(31<roomTitle.length){\r\n");
      out.write("\t\talert('제목 변경은 30글자 이내에서만 가능합니다.')\r\n");
      out.write("\t\treturn false;\r\n");
      out.write("\t}\r\n");
      out.write("\tif(roomTitle!=\"\"&&roomTitle!=null){\r\n");
      out.write("\tvar crt = \"crt:\"+chatNo+\":\"+empNo+\":\"+roomTitle;\r\n");
      out.write("\twebSocket.send(crt);\r\n");
      out.write("\tchattitle.innerText=roomTitle;\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\talert(\"제목을 입력하셔야합니다\");\r\n");
      out.write("\t}\r\n");
      out.write("\treturn false;\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body onunload=\"SocketClose();\">\r\n");
      out.write("<br>\r\n");
      out.write("<nav>\t<div align=\"center\">\r\n");
      out.write("\t<button style=\"background-color:#849ada\" class=\"btn btn-primary\" id=\"bcp\" onclick=\"viewbcp();\">친구 목록</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\t<button style=\"background-color:#849ada\" class=\"btn btn-primary\" id=\"bcr\" onclick=\"viewbcr();\">채팅 목록</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("</nav>\r\n");
      out.write("\t<section>\r\n");
      out.write("\t\t<div id=\"chatperson\" style=\"display:\"><!-- 친구목록 -->\r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t<h3 style=\"display:inline\" style=\"color: blue\">\r\n");
      out.write("\t\t\t\t&nbsp;<strong>");
      out.print(employee.getEmpName());
      out.write("(나)</strong> \r\n");
      out.write("\t\t\t</h3> &nbsp;&nbsp;<i class=\"fas fa-user fa-2x\"></i>\r\n");
      out.write("\t\t\t");
for (ChatPerson cp : clist) {	
      out.write("\r\n");
      out.write("\t\t\t<div class=\"dropdown\">\r\n");
      out.write("\t\t\t\t<input type=\"hidden\" id=\"");
      out.print( cp.getEmpNo() );
      out.write("\" value=\"");
      out.print(cp.getEmpNo());
      out.write("\">\r\n");
      out.write("\t\t\t\t<div style=\"padding: 5px\"></div>\r\n");
      out.write("\t\t\t\t&nbsp;<button style=\"background-color:gray\" class=\"btn btn-primary dropdown-toggle\" type=\"button\"\r\n");
      out.write("\t\t\t\t\tid=\"dropdownMenuButton\" data-toggle=\"dropdown\" aria-haspopup=\"true\"\r\n");
      out.write("\t\t\t\t\taria-expanded=\"false\">\t");
      out.print(cp.getEmpName());
      out.write("\r\n");
      out.write("\t\t\t\t</button><span class=\"onoff\" id=\"on");
      out.print(cp.getEmpNo());
      out.write("\"></span>\r\n");
      out.write("\t\t\t\t<div class=\"dropdown-menu\" aria-labelledby=\"dropdownMenuButton\">\r\n");
      out.write("\t\t\t\t\t<a class=\"dropdown-item\" href=\"#\" onclick=\"openNewRoom(");
      out.print(cp.getEmpNo());
      out.write(");\">1:1대화</a> <a\r\n");
      out.write("\t\t\t\t\t   class=\"dropdown-item\" href=\"#\" onclick=\"openProFile(");
      out.print(cp.getEmpNo());
      out.write(");\">프로필보기</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t");
 } 
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"chatrooms\" style=\"display: none\"><!-- 채팅방목록 -->\r\n");
      out.write("\t\t\t\t");
for(ChatMessage cm : cmlist){
      out.write("\r\n");
      out.write("\t\t\t\t<div id=\"");
      out.print( cm.getChatNo() );
      out.write("\" class=\"dropdown\">\r\n");
      out.write("\t\t\t\t\t<div style=\"padding: 5px\"></div>\r\n");
      out.write("\t\t\t\t\t&nbsp;<button style=\"background-color:gray\" class=\"btn btn-primary\" type=\"button\"\r\n");
      out.write("\t\t\t\t\tid=\"dropdownMenuButton\" data-toggle=\"dropdown\" aria-haspopup=\"true\"\r\n");
      out.write("\t\t\t\t\taria-expanded=\"false\">\r\n");
      out.write("\t\t\t\t\t\t");
for(ChatRoomPerson crp : crplist) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t");
if(cm.getChatNo()==crp.getChatNo() ) {
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<div class=\"dropdown-toggle\" id=\"chatTitle");
      out.print( crp.getChatNo() );
      out.write('"');
      out.write('>');
      out.print( crp.getChatTitle() );
      out.write("</div><!-- 채팅방제목 -->\r\n");
      out.write("\t\t\t\t\t\t");
}} 
      out.write("\r\n");
      out.write("\t\t\t\t\t</button>&nbsp;&nbsp;\r\n");
      out.write("\t\t\t\t\t\t");
for(int[] crpCount : crpCountlist) {
      out.write("<!-- 채팅인원 -->\r\n");
      out.write("\t\t\t\t\t\t");
if(crpCount[0] == cm.getChatNo()){ 
      out.write("<!-- crpcount0은 챗넘버에 1은 인원수 -->\r\n");
      out.write("\t\t\t\t\t\t");
      out.print( crpCount[1] );
      out.write("명\r\n");
      out.write("\t\t\t\t\t\t");
}} 
      out.write("<br>\r\n");
      out.write("\t\t\t\t&nbsp;<span>");
      out.print( cm.getEmpName() );
      out.write(':');
      out.print( cm.getChatContents() );
      out.write("</span>\r\n");
      out.write("\t\t\t\t<div class=\"dropdown-menu\" aria-labelledby=\"dropdownMenuButton\">\r\n");
      out.write("\t\t\t\t\t<a class=\"dropdown-item\" href=\"#\" onclick=\"openOldRoom(");
      out.print( cm.getChatNo() );
      out.write(")\">대화방 참여</a>\r\n");
      out.write("\t\t\t\t\t<a class=\"dropdown-item\" href=\"#\" onclick=\"changeRoomTitle(");
      out.print( cm.getChatNo() );
      out.write(",chatTitle");
      out.print( cm.getChatNo() );
      out.write(");\">방제목 변경</a>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t</section>\r\n");
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
