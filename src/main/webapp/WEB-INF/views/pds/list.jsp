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
<link rel="stylesheet" href="/css/list.css" />

<style>
	tr {text-align : center;}
	h2 {text-align : center;}
</style>

</head>
<body>
	<!-- 내비게이션 바 불러오기 -->
    <%@include file="/WEB-INF/include/navi.jsp" %>

	<section class="notice">
	<!-- 자료실 pdsList -->   
	<!-- <table id="PdsList"> -->
	<!-- board list area -->
	<div id="board-list">
	    <div class="container">
            <h2><b>게시판</b></h2><br>
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
	<button type="button" style="float: right" onclick="location.href='/Pds/WriteForm?menu_idx=${ menu_idx }&bnum=0&lvl=0&step=0&nref=0&nowpage=${map.nowpage}&pagecount=${map.pagecount}&pagegrpnum=${map.pagegrpnum}'">　글쓰기　</button>
     
   </div>
   </div>
     <!-- 페이징 리스트 -->
	<br><%@include file="/WEB-INF/include/paging.jsp" %>
	
   </section>
	
</body>
</html>