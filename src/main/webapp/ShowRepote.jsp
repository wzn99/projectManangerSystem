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
	<td>报告信息：${report_content}</td>
	
	<td>
	教师评审意见
	    <c:forEach items="${reviewlist}" var="item">
	        <tr>
	            <td>${item.teacher_uid}</td>
	    
	            <c:forEach items="${teacherslist}" var="teacher">
	                  <c:if test="${item.teacher_uid eq teacher.uid}">
	                      <td>${teacher.name}</td>
	                  </c:if>
	            </c:forEach>
	            
	            <td>${item.review}</td>
	            <td>分数：${item.score}</td>
	            
	         </tr>
	    </c:forEach>
	</td>
	
	<td>
	<form action="<%=path %>/ChangeSynthetic_review?project_pid=${project_pid}&team_tid=${team_tid}" method="post">
		
		综合评价：<input type="text" name="synthetic_review" value="${synthetic_review}">
		
		
		<input type="submit" value="生成综合评价">
	</form>
	</td>
</table>

<a href="<%=path%>/ShowTeamRepote?project_pid=${project_pid}">
    返回
</a>
</body>
</html>