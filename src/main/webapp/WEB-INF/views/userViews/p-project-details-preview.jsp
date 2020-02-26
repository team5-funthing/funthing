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
	<jsp:include page="./include/i-header-projectPreview.jsp" />


	<section class="container">

		<div class="w-100">
			<div class="row d-flex justify-content-center">
				<div class="row d-flex align-content-between flex-wrap mt-5">
					<div class="col-xl-12 d-flex bd-highlight mb-1">
						<ul id="addedKeywords">
							<c:set var="tag" value="#" />
							<c:set var="keywordId" value="keyword" />

							<c:choose>
								<c:when test="${previewProjectKeywordList eq null }">
								</c:when>
								<c:when test="${previewProjectKeywordList ne null }">
									<c:forEach var="previewProjectKeyword"
										items="${previewProjectKeywordList }" varStatus="step">
										<li id="${keywordId }${step.count}"
											class="btn-sm btn-bd-keyword d-none d-lg-inline-block m-1">
											<a href="javascript:void(0);" class="addedKeyword">${previewProjectKeyword.keyword }</a>
										</li>
									</c:forEach>
								</c:when>
							</c:choose>
						</ul>
						<script>
					         $(function (){
					        	 $(".addedKeyword").removeAttr("href")
					      
						     });
						</script>
					</div>
				</div>
			</div>

			<article class="row d-flex justify-content-center">


				<aside id="project-main-img" class="col-8">
				
					<c:if test="${previewProject ne null }">
						${previewProject.projectIntroduceVideo }"
					</c:if>
				</aside>
				
				<aside id="project-details-info"
					class="col-4 align-items-start d-flex flex-column bd-highlight">
					
					
					<div class="p-2 bd-highlight">
						<div class="h4">모인 금액</div>
						<div class="h2" style="color: #000000">
						
							<c:if test="${previewProject ne null }">
								${previewProject.fundingMoney }원
							</c:if> 
							<div class="h5" style="color: #000000">
								<c:if test="${previewProject ne null }">
									[퍼센트 수치]
								</c:if> 
							</div>
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
							href="showInsertwAskMessage.udo?projectNo=${vo.projectNo }">문의하기</a> <a
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
									<h3>${previewProject.projectSubTitle }</h3>
									<ul class="project-info-link mt-3 mb-4">
										<li><a href="#"><i class="fa fa-user"></i> ${previewProject.category }</a></li>
										<li><a href="#"><i class="fa fa-comments"></i> previewProjectsupporters
												후원한사람들</a></li>
									</ul>
									<c:if test="${previewProject ne null }">
										
										${previewProject.projectStory}
									
									</c:if> 
									
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
															<c:choose>
																<c:when
																	test="${ b1.email eq sessionScope.memberSessionEmail }">

																	<div class="reply-btn">
																		<a type="submit" href="getProjectBoard.udo?projectBoardNo=${b1.projectBoardNo }"
																			class="button button-contactForm btn_1 boxed-btn pt-1 pl-2 pr-2 pb-0">
																			수정 </a> 
																		<a type="submit" href="deleteProjectBoard.udo?projectBoardNo=${b1.projectBoardNo }"
																			class="button button-contactForm btn_1 boxed-btn pt-1 pl-2 pr-2 pb-0">
																			삭제 </a>

																	</div>

																</c:when>


																<c:when
																	test="${sessionScope.memberSessionEmail eq 'shn807@naver.com' }">

																		<div class="reply-btn">
																			<a type="submit" href="replyBoard.udo?projectBoardNo=${b1.projectBoardNo }"
																				class="button button-contactForm btn_1 boxed-btn pt-1 pl-3 pr-3 pb-1">
																				Reply </a>
																		</div>
																	</c:when>
															</c:choose>
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
							                                                       <c:if test="${ b2.email eq sessionScope.memberSessionEmail }">
							                                                       	<form action="getProjectBoardReply.udo" method="post">
																						<div class="reply-btn">
																							<input type="submit" 
																							class="button button-contactForm btn_1 boxed-btn pt-1 pl-2 pr-2 pb-0" value="수정">
																								 <input type="submit" formaction="deleteProjectBoardReply.udo"
																								class="button button-contactForm btn_1 boxed-btn pt-1 pl-2 pr-2 pb-0" value="삭제"> 
																								<input type="hidden" name="step" id="step" value="${b2.step}"> 
																								<input type="hidden" name="ref" id="ref" value="${b2.ref}">

																								</div>
																						</form>
																					</c:if>
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
		</div>
	</section>

	<!-- footer -->
	<footer class="footer"> </footer>

	<jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
	<jsp:include page="./include/i-body-js.jsp"></jsp:include>

</body>
</html>