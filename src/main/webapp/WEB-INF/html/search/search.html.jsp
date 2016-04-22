<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/main.css">
</head>
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
					<li class="active"><a
						href="${pageContext.request.contextPath}/search/">搜索</a></li>
					<li><a
						href="${pageContext.request.contextPath}/vote/startVote.html">投票</a></li>
					<li><a
						href="${pageContext.request.contextPath}/user/selfCenter.html">个人</a></li>
					<li><a
						href="${pageContext.request.contextPath}/demo/demo.html">演示</a></li>
					<li><a
						href="${pageContext.request.contextPath}/help/help.html">帮助</a></li>
					<li><a
						href="${pageContext.request.contextPath}/about/about.html">关于</a></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">更多<span class="caret"></span></a>
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

				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-6">
				<form class="form-search">
					<div class="input-group" style="margin-top: 30px">
						<span class="input-group-addon"><select>
								<option>按标签</option>
								<option>标题</option>
								<option>标签个标题</option>
						</select></span> <input type="text" class="form-control" placeholder="Key Words">
						<span class="input-group-addon"><input type="submit"
							value="Search"></span>
					</div>
					<!--<input class="input-medium search-query" type="text"/>
                <button type="submit" class="btn">查找</button>-->
				</form>
			</div>
			<div class="col-lg-4">
				<div class="panel panel-default">
					<div class="panel-body">
						<span class="label label-default">Label1</span> <span
							class="label label-default">Label1</span> <span
							class="label label-default">Label1</span> <span
							class="label label-default">Label1</span> <span
							class="label label-default">Label1</span>

						<p></p>
						<span class="label label-default">Label1</span> <span
							class="label label-default">Label1</span> <span
							class="label label-default">Label1</span> <span
							class="label label-default">Label1</span> <span
							class="label label-default">Label1</span>
					</div>
				</div>
			</div>
			<div class="col-lg-1"></div>
		</div>

		<div style="margin: 20px 0;">
			<div class="btn-group col-lg-push-2">
				<button class="btn btn-default">时间排序</button>
				<button class="btn btn-default">热度排序</button>
			</div>
		</div>

		<div class="row">
			<div class="col-lg-1"></div>
			<div class="col-lg-8">
				<div class="media well">
					<a class="pull-left" href="#"><img
						class="media-object thumbnail"
						src="${pageContext.request.contextPath}/resources/image/defaultCover.jpg"
						alt='' /></a>

					<div class="media-body">
						<h4 class="media-heading">title</h4>
					</div>
				</div>
				<div class="media well">
					<a class="pull-left" href="#"><img
						class="media-object thumbnail"
						src="${pageContext.request.contextPath}/resources/image/defaultCover.jpg"
						alt='' /></a>

					<div class="media-body">
						<h4 class="media-heading">
							<b>【标题 】</b>${vote.title }</h4>
						<p>【作者】：${vote.authorName }</p>
						<p>【标签】：${vote.tags }</p>
						<p>【时间】：${vote.startTime } - ${vote.endTime }</p>
						<p>【热度】：${vote.hot }</p>
					</div>
				</div>
			</div>
			<div class="col-lg-3">
				<h2>Top list</h2>
			</div>
		</div>
	</div>
	<script type="application/javascript"
		src="${pageContext.request.contextPath}/resources/easyui/jquery.min.js"></script>
	<script type="application/javascript"
		src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
	<script type="application/javascript"
		src="${pageContext.request.contextPath}/resources/easyui/jquery.easyui.min.js"></script>
</body>
</html>