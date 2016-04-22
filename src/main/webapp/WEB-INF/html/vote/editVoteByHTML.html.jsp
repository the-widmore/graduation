<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="x-ua-compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>投票:编辑</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/main.css">
<script
	src="${pageContext.request.contextPath}/resources/ckeditor/ckeditor.js"></script>
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
		<ol class="breadcrumb">
			<li><a href="../../index.html">首页</a></li>
			<li><a href="startVote.html">投票</a></li>
			<li class="active">编辑投票</li>
		</ol>

		<div class="jumbotron">
			<h3>编辑约定</h3>
			1、你只需要填写问题和选项即可。<br>
			2、在添加问题选项时，选项的名称必须填写，并每个问题的选项的名称必须相同。第1个问题就用
			<kbd>q1</kbd>
			，以此类推。<br> 3、选定值/选项值，建议使用大写英文字母。并从大写的英文字母A开始，依次增加。<br>
			4、如果，你没有完成编辑，也可以进行提交。下一次将上一次的基础上继续编辑。
		</div>


		<div>
			<form:form
				action="${pageContext.request.contextPath}/vote/submitVote.do"
				method="POST">
				<input type="hidden" name="id" value="${voteId }">
				<textarea id="editor" name="content">
					${voteContent }
           		</textarea>
				<br>
				<input type="submit" value="提交" class="btn btn-default">
				可以使用编辑器
				<kbd>打印</kbd>
				傍边的工具按钮进行预览。
			</form:form>
		</div>
	</div>

	<br>
	<br>
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
	<script type="text/javascript">
		//customConfig : '../../resources/ckeditor/config-vote.js',
		$(function() {
			CKEDITOR.replace('editor', {
				allowedContent : 'input[*]',
				customConfig : '../../resources/ckeditor/config-vote.js',
			});
			editor.on('instanceReady', function() {
				console.log(editor.filter.allowedContent);
			});
		});
	</script>
</body>
</html>