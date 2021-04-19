<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Error </title>
</head>
<body>
<marquee bgcolor="red"><h1> 로그인에 실패하셨습니다. </h1></marquee>
<%= application.getAttribute("error") %>
<p> 로그인에 실패하셨습니다. </p><br><br>
<p><a href = "login.html"> 돌아가기 </a>

</body>
</html>