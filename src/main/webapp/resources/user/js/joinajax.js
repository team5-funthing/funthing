
function joincheckajax() {
	
$('#email_check').blur(function() {
	alert("송의 스크립트 외부파일 실행 됐어!");
	var email = $('email_check').val();
	$.ajax({
		url : 'http://localhost:8080/funthing/emailjoin2.udo?id=?'+ email,
		type : 'get',
		success : function(data) {
			console.log("1 = 중복o / 0 = 중복x : "+ data);							
			
			if (data == 1) {
					// 1 : 아이디가 중복되는 문구
					$("#emailcheck").text("사용중인 아이디입니다 :p");
					$("#emailcheck").css("color", "red");
					$("#reg_submit").attr("disabled", true);
				} else {
					
//					if(idJ.test(user_id)){
//						// 0 : 아이디 길이 / 문자열 검사
						$("#emailcheck").text("");
						$("#reg_submit").attr("disabled", false);
//			
//					} else if(user_id == ""){
//						
//						$('#email_check').text('아이디를 입력해주세요 :)');
//						$('#email_check').css('color', 'red');
//						$("#reg_submit").attr("disabled", true);				
//						
					} //else {
//						
//						$('#email_check').text("아이디는 소문자와 숫자 4~12자리만 가능합니다 :) :)");
//						$('#email_check').css('color', 'red');
//						$("#reg_submit").attr("disabled", true);
//					}
					
//				}
			}, error : function() {
					console.log("실패");
			}
		}); 
	});
}
