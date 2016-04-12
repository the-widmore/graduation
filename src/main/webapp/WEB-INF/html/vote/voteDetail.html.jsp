<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="zh-CN">
<meta http-equiv="x-ua-compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>投票:详细情</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main.css">

</head>
<body>

	<nav class="navbar navbar-default">
	<div class="container content">
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
				<li><a href="/index.html">首页</a></li><li><a href="${pageContext.request.contextPath}/search/">搜索</a></li>
				<li class="active"><a href="../vote/startVote.html">投票</a></li>
				<li><a href="../user/selfCenter.html">个人</a></li>
				<li><a href="../demo/demo.html">演示</a></li>
				<li><a href="../help/help.html">帮助</a></li>
				<li><a href="../about/about.html">关于</a></li>
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
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-10">
				<div class="page-header">
					<h3>
						<i class="glyphicon glyphicon-stats"></i>这个投票的详细信息
					</h3>
				</div>
				<table class="table table-striped table-bordered table-responsive">
					<tr>
						<td>邮箱</td>
						<td>备注</td>
						<td>是否完成</td>
						<td>完成时间</td>
						<td>操作</td>
					</tr>
					<tr>
						<td>chenyiyuan00@163.com</td>
						<td>boos</td>
						<td class="text-primary">完成</td>
						<td>2015/10/12 09:32</td>
						<td><a href="#">重填</a></td>
					</tr>
					<tr>
						<td>chenyiyuan00@163.com</td>
						<td>boos</td>
						<td class="text-primary">完成</td>
						<td>2015/10/12 09:32</td>
						<td><a href="#">重填</a></td>
					</tr>
					<tr>
						<td>chenyiyuan00@163.com</td>
						<td>boos</td>
						<td class="text-primary">完成</td>
						<td>2015/10/12 09:32</td>
						<td><a href="#">重填</a></td>
					</tr>
					<tr>
						<td>chenyiyuan00@163.com</td>
						<td>boos</td>
						<td class="text-primary">完成</td>
						<td>2015/10/12 09:32</td>
						<td><a href="#">重填</a></td>
					</tr>
					<tr>
						<td>chenyiyuan00@163.com</td>
						<td>boos</td>
						<td class="text-primary">完成</td>
						<td>2015/10/12 09:32</td>
						<td><a href="#">重填</a></td>
					</tr>
					<tr>
						<td>chenyiyuan00@163.com</td>
						<td>boos</td>
						<td class="text-primary">完成</td>
						<td>2015/10/12 09:32</td>
						<td><a href="#">重填</a></td>
					</tr>
					<tr>
						<td>chenyiyuan00@163.com</td>
						<td>boos</td>
						<td class="text-primary">完成</td>
						<td>2015/10/12 09:32</td>
						<td><a href="#">重填</a></td>
					</tr>
					<tr>
						<td>chenyiyuan00@163.com</td>
						<td>boos</td>
						<td class="text-primary">完成</td>
						<td>2015/10/12 09:32</td>
						<td><a href="#">重填</a></td>
					</tr>
					<tr>
						<td>chenyiyuan00@163.com</td>
						<td>boos</td>
						<td class="text-primary">完成</td>
						<td>2015/10/12 09:32</td>
						<td><a href="#">重填</a></td>
					</tr>
					<tr>
						<td>chenyiyuan00@163.com</td>
						<td>boos</td>
						<td class="text-primary">完成</td>
						<td>2015/10/12 09:32</td>
						<td><a href="#">重填</a></td>
					</tr>
					<tr>
						<td>chenyiyuan00@163.com</td>
						<td>boos</td>
						<td class="text-primary">完成</td>
						<td>2015/10/12 09:32</td>
						<td><a href="#">重填</a></td>
					</tr>
					<tr>
						<td>chenyiyuan00@163.com</td>
						<td>boos</td>
						<td class="text-primary">完成</td>
						<td>2015/10/12 09:32</td>
						<td><a href="#">重填</a></td>
					</tr>
					<tr>
						<td>chenyiyuan00@163.com</td>
						<td>boos</td>
						<td class="text-primary">完成</td>
						<td>2015/10/12 09:32</td>
						<td><a href="#">重填</a></td>
					</tr>
					<tr>
						<td>chenyiyuan00@163.com</td>
						<td>boos</td>
						<td class="text-primary">完成</td>
						<td>2015/10/12 09:32</td>
						<td><a href="#">重填</a></td>
					</tr>
					<tr>
						<td>chenyiyuan00@163.com</td>
						<td>boos</td>
						<td class="text-primary">完成</td>
						<td>2015/10/12 09:32</td>
						<td><a href="#">重填</a></td>
					</tr>
				</table>
				<ul class="pagination ">
					<li class="disabled"><a href="#"> &laquo;</a></li>
					<li class="active"><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">6</a></li>
					<li><a href="#">7</a></li>
					<li><a href="#">...</a></li>
					<li><a href="#">&raquo;</a></li>
				</ul>
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

	<script src="${pageContext.request.contextPath}/resources/easyui/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>