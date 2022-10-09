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

<table>
    <td>已提交的队伍</td>
	<c:forEach items="${teamsRepotes}" var="item">
	<tr>
	    <td>${item.teams_tid}</td>
	    
	    <c:forEach items="${teams}" var="team">
	        <c:if test="${item.teams_tid eq team.tid}">
	            <td>${team.name}</td>
	        </c:if>
	    </c:forEach>
	    
	    <td><a href="<%=path%>/ShowRepote?teams_tid=${item.teams_tid}&projects_pid=${item.projects_pid}">查看详细信息</a></td>
	 
	</tr>
	</c:forEach>
</table>
<a href="<%=path%>/QueryProject">
    返回
</a>
</body>
</html>