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
	<jsp:include page="./include/i-header.jsp" />

	<c:if test="${msg != null }">
		<script>
			alert("${msg }");
		</script>
	</c:if>

	<!-- slider_area_start -->
	<div class="slider_area">
		<div class="slider_active owl-carousel">
			<div
				class="single_slider d-flex align-items-center justify-content-center slider_bg_1">
				<div class="container">
					<div class="row">
						<div class="col-xl-12">
							<div class="slider_text text-center"></div>
						</div>
					</div>
				</div>
			</div>
			<div
				class="single_slider  d-flex align-items-center justify-content-center slider_bg_2">
				<div class="container">
					<div class="row">
						<div class="col-xl-12">
							<div class="slider_text text-center"></div>
						</div>
					</div>
				</div>
			</div>
			<div
				class="single_slider d-flex align-items-center justify-content-center slider_bg_1">
				<div class="container">
					<div class="row">
						<div class="col-xl-12">
							<div class="slider_text text-center"></div>
						</div>
					</div>
				</div>
			</div>
			<div
				class="single_slider  d-flex align-items-center justify-content-center slider_bg_2">
				<div class="container">
					<div class="row">
						<div class="col-xl-12">
							<div class="slider_text text-center"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- slider_area_end -->


	<section class="container">


		<div>
			<div class="h3 pt-5 d-flex justify-content-between">
				<a href="#">주목할 만한 프로젝트<i class="fas fa-chevron-right"></i></a>
				<div>
					<i class="fas fa-chevron-left mr-5"></i> <i
						class="fas fa-chevron-right mr-5"></i>
				</div>
			</div>
			<section class="tiles pt-0 mt-0">

				<!-- 올라온 프로젝트들 목록 표시-->
				<!-- 기본셋팅은 목록에는 진행중인 프로젝트 전체 목록 표시-->
				<!---------- 일반 펀딩 목록 보는 양식------ img class 에 가로가 긴 이미지면 landscape 세로가 길면 portrait -->
				<article>

					<div class="project">
						<div class="thumbnail-wrap">
							<div class="thumbnail">
								<div class="centered">
									<a href="projectDetails.udo"><img
										src="${pageContext.request.contextPath}/resources/user/img/test/8.jpg"
										class="card-img-top landscape" alt="1.jpg"></a>
								</div>
							</div>
						</div>
						<h5>프로젝트 제목</h5>
						<ul>
							<li>Luxaries condition</li>
							<li>3 Adults & 2 Children size</li>
							<li>Sea view side</li>
						</ul>
						<div class="mt-10">
							<div class="percentage">
								<p>2,352,000원 30%</p>
								<div class="progress">
									<div class="progress-bar color-7" role="progressbar"
										style="width: 50%" aria-valuenow="30" aria-valuemin="0"
										aria-valuemax="100"></div>
								</div>
							</div>
						</div>
					</div>
				</article>
				<!-- 추가적으로 목록들 생길 시 JSTL로 반복 추가-->
			</section>
			<hr>
		</div>

		<div>
			<div class="h3 pt-5 d-flex justify-content-between">
				<a href="#">진행중인 기획전 <i class="fas fa-chevron-right"></i></a>

			</div>
			<!-- 1번째 페이지 시작 -->
			<div id="progeressListControls" class="carousel slide"
				data-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<section class="tiles pt-0 mt-0">
							<c:forEach var="progeressList" items="${progeressList}">
								<article>
									<div class="project">
										<div class="thumbnail-wrap">
											<div class="thumbnail">
												<div class="centered">
													<img src="${progeressList.projectMainImage}"
														class="card-img-top landscape"
														alt="이미지를 찾지 못했습니다.">
												</div>
											</div>
										</div>
										<h5>타이틀${progeressList.projectTitle}</h5>
										<ul>
											<li>서브타이틀${progeressList.projectSubTitle}</li>

										</ul>
										<div class="mt-10">
											<div class="percentage">
												<fmt:formatNumber type="number" var="progressPercent"
													value="${(progeressList.fundingMoney / progeressList.goalMoney)*100}"
													pattern=".00" />
												<fmt:formatNumber type="number" var="progress"
													maxFractionDigits="3" value="${progeressList.fundingMoney}" />
												<p>${progress}원${progressPercent}%진행중</p>

												<div class="progress">
													<div class="progress-bar color-7" role="progressbar"
														style="width: ${progressPercent}%" aria-valuenow="30"
														aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</div>
										</div>
									</div>

								</article>
							</c:forEach>
						</section>
					</div>
					<!-- 2번째 페이지 시작 -->
					<div class="carousel-item">
						<section class="tiles pt-0 mt-0">
							<c:forEach var="progeressList2" items="${progeressList2}">
								<article>
									<div class="project">
										<div class="thumbnail-wrap">
											<div class="thumbnail">
												<div class="centered">
													<img src="${progeressList2.projectMainImage}"
														class="card-img-top landscape"
														alt="이미지를 찾지 못했습니다.">
												</div>
											</div>
										</div>
										<h5>타이틀${progeressList2.projectTitle}</h5>
										<ul>
											<li>서브타이틀${progeressList2.projectSubTitle}</li>

										</ul>
										<div class="mt-10">
											<div class="percentage">
												<fmt:formatNumber type="number" var="progressPercent2"
													value="${(progeressList2.fundingMoney / progeressList2.goalMoney)*100}"
													pattern=".00" />
												<fmt:formatNumber type="number" var="progress2"
													maxFractionDigits="3"
													value="${progeressList2.fundingMoney}" />
												<p>${progress2}원${progressPercent2}%진행중</p>

												<div class="progress">
													<div class="progress-bar color-7" role="progressbar"
														style="width: ${progressPercent2}%" aria-valuenow="30"
														aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</div>
										</div>
									</div>

								</article>
							</c:forEach>
						</section>
					</div>
					<!-- 3번째 페이지 시작 -->
					<div class="carousel-item">
						<section class="tiles pt-0 mt-0">
							<c:forEach var="progeressList3" items="${progeressList3}">
								<article>
									<div class="project">
										<div class="thumbnail-wrap">
											<div class="thumbnail">
												<div class="centered">
													<img src="${progeressList3.projectMainImage}"
														class="card-img-top landscape"
														alt="이미지를 찾지 못했습니다.">
												</div>
											</div>
										</div>
										<h5>타이틀${progeressList3.projectTitle}</h5>
										<ul>
											<li>서브타이틀${progeressList3.projectSubTitle}</li>

										</ul>
										<div class="mt-10">
											<div class="percentage">
												<fmt:formatNumber type="number" var="progressPercent3"
													value="${(progeressList3.fundingMoney / progeressList3.goalMoney)*100}"
													pattern=".00" />
												<fmt:formatNumber type="number" var="progress3"
													maxFractionDigits="3"
													value="${progeressList3.fundingMoney}" />
												<p>${progress3}원${progressPercent3}%진행중</p>

												<div class="progress">
													<div class="progress-bar color-7" role="progressbar"
														style="width: ${progressPercent3}%" aria-valuenow="30"
														aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</div>
										</div>
									</div>

								</article>
							</c:forEach>
						</section>
					</div>


					<a class="carousel-control-prev" href="#progeressListControls"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" style="background-color: black;" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#progeressListControls"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" style="background-color: black;" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>

			<hr>
		</div>



		<div>
			<div class="h3 pt-5 d-flex justify-content-between">
				<a href="#">인기 프로젝트 <i class="fas fa-chevron-right"></i></a>

			</div>


			<!-- 1번째 페이지 시작 -->
			<div id="likeCountListControls" class="carousel slide"
				data-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<section class="tiles pt-0 mt-0">
							<c:forEach var="likeCountList" items="${likeCountList}">
								<article>
									<div class="project">
										<div class="thumbnail-wrap">
											<div class="thumbnail">
												<div class="centered">
													<img src="${likeCountList.projectMainImage}"
														class="card-img-top landscape" alt="이미지를 찾지 못했습니다.">
												</div>
											</div>
										</div>
										<h5>타이틀${likeCountList.projectTitle}</h5>
										<ul>
											<li>서브타이틀${likeCountList.projectSubTitle}</li>

										</ul>
										<div class="mt-10">
											<div class="percentage">
												<fmt:formatNumber type="number" var="likeCountPercent"
													value="${(likeCountList.fundingMoney / likeCountList.goalMoney)*100}"
													pattern=".00" />
												<fmt:formatNumber type="number" var="likeCount"
													maxFractionDigits="3" value="${likeCountList.fundingMoney}" />
												<p>${likeCount}원${likeCountPercent}%진행중</p>

												<div class="progress">
													<div class="progress-bar color-7" role="progressbar"
														style="width: ${likeCountPercent}%" aria-valuenow="30"
														aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</div>
										</div>
									</div>
								</article>
							</c:forEach>
						</section>
					</div>
					<!-- 2번째 슬라이드 -->
					<div class="carousel-item">
						<section class="tiles pt-0 mt-0">
							<c:forEach var="likeCountList2" items="${likeCountList2}">
								<article>
									<div class="project">
										<div class="thumbnail-wrap">
											<div class="thumbnail">
												<div class="centered">
													<img src="${likeCountList2.projectMainImage}"
														class="card-img-top landscape" alt="이미지를 찾지 못했습니다.">
												</div>
											</div>
										</div>
										<h5>타이틀${likeCountList2.projectTitle}</h5>
										<ul>
											<li>서브타이틀${likeCountList2.projectSubTitle}</li>

										</ul>
										<div class="mt-10">
											<div class="percentage">
												<fmt:formatNumber type="number" var="likeCountPercent2"
													value="${(likeCountList2.fundingMoney / likeCountList2.goalMoney)*100}"
													pattern=".00" />
												<fmt:formatNumber type="number" var="likeCount2"
													maxFractionDigits="3"
													value="${likeCountList2.fundingMoney}" />
												<p>${likeCount2}원${likeCountPercent2}%진행중</p>

												<div class="progress">
													<div class="progress-bar color-7" role="progressbar"
														style="width: ${likeCountPercent2}%" aria-valuenow="30"
														aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</div>
										</div>
									</div>
								</article>
							</c:forEach>
						</section>
					</div>
					<!-- 3번째 슬라이드 -->
					<div class="carousel-item">
						<section class="tiles pt-0 mt-0">
							<c:forEach var="likeCountList3" items="${likeCountList3}">
								<article>
									<div class="project">
										<div class="thumbnail-wrap">
											<div class="thumbnail">
												<div class="centered">
													<img src="${likeCountList3.projectMainImage}"
														class="card-img-top landscape" alt="이미지를 찾지 못했습니다.">
												</div>
											</div>
										</div>
										<h5>타이틀${likeCountList3.projectTitle}</h5>
										<ul>
											<li>서브타이틀${likeCountList3.projectSubTitle}</li>

										</ul>
										<div class="mt-10">
											<div class="percentage">
												<fmt:formatNumber type="number" var="likeCountPercent3"
													value="${(likeCountList3.fundingMoney / likeCountList3.goalMoney)*100}"
													pattern=".00" />
												<fmt:formatNumber type="number" var="likeCount3"
													maxFractionDigits="3"
													value="${likeCountList3.fundingMoney}" />
												<p>${likeCount3}원${likeCountPercent3}%진행중</p>

												<div class="progress">
													<div class="progress-bar color-7" role="progressbar"
														style="width: ${likeCountPercent3}%" aria-valuenow="30"
														aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</div>
										</div>
									</div>
								</article>
							</c:forEach>
						</section>
					</div>

					<a class="carousel-control-prev" href="#likeCountListControls"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" style="background-color: black;" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#likeCountListControls"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" style="background-color: black;" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>

			<hr>
		</div>



		<div>
			<div class="h3 pt-5 d-flex justify-content-between">
				<a href="#">성공 임박 프로젝트<i class="fas fa-chevron-right"></i></a>
			</div>


			<!-- 1번째 페이지 시작 -->
			<div id="moneyPercentListControls" class="carousel slide"
				data-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<section class="tiles pt-0 mt-0">
							<c:forEach var="moneyPercentList" items="${moneyPercentList}">
								<article>
									<div class="project">
										<div class="thumbnail-wrap">
											<div class="thumbnail">
												<div class="centered">
													<img src="${moneyPercentList.projectMainImage}"
														class="card-img-top landscape" alt="이미지를 찾지 못했습니다.">
												</div>
											</div>
										</div>
										<h5>타이틀${moneyPercentList.projectTitle}</h5>
										<ul>
											<li>서브타이틀${moneyPercentList.projectSubTitle}</li>

										</ul>
										<div class="mt-10">
											<div class="percentage">

												<fmt:formatNumber type="number" var="fundingMoneypercent"
													value="${(moneyPercentList.fundingMoney / moneyPercentList.goalMoney)*100}"
													pattern=".00" />
												<fmt:formatNumber type="number" var="fundingMoney"
													maxFractionDigits="3"
													value="${moneyPercentList.fundingMoney}" />
												<p>${fundingMoney}원${fundingMoneypercent}%진행중</p>
												<div class="progress">
													<div class="progress-bar color-7" role="progressbar"
														style="width: ${fundingMoneypercent}%" aria-valuenow="30"
														aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</div>
										</div>
									</div>
								</article>
							</c:forEach>
						</section>
					</div>
					<!-- 2번째 페이지 시작 -->

					<div class="carousel-item">
						<section class="tiles pt-0 mt-0">
							<c:forEach var="moneyPercentList2" items="${moneyPercentList2}">
								<article>
									<div class="project">
										<div class="thumbnail-wrap">
											<div class="thumbnail">
												<div class="centered">
													<img src="${moneyPercentList2.projectMainImage}"
														class="card-img-top landscape" alt="이미지를 찾지 못했습니다.">
												</div>
											</div>
										</div>
										<h5>타이틀${moneyPercentList2.projectTitle}</h5>
										<ul>
											<li>서브타이틀${moneyPercentList2.projectSubTitle}</li>

										</ul>
										<div class="mt-10">
											<div class="percentage">

												<fmt:formatNumber type="number" var="fundingMoneypercent2"
													value="${(moneyPercentList2.fundingMoney / moneyPercentList2.goalMoney)*100}"
													pattern=".00" />
												<fmt:formatNumber type="number" var="fundingMoney2"
													maxFractionDigits="3"
													value="${moneyPercentList2.fundingMoney}" />
												<p>${fundingMoney2}원${fundingMoneypercent2}%진행중</p>
												<div class="progress">
													<div class="progress-bar color-7" role="progressbar"
														style="width: ${fundingMoneypercent2}%" aria-valuenow="30"
														aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</div>
										</div>
									</div>
								</article>
							</c:forEach>
						</section>
					</div>
					<!-- 3번째 페이지 시작 -->

					<div class="carousel-item">
						<section class="tiles pt-0 mt-0">
							<c:forEach var="moneyPercentList3" items="${moneyPercentList3}">
								<article>
									<div class="project">
										<div class="thumbnail-wrap">
											<div class="thumbnail">
												<div class="centered">
													<img src="${moneyPercentList3.projectMainImage}"
														class="card-img-top landscape" alt="이미지를 찾지 못했습니다.">
												</div>
											</div>
										</div>
										<h5>타이틀${moneyPercentList3.projectTitle}</h5>
										<ul>
											<li>서브타이틀${moneyPercentList3.projectSubTitle}</li>

										</ul>
										<div class="mt-10">
											<div class="percentage">

												<fmt:formatNumber type="number" var="fundingMoneypercent3"
													value="${(moneyPercentList3.fundingMoney / moneyPercentList3.goalMoney)*100}"
													pattern=".00" />
												<fmt:formatNumber type="number" var="fundingMoney3"
													maxFractionDigits="3"
													value="${moneyPercentList3.fundingMoney}" />
												<p>${fundingMoney3}원${fundingMoneypercent3}%진행중</p>
												<div class="progress">
													<div class="progress-bar color-7" role="progressbar"
														style="width: ${fundingMoneypercent3}%" aria-valuenow="30"
														aria-valuemin="0" aria-valuemax="100"></div>
												</div>
											</div>
										</div>
									</div>
								</article>
							</c:forEach>
						</section>
					</div>
					<!-- 3번째 끝 -->

					<a class="carousel-control-prev" href="#moneyPercentListControls"
						role="button" data-slide="prev"> <span
						class="carousel-control-prev-icon" style="background-color: black;" aria-hidden="true"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="carousel-control-next" href="#moneyPercentListControls"
						role="button" data-slide="next"> <span
						class="carousel-control-next-icon" style="background-color: black;" aria-hidden="true"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>



			<hr>
		</div>



	</section>

	<jsp:include page="./include/i-footer.jsp" />


	<jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
	<jsp:include page="./include/i-body-js.jsp"></jsp:include>


</body>

</html>