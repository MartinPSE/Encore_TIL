<%@page import="servlet.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO vo = (MemberVO) session.getAttribute("vo");
	if (vo == null) { // 앞에서 != null이라 왔는데 왜 확인해야되냐...로그인 안 하고 url로 바로 접속하는 경우가 있음
%>
	<h3>로그인 부터 하세요</h3>
	<a href="login.html">로그인하러 가기</a>
<%
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Login Information....</h2>
	LOGIN ID : <b><%= vo.getId() %></b>
	LOGIN NAME : <b><%= vo.getName() %></b>
	LOGIN ADDRESS : <b><%= vo.getAddress() %></b>
	LOGIN JSESSIONID : <b><%= session.getId() %></b>
	<hr>
	<a href="logout.jsp">LOG OUT</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a href="index.html">HOME...INDEX...</a>
</body>
</html>


