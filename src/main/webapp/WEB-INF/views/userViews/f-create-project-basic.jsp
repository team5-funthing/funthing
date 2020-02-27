<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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


	<c:if test="${getProjectList ne null}">
	
	    <!-- 작성중인 프로젝트 존재할 경우 나오는 팝업 -->
	    <form action ="mypage.udo" method="GET" id="exist-writingProject-popup" class="white-popup-block mfp-hide" >
	        <div class="popup_box">
	            <div class="popup_inner">
					현재 작성 중인 프로젝트가 있습니다.
                    <p>작성 중인 프로젝트를 수정하거나 새로운 프로젝트를 시작할 수 있습니다.</p>
                    <div class="d-flex justify-content-around">
                        <a href="#" class="btn-lg btn-bd-purple d-none d-lg-inline-block m-1 popup-modal-dismiss">새로 만들기</a>
                        <a href="#" onclick="document.getElementById('exist-writingProject-popup').submit();" 
                        		class="btn-lg btn-bd-purple d-none d-lg-inline-block m-1">프로젝트 수정하기</a>
                    </div>
	            </div>
	        </div>
	    </form>
		
	</c:if>	
	
	<script>
		//프로젝트 시작 시 나오는 폼
		$(document).ready(function () {
			$.magnificPopup.open({
				 items: {
				     src: '#exist-writingProject-popup' 
				 },
				 type: 'inline',
				 preloader: false,
				 modal: true
				 
			});
			
			$(document).on('click', '.popup-modal-dismiss', function (e) {
				e.preventDefault();
				$.magnificPopup.close();
			});
		});	
	</script>



	<!-- footer -->
	<footer class="footer"> </footer>

	<jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
	<jsp:include page="./include/i-body-js.jsp"></jsp:include>

</body>
</html>