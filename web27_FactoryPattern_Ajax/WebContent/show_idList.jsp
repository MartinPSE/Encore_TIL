<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	var xhr;
	
	function startRequest() { // 비동기 요청을 처리하는 로직
		xhr = new XMLHttpRequest();
		var id = document.getElementById("memberId").value;
		
	
		xhr.onreadystatechange = callback;
		
		xhr.open("post","find.do");
		
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8"); // post방식일때 넣어줘야한다.

		xhr.send("id="+id);
			
	
	
		
	}
	
	function callback(){ // 비동기 응답을 처리하는 로직
		if(xhr.readyState == 4 ){
			if ( xhr.status == 200 ){
				
				var text = xhr.responseText;
				document.getElementById("resultView").innerHTML =
				"<h3><font color = #14d3FF size = 5 >"+text +"</font></h3>";	
				
				
			}
		}
		
	}


</script>
</head>
<body>
	<div align="center">
		<h2> ID LIST </h2>
		<h3> 검색할 아이디를 선택하세요 </h3>
		<br>
		<select onchange="startRequest()" id="memberId">
			<option value = ""> ===== ID Choice ===== </option>
			<c:forEach items="${list}" var="memId">
				<option value="${memId}"> ${memId}</option> 
			</c:forEach>
		
		</select>
		
	<span id="resultView"></span>
	</div>



</body>
</html>