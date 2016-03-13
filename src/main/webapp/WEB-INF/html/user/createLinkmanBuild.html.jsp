<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="zh-CN">
<meta http-equiv="x-ua-compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>用户:创建联系人库</title>
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
				<li><a href="/easyvote/vote/startVote.html">投票</a></li>
				<li><a href="/easyvote/poll/startPoll.html">问卷</a></li>
				<li class="active"><a href="/easyvote/user/selfCenter.html">个人</a></li>
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

	<div class="container content">

		<div class="page-header">
			<h3>
				<i class="glyphicon glyphicon-plus"></i>创建联系人组
			</h3>
		</div>
		<div class="row">
			<div class="col-lg-10">
				<ul class="nav nav-tabs" id="createLinkman">
					<li role="presentation" class="active"><a href="#excelModel">Excel上传模式</a></li>
					<li role="presentation"><a href="#textAreaModel">文本域填写模式</a></li>
				</ul>

				<div class="tab-content">

					<div class="tab-pane active" id="excelModel">
						<br>

						<form class="form-horizontal col-lg-offset-1"
							action="/easyvote/user/createLinkmanBuildByExcel.do"
							method="POST" enctype="multipart/form-data">
							<div class="form-group">
								<label for="excelFileInput">选择Excel文件</label> <input type="file"
									id="excelFileInput" accept="application/vnd.ms-excel">

								<p class="help-block">
									你上传的Excel文件必须按照我们给定的格式。 <a
										href="../demo/processDemo.html#step02" target="_blank">查看详情</a>
								</p>
							</div>

							<div class="form-group">
								<input type="submit" class="btn btn-primary" value="上传">
							</div>
						</form>
					</div>

					<div class="tab-pane" id="textAreaModel">
						<br>

						<form:form class="form-horizontal"
							action="/easyvote/user/createLinkmanBuildByText.do"
							modelAttribute="voterGroupAndVoters" method="POST">

							<div class="form-group">
								<label class="col-md-2 control-label"
									for="defaultEmailServerInput">默认邮箱服务</label>

								<div class="col-sm-4">
									<input type="text" id="defaultEmailServerInput"
										name="defaultEmailService" class="form-control"
										placeholder="邮箱的后缀，例如@gmail.com">
								</div>
							</div>

							<div class="form-group">
								<label class="col-md-2 control-label"
									for="groupDescriptionInput">联系人组描述</label>

								<div class="col-sm-4">
									<input type="text" id="groupDescriptionInput"
										name="groupDescription" class="form-control"
										placeholder="联系人组的描述">
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-2 control-label" for="linkmanInput">联系人信息</label>

								<div class="col-sm-6">
									<textarea id="linkmanInput" name="voterText" rows="6" cols="80"
										class="form-control"
										placeholder="example@gmail.com:Alias;example@163.com:备注;"></textarea>

									<div class="help-block">
										如果有疑问,<a href="../demo/processDemo.html#step02">点击这里</a>
									</div>
								</div>
							</div>

							<div class="col-sm-4 col-sm-offset-2">
								<input type="submit" class="btn btn-success" value="提交&raquo;">
							</div>

						</form:form>

					</div>


				</div>


			</div>
			<div class="col-lg-2">
				<div class="panel panel-info">
					<div class="panel-heading">
						<h4>相关帮助</h4>
					</div>
					<div class="panel-body">
						<ul>
							<li><a href="#" target="_blank">#</a></li>
						</ul>

					</div>
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

	<script src="<%=request.getContextPath()%>/resources/easyui/jquery.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="/easyvote/staticFile/site/user/createLinkmanBuild-tab-switch.js"></script>
</body>
</html>