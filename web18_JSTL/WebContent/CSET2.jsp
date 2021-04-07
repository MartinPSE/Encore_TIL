<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="CODE" value="1004" scope="request"/>
<c:set var="NAME" value="encore" scope="page"/>
<c:set var="PRICE" value="22000"/> <!-- default scope="page" -->

<jsp:forward page="CSET2_result.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	상품 코드 : ${CODE}<br>
	상품 이름 : ${NAME}<br>
	상품 가격 : ${PRICE}<br>
</body>
</html>
