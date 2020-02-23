<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html class="no-js">

<head>

<jsp:include page="./include/i-head-setting.jsp" />

</head>

<body>

	<jsp:include page="./include/i-popupover-mypage.jsp" />
	<jsp:include page="./include/i-header.jsp" />


	<section class="container">

		<div class="w-100">
			<article class="row d-flex justify-content-center">
				<aside id="project-main-img" class="col-7">
					<img class="project-main" src="img/test/5.jpg"></a>
				</aside>
				<aside id="project-details-info"
					class="col-5 align-items-start d-flex flex-column bd-highlight">

					<div class="p-2 bd-highlight">
						<div class="h4">모인 금액</div>
						<div class="h2" style="color: #000000">
							500,000원[모인금액]
							<div class="h5" style="color: #000000">50% [달성율]</div>
						</div>
					</div>
					<div class="p-2 bd-highlight">
						<div class="h4">남은 날짜</div>
						<div class="h2" style="color: #000000">
							[날짜 들어오기]
							<div class="h5" style="color: #000000"></div>
						</div>
					</div>
					<div class="p-2 bd-highlight mt-auto ml-0">
						<a
							class="btn btn-lg btn-spon-prj d-none d-lg-inline-block pr-5 pl-5 mb-2"
							href="#">프로젝트 밀어주기</a>
					</div>
					<div class="row d-flex justify-content-around m-0 ">
						<a
							class="btn btn-sm btn-detail-prj-etc-btn d-none d-lg-inline-block p-3 m-1 mb-2"
							href="#">좋아요</a> <a
							class="btn btn-sm btn-detail-prj-etc-btn d-none d-lg-inline-block p-3 m-1 mb-2"
							href="#">문의하기</a> <a
							class="btn btn-sm btn-detail-prj-etc-btn d-none d-lg-inline-block p-3 m-1 mb-2"
							href="#">공유하기</a>

					</div>

				</aside>
			</article>

			<hr>

			<div class="w-75">

				<article>
					<div class="row">
						<div class="col-lg-10 posts-list">
							<div class="single-project-details">
								<div class="feature-img">
									<img class="img-fluid" src="#" alt="">
								</div>
								<div class="blog_details">
									<h2>여기에 상세 내용들 어떻게 올릴지 정해야한다.</h2>
									<ul class="project-info-link mt-3 mb-4">
										<li><a href="#"><i class="fa fa-user"></i> 카테고리</a></li>
										<li><a href="#"><i class="fa fa-comments"></i> 03
												리뷰/문의</a></li>
									</ul>
									<p class="excert">MCSE boot camps have its supporters and
										its detractors. Some people do not understand why you should
										have to spend money on boot camp when you can get the MCSE
										study materials yourself at a fraction of the camp price.
										However, who has the willpower</p>
									<p>MCSE boot camps have its supporters and its detractors.
										Some people do not understand why you should have to spend
										money on boot camp when you can get the MCSE study materials
										yourself at a fraction of the camp price. However, who has the
										willpower to actually sit through a self-imposed MCSE
										training. who has the willpower to actually</p>
									<div class="quote-wrapper">
										<div class="quotes">MCSE boot camps have its supporters
											and its detractors. Some people do not understand why you
											should have to spend money on boot camp when you can get the
											MCSE study materials yourself at a fraction of the camp
											price. However, who has the willpower to actually sit through
											a self-imposed MCSE training.</div>
									</div>
									<p>MCSE boot camps have its supporters and its detractors.
										Some people do not understand why you should have to spend
										money on boot camp when you can get the MCSE study materials
										yourself at a fraction of the camp price. However, who has the
										willpower</p>
									<p>MCSE boot camps have its supporters and its detractors.
										Some people do not understand why you should have to spend
										money on boot camp when you can get the MCSE study materials
										yourself at a fraction of the camp price. However, who has the
										willpower to actually sit through a self-imposed MCSE
										training. who has the willpower to actually</p>
								</div>
							</div>
							<div class="navigation-top">
								<div class="d-sm-flex justify-content-between text-center">
									<p class="like-info">
										<span class="align-middle"><i class="fa fa-heart"></i></span>
										Lily and 4 people like this
									</p>
									<div class="col-sm-4 text-center my-2 my-sm-0">
										<!-- <p class="comment-count"><span class="align-middle"><i class="fa fa-comment"></i></span> 06 Comments</p> -->
									</div>
									<ul class="social-icons row">
										<li class="mr-1"><a href="#"><i
												class="fa fa-facebook-f"></i></a></li>
										<li class="mr-1"><a href="#"><i class="fa fa-twitter"></i></a></li>
										<li class="mr-1"><a href="#"><i
												class="fa fa-dribbble"></i></a></li>
										<li class="mr-1"><a href="#"><i class="fa fa-behance"></i></a></li>
									</ul>
								</div>
								<div class="navigation-area">
									<div class="row">
										<div
											class="col-lg-6 col-md-6 col-12 nav-left flex-row d-flex justify-content-start align-items-centl-lg-6 col-md-6 col-12 nav-left flex-row d-flex justify-content-start align-items-center">
											<div class="thumb">
												<a href="#"> <img class="img-fluid"
													src="img/post/preview.png" alt="">
												</a>
											</div>
											<div class="arrow">
												<a href="#"> <span class="lnr text-white ti-arrow-left"></span>
												</a>
											</div>
											<div class="detials">
												<p>이전 프로젝트</p>
												<a href="#">
													<h4>[프로젝트 제목]</h4>
												</a>
											</div>
										</div>
										<div
											class="col-lg-6 col-md-6 col-12 nav-right flex-row d-flex justify-content-end align-items-center">
											<div class="detials">
												<p>다음 프로젝트</p>
												<a href="#">
													<h4>[프로젝트 제목]</h4>
												</a>
											</div>
											<div class="arrow">
												<a href="#"> <span class="lnr text-white ti-arrow-right"></span>
												</a>
											</div>
											<div class="thumb">
												<a href="#"> <img class="img-fluid"
													src="img/post/next.png" alt="">
												</a>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="project-author">
								<div class="media align-items-center">
									<img src="img/project/author.png" alt="">
									<div class="media-body">
										<a href="#">
											<h4></h4>
										</a>
										<p>Second divided from form fish beast made. Every of seas
											all gathered use saying you're, he our dominion twon Second
											divided from</p>
									</div>
								</div>
							</div>
							
							<!-- projectBoard form 시작 -->
							<div class="comment-form">
								<h4>리뷰 게시판 글 남기기</h4>
								
								<form class="form-contact comment_form" action="insertProjectBoard.udo" 
												id="commentForm" method="post">
									<div class="row">
										<div class="col-12">
											<div class="form-group">
												<textarea class="form-control w-100" name="projectBoardContents" 
													id="projectBoardContents" cols="30" rows="9"></textarea>
											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group">
												<input class="form-control" name="name" id="name" type="text" 
													value="${sessionScope.memberSessionName}">
											</div>
										</div>
										<div class="col-sm-6">
											<div class="form-group">
		                                    <input class="form-control" name="email" id="email" type="email" 
		                                       value="${sessionScope.memberSessionEmail}">
											</div>
										</div>
									</div>
									<div class="form-group">
										<button type="submit" 
											class="button button-contactForm btn_1 boxed-btn">글 남기기</button>
									</div>
								</form>
							</div>
							<!-- projectBoard form 끝 -->
							
							
							<!-- proejctBoardList 시작 -->
							<div class="comments-area">
								<h4>리뷰 게시판</h4>
								
								<!-- projectBoard 시작 -->
								<c:forEach var="b1" items="${getProjectBoard}">
									<c:if test="${b1.step eq 0}"> 
										
										<div class="comment-list">
											<div class="single-comment justify-content-between d-flex">
												<div class="user justify-content-between d-flex">
													<div class="thumb">
														<img src="${pageContext.request.contextPath}/resources/user/img/comment/comment_1.png" alt="">
													</div>
													<div class="desc" style="width: 600px;">
														<p class="comment">
															${b1.projectBoardContents}
														</p>
														<div class="d-flex justify-content-between">
															<div class="d-flex align-items-center">
																<h5>
																	<a href="#">${b1.member.name }</a>
																</h5>
																<p class="date">${b1.projectBoardDate}</p>
															</div>
															<div class="reply-btn">
					                                           <a type="submit" href="projectAskReply.html"
					                                              class="button button-contactForm btn_1 boxed-btn pt-1 pl-3 pr-3 pb-1">
					                                              Reply
					                                           </a>
															</div>
														</div>
														
														<!-- projectBoard Reply 시작 -->
														<c:forEach var="b2" items="${getProjectBoard}">
															<c:if test="${b1.ref eq b2.ref && b1.step ne b2.step}">
																<div class="d-flex justify-content-around mt-3">
							                                       <div class="d-flex align-items-center">
							                                          <div class="single-comment justify-content-between d-flex">
							                                             <div class="user justify-content-between d-flex p-3"
							                                                style="background-color: whitesmoke;">
							                                                <div class="thumb">
							                                                   <img src="${pageContext.request.contextPath}/resources/user/img/comment/comment_2.png" alt="">
							                                                </div>
							                                                <div class="desc" style="width: 500px;">
							                                                    <p class="comment">
							                                                   		${b2.projectBoardContents}
							                                                    </p>
							                                                    <div class="d-flex justify-content-between">
							                                                       <div class="d-flex align-items-center">
							                                                          <h5>
							                                                             <a href="#">${b2.member.name}</a>
							                                                          </h5>
							                                                          <p class="date">${b2.projectBoardDate}</p>
							                                                       </div>
							                                                       <div class="reply-btn">
							                                                       		<a type="submit" href="projectAskReply.html"
											                                               class="button button-contactForm btn_1 boxed-btn pt-1 pl-2 pr-2 pb-0">
											                                              	수정
											                                            </a>
											                                            <a type="submit" href="projectAskReply.html"
											                                               class="button button-contactForm btn_1 boxed-btn pt-1 pl-2 pr-2 pb-0">
											                                              	 삭제
											                                            </a>
											                                           
																				   </div>
							                                                    </div>
							                                                </div>
							                                             </div>
							                                          </div>
							                                       </div>
							                                       <div class="d-flex align-items-center">
							                                       </div>
							                                    </div>
							                            	</c:if>
					                                    </c:forEach>
														<!-- projectBoard Reply 끝 -->
														
													</div>
												</div>
											</div>
										</div>
										<!-- projectBoard 끝 -->
										
									</c:if>
								</c:forEach>
							</div>
							<!-- proejctBoardList 끝 -->
							
							
							
							
						</div>
						<!-- 프로젝트 디테일 페이지 스토리 및 게시글 끝 [왼쪽] -->

						<!-- 리워드 추가되는 부분 시작 -->
						<div class="col-2">
							<!-- 리워드 품목 들어가기 -->
							<div class="card mb-3" style="width: 18rem;">
								<div class="card-body">
									<h5 class="card-title">리워드 제목1 [마감임박]</h5>
									<h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
									<p class="card-text">Some quick example text to build on
										the card title and make up the bulk of the card's content.</p>
									<a href="#" class="card-link">선택하기</a>
								</div>
							</div>
							<!-- 품목 1개 end-->

							<div class="card" style="width: 18rem;">
								<div class="card-body">
									<h5 class="card-title">리워드 제목2 [마감] : 마감 시 비활성화</h5>
									<h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
									<p class="card-text">Some quick example text to build on
										the card title and make up the bulk of the card's content.</p>
									<a href="#" class="card-link">선택하기</a>
								</div>
							</div>
						</div>
						<!-- 리워드 반복 끝-->



					</div>
				</article>
			</div>
	</section>

	<!-- footer -->
	<footer class="footer"> </footer>

	<jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
	<jsp:include page="./include/i-body-js.jsp"></jsp:include>

</body>
</html>