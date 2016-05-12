<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		<form:form class="form-horizontal" role="form"
			action="${pageContext.request.contextPath}/vote/publish.do"
			method="POST">

			<div class="form-group">
				<label class="col-md-2 control-label"></label>

				<div class="col-sm-4">
					<input type="hidden" name="voteId" value="${voteId }">
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label">标题</label>

				<div class="col-sm-4">
					<input type="text" class="form-control" name="title"
						value="${title }" readonly>
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label">结束时间</label>

				<div class="col-sm-4">
					<input type="text" name="endDate" class="form-control"
						placeholder="yyyy-MM-dd hh:mm">
				</div>
			</div>

			<!-- <div class="form-group">
				<label class="col-md-2 control-label">封面</label>

				<div class="col-sm-4">
					<input type="file" name="cover" class="form-control"
						accept="image/jpeg,image/png">
				</div>
			</div> -->

			<div class="form-group">
				<label class="col-md-2 control-label">授权方式</label>

				<div class="col-sm-4">
					<select name="authType" class="form-control" id="auth">
						<option value="PUBLIC">公开</option>
						<option value="PROTECTED">保护</option>
						<option value="PRIVATE">私有</option>
					</select>
				</div>
			</div>

			<div class="form-group" id="voteGroup">
				<label class="col-md-2 control-label">联系人组</label>
				<div class="col-sm-6">
					<table class="table">
						<thead>
							<tr>
								<th>选择</th>
								<th>组描述</th>
								<th>人数</th>
								<th>时间</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${voterGroupVos }" var="voterGroup">
								<tr>
									<td><input type="checkbox" name="voteGroup"
										value="${ voterGroup.id}"></td>
									<td>${voterGroup.description }</td>
									<td>${voterGroup.quantity }</td>
									<td>${voterGroup.inDate}</td>
								</tr>
							</c:forEach>

						</tbody>
					</table>
				</div>
			</div>

			<div class="form-group">
				<div class="col-md-2"></div>
				<input type="submit" value="发布" class="btn btn-primary">
			</div>

		</form:form>
	</div>

	<%@ include file="../reusable/footer.jsp" %>

	<script
		src="${pageContext.request.contextPath}/resources/easyui/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>

	<script type="application/javascript">
		
	$(document).ready(function(){
        $("#voteGroup").hide();
        $("#auth").change(function(){
            var checked=$("#auth").val();
            if("PRIVATE"==checked){
                $("#voteGroup").show();
            }else{
                $("#voteGroup").hide();
            }
        });
    });
	
	</script>
</body>
</html>