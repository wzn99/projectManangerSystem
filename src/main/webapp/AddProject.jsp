<%
	String path = request.getContextPath();
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
</head>
<body>
    <form action="<%=path %>/AddProject" method="post">
		PID：<input type="text" name="pid">
		项目内容：<input type="text" name="content">
		能否提交：<input type="checkbox" name="can_submit">
		
		
		<input type="submit" value="新增">
	</form>
	<p>${messages}</p>
	<a href="<%=path%>/QueryProject">
    返回
    </a>
</body>
</html>