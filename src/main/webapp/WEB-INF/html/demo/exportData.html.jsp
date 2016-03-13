<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="zh-CN">
<meta http-equiv="x-ua-compatible" content="IE=edge">
<title>演示:数据导出</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main.css">
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
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">EasyVote</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="../../index.html">首页</a></li>
				<li><a href="../vote/startVote.html">投票</a></li>
				<li><a href="../poll/startPoll.html">问卷</a></li>
				<li><a href="../user/selfCenter.html">个人</a></li>
				<li class="active"><a href="../demo/demo.html">演示</a></li>
				<li><a href="../help/help.html">帮助</a></li>
				<li><a href="../about/about.html">关于</a></li>
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

	<div class="container content">

		<div class="jumbotron">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;无论是投票、问卷、还是信息收集(下面简称为活动)，你都可以导出填写的数据。
			在网页上显示的数据我们按时间排序进行分页显示，在你导出时我们将全部数据填充到一个Excel文件。
			你可以进行下载，还可以分享给参加这此活动的多个联系人库。你可以在<a href="../user/selfCenter.html">
				个人中心</a>&raquo; <a href="../user/userConsole.html">用户控制台</a>开启二级密码，并使用二级密码加密你导出的Excel文件。你的数据我们只会保存<b>一个月</b>。
			所以，如果一次活动完成，请你尽快导出数据。并请在个人中心留下联系电话，以便在必要时联系你。如果，你没能在限定时间内导出数据，我们将不承担任何责任。
		</div>
		<div class="page-header">
			<h3>导出方式</h3>

			<div class="row">
				<div class="col-md-8">
					<div class="jumbotron"></div>
				</div>
				<div class="col-md-4"></div>

			</div>
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

		<p>网站备案</p>

		<p>京201510-34534****</p>
	</div>
	</footer>

	<script src="${pageContext.request.contextPath}/resources/easyui/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>