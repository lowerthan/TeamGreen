<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %> 
<%
 response.setHeader("Cache-Control","no-cache");
 response.setHeader("Pragma","no-cache");
 response.setDateHeader("Expires",0);
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<meta http-equiv="Expires" content="Mon, 06 Jan 1990 00:00:01 GMT">
<meta http-equiv="Expires" content="0">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">

<title>모임 첫 화면</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<link rel="stylesheet" href="/css/home.css" />
<style>
   h2 { margin : 20px;  }
</style>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"> </script>
<script>

$(document).ready(function(){

	let user_id = $('[name=user_id]').val(); // 유저아이디 들고오기

	let obj={ // 넘겨줄 데이터
			"moim_idx" : $('[name=moim_idx]').val(),
			"user_id" : $('[name=user_id]').val()
		};

	$.ajax({
		url : "regcheck",
		type : "POST",
		data : obj,
		success : function(chk){ // 가입자 -> 탈퇴출력, 미가입자 -> 가입출력
			if(chk==0){
				var plz =  '<button onclick="myFunction()">　가입　</button>';
				$('#show').html( plz );
			} else {
				var plz =  '<button onclick="myFunction2()">　탈퇴　</button>';
				$('#show').html( plz );
			}
		},
		error : function() {
			alert("요청실패");
		}
	})

});

</script>
</head>
<body>
	<input type="hidden" name="user_id" value="${ sessionScope.login.user_id }"/>
	<input type="hidden" name="moim_idx" value="${ moimVo.moim_idx }"/>
	<input type="hidden" name="moim_name" value="${ moimVo.moim_name }"/>
	
	<%@include file="/WEB-INF/include/navi.jsp" %>
        
        <!-- Page header with logo and tagline-->		<!-- 모임 제목 / 모임 소개말 부분 -->
        <header class="py-5 bg-light border-bottom mb-4">
            <div class="container">
                <div class="text-center my-5">
                    <h1 class="fw-bolder">${ moimVo.moim_name }</h1>
                    <p class="lead mb-0"><b>${ moimVo.moim_intro }</b></p>
                </div>
            </div>
        </header>
  		
  		<!-- Page content-->
        <div class="container">
            <div class="row">
                <!-- Blog entries-->
                <div class="col-lg-8">
                    <!-- Featured blog post-->
                    <div class="card mb-4">
                        <img class="card-img-top" src="/img/${moimVo.moim_name}_thumbnail.jpg" width="400" height="200" border="3" alt="사진이 안나오네요.." /></a>
                        <div class="card-body">
                            <div class="small text-muted">January 1, 2022 이런식으로 날짜 가능</div>
                            <h2 class="card-title">저희 모임에 오신것을 환영합니다</h2>
                            <p class="card-text">Nice to meet you</p>
                            <p class="btn btn-primary" id="show">가입</p>
                        </div>
                    </div>
                </div>
            	
            	<!-- Side widgets-->
                <div class="col-lg-4">
                    <!-- Categories widget-->
                    <div class="card mb-4">
                        <div class="card-header">Categories</div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-sm-6">
                                    <ul class="list-unstyled mb-0">
                                        <li><a href="/Pds/List?menu_idx=1&nowpage=1&pagecount=10&pagegrpnum=1">자유 게시판</a></li>
                                        <li><a href="/Pds/List?menu_idx=2&nowpage=1&pagecount=10&pagegrpnum=1" >질문 게시판</a></li>
                                        <li><a href="/Pds/${ moimVo.moim_idx }/Album" >사진첩</a></li>
                                        <li><a href="/Pds/hi?moim_idx=${moimVo.moim_idx}" >가입인사 게시판</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

	
	<!-- 가입 or 탈퇴 버튼 출력 -->
	<!-- <p id="show"></p> -->
	<script>
	function myFunction() {
	  let text = "가입하시겠습니까?";
	  if (confirm(text) == true) { 
		  
		  let user_id = $('[name=user_id]').val();
		  let addr = "/Moim/sign_up_moim?moim_idx=${ moimVo.moim_idx }&user_id=";
		  location = addr+user_id;
	  }
	}

	function myFunction2() {
	  let text = "탈퇴하시겠습니까?";
	  if (confirm(text) == true) {
	    location = "/Delete_moimuser?user_id=${ sessionScope.login.user_id }&moim_idx=${ moimVo.moim_idx }"
		alert("탈퇴되었습니다.")
	  }
	}
	</script>
	
  </div>	
</body>
</html>