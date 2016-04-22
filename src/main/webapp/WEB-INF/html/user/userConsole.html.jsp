<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="zh-CN">
<meta http-equiv="x-ua-compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户:控制面板</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/switch/css/bootstrap3/bootstrap-switch.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/main.css">

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
				<li><a href="${pageContext.request.contextPath}/">首页</a></li>
				<li><a href="${pageContext.request.contextPath}/search/">搜索</a></li>
				<li><a
					href="${pageContext.request.contextPath}/vote/startVote.html">投票</a></li>
				<li class="active"><a
					href="${pageContext.request.contextPath}/user/selfCenter.html">个人</a></li>
				<li><a href="${pageContext.request.contextPath}/demo/demo.html">演示</a></li>
				<li><a href="${pageContext.request.contextPath}/help/help.html">帮助</a></li>
				<li><a
					href="${pageContext.request.contextPath}/about/about.html">关于</a></li>
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
		<ol class="breadcrumb">
			<li><a href="../../index.html">首页</a></li>
			<li><a href="selfCenter.html">个人中心</a></li>
			<li class="active">控制面板</li>
		</ol>

		<div class="row">
			<div class="col-sm-3">
				<div class="panel-success">

					<div class="panel-heading">
						<h4>
							<i class="glyphicon glyphicon-cog"></i>个人管理中心
						</h4>
					</div>

					<div class="panel-body">
						<div class="panel-group" id="accordion">
							<div class="panel panel-primary">
								<div class="panel-heading">
									<h4 class="panel-title">
										<i class="glyphicon glyphicon-user"></i> 账号管理
									</h4>
								</div>

								<div id="collapseOne" class="panel ">
									<div class="panel-body">
										<ul>
											<li><a href="userProfile.html">个人资料</a></li>
											<li><a href="userAccount.html">账号关联</a></li>
											<li><a href="userOrder.html">我的订单</a></li>
											<li><a href="userConsole.html">控制面板</a></li>
										</ul>
									</div>
								</div>
							</div>

							<div class="panel panel-success">
								<div class="panel-heading">
									<h4 class="panel-title">
										<i class="glyphicon glyphicon-th-list"> 内容管理</i>
									</h4>
								</div>

								<div class="panel ">
									<div class="panel-body">
										<ul>
											<li><a href="myLinkman.html">我的联系人</a><span
												class="badge">${authorContentCounter.linkmanCount }</span></li>
											<li>
												<hr>
											</li>
											<li><a href="myPoll.html">我的问卷</a><span class="badge">${authorContentCounter.voteCount }</span></li>
											<li><a href="myVote.html">我的投票</a><span class="badge">${authorContentCounter.pollCount }</span></li>
											<li><a href="myInfoGather.html">我的信息收集</a><span
												class="badge">${authorContentCounter.infoCount }</span></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- end of panel -->

			<div class="col-sm-6">
				<div class="page-header">
					<h3>
						控制面板<i class="glyphicon glyphicon-console"></i>
					</h3>
				</div>

				<form action="#" method="POST">

					<div class="row form-group">
						<div class="col-lg-4">联系人解析完成通知</div>
						<div class="col-lg-6">
							<input type="checkbox" name="">
						</div>
						<div class="col-lg-2"></div>
					</div>
					<div class="row form-group">
						<div class="col-lg-4">投票/问卷完成通知</div>
						<div class="col-lg-6">
							<input type="checkbox" name="">
						</div>
						<div class="col-lg-2"></div>
					</div>
					<div class="row form-group">
						<div class="col-lg-4">数据过期通知</div>
						<div class="col-lg-6">
							<input type="checkbox" name="">
						</div>
						<div class="col-lg-2"></div>
					</div>

					<div class="row form-group">
						<div class="col-lg-3">通知方式</div>

						<div class="col-lg-6">
							<div class="btn-group" role="group">
								<button type="button" class="btn btn-default">邮箱</button>
								<button type="button" class="btn btn-default">邮箱和短息</button>
								<button type="button" class="btn btn-default">短信</button>
							</div>
						</div>
						<div class="col-lg-3"></div>

					</div>

					<div class="row">
						<div class="col-lg-3"></div>
						<div class="col-lg-4">
							<input type="submit" value="修改">
						</div>
					</div>

				</form>
			</div>

			<div class="col-sm-3">
				<div class="page-header">
					<h3>相关帮助</h3>
				</div>
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

		<h3>网站备案</h3>

		<p>京201510-34534****</p>
	</div>
	</footer>

	<script
		src="${pageContext.request.contextPath}/resources/easyui/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/switch/js/bootstrap-switch.min.js"></script>
</body>
</html>