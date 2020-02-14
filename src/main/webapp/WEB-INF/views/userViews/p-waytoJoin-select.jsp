<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="zxx">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Montana</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- <link rel="manifest" href="site.webmanifest"> -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
    <!-- Place favicon.ico in the root directory -->

    <!-- CSS here -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/owl.carousel.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/magnific-popup.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/themify-icons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/nice-select.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/flaticon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/gijgo.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/animate.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/slicknav.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/style.css">
    <!-- <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/responsive.css"> -->
</head>

<body>

    <!-- header-start -->
    <header>
        <div class="header-area ">
            <div id="sticky-header" class="main-header-area">
                <div class="container-fluid p-0">
                    <div id="sticky-header-align" class="row no-gutters">
                        <div class="col-xl-5 col-lg-6 ">
                            <div class="main-menu d-none d-lg-block align-items-center">
                                <nav>
                                    <ul id="navigation" class="d-flex mt-3">
                                        <li><a href="#">프로젝트 보기 <i class="ti-angle-down"></i></a>
                                            <ul class="submenu">
                                                <li><a href="show-projects.html">모든 프로젝트</a></li>
                                                <li><a href="#">리워드 프로젝트</a></li>
                                                <li><a href="#">후원 프로젝트</a></li>
                                                <hr />
                                                <li><a href="#">인기 프로젝트</a></li>
                                                <li><a href="#">마감임박 프로젝트</a></li>
                                                <li><a href="#">신규 프로젝트</a></li>
                                                <hr />
                                                <li><a href="#">기획전 보러가기</a></li>
                                            </ul>
                                        <li><a href="create-project-start.html">프로젝트 올리기</a></li>
                                        <li><a href="#">더 보기 <i class="ti-angle-down"></i></a>
                                            <ul class="submenu">
                                                <li><a href="#"></a></li>
                                                <li><a href="#">공지</a></li>
                                                <li><a href="#">알림</a></li>
                                                <li><a href="#">이벤트</a></li>
                                                
                                            </ul>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                        <div class="col-xl-2 col-lg-2 d-flex align-items-center justify-content-center">
                            <div class="logo-img ">
                                <a href="index.html">
                                    <h2 class="logo">FUN THING</h2>
                                </a>
                            </div>
                        </div>
                        <div class="col-xl-5 col-lg-4 d-none d-lg-block mb-3 mt-3">
                            <div class="nav_right">

                                <div class="search_icon ">
                                    <a class="popup-with-form" href="#search-popup"><span
                                            class="fa fa-search fa-2x pr-1"></span></a>
                                </div>

                                <div class="login_btn d-none d-lg-block pr-3">
                                    <a class="btn d-none d-lg-inline-block pl-3 pr-3 mb-3 mb-md-0 ml-md-3 popup-with-form" href="#login-popup">로그인 | 회원가입</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- header-end -->

    <!-- ================ contact section start ================= -->


    <!-- 회원가입 선택 폼 양식 start -->
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

    
    <!-- JS here -->
    <script src="${pageContext.request.contextPath}/resources/user/js/vendor/modernizr-3.5.0.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/vendor/jquery-1.12.4.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/popper.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/owl.carousel.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/isotope.pkgd.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/ajax-form.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/waypoints.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/jquery.counterup.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/imagesloaded.pkgd.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/scrollIt.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/jquery.scrollUp.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/wow.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/nice-select.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/jquery.slicknav.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/jquery.magnific-popup.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/plugins.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/gijgo.min.js"></script>

    <!--contact js-->
    <script src="${pageContext.request.contextPath}/resources/user/js/contact.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/jquery.ajaxchimp.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/jquery.form.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/jquery.validate.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/user/js/mail-script.js"></script>

    <script src="${pageContext.request.contextPath}/resources/user/js/main.js"></script>
    <script>
        $('#datepicker').datepicker({
            iconsLibrary: 'fontawesome',
            icons: {
                rightIcon: '<span class="fa fa-caret-down"></span>'
            }
        });
        $('#datepicker2').datepicker({
            iconsLibrary: 'fontawesome',
            icons: {
                rightIcon: '<span class="fa fa-caret-down"></span>'
            }

        });
    </script>



</body>

</html>