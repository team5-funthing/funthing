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
					</div>

					<div class="col-xl-2 col-lg-2 d-flex align-items-center justify-content-center">
						<div class="logo-img ">
							<a href="javaScript: return(0);"> <!-- 홈으로 가능 매핑 바꿔줘야함 -->
								<h2 class="logo">FUN THING</h2>
							</a>
						</div>
					</div >
						
					<div class="col-xl-5 col-lg-4 d-none d-lg-block mb-3 mt-3">
					    <div class="nav_right">
					        <div class="login_btn d-none d-lg-block pr-3">
					            <a class="btn d-none d-lg-inline-block pl-3 pr-3 mb-3 mb-md-0 ml-md-3 " 
					            	href="getWritingProject.udo?currentProjectNo=${previewProject.projectNo }">미리보기 나가기</a>
								
					        </div>
					    </div>
					</div>
        
				</div>
			</div>
		</div>
	</div>
</header>
<!-- header-end -->