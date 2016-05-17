<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="zh-CN">
<meta http-equiv="x-ua-compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>收集结果</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/c3/c3.min.css">
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

	<div class="jumbotron" style="margin: 20px 5%"></div>

	<!-- 容器-->
	<div class="content container">

		<div class="row">


			<div class="col-sm-8 col-md-8 col-lg-6">
				<pre class="pre-scrollable" style="min-height: 1000px"
					voteId="${voteId }" id="voteContent">
				//replace content
           		</pre>
			</div>

			<div class="col-sm-4 col-md-4 col-lg-4">
				<div class="pre-scrollable" style="min-height: 1000px"
					questions="${questions }" id="chart">
					<c:forEach var="i" begin="1" end="${questions }">
						<div class="chart" id="chart_q${i }"></div>
					</c:forEach>
				</div>
			</div>

		</div>


	</div>

	<div class="col-md-1 col-lg-1"></div>


	<%@ include file="../reusable/footer.jsp"%>

	<script
		src="${pageContext.request.contextPath}/resources/easyui/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/c3/d3.v3.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/c3/c3.min.js"></script>

	<script type="text/javascript">
		$(function() {
			var voteId = $("#voteContent").attr("voteId");
			var questions = $("#chart").attr("questions");
			console.log("voteId:"+voteId);
			console.log("questions:"+questions);
			for (var i = 1; i <= questions; i++) {
				var aurl ="http://localhost:8080/graduation/data/chart/"+voteId+'/'+i;
				console.log("url:"+aurl);
				c3.generate({
					bindto : "#chart_q" + i,
					data : {
						url : 'http://localhost:8080/graduation/data/chart/'
								+ voteId + '/' + i,
						mimeType : 'json',
						type : 'pie'
					}
				});
			}
		});
	</script>
</body>
</html>