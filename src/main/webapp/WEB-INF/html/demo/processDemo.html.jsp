<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="zh-CN">
<meta http-equiv="x-ua-compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>演示:业务演示</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main.css">

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
				<li><a href="${pageContext.request.contextPath}/">首页</a></li><li><a href="${pageContext.request.contextPath}/search/">搜索</a></li>
				<li><a href="../vote/startVote.html">投票</a></li>
				<li><a href="../poll/startPoll.html">问卷</a></li>
				<li><a href="../user/selfCenter.html">个人</a></li>
				<li class="active"><a href="../demo/demo.html">演示</a></li>
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
			<div class="col-md-10">
				<div class="page-header" id="step01">
					<h3>
						<i class="glyphicon  glyphicon-bookmark"></i>第一步 <small>注册并登录</small>
					</h3>
				</div>
				<div class="jumbotron">
					&nbsp;&nbsp;&nbsp;&nbsp;发起投票和问卷的用户才需要注册。<a
						href="../user/userSignIn.html" target="_blank" role="button"
						class="btn btn-sm btn-info">注册</a>
					如果你是被邀请投票/问卷的填写者，在对应不同的问卷中可能需要邀请链接中的验证码。
					注册后填写用户信息，有助于填写者识别你。你好可以在用户中心进行实名制认证。

				</div>

				<div class="page-header" id="step02">
					<h3>
						<i class="glyphicon  glyphicon-bookmark"></i>第二步 <small>上传联系人</small>
					</h3>
				</div>
				<div class="jumbotron">
					<h4>Excel上传模式</h4>
					&nbsp;&nbsp;&nbsp;&nbsp;为了用户更方便的管理联系人管理，我们提供了Excel模式。但是如果格式不正确可能会出行解析错误，所以使用此模式请下载模版并填写。
					邮箱为必填，电话为选填。如果出现邮箱格式错误，我们将抛弃该条数据。在联系人解析完毕后，我们会尽快通知你。 <a
						href="${pageContext.request.contextPath}/demo/dowmloadLinkmanTemplate.do"
						class="btn btn-sm btn-success">下载模版</a>
					<h4>文本域编辑模式</h4>
					&nbsp;&nbsp;&nbsp;&nbsp;该模式方便编辑，每条数据用
					<kbd>;</kbd>
					分割。为邮箱添加备注<a href="../about/aboutAlias.html">关于备注</a> 在邮箱后以
					<kbd>:</kbd>
					分割。 如果你正确填写了默认邮箱服务，只要是该服务的邮箱，你可以省略邮箱服务。例子：默认邮箱服务为:
					<kbd>@gmail.com</kbd>
					。为本域编辑为：
					<kbd>example:Alias;example@163.com:备注名;</kbd>
					。表示有两个联系人，一个是邮箱为<label class="text-info">example@gmail.com</label>，备注为<label
						class="text-info">Alias</label>， 另一个是邮箱为<label class="text-info">example@163.com</label>，备注为<label
						class="text-info">备注名</label>。
					<h4>使用OCR</h4>
					&nbsp;&nbsp;&nbsp;&nbsp;如果你的联系人数据源是图片，一个一个手动录入太慢，也容易出错。你可以使用<a
						href="https://www.google.com.hk/?gws_rd=cr,ssl#q=OCR">关于OCR</a>
					。我们自己暂时还不支持OCR。
				</div>

				<div class="page-header" id="step03">
					<h3>
						<i class="glyphicon  glyphicon-bookmark"></i>第三步 <small>创建问卷</small>
					</h3>
				</div>
				<div class="jumbotron">
					&nbsp;&nbsp;&nbsp;&nbsp;对于问卷的创建，我们提供了很多的模版。你可以搜索你需要的模版加以修改。也可以完全自定义题目数量、题目类型、题目选项。
					我们也提供了多种编辑问卷的模式。
					<h4>拖拽设计模式</h4>
					<h4>HTML编辑模式</h4>
				</div>

				<div class="page-header" id="step04">
					<h3>
						<i class="glyphicon  glyphicon-bookmark"></i>第四步 <small>预览并发布</small>
					</h3>
				</div>
				<div class="jumbotron">
					&nbsp;&nbsp;&nbsp;&nbsp;在完成对问卷/投票的编辑后，你可以进行预览。再选择联系人（投票可以匿名，也就是说投票可以不用选择）后发起。
					在进行问卷/投票设置时结束时间必须填写，投票最长可以历时3个月，问卷调查最长可以历时一个月。在发布时，发起人请注意。
					对于投票，在成功发起后，我们会给你生成一个链接，你可以将他发布在一些网络平台中。邀请其他平台的人来参与投票。
					对于问卷，在成功发起后，我们会发送邮件给你选择的联系人。</div>

				<div class="page-header" id="step05">
					<h3>
						<i class="glyphicon  glyphicon-bookmark"></i>第五步 <small>填写问卷/投票</small>
					</h3>
				</div>
				<div class="jumbotron">
					&nbsp;&nbsp;&nbsp;&nbsp;点击邀请链接，输入验证码（可能有），就可以开始填写数据了。在完成填写后进行提交。</div>

				<div class="page-header" id="step06">
					<h3>
						<i class="glyphicon  glyphicon-bookmark"></i>第六步 <small>结束问卷/投票</small>
					</h3>
				</div>
				<div class="jumbotron">
					&nbsp;&nbsp;&nbsp;&nbsp;到投票/问卷的结束时间后，投票/问卷就无法继续进行提交了。投票/问卷自动结束。
					对于发起者可以进行手动结束，对于手动结束的投票/问卷数据可能不能在手动结束后立即导出。等到数据分析完成后我么会以邮件形式通知你。
					如果，你想使用短信提醒。在用户中心填写移动电话联系方式 <a href="../user/userProfile.html"
						target="_blank" role="button" class="btn btn-sm btn-primary">查看</a>。
					并在控制面板中开启 <a href="../user/userConsole.html" target="_blank"
						role="button" class="btn btn-sm btn-primary">前去开启</a>短信提醒功能。
				</div>

				<div class="page-header" id="step07">
					<h3>
						<i class="glyphicon  glyphicon-bookmark"></i>第七步 <small>数据导出</small>
					</h3>
				</div>
				<div class="jumbotron">
					在你收到数据导出的通知后，你就可以对数据进行导出了。结果数据我们也只会为你保存一个月，如果你没有进行过数据导出，我们会再最后一周通知你。
					如果你设置了二级密码，在数据导出时，可以使用二级密码加密你搞导出的Excel工作簿。</div>

			</div>
			<div class="col-md-2" role="complementary">

				<nav class="affix">
				<div class="page-header">
					<h3>
						<i class="glyphicon glyphicon-map-marker"></i> 快捷导航
					</h3>
				</div>

				<ul class="nav">
					<li><a href="#step01" role="button">1.注册并登录</a></li>
					<li><a href="#step02" role="button">2.上传联系人</a></li>
					<li><a href="#step03" role="button">3.创建问卷</a></li>
					<li><a href="#step04" role="button">4.预览并发布</a></li>
					<li><a href="#step05" role="button">5.填写问卷</a></li>
					<li><a href="#step06" role="button">6.结束问卷</a></li>
					<li><a href="#step07" role="button">7.数据导出</a></li>
				</ul>

				</nav>
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

		<p>网站备案</p>

		<p>京201510-34534****</p>
	</div>
	</footer>

	<script src="${pageContext.request.contextPath}/resources/easyui/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>