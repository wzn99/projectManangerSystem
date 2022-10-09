<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/modify.css">
    <title></title>
</head>
<body>
<br>
	<form action="<%=path %>/user.do?operate=modifyMessage" method="post">
    <div class="form-group">
      <div class="label">
        <label>电话:</label>
      </div>
      <input type="text" class="input w50" name="telephone_number" size="10" placeholder="请输入电话">
    </div>
    <div class="form-group">
      <div class="label">
        <label>邮箱:</label>
      </div>
      <input type="text" class="input w50" name="email" size="50" placeholder="请输入邮箱">
    </div>

    <div class="form-group">
      <div class="label">
        <label>原密码:</label>
      </div>
      <input type="password" class="input w50" name="pwd0" size="50" placeholder="请输入原密码">
    </div>

    <div class="form-group">
      <div class="label">
        <label>新密码:</label>
      </div>
      <input type="password" class="input w50" name="pwd1" size="50" placeholder="请输入新密码">
    </div>

    <div class="form-group">
      <div class="label">
        <label>确认密码:</label>
      </div>
      <input type="password" class="input w50" name="pwd2" size="50" placeholder="请输入确认新密码">
    </div>
 
    <div class="form-group">
      <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
    </div>
</form>
</body>
</html>