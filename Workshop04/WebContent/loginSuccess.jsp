<%@page import="servlet.model.Member" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% Member members = (Member)application.getAttribute("members"); %>


<html>
<head>
<meta charset="UTF-8">
<title> 로그인 성공 !</title>
</head>
<body>
<div align="center">
	<marquee bgcolor="green"><h1> Login Success </h1></marquee>
	<h3> <%= members.getId() %> 님이 로그인 되었습니다. !!!</h3><br>
	<br>
	<p align = center><a href = "#"> 로그인 하기 </a></p>
	<p align = center><a href = "register.html"> 홈으로 </a></p>
</div>
</body>
</html>
