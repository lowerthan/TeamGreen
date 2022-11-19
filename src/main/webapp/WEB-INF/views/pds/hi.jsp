<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입인사 게시판</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<link rel="stylesheet" href="/css/home.css" />
<link rel="stylesheet" href="/css/list.css" />


<style>
	h2 {text-align:center;}
</style>

</head>
<body>
	<!-- 내비게이션 바 불러오기 -->
    <%@include file="/WEB-INF/include/navi.jsp" %>

	<section class="notice">
	<div id="board-list">
	    <div class="container">
            <h2><b>가입인사 게시판</b></h2>
	        <table class="board-table">
		    
		    <tr>
	         <td class="right" colspan="6">
	         </td>
	       	</tr>
       <tr>
         <td>번호</td>
         <td>인삿말</td>
         <td>작성자</td>       
       </tr>     
     
     
       <c:forEach var="hi" items="${pdsVo}" varStatus="status">
       	 <tr>
			<td>${ status.count }</td>
			<td>${ pdsVo[status.index].board_cont }</td>
			<td>${ pdsVo[status.index].user_id }</td><br>
		</tr>
       </c:forEach>
       
     </table>
   
     
     <!-- 페이징 리스트 -->
     <%@include file="/WEB-INF/include/paging.jsp" %>
     
  	<button type="button" style="float: right" onclick="location.href='/';">　홈으로　</button>
    <button type="button" style="float: right" onclick="location.href='javascript:history.back()';">　이전으로　</button>
  	
  
  
    <button onclick="myFunction2()">　가입　</button>
	<script>
	function myFunction2() {
	  let text = "가입하시겠습니까?";
	  if (confirm(text) == true) {
		alert("가입되었습니다.")  
	    location = "/"
	  } <%-- else {
		location = "http://localhost:8080/User/List/";
	  } --%>
	}
	</script>
  
  
    <button onclick="myFunction()">　탈퇴　</button>
	<script>
	function myFunction() {
	  let text = "탈퇴하시겠습니까?";
	  if (confirm(text) == true) {
		alert("탈퇴되었습니다.")  
	    location = "/"
	  } 
	}
	</script>
	</div>
	
  </div>
  </section>
</body>
</html>


