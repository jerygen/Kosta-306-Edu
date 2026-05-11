
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>Servlet 실습 - JSP</h1>
<h3>
jsp 문서는 마크업 중심으로 코딩을 하면서
부분적으로 java 코드를 실행 할수있다는 장점<br>
그래서 주로 view 즉 출력하는 용도로 많이 사용한다. 
</h3>
<!-- 자바코드를 실행하고 싶다. -->
<%
	//여기는 자바코드를 실행 할수있는 영역
	String s = "효리";
%>

이름 = <%=s %>
<h3 style="color:red">쉬고 싶다</h3>
<%
 List<String> list = new ArrayList();
 list.add("a");
 list.add("b");
 list.add("c");
%>
결과 = <%=list%>
</body>
</html>