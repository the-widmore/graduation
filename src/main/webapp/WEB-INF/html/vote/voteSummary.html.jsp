<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="x-ua-compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>投票:预览</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/main.css">
<style>
.title {
	font-size: 2em;
	text-align: center;
}

.row {
	margin: 50px 0px;
}

.voteInfo {
	background-color: #52d689;
	border-radius: 20px;
	text-align: center;
	height: 30px;
}
</style>
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
			<a class="navbar-brand" href="/index.html">EasyVote</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="../../index.html">首页</a></li>
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

	<div class="container content">

		<div class="title">${vote.title }</div>

		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-1 text-right">标签</div>
			<div class="col-md-6">
				<c:forEach items="${vote.tags }" var="tag">
					<span class="label label-default">${tag }</span>
				</c:forEach>
			</div>
			<div class="col-md-2"></div>
		</div>

		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-2">
				<div class="bg-info">
					<p style="text-align: center">创建时间</p>

					<div class="voteInfo">${voteSummary.createTime }</div>
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-2">
				<div class="bg-info">
					<p style="text-align: center">剩余时间</p>

					<div class="voteInfo">${voteSummary.surplusTime }</div>
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-2">
				<div class="bg-info">
					<p style="text-align: center">结束时间</p>

					<div class="voteInfo">${voteSummary.endTime }</div>
				</div>
			</div>
			<div class="col-md-2"></div>
		</div>

		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-2">
				<div class="bg-info">
					<p style="text-align: center">点击次数</p>

					<div class="voteInfo">345</div>
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-2">
				<div class="bg-info">
					<p style="text-align: center">提交次数</p>

					<div class="voteInfo">${voteSummary.submitTimes }</div>
				</div>
			</div>
			<div class="col-md-1"></div>
			<div class="col-md-2">
				<div class="bg-info">
					<p style="text-align: center">授权方式</p>

					<div class="voteInfo">${voteSummary.auth }</div>
				</div>
			</div>
			<div class="col-md-2"></div>
		</div>

		<div class="row">
			<div class="col-md-8"></div>
			<div class="col-md-4 btn-group">
				<button class="btn btn-danger">清空数据</button>
				<button class="btn btn-danger">现在结束</button>
			</div>
		</div>


	</div>


<%@ include file="../reusable/footer.jsp" %>

	<script
		src="${pageContext.request.contextPath}/resources/easyui/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>