<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!doctype html>

<html class="no-js">

<head>

	<jsp:include page="./include/i-head-setting.jsp"/>
  
</head>

<body>
  	
    <jsp:include page="./include/i-popupover-mypage.jsp"/>
    <jsp:include page="./include/i-header.jsp"/>

	<!-- ------------------ -->


	<div class="container ">
		<div class="container">
			<div class="row mx-lg-n5">

				<form id="getProgressSelectList" action="getShowCategoryList.udo"
					method="GET">
					<div class="col py-3 d-flex justify-content-start">
						<div class="input-group">


							<div class="input-group-btn">

								<script>
									$(document).ready(
											function() {
												$("#category").val().prop(
														"selected", true);
											});
								</script>

								<!-- category고르는곳 -->
								<select class="form-control" id="category" name="category">
									<option value="no">카테고리</option>
										<c:forEach var="category" items="${getAllCategoryList}">										
											<option value="${category.categoryName}">${category.categoryName}</option>
										</c:forEach>
								</select>
							</div>
							<!-- /btn-group -->


							<div class="input-group-btn">

								<!-- funding 진행상태 고르는곳 -->
								<select class="form-control" id="funding" name="funding">
									<option value="z">진행상태</option>
									<!-- 기본값셋팅 -->
									<option value="y">진행중인 펀딩</option>
									<option value="n">성공한 펀딩</option>
									<option value="n">실패한 펀딩</option>
									<option value="n">진행예정인 펀딩</option>
								</select>
							</div>
							<!-- /btn-group -->

							<div class="input-group-btn">

								<!-- fundingMoney 모인금액 범위 고르는곳 -->
								<select class="form-control" id="fundingMoney"
									name="fundingMoney">
									<option value=1>모인금액</option>
									<!-- 기본값셋팅 -->
									<option value=0>0원~500만원미만</option>
									<option value=5000000>500만원~1000만원미만</option>
									<option value=10000000>1000만원~1500만원미만</option>
									<option value=15000000>1500만원이상</option>
								</select>



							</div>
							<!-- /btn-group -->
							<!-- 달성률 fundingmoney/goalmoney *100 %율 고르는곳 -->
							<div class="input-group-btn ">

								<select class="form-control" id="percent" name="percent">
									<option value=1>프로젝트 달성률</option>
									<!-- 기본값셋팅 -->
									<option value="0">0~25%</option>
									<option value="25">26%~50%</option>
									<option value="50">51%~75%</option>
									<option value="75">76%~100%</option>

								</select>

							</div>
							<!-- /btn-group -->

							<div class="input-group-btn">

								<button type="submit" class="btn btn-outline-secondary">검색</button>


							</div>
							<!-- /btn-group -->
						</div>
					</div>

				</form>
			</div>
		</div>
	</div>

	<hr>
       <div class="container">
           
            <section class="tiles pl-5 pr-5">

	<!-- --------------------------------------------------전체보기------------------------------------------------------------------ -->
                <c:forEach var="fundingProject" items="${getAllFundingProjectList }" varStatus="step">
                
	                <article class="js-slidein block">
	                    <div class="project" >
	                        <div class="thumbnail-wrap m-2">
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
		                        
	                        <div class="h5 m-2" style="color: black; font-weight: 500; min-height:70px; ">${fundingProject.projectTitle }</div>
	                        <ul class="m-2">
	                            <li style="color: gray;">by ${fundingProject.creator }</li>
	                        </ul>
	                        <div class="m-2">
                        		<fmt:formatNumber type="number" var="progressPercent"
									value="${(fundingProject.fundingMoney / fundingProject.goalMoney)*100}"
									pattern=".00" />
								<fmt:formatNumber type="number" var="progress"
									maxFractionDigits="3" value="${fundingProject.fundingMoney}" />
                       			<fmt:formatNumber type="number" var="progressPercent"
								value="${(fundingProject.fundingMoney / fundingProject.goalMoney)*100}"
								pattern=".00" />
								<div class="percentage">
									<div class="progress" style=" height: 7px;">
										<div class="progress-bar" role="progressbar"
											style="width: ${progressPercent}%; background-color: #ff9999;" aria-valuenow="30"
											aria-valuemin="0" aria-valuemax="100"></div>
									</div>
									<p>${progress}원${progressPercent}%진행중</p>
								</div>
							</div>
		                </div>
	                </article>
                </c:forEach>
	<!-- ----------------------------------------------------------------------------------------------------------------------- -->
                
            </section>
        </div>




    <!-- footer -->
    <footer class="footer">
    </footer>
    
    <jsp:include page="./include/i-popup-login.jsp"></jsp:include>
	<jsp:include page="./include/i-popup-search.jsp"></jsp:include>
    <jsp:include page="./include/i-body-js.jsp"></jsp:include>
    
</body>
</html>