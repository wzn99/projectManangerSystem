<%@ page language="java" import="com.pojo.User" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title></title>
</head>
<body>
	<script>
	alert('信息修改成功!');
	if (window.parent != undefined && window.parent != null) {
	    window.parent.location.reload();
	}
	</script>
</body>
</html>