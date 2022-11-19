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
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<title>내용 보기</title>

<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<link rel="stylesheet" href="/css/home.css" />
<style>
  #PdsView td:nth-of-type(1) {  width : 150px; text-align: center;   }
  #PdsView td:nth-of-type(2) {  width : 400px; text-align: center;   }
  #PdsView td:nth-of-type(3) {  width : 150px; text-align: center;   }
  #PdsView td:nth-of-type(4) {  width : 400px; text-align: center;   }
  
  #PdsView td[colspan]                 { text-align: left; }
  #PdsView tr:last-child td[colspan]   { text-align: center; }
  
  #PdsView tr:nth-of-type(4) { height: 400px;}
  #PdsView tr:nth-of-type(5) { height: 120px;}
  

  <!-- common.css 내용 그대로 가져옴 -->
   * { box-sizing:border-box; 
       padding:0; margin:0;
   }
   a { text-decoration:none; color:black;}
   a:hover {text-decoration:underline; color:black;}
   
   table, th, td {  
      border : 1px solid  #c0c0c0;
      border-collapse : collapse;
   }
   th, td {  padding:10px; }
   #main { width:80%; margin:0 auto; }
   table { width:100%;}
   
   #menu  { margin-top : 50px;}   
   
   #menu td { text-align :center; } 
   
   .left   { text-align:left !important;}
   .center { text-align:center !important;  }
   .right  { text-align:right !important;  }
   
   h2   { margin:20px; text-align:center;}
  
   #menu  td   {  padding:0;  } 
   #menu  td  a {
      display : inline-block;
      width   : 100%;
      padding : 10px;
   }
   #menu  td  a:hover { background: yellow;  }  
   
   input { height:32px; }  
</style>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
  $(function() {
	  
  });
</script>
</head>
<body> 
<!-- 내비게이션 바 불러오기 -->
<%@include file="/WEB-INF/include/navi.jsp" %>

   <div id="main">
      
      <!-- 자료실 pdsList -->   
      <table id="PdsView">
       <br>
       <h2><b>내용보기</b></h2>
       <br>
       <tr>
         <td>작성자</td>
         <td>${ pdsVo.user_id }</td>
         <td>작성일</td>
         <td>${ pdsVo.board_regdate }</td>
       </tr> 
       <tr>
         <td>글번호</td>
         <td>${ pdsVo.board_idx }</td>
         <td>조회수</td>
         <td>${ pdsVo.readcount }</td>
       </tr> 
       <tr>
         <td>글제목</td>
         <td colspan="3">${ pdsVo.board_title }</td>     
       </tr>
        
       <tr>
         <td>글내용</td>
         <td colspan="3">
<%--       ${fn:replace(pdsVo.board_cont, newLine, "<br />" ) } <!-- "\n" 안먹음 -->  --%>
           ${pdsVo.board_cont } <!-- "\n" 안먹음 -->
         </td>     
       </tr> 
       
       </table>

       <br>
       <tr>
         <td colspan="4">
         <button type="button" class="btn btn-primary" onclick="location.href='/Pds/WriteForm?menu_idx=${ menu_idx }&bnum=0&lvl=0&step=0&nref=0&nowpage=${map.nowpage}&pagecount=${map.pagecount}&pagegrpnum=${map.pagegrpnum}';">　글쓰기　</button>
<%-- 	 <button type="button" onclick="location.href='/Pds/WriteForm?menu_idx=${pdsVo.menu_idx}&bnum=${pdsVo.bnum}&lvl=${pdsVo.lvl}&step=${pdsVo.step}&nref=${pdsVo.nref}';">　답글 쓰기　</button>		 --%>
         <button type="button" class="btn btn-success" onclick="location.href='/Pds/UpdateForm?menu_idx=${pdsVo.menu_idx}&board_idx=${map.board_idx}';">　수정　</button>
     	 <button type="button" class="btn btn-danger" onclick="location.href='/Pds/Delete?menu_idx=${pdsVo.menu_idx}&board_idx=${map.board_idx}';">　삭제　</button> 	
         <button type="button" class="btn btn-warning" onclick="location.href='javascript:history.back()';">　이전으로　</button>
         <button type="button" class="btn btn-dark" onclick="location.href='/';">　홈으로　</button> 
	     </td>     
       </tr><br><br><br>
       
       <c:forEach var="commentslist" items="${CommentsList}" varStatus="status">
       	 <tr>
			<td>${ status.count }</td>
			<td>유저 아이디: ${ CommentsList[status.index].user_id }</td><br>
			<td>댓글내용: ${ CommentsList[status.index].cont }</td><br>
		</tr>
       </c:forEach>
   	  <form action="/Pds/inputcomment" method="post" id="inputcomment">
   	  <input type="hidden" name="board_idx" value="${pdsVo.board_idx}">
   	  <input type="hidden" name="menu_idx" value="${menu_idx}">
   	  <input type="text" name="comment" value="" />
   	  <input type="text" name="user_id" value="${ sessionScope.login.user_id }" readonly />
   	  <button type="submit" form="inputcomment">댓글 달기</button>
   	  </form>
       
   	  
   </div> 
</body>
</html>







