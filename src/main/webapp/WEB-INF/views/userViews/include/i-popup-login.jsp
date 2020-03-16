<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
	<!-- 로그인 팝업페이지-->

    <form id="login-popup" class="white-popup-block mfp-hide" action="getMember.udo" method="post">
        <div class="popup_box">
            <div class="popup_inner">
                <h3>로그인</h3>
            		
                    <div class="mt-10">
	                    <c:if test="${not empty cookie.funthingCookieId.value }">
	                          <input name="email" id="email" class="form-control form-control-lg" type="text"
	                             placeholder="이메일 아이디" onfocus="this.placeholder = '이메일 아이디'"
	                             onblur="this.placeholder = '이메일 아이디'" value="${cookie.funthingCookieId.value }"
	                             class="single-input" required>
	
	                    </c:if>
	                    
	                    <c:if test="${ empty cookie.funthingCookieId.value }">
		                       <input name="email" id="email" class="form-control form-control-lg" type="text"
		                             placeholder="이메일 아이디" onfocus="this.placeholder = '이메일 아이디'"
		                             onblur="this.placeholder = '이메일 아이디'"
		                             class="single-input" required>
	                    </c:if>
                    </div>
                    <div class="mt-10">
	                    <c:if test="${not empty cookie.funthingCookiePw.value }">
	                       		<input name="password" id="password" class="form-control form-control-lg" type="password"
		                             placeholder="비밀번호를 입력하세요." onfocus="this.placeholder = '비밀번호를 입력하세요'"
		                             onblur="this.placeholder = '비밀번호를 입력하세요.'" value="${cookie.funthingCookiePw.value }"
		                             class="single-input" required>
	                    </c:if>
	                    <c:if test="${empty cookie.funthingCookiePw.value }">
                       		<input name="password" id="password" class="form-control form-control-lg" type="password"
	                             placeholder="비밀번호를 입력하세요." onfocus="this.placeholder = '비밀번호를 입력하세요'"
	                             onblur="this.placeholder = '비밀번호를 입력하세요.'"
	                             class="single-input" required>
		                </c:if>
                    </div>

                    <div class="mt-10">
                        <div class="row">
                            <div class="col-5">
                                <div class="switch-wrap d-flex justify-content-start ml-3">
                                    <div class="confirm-switch mr-1">
                                        <input type="checkbox" id="confirm-switch" name="confirm-switch" checked>
                                        <label for="confirm-switch"></label>
                                    </div>
                                    <p>아이디 기억하기</p>
                                </div>
                            </div>
                            <div class="col-2">

                            </div>
                            <div class="col-5">
                                <a href="findpw.udo"><p>비밀번호 찾기</p></a>
                            </div>
                        </div>

                    </div>
					<div id="loginProcessingResult">${loginFail}</div>
                    <div class="col-xl-12 mt-10">
                        <div class="mt-30 d-flex justify-content-center">
							<a href="javascript: return(0);" onclick="inputCheck()"
								class="deliveryOKBtn btn-lg btn-bd-purple d-none d-lg-inline-block m-1 popup-modal-dismiss pl-4 pr-4">
								로그인하기 </a>
						</div>
                    </div>

                    <hr/>
                    
                 	<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
				
                    <div id="naver_id_login"></div>
                    
					<script type="text/javascript">
						var naver_id_login = new naver_id_login(
								"T6JggIUb0xG2LBu9Q7Pf", "http://ec2-54-180-105-174.ap-northeast-2.compute.amazonaws.com/funthing/socialjoin.udo");
						var state = naver_id_login.getUniqState();		
						naver_id_login.setButton("green",3,60);
						naver_id_login.setDomain("http://ec2-54-180-105-174.ap-northeast-2.compute.amazonaws.com");
						naver_id_login.setState(state);
						naver_id_login.init_naver_id_login();
					</script> 
						
                    <div class="col-xl-12 kakao_login_btn-wrapper mt-3">
                        <a class="kakao_login_btn" href="javascript:loginWithKakao()">
                            <img class="landscape" src="${pageContext.request.contextPath}/resources/user/img/apiBtn/kakaoLoginBtn/kakao_account_login_btn_large_wide.png" 
                            style="height:55px;width:277.5px;"/>
                        </a>
                    </div>
                    
                    <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
					<script type='text/javascript'>
							
						    var id;
						    var name;
						    var email;
						    //var url = 'http://localhost:8080/funthing/socialjoin.udo';
						    var url = 'http://ec2-54-180-105-174.ap-northeast-2.compute.amazonaws.com/funthing/socialjoin.udo';
					
							// 사용할 앱의 JavaScript 키를 설정해 주세요.
							Kakao.init('05602e69457875d5bc6718b74ef34eb9');
							function loginWithKakao() {

								// 로그인 창을 띄웁니다.
								Kakao.Auth.login({
									success : function(json) {
										//alert(json.access_token);
										Kakao.API.request({
											url : '/v2/user/me',
											success : function(res) {
												//alert(JSON.stringify(res));
											
												 id = res.id;
												 name = res.properties.nickname;
												 email = res.kakao_account.email;
												 location.href=url+'?email='+email+'&password='+id+'&name='+name;
	
											},
											fail : function(error) {
												alert(JSON.stringify(error));
											}
										});

									},
									fail : function(err) {
										alert(JSON.stringify(err));
									}
								});
							};
							
							function inputCheck(){								
								var email = document.getElementById("email").value;
								var password = document.getElementById("password").value;
								
								console.log(email);
								console.log(password);
								
								if(email == ""){
									$("#loginProcessingResult").empty();
									$("#loginProcessingResult").append("아이디를 입력하세요").css('color','Tomato').css('font-size','75%');
									return;
								}else if(password == ""){
									$("#loginProcessingResult").empty();
									$("#loginProcessingResult").append("비밀번호를 입력하세요").css('color','Tomato').css('font-size','75%');
									return;
								}else{
									document.getElementById('login-popup').submit();
								}
							}
						</script>
                    <div class="mt-10">
                        	아직 회원이 아니신가요?
                        <p class="registry-p" style=" color: gray;" >
                            <a href="joinselect.udo" style=" color: gray;" class="line-button">FunThing 가입하기</a>
                        </p>
                    </div>
            </div>
        </div>
    </form>
    <!-- 로그인 end -->