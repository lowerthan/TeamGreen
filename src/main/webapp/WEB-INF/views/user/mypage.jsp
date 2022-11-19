<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>  
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>My Page</title>

<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="/img/favicon.ico" />

<!-- Bootstrap icons-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />

<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/home.css" rel="stylesheet" />
<link href="css/signUpForm.css" rel="stylesheet" />

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
  function showPopup(){ // 학교검색 팝업창으로 열기
      newWindow = window.open("/univSearch", "학교검색 팝업창", "width=400, height=300, top=10, left=10");
  }

  function setChildValue(pick){ // 팝업창 선택한 정보 입력해주기
      document.getElementById("univname").value = pick;
  }
        
  function chk(){ // 수정버튼 클릭 

	  var pw = document.getElementsByName("user_pw")[0].value;

	  if(pw == ""){
		  alert("비밀번호를 입력하세요.")
		  document.getElementsByName("user_pw")[0].focus();
          return false;
	  }
	  alert('수정완료');
  }
 
</script>
</head>
<body>

  <div class="container px-4 px-lg-5 ">
	<form id="myinfo" action="/Update" method="POST" class="joinForm" >
		<h2><b>사용자 정보</b></h2>
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
			<label><b>관심사 (중복체크 가능)</b></label> <br><br>
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
			<label><b>내가 가입한 모임 목록</b></label><br><br>
			<c:forEach var="moims" items="${ usermoimslist }">
				<div class="item">
				<ul>
					<li><a href="/Moim/moimpage?moim_idx=${ moims.moim_idx }">${ moims.moim_name } --- ${ moims.moim_cate } </a></li>
				</ul>
				</div>
			</c:forEach>   
		</div>
	 	<div id="buttons">
	        <input type="submit" class="btn1" value="수정하기" onclick="return chk()" >
	        <input type="reset" class="btn2" value="원래대로">
		</div>
   </form>
   </div>
   
</body>
</html>