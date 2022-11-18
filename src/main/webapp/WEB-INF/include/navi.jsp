<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!-- Navigation-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="/mainpage">소모임 + 에타 사이트</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                        <c:choose>
                          <c:when test="${  sessionScope.login == null  }" >
                            <li class="nav-item"><a class="nav-link active" aria-current="page" href="/login">로그인</a></li>
                          </c:when>
                          <c:otherwise>
                             <li class="nav-item"><a class="nav-link active" aria-current="page" href="/logout2">로그아웃</a></li>
                        	 <li class="nav-item"><a class="nav-link active" aria-current="page" href="/Mypage?user_id=${ sessionScope.login.user_id }">마이 페이지</a></li>
                       		 <li class="nav-item"><a class="nav-link active" aria-current="page" href="/Main/Createmoim?user_id=${ sessionScope.login.user_id }">모임 개설</a></li>
                          </c:otherwise>
                        </c:choose>
                        
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