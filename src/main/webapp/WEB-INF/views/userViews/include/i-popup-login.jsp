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
                            <div class="col-6">
                                <div class="switch-wrap d-flex justify-content-start ml-3">
                                    <div class="confirm-switch mr-1">
                                        <input type="checkbox" id="confirm-switch" name="confirm-switch" checked>
                                        <label for="confirm-switch"></label>
                                    </div>
                                    <p>아이디 기억하기</p>
                                </div>
                            </div>
                            <div class="col-1">

                            </div>
                            <div class="col-5">
                                <a href="findpw.udo"><p>비밀번호 찾기</p></a>
                            </div>
                        </div>

                    </div>
					<div id="loginProcessingResult">${loginFail}</div>
                    <div class="mb-3">
                        <div class="mt-30 d-flex justify-content-center">
							<a href="javascript: return(0);" onclick="inputCheck()" style="width: 100px;"
								class="btn-lg btn-bd-purple d-none d-lg-inline-block m-1 popup-modal-dismiss pl-2 pr-2">
								로그인 </a>
								<a href="javascript: return(0);" style="width: 100px;"
								class="btn-lg btn-bd-purple d-none d-lg-inline-block m-1 popup-modal-dismiss pl-2 pr-2">
								취소 </a>
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
						naver_id_login.setDomain("http://ec2-54-180-105-174.ap-northeast-2.compute.amazonaws.com/funthing");
						naver_id_login.setState(state);
						naver_id_login.init_naver_id_login();
						
						var naver_id_login = new naver_id_login("bm_Jr_lzbfVgnsh6sEyX", "http://ec2-54-180-105-174.ap-northeast-2.compute.amazonaws.com/.udo");
						  //var naver_id_login = new naver_id_login("bm_Jr_lzbfVgnsh6sEyX", "http://localhost:8080/funthing/.udo");
						  // 접근 토큰 값 출력
						  // alert(naver_id_login.oauthParams.access_token);
						  // 네이버 사용자 프로필 조회
						  naver_id_login.get_naver_userprofile("naverSignInCallback()");
						  // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
						  function naverSignInCallback() {
							 
							 if(naver_id_login.getProfileData('email')!=null){
						    	var naverEmail = naver_id_login.getProfileData('email');
						    	document.getElementById("email2").value = naverEmail;
						   		var naverName = naver_id_login.getProfileData('name')
						    	document.getElementById("name").value = naverName;
						    	var naverId = naver_id_login.getProfileData('id');
						    	document.getElementById("password2").value = naverId;
							 }
							 
							 
							 var typedEmail = {"typedEmail":document.getElementById("email2").value};
							 
							  $.ajax({type:"GET",
							        url:"emailCheck.udo",
							        data:typedEmail,
							        success:function(data){   
							           if(data=='2'){
							        	   
							        	   var loginsubmit = document.createElement("form");
							        		var obj1;
							        		obj1 = document.createElement('input');
							        		obj1.setAttribute('type', 'hidden');
							        		obj1.setAttribute('name', 'name');
							        		obj1.setAttribute('value', naverName);
							        		loginsubmit.appendChild(obj1);
							        		
							        		var obj2;
							        		obj2 = document.createElement('input');
							        		obj2.setAttribute('type', 'hidden');
							        		obj2.setAttribute('name', 'email');
							        		obj2.setAttribute('value', naverEmail);
							        		loginsubmit.appendChild(obj2);
							        		
							        		var obj3;
							        		obj3 = document.createElement('input');
							        		obj3.setAttribute('type', 'hidden');
							        		obj3.setAttribute('name', 'password');
							        		obj3.setAttribute('value', naverId);
							        		loginsubmit.appendChild(obj3);
							        		
							        		loginsubmit.setAttribute('method', 'post');
							        		loginsubmit.setAttribute('action', "socialjoin.udo");

							        		document.body.appendChild(loginsubmit);
											
							        		loginsubmit.submit();

							           }else{
							              alert("가입되지 않은 이메일 입니다. 회원가입을 먼저 해 주세요.");
							           }
							        },error:function(){
							        	alert("서버와 통신이 실패했습니다. 인터넷상태를 다시 확인해주세요.");
							        }
							  		
							  	});  
							  }
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
												 location.href=url+'?email='+email+'&password='+id+'&name='+name+'&check=1';
	
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