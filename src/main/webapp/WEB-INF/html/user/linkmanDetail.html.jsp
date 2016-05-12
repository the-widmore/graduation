<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head lang="zh-CN">
<meta http-equiv="x-ua-compatible" content="IE=edge">
<title>用户:联系人详情</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/main.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/easyui/themes/default/easyui.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/easyui/themes/icon.css">
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
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">EasyVote</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="${pageContext.request.contextPath}/">首页</a></li>
				<li><a href="${pageContext.request.contextPath}/search/">搜索</a></li>
				<li><a
					href="${pageContext.request.contextPath}/vote/startVote.html">投票</a></li>
				<li class="active"><a
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
			<li><a href="${pageContext.request.contextPath}/index.html">首页</a></li>
			<li><a
				href="${pageContext.request.contextPath}/user/selfCenter.html">
					个人中心</a></li>
			<li><a
				href="${pageContext.request.contextPath}/user/myLinkman.html">
					联系人管理</a></li>
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
							<td>电 话</td>
							<th>备 注</th>
							<td class="text-center">删除</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${voters}" var="voter">
							<tr>
								<td><div id="voter_${voter.id }_email" class="voterInfo">${voter.email }</div></td>
								<td><div id="voter_${voter.id }_phone" class="voterInfo">${voter.phone }</div></td>
								<td><div id="voter_${voter.id }_alias" class="voterInfo">${voter.alias }</div></td>
								<td><a
									href="${pageContext.request.contextPath}/user/linkmanDel/${voter.id }">删除</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- pager TODO -->
				<ul class="pagination">
					<li><a href="#">&laquo;</a></li>
					<li class="active"><a href="#">1</a></li>
					<li><a href="#">2</a></li>
					<li><a href="#">3</a></li>
					<li><a href="#">4</a></li>
					<li><a href="#">5</a></li>
					<li><a href="#">&raquo;</a></li>
				</ul>
			</div>

			<div class="col-sm-3"></div>
		</div>
	</div>

	<%@ include file="../reusable/footer.jsp" %>

	<script
		src="${pageContext.request.contextPath}/resources/easyui/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/easyui/jquery.easyui.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/resources/jeditable/jquery.jeditable.js"></script>
	<!-- TODO editable JS -->
	<script type="application/javascript">
		
	 $(document).ready(function () {
	        $(".voterInfo").editable("http://localhost:8080/graduation/voter/updateVoterField", {
	            submit: "Ok",
	            tooltip: "Click to edit ...",
/* 	            callback: function (value, settings) {
	                console.log("value:" + value)
	                console.log("settings:" + settings)
	            } */
	        });
	    });
	
	</script>
</body>
</html>