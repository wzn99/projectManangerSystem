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
<table action="<%=path %>/QueryProject" method="post">
	<c:forEach items="${projectlist}" var="item">
	<tr>
	    <td>${item.pid}</td>
	    <td>${item.content}</td>
	    <td>${item.can_submit}</td>
	    <c:if test="${item.can_submit eq 'yes'}">
	        <td><a href="<%=path%>/ChangeSubmit?pid=${item.pid}&can_submit=${item.can_submit}" onclick="if(confirm('是否关闭?')==false)return false">关闭提交</a></td>
	    </c:if>
	    <c:if test="${item.can_submit eq 'no'}">
	        <td><a href="<%=path%>/ChangeSubmit?pid=${item.pid}&can_submit=${item.can_submit}" onclick="if(confirm('是否开启?')==false)return false">打开提交</a></td>
	    </c:if>
	    
	    <td><a href="<%=path%>/ShowCanReview?project_pid=${item.pid}">授权</a></td>
	    <td><a href="<%=path%>/ShowTeamRepote?project_pid=${item.pid}">查看</a></td>
	</tr>
	</c:forEach>
</table>

<a href="<%=path%>/AddProject.jsp">
    增加报告任务
</a>
<a href="<%=path%>/Return">
    返回
</a>
</body>
</html>