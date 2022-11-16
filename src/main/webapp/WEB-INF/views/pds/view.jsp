<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
 <%@taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions"%>   
    
<% pageContext.setAttribute("newLine", "\n"); %>    

<%--  : jsp 주석
   pageContext.setAttribute : 현재 페이지에서만 사용되는 변수 설정
    ${fn:replace(pdsVo.cont, newLine, "<br />" ) } 사용하기
 --%>    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<link rel="stylesheet" href="/css/common.css" />
<style>
  #PdsView td:nth-of-type(1) {  width : 150px; text-align: center;   }
  #PdsView td:nth-of-type(2) {  width : 400px; text-align: center;   }
  #PdsView td:nth-of-type(3) {  width : 150px; text-align: center;   }
  #PdsView td:nth-of-type(4) {  width : 400px; text-align: center;   }
  
  #PdsView td[colspan]                 { text-align: left; }
  #PdsView tr:last-child td[colspan]   { text-align: center; }
  
  #PdsView tr:nth-of-type(4) { height: 400px;}
  #PdsView tr:nth-of-type(5) { height: 120px;}
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
  $(function() {
	  
  });
</script>
</head>
<body> 
   <div id="main">
      <!-- 자료실 메뉴 목록 -->
      <%@include file="/WEB-INF/include/pdsmenus.jsp" %>
      
      <!-- 자료실 pdsList -->   
      <table id="PdsView">
       <caption><h2>내용보기</h2></caption>
       <button type="button" style="float: right" onclick="location.href='/';">　홈으로　</button>
       <button type="button" style="float: right" onclick="location.href='http://localhost:8080/User/List';">　마이페이지　</button>
       <tr>
         <td>작성자</td>
         <td>${ pdsVo.writer }</td>
         <td>작성일</td>
         <td>${ pdsVo.regdate }</td>
       </tr> 
       <tr>
         <td>글번호</td>
         <td>${ pdsVo.idx }</td>
         <td>조회수</td>
         <td>${ pdsVo.readcount }</td>
       </tr> 
       <tr>
         <td>글제목</td>
         <td colspan="3">${ pdsVo.title }</td>     
       </tr> 
       <tr>
         <td>글내용</td>
         <td colspan="3">
           ${fn:replace(pdsVo.cont, newLine, "<br />" ) } <!-- "\n" 안먹음 -->
         </td>     
       </tr> 
       <tr>
         <td>파일</td>
         <td colspan="3">
	      <c:forEach  var="file" items="${ filesList  }">
	        <div>
	         <%--  <a href="/Pds/download/external/${ file.sfilename }"> --%> 
	         <a href="<c:out value="/Pds/download/external/${ file.sfilename }"  />">
	          ${ file.filename }
	          </a>
	        </div>
	      </c:forEach>          
         </td>     
       </tr> 
       <tr>
         <td colspan="4">
         <button type="button" onclick="location.href='/Pds/WriteForm?menu_id=${map.menu_id}&bnum=0&lvl=0&step=0&nref=0&nowpage=${map.nowpage}&pagecount=${map.pagecount}&pagegrpnum=${map.pagegrpnum}';">　글쓰기　</button>
         <button type="button" onclick="location.href='/Pds/WriteForm?menu_id=${map.menu_id}&idx=${pdsVo.idx}&bnum=${pdsVo.bnum}&lvl=${pdsVo.lvl}&step=${pdsVo.step}&nref=${pdsVo.nref}';">　답글 쓰기　</button>
         <button type="button" onclick="location.href='/Pds/UpdateForm?menu_id=${menu_id}&idx=${pdsVo.idx}&nowpage=${map.nowpage}&pagecount=${map.pagecount}&pagegrpnum=${map.pagegrpnum}';">　수정　</button>
         <button type="button" onclick="location.href='/Pds/Delete?menu_id=${menu_id}&idx=${pdsVo.idx}&nowpage=${map.nowpage}&pagecount=${map.pagecount}&pagegrpnum=${map.pagegrpnum}';">　삭제　</button>
         <button type="button" onclick="location.href='javascript:history.back()';">　이전으로　</button>
         <button type="button" onclick="location.href='/';">　홈으로　</button>
	     </td>     
       </tr> 
       
   	  </table>
   </div> 
</body>
</html>







