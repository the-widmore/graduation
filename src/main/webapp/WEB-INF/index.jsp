<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="zh-CN">
<meta http-equiv="x-ua-compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="EasyVote是一个信息收集和简单分析的网站。">
<meta name="author" content="Carbon.ken">
<meta name="keyWords" content="EasyVote,Vote,Poll,">
<title>EasyVote首页</title>
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
				<li class="active"><a
					href="${pageContext.request.contextPath}/">首页</a></li>
				<li><a href="${pageContext.request.contextPath}/search/">搜索</a></li>
				<li><a
					href="${pageContext.request.contextPath}/vote/startVote.html">问卷</a></li>
				<li><a
					href="${pageContext.request.contextPath}/user/selfCenter.html">个人</a></li>
				<li><a href="${pageContext.request.contextPath}/demo/demo.html">演示</a></li>
				<li><a href="${pageContext.request.contextPath}/help/help.html">帮助</a></li>
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
				<%@ include file="html/user/userBar.jsp"%>
			</ul>
		</div>
	</div>
	</nav>

	<div class="container content">
		<div class="jumbotron">
			<h3>EasyVote</h3>

			<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;EasyVote是一个网上投票、问卷调查、信息收集、信息分析的平台，使用它可以更简单的完成这一切。
				<a href="${pageContext.request.contextPath}/about/about.html"
				role="button" class="btn btn-sm btn-info">了解更多...</a>
			</b> <br> <br> <b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;我们从设计到实现都以用户为中心，让用户可以根据自己需要自定义投票和问卷的问题和选项。
				每项投票和问卷用户都可以由发起人控制，加上方便实用的联系人管理和数据导出功能。</b>

			<p>
				<a class="btn btn-sm btn-primary"
					href="${pageContext.request.contextPath}/vote/startVote.html"
					role="button">发起投票 &raquo;</a> <a class="btn btn-sm btn-success"
					href="${pageContext.request.contextPath}/poll/startPoll.html"
					role="button">发起问卷调查 &raquo;</a>
			</p>

			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在正式使用我们的平台，建议你先阅读<a
				target="_blank"
				href="${pageContext.request.contextPath}/demo/demo.html">演示</a>&raquo;
			<a target="_blank"
				href="${pageContext.request.contextPath}/demo/processDemo.html">过程演示。</a>可以帮你了解更多功能，一可以简化后续工作。
		</div>
		<!--end  jumbotron-->

		<div class="page-header">
			<h3>
				为什么选择EasyVote<i class="glyphicon glyphicon-question-sign"></i>
			</h3>
		</div>
		<div class="row">
			<div class="col-sm-3">
				<div class="panel">
					<div class="panel-title">
						<h3>
							<i class="glyphicon glyphicon-thumbs-up"></i> 方便实用
						</h3>
					</div>
					<div class="panel-body">
						<ul>
							<li><a
								href="${pageContext.request.contextPath}/vote/startVote.html">轻松发起投票</a></li>
							<li><a
								href="${pageContext.request.contextPath}/user/myLinkman.html">轻松管理投票人</a></li>
							<li><a
								href="${pageContext.request.contextPath}/demo/exportData.html">轻松将数据导出Excel</a></li>
							<li><a
								href="${pageContext.request.contextPath}/demo/voteChart.html">
									轻松导出投票图表</a></li>
						</ul>
					</div>
				</div>
			</div>

			<div class="col-sm-3">
				<div class="panel">
					<div class="panel-title">
						<h3>
							<i class="glyphicon glyphicon-thumbs-up"></i> 样式多样
						</h3>
					</div>
					<div class="panel-body">
						<ul>
							<li><a
								href="${pageContext.request.contextPath}/demo/linkmanUpload.html">联系人上传多样</a></li>
							<li><a
								href="${pageContext.request.contextPath}/demo/pollType.html">问卷形式丰富</a></li>
							<li><a
								href="${pageContext.request.contextPath}/demo/voteChart.html">投票报表多样性</a></li>
							<li><a
								href="${pageContext.request.contextPath}/demo/phoneDemo.html">兼容移动设备</a></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="panel">
					<div class="panel-title">
						<h3>
							<i class="glyphicon glyphicon-thumbs-up"></i> 安全可靠
						</h3>
					</div>
					<div class="panel-body">
						<ul>
							<li><a
								href="${pageContext.request.contextPath}/about/systemSecurity.html">系统加固，保证正常运行</a></li>
							<li><a
								href="${pageContext.request.contextPath}/demo/pollResultShare.html">权限控制，可以共享结果</a></li>
							<li><a
								href="${pageContext.request.contextPath}/about/dataSave.html">数据机密保护你的隐私</a></li>
						</ul>
					</div>
				</div>
			</div>

			<div class="col-sm-3">
				<div class="panel">
					<div class="panel-title">
						<h3>
							<i class="glyphicon glyphicon-thumbs-up"></i> 数据分析
						</h3>
					</div>
					<div class="panel-body">
						<ul>
							<li><a
								href="${pageContext.request.contextPath}/demo/voteSummary.html">投票信息摘要</a></li>
							<li><a
								href="${pageContext.request.contextPath}/demo/voteChart.html">投票百分比分布</a></li>
							<li><a
								href="${pageContext.request.contextPath}/demo/advanceDataAnalyse.html">高级数据分析（定制）</a></li>
						</ul>
					</div>
				</div>
			</div>

		</div>
		<div class="page-header">
			<h3>
				<i class="glyphicon glyphicon-pushpin"></i> 成功案例
			</h3>
		</div>

		<div class="row">

			<div class="col-lg-2 col-sm-3 col-xs-4">
				<a href="#"> <img
					src="${pageContext.request.contextPath}/resources/image/neusoft.jpg"
					class="thumbnail img-responsive">
				</a>
				<p>成都东软学院十佳歌手</p>
			</div>
			<div class="col-lg-2 col-sm-3 col-xs-4">
				<a href="#"> <img
					src="${pageContext.request.contextPath}/resources/image/neusoft.jpg"
					class="thumbnail img-responsive">
				</a>
				<p>成都东软学院十佳歌手</p>
			</div>
			<div class="col-lg-2 col-sm-3 col-xs-4">
				<a href="#"> <img
					src="${pageContext.request.contextPath}/resources/image/neusoft.jpg"
					class="thumbnail img-responsive">
				</a>
				<p>成都东软学院十佳歌手</p>
			</div>
			<div class="col-lg-2 col-sm-3 col-xs-4">
				<a href="#"> <img
					src="${pageContext.request.contextPath}/resources/image/neusoft.jpg"
					class="thumbnail img-responsive">
				</a>
				<p>成都东软学院十佳歌手</p>
			</div>
			<div class="col-lg-2 col-sm-3 col-xs-4">
				<a href="#"> <img
					src="${pageContext.request.contextPath}/resources/image/neusoft.jpg"
					class="thumbnail img-responsive">
				</a>
				<p>成都东软学院十佳歌手</p>
			</div>
			<div class="col-lg-2 col-sm-3 col-xs-4">
				<a href="#"> <img
					src="${pageContext.request.contextPath}/resources/image/neusoft.jpg"
					class="thumbnail img-responsive">
				</a>
				<p>成都东软学院十佳歌手</p>
			</div>
			<div class="col-lg-2 col-sm-3 col-xs-4">
				<a href="#"> <img
					src="${pageContext.request.contextPath}/resources/image/neusoft.jpg"
					class="thumbnail img-responsive">
				</a>
				<p>成都东软学院十佳歌手</p>
			</div>
			<div class="col-lg-2 col-sm-3 col-xs-4">
				<a href="#"> <img
					src="${pageContext.request.contextPath}/resources/image/neusoft.jpg"
					class="thumbnail img-responsive">
				</a>
				<p>成都东软学院十佳歌手</p>
			</div>
			<div class="col-lg-2 col-sm-3 col-xs-4">
				<a href="#"> <img
					src="${pageContext.request.contextPath}/resources/image/neusoft.jpg"
					class="thumbnail img-responsive">
				</a>
				<p>成都东软学院十佳歌手</p>
			</div>
			<div class="col-lg-2 col-sm-3 col-xs-4">
				<a href="#"> <img
					src="${pageContext.request.contextPath}/resources/image/neusoft.jpg"
					class="thumbnail img-responsive">
				</a>
				<p>成都东软学院十佳歌手</p>
			</div>
			<div class="col-lg-2 col-sm-3 col-xs-4">
				<a href="#"> <img
					src="${pageContext.request.contextPath}/resources/image/neusoft.jpg"
					class="thumbnail img-responsive">
				</a>
				<p>成都东软学院十佳歌手</p>
			</div>
			<div class="col-lg-2 col-sm-3 col-xs-4">
				<a href="#"> <img
					src="${pageContext.request.contextPath}/resources/image/neusoft.jpg"
					class="thumbnail img-responsive">
				</a>
				<p>成都东软学院十佳歌手</p>
			</div>


		</div>
		<div class="page-header">
			<h4>
				<i class="glyphicon glyphicon-link"></i>友情连接
			</h4>
			<a href="#"> 微信 </a> <a href="#"> 微博 </a> <a href="#"> QQ </a> <a
				href="#"> Google+ </a>
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