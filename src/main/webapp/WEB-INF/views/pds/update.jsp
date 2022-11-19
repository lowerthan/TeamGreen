<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri= "http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri= "http://java.sun.com/jsp/jstl/functions" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1" />

<title>글 수정</title>

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
  
  input[type=text]  { width:100%; }
  textarea          { width:100%; height:400px; }


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
  $(function() {
	  let  num = 1;
	  $('#btnAddFile').on('click', function(e) {
		  // <button> submit 능력을 제거
		  e.preventDefault();
		  e.stopPropagation();
		  let tag = '<input type="file" name="file' + num + '" /><br />';
		  $('#tdfile').append( tag );
		  num++;		  
	  });
	  
	  $('form').on('submit', function(e) {
		  if( $('[name=title]').val().trim() == '') {
			  alert('제목을 입력하세요');
			  $('[name=title]').focus();
			  return false;
		  }
	  });



	  $('#tdfile').on('click','.aDelete',  function( e ) {
		  // a tag 기본 이벤트 제거 href 로 이동하는 것 방지
		  e.preventDefault();
		  e.stopPropagation();
		  
		  let  aDelete = e.target;  // == let  aDelete = this;
		  let  href    = aDelete.href;
		  
		  $.ajax({
			  url     : href,
			  method  : 'GET', 
			  success : function(data) {
				  alert('삭제 완료');	
				  $(aDelete).parent().remove();  // 부모 element 제거
			  },
			  error : function(xhr) {
				  alert(xhr.status + ':' + xhr.textStatus);
			  }
		  })
		  
	  })
  });
</script>
</head>
<body>
<!-- 내비게이션 바 불러오기 -->
<%@include file="/WEB-INF/include/navi.jsp" %>
  <div id="main">
  
    <form  action="/Pds/Update" method="POST">

    <input  type="hidden"  name="board_idx" value="${ pdsVo.board_idx }" />
     <input  type="hidden"  name="moim_idx" value="${ pdsVo.moim_idx }" />
   <input  type="hidden"  name="menu_idx" value="${ pdsVo.menu_idx }" />
<%--     <input type="hidden" name="nowpage"      value="${ map.nowpage }" />
    <input type="hidden" name="pagecount"    value="${ map.pagecount }" />          
    <input type="hidden" name="pagegrpnum"   value="${ map.pagegrpnum }" />    --%>
    <!-- 자료실 pdsList -->   
    <table id="PdsView">
      <h2><b> 수정하기 </b></h2>
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
         <td  colspan="3">
           <input type="text" name="board_title" value="${ pdsVo.board_title }" />
         </td>
       </tr> 
       <tr>
         <td>내용</td>
         <td  colspan="3">
           <textarea name="board_cont">${ pdsVo.board_cont }</textarea>
         </td>
       </tr> 
       
       <tr>
         <td  colspan="4">
           <input type="submit" class="btn btn-primary" value="수정" />
           <input type="button" id="btnList" class="btn btn-warning" value="이전으로" onclick="location.href='javascript:history.back()';" />
         </td>
       </tr> 
       
    
    </table>
    
    </form>
    
    <div style="height: 300px;"></div>
  </div>
</body>
</html>








