<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>

<html class="no-js">


<head>
	<!-- jquery.js파일 있음 -->
	<jsp:include page="./include/i-head-setting.jsp" />

</head>

<body>
	
	<jsp:include page="./include/i-popupover-mypage.jsp"/>
    <jsp:include page="./include/i-header.jsp"/>
    
    <c:if test="${writingProject.projectNo ne -1 }">
    	<script>
    		alert("글 상태 : ${writingProject.writeStatus }  projectNo : ${writingProject.projectNo}");
    		
    	</script>
    </c:if>
    
	<section class="main-wrapper pt-xl-5 pb-5 ">
		<div class="main-content">

			<div class="d-flex justify-content-center">
				<h2>프로젝트 만들기</h2>
			</div>
			<div class="container">
				<div class="row">
					<div class="col"></div>
					<div class="col-10">
						<h3 class="mb-4">프로젝트 등록 폼</h3>
						<form action="saveInputWritingProject.udo" id="tempStorageForm" method="POST" enctype="multipart/form-data">
					<!-- <form action="insertProject.udo" id="tempStorageForm" method="POST" enctype="multi/form-data"> -->
							<input type="hidden" name="projectNo" value="${writingProject.projectNo }">
							<div class="row">
								<div class="col-3">
									<div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist"
										aria-orientation="vertical">
										<a class="nav-link active" id="project-basic-tab" data-toggle="pill"
											href="#project-basic" role="tab" aria-controls="project-basic"
											aria-selected="true">기본 설정</a>
										<a class="nav-link" id="v-pills-profile-tab" data-toggle="pill"
											href="#v-pills-profile" role="tab" aria-controls="v-pills-profile"
											aria-selected="false">프로젝트 소개</a>
										<a class="nav-link" id="v-pills-messages-tab" data-toggle="pill"
											href="#v-pills-messages" role="tab" aria-controls="v-pills-messages"
											aria-selected="false">스토리</a>
										<a class="nav-link" id="v-pills-settings-tab" data-toggle="pill"
											href="#v-pills-settings" role="tab" aria-controls="v-pills-settings"
											aria-selected="false">리워드 설계</a>
											
										<button type="submit" class="btn btn-secondary btn-lg btn-block mt-5">저장하기</button>
										<button id="inputCompleteBtn" class="btn btn-secondary btn-lg btn-block" >작성완료</button>
										<button type="submit" class="btn btn-secondary btn-lg btn-block mt-5" formaction="showPreviewProject.udo">미리보기</button>
									</div>
								</div>

								<div class="col-9">

									<div class="tab-content" id="v-pills-tabContent">
										<div class="tab-pane fade show active" id="project-basic" role="tabpanel"
											aria-labelledby="project-basic-tab">
											<jsp:include page="./include/i-f-create-project-basic.jsp" />
										</div>
										
										<div class="tab-pane fade" id="v-pills-profile" role="tabpanel"
											aria-labelledby="v-pills-profile-tab">
											<jsp:include page="./include/i-f-create-project-intro.jsp" />
										</div>
										<div class="tab-pane fade" id="v-pills-messages" role="tabpanel"
											aria-labelledby="v-pills-messages-tab">
											<jsp:include page="./include/i-f-create-project-story.jsp" />
										</div>
										<div class="tab-pane fade" id="v-pills-settings" role="tabpanel"
											aria-labelledby="v-pills-settings-tab">
											<jsp:include page="./include/i-f-create-project-reward.jsp" />
										</div>
									</div>
								</div>
							</div>
						</form>			
					</div>
					<div class="col"></div>
				</div>
			</div>
		</div>
	</section>
	
	<jsp:include page="./include/i-footer.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-addReward.jsp"></jsp:include>	
	<jsp:include page="./include/i-body-js.jsp"></jsp:include>
	<jsp:include page="./include/i-js-datePicker.jsp"></jsp:include>
	
	<c:choose>
	    <c:when test="${writingProject.writeStatus eq 'y'.charAt(0) }">
	    	<script>
			  $(function() {
				    $("#inputCompleteBtn")
				      	.click(function() {
				    	  	alert("작성완료 클릭!"); 
				    	})
				    	
				      	.prop("disabled", false);
				});
	    	</script>
	    </c:when>
	    	    <c:when test="${writingProject.writeStatus eq 'n'.charAt(0) }">
	    	<script>
		   		$(function() {
	   			    $("#inputCompleteBtn").click(function() {
	   			    	  	alert("작성완료 클릭!"); 
	   			   	})
	   			   	.prop("disabled", true);
		   		});
	    	</script>
	    </c:when>
    </c:choose>
    



</body>

</html>