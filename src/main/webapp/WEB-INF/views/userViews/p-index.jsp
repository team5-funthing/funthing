<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!doctype html>
<html class="no-js">

<head>

	<jsp:include page="./include/i-head-setting.jsp"/>

</head>

<body>

    <jsp:include page="./include/i-popupover-mypage.jsp"/>
    <jsp:include page="./include/i-header.jsp"/>
    
    <c:if test="${msg != null }">
    	<script>
    		alert("${msg }");
    	</script>
    </c:if>
    
    <!-- slider_area_start -->
    <div class="slider_area">
        <div class="slider_active owl-carousel">
            <div class="single_slider d-flex align-items-center justify-content-center slider_bg_1">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="slider_text text-center">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="single_slider  d-flex align-items-center justify-content-center slider_bg_2">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="slider_text text-center">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="single_slider d-flex align-items-center justify-content-center slider_bg_1">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="slider_text text-center">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="single_slider  d-flex align-items-center justify-content-center slider_bg_2">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="slider_text text-center">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- slider_area_end -->
    
    
    
        <!-- slider_area_start -->
    <div class="slider_area">
        <div class="slider_active owl-carousel">
        	
        <section class="tiles pt-0 mt-0">
    
                <!-- 올라온 프로젝트들 목록 표시-->
                <!-- 기본셋팅은 목록에는 진행중인 프로젝트 전체 목록 표시-->
                <!---------- 일반 펀딩 목록 보는 양식------ img class 에 가로가 긴 이미지면 landscape 세로가 길면 portrait -->
                <article>
    
                    <div class="project">
                        <div class="thumbnail-wrap">
                            <div class="thumbnail">
                                <div class="centered">
                                    <a href="projectDetails.udo"><img src="${pageContext.request.contextPath}/resources/user/img/test/8.jpg" class="card-img-top landscape" alt="1.jpg"></a>
                                </div>
                            </div>
                        </div>
                        <h5>프로젝트 제목</h5>
                        <ul>
                            <li>Luxaries condition</li>
                            <li>3 Adults & 2 Children size</li>
                            <li>Sea view side</li>
                        </ul>
                        <div class="mt-10">
                            <div class="percentage">
                                <p>2,352,000원 30% </p>
                                <div class="progress">
                                    <div class="progress-bar color-7" role="progressbar" style="width: 50%"
                                        aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </article>
                <!-- 추가적으로 목록들 생길 시 JSTL로 반복 추가-->
            </section>
            <section class="tiles pt-0 mt-0">
    
                <!-- 올라온 프로젝트들 목록 표시-->
                <!-- 기본셋팅은 목록에는 진행중인 프로젝트 전체 목록 표시-->
                <!---------- 일반 펀딩 목록 보는 양식------ img class 에 가로가 긴 이미지면 landscape 세로가 길면 portrait -->
                <article>
    
                    <div class="project">
                        <div class="thumbnail-wrap">
                            <div class="thumbnail">
                                <div class="centered">
                                    <a href="projectDetails.udo"><img src="${pageContext.request.contextPath}/resources/user/img/test/8.jpg" class="card-img-top landscape" alt="1.jpg"></a>
                                </div>
                            </div>
                        </div>
                        <h5>프로젝트 제목</h5>
                        <ul>
                            <li>Luxaries condition</li>
                            <li>3 Adults & 2 Children size</li>
                            <li>Sea view side</li>
                        </ul>
                        <div class="mt-10">
                            <div class="percentage">
                                <p>2,352,000원 30% </p>
                                <div class="progress">
                                    <div class="progress-bar color-7" role="progressbar" style="width: 50%"
                                        aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </article>
                <!-- 추가적으로 목록들 생길 시 JSTL로 반복 추가-->
            </section>
            <section class="tiles pt-0 mt-0">
    
                <!-- 올라온 프로젝트들 목록 표시-->
                <!-- 기본셋팅은 목록에는 진행중인 프로젝트 전체 목록 표시-->
                <!---------- 일반 펀딩 목록 보는 양식------ img class 에 가로가 긴 이미지면 landscape 세로가 길면 portrait -->
                <article>
    
                    <div class="project">
                        <div class="thumbnail-wrap">
                            <div class="thumbnail">
                                <div class="centered">
                                    <a href="projectDetails.udo"><img src="${pageContext.request.contextPath}/resources/user/img/test/8.jpg" class="card-img-top landscape" alt="1.jpg"></a>
                                </div>
                            </div>
                        </div>
                        <h5>프로젝트 제목</h5>
                        <ul>
                            <li>Luxaries condition</li>
                            <li>3 Adults & 2 Children size</li>
                            <li>Sea view side</li>
                        </ul>
                        <div class="mt-10">
                            <div class="percentage">
                                <p>2,352,000원 30% </p>
                                <div class="progress">
                                    <div class="progress-bar color-7" role="progressbar" style="width: 50%"
                                        aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </article>
                <!-- 추가적으로 목록들 생길 시 JSTL로 반복 추가-->
            </section>
            <section class="tiles pt-0 mt-0">
    
                <!-- 올라온 프로젝트들 목록 표시-->
                <!-- 기본셋팅은 목록에는 진행중인 프로젝트 전체 목록 표시-->
                <!---------- 일반 펀딩 목록 보는 양식------ img class 에 가로가 긴 이미지면 landscape 세로가 길면 portrait -->
                <article>
    
                    <div class="project">
                        <div class="thumbnail-wrap">
                            <div class="thumbnail">
                                <div class="centered">
                                    <a href="projectDetails.udo"><img src="${pageContext.request.contextPath}/resources/user/img/test/8.jpg" class="card-img-top landscape" alt="1.jpg"></a>
                                </div>
                            </div>
                        </div>
                        <h5>프로젝트 제목</h5>
                        <ul>
                            <li>Luxaries condition</li>
                            <li>3 Adults & 2 Children size</li>
                            <li>Sea view side</li>
                        </ul>
                        <div class="mt-10">
                            <div class="percentage">
                                <p>2,352,000원 30% </p>
                                <div class="progress">
                                    <div class="progress-bar color-7" role="progressbar" style="width: 50%"
                                        aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </article>
                <!-- 추가적으로 목록들 생길 시 JSTL로 반복 추가-->
            </section>
            <section class="tiles pt-0 mt-0">
    
                <!-- 올라온 프로젝트들 목록 표시-->
                <!-- 기본셋팅은 목록에는 진행중인 프로젝트 전체 목록 표시-->
                <!---------- 일반 펀딩 목록 보는 양식------ img class 에 가로가 긴 이미지면 landscape 세로가 길면 portrait -->
                <article>
    
                    <div class="project">
                        <div class="thumbnail-wrap">
                            <div class="thumbnail">
                                <div class="centered">
                                    <a href="projectDetails.udo"><img src="${pageContext.request.contextPath}/resources/user/img/test/8.jpg" class="card-img-top landscape" alt="1.jpg"></a>
                                </div>
                            </div>
                        </div>
                        <h5>프로젝트 제목</h5>
                        <ul>
                            <li>Luxaries condition</li>
                            <li>3 Adults & 2 Children size</li>
                            <li>Sea view side</li>
                        </ul>
                        <div class="mt-10">
                            <div class="percentage">
                                <p>2,352,000원 30% </p>
                                <div class="progress">
                                    <div class="progress-bar color-7" role="progressbar" style="width: 50%"
                                        aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </article>
                <!-- 추가적으로 목록들 생길 시 JSTL로 반복 추가-->
            </section>
            <section class="tiles pt-0 mt-0">
    
                <!-- 올라온 프로젝트들 목록 표시-->
                <!-- 기본셋팅은 목록에는 진행중인 프로젝트 전체 목록 표시-->
                <!---------- 일반 펀딩 목록 보는 양식------ img class 에 가로가 긴 이미지면 landscape 세로가 길면 portrait -->
                <article>
    
                    <div class="project">
                        <div class="thumbnail-wrap">
                            <div class="thumbnail">
                                <div class="centered">
                                    <a href="projectDetails.udo"><img src="${pageContext.request.contextPath}/resources/user/img/test/8.jpg" class="card-img-top landscape" alt="1.jpg"></a>
                                </div>
                            </div>
                        </div>
                        <h5>프로젝트 제목</h5>
                        <ul>
                            <li>Luxaries condition</li>
                            <li>3 Adults & 2 Children size</li>
                            <li>Sea view side</li>
                        </ul>
                        <div class="mt-10">
                            <div class="percentage">
                                <p>2,352,000원 30% </p>
                                <div class="progress">
                                    <div class="progress-bar color-7" role="progressbar" style="width: 50%"
                                        aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </article>
                <!-- 추가적으로 목록들 생길 시 JSTL로 반복 추가-->
            </section>
            <section class="tiles pt-0 mt-0">
    
                <!-- 올라온 프로젝트들 목록 표시-->
                <!-- 기본셋팅은 목록에는 진행중인 프로젝트 전체 목록 표시-->
                <!---------- 일반 펀딩 목록 보는 양식------ img class 에 가로가 긴 이미지면 landscape 세로가 길면 portrait -->
                <article>
    
                    <div class="project">
                        <div class="thumbnail-wrap">
                            <div class="thumbnail">
                                <div class="centered">
                                    <a href="projectDetails.udo"><img src="${pageContext.request.contextPath}/resources/user/img/test/8.jpg" class="card-img-top landscape" alt="1.jpg"></a>
                                </div>
                            </div>
                        </div>
                        <h5>프로젝트 제목</h5>
                        <ul>
                            <li>Luxaries condition</li>
                            <li>3 Adults & 2 Children size</li>
                            <li>Sea view side</li>
                        </ul>
                        <div class="mt-10">
                            <div class="percentage">
                                <p>2,352,000원 30% </p>
                                <div class="progress">
                                    <div class="progress-bar color-7" role="progressbar" style="width: 50%"
                                        aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </article>
                <!-- 추가적으로 목록들 생길 시 JSTL로 반복 추가-->
            </section>
        
            <div class="single_slider  d-flex align-items-center justify-content-center slider_bg_2">
                <div class="container">
                    <div class="row">
                        <div class="col-xl-12">
                            <div class="slider_text text-center">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
    </div>
    <!-- slider_area_end -->
    
    
    
    
    
    
    
    
    
    <section class="container">
        <div>
            <div class="h3 pt-5 d-flex justify-content-between">
                <a href="#">주목할 만한 프로젝트<i class="fas fa-chevron-right"></i></a>
                <div>
                    <i class="fas fa-chevron-left mr-5"></i>
                    <i class="fas fa-chevron-right mr-5"></i>
                </div>
            </div>
            <section class="tiles pt-0 mt-0">
    
                <!-- 올라온 프로젝트들 목록 표시-->
                <!-- 기본셋팅은 목록에는 진행중인 프로젝트 전체 목록 표시-->
                <!---------- 일반 펀딩 목록 보는 양식------ img class 에 가로가 긴 이미지면 landscape 세로가 길면 portrait -->
                <article>
    
                    <div class="project">
                        <div class="thumbnail-wrap">
                            <div class="thumbnail">
                                <div class="centered">
                                    <a href="projectDetails.udo"><img src="${pageContext.request.contextPath}/resources/user/img/test/8.jpg" class="card-img-top landscape" alt="1.jpg"></a>
                                </div>
                            </div>
                        </div>
                        <h5>프로젝트 제목</h5>
                        <ul>
                            <li>Luxaries condition</li>
                            <li>3 Adults & 2 Children size</li>
                            <li>Sea view side</li>
                        </ul>
                        <div class="mt-10">
                            <div class="percentage">
                                <p>2,352,000원 30% </p>
                                <div class="progress">
                                    <div class="progress-bar color-7" role="progressbar" style="width: 50%"
                                        aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </article>
                <!-- 추가적으로 목록들 생길 시 JSTL로 반복 추가-->
            </section>
            <hr>
        </div>

        <div>
            <div class="h3 pt-5 d-flex justify-content-between">
                <a href="#">진행중인 기획전 <i class="fas fa-chevron-right"></i></a>
                <div>
                    <i class="fas fa-chevron-left mr-5"></i>
                    <i class="fas fa-chevron-right mr-5"></i>
                </div>
            </div>
            <section class="tiles pt-0 mt-0">
    
                <!-- 올라온 프로젝트들 목록 표시-->
                <!-- 기본셋팅은 목록에는 진행중인 프로젝트 전체 목록 표시-->
                <!---------- 일반 펀딩 목록 보는 양식------ img class 에 가로가 긴 이미지면 landscape 세로가 길면 portrait -->
                <article>
    
                    <div class="project">
                        <div class="thumbnail-wrap">
                            <div class="thumbnail">
                                <div class="centered">
                                    <img src="${pageContext.request.contextPath}/resources/user/img/test/8.jpg" class="card-img-top landscape" alt="1.jpg">
                                </div>
                            </div>
                        </div>
                        <h5>프로젝트 제목</h5>
                        <ul>
                            <li>Luxaries condition</li>
                            <li>3 Adults & 2 Children size</li>
                            <li>Sea view side</li>
                        </ul>
                        <div class="mt-10">
                            <div class="percentage">
                                <p>2,352,000원 30% </p>
                                <div class="progress">
                                    <div class="progress-bar color-7" role="progressbar" style="width: 50%"
                                        aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </article>
                <!-- 추가적으로 목록들 생길 시 JSTL로 반복 추가-->
            </section>
            <hr>
        </div>

        <div>
            <div class="h3 pt-5 d-flex justify-content-between">
                <a href="#">인기 프로젝트 <i class="fas fa-chevron-right"></i></a>
                <div>
                    <i class="fas fa-chevron-left mr-5"></i>
                    <i class="fas fa-chevron-right mr-5"></i>
                </div>
            </div>
            <section class="tiles pt-0 mt-0">
    
                <!-- 올라온 프로젝트들 목록 표시-->
                <!-- 기본셋팅은 목록에는 진행중인 프로젝트 전체 목록 표시-->
                <!---------- 일반 펀딩 목록 보는 양식------ img class 에 가로가 긴 이미지면 landscape 세로가 길면 portrait -->
                <article>
    
                    <div class="project">
                        <div class="thumbnail-wrap">
                            <div class="thumbnail">
                                <div class="centered">
                                    <img src="${pageContext.request.contextPath}/resources/user/img/test/8.jpg" class="card-img-top landscape" alt="1.jpg">
                                </div>
                            </div>
                        </div>
                        <h5>프로젝트 제목</h5>
                        <ul>
                            <li>Luxaries condition</li>
                            <li>3 Adults & 2 Children size</li>
                            <li>Sea view side</li>
                        </ul>
                        <div class="mt-10">
                            <div class="percentage">
                                <p>2,352,000원 30% </p>
                                <div class="progress">
                                    <div class="progress-bar color-7" role="progressbar" style="width: 50%"
                                        aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </article>
                <!-- 추가적으로 목록들 생길 시 JSTL로 반복 추가-->
            </section>
            <hr>
        </div>

        <div>
            <div class="h3 pt-5 d-flex justify-content-between">
                <a href="#">성공 임박 프로젝트<i class="fas fa-chevron-right"></i></a>
                <div>
                    <i class="fas fa-chevron-left mr-5"></i>
                    <i class="fas fa-chevron-right mr-5"></i>
                </div>
            </div>
            <section class="tiles pt-0 mt-0">
    
                <!-- 올라온 프로젝트들 목록 표시-->
                <!-- 기본셋팅은 목록에는 진행중인 프로젝트 전체 목록 표시-->
                <!---------- 일반 펀딩 목록 보는 양식------ img class 에 가로가 긴 이미지면 landscape 세로가 길면 portrait -->
                <article>
    
                    <div class="project">
                        <div class="thumbnail-wrap">
                            <div class="thumbnail">
                                <div class="centered">
                                    <img src="${pageContext.request.contextPath}/resources/user/img/test/8.jpg" class="card-img-top landscape" alt="1.jpg">
                                </div>
                            </div>
                        </div>
                        <h5>프로젝트 제목</h5>
                        <ul>
                            <li>Luxaries condition</li>
                            <li>3 Adults & 2 Children size</li>
                            <li>Sea view side</li>
                        </ul>
                        <div class="mt-10">
                            <div class="percentage">
                                <p>2,352,000원 30% </p>
                                <div class="progress">
                                    <div class="progress-bar color-7" role="progressbar" style="width: 50%"
                                        aria-valuenow="30" aria-valuemin="0" aria-valuemax="100"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </article>
                <!-- 추가적으로 목록들 생길 시 JSTL로 반복 추가-->
            </section>
            <hr>
        </div>
    </section>

    <jsp:include page="./include/i-footer.jsp"/>
   
    
    <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
    <jsp:include page="./include/i-body-js.jsp"></jsp:include>


</body>

</html>