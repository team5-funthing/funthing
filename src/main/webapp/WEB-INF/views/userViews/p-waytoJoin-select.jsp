<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!doctype html>

<html class="no-js" lang="zxx">


<head>

	<jsp:include page="./include/i-head-setting.jsp"/>
	
</head>

<body>

    <jsp:include page="./include/i-popupover-mypage.jsp"/>
    <jsp:include page="./include/i-header-login.jsp"/>
    
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
                                href="registry-form.html">이메일로 가입하기</a>
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
                        <div class="col-xl-12 mt-10">
                            <button type="submit" class="big-btn">카카오 아이디로 회원가입</button>
                        </div>
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
    
    <!-- footer -->
    <footer class="footer">
    </footer>
    
    <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
    <jsp:include page="./include/i-body-js.jsp"></jsp:include>
</body>

</html>