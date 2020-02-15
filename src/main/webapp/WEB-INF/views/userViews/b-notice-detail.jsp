<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>

<html class="no-js" lang="zxx">

<head>
	<jsp:include page="./include/i-head-setting.jsp"/>
	
</head>

<body>

    <jsp:include page="./include/i-popupover-mypage.jsp"/>
    <jsp:include page="./include/i-header.jsp" />
	
    <hr>

    <section class="main-wrapper pt-xl-5 ">
        <article class="main-content">
            <div class="container">

                <div class="row">
                    <div class="col-10">
                        <div class="h3">${NoticeDetail.noticeTitle }</div>
                    </div>
                </div>
                <div class="row m-3">
                    <div class="d-flex justify-content-start mb-3">
                        <div id="detail-mypage-profile-img" style="background: #BDBDBD; width:80px; height:80px;">
                            <img class="profile" src="img/test/1.jpg" > <!-- 공지를 등록한 관리자 프로필 -->
                        </div>
                        <div class="d-flex align-items-end ml-2">
                            <div class="h6 login-id">
                                ${NoticeDetail.adminId} ${NoticeDetail.noticeDate}
                            </div>
                        </div>
                    </div>
                </div>

                <aside>
                    <div class="h4">${NoticeDetail.noticeContents }</div>

                </aside>



                <div class="d-flex justify-content-between p-5">
                    <div>
                        <a href="#"><i class="fas fa-thumbs-up fa-2x"></i></a>
                    </div>
                    <div class="row">
                        <a href="#"><i class="fas fa-comment fa-2x mr-2"></i></a>
                        <a href="#"><i class="fab fa-twitter fa-2x mr-2"></i></a>
                        <a href="#"><i class="fab fa-google-plus-g fa-2x mr-2"></i></a>
                    </div>
                </div>

            </div>
        </article>
    </section>

    
    <!-- footer -->
    <footer class="footer">
    </footer>
    
    <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
    <jsp:include page="./include/i-body-js.jsp"></jsp:include>
    
</body>

</html>