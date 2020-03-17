<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!doctype html>

<html class="no-js" lang="zxx">


<head>

	<jsp:include page="./include/i-head-setting.jsp"/>
	
</head>

<body>

    <jsp:include page="./include/i-popupover-mypage.jsp"/>
    <jsp:include page="./include/i-header.jsp"/>
    
    <!-- 비밀번호 찾기 폼 -->
    <div class="wrap">
        <div class="container">
            <div class="row">
                <div class="col">
                </div>
                <div class="col">
                    <div class="col align-self-center">
                        <form action="#">
                            <div class="h2 col align-self-center mt-10" style="color: black;">
                                비밀번호 찾기
                            </div>
                            <div class="mt-30">
                               <div class="h5" style="color: gray;">이메일 입력</div>
                               <input id="inputeamil" class="form-control form-control-lg" type="text" placeholder="이메일 입력"
                                    onfocus="this.placeholder = ''" onblur="this.placeholder = '이메일 입력'" required
                                    class="single-input">
                         			<a class="mt-10 btn btn-lg btn-block btn-spon-prj d-none d-lg-inline-block pr-5 pl-5 mb-2" href="javascript:certification()">
                         			 인증번호 보내기</a>

							   <input id="sessionCode" type="hidden" name="sessionCode" value="">
								     <!-- 자바 팝업창 띄우기 메서드. -->
								<script
									src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
							
							</div>
                            <div class="mt-30">
                                <div class="h5" style="color: gray;">인증번호 입력</div>
                                <input id="certification" class="form-control form-control-lg" type="text" placeholder="인증번호 입력"
                                    onfocus="this.placeholder = ''" onblur="this.placeholder = '인증번호 입력'" required
                                    class="single-input">
                                    
                                    
                            </div>
                            <hr>
                            <div class="col-xl-12 mt-10" id="hideBtn" style="display:none">
                                <a id="changepassword" class="btn btn-lg btn-block btn-registry-way d-none d-lg-inline-block mb-3"
                                    href="javascript:changePassword()" >확 인</a>
                                    
                                    
                                    <script>                                    
                                       /// 입력된 값과 세션에 저장된 인증값 비교해서 비밀번호 변경페이지 이동 처리.
                                       function changePassword(){    
                                    		var emailData = {
                                    				"email" : document.getElementById('inputeamil').value
                                    			};
                                    	if(document.getElementById('sessionCode').value == document.getElementById('certification').value && document.getElementById('sessionCode').value != null ){
                                    		$.ajax({
                                    			type : "POST",
                                    			url : "pwSuccess.udo",
                                    			data : emailData,
                                    			success : function(data) {
                                    				if(data=="1"){
                                                	alert("임의로 지정된 비밀번호를 메일로 보냈습니다. 마이페이지 - 회원정보 수정에서  비밀번호를 변경후 이용해 주세요");
                                    				document.getElementById("sessionCode").value = data;
                                    				}else{
                                    					alert("가입되지 않은 메일입니다.");
                                    				}
                                    			},
                                    			error : function() {
                                    				alert("연결에 문제가 있습니다. 인터넷 환경을 확인 후 다시 시도해 주세요.")
                                    			}
                                    		});                              		
                                    	}else{
                                    		document.getElementById('certification').value = "";
                                    		document.getElementById('certification').focus();
                                    		alert("인증번호가 틀렸습니다. 다시 입력해주세요.");                                    		
                                    	}
                                       } // changePassword() 종료                                        
                                    </script>
                                    </div>
                               <div class="col-xl-12 mt-10">
                                    
                                <a class="btn btn-lg btn-block btn-spon-prj d-none d-lg-inline-block pr-5 pl-5 mb-2"
                                    href="javascript: history.go(-1)">뒤로가기</a>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col">
                </div>
            </div>
        </div>
    </div>
<script>
function certification() {
	var emailData = {
		"email" : document.getElementById('inputeamil').value
	};
	$.ajax({
		type : "GET",
		url : "certification.udo",
		data : emailData,
		success : function(data) {
			alert("인증코드가 이메일로 발송되었습니다!");
			document.getElementById("sessionCode").value = data;
			document.getElementById("hideBtn").style.display = "block";
		},
		error : function() {
			alert("연결에 문제가 있습니다. 인터넷 환경을 확인 후 다시 시도해 주세요.")
		}
	});
}
</script>


    <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
    <jsp:include page="./include/i-body-js.jsp"></jsp:include>


</body>

</html>