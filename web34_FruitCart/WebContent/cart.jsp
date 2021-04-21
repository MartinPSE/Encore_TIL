<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.gstatic.com">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script>
var key;
var amount;
var totalPrice;
	$(function(){
		// html에 뿌리기. key 값 받고 정보를
		cartInfo();
		
		/* 처음엔 up과 down을 ID로 지정했을때는 1번째 번호만 인식하고 2번째 부턴 on.click을 인식하지 못했다.
				class로 바꾸니 모두 인식했다. 
				ID는 고유의 값이여서 그런건가..?
		*/
		
		// 수량 올리고 내리고
		$('.up').on('click',function(){
			// key값 
			key = $(this).siblings('input[type=hidden]').val();
			amount = eval($(this).siblings('span').html()); // 개수를 가져왔어.
			amount++;
			$(this).siblings('span').text(amount);
			// alert($(this).parent().prev().text()); 상품가격
			totalPrice += eval($(this).parent().prev().html());
			$('#totalPrice').text(totalPrice);
			
			// key값을 받아서, update시켜준다.
			updateCount();

		}); // 수량 올리기
		
		
		$('.down').on('click',function(){
			// key값을 가져와 줘야해
			key = $(this).siblings('input[type=hidden]').val();
			amount = eval($(this).siblings('span').html()); // 개수를 가져왔어.
			if (amount > 1){			
				amount--;
				$(this).siblings('span').html(amount);
				// alert($(this).parent().prev().html()); 상품가격
				totalPrice -= eval($(this).parent().prev().html());
				$('#totalPrice').html(totalPrice);
				
				// key값을 받아서, update시켜준다.
				updateCount();
			}
			
			
		}); // 수량 내리기
		
		
		
		
		
		
		// 삭제하면 다 없어지고
		$('#delete').on('click',function(){ 
			$('input[type=checkbox]:checked').each(function(){
				key = $(this).val();
				localStorage.removeItem(key); 
				$(this).parents('#cartlist').remove();
				totalPrice -= eval($(this).parent().siblings('th:eq(3)').text())
						*eval($(this).parent().siblings('th:eq(4)').text());
				$('#totalPrice').html(totalPrice);
				location.reload();
				
			})// each
			
			
		}); // 삭제 
		
		
	});// ready
	
	// localStorage 도 변경해줘야해
	function updateCount(){
		var data = localStorage.getItem(key).split(","); // 기존 local
		var value = data[0]+","+data[1]+","+data[2]+","+amount; // ++ 혹은 -- 된 amount
		localStorage.setItem(key,value);
	};

	
	function cartInfo(){
		var html ="";
		var no=1;
		totalPrice = 0;
		
		for(var key in localStorage){
			// alert(key);
			if(key=='length') break;
			var cart = localStorage.getItem(key).split(",");
			// alert(cart);
			html += '<tr><th>'+(no++)+'</th>';
			html += '<th><img src='+cart[0]+'></th>';
			html += '<th>'+cart[1]+'</th>'; // 상품명
			html += '<th>'+cart[2]+'</th>'; // 가격
			html += '<th><img src=img/up.jpg class=up><br>'; 
			html += '<input type=hidden value='+key+'><span>'+cart[3]+'</span><br><img src=img/down.jpg class=down></th>'; // 수량
			html += '<th><input type=checkbox value='+key+'></th></tr>';			
			totalPrice += eval(cart[2]*cart[3]);
		}
	
		$('#cartlist').html(html);
		$('#totalPrice').html(totalPrice);

		
	};	//cartInfo()




</script>
</head>
<style>
*{	
box-sizing : border-box;
}


body {
	font-family: 'Do Hyeon', sans-serif;
	text-align : center;
	align : center;
	
		}
input {
	font-family: 'Do Hyeon', sans-serif;
	font-size : 15px;
	margin : 2px;
}

table thead{
	background-color: #FFA500;
	padding : 3px;
}

table tfoot {
	background-color: #FFA500;
}

table th {
	border : 2px solid;
}

#shopping{
	text-align : right;
	margin : 10px;
	padding-right: 100px;
}
table {
	margin : 0 auto;
	align : center;
	width : 80%;

}

#total{
	font-size : 30px;
	color : #a0a0a0;
}

#cartlist img {
	width : 100px;
	height : 100px;
}
#cartlist .up{
	width : 10px;
	height : 10px;
}
#cartlist .down{
	width : 10px;
	height : 10px;
}
#totalPrice{
	padding-right : 10px;
	font-size : 40px;
}

#resultView {
	border-radius: 10px;
	
	
}

</style>


<body>
<h1> 장바구니 </h1>
<hr>
<div id="shopping">
	<a href="itemlist.do"> 쇼핑 계속하기 </a><br/>
</div>
<table>
<tr>
</tr>
	<thead id="header">
		<tr>
			<th>번호 </th>
			<th>상품이미지</th>
			<th>상품명</th>
			<th>상품가격</th>
			<th>수량</th>
			<th><input type="button" id="delete" value="삭제"></th>
		</tr> 
	</thead>
	<tbody id="cartlist"> 
		<!--  장바구니 목록들이 들어오는 자리 -->
	</tbody>
	<tfoot>
		<tr>
			<td colspan="6" id="resultView" >
				<p align="right">
					<span id="total">총 결제금액  : </span>
					<span id="totalPrice"></span>
		</tr>
	</tfoot>

</table><hr/>
</body>
</html>