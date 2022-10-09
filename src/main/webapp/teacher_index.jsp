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
        <div class="navigator1">
			<ul class="n1_ul">
				<li>
					<a class="n1_a" onclick="changeColor(this)" href="teacher_review.jsp" id="review" target="right" style="text-decoration: underline; background-color: red;">项目报告在线评审</a>
				</li>
				
			</ul>
		</div>
		<div class="content navigator1">
			<iframe id="na1" scrolling="auto" rameborder="0" src="teacher_review.jsp" name="right" width="100%" height="100%"></iframe>
		</div>
	    <script>
	    	let url=location.search;
	    	document.getElementById("review").href+=url;
	    	document.getElementById("na1").src+=url;
	    </script>
    </div>
</body>
</html>