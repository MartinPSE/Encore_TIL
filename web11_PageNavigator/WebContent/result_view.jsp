<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- html 주석 -->
<%--
바인딩 된 객체를 받아와서...request.getAttribute()...자바코드...% %
정보를 출력하는 로직을 작성
 --%>
 <%
 	String id = (String) request.getAttribute("id");
 	// String password = (String) request.getAttribute("password");
 	// String name = (String) request.getAttribute("name");
 	// String address = (String) request.getAttribute("address");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>조회한 <%= id %>님의 정보입니다.</h2>
	아이디 : <%= id %><br>
	이름 : 강호동<br>
	주소 : 여의도<br>
</body>
</html>