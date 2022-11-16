<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        
        <title>My Page</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="/img/favicon.ico" />
        
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/home.css" rel="stylesheet" />
        <link href="css/signUpForm.css" rel="stylesheet" />
        
<!-- 내부 스타일 시트 -->
<style>
.btn {
  position:relative;
  left:25%;
  transform: translateX(-50%);
  margin-bottom: 40px;
  width:30%;
  height:40px;
  background: linear-gradient(125deg,#81ecec,#6c5ce7,#81ecec);
  background-position: left;
  background-size: 200%;
  color:white;
  font-weight: bold;
  border:none;
  cursor:pointer;
  transition: 0.4s;
  display:inline;
}
</style>
        
        <!-- 현태 행님이 만든 js, 모임 누르면 해당 모임 화면으로 ?! -->
        <script src="https://code.jquery.com/jquery-3.6.1.min.js"> </script>
		<script>
		$(function(){
			$('.moimList').on('click', function(e){
				console.log(e);
				let moim_idx = $('li', this).eq(0).html(); // this <- click한 div의 0번째 li
				let addr     = "/Moim/moimpage?moim_idx=" + moim_idx;
				location.href= addr;
			})
			
		})
		
		</script>
		
		<!-- 학교 검색 팝업 -->
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script>
		  function showPopup(){ // 학교검색 팝업창으로 열기
		      newWindow = window.open("/univSearch","학교검색 팝업창","width=400, height=300, top=10, left=10");
		  }
		
		  function setChildValue(pick){ // 팝업창 선택한 정보 입력해주기
		      document.getElementById("univname").value = pick;
		  }
		        
		  function msg(){ // 수정버튼 클릭 
			  alert('수정완료');
		  }
		</script>
    </head>
    <body>
        <!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="/">소모임 + 에타 사이트</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/" >홈 화면</a></li>
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/logout" >로그아웃</a></li>
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/Main/Createmoim?user_id=${ sessionScope.login.user_id }" >모임 개설</a></li>
                        
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/Main/searchmoim">모임 검색</a></li>
                        
                        <!-- 
                        <form class="d-flex" role="search">
							<input class="form-control me-2" name="searchword" type="search" placeholder="모임검색" aria-label="Search">
						</form>
                        
                        <li class="nav-item"><a class="nav-link" href="/login">로그인</a></li>
                        
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">여러가지 메뉴</a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="#!">모임 관련</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="/Main/Createmoim?user_id=${ sessionScope.login.user_id }">모임 개설</a></li>
                                <li><a class="dropdown-item" href="#!">New Arrivals</a></li>
                            </ul>
                        </li>
                         -->
                    </ul>
                    <form class="d-flex">
                        <b><big>${ sessionScope.login.univname }</big></b>
                        
                        <!-- 이거 지우면 장바구니 그림이랑 카트 생김
                        <button class="btn btn-outline-dark" type="submit">
                            <i class="bi-cart-fill me-1"></i>
                            <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
                        </button>
                         -->
                    </form>
                </div>
            </div>
        </nav>
		<hr>
		
	<!--  
	<p id="show"></p>
    <fieldset>
    <ul>
    </fieldset>
 		 -->

		
		<!-- 
		<c:forEach var="moim" items="${ moimList }" >
			<div class="moimList">
		    <ul>
		      <li>${ moim.moim_idx   }</li>
		      <li>${ moim.user_id   }</li>
		      <li>${ moim.moim_name   }</li>
		      <li>${ moim.moim_intro }</li>
		    </ul>
			</div>
		</c:forEach>
		 -->
		
		
		<!-- 임시 테스트 중 -->
	<div class="container px-4 px-lg-5 my-5">
	<form id="myinfo" action="/Update" method="POST" class="joinForm" >
		<h2>사용자 정보</h2>
		<div class="textForm">
		  <input name="user_id" type="text" class="user_id" id="user_id" value="${ sessionScope.login.user_id }"  readonly >
		</div>
		<div class="textForm">
		  <input name="user_pw" type="password" class="user_pw" id="user_pw" value="${ sessionScope.login.user_pw }" >
		</div>
		<div class="textForm">
		  <input name="user_name" type="text" class="user_name" id="user_name" value="${ sessionScope.login.user_name }" readonly >
		</div>
		<div class="textForm">
			<label>관심사 (중복체크 가능)</label> <br><br>
			<c:set var = "cate" value = "${ sessionScope.login.user_cate }"/>
			    <c:if test = "${fn:contains(cate, '스포츠/운동')}">
				  <label><input type="checkbox" name="user_cate" value="스포츠/운동" checked >스포츠 / 운동</label>
			    </c:if>
			    <c:if test = "${not fn:contains(cate, '스포츠/운동')}">
				  <label><input type="checkbox" name="user_cate" value="스포츠/운동" >스포츠 / 운동</label>
			    </c:if>
			    <c:if test = "${fn:contains(cate, '문화/공연')}">
				  <label><input type="checkbox" name="user_cate" value="문화/공연" checked >문화 / 공연</label>
			    </c:if>
			    <c:if test = "${not fn:contains(cate, '문화/공연')}">
				  <label><input type="checkbox" name="user_cate" value="문화/공연" >문화 / 공연</label>
			    </c:if>
			    <c:if test = "${fn:contains(cate, '게임/오락')}">
				  <label><input type="checkbox" name="user_cate" value="게임/오락" checked >게임 / 오락</label>
			    </c:if>
			    <c:if test = "${not fn:contains(cate, '게임/오락')}">
				  <label><input type="checkbox" name="user_cate" value="게임/오락" >게임 / 오락</label>
			    </c:if>
			    <c:if test = "${fn:contains(cate, '사교/인맥')}">
				  <label><input type="checkbox" name="user_cate" value="사교/인맥" checked >사교 / 인맥</label>
			    </c:if>
			    <c:if test = "${not fn:contains(cate, '사교/인맥')}">
				  <label><input type="checkbox" name="user_cate" value="사교/인맥" >사교 / 인맥</label>
			    </c:if>
			    <c:if test = "${fn:contains(cate, '댄스/음악')}">
				  <label><input type="checkbox" name="user_cate" value="댄스/음악" checked >댄스 / 음악</label>
			    </c:if>
			    <c:if test = "${not fn:contains(cate, '댄스/음악')}">
				  <label><input type="checkbox" name="user_cate" value="댄스/음악" >댄스 / 음악</label>
			    </c:if>
			    <c:if test = "${fn:contains(cate, '요리/맛집')}">
				  <label><input type="checkbox" name="user_cate" value="요리/맛집" checked >요리 / 맛집</label>
			    </c:if>
			    <c:if test = "${not fn:contains(cate, '요리/맛집')}">
				  <label><input type="checkbox" name="user_cate" value="요리/맛집" >요리 / 맛집</label>
			    </c:if>
			    <c:if test = "${fn:contains(cate, '여행/캠핑')}">
				  <label><input type="checkbox" name="user_cate" value="여행/캠핑" checked >여행 / 캠핑</label>
			    </c:if>
			    <c:if test = "${not fn:contains(cate, '여행/캠핑')}">
				  <label><input type="checkbox" name="user_cate" value="여행/캠핑" >여행 / 캠핑</label>
			    </c:if>
			    <c:if test = "${fn:contains(cate, '반려동물')}">
				  <label><input type="checkbox" name="user_cate" value="반려동물" checked >반려동물 / 펫</label>
			    </c:if>
			    <c:if test = "${not fn:contains(cate, '반려동물')}">
				  <label><input type="checkbox" name="user_cate" value="반려동물" >반려동물 / 펫</label>
			    </c:if>
		</div>
		<div class="textForm">
		       <input type="text" id="univname" name="univname" value="${ sessionScope.login.univname }" readonly>
               <input type="button" value="학교검색" onclick="showPopup();">
		</div>
		
		<div class="textForm">
	     	<legend>가입한 동아리 (소모임) 리스트</legend>
	        <div id="main">
	   			<c:forEach var="moims" items="${ usermoimslist }">
	   			<div class="item">
		   		<ul>
		     		<li><a href="/Moim/moimpage?moim_idx=${ moims.moim_idx }">${ moims.moim_name } --- ${ moims.moim_cate } </a></li>
		   		</ul>
		  		</div>
	   			</c:forEach>   
	 		</div>
	  	</div>
		
		<input type="submit" class="btn1" value="수정하기" onclick="msg();" >
		<input type="reset" class="btn2" value="취소" >
    </form>
		</div>
		
		<!-- 
        Footer
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Made by GreenComputer Team 4 - Dw, Ss, Ht, Js, Iy 2022</p></div>
        </footer>
        Bootstrap core JS
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        Core theme JS
        <script src="js/scripts.js"></script>
        -->
    </body>
</html>
