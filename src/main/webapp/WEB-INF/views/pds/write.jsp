<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>글쓰기</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<link href="/css/home.css" rel="stylesheet" />
<style>
   #pdsWriteTable  td:first-child { wdith:150px; text-align: center; } 
   #pdsWriteTable  td:last-child  { text-align: left; }
   
   input[type=text]  { width:100%; }
   textarea          { width:100%;  height: 300px; }
   
   
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
</script>
</head>
<body>
<!-- 내비게이션 바 불러오기 -->
<%@include file="/WEB-INF/include/navi.jsp" %>
        
  <div id="main">
    
    <!-- 새글 쓰기 자료실 -->
    <form action = "/Pds/Write" method="POST" id="form1">
	  <input type="hidden" name="menu_idx"     value="${ map.menu_idx }"/>
      <input type="hidden" name="bnum"         value="${ map.bnum }" />   
      <input type="hidden" name="lvl"          value="${ map.lvl  }" />   
      <input type="hidden" name="step"         value="${ map.step }" />   
      <input type="hidden" name="nref"         value="${ map.nref }" />          
      <input type="hidden" name="nowpage"      value="${ map.nowpage }" />          
      <input type="hidden" name="pagecount"    value="${ map.pagecount }" />          
      <input type="hidden" name="pagegrpnum"   value="${ map.pagegrpnum }" />   
          
    <table id="pdsWriteTable">
      <br>
      <h2><b>글쓰기</b></h2>
      <br>
      <tr>
        <td>제목</td>
        <td><input  type="text" name="board_title" id="board_title" /></td>
      </tr>
      <tr>
        <td>작성자</td>
        <td><input type="text" name="user_id" id="user_id"  value="${ sessionScope.login.user_id }" readonly/></td>
      </tr>
      <tr>
        <td>내용</td>
        <td><textarea name="board_cont" id="board_cont"></textarea></td>
      </tr>
         

      <tr>
        <td  colspan="2">
          <input type="submit" class="btn btn-primary" value="저장" />
          <input type="button" class="btn btn-dark" id="prev" value="이전" onclick="location.href='javascript:history.back()';"/>
        </td>
      </tr>
    </table>
</form>
  </div>
</body>
</html>





