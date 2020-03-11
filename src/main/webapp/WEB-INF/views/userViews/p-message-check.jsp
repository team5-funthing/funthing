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



	<section class="main-wrapper pt-xl-5 ">

		<div class="main-content">
			<div class="container">

				<div class="row">
					<div class="col"></div>
					<div class="col-10">
					
						<div class="d-flex justify-content-start mb-3">
							<h3>메시지 확인</h3>
						</div>

						<div class="d-flex justify-content-start">
							<nav>
								<div class="nav nav-tabs" id="nav-tab" role="tablist">
									<a class="nav-item nav-link active"	id="nav-created-prj-questions-tab" data-toggle="tab" href="#nav-created-prj-questions"
									 role="tab"	aria-controls="nav-created-prj-questions" aria-selected="true">내가 만든프로젝트 문의내역</a> 
									 
									<a class="nav-item nav-link" id="nav-sponsored-prj-questions-tab" data-toggle="tab" href="#nav-sponsored-prj-questions" role="tab"
										aria-controls="nav-sponsored-prj-questions" aria-selected="false">내가 보낸 문의내역</a>
										
									<a class="nav-item nav-link" id="nav-askadmin-tab" data-toggle="tab" href="#nav-askadmin" role="tab"
										aria-controls="nav-askadmin" aria-selected="false">관리자에게 문의하기</a>
								</div>
							</nav>
						</div>

						<br>
						<!-- 만든프로젝트 탭  -->
						<div class="tab-content" id="nav-check-msg-tab">
							<div class="tab-pane fade show active"
								id="nav-created-prj-questions" role="tabpanel"
								aria-labelledby="nav-created-prj-questions-tab">
								<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
									<li class="nav-item">
										
										<c:choose>
											<c:when test="${vo2.creator ne null && empty messagelist}">
													<div class="row">
													<div class="col"></div>
													<div class="col-8 d-flex justify-content-center ">
														<div class="pt-5 pb-5 ">
															<div>
																<svg xmlns="http://www.w3.org/2000/svg" width="60"
																	height="60" viewBox="0 0 24 24" fill="none"
																	stroke="currentColor" stroke-width="1.5"
																	stroke-linecap="round" stroke-linejoin="round"
																	class="feather feather-mail">
																				<path
																		d="M4 4h16c1.1 0 2 .9 2 2v12c0 1.1-.9 2-2 2H4c-1.1 0-2-.9-2-2V6c0-1.1.9-2 2-2z" />
																				<polyline points="22,6 12,13 2,6" />
																			</svg>
															</div>
															<div class="h3">현재 프로젝트에 대한 '문의 메시지'가 없습니다</div>
															<div class="h5">고객님의 프로젝트에 문의 메시지가 오면 확인할 수있습니다.</div>
														</div>
													</div>
													<div class="col"></div>
												</div>
											</c:when>
											
										
											<c:when test="${vo2.creator ne null && not empty messagelist }">
												<section class="tiles ml-1 mt-3 row row-cols-1 row-cols-md-3">

													<div class="row row-cols-1 row-cols-md-3">
														<c:forEach var="messagelist" items="${messagelist}">
															<div class="card ml-3 mt-3" style="width: 18rem;">
																<div class="thumbnail-wrap">
										                            <div class="thumbnail">
										                                <div class="centered">
								                                       		<a href="#">
									                                         	<img src="${messagelist.project.projectMainImage }" class="card-img-top portrait" alt="내가만든 프로젝트 대표이미지">
								                                       		</a>
										                                </div>
										                            </div>
										                        </div>
										                        
										                        
										                        
										                        
										                        
																<div class="card-body">
																<h6 class="card-title">NO.${messagelist.projectNo } )${messagelist.project.projectTitle }</h6>
																	<p class="card-text">문의내용 : ${messagelist.projectAskContentsTitle }</p>
																	
																	<c:if test="${messagelist.projectAskReplyStatus eq '미답변'}">
																	<a href="getChoiceProjectAskMessageC.udo?projectAskNo=${messagelist.projectAskNo }" 
																		class="btn btn-success">${messagelist.projectAskReplyStatus}</a>
																	</c:if>
																	
																	<c:if test="${messagelist.projectAskReplyStatus eq '답변완료'}">
																	<a href="getChoiceProjectAskMessageC.udo?projectAskNo=${messagelist.projectAskNo }" 
																		class="btn btn-danger">${messagelist.projectAskReplyStatus}</a>
																	</c:if>
																</div>
															</div>
														</c:forEach>
													</div>
												</section>
											</c:when>
											
												
											<c:when test="${vo2.creator eq null }">
												<div class="row">
													<div class="col"></div>
													<div class="col-8 d-flex justify-content-center ">
														<div class="pt-5 pb-5 ">
															<div>
																<svg xmlns="http://www.w3.org/2000/svg" width="60"
																	height="60" viewBox="0 0 24 24" fill="none"
																	stroke="currentColor" stroke-width="1.5"
																	stroke-linecap="round" stroke-linejoin="round"
																	class="feather feather-mail">
																				<path
																		d="M4 4h16c1.1 0 2 .9 2 2v12c0 1.1-.9 2-2 2H4c-1.1 0-2-.9-2-2V6c0-1.1.9-2 2-2z" />
																				<polyline points="22,6 12,13 2,6" />
																			</svg>
															</div>
															<div class="h3">현재 프로젝트에 대한 '문의 메시지'가 없습니다</div>
															<div class="h5">고객님의 프로젝트에 문의 메시지가 오면 확인할 수있습니다.</div>
														</div>
													</div>
													<div class="col"></div>
												</div>
											</c:when>
											
										</c:choose> 
									</li>
								</ul>
								<br><br>
							</div>


							<div class="tab-pane fade" id="nav-sponsored-prj-questions"
								role="tabpanel"
								aria-labelledby="nav-sponsored-prj-questions-tab">


								<!-- 보낸 메세지 있을경우 포문돌리기 -->
								<c:choose>
									<c:when test="${not empty messagelist}">
								<section class="tiles ml-1 mt-3 row row-cols-1 row-cols-md-3">
													<div class="row row-cols-1 row-cols-md-3">
														<c:forEach var="messagelist" items="${messagelist}">
															<div class="card ml-3 mt-3" style="width: 18rem;">
																<div class="thumbnail-wrap">
										                            <div class="thumbnail">
										                                <div class="centered">
								                                       		<a href="#">
									                                         	<img src="${messagelist.project.projectMainImage }" class="card-img-top portrait" alt="내가만든 프로젝트 대표이미지">
								                                       		</a>
										                                </div>
										                            </div>
										                        </div>
													
													
													
													
													
													
													
													
													
													
													<div class="card-body">
													<h6 class="card-title">NO.${messagelist.projectAskNo } )${messagelist.projectAskContentsTitle }</h6>
														<p class="card-text">보낸날짜 : ${messagelist.projectAskDate}</p>
														
														
														
														<c:if test="${messagelist.projectAskReplyStatus eq '미답변'}">
														<a href="getChoiceProjectAskMessage.udo?projectAskNo=${messagelist.projectAskNo }" 
															class="btn btn-success">${messagelist.projectAskReplyStatus}</a>
														</c:if>
														
														<c:if test="${messagelist.projectAskReplyStatus eq '답변완료'}">
														<a href="getChoiceProjectAskMessage.udo?projectAskNo=${messagelist.projectAskNo }" 
															class="btn btn-danger">${messagelist.projectAskReplyStatus}</a>
														</c:if>
														
														
												
													</div>
												</div>
												
												</c:forEach>
												</div>
												</section>
										</c:when>
							
		
									<c:when test="${empty messagelist }">

										<div class="row">
											<div class="col"></div>
											<div class="col-8 d-flex justify-content-center ">
												<div class="pt-5 pb-5 ">
													<div>
														<svg xmlns="http://www.w3.org/2000/svg" width="60"
															height="60" viewBox="0 0 24 24" fill="none"
															stroke="currentColor" stroke-width="1.5"
															stroke-linecap="round" stroke-linejoin="round"
															class="feather feather-mail">
														<path d="M4 4h16c1.1 0 2 .9 2 2v12c0 1.1-.9 2-2 2H4c-1.1 0-2-.9-2-2V6c0-1.1.9-2 2-2z" />
														<polyline points="22,6 12,13 2,6" /></svg>
													</div>
													<div class="h3">보낸 메시지가 없습니다</div>
													<div class="h5">프로젝트 페이지에서 '문의하기' 버튼을 눌러 메시지를 보낼 수
														있습니다.</div>
												</div>
											</div>
											<div class="col"></div>
										</div>
										
										<br><br>
									</c:when>
									
								</c:choose>
								
							</div>
							<br><br>
							
							
						<!--     관리자에게 문의하기          ㅇㅇㅇㅇㅇㅇ -->
							<div class="tab-pane fade" id="nav-askadmin"
								role="tabpanel"
								aria-labelledby="nav-askadmin-tab">


								<!-- 보낸 메세지 있을 경우 -->
								<c:choose>
									<c:when test="${not empty askAdminList}">
										
										<c:forEach var="askAdminList" items="${askAdminList}">
											<c:if test="${askAdminList.replyProgress eq 'Y'.charAt(0)}">
											<div class="card mb-3" style="max-width: 620px;">
												<div class="row no-gutters">
													<div class="col m-4" id="detail-mypage-profile2-img" style="background: #BDBDBD;">
														<img src="${getMember.myImage }" class="card-img" alt="...">
													</div>
													<div class="col-md-8">
														<div class="card-body">
															<input type="hidden" id="csid" name="csid"
																value="${askAdminList.csid}">
															<h6 class="card-title">${askAdminList.csTitle}</h6>
															<p class="card-text">${askAdminList.csContent}</p>
															<p class="card-text">
																<small class="text-muted">${askAdminList.csRegdate}</small>
															</p>
														</div>
													</div>
												</div>
											</div>

											<div class="d-flex flex-row-reverse bd-highlight">
												<div class="card mb-3" style="width: 500px;">
													<div class="row no-gutters ">
														<div class="col-md-8">
														<span class="badge badge-danger">답변완료</span>
															<div class="card-body ">
																<h6 class="card-title">안녕하세요 [펀딩] 입니다.</h6>
																<p class="card-text">
																	답변이 정상등록 되었습니다.<br>이메일을 확인하여 주세요.
																</p>
																<p class="card-text">
																	<small class="text-muted">${askAdminList.csRegdate}
																		이부분바꾸기</small>
																</p>
															</div>
														</div>
													</div>
												</div>
											</div>
											</c:if>
										</c:forEach>
										
										
										
										<c:forEach var="askAdminList" items="${askAdminList}">

											<c:if test="${askAdminList.replyProgress eq 'N'.charAt(0)}">
											<div class="card mb-3" style="max-width: 620px;">
												<div class="row no-gutters">
													<div class="col m-4" id="detail-mypage-profile2-img" style="background: #BDBDBD;">
														<img src="${getMember.myImage }" class="card-img" alt="...">
													</div>
													<div class="col-md-8">
														<div class="card-body">
															<input type="hidden" id="csid" name="csid"
																value="${askAdminList.csid}">
															<h6 class="card-title">${askAdminList.csTitle}</h6>
															<p class="card-text">${askAdminList.csContent}</p>
															<p class="card-text">
																<small class="text-muted">${askAdminList.csRegdate}</small>
															</p>
														</div>
													</div>
												</div>
											</div>

											<div class="d-flex flex-row-reverse bd-highlight">
												<div class="card mb-3" style="width: 500px;">
													<div class="row no-gutters ">
														<div class="col-md-8">
													
														<span class="badge badge-success">미답변</span>
															<div class="card-body ">
																<h6 class="card-title">안녕하세요 [펀딩] 입니다.</h6>
																<p class="card-text">
																	답변이 아직 등록 되지않았습니다.<br>최대한 빨리 답변드리겠습니다.
																</p>
																<p class="card-text">
																	<small class="text-muted">${askAdminList.csRegdate}
																		이부분바꾸기</small>
																</p>
															</div>
														</div>
													</div>
												</div>
											</div>
										
										</c:if>
									</c:forEach>
									
								</c:when>

								<c:when test="${empty askAdminList }">

										<div class="row">
											<div class="col"></div>
											<div class="col-8 d-flex justify-content-center ">
												<div class="pt-5 pb-5 ">
													<div>
														<svg xmlns="http://www.w3.org/2000/svg" width="60"
															height="60" viewBox="0 0 24 24" fill="none"
															stroke="currentColor" stroke-width="1.5"
															stroke-linecap="round" stroke-linejoin="round"
															class="feather feather-mail">
														<path d="M4 4h16c1.1 0 2 .9 2 2v12c0 1.1-.9 2-2 2H4c-1.1 0-2-.9-2-2V6c0-1.1.9-2 2-2z" />
														<polyline points="22,6 12,13 2,6" /></svg>
													</div>
													<div class="h3">문의한 내용이 없습니다</div>
													<div class="h5">홈페이지 하단에서  관리자에게 문의하기를 눌러 홈페이지 이용관련한 문의를 할 수 있습니다. </div>
												</div>
											</div>
											<div class="col"></div>
										</div>
								</c:when>
									
							</c:choose>
						</div>
						<br><br>
		
						</div>
					</div>
					<div class="col"></div>
				</div>
			</div>
		</div>
	</section>



	<!-- footer -->
	<footer class="footer"> </footer>
	
	<jsp:include page="./include/i-footer.jsp"></jsp:include>
   <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
   <jsp:include page="./include/i-popup-search.jsp"></jsp:include>
   <jsp:include page="./include/i-body-js.jsp"></jsp:include>

</body>
</html>