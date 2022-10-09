<%@ page language="java" import="com.pojo.User" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
</head>
<body>
	<%
	String message = request.getAttribute("pwd_message").toString();
	%>
	<script>
	alert('密码修改失败!<%=message %>');	
	window.location.reload();
	</script>
</body>
</html>