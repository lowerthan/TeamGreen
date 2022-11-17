<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<link rel="stylesheet" href="/css/common.css" />
<style>
  #PdsList  td:nth-of-type(1) { width:70px;  text-align: center; }   
  #PdsList  td:nth-of-type(2) { width:300px; text-align: left; }  
  #PdsList  td:nth-of-type(3) { width:80px; text-align: center; }  
  #PdsList  td:nth-of-type(4) { width:80px; text-align: center; }  
  #PdsList  td:nth-of-type(5) { width:100px; text-align: center; }  
  #PdsList  td:nth-of-type(6) { width:100px; text-align: center; }  
</style>
</head>
<body>
  <div id="main">
      
      <!-- 자료실 pdsList -->   
     <table id="PdsList">
       <caption><h2>자유게시판</h2></caption>
       <button type="button" style="float: right" onclick="location.href='/';">　홈으로　</button>
       <button type="button" style="float: right" onclick="location.href='http://localhost:8080/User/List';">　마이페이지　</button>
       <!-- 새글 쓰기 -->
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
              <a href="/Pds/View?board_idx=${ pds.board_idx }&menu_idx=${ pds.menu_idx }">
              ${ pds.board_title }
              </a>
            </c:when>            
            <c:otherwise>
             <b style="display:inline-block;width:${pds.lvl*20}px"></b> 
             <a href="/Pds/View?board_idx=${ pds.board_idx }&menu_idx=${ pds.menu_idx }&nowpage=${map.nowpage}&pagecount=${map.pagecount}&pagegrpnum=${map.pagegrpnum}">
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
   
     
     <!-- 페이징 리스트 -->
     <%@include file="/WEB-INF/include/paging.jspf" %>
  	<button type="button" style="float: right" onclick="location.href='/';">　홈으로　</button>
    <button type="button" style="float: right" onclick="location.href='javascript:history.back()';">　이전으로　</button>
  	<button type="button" style="float: right" onclick="location.href='/Pds/WriteForm'">　글쓰기　</button>
  
  
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
</body>
</html>


