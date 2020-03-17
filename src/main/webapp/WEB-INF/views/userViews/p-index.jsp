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
      <img style="width: 100px; height: 750px;" src="${getUserMainImageChangeList2.imagePath}" class="d-block w-100" alt="...">
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
      <img style="width: 100px; height: 750px;" src="${mainImageList.imagePath}" class="d-block w-100" alt="...">
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
            <a href="javaScript: return(0);" style="color: #333333; font-weight:500;">주목할 만한 프로젝트<i class="fas fa-chevron-right"></i></a>

         </div>
         
         <section class="tiles pt-0 mt-0 js-slidein block">
				
           <c:forEach var="fundingProject" items="${userMainFocusList }" varStatus="step">
                
	                <article class="js-slidein block" >
	                    <div class="project">
	                        <div class="thumbnail-wrap">
	                            <div class="thumbnail">
	                                <div class="centered">
										<form id="projecImage${step.count }" action="projectDetails.udo" method="GET">
										    <input type="hidden" name="projectNo" value="${fundingProject.projectNo}">
                                       		<a href="#" onclick="document.getElementById('projecImage${step.count }').submit()">
                                       			<c:choose>
	                                         		<c:when test="${fundingProject.projectMainImage eq '' }">
	                                         				<img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
	                                         					class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
	                                         		</c:when>
	                                         		<c:when test="${fundingProject.projectMainImage ne '' }">
	                                         			<img src="${fundingProject.projectMainImage }" class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
	                                         		</c:when>
                                       			</c:choose>  
                                       		</a>
                                        </form>
	                                </div>
	                            </div>
	                        </div>
	                        
	                        <div class="h5 p-2" style="color: black; font-weight: 500; min-height:70px; ">${fundingProject.projectTitle }</div>
	                        <ul>
	                            <li style="color: gray;">by ${fundingProject.creator }</li>
	                        </ul>
	                        <div class="mt-10">
								<div class="percentage">
									<fmt:formatNumber type="number" var="progressPercent"
										value="${(fundingProject.fundingMoney / fundingProject.goalMoney)*100}"
										pattern=".00" />
									<fmt:formatNumber type="number" var="progress"
										maxFractionDigits="3" value="${fundingProject.fundingMoney}" />
									<p>${progress}원${progressPercent}%진행중</p>

									<div class="progress" style=" height: 7px;">
										<div class="progress-bar" role="progressbar"
											style="width: ${progressPercent}%; background-color: #ff9999;" aria-valuenow="30"
											aria-valuemin="0" aria-valuemax="100"></div>
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
            <a href="javaScript: return(0);" style=" color: #333333;">진행중인 기획전 <i class="fas fa-chevron-right"></i></a>

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
					<c:forEach var="fundingProject" items="${progressList }" varStatus="step">
                
		                <article class="js-slidein block">
		                    <div class="project">
		                        <div class="thumbnail-wrap">
		                            <div class="thumbnail">
		                                <div class="centered">
											<form id="projecImage${step.count }" action="projectDetails.udo" method="GET">
											    <input type="hidden" name="projectNo" value="${fundingProject.projectNo}">
	                                       		<a href="#" onclick="document.getElementById('projecImage${step.count }').submit()">
	                                       			<c:choose>
		                                         		<c:when test="${fundingProject.projectMainImage eq '' }">
		                                         				<img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
		                                         					class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                         		</c:when>
		                                         		<c:when test="${fundingProject.projectMainImage ne '' }">
		                                         			<img src="${fundingProject.projectMainImage }" class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                         		</c:when>
	                                       			</c:choose>  
	                                       		</a>
	                                        </form>
		                                </div>
		                            </div>
		                        </div>
		                        
		                        <div class="h5 p-2" style="color: black; font-weight: 500; min-height:70px; ">${fundingProject.projectTitle }</div>
		                        <ul>
		                            <li style="color: gray;">by ${fundingProject.creator }</li>
		                        </ul>
		                        <div class="mt-10">
									<div class="percentage">
										<fmt:formatNumber type="number" var="progressPercent"
											value="${(fundingProject.fundingMoney / fundingProject.goalMoney)*100}"
											pattern=".00" />
										<fmt:formatNumber type="number" var="progress"
											maxFractionDigits="3" value="${fundingProject.fundingMoney}" />
										<p>${progress}원${progressPercent}%진행중</p>
	
										<div class="progress" style=" height: 7px;">
											<div class="progress-bar" role="progressbar"
												style="width: ${progressPercent}%; background-color: #ff9999;" aria-valuenow="30"
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
		           	<c:forEach var="fundingProject" items="${progressList2 }" varStatus="step">
		                <article class="js-slidein block">
		                    <div class="project">
		                        <div class="thumbnail-wrap">
		                            <div class="thumbnail">
		                                <div class="centered">
											<form id="projecImage${step.count }" action="projectDetails.udo" method="GET">
											    <input type="hidden" name="projectNo" value="${fundingProject.projectNo}">
	                                       		<a href="#" onclick="document.getElementById('projecImage${step.count }').submit()">
	                                       			<c:choose>
		                                         		<c:when test="${fundingProject.projectMainImage eq '' }">
		                                         				<img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
		                                         					class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                         		</c:when>
		                                         		<c:when test="${fundingProject.projectMainImage ne '' }">
		                                         			<img src="${fundingProject.projectMainImage }" class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                         		</c:when>
	                                       			</c:choose>  
	                                       		</a>
	                                        </form>
		                                </div>
		                            </div>
		                        </div>
		                        
		                        <div class="h5 p-2" style="color: black; font-weight: 500; min-height:70px; ">${fundingProject.projectTitle }</div>
		                        <ul>
		                            <li style="color: gray;">by ${fundingProject.creator }</li>
		                        </ul>
		                        <div class="mt-10">
									<div class="percentage">
										<fmt:formatNumber type="number" var="progressPercent"
											value="${(fundingProject.fundingMoney / fundingProject.goalMoney)*100}"
											pattern=".00" />
										<fmt:formatNumber type="number" var="progress"
											maxFractionDigits="3" value="${fundingProject.fundingMoney}" />
										<p>${progress}원${progressPercent}%진행중</p>
	
										<div class="progress" style=" height: 7px;">
											<div class="progress-bar" role="progressbar"
												style="width: ${progressPercent}%; background-color: #ff9999;" aria-valuenow="30"
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
			        <c:forEach var="fundingProject" items="${likeCountList }" varStatus="step">
		                <article class="js-slidein block">
		                    <div class="project">
		                        <div class="thumbnail-wrap">
		                            <div class="thumbnail">
		                                <div class="centered">
											<form id="projecImage${step.count }" action="projectDetails.udo" method="GET">
											    <input type="hidden" name="projectNo" value="${fundingProject.projectNo}">
	                                       		<a href="#" onclick="document.getElementById('projecImage${step.count }').submit()">
	                                       			<c:choose>
		                                         		<c:when test="${fundingProject.projectMainImage eq '' }">
		                                         				<img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
		                                         					class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                         		</c:when>
		                                         		<c:when test="${fundingProject.projectMainImage ne '' }">
		                                         			<img src="${fundingProject.projectMainImage }" class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                         		</c:when>
	                                       			</c:choose>  
	                                       		</a>
	                                        </form>
		                                </div>
		                            </div>
		                        </div>
		                        
		                        <div class="h5 p-2" style="color: black; font-weight: 500; min-height:70px; ">${fundingProject.projectTitle }</div>
		                        <ul>
		                            <li style="color: gray;">by ${fundingProject.creator }</li>
		                        </ul>
		                        <div class="mt-10">
									<div class="percentage">
										<fmt:formatNumber type="number" var="progressPercent"
											value="${(fundingProject.fundingMoney / fundingProject.goalMoney)*100}"
											pattern=".00" />
										<fmt:formatNumber type="number" var="progress"
											maxFractionDigits="3" value="${fundingProject.fundingMoney}" />
										<p>${progress}원${progressPercent}%진행중</p>
	
										<div class="progress" style=" height: 7px;">
											<div class="progress-bar" role="progressbar"
												style="width: ${progressPercent}%; background-color: #ff9999;" aria-valuenow="30"
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
            <a href="getAllLikeCountList.udo" style=" color: #333333;">인기 프로젝트 <i class="fas fa-chevron-right"></i></a>

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
					<c:forEach var="fundingProject" items="${likeCountList }" varStatus="step">
		                <article class="js-slidein block">
		                    <div class="project">
		                        <div class="thumbnail-wrap">
		                            <div class="thumbnail">
		                                <div class="centered">
											<form id="projecImage${step.count }" action="projectDetails.udo" method="GET">
											    <input type="hidden" name="projectNo" value="${fundingProject.projectNo}">
	                                       		<a href="#" onclick="document.getElementById('projecImage${step.count }').submit()">
	                                       			<c:choose>
		                                         		<c:when test="${fundingProject.projectMainImage eq '' }">
		                                         				<img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
		                                         					class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                         		</c:when>
		                                         		<c:when test="${fundingProject.projectMainImage ne '' }">
		                                         			<img src="${fundingProject.projectMainImage }" class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                         		</c:when>
	                                       			</c:choose>  
	                                       		</a>
	                                        </form>
		                                </div>
		                            </div>
		                        </div>
		                        
		                        <div class="h5 p-2" style="color: black; font-weight: 500; min-height:70px; ">${fundingProject.projectTitle }</div>
		                        <ul>
		                            <li style="color: gray;">by ${fundingProject.creator }</li>
		                        </ul>
		                        <div class="mt-10">
									<div class="percentage">
										<fmt:formatNumber type="number" var="progressPercent"
											value="${(fundingProject.fundingMoney / fundingProject.goalMoney)*100}"
											pattern=".00" />
										<fmt:formatNumber type="number" var="progress"
											maxFractionDigits="3" value="${fundingProject.fundingMoney}" />
										<p>${progress}원${progressPercent}%진행중</p>
	
										<div class="progress" style=" height: 7px;">
											<div class="progress-bar" role="progressbar"
												style="width: ${progressPercent}%; background-color: #ff9999;" aria-valuenow="30"
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
					<c:forEach var="fundingProject" items="${likeCountList2 }" varStatus="step">
		                <article class="js-slidein block">
		                    <div class="project">
		                        <div class="thumbnail-wrap">
		                            <div class="thumbnail">
		                                <div class="centered">
											<form id="projecImage${step.count }" action="projectDetails.udo" method="GET">
											    <input type="hidden" name="projectNo" value="${fundingProject.projectNo}">
	                                       		<a href="#" onclick="document.getElementById('projecImage${step.count }').submit()">
	                                       			<c:choose>
		                                         		<c:when test="${fundingProject.projectMainImage eq '' }">
		                                         				<img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
		                                         					class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                         		</c:when>
		                                         		<c:when test="${fundingProject.projectMainImage ne '' }">
		                                         			<img src="${fundingProject.projectMainImage }" class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                         		</c:when>
	                                       			</c:choose>  
	                                       		</a>
	                                        </form>
		                                </div>
		                            </div>
		                        </div>
		                        
		                        <div class="h5 p-2" style="color: black; font-weight: 500; min-height:70px; ">${fundingProject.projectTitle }</div>
		                        <ul>
		                            <li style="color: gray;">by ${fundingProject.creator }</li>
		                        </ul>
		                        <div class="mt-10">
									<div class="percentage">
										<fmt:formatNumber type="number" var="progressPercent"
											value="${(fundingProject.fundingMoney / fundingProject.goalMoney)*100}"
											pattern=".00" />
										<fmt:formatNumber type="number" var="progress"
											maxFractionDigits="3" value="${fundingProject.fundingMoney}" />
										<p>${progress}원${progressPercent}%진행중</p>
	
										<div class="progress" style=" height: 7px;">
											<div class="progress-bar" role="progressbar"
												style="width: ${progressPercent}%; background-color: #ff9999;" aria-valuenow="30"
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
					<c:forEach var="fundingProject" items="${likeCountList3 }" varStatus="step">
		                <article class="js-slidein block">
		                    <div class="project">
		                        <div class="thumbnail-wrap">
		                            <div class="thumbnail">
		                                <div class="centered">
											<form id="projecImage${step.count }" action="projectDetails.udo" method="GET">
											    <input type="hidden" name="projectNo" value="${fundingProject.projectNo}">
	                                       		<a href="#" onclick="document.getElementById('projecImage${step.count }').submit()">
	                                       			<c:choose>
		                                         		<c:when test="${fundingProject.projectMainImage eq '' }">
		                                         				<img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
		                                         					class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                         		</c:when>
		                                         		<c:when test="${fundingProject.projectMainImage ne '' }">
		                                         			<img src="${fundingProject.projectMainImage }" class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                         		</c:when>
	                                       			</c:choose>  
	                                       		</a>
	                                        </form>
		                                </div>
		                            </div>
		                        </div>
		                        
		                        <div class="h5 p-2" style="color: black; font-weight: 500; min-height:70px; ">${fundingProject.projectTitle }</div>
		                        <ul>
		                            <li style="color: gray;">by ${fundingProject.creator }</li>
		                        </ul>
		                        <div class="mt-10">
									<div class="percentage">
										<fmt:formatNumber type="number" var="progressPercent"
											value="${(fundingProject.fundingMoney / fundingProject.goalMoney)*100}"
											pattern=".00" />
										<fmt:formatNumber type="number" var="progress"
											maxFractionDigits="3" value="${fundingProject.fundingMoney}" />
										<p>${progress}원${progressPercent}%진행중</p>
	
										<div class="progress" style=" height: 7px;">
											<div class="progress-bar" role="progressbar"
												style="width: ${progressPercent}%; background-color: #ff9999;" aria-valuenow="30"
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
            <a href="javaScript: return(0);" style=" color: #333333;">성공 임박 프로젝트<i class="fas fa-chevron-right"></i></a>
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
                     <c:forEach var="fundingProject" items="${moneyPercentList }" varStatus="step">
		                <article class="js-slidein block">
		                    <div class="project">
		                        <div class="thumbnail-wrap">
		                            <div class="thumbnail">
		                                <div class="centered">
											<form id="projecImage${step.count }" action="projectDetails.udo" method="GET">
											    <input type="hidden" name="projectNo" value="${fundingProject.projectNo}">
	                                       		<a href="#" onclick="document.getElementById('projecImage${step.count }').submit()">
	                                       			<c:choose>
		                                         		<c:when test="${fundingProject.projectMainImage eq '' }">
		                                         				<img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
		                                         					class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                         		</c:when>
		                                         		<c:when test="${fundingProject.projectMainImage ne '' }">
		                                         			<img src="${fundingProject.projectMainImage }" class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                         		</c:when>
	                                       			</c:choose>  
	                                       		</a>
	                                        </form>
		                                </div>
		                            </div>
		                        </div>
		                        
		                        <div class="h5 p-2" style="color: black; font-weight: 500; min-height:70px; ">${fundingProject.projectTitle }</div>
		                        <ul>
		                            <li style="color: gray;">by ${fundingProject.creator }</li>
		                        </ul>
		                        <div class="mt-10">
									<div class="percentage">
										<fmt:formatNumber type="number" var="progressPercent"
											value="${(fundingProject.fundingMoney / fundingProject.goalMoney)*100}"
											pattern=".00" />
										<fmt:formatNumber type="number" var="progress"
											maxFractionDigits="3" value="${fundingProject.fundingMoney}" />
										<p>${progress}원${progressPercent}%진행중</p>
	
										<div class="progress" style=" height: 7px;">
											<div class="progress-bar" role="progressbar"
												style="width: ${progressPercent}%; background-color: #ff9999;" aria-valuenow="30"
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
                     <c:forEach var="fundingProject" items="${moneyPercentList2 }" varStatus="step">
		                <article class="js-slidein block">
		                    <div class="project">
		                        <div class="thumbnail-wrap">
		                            <div class="thumbnail">
		                                <div class="centered">
											<form id="projecImage${step.count }" action="projectDetails.udo" method="GET">
											    <input type="hidden" name="projectNo" value="${fundingProject.projectNo}">
	                                       		<a href="#" onclick="document.getElementById('projecImage${step.count }').submit()">
	                                       			<c:choose>
		                                         		<c:when test="${fundingProject.projectMainImage eq '' }">
		                                         				<img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
		                                         					class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                         		</c:when>
		                                         		<c:when test="${fundingProject.projectMainImage ne '' }">
		                                         			<img src="${fundingProject.projectMainImage }" class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                         		</c:when>
	                                       			</c:choose>  
	                                       		</a>
	                                        </form>
		                                </div>
		                            </div>
		                        </div>
		                        
		                        <div class="h5 p-2" style="color: black; font-weight: 500; min-height:70px; ">${fundingProject.projectTitle }</div>
		                        <ul>
		                            <li style="color: gray;">by ${fundingProject.creator }</li>
		                        </ul>
		                        <div class="mt-10">
									<div class="percentage">
										<fmt:formatNumber type="number" var="progressPercent"
											value="${(fundingProject.fundingMoney / fundingProject.goalMoney)*100}"
											pattern=".00" />
										<fmt:formatNumber type="number" var="progress"
											maxFractionDigits="3" value="${fundingProject.fundingMoney}" />
										<p>${progress}원${progressPercent}%진행중</p>
	
										<div class="progress" style=" height: 7px;">
											<div class="progress-bar" role="progressbar"
												style="width: ${progressPercent}%; background-color: #ff9999;" aria-valuenow="30"
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
                     <c:forEach var="fundingProject" items="${moneyPercentList3 }" varStatus="step">
		                <article class="js-slidein block">
		                    <div class="project">
		                        <div class="thumbnail-wrap">
		                            <div class="thumbnail">
		                                <div class="centered">
											<form id="projecImage${step.count }" action="projectDetails.udo" method="GET">
											    <input type="hidden" name="projectNo" value="${fundingProject.projectNo}">
	                                       		<a href="#" onclick="document.getElementById('projecImage${step.count }').submit()">
	                                       			<c:choose>
		                                         		<c:when test="${fundingProject.projectMainImage eq '' }">
		                                         				<img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
		                                         					class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                         		</c:when>
		                                         		<c:when test="${fundingProject.projectMainImage ne '' }">
		                                         			<img src="${fundingProject.projectMainImage }" class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                         		</c:when>
	                                       			</c:choose>  
	                                       		</a>
	                                        </form>
		                                </div>
		                            </div>
		                        </div>
		                        
		                        <div class="h5 p-2" style="color: black; font-weight: 500; min-height:70px; ">${fundingProject.projectTitle }</div>
		                        <ul>
		                            <li style="color: gray;">by ${fundingProject.creator }</li>
		                        </ul>
		                        <div class="mt-10">
									<div class="percentage">
										<fmt:formatNumber type="number" var="progressPercent"
											value="${(fundingProject.fundingMoney / fundingProject.goalMoney)*100}"
											pattern=".00" />
										<fmt:formatNumber type="number" var="progress"
											maxFractionDigits="3" value="${fundingProject.fundingMoney}" />
										<p>${progress}원${progressPercent}%진행중</p>
	
										<div class="progress" style=" height: 7px;">
											<div class="progress-bar" role="progressbar"
												style="width: ${progressPercent}%; background-color: #ff9999;" aria-valuenow="30"
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
           <a href="javaScript: return(0);" style=" color: #333333;">마감 임박 프로젝트<i class="fas fa-chevron-right"></i></a>
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
                     <c:forEach var="fundingProject" items="${deadLineList }" varStatus="step">
		                <article class="js-slidein block">
		                    <div class="project">
		                        <div class="thumbnail-wrap">
		                            <div class="thumbnail">
		                                <div class="centered">
											<form id="projecImage${step.count }" action="projectDetails.udo" method="GET">
											    <input type="hidden" name="projectNo" value="${fundingProject.projectNo}">
	                                       		<a href="#" onclick="document.getElementById('projecImage${step.count }').submit()">
	                                       			<c:choose>
		                                         		<c:when test="${fundingProject.projectMainImage eq '' }">
		                                         				<img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
		                                         					class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                         		</c:when>
		                                         		<c:when test="${fundingProject.projectMainImage ne '' }">
		                                         			<img src="${fundingProject.projectMainImage }" class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                         		</c:when>
	                                       			</c:choose>  
	                                       		</a>
	                                        </form>
		                                </div>
		                            </div>
		                        </div>
		                        
		                        <div class="h5 p-2" style="color: black; font-weight: 500; min-height:70px; ">${fundingProject.projectTitle }</div>
		                        <ul>
		                            <li style="color: gray;">by ${fundingProject.creator }</li>
		                        </ul>
		                        <div class="mt-10">
									<div class="percentage">
										<fmt:formatNumber type="number" var="progressPercent"
											value="${(fundingProject.fundingMoney / fundingProject.goalMoney)*100}"
											pattern=".00" />
										<fmt:formatNumber type="number" var="progress"
											maxFractionDigits="3" value="${fundingProject.fundingMoney}" />
										<p>${progress}원${progressPercent}%진행중</p>
	
										<div class="progress" style=" height: 7px;">
											<div class="progress-bar" role="progressbar"
												style="width: ${progressPercent}%; background-color: #ff9999;" aria-valuenow="30"
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
                     <c:forEach var="fundingProject" items="${deadLineList2 }" varStatus="step">
		                <article class="js-slidein block">
		                    <div class="project">
		                        <div class="thumbnail-wrap">
		                            <div class="thumbnail">
		                                <div class="centered">
											<form id="projecImage${step.count }" action="projectDetails.udo" method="GET">
											    <input type="hidden" name="projectNo" value="${fundingProject.projectNo}">
	                                       		<a href="#" onclick="document.getElementById('projecImage${step.count }').submit()">
	                                       			<c:choose>
		                                         		<c:when test="${fundingProject.projectMainImage eq '' }">
		                                         				<img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
		                                         					class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                         		</c:when>
		                                         		<c:when test="${fundingProject.projectMainImage ne '' }">
		                                         			<img src="${fundingProject.projectMainImage }" class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                         		</c:when>
	                                       			</c:choose>  
	                                       		</a>
	                                        </form>
		                                </div>
		                            </div>
		                        </div>
		                        
		                        <div class="h5 p-2" style="color: black; font-weight: 500; min-height:70px; ">${fundingProject.projectTitle }</div>
		                        <ul>
		                            <li style="color: gray;">by ${fundingProject.creator }</li>
		                        </ul>
		                        <div class="mt-10">
									<div class="percentage">
										<fmt:formatNumber type="number" var="progressPercent"
											value="${(fundingProject.fundingMoney / fundingProject.goalMoney)*100}"
											pattern=".00" />
										<fmt:formatNumber type="number" var="progress"
											maxFractionDigits="3" value="${fundingProject.fundingMoney}" />
										<p>${progress}원${progressPercent}%진행중</p>
	
										<div class="progress" style=" height: 7px;">
											<div class="progress-bar" role="progressbar"
												style="width: ${progressPercent}%; background-color: #ff9999;" aria-valuenow="30"
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
                     <c:forEach var="fundingProject" items="${deadLineList3 }" varStatus="step">
		                <article class="js-slidein block">
		                    <div class="project">
		                        <div class="thumbnail-wrap">
		                            <div class="thumbnail">
		                                <div class="centered">
											<form id="projecImage${step.count }" action="projectDetails.udo" method="GET">
											    <input type="hidden" name="projectNo" value="${fundingProject.projectNo}">
	                                       		<a href="#" onclick="document.getElementById('projecImage${step.count }').submit()">
	                                       			<c:choose>
		                                         		<c:when test="${fundingProject.projectMainImage eq '' }">
		                                         				<img src="${pageContext.request.contextPath}/resources/user/img/elements/a.jpg" 
		                                         					class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                         		</c:when>
		                                         		<c:when test="${fundingProject.projectMainImage ne '' }">
		                                         			<img src="${fundingProject.projectMainImage }" class="card-img-top landscape" alt="내가만든 프로젝트 대표이미지">
		                                         		</c:when>
	                                       			</c:choose>  
	                                       		</a>
	                                        </form>
		                                </div>
		                            </div>
		                        </div>
		                        
		                        <div class="h5 p-2" style="color: black; font-weight: 500; min-height:70px; ">${fundingProject.projectTitle }</div>
		                        <ul>
		                            <li style="color: gray;">by ${fundingProject.creator }</li>
		                        </ul>
		                        <div class="mt-10">
									<div class="percentage">
										<fmt:formatNumber type="number" var="progressPercent"
											value="${(fundingProject.fundingMoney / fundingProject.goalMoney)*100}"
											pattern=".00" />
										<fmt:formatNumber type="number" var="progress"
											maxFractionDigits="3" value="${fundingProject.fundingMoney}" />
										<p>${progress}원${progressPercent}%진행중</p>
	
										<div class="progress" style=" height: 7px;">
											<div class="progress-bar" role="progressbar"
												style="width: ${progressPercent}%; background-color: #ff9999;" aria-valuenow="30"
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