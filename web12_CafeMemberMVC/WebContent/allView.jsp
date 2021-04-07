<%@page import="servlet.model.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<MemberVO> list = (ArrayList) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 align="center">회원 전체 명단 보기</h3>
	<table border="2" width="350px" bgcolor="yellow" align="center">
		<%
			for (MemberVO m : list) {
		%>
				<tr>
					<td><%= m.getId() %></td>
					<td><%= m.getName() %></td>
					<td><%= m.getAddress() %></td>
				</tr>		
		<%
			}
		%>
	</table>
	<a href="index.html">홈으로 돌아가기</a>
</body>
</html>
