<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자에게 문의하기</title>


<jsp:include page="./include/i-head-setting.jsp" />


</head>
<body>
	<jsp:include page="./include/i-popupover-mypage.jsp" />
	<jsp:include page="./include/i-header.jsp" />


	<section class="container">

		<div class="w-100">

			<div class="w-75">


				<form class="form-contact comment_form" action="#" id="askForm"
					method="post">

					<div class="h2">관리자에게 문의하기</div>
					<div class="comment-form pt-2"></div>

					<c:if test="${empty askForAdmin }">
					<h5>문의 제목</h5>
					<input type="text" name="csTitle"	id="csTitle"	 class="form-control"	placeholder="Title">
					<p class="comment h3"></p>
					</c:if>
					
					<c:if test="${not empty askForAdmin }">
					<h5>문의 제목</h5>
					<input type="text" name="csTitle"	id="csTitle"	 class="form-control" value="${askForAdmin.csTitle }"	placeholder="Title" readonly>
					<p class="comment h3"></p>
					</c:if>
					
					
					

					<c:if test="${empty sessionScope.memberSession.email }">
						<h5>
							작성자 아이디 <input type="text" id="email" name="email" value=""  class="form-control"
								placeholder="답변받을 email을 기재하세요">

						</h5>
					</c:if>
					<c:if test="${not empty sessionScope.memberSession.email }">
						<h5>작성자 아이디</h5>
						<input type="text" id="email" name="email"
							value="${sessionScope.memberSession.email }" disabled="disabled"  class="form-control">

					</c:if>

					<br>
					<div class="row">
						<div class="col-12">
							<h5>내용</h5>
							<div class="form-group">
							<c:if test="${empty askForAdmin }">
								<textarea class="form-control w-100" form="askForm"
									name="csContent" id="csContent" cols="30" 
									placeholder="문의사항에 대한 답변은  작성자의  Email로 발송해드리니, Email에서 확인 바랍니다."
									rows="9" ></textarea>
							</c:if>
							
							<c:if test="${not empty askForAdmin }">
								<textarea class="form-control w-100" form="askForm"
									name="csContent" id="csContent" cols="30"
									rows="9" placeholder="Write Comment"  disabled="disabled">${askForAdmin.csContent }</textarea>
							</c:if>
							</div>
						</div>
					</div>
					<div class="form-group">
					<c:if test="${empty askForAdmin }">
						<c:if test="${empty sessionScope.memberSession.email }">
							<input type="submit"
								class="button button-contactForm btn_1 boxed-btn" formaction="insertCSBoard.udo">작성하기</button>
						</c:if>
						<c:if test="${not empty sessionScope.memberSession.email }">
							<button type="submit"
								class="button button-contactForm btn_1 boxed-btn" formaction="insertCSBoard.udo">작성하기</button>
						</c:if>
					
					
						<button  formaction="projectDetails.udo"
							class="button button-contactForm btn_1 boxed-btn"
							onclick="cancel()">취소하기</button>
							
						</c:if>
						
						<c:if test="${not empty askForAdmin }">
								<button  formaction="projectDetails.udo"
							class="button button-contactForm btn_1 boxed-btn"
							onclick="back()">뒤로가기</button>
							
						</c:if>	
					</div>
				</form>
			</div>



			<hr>

		</div>

	</section>
	<script>
		function cancel() {
			history.go(-1);
		}
		
		function back(){
			location.href="showDetailMyPage.udo";
		}
	
	</script>


	<jsp:include page="./include/i-footer.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
	<jsp:include page="./include/i-body-js.jsp"></jsp:include>

</body>
</html>