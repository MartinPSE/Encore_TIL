<%--
로그아웃 로직 
1. 세션에 바인딩된 정보가 있다면 --- 현재 로그인된 상태다.  
2. 세션을 죽인다. session.invalidate() ** 무조건
3. 다시 홈으로 / 로그인 페이지로


--%>

<%@page import="servlet.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function logoutpop(){
		alert("    Logout    ")
	}
</script>

</head>
<body onload="return logoutpop()">
	<div align="center" style="margin:50px">
		<b>로그아웃 되셨습니다</b><br><br>
		<hr>
		<a href="login.html"> Home </a>
	</div>
</body>
</html>






