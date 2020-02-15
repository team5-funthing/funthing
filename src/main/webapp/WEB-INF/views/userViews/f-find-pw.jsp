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
                               <input id="inputeamil" name="inputemail" class="form-control form-control-lg" type="text" placeholder="이메일 입력"
                                    onfocus="this.placeholder = ''" onblur="this.placeholder = '이메일 입력'" required
                                    class="single-input">
                         
                                    <a class="btn btn-lg btn-block btn-registry-way d-none d-lg-inline-block mb-3"
                                    href="javascript:popup()">인증번호 보내기</a>
                                    
                    
                                    <!-- 자바 팝업창 띄우기 메서드. -->
								<script
									src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
								<script>
                                    
                                     function popup(){                                     	
                                    	 var email = $('#inputemail').val();
                                    	 alert(email);
                                    	// window.open("certification.udo?email="+email,"인증번호가 발송되었습니다.","width=100,height=50");
                                    	 
                                     }
                                  
                                    </script>
							</div>
                            <div class="mt-30">
                                <h5>인증번호 입력</h5>
                                <input class="form-control form-control-lg" type="text" placeholder="인증번호 입력"
                                    onfocus="this.placeholder = ''" onblur="this.placeholder = '인증번호 입력'" required
                                    class="single-input">
                            </div>
                            <hr>
                            <div class="col-xl-12 mt-10">
                                <a class="btn btn-lg btn-block btn-registry-way d-none d-lg-inline-block mb-3"
                                    href="#">확 인</a>
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

<<<<<<< HEAD
   
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



=======
  	<!-- footer -->
    <footer class="footer">
    </footer>
    
    <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
    <jsp:include page="./include/i-body-js.jsp"></jsp:include>
>>>>>>> 193ce0181c850e546df0196c8f9f2b0411ccf7e0
</body>

</html>