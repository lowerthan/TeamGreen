<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" type="image/x-icon" href="/img/favicon.ico" />
<link rel="stylesheet" href="/css/signUpForm.css" />
<title>회원가입 화면</title>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
        function showPopup(){
            newWindow = window.open("/univSearch","학교검색 팝업창","width=400, height=300, top=10, left=10");
        }
        
        function setChildValue(pick){
        	console.log(pick);
            document.getElementById("univname").value = pick;

      }
	/*
	// 체크박스 다중체크 관련 소스 - 아직 미적용
	function clickBtn() {
    var chkArray = new Array();

    $("input[name='user_cate[]']:checked").each(function() { 
      var tmpVal = $(this).val(); 
      chkArray.push(tmpVal);
    });

    if( chkArray.length < 1 ){
      alert("값을 선택해주시기 바랍니다.");
      return;
    }

    console.log(chkArray);	// (2) ["A", "B"]
  	}
	*/
	
	
	
	// 아이디 중복체크 관련 소스 - ajax
	function checkId(){
        var id = $('#user_id').val(); //id값이 "id"인 입력란의 값을 저장
        $.ajax({
            url:'./idCheck', //Controller에서 요청 받을 주소
            type:'post', //POST 방식으로 전달
            data:{id:id},
            success:function(cnt){ //컨트롤러에서 넘어온 cnt값을 받는다 
                if(cnt == 0){ //cnt가 1이 아니면(=0일 경우) -> 사용 가능한 아이디 
                    $('.id_ok').css("display","inline-block"); 
                    $('.id_already').css("display", "none");
                    
                } else { // cnt가 1일 경우 -> 이미 존재하는 아이디
                    $('.id_already').css("display","inline-block");
                    $('.id_ok').css("display", "none");
                    alert("아이디를 다시 입력해주세요");
                    $('#user_id').val('');
                }
            },
            error:function(){
                alert("에러입니다");
            }
        });
        };
	
</script>

</head>
<body>
	
	<!-- USER_ID, USER_PW, USER_NAME, USER_CATE, UNIVNAME 
	
	onsubmit="DoJoinForm__submit(this); return false;" 밑에 joinForm 옆에 있던거-->
	<form action="/signUpProcess" method="POST" class="joinForm" >
                                                                                               
	<h2>소모임 + 에브리타임을 섞은 <br> 우리 사이트 회원가입을 환영합니다</h2>
		<div class="textForm">
		  <input name="user_id" type="text" class="user_id" id="user_id" placeholder="아이디">
		</div>
		<div class="textForm">
		  <input name="user_pw" type="password" class="user_pw" id="user_pw" placeholder="비밀번호">
		</div>
		<div class="textForm">
		  <input name="user_name" type="text" class="user_name" id="user_name"  placeholder="이름">
		</div>
		<div class="textForm">
			<label>관심사 (중복체크 가능)</label> <br><br>
			<label><input type="checkbox" name="user_cate[]" value="스포츠/운동" > 스포츠 / 운동</label> &nbsp;&nbsp;&nbsp;
			<label><input type="checkbox" name="user_cate[]" value="문화/공연" > 문화 / 공연</label><br> 
			<label><input type="checkbox" name="user_cate[]" value="게임/오락" > 게임 / 오락</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<label><input type="checkbox" name="user_cate[]" value="사교/인맥" > 사교 / 인맥</label><br>
			<label><input type="checkbox" name="user_cate[]" value="댄스/음악" > 댄스 / 음악</label> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<label><input type="checkbox" name="user_cate[]" value="요리/맛집" > 요리 / 맛집</label><br>
			<label><input type="checkbox" name="user_cate[]" value="여행/캠핑" > 여행 / 캠핑</label> &nbsp;&nbsp;&nbsp;
			<label><input type="checkbox" name="user_cate[]" value="반려동물/펫" > 반려동물 / 펫</label>
		</div>
		<div class="textForm">
		       <input type="text" id="univname" name="univname" readonly>
               <input type="button" value="학교검색" onclick="showPopup();">
		</div>
		<input type="submit" class="btn1" value="가입하기"/>
    </form>
	
</body>
</html>



