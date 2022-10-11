<%
	String path = request.getContextPath();
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/teacher.css">
<title></title>
</head>
<body id="page">
	<div class="content">
		<div class="center">
			<div class="projectDescription">
				<h4 class="description">本期项目内容:</h4>
				<p class="description" id="content"></p>
			</div>
		</div>
		<div class="bottom">
			<div class="bottom-left">
				<div class="bottom-left-top">
					<h3 class="teamText">待评审的团队：</h3>
					<ul class="teams" id="teams">
					<!-- 
					<li class="team selected">第1组</li>
						<li class="team">第2组</li>
					 -->
						
					</ul>
				</div>
			</div>
			<div class="bottom-right">
				<div class="bottom-right-top">
					<p class="reportText">该组项目报告：</p>
					<p class="report" id="report"></p>
				</div>
				<div class="bottom-right-bottom">
					<div>
						<form action="<%=path %>/saveReviewServlet" method="post"
							target="frameName">
							<br>
							<br>
							<div class="reviews">
								<p class="label">评&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp分：
								<input class="input score" placeholder="输入该组分数(0~100)" name="score" id="score">
								<p class="scores-alert" id="scores-alert" style="display: none">请输入0~100的数字</p>
								</p> 
							</div>
							<br>
							<div class="reviews">
								<label class="label">评审意见：&nbsp</label>
								<textarea class="review" placeholder="输入评审意见" name="review"
									id="review"></textarea>
							</div>
							<input name="project_pid" style="display: none" id="project_pid">
							<input name="teacher_uid" style="display: none" id="teacher_uid">
							<input value="1" name="team_tid" style="display: none"
								id="team_tid"> <input value="1" name="status"
								style="display: none" id="status"> <br> <br>
							<div align="center">
								<input type="submit" class="button bg-main icon-check-square-o"
									value="暂存" id="temp-button" name="temp">
								<input type="submit" class="button bg-main icon-check-square-o"
									value="提交" id="submit-button" name="submit">
							</div>
						</form>
						<iframe src="" frameborder="0" name="frameName" height="0px"></iframe>
					</div>
				</div>
			</div>
		</div>
	</div>




	<script src="js/axios-0.18.0.js"></script>

	<script>
		//在页面加载后执行
		onload = function() {
			//输入的评分不是0~100的数字，则显示提示信息
			document.getElementById("score").onblur = function() {
				let inputScore = document.getElementById("score").value;
				if (inputScore >= 1 && inputScore <= 100) {
					document.getElementById("scores-alert").style.display = 'none';
				} else {
					document.getElementById("scores-alert").style.display = '';
				}
			}
			//获取url中携带的参数
			let url = window.location.search;//获取url中"?"后的字符串
			//提取参数：url中的project_pid和teacher_uid
			let pid_index = url.indexOf("project_pid");
			let tid_index = url.indexOf("teacher_uid");
			let project_pid = url.substring(pid_index + 12, pid_index + 13);
			let teacher_uid = url.substring(tid_index + 12, tid_index + 13);
			//设置form表单中的project_pid信息
			document.getElementById("project_pid").value = project_pid;
			document.getElementById("teacher_uid").value = teacher_uid;
			let scores = new Array();//对各团队的评分
			let reviews = new Array();//对各团队的评审意见
			//获取暂存的评分和评审意见,并初始化scores和reviews
			axios(
					{
						method : "get",
						//tempReviewServlet
						//ReviewTempServlet
						url : "http://localhost:8080/projectManagerSystem/tempReviewServlet"
								+ url,
					}).then(function(resp) {
				let temp_reviews = resp.data;
				for (i = 0; i < temp_reviews.length; i++) {
					temp_review = temp_reviews[i];
					scores[temp_review.team_tid] = temp_review.score;
					reviews[temp_review.team_tid] = temp_review.review;
				}
			})
			//获取项目内容并显示到页面
			axios(
					{
						method : "get",
						//projectContentServlet
						//ReviewProjectServlet
						url : "http://localhost:8080/projectManagerSystem/projectContentServlet"
								+ url,
					}).then(function(resp) {
				let content = resp.data;
				document.getElementById("content").innerText += content;
			})
			//获取待评审的报告
			axios(
					{
						method : "get",
						//ReviewReportServlet
						//reportsServlet
						url : "http://localhost:8080/projectManagerSystem/reportsServlet"
								+ url,
					})
					.then(
							function(resp) {
								//获取数据
								let reports = resp.data;
								//响应"error"，链接有误,清空页面内容并提示
								if (reports == "error") {
									document.getElementById("page").innerHTML = "";
									alert("您输入的链接有误");
									return;
								}
								//响应"no permission"，该导师没有查看改期项目的报告,清空页面内容并提示
								if (reports == "no permission") {
									document.getElementById("page").innerHTML = "";
									alert("您当前没有权限查看当期报告");
									return;
								}
								let buttonData = "";//用于显示组的按钮--innerHTML内容
								for (let i = 0; i < reports.length; i++) {
									let report = reports[i];
									buttonData += "\n"
											+ "<li class=\"team\" id=\"team" + report.teams_tid
                    + "\">第"
											+ report.teams_tid + "组</li>";
								}
								//设置按钮数据
								document.getElementById("teams").innerHTML = buttonData;
								let button_choosed;//用于表示被选中的button
								//先默认选中第一个组
								button_choosed = document.getElementById("team"
										+ reports[0].teams_tid);
								button_choosed.className = "team selected";
								document.getElementById("team_tid").value = reports[0].teams_tid;//初始化form表单中的team_tid
								document.getElementById("report").innerText = reports[0].report_content;//默认显示第一组的报告
								if (scores[reports[0].teams_tid]) {//初始化score input框的内容
									document.getElementById("score").value = scores[reports[0].teams_tid];
								} else {
									document.getElementById("score").value = null;
								}
								if (reviews[reports[0].teams_tid]) {//初始化review input框的内容
									document.getElementById("review").value = reviews[reports[0].teams_tid];
								} else {
									document.getElementById("review").value = null;
								}
								//按钮点击选择team，改变className，显示该组提交的文本信息，改变form表单中的team_tid值
								for (let i = 0; i < reports.length; i++) {
									let id = "team" + reports[i].teams_tid;
									let button = document.getElementById(id);
									button.onclick = function() {
										//把其余button设置为未选中状态
										for (let i = 0; i < reports.length; i++) {
											let id = "team"
													+ reports[i].teams_tid;
											document.getElementById(id).className = "team";
											button_choosed = button;
										}
										//把点击的button设置为选中状态
										button.className = "team selected";
										//记录当前input框中的内容
										scores[document
												.getElementById("team_tid").value] = document
												.getElementById("score").value;
										reviews[document
												.getElementById("team_tid").value] = document
												.getElementById("review").value;
										//修改form表单
										document.getElementById("report").innerText = reports[i].report_content;
										document.getElementById("team_tid").value = reports[i].teams_tid;
										//修改score input框的内容
										if (scores[reports[i].teams_tid]) {
											document.getElementById("score").value = scores[reports[i].teams_tid];
										} else {
											document.getElementById("score").value = null;
										}
										//修改review input框的内容
										if (reviews[reports[i].teams_tid]) {
											document.getElementById("review").value = reviews[reports[i].teams_tid];
										} else {
											document.getElementById("review").value = null;
										}
									}
								}
								//点击暂存按钮
								document.getElementById("temp-button").onclick = function() {
									let score = document
											.getElementById("score").value;
									if (score > 0 && score <= 100) {
										alert("成功暂存对于改组报告的评审意见");
										parent.location.reload();
									} else {
										alert("暂存失败-评分请输入0~100的数字");
									}
								}
								//点击提交按钮
								document.getElementById("submit-button").onclick = function() {
									let score = document
											.getElementById("score").value;
									if (score > 0 && score <= 100) {
										alert("成功提交对于该组报告的评审意见");
										//移除界面上选则该组的按钮
										button_choosed.style.display = "none";
										parent.location.reload();
									} else {
										alert("提交失败-评分请输入0~100的数字");
									}
									
								}
							})
		}
	</script>

</body>
</html>