<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" lang="en">
<head>
	<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/login.css">
    <title>用户登录</title>
</head>
<body>
<div id="login">
    <h1>欢迎来到在线报告评审系统，请登录：</h1>
    <%
    String email = "";
    if(request.getAttribute("login_message") != null && request.getAttribute("login_message").toString().equals("failed")) {
    	email = request.getAttribute("email").toString();
    }
    %>
    <form action="<%=path %>/user.do?operate=login" method="post">
        <label>
            <input type="text" required="required" placeholder="邮箱" name="email" value="<%=email %>"/>
        </label>
        <label>
            <input type="password" required="required" placeholder="密码" name="pwd"/>
        </label>
	    <%if(request.getAttribute("login_message") != null && request.getAttribute("login_message").toString().equals("failed")) {%>
	<!--     <script type="text/javascript">alert("登录失败！用户名或密码错误！")</script> -->
	    <label style="color: red; font-weight: bold;">登录失败！用户名或密码错误！</label>
	    <%} %>
        <button class="but" type="submit">登录</button>
    </form>
</div>
</body>
</html>
