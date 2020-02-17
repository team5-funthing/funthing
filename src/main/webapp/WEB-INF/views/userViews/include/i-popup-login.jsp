<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    
	<!-- 로그인 팝업페이지-->
    <form id="login-popup" class="white-popup-block mfp-hide" action="loginmember.udo" method="post">
        <div class="popup_box ">
            <div class="popup_inner">
                <h3>로그인</h3>
            
                    <div class="mt-10">
                        <input type="text" name="email" placeholder="이메일 아이디" onfocus="this.placeholder = ''"
                            onblur="this.placeholder = '이메일 아이디'" required class="single-input">
                    </div>
                    <div class="mt-10">
                        <input type="password" name="password" placeholder="비밀번호" onfocus="this.placeholder = ''"
                            onblur="this.placeholder = '비밀번호'" required class="single-input">
                    </div>

                    <div class="mt-10">
                        <div class="row">
                            <div class="col-5">
                                <div class="switch-wrap d-flex justify-content-start ml-3">
                                    <div class="confirm-switch mr-1">
                                        <input type="checkbox" id="confirm-switch" checked>
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

                    <div class="col-xl-12 mt-10">
                        
                        <input type="submit" class="boxed-btn3" value="로그인하기"> 
                    </div>

                    <hr/>

                    <div class="col-xl-12 mt-10 kakao_login_btn-wrapper" id="naver_id_login">
                        <%-- <a class="naver_login_btn" id="naver_id_login href="#">
                            <img class="landscape" src="${pageContext.request.contextPath}/resources/user/img/apiBtn/naverLoginBtn/네이버 아이디로 로그인_완성형_White.PNG"/>
                        </a> --%>
                    </div>
                 <script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
						<script type="text/javascript">
							var naver_id_login = new naver_id_login(
									"T6JggIUb0xG2LBu9Q7Pf", "http://localhost:8080/funthing/socialLogin.udo");
							var state = naver_id_login.getUniqState();		
							naver_id_login.setButton("green",3,60);
							naver_id_login.setDomain("http://localhost:8080/funthing");
							naver_id_login.setState(state);
							naver_id_login.init_naver_id_login();
						</script> 
						
                    <div class="col-xl-12 mt-10 kakao_login_btn-wrapper">
                        <a class="kakao_login_btn" href="javascript:loginWithKakao()">
                            <img class="landscape" src="${pageContext.request.contextPath}/resources/user/img/apiBtn/kakaoLoginBtn/kakao_account_login_btn_large_wide.png"/>
                        </a>
                    </div>
                    <script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
					<script type='text/javascript'>
							
						    var id;
						    var name;
						    var email;
						    var url = 'http://localhost:8080/funthing/socialjoin.udo';
					
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
						</script>
                    <div class="mt-10">
                        	아직 회원이 아니신가요?
                        <p class="registry-p">
                            <a href="joinselect.udo" class="line-button">FunThing 가입하기</a>
                        </p>
                    </div>
            </div>
        </div>
    </form>
    <!-- 로그인 end -->