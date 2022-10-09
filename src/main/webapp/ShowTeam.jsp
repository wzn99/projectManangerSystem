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
<%

%>
<table>
	<c:forEach items="${teamlist}" var="item">
	<tr>
	    <td>${item.tid}</td>
	    <td>${item.name}</td>

	    <td><a href="<%=path%>/TeamChange?tid=${item.tid}">修改</a></td>
	    <td><a href="<%=path%>/TeamDelete?tid=${item.tid}" onclick="if(confirm('是否确定删除?')==false)return false">删除</a></td>
	</tr>
	</c:forEach>
</table>
<a href="<%=path%>/AddTeam.jsp">
    增加团队
</a>
<a href="<%=path%>/Return">
    返回
</a>
</body>
</html>