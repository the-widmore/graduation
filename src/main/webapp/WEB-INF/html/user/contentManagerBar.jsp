<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="panel-body">
	<ul>
		<li><a href="myLinkman.html">我的联系人</a><span class="badge">${sessionScope.authorContentCounter.linkmanCount }</span></li>
		<li>
			<hr>
		</li>
		<li><a href="myPoll.html">我的问卷</a><span class="badge">${sessionScope.authorContentCounter.voteCount }</span></li>
		<li><a href="myVote.html">我的投票</a><span class="badge">${sessionScope.authorContentCounter.pollCount }</span></li>
		<li><a href="myInfoGather.html">我的信息收集</a><span class="badge">${sessionScope.authorContentCounter.infoCount }</span></li>
	</ul>
</div>