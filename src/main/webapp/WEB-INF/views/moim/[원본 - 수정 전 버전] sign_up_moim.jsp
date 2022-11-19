<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"> </script>
<script>
/*
$(function() {
	$('form').on('submit', function(e) {
		let user_id = "${user_info.user_id}"
		let moim_idx = "${moim_info.moim_idx}"
		var error = false;
		
		$.ajax({
				url : "moim_user_duplicate_check",
				type : "GET",
				data : {user_id : user_id, moim_idx : moim_idx},
				async : false,
				dataType : 'json',
				success : function(result){
					if(result > 0){
						alert('이미 이 모임에 가입하셨습니다.');
						error = true;
					}
					else{
						
					}
				},
				error : function() {
					alert("서버요청실패");
				}
		});
		if(error){
			return false;
		}
		
		
	})
});
*/
	


</script>

</head>
<body>
	<div id=sign_up>
	<form action="/sign_moim_user" method="GET" id="sign_moim_user">
		<table>
			<ul>
			<input type="hidden" name="user_id" value="${user_info.user_id}" />
			<input type="hidden" name="moim_idx" value="${moim_info.moim_idx}" />
			
			<li> 유저이름 : ${user_info.user_name } </li><br>
			<li> 유저의 대학교명 : ${user_info.univname } </li><br>
			<li> 유저관심사 : ${user_info.user_cate } </li><br>
			
			<li> 가입할려는 동아리 이름 : ${moim_info.moim_name } </li><br>
			
			<li> 가입인삿말
			<input type="text" name="sign_up_intro" />
			</li>
			</ul>		
		</table>
			<button type="submit" for="sign_moim_user">가입하기</button>
		</form>
	</div>
</body>
</html>