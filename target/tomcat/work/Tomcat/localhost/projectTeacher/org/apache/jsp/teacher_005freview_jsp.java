/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2022-07-20 06:52:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class teacher_005freview_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

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


	String path = request.getContextPath();

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"css/teacher.css\">\r\n");
      out.write("<title></title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"content\">\r\n");
      out.write("\t\t<div class=\"center\">\r\n");
      out.write("\t\t\t<div class=\"projectDescription\">\r\n");
      out.write("\t\t\t\t<h4 class=\"description\">??????????????????:</h4>\r\n");
      out.write("\t\t\t\t<p class=\"description\" id=\"content\"></p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"bottom\">\r\n");
      out.write("\t\t\t<div class=\"bottom-left\">\r\n");
      out.write("\t\t\t\t<div class=\"bottom-left-top\">\r\n");
      out.write("\t\t\t\t\t<h3 class=\"teamText\">?????????????????????</h3>\r\n");
      out.write("\t\t\t\t\t<ul class=\"teams\" id=\"teams\">\r\n");
      out.write("\t\t\t\t\t<!-- \r\n");
      out.write("\t\t\t\t\t<li class=\"team selected\">???1???</li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"team\">???2???</li>\r\n");
      out.write("\t\t\t\t\t -->\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"bottom-right\">\r\n");
      out.write("\t\t\t\t<div class=\"bottom-right-top\">\r\n");
      out.write("\t\t\t\t\t<p class=\"reportText\">?????????????????????</p>\r\n");
      out.write("\t\t\t\t\t<p class=\"report\" id=\"report\"></p>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"bottom-right-bottom\">\r\n");
      out.write("\t\t\t\t\t<div>\r\n");
      out.write("\t\t\t\t\t\t<form action=\"");
      out.print(path );
      out.write("/ReviewSaveServlet\" method=\"post\"\r\n");
      out.write("\t\t\t\t\t\t\ttarget=\"frameName\">\r\n");
      out.write("\t\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"reviews\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p class=\"label\">???&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp??????\r\n");
      out.write("\t\t\t\t\t\t\t\t<input class=\"input score\" placeholder=\"??????????????????(0~100)\" name=\"score\" id=\"score\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p class=\"scores-alert\" id=\"scores-alert\" style=\"display: none\">?????????0~100?????????</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t</p> \r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"reviews\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"label\">???????????????&nbsp</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<textarea class=\"review\" placeholder=\"??????????????????\" name=\"review\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tid=\"review\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<input name=\"project_pid\" style=\"display: none\" id=\"project_pid\">\r\n");
      out.write("\t\t\t\t\t\t\t<input name=\"teacher_uid\" style=\"display: none\" id=\"teacher_uid\">\r\n");
      out.write("\t\t\t\t\t\t\t<input value=\"1\" name=\"team_tid\" style=\"display: none\"\r\n");
      out.write("\t\t\t\t\t\t\t\tid=\"team_tid\"> <input value=\"1\" name=\"status\"\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"display: none\" id=\"status\"> <br> <br>\r\n");
      out.write("\t\t\t\t\t\t\t<div align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"submit\" class=\"button bg-main icon-check-square-o\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tvalue=\"??????\" id=\"temp-button\" name=\"temp\"> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttype=\"submit\" class=\"button bg-main icon-check-square-o\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tvalue=\"??????\" id=\"submit-button\" name=\"submit\">\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t</form>\r\n");
      out.write("\t\t\t\t\t\t<iframe src=\"\" frameborder=\"0\" name=\"frameName\" height=\"0px\"></iframe>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<script src=\"js/axios-0.18.0.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t//????????????????????????\r\n");
      out.write("\t\tonload = function() {\r\n");
      out.write("\t\t\tlet a=new Array()\r\n");
      out.write("\t\t\ta[5]=1\r\n");
      out.write("\r\n");
      out.write("\t\t\t// alert(a.length)\r\n");
      out.write("\t\t\t//?????????????????????0~100?????????????????????????????????\r\n");
      out.write("\t\t\tdocument.getElementById(\"score\").onblur = function() {\r\n");
      out.write("\t\t\t\tlet inputScore = document.getElementById(\"score\").value;\r\n");
      out.write("\t\t\t\tif (inputScore >= 1 && inputScore <= 100) {\r\n");
      out.write("\t\t\t\t\tdocument.getElementById(\"scores-alert\").style.display = 'none';\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\tdocument.getElementById(\"scores-alert\").style.display = '';\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t//??????url??????????????????\r\n");
      out.write("\t\t\tlet url = window.location.search;//??????url???\"?\"???????????????\r\n");
      out.write("\t\t\t//???????????????url??????project_pid???teacher_uid\r\n");
      out.write("\t\t\tlet pid_index = url.indexOf(\"project_pid\");\r\n");
      out.write("\t\t\tlet tid_index = url.indexOf(\"teacher_uid\");\r\n");
      out.write("\t\t\tlet project_pid = url.substring(pid_index + 12, pid_index + 13);\r\n");
      out.write("\t\t\tlet teacher_uid = url.substring(tid_index + 12, tid_index + 13);\r\n");
      out.write("\t\t\t//??????form????????????project_pid??????\r\n");
      out.write("\t\t\tdocument.getElementById(\"project_pid\").value = project_pid;\r\n");
      out.write("\t\t\tdocument.getElementById(\"teacher_uid\").value = teacher_uid;\r\n");
      out.write("\t\t\tlet scores = new Array();//?????????????????????\r\n");
      out.write("\t\t\tlet reviews = new Array();//???????????????????????????\r\n");
      out.write("\t\t\t//????????????????????????????????????,????????????scores???reviews\r\n");
      out.write("\t\t\taxios(\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\tmethod : \"get\",\r\n");
      out.write("\t\t\t\t\t\turl : \"http://localhost:9879/OnlineReviewSystem/ReviewTempServlet\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ url,\r\n");
      out.write("\t\t\t\t\t}).then(function(resp) {\r\n");
      out.write("\t\t\t\tlet temp_reviews = resp.data;\r\n");
      out.write("\t\t\t\tfor (i = 0; i < temp_reviews.length; i++) {\r\n");
      out.write("\t\t\t\t\ttemp_review = temp_reviews[i];\r\n");
      out.write("\t\t\t\t\tscores[temp_review.team_tid] = temp_review.score;\r\n");
      out.write("\t\t\t\t\treviews[temp_review.team_tid] = temp_review.review;\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t\t//????????????????????????????????????\r\n");
      out.write("\t\t\taxios(\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\tmethod : \"get\",\r\n");
      out.write("\t\t\t\t\t\turl : \"http://localhost:9879/OnlineReviewSystem/ReviewProjectServlet\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ url,\r\n");
      out.write("\t\t\t\t\t}).then(function(resp) {\r\n");
      out.write("\t\t\t\tlet content = resp.data;\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"content\").innerText += content;\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t\t//????????????????????????\r\n");
      out.write("\t\t\taxios(\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\tmethod : \"get\",\r\n");
      out.write("\t\t\t\t\t\turl : \"http://localhost:9879/OnlineReviewSystem/ReviewReportServlet\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ url,\r\n");
      out.write("\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t\t.then(\r\n");
      out.write("\t\t\t\t\t\t\tfunction(resp) {\r\n");
      out.write("\t\t\t\t\t\t\t\t//????????????\r\n");
      out.write("\t\t\t\t\t\t\t\tlet reports = resp.data;\r\n");
      out.write("\t\t\t\t\t\t\t\t//??????\"error\"???????????????,???????????????????????????\r\n");
      out.write("\t\t\t\t\t\t\t\tif (reports == \"error\") {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdocument.getElementById(\"page\").innerHTML = \"\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\talert(\"????????????????????????\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t//??????\"no permission\"?????????????????????????????????????????????,???????????????????????????\r\n");
      out.write("\t\t\t\t\t\t\t\tif (reports == \"no permission\") {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdocument.getElementById(\"page\").innerHTML = \"\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\talert(\"???????????????????????????????????????\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\tlet buttonData = \"\";//????????????????????????--innerHTML??????\r\n");
      out.write("\t\t\t\t\t\t\t\tfor (let i = 0; i < reports.length; i++) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tlet report = reports[i];\r\n");
      out.write("\t\t\t\t\t\t\t\t\tbuttonData += \"\\n\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ \"<li class=\\\"team\\\" id=\\\"team\" + report.teams_tid\r\n");
      out.write("                    + \"\\\">???\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ report.teams_tid + \"???</li>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t//??????????????????\r\n");
      out.write("\t\t\t\t\t\t\t\tdocument.getElementById(\"teams\").innerHTML = buttonData;\r\n");
      out.write("\t\t\t\t\t\t\t\tlet button_choosed;//????????????????????????button\r\n");
      out.write("\t\t\t\t\t\t\t\t//???????????????????????????\r\n");
      out.write("\t\t\t\t\t\t\t\tbutton_choosed = document.getElementById(\"team\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+ reports[0].teams_tid);\r\n");
      out.write("\t\t\t\t\t\t\t\tbutton_choosed.className = \"team selected\";\r\n");
      out.write("\t\t\t\t\t\t\t\tdocument.getElementById(\"team_tid\").value = reports[0].teams_tid;//?????????form????????????team_tid\r\n");
      out.write("\t\t\t\t\t\t\t\tdocument.getElementById(\"report\").innerText = reports[0].report_content;//??????????????????????????????\r\n");
      out.write("\t\t\t\t\t\t\t\tif (scores[reports[0].teams_tid]) {//?????????score input????????????\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdocument.getElementById(\"score\").value = scores[reports[0].teams_tid];\r\n");
      out.write("\t\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdocument.getElementById(\"score\").value = null;\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\tif (reviews[reports[0].teams_tid]) {//?????????review input????????????\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdocument.getElementById(\"review\").value = reviews[reports[0].teams_tid];\r\n");
      out.write("\t\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdocument.getElementById(\"review\").value = null;\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t//??????????????????team?????????className?????????????????????????????????????????????form????????????team_tid???\r\n");
      out.write("\t\t\t\t\t\t\t\tfor (let i = 0; i < reports.length; i++) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tlet id = \"team\" + reports[i].teams_tid;\r\n");
      out.write("\t\t\t\t\t\t\t\t\tlet button = document.getElementById(id);\r\n");
      out.write("\t\t\t\t\t\t\t\t\tbutton.onclick = function() {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//?????????button????????????????????????\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tfor (let i = 0; i < reports.length; i++) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tlet id = \"team\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+ reports[i].teams_tid;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(id).className = \"team\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tbutton_choosed = button;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//????????????button?????????????????????\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tbutton.className = \"team selected\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//????????????input???????????????\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tscores[document\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t.getElementById(\"team_tid\").value] = document\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t.getElementById(\"score\").value;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\treviews[document\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t.getElementById(\"team_tid\").value] = document\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t.getElementById(\"review\").value;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//??????form??????\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"report\").innerText = reports[i].report_content;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"team_tid\").value = reports[i].teams_tid;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//??????score input????????????\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tif (scores[reports[i].teams_tid]) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"score\").value = scores[reports[i].teams_tid];\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"score\").value = null;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//??????review input????????????\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tif (reviews[reports[i].teams_tid]) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"review\").value = reviews[reports[i].teams_tid];\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"review\").value = null;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t//??????????????????\r\n");
      out.write("\t\t\t\t\t\t\t\tdocument.getElementById(\"temp-button\").onclick = function() {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tlet score = document\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.getElementById(\"score\").value;\r\n");
      out.write("\t\t\t\t\t\t\t\t\tif (score > 0 && score <= 100) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\talert(\"?????????????????????????????????????????????\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tparent.location.reload();\r\n");
      out.write("\t\t\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\talert(\"????????????-???????????????0~100?????????\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t//??????????????????\r\n");
      out.write("\t\t\t\t\t\t\t\tdocument.getElementById(\"submit-button\").onclick = function() {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tlet score = document\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.getElementById(\"score\").value;\r\n");
      out.write("\t\t\t\t\t\t\t\t\tif (score > 0 && score <= 100) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\talert(\"?????????????????????????????????????????????\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//????????????????????????????????????\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tbutton_choosed.style.display = \"none\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tparent.location.reload();\r\n");
      out.write("\t\t\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\talert(\"????????????-???????????????0~100?????????\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t})\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
