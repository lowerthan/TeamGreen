<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<link rel="stylesheet" href="/css/common.css" />
<style>
   #pdsWriteTable  td:first-child { wdith:150px; text-align: center; }
   #pdsWriteTable  td:last-child  { text-align: left; }
   
   input[type=text]  { width:100%; }
   textarea          { width:100%;  height: 300px;   }
</style>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>

  
</script>
</head>
<body>
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
      <caption><h2> 글쓰기 </h2></caption>
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
         

    </table>
      <tr>
        <td  colspan="2">
          <input type="submit"  value="저장" />
        </td>

      </tr>
      <tr>
    	<td  colspan="2">
      	  <input type="button" id="prev" value="이전" onclick="location.href='javascript:history.back()';"/>
        </td>
      </tr>
</form>
  </div>
</body>
</html>





