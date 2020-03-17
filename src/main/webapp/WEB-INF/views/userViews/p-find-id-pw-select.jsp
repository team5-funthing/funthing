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
    
    <!-- 아이디 비밀번호 찾기 폼 start -->
    <div class="wrap">
        <div class="container ">
            <div class="row ">
                <div class="col">
                </div>
                <div class="col align-self-center">
                    <form action="#">
                        <div class="h2 col align-self-center mt-10 pb-5">
                            아이디|비밀번호 찾기
                        </div>

                        <div class="col-xl-12 mt-10">
                            <a class="btn btn-lg btn-block btn-registry-way d-none d-lg-inline-block mb-3" 
                                href="#">아이디 찾기</a>
                            <a class="btn btn-lg btn-block btn-registry-way d-none d-lg-inline-block mb-3" 
                                href="#">비밀번호 찾기</a>
                        </div>
                        <hr>
                        <div class="col-xl-12 mt-10 p-5">
                            <a class="btn btn-lg btn-block btn-registry-way d-none d-lg-inline-block mb-3" 
                                href="#">메인으로 돌아가기</a>
                        </div>
                    </form>

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