<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
							${previewProject.projectIntroduceVideo }
					    </div>
					</div>			
				</aside>
				<aside id="project-details-info"
					class="col-4 align-items-start d-flex flex-column bd-highlight">
					
					<fmt:formatNumber type="number" var="progressPercent"
										value="${(projectPreview.fundingMoney / projectPreview.goalMoney)*100}"
										pattern=".00" />
					<fmt:formatNumber type="number" var="progress"
						maxFractionDigits="3" value="${projectPreview.fundingMoney}" />
					
					
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
					<fmt:formatDate var="endDate" value="${projectPreview.endDate}" pattern="yyyyMMdd" />

					
					<div class="p-2 bd-highlight">
						<div class="h4">남은 날짜</div>
						<div class="h2" style="color: #000000">
							${endDate - today } 일
							<div class="h5" style="color: #000000"></div>
						</div>
					</div>
					<div class="p-2 bd-highlight mt-auto ml-0">
						<form id="supportProject" action="supportprojectPreview.udo" method="GET">
							<input type="hidden" name="projectNo" value="${projectPreview.projectNo }">
							<a class="btn btn-lg btn-spon-prj d-none d-lg-inline-block pr-5 pl-5 mb-2"
								href="javaScript: return(0);" onclick="document.getElementById('supportProject').submit();">
								프로젝트 밀어주기</a>
						</form>
					</div>
					<div class="row d-flex justify-content-around m-0 ">
						<a
							class="btn btn-sm btn-detail-prj-etc-btn d-none d-lg-inline-block p-3 m-1 mb-2"
							href="#">좋아요</a> <a
							class="btn btn-sm btn-detail-prj-etc-btn d-none d-lg-inline-block p-3 m-1 mb-2"
							href="showInsertwAskMessage.udo?projectNo=${projectPreview.projectNo }">문의하기</a> <a
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
							
						</div>
						<!-- 프로젝트 디테일 페이지 스토리 및 게시글 끝 [왼쪽] -->

						<!-- 리워드 추가되는 부분 시작 -->
						<div class="col-2">
							<!-- 리워드 품목 들어가기 -->
							<c:forEach var="reward" items="${rewardList }">
								<div class="card mb-3" style="width: 18rem;">
									<div class="card-body">
										<h5 class="card-title">${reward.rewardPrice }</h5>
										<h6 class="card-subtitle mb-2 text-muted">${reward.rewardName }</h6>
										<p class="card-text">${reward.rewardContent }</p>
										<p class="card-text">${reward.rewardMonth }월  ${reward.rewardDay } 배송예정</p>
										<c:forEach var="option" items="${reward.rewardOptionList }">
											<p class="card-text">${option.rewardOptionKey } | ${option.rewardOptionValue }</p>
										</c:forEach>
										<a href="javaScript: return(0);" class="card-link">${reward.rewardAmount }개 남음</a>
									</div>
								</div>
							</c:forEach>
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