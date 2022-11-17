<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
  function showPopup(){ // 학교검색 팝업창으로 열기
      newWindow = window.open("/univSearch", "학교검색 팝업창", "width=400, height=300, top=10, left=10");
  }

  function setChildValue(pick){ // 팝업창 선택한 정보 입력해주기
      document.getElementById("univname").value = pick;
  }
        
  function chk(){ // 수정버튼 클릭 
	  var pw = document.myinfo.user_pw.value;
	  if(pw == ""){
		  alert("비밀번호를 입력하세요.")
		  document.myinfo.user_pw.focus();
          return false;
	  }
	  alert('수정완료');
  }
 
</script>
</head>
<body>
   <a href="/">Home</a>
   <a href="/logout">로그아웃</a>
  <p id="show"></p>
  <form name="myinfo" id="myinfo"  action="/Update" method="POST" >
      <fieldset>
         <legend>사용자 정보</legend>
         <ul>
         <!-- USER_ID, USER_PW, USER_NAME, USER_CATE, UNIV_IDX -->
            <li>
               <label>아이디 : ${ sessionScope.login.user_id }</label>
               <input type="hidden" name="user_id"  value="${ sessionScope.login.user_id }">
            </li>
            <li>
               <label>비밀번호 :</label>
               <input type="password" name="user_pw" required value="${ sessionScope.login.user_pw }">
            </li>
            <li>
               <label>이름 : ${ sessionScope.login.user_name }</label>
               <input type="hidden" name="user_name"  value="${ sessionScope.login.user_name }">
            </li>
            <li>
               <label>학교 :</label>
               <input type="text" id="univname" name="univname"  value="${ sessionScope.login.univname }" readonly>
               <input type="button" value="학교검색" onclick="showPopup();">
            </li>
            
              <li><label>관심사 (중복체크 가능)</label>
              
              <tr>
                <c:set var = "cate" value = "${ sessionScope.login.user_cate }"/>
			    <c:if test = "${fn:contains(cate, '스포츠/운동')}">
				  <li><label><input type="checkbox" name="user_cate" value="스포츠/운동" checked >스포츠 / 운동</label></li>
			    </c:if>
			    <c:if test = "${not fn:contains(cate, '스포츠/운동')}">
				  <li><label><input type="checkbox" name="user_cate" value="스포츠/운동" >스포츠 / 운동</label></li>
			    </c:if>
			    <c:if test = "${fn:contains(cate, '문화/공연')}">
				  <li><label><input type="checkbox" name="user_cate" value="문화/공연" checked >문화 / 공연</label></li>
			    </c:if>
			    <c:if test = "${not fn:contains(cate, '문화/공연')}">
				  <li><label><input type="checkbox" name="user_cate" value="문화/공연" >문화 / 공연</label></li>
			    </c:if>
			    <c:if test = "${fn:contains(cate, '게임/오락')}">
				  <li><label><input type="checkbox" name="user_cate" value="게임/오락" checked >게임 / 오락</label></li>
			    </c:if>
			    <c:if test = "${not fn:contains(cate, '게임/오락')}">
				  <li><label><input type="checkbox" name="user_cate" value="게임/오락" >게임 / 오락</label></li>
			    </c:if>
			    <c:if test = "${fn:contains(cate, '사교/인맥')}">
				  <li><label><input type="checkbox" name="user_cate" value="사교/인맥" checked >사교 / 인맥</label></li>
			    </c:if>
			    <c:if test = "${not fn:contains(cate, '사교/인맥')}">
				  <li><label><input type="checkbox" name="user_cate" value="사교/인맥" >사교 / 인맥</label></li>
			    </c:if>
			    <c:if test = "${fn:contains(cate, '댄스/음악')}">
				  <li><label><input type="checkbox" name="user_cate" value="댄스/음악" checked >댄스 / 음악</label></li>
			    </c:if>
			    <c:if test = "${not fn:contains(cate, '댄스/음악')}">
				  <li><label><input type="checkbox" name="user_cate" value="댄스/음악" >댄스 / 음악</label></li>
			    </c:if>
			    <c:if test = "${fn:contains(cate, '요리/맛집')}">
				  <li><label><input type="checkbox" name="user_cate" value="요리/맛집" checked >요리 / 맛집</label></li>
			    </c:if>
			    <c:if test = "${not fn:contains(cate, '요리/맛집')}">
				  <li><label><input type="checkbox" name="user_cate" value="요리/맛집" >요리 / 맛집</label></li>
			    </c:if>
			    <c:if test = "${fn:contains(cate, '여행/캠핑')}">
				  <li><label><input type="checkbox" name="user_cate" value="여행/캠핑" checked >여행 / 캠핑</label></li>
			    </c:if>
			    <c:if test = "${not fn:contains(cate, '여행/캠핑')}">
				  <li><label><input type="checkbox" name="user_cate" value="여행/캠핑" >여행 / 캠핑</label></li>
			    </c:if>
			    <c:if test = "${fn:contains(cate, '반려동물')}">
				  <li><label><input type="checkbox" name="user_cate" value="반려동물" checked >반려동물 / 펫</label></li>
			    </c:if>
			    <c:if test = "${not fn:contains(cate, '반려동물')}">
				  <li><label><input type="checkbox" name="user_cate" value="반려동물" >반려동물 / 펫</label></li>
			    </c:if>
              </tr>        
         </ul>
      </fieldset>
      <div id="buttons">
         <input type="submit" value="수정하기" onclick="return chk()" >
         <input type="reset" value="취소">
       </div>
   </form>
   <br>
   <fieldset>
     <legend>내모임 리스트</legend>
        <div id="main">
   <c:forEach var="moims" items="${ usermoimslist }">
   <div class="item">
   <ul>
     <li><a href="/Moim/moimpage?moim_idx=${ moims.moim_idx }">${ moims.moim_name } --- ${ moims.moim_cate } </a></li>
   </ul>
   </div>
   </c:forEach>   
 </div>
   </fieldset>
   
</body>
</html>