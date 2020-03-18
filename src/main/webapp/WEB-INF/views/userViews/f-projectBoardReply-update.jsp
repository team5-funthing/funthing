<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>

<html class="no-js">

<head>

	<jsp:include page="./include/i-head-setting.jsp"/>
  
</head>

<body>
  	
    <jsp:include page="./include/i-popupover-mypage.jsp"/>
    <jsp:include page="./include/i-header.jsp"/>

	<!-- ------------------ -->
	
	<!-- projectBoard form 시작 -->
		<section class="container p-5">

			<div class="w-100">
				<div class="w-75">
					<article>
						<div class="col-lg-10 posts-list pt-5">
							<div class="commentupdete-form p-5">
								<h4>리뷰 게시판 글 수정하기</h4>
								
								<form class="form-contact commentupdete-form" action="updateProjectBoardReply.udo" 
												id="commentForm" method="get">
									<div class="row">
										<div class="col-12">
											<div class="form-group">
												<textarea class="form-control w-100" name="projectBoardContents" 
													id="projectBoardContents" cols="30" rows="9" >${vo.projectBoardContents}</textarea>
											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<input class="form-control" name="name" id="name" type="text" 
													value="${sessionScope.memberSession.name}">
												<input type="hidden" name="step" id="step" value="${vo.step}">
												<input type="hidden" name="ref" id="ref" value="${vo.ref}">
												<input type="hidden" name="projectNo" id="projectNo" value="${vo.projectNo}">
											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group">
		                                    <input class="form-control" name="email" id="email" type="email" 
		                                       value="${sessionScope.memberSession.email}">
											</div>
										</div>
									</div>
									<div class="form-group">
										<button type="submit" 
											class="button button-contactForm btn_1 boxed-btn">답글 수정하기</button>
									</div>
								</form>
							</div>
						<!-- projectBoard form 끝 -->
						</div>
					</article>
				<hr>
			</div>
		</div>
	</section>
	
	<!-- -------------------- -->

    <!-- footer -->
    <footer class="footer">
    </footer>
    
    <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
    <jsp:include page="./include/i-body-js.jsp"></jsp:include>
    
</body>
</html>