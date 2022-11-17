<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(  function() { // 전국대학교정보 오픈 api 사용 
	   $('#btnOk').on('click', function() {
		   
		   var search = encodeURI($("#search").val()); // url 주소에 검색단어 붙이기위해 encodeURI 필요

		   $.ajax({
			   type: "GET",
			   url: "https:/www.career.go.kr/cnet/openapi/getOpenApi?apiKey=4f20107b691a986d99f3bf13359e47d8&svcType=api&svcCode=SCHOOL&contentType=json&gubun=univ_list&searchSchulNm="
					   + search, // api 주소 + 검색단어
			   dataType : 'json',
			   error : function(err) {
	                  console.log("실행중 오류가 발생하였습니다.");
	               },
			   success: function(data){
			     var plz = "";
			     const cnt = JSON.stringify(data.dataSearch.content.length); // data 갯수만큼 반복필요
			     for (var i = 0; i < cnt; i++) { // 데이터요청결과 파싱 --> 리스트 만들기
			    	 plz += '<br><a href=javascript:sendChildValue(' + JSON.stringify(data.dataSearch.content[i].schoolName) +')>'+ data.dataSearch.content[i].schoolName + '</a>';
			       }
			     $('#show').html( plz );
			   }
			 });
	   })
});

function sendChildValue(pick){ // 부모창에 데이터 넘겨주고 팝업창(자식창) 닫기
	
	opener.setChildValue(pick);
	window.close();

	}
</script>

<script language="javascript">
</script>
</head>
<body>
  <input type="text" id="search" >
  <button  id="btnOk">찾기</button>
      <p id="show"></p>    
</body>
</html>