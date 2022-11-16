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
   var num = 1;
   $(function() {


	   $('#btnAddFile').on('click', function() {
		   let tag  = '<input type="file" name=\"upfile' + num;
		   tag     += '\" class="upfile" /><br>';
		   $('#tdfile').append( tag  );
		   alert(tag);
		   num++;
	   } );
   });
   
   $(function() {
	   $('#prev').on('click', function() {
		   let tag  = '이전으로 돌아갑니다';
		   alert(tag);
	   } );
   });
</script>
</head>
<body>
  <div id="main">
    <!-- 메뉴 목록 -->
    <%@include file="/WEB-INF/include/pdsmenus.jsp" %>
    
    <!-- 새글 쓰기 자료실 -->
    <!--  파일전송시 필수 enctype = "multipart/form-data" -->
    <form action = "/Pds/Write" method="POST" id="form1">
<input type="hidden" name="menu_idx"   value="1"/>

<%--      <input type="hidden" name="menu_id"      value="${ menu_id }" />
      <input type="hidden" name="bnum"         value="${ pdsvo.bnum }" />   
      <input type="hidden" name="lvl"          value="${ pdsvo.lvl  }" />   
      <input type="hidden" name="step"         value="${ pdsvo.step }" />   
      <input type="hidden" name="nref"         value="${ pdsvo.nref }" />          
      <input type="hidden" name="nowpage"      value="${ pdsvo.nowpage }" />          
      <input type="hidden" name="pagecount"    value="${ pdsvo.pagecount }" />          
      <input type="hidden" name="pagegrpnum"   value="${ pdsvo.pagegrpnum }" />     --%>
          
    <table id="pdsWriteTable">
      <caption><h2> 글쓰기 </h2></caption>
      <tr>
        <td>제목</td>
        <td><input  type="text" name="board_title" id="board_title" /></td>
      </tr>
      <tr>
        <td>작성자</td>
        <td><input type="text" name="user_id" id="user_id"  value="sky" readonly/></td>
      </tr>
      <tr>
        <td>내용</td>
        <td><textarea name="board_cont" id="board_cont"></textarea></td>
      </tr>
     <tr>
        <td>파일 첨부</td>
        <td id="tdfile">
           <input type="button" id="btnAddFile" value="파일 추가"/><br>
           <input type="file" name="upfile" class="upfile" /><br>
        </td>
      </tr>
    
    </table>
      <tr>
        <td  colspan="2">
          <input type="submit"  value="저장" />
        </td>

      </tr>
      <tr>
    	<td  colspan="2">
      	  <input type="button" id="prev" value="이전" />
      	  <a href="javascript:history.back()">이전으로</a>
      	  <button type="button" onclick="location.href='javascript:history.back()';">이전으로</button>
        </td>
      </tr>
            </form>
  </div>
</body>
</html>





