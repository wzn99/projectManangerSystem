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
<table action="<%=path %>/UserQuery" method="post">
	<div>UID&nbsp;姓名&nbsp;电话&nbsp;邮箱&nbsp;密码&nbsp;角色&nbsp;组号</div>
	<c:forEach items="${userlist}" var="item">
	<tr>
	    <td>${item.uid}</td>
	    <td>${item.name}</td>
	    <td>${item.telephone_number}</td>
	    <td>${item.email}</td>
	    <td>${item.password}</td>
	    <td>${item.role}</td>
	    <td>${item.teams_tid}</td>
	    <td><a href="<%=path%>/UserChange?uid=${item.uid}">修改</a></td>
	    <td><a href="<%=path%>/UserDelete?uid=${item.uid}" onclick="if(confirm('是否确定删除?')==false)return false">删除</a></td>
	</tr>
	</c:forEach>
</table>
<a href="<%=path%>/AddUser">
    增加成员
</a>
<a href="<%=path%>/Return">
    返回
</a>
</body>
</html>