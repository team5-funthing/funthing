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
    
    <!-- 회원가입 양식 start -->
    <div class="wrap">
        <div class="container">
            <div class="row">
                <div class="col">
                </div>
                <div class="col">
                    <div class="col align-self-center">
                        <form action="#">
                            <div class="mt-10">
                                <h2>회원가입</h2>
                            </div>
                            <div class="mt-10">
                                <h5>이름</h5>
                                <input type="text" name="name" placeholder="이름" onfocus="this.placeholder = ''"
                                    onblur="this.placeholder = '이름'" required class="single-input">
                            </div>
                            <div class="mt-10">
                                <h5>이메일 입력</h5>
                                <input type="email" name="email" placeholder="이메일 입력" onfocus="this.placeholder = ''"
                                    onblur="this.placeholder = '이메일 입력'" required class="single-input">
                            </div>
                            <div class="mt-10">
                                <input type="email" name="emailCheck" placeholder="이메일 입력를 다시 입력하세요"
                                    onfocus="this.placeholder = ''" onblur="this.placeholder = '이메일 입력를 다시 입력하세요'"
                                    required class="single-input">
                            </div>
                            <div class="mt-10">
                                <h5>비밀번호</h5>
                                <input type="password" name="password" placeholder="비밀번호를 입력하세요"
                                    onfocus="this.placeholder = ''" onblur="this.placeholder = '비밀번호를 입력하세요'" required
                                    class="single-input">
                            </div>
                            <div class="mt-10">
                                <input type="password" name="passwordCheck" placeholder="비밀번호를 입력하세요"
                                    onfocus="this.placeholder = ''" onblur="this.placeholder = '비밀번호를 입력하세요'" required
                                    class="single-input">
                            </div>
                            <div class="col-xl-12 mt-10">
                                <button type="submit" class="boxed-btn3"> 완료 </button>
                            </div>
                            <div class="mt-10">
                                <a class="btn btn-registry-way d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                                    href="registry-way-select-form.html">뒤로가기</a>
                            </div>
                            <hr>
                        </form>
                    </div>
                </div>
                <div class="col">
                </div>
            </div>
        </div>
    </div>
    <!-- 회원가입 폼 end -->


    <!-- footer -->
    <footer class="footer">
    </footer>
    
    <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
    <jsp:include page="./include/i-body-js.jsp"></jsp:include>
    
</body>

</html>