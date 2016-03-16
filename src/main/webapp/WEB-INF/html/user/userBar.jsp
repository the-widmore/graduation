<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<shiro:guest>
	<li class="dropdown"><a href="#" class="dropdown-toggle"
		data-toggle="dropdown" role="button" aria-haspopup="true"
		aria-expanded="false">注册/登录<span class="caret"></span></a>
		<ul class="dropdown-menu">
			<li><a href="${pageContext.request.contextPath}/user/userLogin.html">登录</a></li>
			<li class="divider"></li>
			<li><a href="${pageContext.request.contextPath}/user/userSignIn.html">注册</a></li>
		</ul></li>
</shiro:guest>
<shiro:authenticated>
	<li class="dropdown"><a href="#" class="dropdown-toggle"
		data-toggle="dropdown" role="button" aria-haspopup="true"
		aria-expanded="false">${sessionScope.SESSION_KEY_SHOW_NAME}<span
			class="caret"></span></a>
		<ul class="dropdown-menu">
			<li><a href="${pageContext.request.contextPath}/user/selfCenter.html">个人中心</a></li>
			<li class="divider"></li>
			<li><a href="${pageContext.request.contextPath}/user/logout.do">退出</a></li>
		</ul></li>
</shiro:authenticated>
