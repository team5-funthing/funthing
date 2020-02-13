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
                                <input class="form-control form-control-lg" type="text" placeholder="이메일 입력"
                                    onfocus="this.placeholder = ''" onblur="this.placeholder = '이메일 입력'" required
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

  	<!-- footer -->
    <footer class="footer">
    </footer>
    
    <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
    <jsp:include page="./include/i-body-js.jsp"></jsp:include>
</body>

</html>