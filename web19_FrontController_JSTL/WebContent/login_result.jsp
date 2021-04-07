<%@page import="servlet.model.MemberVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${!empty vo}">
			<h2>${vo.name}님 로그인 성공!!</h2>
				LOGIN ID : <b>${vo.id}</b>
				LOGIN NAME : <b>${vo.name}</b>
				LOGIN ADDRESS : <b>${vo.address}</b>
				LOGIN JSESSIONID : <b><%= session.getId() %></b> <!-- 일단 그냥 둔다. -->
			<hr>
			<a href="front.do?command=logout">LOG OUT</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="index.jsp">HOME...INDEX...</a>
		</c:when>
		<c:otherwise>
			<script>
				alert("로그인부터 진행하세요.");
				location.href="login.jsp";
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>