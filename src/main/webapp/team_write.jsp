<%--
  Created by IntelliJ IDEA.
  User: Owen
  Date: 2022/7/6
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@ page language="java" contentType="text/html; charset=utf-8"
             pageEncoding="utf-8" %>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="css/modify.css">
    <title></title>
</head>
<body>
<br>
<form action="<%=path %>/team.do?operate=writeReport" method="post">
    <div class="form-group">
      <div class="label">
        <label>项目pid:</label>
      </div>
      <input type="text" class="input w50" name="projects_pid" size="10" placeholder="请输入项目pid">
    </div>
    <div class="form-group">
      <div class="label">
        <label>项目报告:</label>
      </div>
      <input type="text" class="input w50" name="report" size="10" placeholder="请输入项目报告">
    </div>
    <div class="form-group">
      <input type="submit" class="button bg-main icon-check-square-o" value="提交项目报告">
    </div>
</form>
</body>
</html>