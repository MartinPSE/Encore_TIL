<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import ="servlet.model.ProductVO" %>
    
<% 
	List<ProductVO> list = (List<ProductVO>)application.getAttribute("list");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h2><%= request.getParameter("name") %> Product Register</h2>
<h3> All Product List </h3>
<table border="2" width ="350" bgcolor="yellow">
<!-- JAVA CODE와 HTML 태그를 연결..?  -->
	<% for (int i =0 ; i < list.size() ; i ++){ %>
	<tr>
		
		<td><%= list.get(i).getName() %></td>
		<td><%= list.get(i).getPrice() %></td>
		<td><%= list.get(i).getDesc() %></td>
		
	</tr>
	<% } %>
</table>



</div>

</body>
</html>