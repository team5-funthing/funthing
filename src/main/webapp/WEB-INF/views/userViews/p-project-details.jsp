<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!doctype html>
<html class="no-js">

<head>

<jsp:include page="./include/i-head-setting.jsp" />

<style>
.white-popup{
  position: relative;
  background: #FFF;
  padding: 40px;
  width: auto;
  max-width: 600px;
  margin: 20px auto;
  text-align: center;
}
h6{
	color:black;
	font-size:75%;
}
</style>
<script>
$(document).ready(function(){
	$(".showReport").magnificPopup({
		type:'inline',
		midClick:true
	});
});





</script>
</head>

<body>

	<jsp:include page="./include/i-popupover-mypage.jsp" />
	<jsp:include page="./include/i-header.jsp" />
	
	<section class="container">

		<div class="w-100">
		
			<div class="row d-flex justify-content-center">
				<div class="row d-flex align-content-between flex-wrap mt-5">
					<div class="col-xl-12 d-flex bd-highlight mb-1">
						<ul id="addedKeywords">
							<c:set var="tag" value="#" />
							<c:set var="keywordId" value="keyword" />
							<c:choose>
								<c:when test="${projectKeywordList eq null }">
								</c:when>
								<c:when test="${projectKeywordList ne null }">
									<c:forEach var="projectKeyword"
										items="${projectKeywordList }" varStatus="step">
										<li id="${keywordId }${step.count}"
											class="btn-sm btn-bd-keyword d-none d-lg-inline-block m-1">
											<a href="javascript:void(0);" class="addedKeyword">${projectKeyword.keyword }</a>
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
					<nav>
					    <div class="nav nav-tabs" id="nav-tab" role="tablist">
					   		<a class="nav-item nav-link active" id="nav-images-tab" data-toggle="tab" href="#nav-images" role="tab" aria-controls="nav-images" aria-selected="true">소개 이미지</a>
				            <a class="nav-item nav-link" id="nav-video-tab" data-toggle="tab" href="#nav-video" role="tab" aria-controls="nav-video" aria-selected="false" >소개 영상</a>
				            
					    
					    </div>
					</nav>
					
					<div class="tab-content p-3" id="nav-tabContent">
					    <div class="tab-pane fade show active" id="nav-images" role="tabpanel" aria-labelledby="nav-images-tab">
					  		
							<div id="carouselIntroduceImages" class="carousel slide">
							
							    <ol class="carousel-indicators">
							        <li data-target="#carouselIntroduceImages" data-slide-to="0" class="active"></li>
							        <li data-target="#carouselIntroduceImages" data-slide-to="1"></li>
							        <li data-target="#carouselIntroduceImages" data-slide-to="2"></li>
							    </ol>
								<div class="carousel-inner">
									<c:forEach var="projectIntroduceImage" items="${projectIntroduceImageList }" varStatus="cnt">
										<c:choose>
											<c:when test="${cnt.first }">
												<div class="carousel-item active">
													<div class="thumbnail-wrap">
							                            <div class="thumbnail">
							                                <div class="centered">
							                                	<img src="${projectIntroduceImage.projectIntroduceImage }" class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
							                                </div>
							                            </div>
							                        </div>
												</div>
											</c:when>
											<c:otherwise>
												<div class="carousel-item">
													<div class="thumbnail-wrap">
							                            <div class="thumbnail">
							                                <div class="centered">
							                                	<img src="${projectIntroduceImage.projectIntroduceImage }" class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
							                                </div>
							                            </div>
							                        </div>
												</div>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</div>
								<a class="carousel-control-prev" href="#carouselIntroduceImages" role="button" data-slide="prev">
								<span class="carousel-control-prev-icon" aria-hidden="true"></span>
								<span class="sr-only">Previous</span>
								</a>
								<a class="carousel-control-next" href="#carouselIntroduceImages" role="button" data-slide="next">
									<span class="carousel-control-next-icon" aria-hidden="true"></span>
									<span class="sr-only">Next</span>
								</a>
							</div>		
					    </div>
					    <div class="tab-pane fade" id="nav-video" role="tabpanel" aria-labelledby="nav-video-tab">
							${project.projectIntroduceVideo }
					    </div>
					</div>			
				</aside>
				
				<aside id="project-details-info"
					class="col-4 align-items-start d-flex flex-column bd-highlight">
					
					<fmt:formatNumber type="number" var="progressPercent"
										value="${(project.fundingMoney / project.goalMoney)*100}"
										pattern=".00" />
					<fmt:formatNumber type="number" var="progress"
						maxFractionDigits="3" value="${project.fundingMoney}" />
					
					
					<div class="p-2 bd-highlight">
						<div class="h4">모인 금액</div>
						<div class="h2" style="color: #000000">
								${progress} 원
							
							<div class="h5" style="color: #000000">
								${progressPercent}% 달성중
							</div>
						</div>
					</div>
					<div class="progress">
						<div class="progress-bar color-7" role="progressbar"
							style="width: ${progressPercent}%" aria-valuenow="30"
							aria-valuemin="0" aria-valuemax="100"></div>
					</div>
					
					<jsp:useBean id="now" class="java.util.Date" />
					<fmt:formatDate var="today" value="${now}" pattern="yyyyMMdd" />
					<fmt:formatDate var="endDate" value="${project.endDate}" pattern="yyyyMMdd" />

					
					<div class="p-2 bd-highlight">
						<div class="h4" style="color: gray; font-weight: 400;">남은 날짜</div>
						<div class="h2" style="color: black; font-weight: 500;">
							<c:choose>
								<c:when test="${endDate - today < 1 }">
									마감
								</c:when>
								<c:otherwise>
									${endDate - today } 일
								</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="p-2 bd-highlight mt-auto ml-0">
						<form id="supportProject" action="supportProject.udo" method="GET">
							<input type="hidden" name="projectNo" value="${project.projectNo }">
							<c:choose>
								<c:when test="${endDate - today < 1 }">		
									<a class="supportProjectBtn btn btn-lg btn-spon-prj d-none d-lg-inline-block pr-5 pl-5 mb-2"
									href="javaScript: return(0);" onclick="document.getElementById('supportProject').submit();">
									프로젝트 밀어주기</a>							
 									<script>
										$(".supportProjectBtn").css("background-color", "gray");
										$(".supportProjectBtn").css("opacity", "0.3");
										$(".supportProjectBtn").css({'pointer-events':'none'});
									</script>
								</c:when>
								<c:otherwise>
									<a class="supportProjectBtn btn btn-lg btn-spon-prj d-none d-lg-inline-block pr-5 pl-5 mb-2"
										href="javaScript: return(0);" onclick="document.getElementById('supportProject').submit();">
										프로젝트 밀어주기</a>
								</c:otherwise>
							</c:choose>
						</form>
					</div>
					<div class="row d-flex justify-content-center m-0 ">
						<a class="btn btn-sm btn-detail-prj-etc-btn d-none d-lg-inline-block p-3 m-1 mb-2" href="upCountLike.udo?projectNo=${project.projectNo }">좋아요   ${likeCount}</a> 
						<a class="btn btn-sm btn-detail-prj-etc-btn d-none d-lg-inline-block p-3 m-1 mb-2" href="showInsertwAskMessage.udo?projectNo=${project.projectNo }">문의하기</a> 
						
					</div>

				</aside>
			</article>

			<hr>

			<div class="w-75">

				<article>
					<div class="row">
						<div class="col-lg-10 posts-list">
							<div class="single-project-details">
								<div class="blog_details">
									<h3>${project.projectSubTitle }</h3>
									<c:if test="${project ne null }">
										
										${project.projectStory}
									
									</c:if> 
									
								</div>
							</div>
							
							<!-- projectBoard form 시작 -->
							<div class="comment-form">
								<h4>리뷰 게시판 글 남기기</h4>
								
								<form class="form-contact comment_form" action="insertProjectBoard.udo" 
												id="commentForm" method="get">
									<input type="hidden" name="projectNo" value="${project.projectNo}">
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
													value="${sessionScope.memberSession.name}">
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
										<button onclick="submitComment()" class="button button-contactForm btn_1 boxed-btn">글 남기기</button>
									</div>
								</form>
							</div>
							<!-- projectBoard form 끝 -->
							<script>
								function submitComment() {
									var comment = document.getElementById("projectBoardContents").value;
									
									if(comment==""){
										alert("글을 쓰세요");
										return;
									}else{
										document.getElementById("commentForm").submit();
									}
									
								}
							</script>
							
							
							<!-- proejctBoardList 시작 -->
							<div class="comments-area">
								<h4>리뷰 게시판</h4>
								
								<!-- projectBoard 시작 -->
								<c:forEach var="b1" items="${getProjectBoardList}">
									<c:if test="${b1.step eq 0}"> 										
										<div class="comment-list">
											<div class="single-comment justify-content-between d-flex">
												<div class="user justify-content-between d-flex">
													<div id="projectBoard-profile" class="thumb">
														<img class="profile" src="${b1.member.myImage }">
													</div>
													<div class="desc" style="width: 600px;">
														<p class="comment">
															${b1.projectBoardContents}
														</p>
														<div class="d-flex justify-content-between">
															<div class="d-flex align-items-center">
																<h5>
																	
																	<a href="nameProfile.udo?email=${b1.email}&name=${b1.member.name}" onclick="window.open(this.href,'_blank', toolvars=no'); return false;">${b1.member.name }</a>
																	
																</h5>
																
																

																<p class="date">${b1.projectBoardDate}</p>
															</div>
															<c:choose>
																<c:when
																	test="${ b1.email eq sessionScope.memberSession.email }">

																	<div class="reply-btn">
																		<a href="getProjectBoard.udo?projectNo=${b1.projectNo }&projectBoardNo=${b1.projectBoardNo }"
																			class="button button-contactForm btn_1 boxed-btn pt-1 pl-2 pr-2 pb-0">
																			수정 </a> 
																		<a href="deleteProjectBoard.udo?projectNo=${b1.projectNo }&projectBoardNo=${b1.projectBoardNo }"
																			class="button button-contactForm btn_1 boxed-btn pt-1 pl-2 pr-2 pb-0">
																			삭제 </a>

																	</div>

																</c:when>


																<c:when
																	test="${sessionScope.memberSession.email eq project.email }">

																		<div class="reply-btn">
																			<a type="submit" href="replyBoard.udo?projectNo=${b1.projectNo }&projectBoardNo=${b1.projectBoardNo }"
																				class="button button-contactForm btn_1 boxed-btn pt-1 pl-3 pr-3 pb-1">
																				Reply </a>
																		</div>
																	</c:when>
															</c:choose>
														</div>
														
														<!-- projectBoard Reply 시작 -->
														<c:forEach var="b2" items="${getProjectBoardList}">
															<c:if test="${b1.ref eq b2.ref && b1.step ne b2.step}">
																<div class="d-flex justify-content-around mt-3">
							                                       <div class="d-flex align-items-center">
							                                          <div class="single-comment justify-content-between d-flex">
							                                             <div class="user justify-content-between d-flex p-3"
							                                                style="background-color: whitesmoke;">
																				<div id="projectBoard-profile" class="thumb">
																					<img class="profile" src="${creator.creatorProfileImage }">
																				</div>
																				<div class="desc" style="width: 500px;">
							                                                    <p class="comment">
							                                                   		${b2.projectBoardContents}
							                                                    </p>
							                                                    <div class="d-flex justify-content-between">
							                                                       <div class="d-flex align-items-center">
							                                                          <h5>
							                                                          <a href="nameProfile.udo?email=${b2.email}&name=${b2.member.name}" onclick="window.open(this.href,'_blank', toolvars=no'); return false;">${b2.member.name }</a>
							                                                             
							                                                          </h5>
							                                                          <p class="date">${b2.projectBoardDate}</p>
							                                                       </div>
							                                                       <c:if test="${ b2.email eq sessionScope.memberSession.email }">
							                                                       	<form action="getProjectBoardReply.udo" method="get">
																						<div class="reply-btn">
																							<input type="submit" 
																							class="button button-contactForm btn_1 boxed-btn pt-1 pl-2 pr-2 pb-0" value="수정">
																								 <input type="submit" formaction="deleteProjectBoardReply.udo"
																								class="button button-contactForm btn_1 boxed-btn pt-1 pl-2 pr-2 pb-0" value="삭제"> 
																								<input type="hidden" name="step" id="step" value="${b2.step}"> 
																								<input type="hidden" name="ref" id="ref" value="${b2.ref}">
																								<input type="hidden" name="projectNo" id="projectNo" value="${b2.projectNo}">
																								

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

						<div class="col-2">
							<!-- 리워드 추가되는 부분 시작 -->
							<c:forEach var="reward" items="${rewardList }">
								<div class="card mb-3" style="width: 18rem;">
									<div class="card-body">
										<h5 class="card-title">${reward.rewardPrice }</h5>
										<h6 class="card-subtitle mb-2 text-muted">${reward.rewardName }</h6>
										<p class="card-text">${reward.rewardContent }</p>
										<p class="card-text">${reward.rewardMonth }  ${reward.rewardDay } 배송예정</p>
										<c:forEach var="option" items="${reward.rewardOptionList }">
											<p class="card-text">${option.rewardOptionKey } | ${option.rewardOptionValue }</p>
										</c:forEach>
										<a href="javaScript: return(0);" class="card-link">${reward.rewardAmount }개 남음</a>
									</div>
								</div>
							</c:forEach>
							<!-- 리워드 반복 끝-->
							
							<div>
								<div class="card mb-3" style="width: 18rem;">
									<div class="p-2 bd-highlight mt-auto ml-0">
										<h5>신고하기란?</h5>
										<h6>해당 프로젝트에 허위내용 및 지적재산권을 침해하는 내용이 있다면 제보해주세요</h6>
										<a class="showReport btn btn-lg btn-spon-prj d-none d-lg-inline-block pr-5 pl-5 mb-2"
										   href="#showReportPage"> 프로젝트 신고하기</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</article>
			</div>
		</div>
	</section>
	
	<div id="showReportPage" class="white-popup mfp-hide">
		<form id="reports" action="insertReport.udo" method="POST">
			<input type="hidden" value="${project.projectNo}" name="projectNo">
			<input type="hidden" value="${project.email}" name="email">
	        <div class="report_popup_box ">
	            <div class="popup_inner ">
	                <div class="container ">
	                    <div class="row pb-1">
	                        <h4>프로젝트 신고하기</h4>
	                    </div>
	                    <hr>
	                    <div class="row">
	                        <span>신고 이유가 무엇인가요?</span>
	                    </div>
	                    <div class="row d-flex align-items-center">
	                        <div class="p-2 bd-highlight">
	                            <div class="form-check primary-radio ">
	                                <input class="form-check-input primary-radio checkbox" type="radio" name="reasonSelect"
	                                    id="primary-radio1" value="스토리에 허위사실이 있습니다." checked>
	                                <label for="primary-radio1"></label>
	                            </div>
	                        </div>
	                        <div class="d-flex p-2 bd-highlight">스토리에 허위사실이 있습니다.</div>
	                    </div>
	                    <div class="row d-flex align-items-center">
	                        <div class="p-2 bd-highlight">
	                            <div class="form-check primary-radio ">
	                                <input class="form-check-input primary-radio checkbox" type="radio" name="reasonSelect"
	                                    id="primary-radio2" value="지적 재산권을 침해하고 있습니다." >
	                                <label for="primary-radio2"></label>
	                            </div>
	                        </div>
	                        <div class="d-flex p-2 bd-highlight">지적 재산권을 침해하고 있습니다.</div>
	                    </div>
	                    <div class="row d-flex align-items-center">
	                        <div class="p-2 bd-highlight">
	                            <div class="form-check primary-radio ">
	                                <input class="form-check-input primary-radio checkbox" type="radio" name="reasonSelect"
	                                    id="primary-radio3" value="다른 채널에서 판매되고 있는 제품입니다." >
	                                <label for="primary-radio3"></label>
	                            </div>
	                        </div>
	                        <div class="d-flex p-2 bd-highlight">다른 채널에서 판매되고 있는 제품입니다.</div>
	                    </div>
	                    <div class="row d-flex align-items-center">
	                        <div class="p-2 bd-highlight">
	                            <div class="form-check primary-radio ">
	                                <input class="form-check-input primary-radio checkbox" type="radio" name="reasonSelect"
	                                    id="primary-radio4" value="메이커와 오랫동안 연락이 되지 않습니다." >
	                                <label for="primary-radio4"></label>
	                            </div>
	                        </div>
	                        <div class="d-flex p-2 bd-highlight">메이커와 오랫동안 연락이 되지 않습니다.</div>
	                    </div>
	                    <div class="row d-flex align-items-center">
	                        <div class="p-2 bd-highlight">
	                            <div class="form-check primary-radio ">
	                                <input class="form-check-input primary-radio checkbox" type="radio" name="reasonSelect"
	                                    id="primary-radio5" value="사회적 공익을 저해할 우려가 있습니다.">
	                                <label for="primary-radio5"></label>
	                            </div>
	                        </div>
	                        <div class="d-flex p-2 bd-highlight">사회적 공익을 저해할 우려가 있습니다.</div>
	                    </div>
	                    <div class="row d-flex align-items-center">
	                        <div class="p-2 bd-highlight">
	                            <div class="form-check primary-radio ">
	                                <input class="form-check-input primary-radio checkbox" type="radio" name="reasonSelect"
	                                    id="primary-radio6" value="기타">
	                                <label for="primary-radio6"></label>
	                            </div>
	                        </div>
	                        <div class="d-flex p-2 bd-highlight">기타</div>
	                    </div>
	                    <div class="row mt-30">
	                        <h6>상세내용을 작성해주세요.</h6>
	                    </div>
	                    <div class="row">
	                        <div class="form-group col-12 ">
	                            <textarea name="reason" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
	                        </div>
	                    </div>
	                    <div class="row">
	                        <p>
	                            - 신고/제보를 통해 접수된 의견은 와디즈 프로젝트 운영에 반영되며 별도로 제보자에게 회신드리지 않습니다.<br>
	                            - 와디즈가 건전한 크라우드펀딩 생태계 조성을 할 수 있도록 도움을 주심에 감사드리며, 
	                                                        근거 없는 비방 내용의 경우에는 법적 처벌대상이 될 수 있사오니 유의해주시기 바랍니다.
	                        </p>
	                    </div>
	
	                    <div class="row d-flex justify-content-end">
	                        <div>
	                            <a class="btn btn-lg btn-report-cancel d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
	                                href="#">취소</a>
	                        </div>
	                        <div>
	                            <a class="btn btn-lg btn-report-submit d-none d-lg-inline-block mb-3 mb-md-0 ml-md-3"
	                                href="javaScript:return(0);" onclick="javascript:document.getElementById('reports').submit();">제출하기</a>
	                        </div>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </form>
    </div>

	<!-- footer -->
	<footer class="footer"> </footer>

	<jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
	<jsp:include page="./include/i-body-js.jsp"></jsp:include>
	
	
	

</body>
</html>







