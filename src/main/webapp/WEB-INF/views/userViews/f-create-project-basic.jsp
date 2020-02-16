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
						<form action="insertProject.udo" id="inputProjectBasicSetting" method="post">
							<div class="h2 col align-self-center mt-10">프로젝트 기본 설정</div>
							<div class="mt-30">
								<h5>창작자 | 업체명 *</h5>
								<input name="creator" class="form-control form-control-lg" type="text"
									placeholder="창작자 또는 업체명을 입력하세요." onfocus="this.placeholder = ''"
									onblur="this.placeholder = '창작자 또는 업체명을 입력하세요.'" required
									class="single-input">
							</div>
							<div class="mt-30">
								<h5>이메일</h5>
								<input name="email" class="form-control form-control-lg" type="text"
									value="${basicProjectSetting.email }" class="single-input">
							</div>
							<hr>
							<div class="col-xl-12 mt-10">
								<a class="btn btn-lg btn-block btn-registry-way d-none d-lg-inline-block mb-3"
									href="#" onclick="document.getElementById('inputProjectBasicSetting').submit();">시작하기</a> 
								<a class="btn btn-lg btn-block btn-registry-way d-none d-lg-inline-block mb-3"
									href="#" >뒤로가기</a>
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
	<footer class="footer"> </footer>

	<jsp:include page="./include/i-popup-login.jsp"></jsp:include> -->
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include> -->
	<jsp:include page="./include/i-body-js.jsp"></jsp:include> -->

</body>
</html>