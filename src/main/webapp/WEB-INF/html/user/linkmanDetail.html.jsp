﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="zh-CN">
<meta http-equiv="x-ua-compatible" content="IE=edge">
<title>用户:联系人详情</title>
<link rel="stylesheet" href="/easyvote/staticFile/css/bootstrap.min.css">
<link rel="stylesheet" href="/easyvote/staticFile/main.css">
</head>
<body>

	<nav class="navbar navbar-default ">
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
		<ol class="breadcrumb">
			<li><a href="/easyvote/index.html">首页</a></li>
			<li><a href="/easyvote/user/selfCenter.html"> 个人中心</a></li>
			<li><a href="/easyvote/user/myLinkman.html"> 联系人管理</a></li>
			<li class="active">联系人详细信息</li>
		</ol>
		<div class="row">
			<div class="col-sm-8">
				<div class="page-header">
					<h3>
						<i class="glyphicon glyphicon-th-list"></i> 联系人详情 <small>${description }</small>
					</h3>
				</div>

				<table class="table table-bordered table-hover table-condensed">
					<thead class="alert-info">
						<tr>
							<td>联系人邮箱</td>
							<th>备注</th>
							<td class="text-center">删除</td>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${ voters}" var="voter">
							<tr>
								<td><b class="dblclick" id="${voter.id }">${voter.email }</b></td>
								<td>${voter.alias }</td>
								<td><a href="/easyvote/user/linkmanDel/${voter.id }">删除</a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>

			<div class="col-sm-3"></div>
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

	<script src="/easyvote/staticFile/js/jquery-1.11.0.min.js"></script>
	<script src="/easyvote/staticFile/js/bootstrap.min.js"></script>
	<script src="../../js/jquery.jeditable.js"></script>
	<script src="../../js/user/linkmanDetailEdit.js"></script>
</body>
</html>