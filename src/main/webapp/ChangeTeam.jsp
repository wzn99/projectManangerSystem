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
    <form action="<%=path %>/ChangeTeam" method="post">
		TID：<input type="text" name="tid" readonly="readonly" value="${team.tid}">
		队名：<input type="text" name="name" value="${team.name}">
		
		<input type="submit" value="修改">
	</form>
	<a href="<%=path%>/ShowTeam">
    返回
    </a>
</body>
</html>