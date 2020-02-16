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
    
    <!-- 회원가입 양식 start -->
    <div class="wrap">
        <div class="container">
            <div class="row">
                <div class="col">
                </div>
                <div class="col">
                    <div class="col align-self-center">
                        <form action="successjoin.udo" method="post">
                            <div class="mt-10">
                                <h2>회원가입</h2>
                            </div>
                            <div class="mt-10">
                                <h5>이름</h5>
                                <input type="text" name="name" placeholder="이름" onfocus="this.placeholder = ''"
                                    onblur="this.placeholder = '이름'" required class="single-input">
                            </div>
                            <div class="mt-10">
                                <h5>이메일 입력</h5>
                                <input type="email" id="email" name="email" placeholder="이메일 입력" onfocus="this.placeholder = ''"
                                    onblur="this.placeholder = '이메일 입력'" required class="single-input">
                            </div>
                            <div class="mt-10">
                             <a class="btn btn-lg btn-block btn-registry-way d-none d-lg-inline-block mb-3"
                                    href="javascript:popup()">인증번호 보내기</a>
                            
                                <input type="text" name="emailCheck" placeholder="인증번호를 입력하세요"
                                    onfocus="this.placeholder = ''" onblur="this.placeholder = '인증번호를 입력하세요'"
                                    required class="single-input">
                            </div>
                           
							<script
								src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
							<script>
								function popup() {
									var email = document.getElementById('email').value;
									window.open("certification.udo?email="
											+ email, "인증번호가 발송되었습니다.",
											"width=50,height=10");
								}
							</script>
							<input id="sessionCode" type="hidden" value="<%=session.getAttribute("certificationCode")%>">
                            <div class="mt-10">
                                <h5>비밀번호</h5>
                                <input type="password" name="password" placeholder="비밀번호를 입력하세요"
                                    onfocus="this.placeholder = ''" onblur="this.placeholder = '비밀번호를 입력하세요'" required
                                    class="single-input">
                            </div>
                            <div class="mt-10">
                                <input type="password" name="passwordCheck" placeholder="비밀번호를 입력하세요"
                                    onfocus="this.placeholder = ''" onblur="this.placeholder = '비밀번호를 입력하세요'" required
                                    class="single-input">
                            </div>
                            <div class="col-xl-12 mt-10">
                                <input type="submit" onclick="class="boxed-btn3" value="완료"> 
                            </div>
                            <div class="mt-10">
                                <a class="btn btn-registry-way d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                                    href="joinselect.udo">뒤로가기</a>
                            </div>
                            <hr>
                        </form>
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
                    </div>
                </div>
                <div class="col">
                </div>
            </div>
        </div>
    </div>
    <!-- 회원가입 폼 end -->
  
    <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
    <jsp:include page="./include/i-body-js.jsp"></jsp:include>
    
</body>

</html>