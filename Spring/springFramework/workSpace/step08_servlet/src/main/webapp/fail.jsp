<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>실패했을 때 페이지</h1>

메세지: <%=request.getAttribute("message") %><br>
메세지: ${requestScope.message}<br>
메세지: ${message}<br>

</body>
</html>