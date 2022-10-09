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
    <form action="<%=path %>/ChangeUser" method="post">
		UID：<input type="text" name="uid" readonly="readonly" value="${user.uid}">
		姓名：<input type="text" name="name" value="${user.name}">
		电话号码：<input type="text" name="telephone_number" value="${user.telephone_number}">
		邮箱：<input type="text" name="email" value="${user.email}">
		密码：<input type="text" name="password" value="${user.password}">
		角色：<input type="text" name="role" value="${user.role}">
		团队号：<input type="text" name="teams_tid" value="${user.teams_tid}">
		
		<input type="submit" value="修改">
	</form>
	<a href="<%=path%>/UserQuery">
    返回
    </a>
</body>
</html>