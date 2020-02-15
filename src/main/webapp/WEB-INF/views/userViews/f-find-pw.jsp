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
                            <div class="h2 col align-self-center mt-10">
                                비밀번호 찾기
                            </div>
                            <div class="mt-30">
                                <h5>이메일 입력</h5>
                               <input id="inputeamil"  class="form-control form-control-lg" type="text" placeholder="이메일 입력"
                                    onfocus="this.placeholder = ''" onblur="this.placeholder = '이메일 입력'" required
                                    class="single-input">
                         
                                    <a class="btn btn-lg btn-block btn-registry-way d-none d-lg-inline-block mb-3"
                                    href="javascript:popup()">인증번호 보내기</a>

							
								<input id="sessionCode" type="hidden" value="<%=session.getAttribute("certificationCode")%>">
                                    <!-- 자바 팝업창 띄우기 메서드. -->
								<script
									src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
								<script>                              
                                     function popup(){                                      	
                                    	 var email = document.getElementById('inputeamil').value;	 
                                    	 window.open("certification.udo?email="+email,"인증번호가 발송되었습니다.","width=100,height=50");
                                     }                                  
                                    </script>
							</div>
                            <div class="mt-30">
                                <h5>인증번호 입력</h5>
                                <input id="certification" class="form-control form-control-lg" type="text" placeholder="인증번호 입력"
                                    onfocus="this.placeholder = ''" onblur="this.placeholder = '인증번호 입력'" required
                                    class="single-input">
                                    
                                    
                            </div>
                            <hr>
                            <div class="col-xl-12 mt-10">
                                <a id="changepassword" class="btn btn-lg btn-block btn-registry-way d-none d-lg-inline-block mb-3"
                                    href="javascript:changePassword()">확 인</a>
                                    
                                    
                                    <script>                                    
                                       /// 입력된 값과 세션에 저장된 인증값 비교해서 비밀번호 변경페이지 이동 처리.
                                       function changePassword(){    
                                    	if(document.getElementById('sessionCode').value == document.getElementById('certification').value){
                                    		alert("성공");
                                    		location.href = "#";                                    		
                                    	}else{
                                    		document.getElementById('certification').value = "";
                                    		document.getElementById('certification').focus();
                                    		alert("인증번호가 틀렸습니다. 다시 입력해주세요.");                                    		
                                    	}
                                       } // changePassword() 종료                                        
                                    </script>
                                <a class="btn btn-lg btn-block btn-registry-way d-none d-lg-inline-block mb-3"
                                    href="find-id-pw-form.html">뒤로가기</a>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col">
                </div>
            </div>
        </div>
    </div>

</body>

</html>