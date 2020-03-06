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
						<form action="insertProject.udo" id="inputProjectBasicSetting" method="post" enctype="multipart/form-data">
							<div class="h2 col align-self-center mt-10">프로젝트 기본 설정</div>
							
							<c:choose>
								<c:when test="${empty getCreatorList}">
									
								</c:when>
								
								<c:when test="${not empty getCreatorList}">
								
									<div class="form-group">
									    <label for="existCreator"><h5>창작자 | 업체명 *</h5></label>
									    <select class="form-control" id="existCreator">
										    <c:forEach var="creatorList" items="${getCreatorList }">
												<option>${creatorList.creator }</option>
											</c:forEach>
									    </select>
									</div>
									
								</c:when>
								
							</c:choose>
							
							<div class="mt-30">
								<h5>창작자 | 업체명 *</h5>
								<input name="creator" class="form-control form-control-lg" type="text"
									placeholder="창작자 또는 업체명을 입력하세요." onfocus="this.placeholder = ''"
									onblur="this.placeholder = '창작자 또는 업체명을 입력하세요.'" 
									class="single-input" required>
							</div>
							<div class="mt-30">
								<h5>이메일</h5>
								<input name="email" class="form-control form-control-lg" type="text"
									value="${basicProjectSetting.email }" class="single-input">
							</div>
							
							<div class="mt-30">
								<h5>창작자 프로필 사진</h5>
								<div class="input-group mt-2 mb-3">
								    <div class="form-group">
								   		<label for="creatorProfile">프로필에 사용할 사진을 선택해주세요.</label>
								    	<input type="file" id="creatorProfile" name="creatorUploadImage" class="form-control-file">
								    </div>
									<div class="creator_select_img"><img src="" /></div>
								</div>
								<script>
					            	$("#creatorProfile").change(function(){
					            		if(this.files && this.files[0]){
					            			var reader = new FileReader;
					            			reader.onload = function(data){
					            				$(".creator_select_img img").attr("src", data.target.result).width(200);
					            			}
					            			reader.readAsDataURL(this.files[0]);
					            		}
					            	})
								</script>
							</div>
							<div class="mt-30">
								<h5>문의 전화번호*</h5>
								<input name="makerPhone" class="form-control form-control-lg" type="text"
									class="single-input" required>
							</div>
							<div class="mt-30">
								<h5>사업자번호</h5>
								<input name="businessNumber" class="form-control form-control-lg" type="text"
									class="single-input">
							</div>
							<div class="mt-30">
								<h5>소재지</h5>
								<input name="businessAddress" class="form-control form-control-lg" type="text"
									class="single-input">
							</div>					
							<div class="mt-30">
								<h5>통장 사본*</h5>
								<div class="input-group mt-2 mb-3">
								    <div class="form-group">
								   		<label for="creatorProfile">프로필에 사용할 사진을 선택해주세요.</label>
								    	<input type="file" id="businessUpload" name="businessUploadFile" class="form-control-file">
								    </div>
									<div class="business_select_img"><img src="" /></div>
								</div>
								<script>
					            	$("#businessUpload").change(function(){
					            		if(this.files && this.files[0]){
					            			var reader = new FileReader;
					            			reader.onload = function(data){
					            				$(".business_select_img img").attr("src", data.target.result).width(400);
					            			}
					            			reader.readAsDataURL(this.files[0]);
					            		}
					            	})
								</script>
							</div>								
							
							<hr>
							<div class="row mt-1 d-flex justify-content-center mb-5">
								<div class="col-xl-5">
									<a class="btn btn-lg btn-block btn-registry-way d-none d-lg-inline-block mb-3"
										href="javaScript:return(0);" onclick="document.getElementById('inputProjectBasicSetting').submit();">시작하기</a> 
								</div>
								<div class="col-xl-5"> 
									<a class="btn btn-lg btn-block btn-registry-way d-none d-lg-inline-block mb-3"
										href="javaScript:return(0);" >뒤로가기</a>
								</div>
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
                        <a href="#" onclick="document.getElementById('exist-writingProject-popup').submit();" class="btn-lg btn-bd-purple d-none d-lg-inline-block m-1">프로젝트 수정하기</a>
                    </div>
	            </div>
	        </div>
	    </form>
    
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
		
	</c:if>	
	
	



	<jsp:include page="./include/i-footer.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
	<jsp:include page="./include/i-body-js.jsp"></jsp:include>

</body>
</html>