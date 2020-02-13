<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js" lang="zxx">

<head>

<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Montana</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- <link rel="manifest" href="site.webmanifest"> -->
<link rel="shortcut icon" type="image/x-icon" href="img/favicon.png">
<!-- Place favicon.ico in the root directory -->

<!-- CSS here -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/user/css/jquery.gpopover.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/user/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/user/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/user/css/magnific-popup.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/user/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/user/css/themify-icons.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/user/css/nice-select.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/user/css/flaticon.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/user/css/gijgo.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/user/css/animate.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/user/css/slicknav.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/user/css/style.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/user/css/bootstrap.min.css">


<!-- Include jQuery and the jquery.gpopover plugin -->
<script
	src="${pageContext.request.contextPath}/resources/user/js/vendor/jquery-1.12.4.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/user/js/jquery.gpopover.js"></script>
<script src="https://kit.fontawesome.com/7a424ad03a.js"
	crossorigin="anonymous"></script>

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

	<!-- mypage code start -->
	<div id="popover-mypage-menu" class="gpopover">
		<div class="container">
			<div>
				<div>
					<div class="row d-flex justify-content-between ml-2 mr-2 mt-4 pb-4">
						<div id="profile-img" style="background: #BDBDBD;">
							<img class="profile" src="img/test/5.jpg">
						</div>
						<div class="h5 login-id align-self-center">닉네임</div>
					</div>
				</div>
				<div>
					<div class="d-flex justify-content-around bd-highlight">
						<div class="p-2 bd-highlight">
							<div class="d-flex flex-column bd-highlight ">
								<div class="p-2 bd-highlight">
									<div class="justify-content-center">
										<div class="p-2 bd-highlight">
											<i class="fas fa-shapes fa-3x"></i>
										</div>
										<div class="p-2 bd-highlight">
											<a href="show-filteredProjects.html">
												<div class="h6">창작한</div>
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="p-2 bd-highlight">
							<div class="d-flex flex-column bd-highlight ">
								<div class="p-2 bd-highlight">
									<div class="justify-content-center">
										<div class="p-2 bd-highlight">
											<i class="fas fa-hand-holding-usd fa-3x"></i>
										</div>
										<div class="p-2 bd-highlight">
											<a href="show-filteredProjects.html">
												<div class="h6">후원한</div>
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="p-2 bd-highlight">
							<div class="d-flex flex-column bd-highlight">
								<div class="p-2 bd-highlight">
									<div class="justify-content-center">
										<div class="p-2 bd-highlight">
											<i class="far fa-surprise fa-3x"></i>
										</div>
										<div class="p-2 bd-highlight">
											<a href="show-filteredProjects.html">
												<div class="h6">반응한</div>
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="p-2 bd-highlight">
							<div class="d-flex flex-column bd-highlight ">
								<div class="p-2 bd-highlight">
									<div class="justify-content-center">
										<div class="p-2 bd-highlight">
											<i class="fas fa-heart fa-3x"></i>
										</div>
										<div class="p-2 bd-highlight">
											<a href="show-filteredProjects.html">
												<div class="h6">좋아한</div>
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row align-items-end">
					<div class="list-group">
						<a href="#" class="list-group-item list-group-item-action active">
							<div class="d-flex w-100 justify-content-between">
								<h5 class="mb-1">보안 인증 하시면 좋데요</h5>
								<small>3 days ago</small>
							</div>
							<p class="mb-1">Donec id elit non mi porta gravida at eget
								metus. Maecenas sed diam eget risus varius blandit.</p> <small></small>
						</a>
					</div>
				</div>
				<div class="d-flex flex-column bd-highlight mb-3">
					<ul class="list-group list-group-flush">
						<li class="list-group-item"><a href="#">
								<div class="h6">마이페이지</div>
						</a></li>
						<li class="list-group-item"><a href="#">
								<div class="h6">후원 결제내역</div>
						</a></li>
						<li class="list-group-item"><a href="#">
								<div class="h6">수입내역</div>
						</a></li>
						<li class="list-group-item"><a href="#">
								<div class="h6">로그아웃 하기</div>
						</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- mypage code end -->

	<!-- header-start -->
	<header>
		<div class="header-area ">
			<div id="sticky-header" class="main-header-area">
				<div class="container-fluid p-0">
					<div id="sticky-header-align" class="row no-gutters">
						<div class="col-xl-5 col-lg-6 ">
							<div class="main-menu d-none d-lg-block align-items-center">
								<nav>
									<ul id="navigation" class="d-flex mt-3">
										<li><a href="#">프로젝트 보기 <i class="ti-angle-down"></i></a>
											<ul class="submenu">
												<li><a href="show-projects.html">모든 프로젝트</a></li>
												<li><a href="#">리워드 프로젝트</a></li>
												<li><a href="#">후원 프로젝트</a></li>
												<hr />
												<li><a href="#">인기 프로젝트</a></li>
												<li><a href="#">마감임박 프로젝트</a></li>
												<li><a href="#">신규 프로젝트</a></li>
												<hr />
												<li><a href="#">기획전 보러가기</a></li>
											</ul>
										<li><a href="create-project-start.html">프로젝트 올리기</a></li>
										<li><a href="#">더 보기 <i class="ti-angle-down"></i></a>
											<ul class="submenu">
												<li><a href="#"></a></li>
												<li><a href="#">공지</a></li>
												<li><a href="#">알림</a></li>
												<li><a href="#">이벤트</a></li>

											</ul></li>
									</ul>
								</nav>
							</div>
						</div>
						<div
							class="col-xl-2 col-lg-2 d-flex align-items-center justify-content-center">
							<div class="logo-img ">
								<a href="index.html">
									<h2 class="logo">FUN THING</h2>
								</a>
							</div>
						</div>
						<div class="col-xl-5 col-lg-4 d-none d-lg-block mb-3 mt-3">
							<div class="nav_right">

								<div class="search_icon ">
									<a class="popup-with-form" href="#search-popup"><span
										class="fa fa-search fa-2x pr-1"></span></a>
								</div>

								<div class="login_btn d-none d-lg-block pr-3">
									<a
										class="btn d-none d-lg-inline-block pl-3 pr-3 mb-3 mb-md-0 ml-md-3 popup-with-form"
										href="#login-popup">로그인 | 회원가입</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- header-end -->

	<hr>

	<section class="">

		<article class="d-flex justify-content-center">
			<div class="h2 p-5">공지 사항</div>
		</article>

		<article>

			<nav>

					<div class="nav nav-tabs d-flex justify-content-center"
						id="nav-tab" role="tablist">
						<a class="nav-item nav-link active" id="nav-notice-all-tab"
							data-toggle="tab" href="#nav-notice-all" role="tab"
							aria-controls="nav-notice-all" aria-selected="true">모든 소식</a> 
							<a class="nav-item nav-link" id="nav-notice-tab" data-toggle="tab"
							href="#nav-notice" role="tab" aria-controls="nav-notice"
							aria-selected="false">
							공지 | 알림</a> 
							<a class="nav-item nav-link" id="nav-event-tab" data-toggle="tab"
							href="#nav-event" role="tab" aria-controls="nav-event"
							aria-selected="false" >이벤트</a>
					</div>

			</nav>

		</article>

		<article>

			<div class="row p-4">
				<div class="col-3"></div>
				<div class="col-6">
					<div class="">

						<div class="tab-content" id="nav-tabContent">

							<div class="tab-pane fade show active" id="nav-notice-all"
								role="tabpanel" aria-labelledby="nav-notice-all-tab">
								<c:forEach var="list" items="${noticeList}">
									<div class="h4">
										<p>공지 알림 [뱃지 형식]</p>
										<a href="#">${list.noticeTitle }</a>
										<p>${list.adminId }</p>
										<p>${list.noticeDate }</p>
									</div>
									<hr>
								</c:forEach>
							</div>

							<div class="tab-pane fade" id="nav-notice" role="tabpanel"
								aria-labelledby="nav-notice-tab">

								<div class="tab-pane fade show active" id="nav-notice"
									role="tabpanel" aria-labelledby="nav-notice-tab">
									<c:forEach var="list" items="${noticeList}">
										<div class="h4">
											<p>공지 알림 [뱃지 형식]</p>
											<a href="#">${list.noticeTitle }</a>
											<p>${list.adminId }</p>
											<p>${list.noticeDate }</p>
										</div>
										<hr>
									</c:forEach>

								</div>

							</div>
							<div class="tab-pane fade" id="nav-event" role="tabpanel"
								aria-labelledby="nav-event-tab">

								<div class="tab-pane fade show active" id="nav-event"
									role="tabpanel" aria-labelledby="nav-event-tab">
									<c:forEach var="list" items="${noticeList}">
										<div class="h4">
											<p>공지 알림 [뱃지 형식]</p>
											<a href="#">${list.noticeTitle }</a>
											<p>${list.adminId }</p>
											<p>${list.noticeDate }</p>
										</div>
										<hr>
									</c:forEach>
								</div>
							</div>
							
						</div>
					</div>
				</div>
				<div class="col-3"></div>
			</div>


		</article>

		<article class="d-flex justify-content-center">
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
					</a></li>
					<li class="page-item"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next"> <span aria-hidden="true">&raquo;</span>
					</a></li>
				</ul>
			</nav>
		</article>

		<article class="d-flex justify-content-center">
			<form class="form-inline my-2 my-lg-0">
				<div class="form-group p-2">
					<label for="exampleFormControlSelect1"></label> <select
						class="form-control" id="exampleFormControlSelect1">
						<option>제목+내용</option>
						<option>제목</option>
						<option>내용</option>
					</select>
				</div>
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>
			</form>
		</article>

	</section>

	<!-- footer -->
	<footer class="footer"> </footer>

	<!-- 로그인 팝업페이지-->
	<form id="login-popup" class="white-popup-block mfp-hide">
		<div class="popup_box ">
			<div class="popup_inner">
				<h3>로그인</h3>
				<form action="#">
					<div class="mt-10">
						<input type="text" name="id" placeholder="이메일 아이디"
							onfocus="this.placeholder = ''"
							onblur="this.placeholder = '이메일 아이디'" required
							class="single-input">
					</div>
					<div class="mt-10">
						<input type="password" name="password" placeholder="비밀번호"
							onfocus="this.placeholder = ''"
							onblur="this.placeholder = '비밀번호'" required class="single-input">
					</div>




					<div class="mt-10">
						<div class="row">
							<div class="col-5">
								<div class="switch-wrap d-flex justify-content-start ml-3">
									<div class="confirm-switch mr-1">
										<input type="checkbox" id="confirm-switch" checked> <label
											for="confirm-switch"></label>
									</div>
									<p>아이디 기억하기</p>
								</div>
							</div>
							<div class="col-2"></div>
							<div class="col-5">
								<a href="#"><p>아이디|비밀번호 찾기</p></a>
							</div>



						</div>

					</div>

					<div class="col-xl-12 mt-10">

						<button type="submit" class="boxed-btn3">로그인하기</button>
					</div>

					<hr />

					<div class="col-xl-12 mt-10 kakao_login_btn-wrapper">
						<a class="kakao_login_btn" href="#"> <img class="landscape"
							src="img/apiBtn/naverLoginBtn/네이버 아이디로 로그인_완성형_White.PNG" />
						</a>
					</div>

					<div class="col-xl-12 mt-10 kakao_login_btn-wrapper">
						<a class="kakao_login_btn" href="#"> <img class="landscape"
							src="img/apiBtn/kakaoLoginBtn/kakao_account_login_btn_large_wide.png" />
						</a>
					</div>

					<div class="mt-10">
						아직 회원이 아니신가요?
						<p class="registry-p">
							<a href="registry-way-select-form.html" class="line-button">FunThing
								가입하기</a>
						</p>
					</div>
				</form>
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
								<input type="text" class="form-control"
									placeholder='찾으시는 프로젝트가 있으신가요?' onfocus="this.placeholder = ''"
									onblur="this.placeholder = '검색어를 입력해 주세요.'">
								<div class="input-group-append">
									<button class="btn" type="button">
										<i class="ti-search"></i>
									</button>
								</div>
							</div>
							<hr>
							<div class="row">
								<aside class="single_sidebar_widget post_category_widget">
									<h4 class="widget_title">인기 검색어</h4>
									<ul class="list cat-list">
										<li><a href="#" class="d-flex">
												<p>Resaurant food</p>
												<p>(37)</p>
										</a></li>
										<li><a href="#" class="d-flex">
												<p>Travel news</p>
												<p>(10)</p>
										</a></li>
										<li><a href="#" class="d-flex">
												<p>Modern technology</p>
												<p>(03)</p>
										</a></li>
										<li><a href="#" class="d-flex">
												<p>Product</p>
												<p>(11)</p>
										</a></li>
										<li><a href="#" class="d-flex">
												<p>Inspiration</p>
												<p>(21)</p>
										</a></li>
										<li><a href="#" class="d-flex">
												<p>Health Care</p>
												<p>(21)</p>
										</a></li>
									</ul>
								</aside>
								<aside class="single_sidebar_widget tag_cloud_widget">
									<h4 class="widget_title">Tag Clouds</h4>
									<ul class="list">
										<li><a href="#"
											class="genric-btn primary small tag-keyword">#여긴 어디</a></li>
										<li><a href="#" class="genric-btn info small tag-keyword">#여긴
												어디</a></li>
										<li><a href="#"
											class="genric-btn primary small tag-keyword">#나는 누구</a></li>
										<li><a href="#" class="genric-btn info small tag-keyword">#여긴
												어디</a></li>
										<li><a href="#"
											class="genric-btn primary small tag-keyword">#나는 어디</a></li>
										<li><a href="#"
											class="genric-btn primary small tag-keyword">#여긴 누구</a></li>
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
	<script
		src="${pageContext.request.contextPath}/resources/user/js/vendor/modernizr-3.5.0.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/user/js/popper.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/user/js/bootstrap.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/user/js/owl.carousel.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/user/js/isotope.pkgd.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/user/js/ajax-form.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/user/js/waypoints.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/user/js/jquery.counterup.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/user/js/imagesloaded.pkgd.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/user/js/scrollIt.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/user/js/jquery.scrollUp.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/user/js/wow.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/user/js/nice-select.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/user/js/jquery.slicknav.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/user/js/jquery.magnific-popup.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/user/js/plugins.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/user/js/gijgo.min.js"></script>

	<!--contact js-->
	<script
		src="${pageContext.request.contextPath}/resources/user/js/contact.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/user/js/jquery.ajaxchimp.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/user/js/jquery.form.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/user/js/jquery.validate.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/user/js/mail-script.js"></script>

	<script
		src="${pageContext.request.contextPath}/resources/user/js/main.js"></script>

</body>

</html>