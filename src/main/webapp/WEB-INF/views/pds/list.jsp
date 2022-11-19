<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유 게시판</title>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<link rel="stylesheet" href="/css/home.css" />
<link rel="stylesheet" href="/css/list_test.css" />

<style>
	tr {text-align : center;}
	h2 {text-align : center;}
</style>

</head>
<body>
	<!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="/">소모임 + 에타 사이트</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/login">로그인</a></li>
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/Mypage?user_id=${ sessionScope.login.user_id }">마이 페이지</a></li>
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="/Main/Createmoim?user_id=${ sessionScope.login.user_id }">모임 개설</a></li>
                        
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

	<section class="notice">
	<!-- 자료실 pdsList -->   
	<!-- <table id="PdsList"> -->
	
	
	
<c:choose>
 <c:when test="${menu_idx eq 1 }">
 <h2>자유게시판</h2>
</c:when>
<c:otherwise>
<h2>Q & A</h2>
</c:otherwise>
</c:choose>
	
	
	
	<!-- board list area -->
	<div id="board-list">
	    <div class="container">
	        <table class="board-table">
		       <!-- 새글 쓰기 -->
		       <thead>
		       <tr>
		         <td class="right" colspan="6">
		         
		         </td>
		       </tr>
		       <tr>
		         <td>번호</td>
		         <td>제목</td>
		         <td>작성자</td>
		         <td>조회수</td>
		         <td>작성일</td>       
		       </tr>     
		       </thead>
		     
		       <c:forEach var="pds"  items="${ pdsList }">
		        <tr>
		         <!-- 번호 -->
		         <td>
			       <c:if test="${ pds.lvl eq 0 }">
			         ${ pds.bnum }
			       </c:if>
		         </td>
		        <!-- 제목 -->        
		         <td>        
		           <!-- 새글/답글 -->
		           <c:choose> 
		            <c:when test="${ pds.lvl eq 0 }">
		              <a href="/Pds/View?menu_idx=${ pds.menu_idx }&board_idx=${pds.board_idx}&nowpage=${map.nowpage}&pagecount=${map.pagecount}&pagegrpnum=${map.pagegrpnum}">
		              ${ pds.board_title }
		              </a>
		            </c:when>            
		            <c:otherwise>
		             <b style="display:inline-block;width:${pds.lvl*20}px"></b> 
		             <a href="/Pds/View?menu_idx=${ pds.menu_idx }&board_idx=${pds.board_idx}&nowpage=${map.nowpage}&pagecount=${map.pagecount}&pagegrpnum=${map.pagegrpnum}">
		              [답글]  ${ pds.board_title }
		             </a> 
		            </c:otherwise>
		            </c:choose>
		         </td>         
		         
		         <!-- 작성자  -->
		         <td>${ pds.user_id }</td>
		         <!-- 조회수  -->
		         <td>${ pds.readcount }</td>
		         <!-- 작성일  -->
		         <td>${fn:substring(pds.board_regdate, 0, 10) }</td>     
         
        	</tr>
        
       </c:forEach>
    
     </table>
	<button type="button" style="float: right" onclick="location.href='/Pds/WriteForm?menu_idx=${ menu_idx }&bnum=0&lvl=0&step=0&nref=0&nowpage=${map.nowpage}&pagecount=${map.pagecount}&pagegrpnum=${map.pagegrpnum}&moim_idx=${map.moim_idx}'">　글쓰기　</button>
     
   </div>
   </div>
     <!-- 페이징 리스트 -->
	<br><%@include file="/WEB-INF/include/paging.jsp" %>
	
   </section>
	
</body>
</html>