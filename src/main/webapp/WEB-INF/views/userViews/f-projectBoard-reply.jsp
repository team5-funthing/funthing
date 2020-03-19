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
    
    

	<section class="container pt-5">

		<div class="w-100">
			<div class="w-75">

				<article>
					<div class="col-lg-10 posts-list">

						<div class="comment-form pt-5">
							<h4>문의 답변하기</h4>
							<div class="comment-list p-5">
								<div class="single-comment justify-content-between d-flex">
									<div class="user justify-content-between d-flex">
										<div class="thumb mr-2">
											<img src="img/comment/comment_1.png" alt="">
										</div>
										<div class="desc">
											<p class="comment">${vo.projectBoardContents}</p>
											<div class="d-flex justify-content-between">
												<div class="d-flex align-items-center">
													<h5>
														<a href="javaScript: return(0);">${vo.email}</a>
													</h5>

													<p class="date">${vo.projectBoardDate}</p>
												</div>
											</div>
											<div class="d-flex justify-content-around mt-3"></div>
										</div>
									</div>
								</div>
							</div>

							<form class="form-contact comment_form"
								action="insertReplyProjectBoard.udo" id="commentForm"
								method="get">

								<div class="row d-flex align-items-center">
									<div class="col-sm-6">
										<div class="form-group">
											<input class="form-control" name="name" id="name" type="text"
												value="${sessionScope.memberSession.name }"
												placeholder="창작자명"> <input type="hidden" name="ref"
												value="${vo.projectBoardNo}">
												<input type="hidden" name="projectNo"
												value="${vo.projectNo}">
										</div>
									</div>
									<div class="col-sm-6">
										<div class="form-group">
											<input class="form-control" name="email" id="email"
												type="email" value="${sessionScope.memberSession.email }"
												placeholder="Email">
										</div>
									</div>
								</div>
								<div class="col-12">
									<div class="form-group">
										<textarea class="form-control w-100"
											name="projectBoardContents" cols="30" rows="9"
											placeholder="Write Comment"></textarea>
									</div>
								</div>
								<div class="form-group">
									<button type="submit"
										class="button button-contactForm btn_1 boxed-btn">
										작성하기</button>
									<button type="submit" formaction="projectDetails.udo"
										class="button button-contactForm btn_1 boxed-btn">
										취소하기</button>
								</div>
							</form>
						</div>
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