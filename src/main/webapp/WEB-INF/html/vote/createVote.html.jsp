<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="zh-CN">
<meta http-equiv="x-ua-compatible" content="IE=edge">
<title>EasyVote::投票:创建</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/main.css">
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

	<div class="container">
		<ol class="breadcrumb">
			<li><a href="../../index.html">首页 </a></li>
			<li><a href="startVote.html"> 投票 </a></li>
			<li class="active">创建简单投票</li>
		</ol>

		<div class="row">
			<div class="col-md-9">
				<div class="page-header">
					<h3>
						<i class="glyphicon glyphicon-hand-up"></i>创建投票
					</h3>
				</div>

				<form class="form-horizontal" action="#" method="POST">

					<div class="form-group">
						<label class="control-label col-md-2" for="voteTitleInput">投票标题</label>

						<div class="col-md-6">
							<input type="text" class="form-control" id="voteTitleInput">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2" for="voteTagInput">投票标签</label>

						<div class="col-md-6">
							<input type="text" class="form-control" id="voteTagInput"
								placeholder="使用分号,逗号,空格分割 最多5个">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2" for="endTimeInput">结束时间</label>

						<div class="col-md-6">
							<input type="datetime-local" class="form-control"
								id="endTimeInput" placeholder="使用分号,逗号,空格分割 最多5个">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2">编辑模式</label>

						<div class="col-md-6">
							<select class="form-control">
								<option>拖拽编辑</option>
								<option>HTML模式</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-6 col-md-offset-2">
							<a href="editVote.html">创建并编辑</a>
							<!--<input type="submit" role="button" class="btn btn-primary" value="创建并编辑">-->
						</div>
					</div>


				</form>

			</div>

			<div class="col-md-3"></div>

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