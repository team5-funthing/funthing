<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

    
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
                            <a href="registry-way-select-form.html" class="line-button">FunThing 가입하기</a>
                        </p>
                    </div>
                </form>
            </div>
        </div>
    </form>
    <!-- 로그인 end -->