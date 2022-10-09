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
    <form action="<%=path %>/UserAdd" method="post">
		UID：<input type="text" name="uid">
		姓名：<input type="text" name="name">
		电话号码：<input type="text" name="telephone_number">
		邮箱：<input type="text" name="email">
		密码：<input type="text" name="password">
		角色：<input type="text" name="role">
		团队号：<input type="text" name="teams_tid">
		
		<input type="submit" value="新增">
	</form>
	<p>${messages}</p>
    <a href="<%=path%>/UserQuery">
    返回
    </a>
</body>
</html>