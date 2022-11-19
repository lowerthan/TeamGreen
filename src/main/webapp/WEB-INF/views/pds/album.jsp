<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<link rel="stylesheet" href="/css/home.css"  />
<link rel="icon" type="image/x-icon" href="/img/favicon.ico" />
<title>사진첩</title>

<style>
	h2 {text-align:center;}
</style>

</head>
<body>
<!-- 내비게이션 바 불러오기 -->
<%@include file="/WEB-INF/include/navi.jsp" %>
	<!-- 
	<button type="button" style="float: right" onclick="location.href='/';">　홈으로　</button>
    <button type="button" style="float: right" onclick="location.href='javascript:history.back()';">　이전으로　</button>
  	<button type="button" style="float: right" onclick="location.href='/Pds/Album/WriteForm?moim_idx=1'">　글쓰기　</button>  <%-- 1에 MOIM_IDX 넣어주기--%>
	 -->
	<br><h2><b>사진첩</b></h2><br>

	 <c:forEach var="list" items="${ImageList}">
		  <a href="/Pds/View?board_idx=${ list.board_idx  }&menu_idx=3"><img src="/imgup2/${list.sfilename}"  height="200" width="400" /></a>
	 </c:forEach>
	 
</body>
</html>