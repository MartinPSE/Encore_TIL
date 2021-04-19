<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

div{
	width : 80%;
	margin : 0 auto;
}

div #search{
	float : right;
	
}
div table{
	width : 100%;
}

table th {
	border: 1px solid grey;
	background : lightgrey;
	font-weight : normal;
	height: 40px;
}
table td{
	text-align : center;
	border : 1px solid grey;
	height : 40px
}


</style>
</head>
<body>
<h1 style="text-align : center"> 도서 목록 화면 </h1>
<div>
	<p id = "search">
		<select name="option">
			<option>전체</option>
			<option>?</option>
			<option>?</option>
			<option>?</option>
		</select>
		<input type="text">
		<input type="submit" value="검색">
	</p>


	<table>
		<tr>
			<th>도서번호</th>
			<th>도서명</th>
			<th>도서분류</th>
			<th>저자</th>
	
		</tr>
	<c:forEach items="${list}" var="vo">
		<tr>
			<td style="width: 20%"> ${vo.isbn} </td>
			<td style="width: 50%"><a href="#"> ${vo.title} </a></td>
			<td style="width: 15%"> ${vo.catalogue}</td>
			<td style="width: 15%"> ${vo.author}</td>
		</tr>	
			
	</c:forEach>	
	
	</table>
	<p align = "center"><a href="book/Book.html"> 도서 등록</a>




</div>



</body>
</html>