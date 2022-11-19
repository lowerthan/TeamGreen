<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link href="/css/home.css" rel="stylesheet" />
<title>Insert title here</title>
<style>
.search {
  position: relative;
  width: 300px;
}

input {
  width: 100%;
  border: 1px solid #bbb;
  border-radius: 8px;
  padding: 10px 12px;
  font-size: 14px;
}

img {
  position : absolute;
  width: 17px;
  top: 10px;
  right: 12px;
  margin: 0;
}

</style>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"> </script>
<script>
$(function() {
	$('#search_moim').on('keyup', function() {
		let search_moim_name = $('#search_moim').val(); // 검색어
			
		$.ajax({
			url : "/Moim/search_moim_name",
			type : "GET",
			data : {search_moim_name : search_moim_name},
			dataType : "json",
			}).done(function(e){
				$("#test").remove();
				console.log(e['moimVo']);
				let arr = e['moimVo'];
				console.log(arr);
				let tr = $("<ul id=test></ul>");
				
				$.each(arr, function(index, obj) {
					// console.log(index); // 번호
					// console.log("moim_name : " + obj.moim_name); 
					// console.log("moim_cate : " + obj.moim_cate);
					// console.log("moim_intro : " + obj.moim_intro);
					//$("<li></li><br>").html(index).appendTo(tr);
					$("<li></li><br>").html(obj.moim_name).appendTo(tr);
					$("<li></li><br>").html(obj.moim_cate).appendTo(tr);
					$("<li></li><br>").html(obj.moim_intro).appendTo(tr);
					
					
					
				});
				
				$("#moim_list").append(tr);
				
			})
			
		})
	})

</script>
</head>
<body>
<!-- 내비게이션 바 불러오기 -->
<%@include file="/WEB-INF/include/navi.jsp" %>
<br><br>

<div id="searchmain">
	<form action="/search_moim_name" method="GET" id="search_moim_name">
	<table>
		<div class="search">
  			<input type="text" id="search_moim" placeholder="검색어 입력">
  			<img src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png">
		</div>
		<ul><span id="moim_list"></span></ul><br>
		
		
		
	</table>
	</form>
</div>
</body>
</html>