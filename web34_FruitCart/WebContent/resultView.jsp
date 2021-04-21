<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Item AllView</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
</head>
<style>

body{
	font-family: 'Do Hyeon', sans-serif;
}

table{
	text-align: center;
	margin : 0 auto;
}
table td {
	border : 2px solid #8C8CF5;
	border-style : outset;
}

table tr{
	float : left;
}


img {
	width: 200px;
	height : 150px;
	background-color:white;
}
#todayWatched{
	margin :0 auto;
	text-align:center;
}

#todayImage {
	margin : 0 auto;
	height : 100px;
	weight : 100px;
	border-radius: 20px;
	padding : 10px;
}
#todayImages{
	margin-right: 100px;

	}

h2{
color : purple;
}
figure.snip1283 {
  float : right;
  color: #000000;
  position: relative;
  overflow: hidden;
  margin: 10px;
  min-width: 150px;
  max-width: 200px;
  max-height: 150px;
  width: 100%;
  color: #000000;
  text-align: left;
  background-color: white;
  font-size: 13px;
  -webkit-perspective: 50em;
  perspective: 50em;
}
figure.snip1283 * {
  -webkit-box-sizing: border-box;
  box-sizing: border-box;
  -webkit-transition: all 0.6s ease;
  transition: all 0.6s ease;
}

figure.snip1283 figcaption {
  position: absolute;
  top: 0;
  left: 0;
  bottom: 0;
  width: 100%;
  -webkit-transform: rotateX(90deg);
  transform: rotateX(90deg);
  -webkit-transform-origin: 50% 100%;
  -ms-transform-origin: 50% 100%;
  transform-origin: 50% 100%;
  z-index: 1;
  opacity: 0;
  padding: 20px 30px;
}

figure.snip1283:hover img,
figure.snip1283.hover img {
  -webkit-transform: rotateX(-90deg);
  transform: rotateX(-90deg);
  opacity: 0;
}

figure.snip1283:hover figcaption,
figure.snip1283.hover figcaption {
  -webkit-transform: rotateX(0deg);
  transform: rotateX(0deg);
  opacity: 1;
  -webkit-transition-delay: 0.2s;
  transition-delay: 0.2s;
}

</style>

<body>
<h3 align="center"> Fruit Total List 1.</h3>
<table>
	<c:forEach items="${item}" var="item">
		<tr>
		<td>
			<figure class="snip1283">
			<a href="itemView.do?itemnumber=${item.itemNumber}"><img src="${item.url}"></a><br/>
			 <figcaption>
   	 			<h3>상품명 : ${item.name} </h3>
    			<p>
    				<p>가격 : ${item.price}</p>
    				<a href="itemView.do?itemnumber=${item.itemNumber}">클릭</a>하시면<br/>
    				상세 정보로 넘어갑니다<br/>
    				
    				
    		</figcaption>
			</figure>
			
		</td>
		</tr>

	</c:forEach>
</table> 
<br>
<c:if test="${!empty fruits}">
<div id="todayWatched">
	<hr/>
	<h2> 오늘 본 상품들 </h2>
		<div id="todayImages">
			<c:forEach items="${fruits}" var="fruit">
				<figure class="snip1283">
				<img src="${fruit}" id="todayImage">
				</figure>		
			</c:forEach>
		</div>
</div>
</c:if>
</body>
</html>