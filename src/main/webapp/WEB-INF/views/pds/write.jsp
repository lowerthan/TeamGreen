<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>새 글 작성</title>

<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<link rel="stylesheet" href="/css/home.css" />
<style>
   #pdsWriteTable  td:first-child { wdith:150px; text-align: center; }
   #pdsWriteTable  td:last-child  { text-align: left; }
   
   input[type=text]  { width:100%; }
   textarea          { width:100%;  height: 300px;   }
   
   <!-- ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
   		WEB-INF/views/pds에 있는
   		write, view, update.jsp는 table 관련 부분에서
   		common.css 랑 home.css랑 충돌하는 것 같아서
   		common.css 내용을 여기에 내부 스타일 시트로
   		가져다 놓고 우선적용 하는 방식으로 하겠습니다 
   		(아래쪽 부분 전부 common.css 내용 복붙)
   		★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★ -->
   		
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
      <input type="hidden" name="moim_idx"     value="${ map.moim_idx }" />   
          
    <table id="pdsWriteTable">
      <h2><b> 새글 쓰기 </b></h2>
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
          <input type="submit" class="btn btn-primary" value="저장" style="float: center" />
      	  <input type="button" id="prev" class="btn btn-warning" value="이전으로" onclick="location.href='javascript:history.back()';" style="float: center" />
        </td>
      </tr>
    </table>
</form>
  </div>
</body>
</html>





