<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- header-start -->
<header>
	<div class="header-area">
		<div id="sticky-header" class="main-header-area">
			<div class="container-fluid p-0">
				<div id="sticky-header-align" class="row no-gutters">

					<div class="col-xl-5 col-lg-6 ">
						<div class="main-menu d-none d-lg-block align-items-center">
							<nav>
								<ul id="navigation" class="d-flex mt-3">
									<li><a href="javaScript: return(0);">프로젝트 보기 <i class="ti-angle-down"></i></a>
										<ul class="submenu">
											<li><a href="getAllFundingProjectList.udo">모든 프로젝트</a></li>
											<li><a href="#">리워드 프로젝트</a></li>
											<li><a href="#">후원 프로젝트</a></li>
											<hr>
											<li><a href="#">인기 프로젝트</a></li>
											<li><a href="#">마감임박 프로젝트</a></li>
											<li><a href="#">신규 프로젝트</a></li>
											<hr>
											<li><a href="#">기획전 보러가기</a></li>
										</ul>
									<li><a href="showStartProjectPage.udo">프로젝트 올리기</a></li>
									<li><a href="#">더 보기 <i class="ti-angle-down"></i></a>
										<ul class="submenu">
											<li><a href="#"></a></li>
											<li><a href="selectEntireNoticeList.udo">공지</a></li>
											<li><a href="#">알림</a></li>
											<li><a href="#">이벤트</a></li>
										</ul>
									</li>
								</ul>
							</nav>
						</div>
					</div>

					<div class="col-xl-2 col-lg-2 d-flex align-items-center justify-content-center">
						<div class="logo-img ">
							<a href="index.udo"> <!-- 홈으로 가능 매핑 바꿔줘야함 -->
								<h2 class="logo">FUN THING</h2>
							</a>
						</div>
					</div >
						
					<c:if test="${!empty sessionScope.memberSession.email }">
						<jsp:include page="./i-header-nav-right-login-ok.jsp"/>
					</c:if>
					<c:if test="${empty sessionScope.memberSession.email }">
						<jsp:include page="./i-header-nav-right-login-no.jsp"/>
					</c:if>
        
				</div>
			</div>
		</div>
	</div>
</header>
<!-- header-end -->