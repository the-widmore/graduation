<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="zh-CN">
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <title>问卷:创建问卷</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/main.css">
    <link rel="stylesheet" href="../../userDefined/poll/progress-nav.css">

</head>
<body>

<nav class="navbar navbar-default ">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">EasyVote</a>
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
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">更多 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="../more/activity.html">活动</a></li>
                        <li class="divider"></li>
                        <li class="dropdown-header">隐私政策</li>
                        <li><a href="../more/userData.html">用户数据</a></li>
                        <li><a href="../more/platformPolicy.html">平台政策</a></li>
                    </ul>
                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
				<%@include file="../user/userBar.jsp"%>
			</ul>
        </div>
    </div>
</nav>

<div class="container content">
    <div class="jumbotron">

        <h3>方式选择</h3>

        <h4>方式一:
            <small>使用我们或者用户共享的模版，编辑后进行使用。</small>
        </h4>

        <div class="progress-nav">
            <span>选择模版</span>
            <span> <i class="glyphicon glyphicon-arrow-right"></i> </span>
            <span>编辑模版</span>
            <span> <i class="glyphicon glyphicon-arrow-right"></i> </span>
            <span>预览发布</span>
            <span> <i class="glyphicon glyphicon-arrow-right"></i> </span>
            <span>成功发起</span>
            <span> <i class="glyphicon glyphicon-arrow-right"></i> </span>
            <span>结束</span>
        </div>

        <h4>方式二:
            <small>全部自定义，对于问题较少的很实用，你也可以制作可以共享的模版。</small>
        </h4>

        <div class="progress-nav">
            <span>定义问题</span>
            <span> <i class="glyphicon glyphicon-arrow-right"></i> </span>
            <span>预览发布</span>
            <span> <i class="glyphicon glyphicon-arrow-right"></i> </span>
            <span>成功发起</span>
            <span> <i class="glyphicon glyphicon-arrow-right"></i> </span>
            <span>结束</span>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6">
            <div class="page-header">
                <h3>选择方式
                    <small><a href="#" class="btn btn-sm btn-info"> 相关演示</a></small>
                </h3>
            </div>

            <form action="#" method="POST" class="form-inline">
                <label>后续操作方式</label>
                <select class="form-control">
                    <option value="way1">方式一</option>
                    <option value="way2">方式二</option>
                </select>
                <!-- <input type="submit" class="btn btn-primary" value="开始创建"> -->
                <a href="searchPollModel.html" class="btn btn-sm btn-primary"> 开始创建</a>

            </form>
        </div>
    </div>
</div>

<footer class="footer">
    <div class="col-md-1">
    </div>
    <div class="col-md-2">
        <h2>EasyVote</h2>
        <ul>
            <li><a href="">版权声明</a></li>
            <li><a href="">使用须知</a></li>
            <li><a href="">隐私策略</a></li>
            <li><a href="">关于我们</a></li>
        </ul>
    </div>
    <div class="col-md-1">
    </div>
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