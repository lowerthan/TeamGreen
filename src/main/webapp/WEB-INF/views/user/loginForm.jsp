<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>로그인 화면</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<link rel="stylesheet" href="/css/loginForm.css" />
</head>
<body>
	<div class="sidenav">
		<div class="login-main-text">
		   <h2>모두 모이는<br>우리들의 사이트</h2>
		   <br><p>이곳에서 당신만의 모임을 만들어가세요</p>
		</div>
	</div>
	<div class="main">
	   <div class="col-md-6 col-sm-12">
	      <div class="login-form">
	     		 <form action="/loginProcess" method="POST">
	             <div class="form-group">
	                <label>아이디</label>
	                <input type="text" class="form-control" name="user_id" placeholder="아이디를 입력하세요">
	             </div>
	             <div class="form-group">
	                <label>비밀번호</label>
	                <input type="password" class="form-control" name="user_pw" placeholder="비밀번호를 입력하세요">
	             </div>
	             <button type="submit" class="btn btn-black">로그인</button>
	         	</form>
	      </div>
	 		<br>
	  		<form action="/signUpForm" method="GET">
	       	<button type="submit" class="btn btn-secondary">회원가입</button>
	       </form>
	   </div>
	</div>
</body>