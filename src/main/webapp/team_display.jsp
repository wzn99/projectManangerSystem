<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="css/display.css">
    <title></title>
</head>
<body>
  <br>
<form action="<%=path %>/team.do?operate=showProjectReports" method="post">
    <div class="form-group">
      <div class="label">
        <label>项目pid:</label>
        <input type="text" class="input w50" name="projects_pid" size="10" placeholder="请输入项目pid">
        <input type="submit" class="button bg-main icon-check-square-o" value="查看项目">
      </div>
    </div>
</form>
<form action="<%=path%>/team.do?operate=tmpSaveReport" method="post">
    <div class="form-group">
      <div class="label">
        <label>项目pid:</label>
        <input type="text" class="input w50" name="projects_pid" size="10" placeholder="请输入项目pid">
        <label>内容:</label>
        <input type="text" class="input w50" name="content" size="10" placeholder="请输入内容">
        <input type="submit" class="button bg-main icon-check-square-o" value="暂存项目">
      </div>
    </div>
</form>
<form action="<%=path%>/team.do?operate=showTmpReport" method="post">
    <div class="form-group">
      <div class="label">
        <label>项目pid:</label>
        <input type="text" class="input w50" name="projects_pid" size="10" placeholder="请输入项目pid">
        <input type="submit" class="button bg-main icon-check-square-o" value="查看暂存项目报告">
      </div>
    </div>
</form>
</body>
</html>