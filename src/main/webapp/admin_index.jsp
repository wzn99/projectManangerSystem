<%@ page language="java" import="com.pojo.User" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" href="css/index.css">
	<script type="text/javascript" src="js/index.js"></script>
	<title>用户主页</title>
</head>
<body>
	<h3 class="menu_title">欢迎您！</h3>
	<div class="menu">
		<div class="navigator2">
			<ul class="n2_ul">
<%--				<li>--%>
<%--					<%--%>
<%--					User user = (User)session.getAttribute("user");--%>
<%--					String name = user.getName();--%>
<%--					String email = user.getEmail();--%>
<%--					String telephone = user.getTelephone_number();--%>
<%--					String role = user.getRole();--%>
<%--					switch (role) {--%>
<%--					case "member":--%>
<%--						role = "团队成员";--%>
<%--						break;--%>
<%--					case "admin":--%>
<%--						role = "管理员";--%>
<%--						break;--%>
<%--					}--%>
<%--					%>--%>
<%--					<div align="right">--%>
<%--							姓名：<font color="#001487"><%=name %></font>&nbsp;&nbsp;&nbsp;&nbsp;--%>
<%--							邮箱：<font color="#001487"><%=email %></font>&nbsp;&nbsp;&nbsp;&nbsp;--%>
<%--							电话：<font color="#001487"><%=telephone %></font>&nbsp;&nbsp;&nbsp;&nbsp;--%>
<%--							角色：<font color="#001487"><%=role %></font>&nbsp;&nbsp;&nbsp;&nbsp;--%>
<%--					</div>--%>

<%--				</li>--%>
			</ul>
		</div>
        <div class="navigator1">
			<ul class="n1_ul">
				<li>
					<a class="n1_a" onclick="changeColor(this)" href="admin_main.jsp" target="right" style="text-decoration: underline; background-color: red;">管理信息</a>
				</li>
				
			</ul>
		</div>
		<div class="content navigator1">
			<iframe scrolling="auto" rameborder="0" src="admin_main.jsp" name="right" width="100%" height="100%"></iframe>
		</div>
    </div>
    
</body>
</html>