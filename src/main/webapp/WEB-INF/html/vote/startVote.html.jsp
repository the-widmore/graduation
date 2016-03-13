<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="x-ua-compatible" content="IE=edge">
<title>EasyVote::投票介绍</title>
<link rel="stylesheet" href="/easyvote/staticFile/css/bootstrap.min.css">
<link rel="stylesheet" href="/easyvote/staticFile/main.css">
</head>
<body>

	<nav class="navbar navbar-default">
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
				<li class="active"><a href="/easyvote/vote/startVote.html">投票</a></li>
				<li><a href="/easyvote/poll/startPoll.html">问卷</a></li>
				<li><a href="/easyvote/user/selfCenter.html">个人</a></li>
				<li><a href="/easyvote/demo/demo.html">演示</a></li>
				<li><a href="/easyvote/help/help.html">帮助</a></li>
				<li><a href="/easyvote/about/about.html">关于</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">更多 <span class="caret"></span>
				</a>
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

	<div class="container">

		<div class="page-header">
			<h3>
				<i class="glyphicon glyphicon-hand-up"></i>创建投票
			</h3>
		</div>

		<div class="row">
			<div class="col-sm-8">

				<div class="jumbotron">
					&nbsp;&nbsp;&nbsp;&nbsp;开始你的投票吧！上传一个文档我们为你进行问题的创建。 文档格式支持Microsoft
					office(word,excel)、PDF,图片。 
					<br> <a
						href="/easyvote/vote/createVoteFromFile.html" role="button"
						class="btn btn-sm btn-info">创建投票&raquo;</a> <a
						href="/easyvote/help/createVoteFromFile.html" role="button"
						target="_black" class="btn btn-sm btn-default">查看相关帮助</a>

				</div>

				<div class="jumbotron">
					&nbsp;&nbsp;&nbsp;&nbsp;
					开始你的投票吧！创建几个问题(投票最多十个问题)和多个选项，在你提交后会生成一个网址。把这个网址发送给投票人，投票人就可以进行投票了。
					<br> &nbsp;&nbsp;&nbsp;&nbsp;
					你可以创建一个简单的投票，在投票结束后我们会发送邮件告知你。你可以查看投票的比例，和实时变化图。 <br> <a
						href="/easyvote/vote/createVote.html" role="button"
						class="btn btn-sm btn-info">创建投票&raquo;</a>

				</div>

				<div class="jumbotron">
					&nbsp;&nbsp;&nbsp;&nbsp; 模式太简单、不支持多媒体，看看这里吧。你可以添加更多的问题和对应的选项。 <br>

					<a href="/easyvote/vote/createAdvanceVote.html" role="button"
						class="btn btn-sm btn-primary">创建高级投票&raquo;</a>
				</div>

			</div>
			<div class="col-sm-4"></div>
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

	<script src="/easyvote/staticFile/js/jquery-1.11.0.min.js"></script>
	<script src="/easyvote/staticFile/js/bootstrap.min.js"></script>
</body>
</html>