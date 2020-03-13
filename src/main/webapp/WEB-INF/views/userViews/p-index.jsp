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
   <div id="carouselExampleInterval" class="carousel slide" data-ride="carousel">

  <div class="carousel-inner">

     <c:if test="${not empty getUserMainImageChangeList2}">
   <div class="carousel-item active" data-interval="500">
      <img style="width: 100px; height: 300px;" src="${getUserMainImageChangeList2.imagePath}" class="d-block w-100" alt="...">
   		<div class="carousel-caption d-none d-md-block">
   		<c:if test="${not empty getUserMainImageChangeList2.imageContent}">
        	<h5 style="color: black; margin-bottom: 10px;" align="left">${getUserMainImageChangeList2.imageContent}</h5>
        </c:if>	
     	 </div>
   </div>
   </c:if>
   
 
  <c:if test="${not empty getUserMainImageChangeList3}">

   <c:forEach var="mainImageList" items="${getUserMainImageChangeList3}">
  
    <div class="carousel-item" data-interval="500">
      <img style="width: 100px; height: 300px;" src="${mainImageList.imagePath}" class="d-block w-100" alt="...">
      	<div class="carousel-caption d-none d-md-block">
      	<c:if test="${not empty mainImageList.imageContent}">
        	<h5 style="color: black; margin-bottom: 10px;" align="left">${mainImageList.imageContent}</h5>
        	</c:if>
     	 </div>
    </div>
   </c:forEach>
   </c:if>

    
  </div>
  
  <a class="carousel-control-prev" href="#carouselExampleInterval" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleInterval" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
   <!-- slider_area_end -->


   <section class="container">


      <div>
         <div class="h3 pt-5 d-flex justify-content-between">
            <a href="javaScript: return(0);">주목할 만한 프로젝트<i class="fas fa-chevron-right"></i></a>

         </div>
         <section class="tiles pt-0 mt-0 js-slidein block">

            <!-- 올라온 프로젝트들 목록 표시-->
            <!-- 기본셋팅은 목록에는 진행중인 프로젝트 전체 목록 표시-->
            <!---------- 일반 펀딩 목록 보는 양식------ img class 에 가로가 긴 이미지면 landscape 세로가 길면 portrait -->
            <c:forEach var="mainProject" items="${userMainFocusList}">
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
                  <h5>${mainProject.projectTitle}</h5>
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
            </c:forEach>
            <!-- 추가적으로 목록들 생길 시 JSTL로 반복 추가-->
         </section>
         <hr>
      </div>

         <div class="h3 pt-5 d-flex justify-content-between js-slidein block">
            <a href="javaScript: return(0);">진행중인 기획전 <i class="fas fa-chevron-right"></i></a>

         </div>
         
       	<ul class="nav justify-content-end">
		  <li class="nav-item">
		    <a class="nav-link active" id="exhibition1-tab" data-toggle="tab" href="#exhibition1" role="tab" aria-controls="exhibition1" aria-selected="true">1</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="exhibition2-tab" data-toggle="tab" href="#exhibition2" role="tab" aria-controls="exhibition2" aria-selected="false">2</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="exhibition3-tab" data-toggle="tab" href="#exhibition3" role="tab" aria-controls="exhibition3" aria-selected="false">3</a>
		  </li>
		</ul>

		<div class="tab-content" id="myTabContent">
			<div class="tab-pane fade show active" id="exhibition1" role="tabpanel"
				aria-labelledby="exhibition1-tab">
				<section class="tiles pt-0 mt-0">
					<c:forEach var="progressList" items="${progressList}"
						varStatus="step">
						<article>
							<div class="project">
								<div class="thumbnail-wrap">
									<div class="thumbnail">
										<div class="centered">
											<form id="projecImage${step.count }"
												action="projectDetails.udo" method="GET">
												<input type="hidden" name="projectNo"
													value="${progressList.projectNo}"> <a
													href="javaScript: return(0);"
													onclick="document.getElementById('projecImage${step.count }').submit()">
													<c:choose>
														<c:when test="${progressList.projectMainImage eq '' }">
															<img
																src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg"
																class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
														</c:when>
														<c:when test="${progressList.projectMainImage ne '' }">
															<img src="${progressList.projectMainImage }"
																class="card-img-top landscape" alt="이미지를 찾지 못했습니다.">
														</c:when>
													</c:choose>
												</a>
											</form>
										</div>
									</div>
								</div>
								<h5>${progressList.projectTitle}</h5>
								<ul>
									<li>${progressList.projectSubTitle}</li>

								</ul>
								<div class="mt-10">
									<div class="percentage">
										<fmt:formatNumber type="number" var="progressPercent"
											value="${(progressList.fundingMoney / progressList.goalMoney)*100}"
											pattern=".00" />
										<fmt:formatNumber type="number" var="progress"
											maxFractionDigits="3" value="${progressList.fundingMoney}" />
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


			<div class="tab-pane fade" id="exhibition2" role="tabpanel"
				aria-labelledby="exhibition2-tab">

		        <section class="tiles pt-0 mt-0">
		           <c:forEach var="progressList2" items="${progressList2}" varStatus="step">
		              <article>
		                 <div class="project">
		                    <div class="thumbnail-wrap">
		                       <div class="thumbnail">
		                          <div class="centered">
		                             <form id="projecImage${step.count }" action="projectDetails.udo" method="GET">
		                                 <input type="hidden" name="projectNo" value="${progressList2.projectNo}">
		                                            <a href="javaScript: return(0);" onclick="document.getElementById('projecImage${step.count }').submit()">
		                                               <c:choose>
		                                                 <c:when test="${progressList2.projectMainImage eq '' }">
		                                                       <img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
		                                                          class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                                 </c:when>
		                                                 <c:when test="${progressList2.projectMainImage ne '' }">
		                                                    <img src="${progressList2.projectMainImage }" class="card-img-top landscape" alt="이미지를 찾지 못했습니다.">
		                                                 </c:when>
		                                               </c:choose>  
		                                            </a>
		                                       </form>
		                          </div>
		                       </div>
		                    </div>
		                    <h5>${progressList2.projectTitle}</h5>
		                    <ul>
		                       <li>${progressList2.projectSubTitle}</li>
		
		                    </ul>
		                    <div class="mt-10">
		                       <div class="percentage">
		                          <fmt:formatNumber type="number" var="progressPercent"
		                             value="${(progressList2.fundingMoney / progressList2.goalMoney)*100}"
		                             pattern=".00" />
		                          <fmt:formatNumber type="number" var="progress"
		                             maxFractionDigits="3" value="${progressList2.fundingMoney}" />
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
			
			<div class="tab-pane fade" id="exhibition3" role="tabpanel"
				aria-labelledby="exhibition3-tab">
				<section class="tiles pt-0 mt-0">
			        <c:forEach var="progressList3" items="${progressList3}" varStatus="step">
			           <article>
			              <div class="project">
			                 <div class="thumbnail-wrap">
			                    <div class="thumbnail">
			                       <div class="centered">
			                          <form id="projecImage${step.count }" action="projectDetails.udo" method="GET">
			                              <input type="hidden" name="projectNo" value="${progressList3.projectNo}">
			                                         <a href="javaScript: return(0);" onclick="document.getElementById('projecImage${step.count }').submit()">
			                                            <c:choose>
			                                              <c:when test="${progressList3.projectMainImage eq '' }">
			                                                    <img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
			                                                       class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
			                                              </c:when>
			                                              <c:when test="${progressList3.projectMainImage ne '' }">
			                                                 <img src="${progressList3.projectMainImage }" class="card-img-top landscape" alt="이미지를 찾지 못했습니다.">
			                                              </c:when>
			                                            </c:choose>  
			                                         </a>
			                                    </form>
			                       </div>
			                    </div>
			                 </div>
			                 <h5>${progressList3.projectTitle}</h5>
			                 <ul>
			                    <li>${progressList3.projectSubTitle}</li>
			
			                 </ul>
			                 <div class="mt-10">
			                    <div class="percentage">
			                       <fmt:formatNumber type="number" var="progressPercent"
			                          value="${(progressList3.fundingMoney / progressList3.goalMoney)*100}"
			                          pattern=".00" />
			                       <fmt:formatNumber type="number" var="progress"
			                          maxFractionDigits="3" value="${progressList3.fundingMoney}" />
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
		</div>


		<hr>
		
         <div class="h3 pt-5 d-flex justify-content-between js-slidein block">
            <a href="getAllLikeCountList.udo">인기 프로젝트 <i class="fas fa-chevron-right"></i></a>

         </div>
         
        <ul class="nav justify-content-end">
		  <li class="nav-item">
		    <a class="nav-link active" id="popular1-tab" data-toggle="tab" href="#popular1" role="tab" aria-controls="popular1" aria-selected="true">1</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="popular2-tab" data-toggle="tab" href="#popular2" role="tab" aria-controls="popular2" aria-selected="false">2</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="popular3-tab" data-toggle="tab" href="#popular3" role="tab" aria-controls="popular3" aria-selected="false">3</a>
		  </li>
		</ul>

		<div class="tab-content" id="myTabContent">
			<div class="tab-pane fade show active" id="popular1" role="tabpanel"
				aria-labelledby="popular1-tab">
				<section class="tiles pt-0 mt-0">
					<c:forEach var="likeCount" items="${likeCountList}"
						varStatus="step">
						<article>
							<div class="project">
								<div class="thumbnail-wrap">
									<div class="thumbnail">
										<div class="centered">
											<form id="projecImage${step.count }"
												action="projectDetails.udo" method="GET">
												<input type="hidden" name="projectNo"
													value="${likeCount.projectNo}"> <a
													href="javaScript: return(0);"
													onclick="document.getElementById('projecImage${step.count }').submit()">
													<c:choose>
														<c:when test="${likeCount.projectMainImage eq '' }">
															<img
																src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg"
																class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
														</c:when>
														<c:when test="${likeCount.projectMainImage ne '' }">
															<img src="${likeCount.projectMainImage }"
																class="card-img-top landscape" alt="이미지를 찾지 못했습니다.">
														</c:when>
													</c:choose>
												</a>
											</form>
										</div>
									</div>
								</div>
								<h5>${likeCount.projectTitle}</h5>
								<ul>
									<li>${likeCount.projectSubTitle}</li>

								</ul>
								<div class="mt-10">
									<div class="percentage">
										<fmt:formatNumber type="number" var="progressPercent"
											value="${(likeCount.fundingMoney / likeCount.goalMoney)*100}"
											pattern=".00" />
										<fmt:formatNumber type="number" var="progress"
											maxFractionDigits="3" value="${likeCount.fundingMoney}" />
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
			<div class="tab-pane fade" id="popular2" role="tabpanel"
				aria-labelledby="popular2-tab">
				<section class="tiles pt-0 mt-0">
					<c:forEach var="likeCount2" items="${likeCountList2}"
						varStatus="step">
						<article>
							<div class="project">
								<div class="thumbnail-wrap">
									<div class="thumbnail">
										<div class="centered">
											<form id="projecImage${step.count }"
												action="projectDetails.udo" method="GET">
												<input type="hidden" name="projectNo"
													value="${likeCount2.projectNo}"> <a
													href="javaScript: return(0);"
													onclick="document.getElementById('projecImage${step.count }').submit()">
													<c:choose>
														<c:when test="${likeCount2.projectMainImage eq '' }">
															<img
																src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg"
																class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
														</c:when>
														<c:when test="${likeCount2.projectMainImage ne '' }">
															<img src="${likeCount2.projectMainImage }"
																class="card-img-top landscape" alt="이미지를 찾지 못했습니다.">
														</c:when>
													</c:choose>
												</a>
											</form>
										</div>
									</div>
								</div>
								<h5>${likeCount2.projectTitle}</h5>
								<ul>
									<li>${likeCount2.projectSubTitle}</li>

								</ul>
								<div class="mt-10">
									<div class="percentage">
										<fmt:formatNumber type="number" var="progressPercent"
											value="${(likeCount2.fundingMoney / likeCount2.goalMoney)*100}"
											pattern=".00" />
										<fmt:formatNumber type="number" var="progress"
											maxFractionDigits="3" value="${likeCount2.fundingMoney}" />
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
			<div class="tab-pane fade" id="popular3" role="tabpanel"
				aria-labelledby="popular3-tab">
				<section class="tiles pt-0 mt-0">
					<c:forEach var="likeCount3" items="${likeCountList3}"
						varStatus="step">
						<article>
							<div class="project">
								<div class="thumbnail-wrap">
									<div class="thumbnail">
										<div class="centered">
											<form id="projecImage${step.count }"
												action="projectDetails.udo" method="GET">
												<input type="hidden" name="projectNo"
													value="${likeCount3.projectNo}"> <a
													href="javaScript: return(0);"
													onclick="document.getElementById('projecImage${step.count }').submit()">
													<c:choose>
														<c:when test="${likeCount3.projectMainImage eq '' }">
															<img
																src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg"
																class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
														</c:when>
														<c:when test="${likeCount3.projectMainImage ne '' }">
															<img src="${likeCount3.projectMainImage }"
																class="card-img-top landscape" alt="이미지를 찾지 못했습니다.">
														</c:when>
													</c:choose>
												</a>
											</form>
										</div>
									</div>
								</div>
								<h5>${likeCount3.projectTitle}</h5>
								<ul>
									<li>${likeCount3.projectSubTitle}</li>

								</ul>
								<div class="mt-10">
									<div class="percentage">
										<fmt:formatNumber type="number" var="progressPercent"
											value="${(likeCount3.fundingMoney / likeCount3.goalMoney)*100}"
											pattern=".00" />
										<fmt:formatNumber type="number" var="progress"
											maxFractionDigits="3" value="${likeCount3.fundingMoney}" />
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
		</div>
		
		<hr>

         <div class="h3 pt-5 d-flex justify-content-between js-slidein block">
            <a href="javaScript: return(0);">성공 임박 프로젝트<i class="fas fa-chevron-right"></i></a>
         </div>
         
         
         
       	<ul class="nav justify-content-end">
		  <li class="nav-item">
		    <a class="nav-link active" id="success1-tab" data-toggle="tab" href="#success1" role="tab" aria-controls="success1" aria-selected="true">1</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="success2-tab" data-toggle="tab" href="#success2" role="tab" aria-controls="success2" aria-selected="false">2</a>
		  </li>
		  <li class="nav-item">
		    <a class="nav-link" id="success3-tab" data-toggle="tab" href="#success3" role="tab" aria-controls="success3" aria-selected="false">3</a>
		  </li>
		</ul>

		<div class="tab-content" id="myTabContent">
			<div class="tab-pane fade show active" id="success1" role="tabpanel"
				aria-labelledby="success1-tab">
				 <section class="tiles pt-0 mt-0">
                     <c:forEach var="moneyPercentList1" items="${moneyPercentList}" varStatus="step">
                        <article>
                           <div class="project">
                              <div class="thumbnail-wrap">
                                 <div class="thumbnail">
                                    <div class="centered">
                                       <form id="projecImage${step.count }" action="projectDetails.udo" method="GET">
                                           <input type="hidden" name="projectNo" value="${moneyPercentList1.projectNo}">
                                                      <a href="javaScript: return(0);" onclick="document.getElementById('projecImage${step.count }').submit()">
                                                         <c:choose>
                                                           <c:when test="${moneyPercentList1.projectMainImage eq '' }">
                                                                 <img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
                                                                    class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
                                                           </c:when>
                                                           <c:when test="${moneyPercentList1.projectMainImage ne '' }">
                                                              <img src="${moneyPercentList1.projectMainImage }" class="card-img-top landscape" alt="이미지를 찾지 못했습니다.">
                                                           </c:when>
                                                         </c:choose>  
                                                      </a>
                                                 </form>
                                    </div>
                                 </div>
                              </div>
                              <h5>${moneyPercentList1.projectTitle}</h5>
                              <ul>
                                 <li>${moneyPercentList1.projectSubTitle}</li>

                              </ul>
                              <div class="mt-10">
                                 <div class="percentage">
                                    <fmt:formatNumber type="number" var="progressPercent"
                                       value="${(moneyPercentList1.fundingMoney / moneyPercentList1.goalMoney)*100}"
                                       pattern=".00" />
                                    <fmt:formatNumber type="number" var="progress"
                                       maxFractionDigits="3" value="${moneyPercentList1.fundingMoney}" />
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
			<div class="tab-pane fade" id="success2" role="tabpanel"
				aria-labelledby="success2-tab">
			     <section class="tiles pt-0 mt-0">
                     <c:forEach var="moneyPercentList2" items="${moneyPercentList2}" varStatus="step">
                        <article>
                           <div class="project">
                              <div class="thumbnail-wrap">
                                 <div class="thumbnail">
                                    <div class="centered">
                                       <form id="projecImage${step.count }" action="projectDetails.udo" method="GET">
                                           <input type="hidden" name="projectNo" value="${moneyPercentList2.projectNo}">
                                                      <a href="javaScript: return(0);" onclick="document.getElementById('projecImage${step.count }').submit()">
                                                         <c:choose>
                                                           <c:when test="${moneyPercentList2.projectMainImage eq '' }">
                                                                 <img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
                                                                    class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
                                                           </c:when>
                                                           <c:when test="${moneyPercentList2.projectMainImage ne '' }">
                                                              <img src="${moneyPercentList2.projectMainImage }" class="card-img-top landscape" alt="이미지를 찾지 못했습니다.">
                                                           </c:when>
                                                         </c:choose>  
                                                      </a>
                                                 </form>
                                    </div>
                                 </div>
                              </div>
                              <h5>${moneyPercentList2.projectTitle}</h5>
                              <ul>
                                 <li>${moneyPercentList2.projectSubTitle}</li>

                              </ul>
                              <div class="mt-10">
                                 <div class="percentage">
                                    <fmt:formatNumber type="number" var="progressPercent"
                                       value="${(moneyPercentList2.fundingMoney / moneyPercentList2.goalMoney)*100}"
                                       pattern=".00" />
                                    <fmt:formatNumber type="number" var="progress"
                                       maxFractionDigits="3" value="${moneyPercentList2.fundingMoney}" />
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
			<div class="tab-pane fade" id="success3" role="tabpanel"
				aria-labelledby="success3-tab">
				<section class="tiles pt-0 mt-0">
                     <c:forEach var="moneyPercentList3" items="${moneyPercentList3}" varStatus="step">
                        <article>
                           <div class="project">
                              <div class="thumbnail-wrap">
                                 <div class="thumbnail">
                                    <div class="centered">
                                       <form id="projecImage${step.count }" action="projectDetails.udo" method="GET">
                                           <input type="hidden" name="projectNo" value="${moneyPercentList3.projectNo}">
                                                      <a href="javaScript: return(0);" onclick="document.getElementById('projecImage${step.count }').submit()">
                                                         <c:choose>
                                                           <c:when test="${moneyPercentList3.projectMainImage eq '' }">
                                                                 <img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
                                                                    class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
                                                           </c:when>
                                                           <c:when test="${moneyPercentList3.projectMainImage ne '' }">
                                                              <img src="${moneyPercentList3.projectMainImage }" class="card-img-top landscape" alt="이미지를 찾지 못했습니다.">
                                                           </c:when>
                                                         </c:choose>  
                                                      </a>
                                                 </form>
                                    </div>
                                 </div>
                              </div>
                              <h5>${moneyPercentList3.projectTitle}</h5>
                              <ul>
                                 <li>${moneyPercentList3.projectSubTitle}</li>

                              </ul>
                              <div class="mt-10">
                                 <div class="percentage">
                                    <fmt:formatNumber type="number" var="progressPercent"
                                       value="${(moneyPercentList3.fundingMoney / moneyPercentList3.goalMoney)*100}"
                                       pattern=".00" />
                                    <fmt:formatNumber type="number" var="progress"
                                       maxFractionDigits="3" value="${moneyPercentList3.fundingMoney}" />
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
		</div>

		<hr>

        <div class="h3 pt-5 d-flex justify-content-between js-slidein block">
           <a href="javaScript: return(0);">마감 임박 프로젝트<i class="fas fa-chevron-right"></i></a>
        </div>

		<ul class="nav justify-content-end">
			<li class="nav-item"><a class="nav-link active"
				id="deadline1-tab" data-toggle="tab" href="#deadline1" role="tab"
				aria-controls="deadline1" aria-selected="true">1</a></li>
			<li class="nav-item"><a class="nav-link" id="deadline2-tab"
				data-toggle="tab" href="#deadline2" role="tab"
				aria-controls="deadline2" aria-selected="false">2</a></li>
			<li class="nav-item"><a class="nav-link" id="deadline3-tab"
				data-toggle="tab" href="#deadline3" role="tab"
				aria-controls="deadline3" aria-selected="false">3</a></li>
		</ul>

		<div class="tab-content" id="myTabContent">
			<div class="tab-pane fade show active" id="deadline1" role="tabpanel"
				aria-labelledby="deadline1-tab">
				<section class="tiles pt-0 mt-0">
                     <c:forEach var="deadLineList" items="${deadLineList}" varStatus="step">
                        <article>
                           <div class="project">
                              <div class="thumbnail-wrap">
                                 <div class="thumbnail">
                                    <div class="centered">
                                       <form id="projecImage${step.count }" action="projectDetails.udo" method="GET">
                                           <input type="hidden" name="projectNo" value="${deadLineList.projectNo}">
                                                      <a href="javaScript: return(0);" onclick="document.getElementById('projecImage${step.count }').submit()">
                                                         <c:choose>
                                                           <c:when test="${deadLineList.projectMainImage eq '' }">
                                                                 <img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
                                                                    class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
                                                           </c:when>
                                                           <c:when test="${deadLineList.projectMainImage ne '' }">
                                                              <img src="${deadLineList.projectMainImage }" class="card-img-top landscape" alt="이미지를 찾지 못했습니다.">
                                                           </c:when>
                                                         </c:choose>  
                                                      </a>
                                                 </form>
                                    </div>
                                 </div>
                              </div>
                              <h5>${deadLineList.projectTitle}</h5>
                              <ul>
                                 <li>${deadLineList.projectSubTitle}</li>

                              </ul>
                              <div class="mt-10">
                                 <div class="percentage">
                                    <fmt:formatNumber type="number" var="progressPercent"
                                       value="${(deadLineList.fundingMoney / deadLineList.goalMoney)*100}"
                                       pattern=".00" />
                                    <fmt:formatNumber type="number" var="progress"
                                       maxFractionDigits="3" value="${deadLineList.fundingMoney}" />
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
			<div class="tab-pane fade" id="deadline2" role="tabpanel"
				aria-labelledby="deadline3-tab">
				<section class="tiles pt-0 mt-0">
                     <c:forEach var="deadLineList2" items="${deadLineList2}" varStatus="step">
                        <article>
                           <div class="project">
                              <div class="thumbnail-wrap">
                                 <div class="thumbnail">
                                    <div class="centered">
                                       <form id="projecImage${step.count }" action="projectDetails.udo" method="GET">
                                           <input type="hidden" name="projectNo" value="${deadLineList2.projectNo}">
                                                      <a href="javaScript: return(0);" onclick="document.getElementById('projecImage${step.count }').submit()">
                                                         <c:choose>
                                                           <c:when test="${deadLineList2.projectMainImage eq '' }">
                                                                 <img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
                                                                    class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
                                                           </c:when>
                                                           <c:when test="${deadLineList2.projectMainImage ne '' }">
                                                              <img src="${deadLineList2.projectMainImage }" class="card-img-top landscape" alt="이미지를 찾지 못했습니다.">
                                                           </c:when>
                                                         </c:choose>  
                                                      </a>
                                                 </form>
                                    </div>
                                 </div>
                              </div>
                              <h5>${deadLineList2.projectTitle}</h5>
                              <ul>
                                 <li>${deadLineList2.projectSubTitle}</li>

                              </ul>
                              <div class="mt-10">
                                 <div class="percentage">
                                    <fmt:formatNumber type="number" var="progressPercent"
                                       value="${(deadLineList2.fundingMoney / deadLineList2.goalMoney)*100}"
                                       pattern=".00" />
                                    <fmt:formatNumber type="number" var="progress"
                                       maxFractionDigits="3" value="${deadLineList2.fundingMoney}" />
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
			<div class="tab-pane fade" id="deadline3" role="tabpanel"
				aria-labelledby="deadline3-tab">
				<section class="tiles pt-0 mt-0">
                     <c:forEach var="deadLineList3" items="${deadLineList3}" varStatus="step">
                        <article>
                           <div class="project">
                              <div class="thumbnail-wrap">
                                 <div class="thumbnail">
                                    <div class="centered">
                                       <form id="projecImage${step.count }" action="projectDetails.udo" method="GET">
                                           <input type="hidden" name="projectNo" value="${deadLineList3.projectNo}">
                                                      <a href="javaScript: return(0);" onclick="document.getElementById('projecImage${step.count }').submit()">
                                                         <c:choose>
                                                           <c:when test="${deadLineList3.projectMainImage eq '' }">
                                                                 <img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
                                                                    class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
                                                           </c:when>
                                                           <c:when test="${deadLineList3.projectMainImage ne '' }">
                                                              <img src="${deadLineList3.projectMainImage }" class="card-img-top landscape" alt="이미지를 찾지 못했습니다.">
                                                           </c:when>
                                                         </c:choose>  
                                                      </a>
                                                 </form>
                                    </div>
                                 </div>
                              </div>
                              <h5>${deadLineList3.projectTitle}</h5>
                              <ul>
                                 <li>${deadLineList3.projectSubTitle}</li>

                              </ul>
                              <div class="mt-10">
                                 <div class="percentage">
                                    <fmt:formatNumber type="number" var="progressPercent"
                                       value="${(deadLineList3.fundingMoney / deadLineList3.goalMoney)*100}"
                                       pattern=".00" />
                                    <fmt:formatNumber type="number" var="progress"
                                       maxFractionDigits="3" value="${deadLineList3.fundingMoney}" />
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
		</div>

            
   </section>

   <jsp:include page="./include/i-footer.jsp" />


   <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
   <jsp:include page="./include/i-popup-search.jsp"></jsp:include>
   <jsp:include page="./include/i-body-js.jsp"></jsp:include>
  
  
</body>

</html>