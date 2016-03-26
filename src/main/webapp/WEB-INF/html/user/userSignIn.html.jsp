<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="zh-CN">
<meta http-equiv="x-ua-compatible" content="IE=edge">
<title>用户:注册</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main.css">
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
				<li><a href="${pageContext.request.contextPath}/">首页</a></li><li><a href="${pageContext.request.contextPath}/search/">搜索</a></li>
				<li><a href="${pageContext.request.contextPath}/vote/startVote.html">投票</a></li>
				<li><a href="${pageContext.request.contextPath}/poll/startPoll.html">问卷</a></li>
				<li class="active"><a href="${pageContext.request.contextPath}/user/selfCenter.html">个人</a></li>
				<li><a href="${pageContext.request.contextPath}/demo/demo.html">演示</a></li>
				<li><a href="${pageContext.request.contextPath}/help/help.html">帮助</a></li>
				<li><a href="${pageContext.request.contextPath}/about/about.html">关于</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">更多 <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/more/activity.html">活动</a></li>
						<li class="divider"></li>
						<li class="dropdown-header">隐私政策</li>
						<li><a href="${pageContext.request.contextPath}/more/userData.html">用户数据</a></li>
						<li><a href="${pageContext.request.contextPath}/more/platformPolicy.html">平台政策</a></li>
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
			<div class="col-sm-8">
				<h2>用户注册</h2>

				<form:form class="form-horizontal" method="POST"
					action="${pageContext.request.contextPath}/user/userSignIn.do" modelAttribute="userRegister"
					data-toggle="validator" role="form" id="signInForm">
					<div class="form-group">
						<label for="emailInput" class="col-md-2 control-label">邮箱
							*</label>

						<div class="col-sm-4">
							<input type="email" class="form-control" id="emailInput"
								name="email" placeholder="你的邮箱" data-error="邮件格式不正确" required>
						</div>
						<div class="help-block with-errors"></div>
					</div>

					<div class="form-group">
						<label for="passwordInput" class="col-md-2 control-label">密码
							*</label>

						<div class="col-sm-4">
							<input type="password" class="form-control" id="passwordInput"
								name="password" placeholder="输入密码" data-minlength="6"
								data-error="密码最小长度为6个字符" required>
						</div>
						<div class="help-block with-errors">${errorMessageEmail }</div>
					</div>

					<div class="form-group">
						<label for="rePasswordInput" class="col-md-2 control-label">重复密码
							*</label>

						<div class="col-sm-4">
							<input type="password" class="form-control" id="rePasswordInput"
								name="rePassword" placeholder="再次输入密码"
								data-match="#passwordInput" data-error="两次密码不一致" required>
						</div>
						<div class="help-block with-errors">${errorMessageRePassword }</div>
					</div>

					<div class="form-group">
						<label for="nickNameInput" class="col-md-2 control-label">昵称</label>

						<div class="col-sm-4">
							<input type="text" class="form-control" id="nickNameInput"
								name="nickName" placeholder="输入你的昵称">
						</div>
					</div>

					<div class="form-group">
						<label for="verifyCodeInput" class="col-md-2 control-label">验证码
							*</label>

						<div class="col-sm-4">
							<img src="${pageContext.request.contextPath}/captchaImage" alt="验证码加载失败"
								style="height: 50px; margin-bottom: 5px"
								onclick="reloadVerifyCode()" id="kaptchaImage"> <input
								type="text" class="form-control" placeholder="输入验证码" required
								data-error="输入上面验证码" name="verifyCode">
							<div class="help-block with-errors">${errorMessageVerifyCode }</div>
						</div>
					</div>

					<div class="form-group">
						<div class="col-md-2"></div>
						<div class="col-md-2">
							同意协议 <input type="checkbox" required data-error="你必须同意注册协议">
						</div>
						<div class="col-md-2">
							<input type="submit" class="btn btn-sm btn-primary" value="注 册">
						</div>
						<div class="col-md-2">
							<a href="userLogin.html" role="button"
								class="btn btn-sm btn-default">登 录</a>
						</div>
						<div class="help-block with-errors"></div>
					</div>
				</form:form>

				<div class="col-md-2"></div>
				<div class="col-md-6">
					<textarea cols="50" rows="7" readonly style="resize: none;">
                    注册协议

                    1.
                    2.
                    3.
                    4.
                    5.
                    6.
                    7.
                    8.
                    9.
                    10.


                </textarea>
				</div>
			</div>
			<!-- end col-sm-8-->

			<div class="col-sm-4">
				<div class="page-header">
					<h3>帮助</h3>
				</div>
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
	<script src="${pageContext.request.contextPath}/staticFile/plus/validator.js"></script>

	<script type="text/javascript">
		$(function() {
			$("#signInForm").validator();
		});

		function reloadVerifyCode() {
			var verify = $("#kaptchaImage");
			verify.attr('src', '${pageContext.request.contextPath}/captchaImage?' + Math.random());
		}
	</script>
</body>
</html>