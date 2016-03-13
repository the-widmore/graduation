<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="zh-CN">
<meta http-equiv="x-ua-compatible" content="IE=edge">
<title>EasyVote:演示</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/main.css">
</head>
<body>

	<nav class="navbar navbar-default ">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/easyvote/">EasyVote</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="/easyvote/">首页</a></li>
				<li><a href="/easyvote/vote/startVote.html">投票</a></li>
				<li><a href="/easyvote/poll/startPoll.html">问卷</a></li>
				<li><a href="/easyvote/user/selfCenter.html">个人</a></li>
				<li class="active"><a href="/easyvote/demo/demo.html">演示</a></li>
				<li><a href="/easyvote/help/help.html">帮助</a></li>
				<li><a href="/easyvote/about/about.html">关于</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">更多 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="../more/activity.html">活动</a></li>
						<li class="divider"></li>
						<li class="dropdown-header">隐私政策</li>
						<li><a href="../more/userData.html">用户数据</a></li>
						<li><a href="../more/platformPolicy.html">平台政策</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<%@include file="../user/userBar.jsp"%>
			</ul>
		</div>
	</div>
	</nav>

	<div class="carousel-caption"></div>

	<div class="container content">

		<div class="page-header">
			<h3>
				主要功能 -- <small><a href="processDemo.html" role="button"
					class="btn btn-success">流程演示</a></small>
			</h3>
		</div>
		<div class="carousel slide" id="function-example" data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#function-example" data-slide-to="1" class="active"></li>
				<li data-target="#function-example" data-slide-to="1"></li>
				<li data-target="#function-example" data-slide-to="1"></li>
				<li data-target="#function-example" data-slide-to="1"></li>
				<li data-target="#function-example" data-slide-to="1"></li>
			</ol>

			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="/easyvote/staticFile/image/function/fun01.jpg" alt="fun01">
				</div>
				<div class="item">
					<img src="/easyvote/staticFile/image/function/fun02.jpg" alt="fun02">
				</div>
				<div class="item">
					<img src="/easyvote/staticFile/image/function/fun03.jpg" alt="fun03">
				</div>
				<div class="item">
					<img src="/easyvote/staticFile/image/function/fun04.jpg" alt="fun05">
				</div>
				<div class="item">
					<img src="/easyvote/staticFile/image/function/fun05.jpg" alt="fun05">
				</div>
			</div>

			<a class="left carousel-control" role="button" data-slide="prev"
				href="#function-example"> <span
				class="glyphicon glyphicon-chevron-left"></span>
			</a> <a class="right carousel-control" role="button" data-slide="next"
				href="#function-example"> <span
				class="glyphicon glyphicon-chevron-right"></span>
			</a>

		</div>
		<!-- end of carousel -->

		<div class="jumbotron bg-success">
			<p></p>

		</div>
	</div>

	<footer class="footer">
	<div class="col-md-1"></div>
	<div class="col-md-2">
		<h2>EasyVote</h2>
		<ul>
			<li><a href="">版权声明</a></li>
			<li><a href="">使用须知</a></li>
			<li><a href="">隐私策略</a></li>
			<li><a href="">关于我们</a></li>
		</ul>
	</div>
	<div class="col-md-1"></div>
	<div class="col-md-2">
		<br>

		<h3>网站备案</h3>

		<p>京201510-34534****</p>
	</div>
	</footer>

	<script src="<%=request.getContextPath()%>/resources/easyui/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>