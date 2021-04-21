<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
	$(function(){
		$('#cartIn').click(function(){
			var key = '${item.itemNumber}';
			var url = '${item.url}';
			var name = '${item.name}';
			var price = '${item.price}';
			var amount = 1;
			
			if(localStorage.getItem(key)!=null){
				var data = localStorage.getItem(key).split(",");
				alert("이미 저장된 품목입니다.")			
			}else{
				alert("장바구니에 성공적으로 담겼습니다.")
			}
			
					
			var value = url+","+name+","+price+","+amount;
			localStorage.setItem(key,value);	
			
		}); // 장바구니 담기
			
		$('#cartCheck').click(function(){
			location.href="cart.jsp";

		}); // 장바구니 확인
			

		
	}); // ready


</script>
</head>

<style>

body {
font-family: 'Do Hyeon', sans-serif;
}

p {
	text-align : center;
	background-color : #7878AA;
	padding : 10px;
	border-radius : 15px;
}


#itemView {
	text-align:left;
	color : #8C8CF5;
	font-size: 1.3em;
	
	
}





</style>
<body>
<h1 align="center"><b> ${item.name} </b></h1><hr>

<div id="Info">
<p> 조회수 : ${item.count}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<input type="button" value="장바구니 담기" id="cartIn">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	<input type="button" value="장바구니 확인" id="cartCheck">&nbsp;&nbsp;&nbsp;
</p>
</div>
<table id="itemView">
	<tr>
		<td colspan="3">
			<img src="${item.url}"><br/>
		</td>
		<td>
			종 류 : ${item.name}<br/><br/>
			가 격 : ${item.price}<br/><br/><br/><br/>
			설 명 : ${item.description}<br/><br/>
		</td>
	</tr>
</table>

<p><a href="itemlist.do" id="resultView" style="align:center">상품 목록 보기</a></p>
<hr>


</body>
</html>