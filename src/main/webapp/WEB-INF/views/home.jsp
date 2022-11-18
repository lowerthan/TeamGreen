<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        
        <title>메인 화면</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="/img/favicon.ico" />
        
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/home.css" rel="stylesheet" />
        
        <!-- 현태 행님이 만든 js, 모임 누르면 해당 모임 화면으로 ?! -->
        <script src="https://code.jquery.com/jquery-3.6.1.min.js"> </script>
		<script>
		<!--  
		$(function(){
			$('.moimList').on('click', function(e){
				console.log(e);
				let moim_idx = $('li', this).eq(0).html(); // this <- click한 div의 0번째 li
				let addr     = "/Moim/moimpage?moim_idx=" + moim_idx;
				location.href= addr;
			})
			
		})
		
		-->
		</script>
    </head>
    <body>
        <!-- 내비게이션 바 불러오기 -->
        <%@include file="/WEB-INF/include/navi.jsp" %>
        
        <!-- Header-->
        <header class="bg-dark py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white">
                    <h2 class="display-4 fw-bolder">GreenCom Team 4 <br>Dw + Ss + Ht + Js + Iy</h2>
                    <p class="lead fw-normal text-white-50 mb-0">당신만의 동아리를 만들어가세요</p>
                </div>
            </div>
        </header>
        <!-- Section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="/img/cooking.png" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">요리 / 맛집</h5>
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="/Main/searchmoim?=요리/맛집">해당 카테고리로</a></div>
                            </div>
                        </div>
                    </div>
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="/img/realation.png" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">사교 / 인맥</h5>
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="/Main/searchmoim?=사교/인맥">해당 카테고리로</a></div>
                            </div>
                        </div>
                    </div>
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="/img/travel.png" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">여행 / 캠핑</h5>
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="/Main/searchmoim?=여행/캠핑">해당 카테고리로</a></div>
                            </div>
                        </div>
                    </div>
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="/img/sports.png" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">스포츠 / 운동</h5>
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="/Main/searchmoim?=스포츠/운동">해당 카테고리로</a></div>
                            </div>
                        </div>
                    </div>
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="/img/show.png" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">문화 / 공연</h5>
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="/Main/searchmoim?=문화/공연">해당 카테고리로</a></div>
                            </div>
                        </div>
                    </div>
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="/img/game.png" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">게임 / 오락</h5>
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="/Main/searchmoim?=게임/오락">해당 카테고리로</a></div>
                            </div>
                        </div>
                    </div>
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="/img/music.png" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">댄스 / 음악</h5>
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="/Main/searchmoim?=댄스/음악">해당 카테고리로</a></div>
                            </div>
                        </div>
                    </div>
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="/img/pet.png" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">반려동물</h5>
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="/Main/searchmoim?=반려동물">해당 카테고리로</a></div>
                            </div>
                        </div>
                    </div>
                </div>
				<hr>

				<c:forEach var="moim" items="${ moimList }" begin="0" end="2" >
					       <div class="col">
	        				<div class="card mb-4 rounded-3 shadow-sm">
	          				 <div class="card-header py-3">
	            				<h4 class="my-0 fw-normal">${ moim.moim_name}</h4>
	          				 </div>
	          			   <div class="card-body">
	            			  <h1 class="card-title pricing-card-title">${ moim.user_name }</h1>
	            				<ul class="list-unstyled mt-3 mb-4">
					              <li>${ moim.moim_intro }</li>
	           					</ul>
					            <a href="/Moim/moimpage?moim_idx=${ moim.moim_idx}"><button type="button" class="w-100 btn btn-lg btn-outline-primary">동아리 바로가기</button></a>
					          </div>
					        </div>
					      </div>
				</c:forEach>
				
            </div>
        </section>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Made by GreenComputer Team 4 - Dw, Ss, Ht, Js, Iy 2022</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>
