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
	<section class="main-wrapper pt-xl-5 pb-5 ">
		<div class="main-content">

			<div class="d-flex justify-content-center">
				<h2></h2>
			</div>
			<div class="container">
				<div class="row">
					<div class="col"></div>
					<div class="col-10">
						<h3 class="mb-4"></h3>
						<form action="saveInputWritingProject.udo" id="tempStorageForm" method="POST" enctype="multipart/form-data">
					<!-- <form action="insertProject.udo" id="tempStorageForm" method="POST" enctype="multi/form-data"> -->
							<div class="row">
								<div class="col-3">
									<div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist"
										aria-orientation="vertical">
										<a class="nav-link active" id="register-tos-tab" data-toggle="pill"
											href="#register-tos" role="tab" aria-controls="register-tos"
											aria-selected="true">회원가입약관</a>
										<a class="nav-link" id="project-basic-tab" data-toggle="pill"
											href="#project-basic" role="tab" aria-controls="project-basic"
											aria-selected="true">이용약관</a>
										<a class="nav-link" id="v-pills-profile-tab" data-toggle="pill"
											href="#v-pills-profile" role="tab" aria-controls="v-pills-profile"
											aria-selected="false">개인정보처리방침</a>
											
										
									</div>
								</div>

								<div class="col-9">

									<div class="tab-content" id="v-pills-tabContent">
										<div class="tab-pane fade show active" id="register-tos" role="tabpanel"
											aria-labelledby="v-pills-profile-tab">
											<jsp:include page="./include/i-registerTos.jsp" />
										</div>
										<div class="tab-pane fade" id="project-basic" role="tabpanel"
											aria-labelledby="project-basic-tab">
											<jsp:include page="./include/i-tos.jsp" />
										</div>
										
										<div class="tab-pane fade" id="v-pills-profile" role="tabpanel"
											aria-labelledby="v-pills-profile-tab">
											<jsp:include page="./include/i-policy.jsp" />
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
	
	
	    <c:if test="${writingProject.writeStatus eq 'y'.charAt(0)  }">
	    	<script>
			  $(function() {
				    $("#inputCompleteBtn")
				      	.click(function() {
				    	})
				      	.prop("disabled", false);
				});
			  
			  $(function() {
				    $("#inputSaveBtn")
				      	.click(function() {
				    	})
				      	.prop("disabled", true);
				});
	    	</script>
	    	
	    	<script>
				$(document).on("change keyup", 'input:text', function(){
					  
					  $("#inputSaveBtn")
				    	.click(function() {
				  	})
				    	.prop("disabled", false);
					  
					  $(function() {
						    $("#inputCompleteBtn")
						      	.click(function() {
						    	})
						      	.prop("disabled", true);
						});
				
				});
			</script>
		</c:if>
	   	<c:if test="${	writingProject.writeStatus eq 'n'.charAt(0) || 
	   						writingProject.status eq 'w'.charAt(0) ||
	   						writingProject.status eq 'f'.charAt(0) ||
	   						writingProject.status eq 'p'.charAt(0) }">
	    	<script>
		   		$(function() {
	   			    $("#inputCompleteBtn").click(function() {
	   			   	})
	   			   	.prop("disabled", true);
		   		});
	    	</script>
	    </c:if>



</body>

</html>