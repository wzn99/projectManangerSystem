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
      out.write("\t\t\t\t<h4 class=\"description\">本期项目内容:</h4>\r\n");
      out.write("\t\t\t\t<p class=\"description\" id=\"content\"></p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"bottom\">\r\n");
      out.write("\t\t\t<div class=\"bottom-left\">\r\n");
      out.write("\t\t\t\t<div class=\"bottom-left-top\">\r\n");
      out.write("\t\t\t\t\t<h3 class=\"teamText\">待评审的团队：</h3>\r\n");
      out.write("\t\t\t\t\t<ul class=\"teams\" id=\"teams\">\r\n");
      out.write("\t\t\t\t\t<!-- \r\n");
      out.write("\t\t\t\t\t<li class=\"team selected\">第1组</li>\r\n");
      out.write("\t\t\t\t\t\t<li class=\"team\">第2组</li>\r\n");
      out.write("\t\t\t\t\t -->\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"bottom-right\">\r\n");
      out.write("\t\t\t\t<div class=\"bottom-right-top\">\r\n");
      out.write("\t\t\t\t\t<p class=\"reportText\">该组项目报告：</p>\r\n");
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
      out.write("\t\t\t\t\t\t\t\t<p class=\"label\">评&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp分：\r\n");
      out.write("\t\t\t\t\t\t\t\t<input class=\"input score\" placeholder=\"输入该组分数(0~100)\" name=\"score\" id=\"score\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<p class=\"scores-alert\" id=\"scores-alert\" style=\"display: none\">请输入0~100的数字</p>\r\n");
      out.write("\t\t\t\t\t\t\t\t</p> \r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t\t\t\t<div class=\"reviews\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<label class=\"label\">评审意见：&nbsp</label>\r\n");
      out.write("\t\t\t\t\t\t\t\t<textarea class=\"review\" placeholder=\"输入评审意见\" name=\"review\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tid=\"review\"></textarea>\r\n");
      out.write("\t\t\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t\t\t<input name=\"project_pid\" style=\"display: none\" id=\"project_pid\">\r\n");
      out.write("\t\t\t\t\t\t\t<input name=\"teacher_uid\" style=\"display: none\" id=\"teacher_uid\">\r\n");
      out.write("\t\t\t\t\t\t\t<input value=\"1\" name=\"team_tid\" style=\"display: none\"\r\n");
      out.write("\t\t\t\t\t\t\t\tid=\"team_tid\"> <input value=\"1\" name=\"status\"\r\n");
      out.write("\t\t\t\t\t\t\t\tstyle=\"display: none\" id=\"status\"> <br> <br>\r\n");
      out.write("\t\t\t\t\t\t\t<div align=\"center\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<input type=\"submit\" class=\"button bg-main icon-check-square-o\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tvalue=\"暂存\" id=\"temp-button\" name=\"temp\"> <input\r\n");
      out.write("\t\t\t\t\t\t\t\t\ttype=\"submit\" class=\"button bg-main icon-check-square-o\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\tvalue=\"提交\" id=\"submit-button\" name=\"submit\">\r\n");
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
      out.write("\t\t//在页面加载后执行\r\n");
      out.write("\t\tonload = function() {\r\n");
      out.write("\t\t\tlet a=new Array()\r\n");
      out.write("\t\t\ta[5]=1\r\n");
      out.write("\r\n");
      out.write("\t\t\t// alert(a.length)\r\n");
      out.write("\t\t\t//输入的评分不是0~100的数字，则显示提示信息\r\n");
      out.write("\t\t\tdocument.getElementById(\"score\").onblur = function() {\r\n");
      out.write("\t\t\t\tlet inputScore = document.getElementById(\"score\").value;\r\n");
      out.write("\t\t\t\tif (inputScore >= 1 && inputScore <= 100) {\r\n");
      out.write("\t\t\t\t\tdocument.getElementById(\"scores-alert\").style.display = 'none';\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\tdocument.getElementById(\"scores-alert\").style.display = '';\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\t//获取url中携带的参数\r\n");
      out.write("\t\t\tlet url = window.location.search;//获取url中\"?\"后的字符串\r\n");
      out.write("\t\t\t//提取参数：url中的project_pid和teacher_uid\r\n");
      out.write("\t\t\tlet pid_index = url.indexOf(\"project_pid\");\r\n");
      out.write("\t\t\tlet tid_index = url.indexOf(\"teacher_uid\");\r\n");
      out.write("\t\t\tlet project_pid = url.substring(pid_index + 12, pid_index + 13);\r\n");
      out.write("\t\t\tlet teacher_uid = url.substring(tid_index + 12, tid_index + 13);\r\n");
      out.write("\t\t\t//设置form表单中的project_pid信息\r\n");
      out.write("\t\t\tdocument.getElementById(\"project_pid\").value = project_pid;\r\n");
      out.write("\t\t\tdocument.getElementById(\"teacher_uid\").value = teacher_uid;\r\n");
      out.write("\t\t\tlet scores = new Array();//对各团队的评分\r\n");
      out.write("\t\t\tlet reviews = new Array();//对各团队的评审意见\r\n");
      out.write("\t\t\t//获取暂存的评分和评审意见,并初始化scores和reviews\r\n");
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
      out.write("\t\t\t//获取项目内容并显示到页面\r\n");
      out.write("\t\t\taxios(\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\tmethod : \"get\",\r\n");
      out.write("\t\t\t\t\t\turl : \"http://localhost:9879/OnlineReviewSystem/ReviewProjectServlet\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ url,\r\n");
      out.write("\t\t\t\t\t}).then(function(resp) {\r\n");
      out.write("\t\t\t\tlet content = resp.data;\r\n");
      out.write("\t\t\t\tdocument.getElementById(\"content\").innerText += content;\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t\t//获取待评审的报告\r\n");
      out.write("\t\t\taxios(\r\n");
      out.write("\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\tmethod : \"get\",\r\n");
      out.write("\t\t\t\t\t\turl : \"http://localhost:9879/OnlineReviewSystem/ReviewReportServlet\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ url,\r\n");
      out.write("\t\t\t\t\t})\r\n");
      out.write("\t\t\t\t\t.then(\r\n");
      out.write("\t\t\t\t\t\t\tfunction(resp) {\r\n");
      out.write("\t\t\t\t\t\t\t\t//获取数据\r\n");
      out.write("\t\t\t\t\t\t\t\tlet reports = resp.data;\r\n");
      out.write("\t\t\t\t\t\t\t\t//响应\"error\"，链接有误,清空页面内容并提示\r\n");
      out.write("\t\t\t\t\t\t\t\tif (reports == \"error\") {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdocument.getElementById(\"page\").innerHTML = \"\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\talert(\"您输入的链接有误\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t//响应\"no permission\"，该导师没有查看改期项目的报告,清空页面内容并提示\r\n");
      out.write("\t\t\t\t\t\t\t\tif (reports == \"no permission\") {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdocument.getElementById(\"page\").innerHTML = \"\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\talert(\"您当前没有权限查看当期报告\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\treturn;\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\tlet buttonData = \"\";//用于显示组的按钮--innerHTML内容\r\n");
      out.write("\t\t\t\t\t\t\t\tfor (let i = 0; i < reports.length; i++) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tlet report = reports[i];\r\n");
      out.write("\t\t\t\t\t\t\t\t\tbuttonData += \"\\n\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ \"<li class=\\\"team\\\" id=\\\"team\" + report.teams_tid\r\n");
      out.write("                    + \"\\\">第\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t+ report.teams_tid + \"组</li>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t//设置按钮数据\r\n");
      out.write("\t\t\t\t\t\t\t\tdocument.getElementById(\"teams\").innerHTML = buttonData;\r\n");
      out.write("\t\t\t\t\t\t\t\tlet button_choosed;//用于表示被选中的button\r\n");
      out.write("\t\t\t\t\t\t\t\t//先默认选中第一个组\r\n");
      out.write("\t\t\t\t\t\t\t\tbutton_choosed = document.getElementById(\"team\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t+ reports[0].teams_tid);\r\n");
      out.write("\t\t\t\t\t\t\t\tbutton_choosed.className = \"team selected\";\r\n");
      out.write("\t\t\t\t\t\t\t\tdocument.getElementById(\"team_tid\").value = reports[0].teams_tid;//初始化form表单中的team_tid\r\n");
      out.write("\t\t\t\t\t\t\t\tdocument.getElementById(\"report\").innerText = reports[0].report_content;//默认显示第一组的报告\r\n");
      out.write("\t\t\t\t\t\t\t\tif (scores[reports[0].teams_tid]) {//初始化score input框的内容\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdocument.getElementById(\"score\").value = scores[reports[0].teams_tid];\r\n");
      out.write("\t\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdocument.getElementById(\"score\").value = null;\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\tif (reviews[reports[0].teams_tid]) {//初始化review input框的内容\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdocument.getElementById(\"review\").value = reviews[reports[0].teams_tid];\r\n");
      out.write("\t\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tdocument.getElementById(\"review\").value = null;\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t//按钮点击选择team，改变className，显示该组提交的文本信息，改变form表单中的team_tid值\r\n");
      out.write("\t\t\t\t\t\t\t\tfor (let i = 0; i < reports.length; i++) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tlet id = \"team\" + reports[i].teams_tid;\r\n");
      out.write("\t\t\t\t\t\t\t\t\tlet button = document.getElementById(id);\r\n");
      out.write("\t\t\t\t\t\t\t\t\tbutton.onclick = function() {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//把其余button设置为未选中状态\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tfor (let i = 0; i < reports.length; i++) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tlet id = \"team\"\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t\t+ reports[i].teams_tid;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(id).className = \"team\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tbutton_choosed = button;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//把点击的button设置为选中状态\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tbutton.className = \"team selected\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//记录当前input框中的内容\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tscores[document\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t.getElementById(\"team_tid\").value] = document\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t.getElementById(\"score\").value;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\treviews[document\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t.getElementById(\"team_tid\").value] = document\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t\t.getElementById(\"review\").value;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//修改form表单\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"report\").innerText = reports[i].report_content;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"team_tid\").value = reports[i].teams_tid;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//修改score input框的内容\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tif (scores[reports[i].teams_tid]) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"score\").value = scores[reports[i].teams_tid];\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"score\").value = null;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//修改review input框的内容\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tif (reviews[reports[i].teams_tid]) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"review\").value = reviews[reports[i].teams_tid];\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"review\").value = null;\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t//点击暂存按钮\r\n");
      out.write("\t\t\t\t\t\t\t\tdocument.getElementById(\"temp-button\").onclick = function() {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tlet score = document\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.getElementById(\"score\").value;\r\n");
      out.write("\t\t\t\t\t\t\t\t\tif (score > 0 && score <= 100) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\talert(\"成功暂存对于改组报告的评审意见\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tparent.location.reload();\r\n");
      out.write("\t\t\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\talert(\"暂存失败-评分请输入0~100的数字\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\t\t\t//点击提交按钮\r\n");
      out.write("\t\t\t\t\t\t\t\tdocument.getElementById(\"submit-button\").onclick = function() {\r\n");
      out.write("\t\t\t\t\t\t\t\t\tlet score = document\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t\t.getElementById(\"score\").value;\r\n");
      out.write("\t\t\t\t\t\t\t\t\tif (score > 0 && score <= 100) {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\talert(\"成功提交对于该组报告的评审意见\");\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\t//移除界面上选则该组的按钮\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tbutton_choosed.style.display = \"none\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\tparent.location.reload();\r\n");
      out.write("\t\t\t\t\t\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t\t\t\t\t\talert(\"提交失败-评分请输入0~100的数字\");\r\n");
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
