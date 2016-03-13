<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="x-ua-compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>投票:编辑</title>
<link rel="stylesheet" href="/easyvote/staticFile/css/bootstrap.min.css">
<link rel="stylesheet" href="/easyvote/staticFile/main.css">
<script src="/easyvote/staticFile/ckeditor/ckeditor.js"></script>
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
				<li class="active"><a href="../vote/startVote.html">投票</a></li>
				<li><a href="../poll/startPoll.html">问卷</a></li>
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
			，以此类推。<br> 3、选定值/选项值，建议使用大写英文字母。并从A开始，依次增加。每个问题在问题定义时，选项必须要至少有一个选中值。
		</div>


		<div>
			<form action="/easyvote/vote/previewVote.do" method="POST">
				<textarea id="editor" name="voteText">
					<p>1.示例单选问题？</p>

<p>
						<input name="q1" type="radio" value="A" />选项1 &nbsp; &nbsp; <input
							name="q1" type="radio" value="B" />选项2 &nbsp; &nbsp; <input
							name="q1" type="radio" value="C" />选项3 &nbsp; &nbsp;</p>

<p>2.多选实例问题？</p>

<p>
						<input name="q2" type="checkbox" value="A" />可选A &nbsp; &nbsp; <input
							name="q2" type="checkbox" value="B" />可选B &nbsp; &nbsp; <input
							name="q2" type="checkbox" value="C" />可选C</p>

<p>3.下拉选择实例问题？</p>

<p>
						<select name="q3"><option value="A">下拉选项01</option>
							<option value="B">下拉选项02</option>
							<option value="C">下拉选项03</option>
							<option value="D">下拉选项04</option> </select>
					</p>

<p>4.带有自定义域的问题？</p>

<p>
						<input name="a4" type="checkbox" />选项01 &nbsp; <input name="q4"
							type="checkbox" />选项02 &nbsp; 其他 <input name="q4" type="text"
							value="初始值" />
					</p>
           		</textarea>
				<br> <input type="submit" value="预览">
			</form>
		</div>

	</div>

	<script src="/easyvote/staticFile/js/jquery-1.11.0.min.js"></script>
	<script src="/easyvote/staticFile/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$(function() {
			CKEDITOR.replace('editor', {
				/* customConfig : '../../staticFile/ckeditor/config-advance.js' */
				customConfig : '../../staticFile/ckeditor/config-vote.js'
			});
		});
	</script>
</body>
</html>