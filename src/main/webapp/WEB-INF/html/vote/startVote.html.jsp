<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="x-ua-compatible" content="IE=edge">
<title>EasyVote::投票介绍</title>
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
				<li><a href="${pageContext.request.contextPath}/">首页</a></li><li><a href="${pageContext.request.contextPath}/search/">搜索</a></li>
				<li class="active"><a href="${pageContext.request.contextPath}/vote/startVote.html">投票</a></li>
				<li><a href="${pageContext.request.contextPath}/user/selfCenter.html">个人</a></li>
				<li><a href="${pageContext.request.contextPath}/demo/demo.html">演示</a></li>
				<li><a href="${pageContext.request.contextPath}/help/help.html">帮助</a></li>
				<li><a href="${pageContext.request.contextPath}/about/about.html">关于</a></li>
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

	<div class="container content">

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
						href="${pageContext.request.contextPath}/vote/createVoteFromFile.html" role="button"
						class="btn btn-sm btn-info">创建投票&raquo;</a> <a
						href="${pageContext.request.contextPath}/help/createVoteFromFile.html" role="button"
						target="_black" class="btn btn-sm btn-default">查看相关帮助</a>

				</div>

				<div class="jumbotron">
					&nbsp;&nbsp;&nbsp;&nbsp;
					开始你的投票吧！创建几个问题(投票最多十个问题)和多个选项，在你提交后会生成一个网址。把这个网址发送给投票人，投票人就可以进行投票了。
					<br> &nbsp;&nbsp;&nbsp;&nbsp;
					你可以创建一个简单的投票，在投票结束后我们会发送邮件告知你。你可以查看投票的比例，和实时变化图。 <br> <a
						href="${pageContext.request.contextPath}/vote/createVote.html" role="button"
						class="btn btn-sm btn-info">创建投票&raquo;</a>

				</div>

				<div class="jumbotron">
					&nbsp;&nbsp;&nbsp;&nbsp; 模式太简单、不支持多媒体，看看这里吧。你可以添加更多的问题和对应的选项。 <br>

					<a href="${pageContext.request.contextPath}/vote/createAdvanceVote.html" role="button"
						class="btn btn-sm btn-primary">创建高级投票&raquo;</a>
				</div>

			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>

	<%@ include file="../reusable/footer.jsp" %>

	<script src="${pageContext.request.contextPath}/resources/easyui/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>