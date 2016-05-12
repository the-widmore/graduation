<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head lang="zh-CN">
<meta http-equiv="x-ua-compatible" content="IE=edge">
<title>EasyVote::投票:创建</title>
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
				<li><a href="${pageContext.request.contextPath}/">首页</a></li>
				<li><a href="${pageContext.request.contextPath}/search/">搜索</a></li>
				<li class="active"><a
					href="${pageContext.request.contextPath}/vote/startVote.html">投票</a></li>
				<li><a
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

				<form:form class="form-horizontal"
					action="createVote.do"
					method="POST">

					<div class="form-group">
						<label class="control-label col-md-2" for="voteTitleInput">投票标题</label>

						<div class="col-md-6">
							<input type="text" class="form-control" id="voteTitleInput"
								name="title" required>
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2" for="voteTagInput">投票标签</label>

						<div class="col-md-6">
							<input type="text" class="form-control" id="voteTagInput"
								placeholder="使用分号,逗号,空格分割 最多5个" name="tags">
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-md-2">编辑模式</label>

						<div class="col-md-6">
							<select class="form-control" name="editMode">
								<option value="html">HTML模式</option>
								<option value="visible">拖拽编辑</option>
							</select>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-6 col-md-offset-2">
							<input type="submit" role="button" class="btn btn-primary"
								value="创建并编辑">
						</div>
					</div>


				</form:form>

			</div>

			<div class="col-md-3"></div>

		</div>
	</div>

<%@ include file="../reusable/footer.jsp" %>

	<script
		src="${pageContext.request.contextPath}/resources/easyui/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>