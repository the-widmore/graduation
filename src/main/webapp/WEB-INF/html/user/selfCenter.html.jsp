<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="zh-CN">
<meta http-equiv="x-ua-compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>用户:个人中心</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
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
				<li><a href="${pageContext.request.contextPath}/">首页</a></li><li><a href="${pageContext.request.contextPath}/search/">搜索</a></li>
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
						<li><a
							href="${pageContext.request.contextPath}/more/activity.html">活动</a></li>
						<li class="divider"></li>
						<li class="dropdown-header">隐私政策</li>
						<li><a
							href="${pageContext.request.contextPath}/more/userData.html">用户数据</a></li>
						<li><a
							href="${pageContext.request.contextPath}/more/platformPolicy.html">平台政策</a></li>
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
			<li><a href="${pageContext.request.contextPath}/">首页</a></li>
			<li class="active">个人中心</li>
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
											<li><a href="userProfile.html">个人资料 </a></li>
											<li><a href="userAccount.html">账号关联 </a></li>
											<li><a href="userOrder.html">我的订单 </a></li>
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

			<div class="col-sm-9">
				<div class="row">
					<div class="page-header">
						<h3>账号管理</h3>
					</div>
					<div class="col-sm-4 col-sm-offset-1">
						<h3>个人账号</h3>

						<p>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;你可以查看和修改你的账号的基本信息。这里包括了账号的昵称、密码和<a
								href="${pageContext.request.contextPath}/about/secondPassword.html">
								二级密码</a>。
						</p>
						<a href="userProfile.html" role="button" class="btn btn-default">查看详细&raquo;</a>
					</div>

					<div class="col-sm-2"></div>

					<div class="col-sm-4">
						<h3>账号关联</h3>

						<p>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;你可以将EasyVote的账号与其他网络平台相关联，这将极大的方便投票的发布。我们正在努力支持更多的平台。
						</p>
						<a href="userAccount.html" role="button" class="btn btn-default">查看详细&raquo;</a>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-4 col-sm-offset-1">
						<h3>我的订单</h3>

						<p>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;你可以购买EasyVote的<a href="#">增值套餐</a>。我们提供了多种不同的套餐，总有适合你的。
						</p>
						<a href="userOrder.html" role="button" class="btn btn-default">查看详细&raquo;</a>
					</div>
					<div class="col-sm-2"></div>
					<div class="col-sm-4">
						<h3>控制面板</h3>

						<p>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;这里你可以根据你自己的愿望设置通知的方式，和数据导出时是否启用二级密码加密Excel文件。
						</p>
						<a href="userConsole.html" role="button" class="btn btn-default">查看详细&raquo;</a>

					</div>
				</div>

				<div class="row">
					<div class="page-header">
						<h3>内容管理</h3>
					</div>

					<div class="col-sm-4 col-sm-offset-1">
						<h3>我的联系人</h3>

						<p>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;查看和管理你的联系人版本，进而修改联系人。你也可以进行创建和删除。你可以参考联系人上传
							<a href="../demo/linkmanUpload.html">演示</a>
						</p>
						<a href="myLinkman.html" role="button" class="btn btn-default">查看详细&raquo;</a>
					</div>

					<div class="col-sm-2"></div>
					<div class="col-sm-4">
						<h3>我的投票</h3>

						<p>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;查看你发起的投票的一些信息(主题、时间、参加的人数等)，进入后你可以进行更多的操作。不包括问卷调查的结果数据（<a
								href="../about/dataSave.html">关于数据</a> ）。
						</p>
						<a href="myPoll.html" role="button" class="btn btn-default">查看详细&raquo;</a>
					</div>
				</div>

				<div class="row">
					<div class="col-sm-4 col-sm-offset-1">
						<h3>我的问卷</h3>

						<p>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;查看你发起的问卷调查的基本信息(发起的和结束的时间、主题、邀请参与的联系人版本库)。这里也是你问卷数据导出的入口。
						</p>
						<a href="myPoll.html" role="button" class="btn btn-default">查看详细&raquo;</a>
					</div>

					<div class="col-sm-2"></div>

					<div class="col-sm-4">
						<h3>我的信息收集</h3>

						<p>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;信息收集是问卷调查的子类型。使用信息收集你可以选择，信息收集的侧重点帮助你简化工作。这里你可以查看你发起的信息收集。
						</p>
						<a href="myInfoGather.html" role="button" class="btn btn-default">查看详细&raquo;</a>
					</div>
				</div>

			</div>
		</div>


		<div class="page-header">
			<h3>
				<i class="glyphicon glyphicon-tags"></i> 活动
			</h3>
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
</body>
</html>
</html>