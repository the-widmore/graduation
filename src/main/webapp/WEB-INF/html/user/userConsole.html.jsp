<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="zh-CN">
    <meta http-equiv="x-ua-compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户:控制面板</title>
    <link rel="stylesheet" href="/easyvote/staticFile/css/bootstrap.min.css">
    <link rel="stylesheet" href="/easyvote/staticFile/main.css">
    <link rel="stylesheet" href="/easyvote/staticFile/extend/jqwidgets/styles/jqx.base.css">
    <link rel="stylesheet" href="/easyvote/staticFile/extend/jqwidgets/styles/jqx.bootstrap.css">

</head>
<body>

<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
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
    <ol class="breadcrumb">
        <li><a href="../../index.html">首页</a></li>
        <li><a href="selfCenter.html">个人中心</a></li>
        <li class="active">控制面板</li>
    </ol>

    <div class="row">
        <div class="col-sm-3">
            <div class="panel-success">

                <div class="panel-heading">
                    <h4><i class="glyphicon glyphicon-cog"></i>个人管理中心</h4>
                </div>

                <div class="panel-body">
                    <div class="panel-group" id="accordion">
                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <i class="glyphicon glyphicon-user"></i> 账号管理
                                </h4>
                            </div>

                            <div id="collapseOne" class="panel ">
                                <div class="panel-body">
                                    <ul>
                                        <li><a href="userProfile.html">个人资料</a></li>
                                        <li><a href="userAccount.html">账号关联</a></li>
                                        <li><a href="userOrder.html">我的订单</a></li>
                                        <li><a href="userConsole.html">控制面板</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <div class="panel panel-success">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <i class="glyphicon glyphicon-th-list"> 内容管理</i>
                                </h4>
                            </div>

                            <div class="panel ">
                                <div class="panel-body">
                                    <ul>
                                        <li><a href="myLinkman.html">我的联系人</a><span class="badge">3</span></li>
                                        <li><hr></li>
                                        <li><a href="myPoll.html">我的问卷</a><span class="badge">4</span></li>
                                        <li><a href="myVote.html">我的投票</a><span class="badge">10</span></li>
                                        <li><a href="myInfoGather.html">我的信息收集</a><span class="badge">1</span></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- end of panel -->

        <div class="col-sm-6">
            <div class="page-header">
                <h3>控制面板<i class="glyphicon glyphicon-console"></i></h3>
            </div>

            <form action="#" method="POST">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-sm-4 text-right"><label>联系人上传通知</label></div>
                        <div class="col-sm-3">
                            <div class="switch-button" id="linkmanUploadNotify"></div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-4 text-right"><label>投票/问卷成功发起通知</label></div>
                        <div class="col-sm-3">
                            <div class="switch-button" id="voteOrPollSuccessStartNotify"></div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-4 text-right"><label>投票/问卷完成通知</label></div>
                        <div class="col-sm-4">
                            <div class="switch-button" id="voteOrPollEndNotify"></div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-4 text-right"><label>数据过期通知</label></div>
                        <div class="col-sm-4">
                            <div class="switch-button" id="dataExpireNotify"></div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-4 text-right"><label>优先的通知方式</label></div>

                        <div class="col-sm-4">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="primaryNotifyWay" value="emailPrimary" checked>
                                    邮箱优先
                                </label>
                            </div>

                            <div class="radio">
                                <label>
                                    <input type="radio" name="primaryNotifyWay" value="telPrimary">
                                    电话优先
                                </label>
                            </div>

                            <div class="radio">
                                <label>
                                    <input type="radio" name="primaryNotifyWay" value="emailAndTelPrimary">
                                    邮箱和电话
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-4 text-right"><label>启用二级密码</label></div>
                        <div class="col-sm-2">
                            <div class="switch-button" id="secondLavaPasswordAble"></div>
                        </div>
                        <div class="col-sm-4">
                            <a href="userProfile.html#baseInfo" role="button" class="btn btn-sm btn-success">前去设置</a>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-sm-2 col-md-offset-4">
                            <input type="submit" class="btn btn-primary" value="修改设置">
                        </div>
                    </div>
                </div>
            </form>
        </div>

        <div class="col-sm-3">
            <div class="page-header">
                <h3>相关帮助</h3>
            </div>
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

<script src="/easyvote/staticFile/js/jquery-1.11.0.min.js"></script>
<script src="/easyvote/staticFile/js/bootstrap.min.js"></script>
<script src="/easyvote/staticFile/extend/jqwidgets/jqxcore.js"></script>
<script src="/easyvote/staticFile/extend/jqwidgets/jqxswitchbutton.js"></script>
<script src="/easyvote/staticFile/extend/jqwidgets/jqxcheckbox.js"></script>
<script type="text/javascript">
    $('.switch-button').jqxSwitchButton({width: 80, height: 25, checked: true});
</script>
</body>
</html>