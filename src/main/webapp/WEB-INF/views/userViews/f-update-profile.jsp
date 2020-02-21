<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!doctype html>
<html class="no-js" lang="zxx">

<head>
    <script>
    sessionStorage.getItem("memberSession");
    
    </script>
    
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Montana</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- <link rel="manifest" href="site.webmanifest"> -->
    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
    <!-- Place favicon.ico in the root directory -->

    <!-- CSS here -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/jquery.gpopover.css">
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

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/user/css/bootstrap.min.css">



    <!-- Include jQuery and the jquery.gpopover plugin -->
    <script src="js/vendor/jquery-1.12.4.min.js"></script>
    <script src="js/jquery.gpopover.js"></script>
    <script src="https://kit.fontawesome.com/7a424ad03a.js" crossorigin="anonymous"></script>

    <script>
        $(function () {


            // Use custom options for the right button
            $('#mypage-btn').gpopover({
                width: 360,
                preventHide: true,
                onShow: function () {
                    if (console && console.log) console.log("Popover shown.");
                },
                onHide: function () {
                    if (console && console.log) console.log("Popover hidden.");
                }
            });
        });
    </script>
</head>

<body>

    <hr>

    <div class="container">
        <div class="row">
            <div class="col-2">

            </div>
            <div class="col-6">

                <div class="col mt-5 ">
                    <form action="#">
                        <div class="mt-10">
                            <div class="h4">
                                프로필 변경 [프로필 설정]
                            </div>
                            <hr>
                        </div>

                        <div class="d-flex justify-content-start mt-5">
                            <div class="col-3 mr-4">프로필 사진</div>
                            <div class="col-10">
                                <div class="row">
                                    <div class="col-5 align-self-center">
                                        <label for="image">
                                            <input type="file" name="image" id="image" style="display:none;" />
                                            <div id="detail-mypage-profile-img" class="">
                                                <img class="profile" src="${pageContext.request.contextPath}/resources/user/img/test/2.jpg">
                                            </div>
                                        </label>
                                    </div>
                                    <div class="col align-self-center">
                                        <div>
                                            <a href="#" class="genric-btn success medium" style="width: 110px;">바꾸기</a>
                                        </div>
                                        <div class="mt-2">
                                            <a href="#" class="genric-btn success medium" style="width: 110px;">삭제</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <hr>

                        <div class="form-row">
                            <div class="col-md-4 mb-3">
                                <label for="validationDefault01">비밀번호</label>
                                <input type="password" class="form-control" id="password" name="password" required>
                            </div>
                        </div>
                             <div class="form-row">
                            <div class="col-md-4 mb-3">
                                <label for="validationDefault01">비밀번호 확인</label>
                                <input type="password" class="form-control" id="password-check" required>
                            </div>
                        </div>
                             <div class="form-row">
                            <div class="col-md-4 mb-3">
                                <label for="validationDefault01">연락처</label> 
                                <input type="text" class="form-control" id="phone" name="phone" required> <label for="exampleFormControlTextarea1" class="mr-1"> - 없이 입력해주세요</label>
                            </div>
                        </div>
            

                        <div class="form-row">
                            <div class="form-group mb-3 w-100">
                                <label for="exampleFormControlTextarea1" class="mr-1">소개</label>
                                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                            </div>
                        </div>

                        <hr>
                        <div class="form-inline pb-5 justify-content-center"
                        >
                            <div class="mt-10">
                                <a class="btn btn-registry-way-cancel d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                                    href="#">회원탈퇴</a>
                            </div>
                            <div class="mt-10">
                                <a class="btn btn-registry-way-cancel d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                                    href="#">취소</a>
                            </div>
                               <div class="mt-10">
                                <a class="btn btn-registry-way-cancel d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
                                    href="#">완료</a>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="col-2">

            </div>

        </div>

    </div>

    <jsp:include page="./include/i-footer.jsp"/>
    
    <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
    <jsp:include page="./include/i-body-js.jsp"></jsp:include>


</body>

</html>