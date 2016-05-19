<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="x-ua-compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>查看定义</title>
<link rel="stylesheet" type="text/css"
	href="../../../resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/main.css">
<meta charset="UTF-8">
</head>
<body>

	<div class="container">
		<h3>${vote.title}</h3>

		<div class="content">
			<div class="row">
				<div class="col-md-6">${voteContent.content }</div>
				<div class="col-md-4"></div>

			</div>
		</div>
	</div>

</body>
</html>