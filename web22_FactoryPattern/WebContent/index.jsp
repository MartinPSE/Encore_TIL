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
<%--
	index 페이지에서는 클라이언트가 6가지의 서비스를 요청할 수 있다.
	이 때 인증(Authentication)과 권한부여(Authorization)에 따라 요청할 수 있는 서비스가 달라져야 한다.
	
	Authentication   Authorization
	   로그인 O 사용자 - 로그아웃 / 전체회원 명단보기 / 회원정보 수정
	   로그인 X 사용자 - 회원가입 / 로그인
	   무관		   - 회원검색
	   
	JSTL choose 사용해서 기능을 만든다.
 --%>
<body>
	<div id="wrap">
		<h2>CafeMember : FrontControllerPatter + EL, JSTL</h2><p>
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