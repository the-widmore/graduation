<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="${pageContext.request.contextPath}/user/fileUpload.do" method="POST"
		enctype="multipart/form-data">
		<input type="file" value="选择你的文档" name="file"> <input
			type="submit" value="上传">
	</form>

<%@ include file="../reusable/footer.jsp" %>
</body>
</html>