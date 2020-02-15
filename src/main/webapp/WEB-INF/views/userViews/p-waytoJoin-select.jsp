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
    
    <div class="wrap">
        <div class="container">
            <div class="row">
                <div class="col">
                </div>
                <div class="col">
                    <form action="#">
                        <div class=" col align-self-center mt-10">
                            <h2>회원가입</h2>
                        </div>
                        <hr>
                        <div class="col-xl-12">
                            <a class="btn btn-registry-way d-none d-lg-inline-block p-4 mb-3 w-100"
                                href="emailJoin.udo">이메일로 가입하기</a>
                        </div>
                        <div class="d-flex align-self-center mt-10 w-100">
                            <div class="d-flex align-content-center">
                                <div class="h5">
                                    또는
                                </div>
                            </div>
                        </div>
                        <hr />
                        <div class="col-xl-12 mt-10">
                            <button type="submit" class="big-btn">네이버 아이디로 회원가입</button>
                        </div>
 <script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
						<!-- 네이버아이디로로그인 버튼 노출 영역 -->
						<div id="naver_id_login"></div>
						<!-- //네이버아이디로로그인 버튼 노출 영역 -->
						<script type="text/javascript">
							var naver_id_login = new naver_id_login(
									"bm_Jr_lzbfVgnsh6sEyX", "http://localhost:8080/funthing/naverjoin.udo");
							var state = naver_id_login.getUniqState();
							naver_id_login.setButton("green", 1, 69);
							naver_id_login.setDomain("http://localhost:8080/");
							naver_id_login.setState(state);
							naver_id_login.init_naver_id_login();
							
			
						</script>


						<div class="col-xl-12 mt-10">
                            <button type="submit" class="big-btn">카카오 아이디로 회원가입</button>
                        </div>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
			
							
						<a id="custom-login-btn2" href="javascript:loginWithKakao()"> <img
							src="${pageContext.request.contextPath}/resources/user/img/apiBtn/kakaoLoginBtn/kakao69.png"
							width="68" />
						</a>
				
						<script type='text/javascript'>
							
						    var id;
						    var name;
						    var email;
						    var url = 'http://localhost:8080/funthing/naverjoin.udo';
					
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
						<hr>
                    </form>
                    <div class="mt-10">
                        이미 회원가입을 하셨나요?
                        <p class="registry-p">
                            <a class="popup-with-form" href="#login-popup">로그인 하러가기</a>
                        </p>
                    </div>
                </div>
                <div class="col">
                </div>
            </div>
        </div>
    </div>
<<<<<<< HEAD
    <!-- 회원가입 폼 end -->


  
    <!-- 로그인 팝업페이지-->
    <form id="login-popup" class="white-popup-block mfp-hide" action="loginMember.udo" method="post">
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
                                <a href="#"><p>아이디|비밀번호 찾기</p></a>
                            </div>
                        </div>

                    </div>

                    <div class="col-xl-12 mt-10">
                        
                        <input type="submit" class="boxed-btn3" value="로그인하기 "> 
                    </div>

                    <hr/>

                    <div class="col-xl-12 mt-10 kakao_login_btn-wrapper">
                        <a class="kakao_login_btn" href="#">
                            <img class="landscape" src="${pageContext.request.contextPath}/resources/user/img/apiBtn/naverLoginBtn/네이버 아이디로 로그인_완성형_White.PNG"/>
                        </a>
                    </div>

                    <div class="col-xl-12 mt-10 kakao_login_btn-wrapper">
                        <a class="kakao_login_btn" href="#">
                            <img class="landscape" src="${pageContext.request.contextPath}/resources/user/img/apiBtn/kakaoLoginBtn/kakao_account_login_btn_large_wide.png"/>
                        </a>
                    </div>

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

    <!-- 검색 폼 -->
    <form id="search-popup" class="white-popup-block mfp-hide">
        <div class="popup_box ">
            <div class="popup_inner">
                <aside class="single_sidebar_widget search_widget">
                    <form action="#">
                        인기태그 : #내눈깔 #하늘vs정호 #직배송 #귱
                        <div class="form-group">
                            <div class="input-group mb-3">
                                <input type="text" class="form-control" placeholder='찾으시는 프로젝트가 있으신가요?'
                                    onfocus="this.placeholder = ''" onblur="this.placeholder = '검색어를 입력해 주세요.'">
                                <div class="input-group-append">
                                    <button class="btn" type="button"><i class="ti-search"></i></button>
                                </div>
                            </div>
                            <hr>
                            <div class="row">
                                <aside class="single_sidebar_widget post_category_widget">
                                    <h4 class="widget_title">인기 검색어</h4>
                                    <ul class="list cat-list">
                                        <li>
                                            <a href="#" class="d-flex">
                                                <p>Resaurant food</p>
                                                <p>(37)</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#" class="d-flex">
                                                <p>Travel news</p>
                                                <p>(10)</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#" class="d-flex">
                                                <p>Modern technology</p>
                                                <p>(03)</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#" class="d-flex">
                                                <p>Product</p>
                                                <p>(11)</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#" class="d-flex">
                                                <p>Inspiration</p>
                                                <p>(21)</p>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="#" class="d-flex">
                                                <p>Health Care</p>
                                                <p>(21)</p>
                                            </a>
                                        </li>
                                    </ul>
                                </aside>
                                <aside class="single_sidebar_widget tag_cloud_widget">
                                    <h4 class="widget_title">Tag Clouds</h4>
                                    <ul class="list">
                                        <li>
                                            <a href="#" class="genric-btn primary small tag-keyword">#여긴 어디</a>
                                        </li>
                                        <li>
                                            <a href="#" class="genric-btn info small tag-keyword">#여긴 어디</a>
                                        </li>
                                        <li>
                                            <a href="#" class="genric-btn primary small tag-keyword">#나는 누구</a>
                                        </li>
                                        <li>
                                            <a href="#" class="genric-btn info small tag-keyword">#여긴 어디</a>
                                        </li>
                                        <li>
                                            <a href="#" class="genric-btn primary small tag-keyword">#나는 어디</a>
                                        </li>
                                        <li>
                                            <a href="#" class="genric-btn primary small tag-keyword">#여긴 누구</a>
                                        </li>
                                    </ul>
                                </aside>
                            </div>
                        </div>
                    </form>
                </aside>
            </div>
        </div>
    </form>
    <!-- 검색폼 end -->

=======
>>>>>>> 193ce0181c850e546df0196c8f9f2b0411ccf7e0
    
    <!-- footer -->
    <footer class="footer">
    </footer>
    
    <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
    <jsp:include page="./include/i-body-js.jsp"></jsp:include>
</body>

</html>