<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>성공했을 때 페이지</h1>

결과: <%=request.getAttribute("hobbys")%><br>
결과: ${requestScope.hobbys}<br> <!-- 표현언어 방식 - jsp 코드를 좀 더 간결하게 -->
결과: ${hobbys}<br> <!-- requestScope 생략가능 -->


</body>
</html>