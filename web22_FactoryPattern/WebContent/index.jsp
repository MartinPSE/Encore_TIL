<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#wrap{
		text-align: center;
		border: 2px dotted green;
	}
</style>
</head>

<body>
<h1>CafeMember : FrontControllerPatter + EL, JSTL + AJAX</h1><p>
	<div id="wrap">
		<a href="find.jsp">회원 검색하기</a><p>
		
 		<c:choose>
 			<c:when test="${!empty vo}"> <!-- vo != null 혹은 sessionScope.vo != null -->
				<a href="allmember.do">전체회원 명단보기</a><p>
				<a href="update.jsp">회원정보 수정</a><p>
				<a href="logout.do">로그 아웃</a><p>	
 			</c:when>
 			<c:otherwise>
	 			<a href="register.jsp">회원 가입 하기</a><p>
				<a href="login.jsp">로그인 하기</a><p>
 			</c:otherwise>
 		</c:choose>
	</div>
</body>
</html>