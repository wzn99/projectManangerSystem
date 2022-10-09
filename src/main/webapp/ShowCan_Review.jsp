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

<script>
    function ds(project_pid,teacher_uid,password){
	  document.getElementById(teacher_uid).innerHTML="http://localhost:9879/OnlineReviewSystem/teacher_index.jsp?project_pid="
			  +project_pid+"&teacher_uid="
			  +teacher_uid+"&password="
			  +password
	}
    
</script>

</head>
<body>
<%

%>
<table>
	<c:forEach items="${can_reviewlist}" var="item">
	<tr>
	    <td>${item.teacher_uid}</td>
	    
	    <c:forEach items="${teacherslist}" var="teacher">
	        <c:if test="${item.teacher_uid eq teacher.uid}">
	            <td>${teacher.name}</td>
	        </c:if>
	    </c:forEach>
	    
	    <td>${item.can_review}</td>
	    
	    <c:if test="${item.can_review eq 'yes'}">
	        <td><a href="<%=path%>/ChangeReview?teacher_uid=${item.teacher_uid}&can_review=${item.can_review}&project_pid=${item.project_pid}" onclick="if(confirm('是否关闭?')==false)return false">关闭权限</a></td>
	        
	        <!-- 生成链接 -->
	            <td>
	                 <c:forEach items="${teacherslist}" var="teacher">
	                       <c:if test="${item.teacher_uid eq teacher.uid}">
	                          <button onclick = "ds(${item.project_pid},${item.teacher_uid},${teacher.password})">
                                生成评审链接
                              </button>
                              <td id=${item.teacher_uid}></td>
                           </c:if>
                    </c:forEach>
                </td>
            <!-- end -->
            
	    </c:if>
	    <c:if test="${item.can_review eq 'no'}">
	        <td><a href="<%=path%>/ChangeReview?teacher_uid=${item.teacher_uid}&can_review=${item.can_review}&project_pid=${item.project_pid}" onclick="if(confirm('是否开启?')==false)return false">打开权限</a></td>
	    </c:if>
	    
	    
	</tr>
	</c:forEach>
</table>
<a href="<%=path%>/QueryProject">
    返回
</a>
</body>
</html>