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
                    <div class="col py-3 d-flex justify-content-start">
                        <div class="input-group ">
                            <div class="input-group-btn">
                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
                                    aria-expanded="false">카테고리 <span class="caret"></span></button>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#">전체보기</a></li>
                                    <li class="dropdown-divider"></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li><a href="#">Separated link</a></li>
                                </ul>
                            </div><!-- /btn-group -->
                            <div class="input-group-btn">
                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
                                    aria-expanded="false">진행상태<span class="caret"></span></button>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#">전체보기</a></li>
                                    <li><a href="#">진행중인 프로젝트</a></li>
                                    <li class="dropdown-divider"></li>
                                    <li><a href="#">성공한 프로젝트</a></li>
                                    <li><a href="#">마감한 프로젝트</a></li>
                                    <li class="dropdown-divider"></li>
                                    <li><a href="#">마감임박 프로젝트</a></li>
                                </ul>
                            </div><!-- /btn-group -->
                            <div class="input-group-btn">
                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
                                    aria-expanded="false">모인금액 <span class="caret"></span></button>
                                <ul class="dropdown-menu" role="menu">

                                    <li><a href="#">Separated link</a></li>
                                </ul>
                            </div><!-- /btn-group -->
                            <div class="input-group-btn ">
                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
                                    aria-expanded="false">달성률 <span class="caret"></span></button>
                                <ul class="dropdown-menu" role="menu">
                                    <li><a href="#">Action</a></li>
                                    <li><a href="#">Another action</a></li>
                                    <li><a href="#">Something else here</a></li>
                                    <li class="divider"></li>
                                    <li><a href="#">Separated link</a></li>
                                </ul>
                            </div><!-- /btn-group -->
                        </div><!-- /input-group -->
                    </div><!-- <div class="row mx-lg-n5"> -->
                    <div class="col py-3">
                        <div class="d-flex justify-content-end">
                            <button type="button" class="btn btn-outline-secondary">필터 초기화</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <hr />

        <div class="container ">
            <div class="btn-group d-flex justify-content-end">
                <button type="button" class="btn btn-outline-secondary">인기순</button>
                <button type="button" class="btn btn-outline-secondary dropdown-toggle dropdown-toggle-split"
                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <span class="sr-only">Toggle Dropdown</span>
                </button>
                <div class="dropdown-menu">
                    <a class="dropdown-item" href="#"></a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Separated link</a>
                </div>
            </div>
        </div>
		<hr>

        <div class="container">
        
        
        
           
            <section class="tiles">
                <!-- 올라온 프로젝트들 목록 표시-->
                <!-- 기본셋팅은 목록에는 진행중인 프로젝트 전체 목록 표시-->
                <!---------- 일반 펀딩 목록 보는 양식------ img class 에 가로가 긴 이미지면 landscape 세로가 길면 portrait -->

	<!-- ----------------------------------------------------------------------------------------------------------------------- -->
                <c:forEach var="fundingProject" items="${getAllFundingProjectList }" varStatus="step">
                
	                <article>
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
	                        <h5>${fundingProject.projectTitle }</h5>
	                        <ul>
	                            <li>${fundingProject.projectSummary }</li>
	                            <li>by ${fundingProject.creator }</li>
	                        </ul>
	                        <div class="mt-10">
								<div class="percentage">
									<fmt:formatNumber type="number" var="progressPercent"
										value="${(fundingProject.fundingMoney / fundingProject.goalMoney)*100}"
										pattern=".00" />
									<fmt:formatNumber type="number" var="progress"
										maxFractionDigits="3" value="${fundingProject.fundingMoney}" />
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