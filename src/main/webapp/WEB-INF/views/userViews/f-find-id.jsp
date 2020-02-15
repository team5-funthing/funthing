<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!doctype html>

<html class="no-js" lang="zxx">


<head>

	<jsp:include page="./include/i-head-setting.jsp"/>
	
</head>

<body>

<<<<<<< HEAD
   <div class="mt-30">  
   <script>
   function getParam(sname) {
	    var params = location.search.substr(location.search.indexOf("?") + 1);
	    var sval = "";
	    params = params.split("&");
	    for (var i = 0; i < params.length; i++) {
	        temp = params[i].split("=");
	        if ([temp[0]] == sname) { sval = temp[1]; }
	    }
	    return sval;
	} 
   alert(getParam('email'));
   self.close();

   
   </script>      
    </div>
 
 
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
    <jsp:include page="./include/i-popupover-mypage.jsp"/>
    <jsp:include page="./include/i-header.jsp"/>
    
    <!-- 아이디 찾기 폼 -->
    <div class="wrap">
        <div class="container">
            <div class="row">
                <div class="col">
                </div>
                <div class="col">
                    <div class="col align-self-center">
                        <form action="#">
                            <div class="h2 col align-self-center mt-10">
                               	 아이디 찾기
                            </div>
                            <div class="mt-30">
                                <h5>이메일 입력</h5>
                                <input class="form-control form-control-lg" type="text" placeholder="이메일 입력"onfocus="this.placeholder = ''"
                                onblur="this.placeholder = '이메일 입력'" required class="single-input">
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
    <!-- 아이디 찾기 폼 end -->

    <!-- 로그인 팝업페이지-->
    <form id="login-popup" class="white-popup-block mfp-hide">
        <div class="popup_box ">
            <div class="popup_inner">
                <h3>로그인</h3>
                <form action="#">
                    <div class="mt-10">
                        <input type="text" name="id" placeholder="이메일 아이디" onfocus="this.placeholder = ''"
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
                        
                        <button type="submit" class="boxed-btn3"> 로그인하기 </button>
                    </div>

                    <hr/>

                    <div class="col-xl-12 mt-10 kakao_login_btn-wrapper">
                        <a class="kakao_login_btn" href="#">
                            <img class="landscape" src="img/apiBtn/naverLoginBtn/네이버 아이디로 로그인_완성형_White.PNG"/>
                        </a>
                    </div>

                    <div class="col-xl-12 mt-10 kakao_login_btn-wrapper">
                        <a class="kakao_login_btn" href="#">
                            <img class="landscape" src="img/apiBtn/kakaoLoginBtn/kakao_account_login_btn_large_wide.png"/>
                        </a>
                    </div>

                    <div class="mt-10">
                        아직 회원이 아니신가요?
                        <p class="registry-p">
                            <a href="registry-way-select-form.html" class="line-button">FunThing 가입하기</a>
                        </p>
                    </div>
                </form>
            </div>
        </div>
    </form>
    <!-- 로그인 end -->
    

    <!-- footer -->
    <footer class="footer">
    </footer>
    
    <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
    <jsp:include page="./include/i-body-js.jsp"></jsp:include>
>>>>>>> 193ce0181c850e546df0196c8f9f2b0411ccf7e0


</body>

</html>